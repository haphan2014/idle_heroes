package com.heyzap.mediation.display;

import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.FutureUtils.FutureRunnable;
import com.heyzap.common.concurrency.ListenableFuture;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.DisplayOptions.Builder;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.LargeSet;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Provider;
import com.heyzap.internal.RetryManager;
import com.heyzap.internal.RetryManager.RetryableTask;
import com.heyzap.internal.RetryManager.StaticSchedule;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.MediationResult.NetworkResult;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.adapter.AdapterPool;
import com.heyzap.mediation.display.DisplayConfig.Network;
import com.heyzap.mediation.display.Mediator.NetworkWrapper;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.mediation.adapter.HeyzapExchangeAdapter;
import com.heyzap.sdk.segmentation.SegmentManager;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SerialMediator implements Mediator {
    private final AdapterPool adapterPool;
    private final DisplayConfigLoader displayConfigLoader;
    private final ScheduledExecutorService scheduledExecutorService;
    private final Provider<SegmentManager> segmentManager;

    public SerialMediator(AdapterPool adapterPool, DisplayConfigLoader displayConfigLoader, Provider<SegmentManager> segmentManager) {
        this(adapterPool, displayConfigLoader, ExecutorPool.getInstance(), segmentManager);
    }

    public SerialMediator(AdapterPool adapterPool, DisplayConfigLoader displayConfigLoader, ScheduledExecutorService scheduledExecutorService, Provider<SegmentManager> segmentManager) {
        this.adapterPool = adapterPool;
        this.displayConfigLoader = displayConfigLoader;
        this.scheduledExecutorService = scheduledExecutorService;
        this.segmentManager = segmentManager;
    }

    public ListenableFuture<MediationResult> mediate(final MediationRequest request) {
        final SettableFuture<MediationResult> mediationResultFuture = SettableFuture.create();
        final SettableFuture<DisplayConfig> displayConfigFuture = this.displayConfigLoader.consume();
        FutureUtils.addTimeout(displayConfigFuture, this.scheduledExecutorService, request.getRemainingTtl(), TimeUnit.MILLISECONDS);
        mediationResultFuture.addListener(new Runnable() {
            public void run() {
                displayConfigFuture.setException(new RuntimeException("display cancelled"));
            }
        }, this.scheduledExecutorService);
        displayConfigFuture.addListener(new FutureRunnable<DisplayConfig>(displayConfigFuture) {
            public void run(final DisplayConfig displayConfig, final Exception exception) {
                new RetryManager(new RetryableTask() {
                    public void run() {
                        if (exception != null) {
                            mediationResultFuture.setException(exception);
                            return;
                        }
                        DisplayOptions baseDisplayOptions = DisplayOptions.builder(request.getAdUnit()).setTag(request.getTag()).build();
                        MediationResult mediationResult = new MediationResult();
                        mediationResult.id = displayConfig.id;
                        int ordinal = 0;
                        for (Network networkConfig : displayConfig.networks) {
                            if ("heyzap_exchange".equals(networkConfig.network) && networkConfig.creativeType == CreativeType.BANNER) {
                                Logger.debug("SerialMediator - exchange pre-fetching starting");
                                SerialMediator.this.fetchForNetwork(networkConfig, baseDisplayOptions, request, mediationResult, 0, true);
                                Logger.debug("SerialMediator - exchange pre-fetching finished");
                            }
                        }
                        if (displayConfig.sortNetworksOnScore) {
                            Logger.debug("SerialMediator - sorting networks");
                            new NetworkSorter().sortNetworks(displayConfig.networks, SerialMediator.this.adapterPool, baseDisplayOptions);
                        }
                        for (Network networkConfig2 : displayConfig.networks) {
                            Logger.debug("SerialMediator - fetching network " + networkConfig2.network);
                            NetworkResult networkResult = SerialMediator.this.fetchForNetwork(networkConfig2, baseDisplayOptions, request, mediationResult, ordinal, false);
                            if (networkResult != null) {
                                mediationResult.networkResults.add(networkResult);
                                if (networkResult.fetchResult.success) {
                                    Logger.info("SerialMediator SUCCESSSSS! " + networkConfig2.network);
                                    mediationResult.selectedNetwork = networkResult;
                                    mediationResult.displayOptions = networkResult.displayOptions;
                                    mediationResultFuture.set(mediationResult);
                                    break;
                                }
                                ordinal++;
                            }
                        }
                        if (mediationResult.selectedNetwork != null) {
                            return;
                        }
                        if (request.isCancelled() || !retry()) {
                            mediationResultFuture.set(mediationResult);
                        }
                    }
                }, new StaticSchedule(20, TimeUnit.SECONDS, 10), SerialMediator.this.scheduledExecutorService).start();
            }
        }, this.scheduledExecutorService);
        return mediationResultFuture;
    }

    public NetworkResult fetchForNetwork(Network networkConfig, DisplayOptions baseDisplayOptions, MediationRequest request, MediationResult mediationResult, int ordinal, boolean prefetch) {
        Builder tag = DisplayOptions.builder(baseDisplayOptions.getAdUnit()).setTag(baseDisplayOptions.getTag());
        AuctionType[] auctionTypeArr = new AuctionType[1];
        auctionTypeArr[0] = networkConfig.network.endsWith("cross_promo") ? AuctionType.CROSS_PROMO : AuctionType.MONETIZATION;
        List<DisplayOptions> displayOptionsList = ((SegmentManager) this.segmentManager.get()).transform(tag.setAuctionTypes(LargeSet.of(auctionTypeArr)).setNetworks(baseDisplayOptions.getNetworks()).setCreativeTypes(LargeSet.of(networkConfig.creativeType)).build());
        if (displayOptionsList.isEmpty()) {
            return null;
        }
        DisplayOptions displayOptions = (DisplayOptions) displayOptionsList.get(0);
        NetworkAdapter adapter = this.adapterPool.get(networkConfig.network);
        if (adapter == null || !adapter.isCapable(displayOptions)) {
            return null;
        }
        if (request.getNetwork() != null && !request.getNetwork().equals(adapter.getCanonicalName())) {
            return null;
        }
        DisplayResult displayResult;
        Logger.info("SerialMediator fetching network " + networkConfig.network);
        FetchResult fetchResult = FetchResult.INTERNAL;
        NetworkWrapper networkWrapper = new NetworkWrapper(SettableFuture.create(), adapter, networkConfig, displayOptions);
        AdDisplay display = null;
        if (prefetch) {
            try {
                if (adapter instanceof HeyzapExchangeAdapter) {
                    Logger.debug("SerialMediator - calling adapter.prefetchBanner()");
                    display = ((HeyzapExchangeAdapter) adapter).prefetchBanner(request, mediationResult, displayOptions);
                    displayResult = (DisplayResult) display.displayEventStream.getFirstEventFuture().get(20, TimeUnit.SECONDS);
                    if (displayResult.success) {
                        fetchResult = new FetchResult(displayResult.errorCode, displayResult.errorMessage);
                    } else {
                        fetchResult = FetchResult.SUCCESS;
                        mediationResult.display = display;
                    }
                    if (!(fetchResult == FetchResult.SUCCESS || display == null || prefetch)) {
                        display.cancel();
                    }
                    return new NetworkResult(networkWrapper.networkConfig.id, networkWrapper.networkConfig.score, networkWrapper.networkAdapter, networkWrapper.networkConfig.network, fetchResult, ordinal, networkWrapper.networkConfig.creativeType, displayOptions);
                }
            } catch (InterruptedException e) {
                Logger.error("SerialMediator InterruptedException", e);
                fetchResult = FetchResult.INTERNAL;
            } catch (TimeoutException e2) {
                Logger.error("SerialMediator timeout for " + networkConfig.network);
                fetchResult = FetchResult.TIMEOUT;
            } catch (ExecutionException e3) {
                Logger.error("SerialMediator ExecutionException", e3);
                fetchResult = FetchResult.INTERNAL;
            }
        }
        Logger.debug("SerialMediator - calling adapter.show()");
        display = adapter.show(request, mediationResult, displayOptions);
        displayResult = (DisplayResult) display.displayEventStream.getFirstEventFuture().get(20, TimeUnit.SECONDS);
        if (displayResult.success) {
            fetchResult = new FetchResult(displayResult.errorCode, displayResult.errorMessage);
        } else {
            fetchResult = FetchResult.SUCCESS;
            mediationResult.display = display;
        }
        display.cancel();
        return new NetworkResult(networkWrapper.networkConfig.id, networkWrapper.networkConfig.score, networkWrapper.networkAdapter, networkWrapper.networkConfig.network, fetchResult, ordinal, networkWrapper.networkConfig.creativeType, displayOptions);
    }
}
