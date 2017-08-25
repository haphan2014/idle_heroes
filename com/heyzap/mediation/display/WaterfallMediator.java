package com.heyzap.mediation.display;

import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.FutureUtils.FutureRunnable;
import com.heyzap.common.concurrency.ListenableFuture;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.DisplayOptions.Builder;
import com.heyzap.common.lifecycle.FetchFailure;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.LargeSet;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Provider;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.MediationResult.NetworkResult;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.adapter.AdapterPool;
import com.heyzap.mediation.display.DisplayConfig.Network;
import com.heyzap.mediation.display.Mediator.NetworkWrapper;
import com.heyzap.mediation.filters.FilterManager;
import com.heyzap.mediation.filters.InterstitialVideoTracker;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.segmentation.SegmentManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WaterfallMediator implements Mediator {
    private final AdapterPool adapterPool;
    private final DisplayConfigLoader displayConfigLoader;
    private final InterstitialVideoTracker interstitialVideoTracker;
    private final ScheduledExecutorService scheduledExecutorService;
    private final Provider<SegmentManager> segmentManager;

    public WaterfallMediator(AdapterPool adapterPool, DisplayConfigLoader displayConfigLoader, ScheduledExecutorService scheduledExecutorService, FilterManager filterManager, InterstitialVideoTracker interstitialVideoTracker, Provider<SegmentManager> segmentManager) {
        this.adapterPool = adapterPool;
        this.displayConfigLoader = displayConfigLoader;
        this.scheduledExecutorService = scheduledExecutorService;
        this.interstitialVideoTracker = interstitialVideoTracker;
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
            public void run(DisplayConfig displayConfig, Exception exception) {
                if (exception != null) {
                    mediationResultFuture.setException(exception);
                    return;
                }
                Collection creativeTypes = request.getAdUnit().creativeTypes();
                if (request.getAdUnit() == AdUnit.INTERSTITIAL && !(WaterfallMediator.this.interstitialVideoTracker.interstitialCooldownExpired(displayConfig.interstitialVideoInterval) && displayConfig.interstitialVideoEnabled)) {
                    creativeTypes.remove(CreativeType.VIDEO);
                }
                DisplayOptions baseDisplayOptions = DisplayOptions.builder(request.getAdUnit()).setTag(request.getTag()).setCreativeTypes(new LargeSet(creativeTypes)).build();
                request.setTimeoutMilli(displayConfig.displayTtl);
                if (request.isTimedOut().booleanValue()) {
                    MediationResult timedOutResult = new MediationResult();
                    timedOutResult.setError("Display timed out");
                    mediationResultFuture.set(timedOutResult);
                    return;
                }
                List<ListenableFuture> availabilityWaiters = new ArrayList();
                final List<NetworkWrapper> pendingNetworks = new ArrayList();
                if (displayConfig.sortNetworksOnScore) {
                    new NetworkSorter().sortNetworks(displayConfig.networks, WaterfallMediator.this.adapterPool, baseDisplayOptions);
                }
                for (Network networkConfig : displayConfig.networks) {
                    Builder creativeTypes2 = DisplayOptions.builder(baseDisplayOptions.getAdUnit()).setTag(baseDisplayOptions.getTag()).setNetworks(baseDisplayOptions.getNetworks()).setCreativeTypes(LargeSet.of(networkConfig.creativeType));
                    AuctionType[] auctionTypeArr = new AuctionType[1];
                    auctionTypeArr[0] = networkConfig.network.endsWith("cross_promo") ? AuctionType.CROSS_PROMO : AuctionType.MONETIZATION;
                    List<DisplayOptions> displayOptionsList = ((SegmentManager) WaterfallMediator.this.segmentManager.get()).transform(creativeTypes2.setAuctionTypes(LargeSet.of(auctionTypeArr)).build());
                    if (displayOptionsList.size() > 0) {
                        DisplayOptions entryDisplayOptions = (DisplayOptions) displayOptionsList.get(0);
                        NetworkAdapter adapter = WaterfallMediator.this.adapterPool.get(networkConfig.network);
                        if (baseDisplayOptions.getCreativeTypes().contains(networkConfig.creativeType)) {
                            if (request.getNetwork() != null) {
                                if (!request.getNetwork().equals(adapter.getCanonicalName())) {
                                    continue;
                                }
                            }
                            NetworkWrapper networkWrapper;
                            if (adapter == null) {
                                networkWrapper = new NetworkWrapper(SettableFuture.create(), adapter, networkConfig, entryDisplayOptions);
                                networkWrapper.setRejected("Network not on board.");
                                pendingNetworks.add(networkWrapper);
                            } else if (adapter.isCapable(entryDisplayOptions)) {
                                SettableFuture<FetchResult> availabilityWaiter = adapter.awaitAvailability(entryDisplayOptions);
                                pendingNetworks.add(new NetworkWrapper(availabilityWaiter, adapter, networkConfig, entryDisplayOptions));
                                availabilityWaiters.add(availabilityWaiter);
                                if (availabilityWaiter.isDone()) {
                                    try {
                                        if (((FetchResult) availabilityWaiter.get()).success) {
                                            mediationResultFuture.set(WaterfallMediator.this.reapPending(displayConfig, pendingNetworks));
                                            return;
                                        }
                                    } catch (Throwable e) {
                                        Logger.trace(e);
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                networkWrapper = new NetworkWrapper(SettableFuture.create(), adapter, networkConfig, entryDisplayOptions);
                                networkWrapper.setRejected("Network not capable of ad unit");
                                pendingNetworks.add(networkWrapper);
                            }
                        } else {
                            continue;
                        }
                    }
                }
                final SettableFuture<Boolean> reapTimeoutFuture = SettableFuture.create();
                for (NetworkWrapper wrapper : pendingNetworks) {
                    final NetworkWrapper networkWrapper2 = wrapper;
                    wrapper.fetchResultFuture.addListener(new FutureRunnable<FetchResult>(wrapper.fetchResultFuture) {
                        public void run(FetchResult result, Exception exception) {
                            if (!networkWrapper2.rejected && (result == null || !result.success)) {
                                if (result != null) {
                                    networkWrapper2.setRejected(result.getFetchFailure().getMessage());
                                } else if (exception != null) {
                                    networkWrapper2.setRejected(exception.getMessage());
                                }
                            }
                            Logger.info(String.format("Reaping %s for %s", new Object[]{networkWrapper2.networkAdapter.getMarketingName(), networkWrapper2.getRejectionCause()}));
                            if (result != null && result.success) {
                                reapTimeoutFuture.set(Boolean.valueOf(true));
                            }
                        }
                    }, WaterfallMediator.this.scheduledExecutorService);
                }
                final DisplayConfig displayConfig2 = displayConfig;
                FutureUtils.wrapTimeout(reapTimeoutFuture, WaterfallMediator.this.scheduledExecutorService, request.getRemainingTtl(), TimeUnit.MILLISECONDS).addListener(new Runnable() {
                    public void run() {
                        mediationResultFuture.set(WaterfallMediator.this.reapPending(displayConfig2, pendingNetworks));
                    }
                }, WaterfallMediator.this.scheduledExecutorService);
            }
        }, this.scheduledExecutorService);
        return mediationResultFuture;
    }

    private MediationResult reapPending(DisplayConfig config, List<NetworkWrapper> pendingNetworks) {
        MediationResult result = new MediationResult();
        result.id = config.id;
        int ordinal = 0;
        for (NetworkWrapper wrapper : pendingNetworks) {
            FetchResult fetchResult;
            if (wrapper.rejected) {
                fetchResult = new FetchResult(FetchFailureReason.SKIPPED, wrapper.rejectionCause);
            } else if (wrapper.fetchResultFuture.isDone()) {
                try {
                    fetchResult = (FetchResult) wrapper.fetchResultFuture.get();
                } catch (Exception e) {
                    fetchResult = new FetchResult(FetchFailureReason.UNKNOWN, e.getMessage());
                }
            } else {
                FetchFailure fetchFailure = wrapper.networkAdapter.getLastFetchFailure(wrapper.displayOptions);
                if (fetchFailure == null) {
                    fetchFailure = new FetchFailure(FetchFailureReason.TIMEOUT, "Display timed out");
                }
                fetchResult = new FetchResult(fetchFailure);
            }
            NetworkResult networkResult = new NetworkResult(wrapper.networkConfig.id, wrapper.networkConfig.score, wrapper.networkAdapter, wrapper.networkConfig.network, fetchResult, ordinal, wrapper.networkConfig.creativeType, wrapper.displayOptions);
            result.networkResults.add(networkResult);
            if (fetchResult.success) {
                result.selectedNetwork = networkResult;
                result.displayOptions = wrapper.displayOptions;
                break;
            }
            ordinal++;
        }
        return result;
    }
}
