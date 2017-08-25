package com.heyzap.mediation.display;

import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.FutureUtils.FutureRunnable;
import com.heyzap.common.concurrency.ListenableFuture;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.LargeSet;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Provider;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.MediationResult.NetworkResult;
import com.heyzap.mediation.abstr.NativeNetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.adapter.AdapterPool;
import com.heyzap.mediation.display.DisplayConfig.Network;
import com.heyzap.mediation.display.Mediator.NetworkWrapper;
import com.heyzap.mediation.filters.FilterManager;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.segmentation.SegmentManager;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class NativeMediator implements Mediator {
    private static int PER_NETWORK_TIMEOUT = 10;
    private final AdapterPool adapterPool;
    private final DisplayConfigLoader displayConfigLoader;
    private final FilterManager filterManager;
    private final ScheduledExecutorService scheduledExecutorService;
    private final Provider<SegmentManager> segmentManager;

    public NativeMediator(AdapterPool adapterPool, DisplayConfigLoader displayConfigLoader, FilterManager filterManager, Provider<SegmentManager> segmentManager) {
        this(adapterPool, displayConfigLoader, ExecutorPool.getInstance(), filterManager, segmentManager);
    }

    public NativeMediator(AdapterPool adapterPool, DisplayConfigLoader displayConfigLoader, ScheduledExecutorService scheduledExecutorService, FilterManager filterManager, Provider<SegmentManager> segmentManager) {
        this.adapterPool = adapterPool;
        this.displayConfigLoader = displayConfigLoader;
        this.scheduledExecutorService = scheduledExecutorService;
        this.filterManager = filterManager;
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
                FetchResult fetchResult;
                Throwable th;
                if (exception != null) {
                    mediationResultFuture.setException(exception);
                    return;
                }
                DisplayOptions baseDisplayOptions = DisplayOptions.builder(request.getAdUnit()).setTag(request.getTag()).build();
                MediationResult mediationResult = new MediationResult();
                mediationResult.id = displayConfig.id;
                int ordinal = 0;
                boolean fetchedSuccessfully = false;
                NetworkResult latestNetworkResult = null;
                for (Network networkConfig : displayConfig.networks) {
                    DisplayOptions entryDisplayOptions;
                    FetchResult fetchResult2;
                    NetworkWrapper networkWrapper;
                    NetworkAdapter adapter = NativeMediator.this.adapterPool.get(networkConfig.network);
                    if (adapter != null) {
                        entryDisplayOptions = DisplayOptions.builder(baseDisplayOptions.getAdUnit()).setTag(baseDisplayOptions.getTag()).setNetworks(baseDisplayOptions.getNetworks()).setCreativeTypes(LargeSet.of(networkConfig.creativeType)).build();
                        boolean fetchedThisNetwork = false;
                        for (DisplayOptions displayOptions : ((SegmentManager) NativeMediator.this.segmentManager.get()).transform(entryDisplayOptions)) {
                            if (fetchedThisNetwork) {
                                break;
                            } else if (adapter.isCapable(displayOptions) && (request.getNetwork() == null || request.getNetwork().equals(adapter.getCanonicalName()))) {
                                fetchedThisNetwork = true;
                                fetchResult2 = null;
                                networkWrapper = new NetworkWrapper(SettableFuture.create(), adapter, networkConfig, entryDisplayOptions);
                                boolean success = false;
                                try {
                                    Logger.debug("Attempting to Fetch Native Ad from: " + networkConfig.network);
                                    fetchResult2 = (FetchResult) ((NativeNetworkAdapter) adapter).fetchNative(((SegmentManager) NativeMediator.this.segmentManager.get()).transform(FetchOptions.builder(adapter.getCanonicalName(), CreativeType.NATIVE, adapter.getAuctionType()).setTags(LargeSet.of(displayOptions.getTag())).setAdUnit(LargeSet.of(AdUnit.NATIVE)).setNativeAdOptions(request.getNativeAdOptions()).build())).fetchListener.get((long) NativeMediator.PER_NETWORK_TIMEOUT, TimeUnit.SECONDS);
                                    if (fetchResult2.success) {
                                        Logger.debug("bbb NativeMediator fetchResult success: " + networkConfig.network);
                                        success = true;
                                    } else {
                                        Logger.debug("bbb NativeMediator fetchFailure: " + fetchResult2.getFetchFailure().getMessage());
                                    }
                                    latestNetworkResult = new NetworkResult(networkWrapper.networkConfig.id, networkWrapper.networkConfig.score, networkWrapper.networkAdapter, networkWrapper.networkConfig.network, fetchResult2, ordinal, networkWrapper.networkConfig.creativeType, entryDisplayOptions);
                                    mediationResult.networkResults.add(latestNetworkResult);
                                } catch (InterruptedException e) {
                                    fetchResult = fetchResult2;
                                    Logger.log("bbb NativeMediator InterruptedException", e);
                                    latestNetworkResult = new NetworkResult(networkWrapper.networkConfig.id, networkWrapper.networkConfig.score, networkWrapper.networkAdapter, networkWrapper.networkConfig.network, new FetchResult(FetchFailureReason.INTERNAL, "exception"), ordinal, networkWrapper.networkConfig.creativeType, entryDisplayOptions);
                                    mediationResult.networkResults.add(latestNetworkResult);
                                } catch (TimeoutException e2) {
                                    fetchResult = fetchResult2;
                                    Logger.log("bbb NativeMediator timeout", networkConfig.network);
                                    latestNetworkResult = new NetworkResult(networkWrapper.networkConfig.id, networkWrapper.networkConfig.score, networkWrapper.networkAdapter, networkWrapper.networkConfig.network, new FetchResult(FetchFailureReason.TIMEOUT, "timed out"), ordinal, networkWrapper.networkConfig.creativeType, entryDisplayOptions);
                                    mediationResult.networkResults.add(latestNetworkResult);
                                } catch (ExecutionException e3) {
                                    fetchResult = fetchResult2;
                                    Logger.log("bbb NativeMediator ExecutionException", e3);
                                    latestNetworkResult = new NetworkResult(networkWrapper.networkConfig.id, networkWrapper.networkConfig.score, networkWrapper.networkAdapter, networkWrapper.networkConfig.network, new FetchResult(FetchFailureReason.INTERNAL, "exception"), ordinal, networkWrapper.networkConfig.creativeType, entryDisplayOptions);
                                    mediationResult.networkResults.add(latestNetworkResult);
                                } catch (Throwable th2) {
                                    th = th2;
                                    fetchResult2 = fetchResult;
                                }
                                if (success) {
                                    Logger.log("bbb NativeMediator SUCCESS!", networkConfig.network);
                                    fetchedSuccessfully = true;
                                    mediationResult.selectedNetwork = latestNetworkResult;
                                    mediationResult.displayOptions = entryDisplayOptions;
                                    break;
                                }
                                ordinal++;
                            }
                        }
                        if (fetchedSuccessfully) {
                            break;
                        }
                    }
                }
                if (!fetchedSuccessfully) {
                    if (latestNetworkResult != null) {
                        mediationResult.selectedNetwork = latestNetworkResult;
                    } else {
                        mediationResult.setError("No Valid Networks for Mediation Request");
                    }
                }
                mediationResultFuture.set(mediationResult);
                return;
                mediationResult.networkResults.add(new NetworkResult(networkWrapper.networkConfig.id, networkWrapper.networkConfig.score, networkWrapper.networkAdapter, networkWrapper.networkConfig.network, fetchResult2, ordinal, networkWrapper.networkConfig.creativeType, entryDisplayOptions));
                throw th;
            }
        }, this.scheduledExecutorService);
        return mediationResultFuture;
    }
}
