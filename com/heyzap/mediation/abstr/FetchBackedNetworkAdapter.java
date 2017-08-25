package com.heyzap.mediation.abstr;

import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.PausableRunnable;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.FetchFailure;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.common.lifecycle.FetchResult.FetchStartedListener;
import com.heyzap.common.lifecycle.ImpressionOptions;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.Logger;
import com.heyzap.internal.RetryManager;
import com.heyzap.internal.RetryManager.ExponentialSchedule;
import com.heyzap.internal.RetryManager.RetryableTask;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.request.MediationRequest;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class FetchBackedNetworkAdapter extends NetworkAdapter {
    FetchStateMachineMap fetchStateMap = new FetchStateMachineMap();
    private final Object stateLock = new Object();

    private interface StateTransitionListener {
        void onStateTransition(FetchStateMachine fetchStateMachine, FetchState fetchState, FetchState fetchState2);
    }

    protected interface CachedAd {

        public interface ExpiryListener {
            void onExpired(boolean z);
        }

        void setExpiryListener(ExpiryListener expiryListener);

        AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions);
    }

    public class DisplayableFetchResult extends FetchResult {
        CachedAd cachedAd;

        public DisplayableFetchResult(CachedAd ad) {
            this.cachedAd = ad;
            this.success = true;
        }

        public DisplayableFetchResult(FetchFailure fetchFailure) {
            super(fetchFailure);
        }
    }

    private enum FetchState {
        init,
        fetching,
        failed,
        ready
    }

    private class FetchStateMachine {
        private CachedAd cachedAd;
        private FetchFailure fetchFailure;
        private SettableFuture<DisplayableFetchResult> fetchFuture;
        private final FetchOptions fetchOptions;
        private final FetchStateMachineMap parent;
        private FetchState state;
        private SettableFuture stateFinishedFuture;

        private FetchStateMachine(FetchStateMachineMap parent, FetchOptions fetchOptions) {
            this.state = FetchState.init;
            this.stateFinishedFuture = SettableFuture.create();
            this.fetchFuture = SettableFuture.create();
            this.parent = parent;
            this.fetchOptions = fetchOptions;
        }

        public void setFetching() {
            if (changeState(FetchState.fetching)) {
                this.fetchFuture = SettableFuture.create();
            }
        }

        public void setFailed(FetchFailure fetchFailure) {
            Logger.log(FetchBackedNetworkAdapter.this.getCanonicalName() + " - " + this.fetchOptions.getCreativeType() + " - setting failure", fetchFailure);
            this.fetchFailure = fetchFailure;
            changeState(FetchState.failed);
        }

        public void setReady(CachedAd cachedAd) {
            this.cachedAd = cachedAd;
            initExpiry();
            changeState(FetchState.ready);
        }

        private void initExpiry() {
            final CachedAd expiryCachedAd = this.cachedAd;
            expiryCachedAd.setExpiryListener(new ExpiryListener() {

                class C14131 implements Runnable {
                    C14131() {
                    }

                    public void run() {
                        FetchBackedNetworkAdapter.this.fetchWithRetries(FetchStateMachine.this, FetchStateMachine.this.fetchOptions);
                    }
                }

                public void onExpired(boolean refetchImmediately) {
                    if (FetchStateMachine.this.cachedAd == expiryCachedAd && FetchStateMachine.this.state == FetchState.ready) {
                        FetchStateMachine.this.setFetching();
                        if (refetchImmediately) {
                            FetchBackedNetworkAdapter.this.fetchWithRetries(FetchStateMachine.this, FetchStateMachine.this.fetchOptions);
                        } else {
                            FetchBackedNetworkAdapter.this.getFetchConsumer().consumeNext(FetchStateMachine.this.fetchOptions.getAdUnits().intersect(EnumSet.allOf(AdUnit.class)), new C14131(), FetchBackedNetworkAdapter.this.executorService);
                        }
                    }
                }
            });
        }

        private synchronized boolean changeState(FetchState newState) {
            boolean z = true;
            synchronized (this) {
                if (this.state != newState) {
                    FetchState oldState = this.state;
                    Logger.info(FetchBackedNetworkAdapter.this.getCanonicalName() + " - " + this.fetchOptions.getCreativeType() + " - switching state: " + oldState + " -> " + newState);
                    this.state = newState;
                    this.stateFinishedFuture.set(Boolean.valueOf(true));
                    this.stateFinishedFuture = SettableFuture.create();
                    this.parent.onStateTransition(this, oldState, newState);
                } else {
                    z = false;
                }
            }
            return z;
        }

        public SettableFuture<DisplayableFetchResult> getFetchFuture() {
            return this.fetchFuture;
        }

        public synchronized FetchState getState() {
            return this.state;
        }

        public synchronized CachedAd getCachedAd() {
            return this.cachedAd;
        }

        public synchronized SettableFuture getStateFinishedFuture() {
            return this.stateFinishedFuture;
        }

        public synchronized FetchFailure getFetchFailure() {
            return this.fetchFailure;
        }

        public FetchOptions getFetchOptions() {
            return this.fetchOptions;
        }
    }

    private class FetchStateMachineMap implements StateTransitionListener {
        final Map<FetchOptions, FetchStateMachine> machineMap;
        final List<StateTransitionListener> stateTransitionListenerList;

        private FetchStateMachineMap() {
            this.machineMap = new ConcurrentHashMap();
            this.stateTransitionListenerList = new ArrayList();
        }

        public FetchStateMachine findOrCreate(FetchOptions fetchOptions) {
            FetchStateMachine fetchStateMachine = (FetchStateMachine) this.machineMap.get(fetchOptions);
            if (fetchStateMachine != null) {
                return fetchStateMachine;
            }
            fetchStateMachine = new FetchStateMachine(this, fetchOptions);
            this.machineMap.put(fetchOptions, fetchStateMachine);
            return fetchStateMachine;
        }

        public FetchStateMachine get(FetchOptions fetchOptions) {
            return (FetchStateMachine) this.machineMap.get(fetchOptions);
        }

        public void onStateTransition(FetchStateMachine fetchStateMachine, FetchState from, FetchState to) {
            for (StateTransitionListener listener : this.stateTransitionListenerList) {
                listener.onStateTransition(fetchStateMachine, from, to);
            }
        }

        public void addStateTransitionListener(StateTransitionListener stateTransitionListener) {
            this.stateTransitionListenerList.add(stateTransitionListener);
        }

        public Map<FetchOptions, FetchStateMachine> toMap() {
            return this.machineMap;
        }
    }

    protected abstract SettableFuture<DisplayableFetchResult> fetch(FetchOptions fetchOptions);

    public FetchOptions canonizeFetch(FetchOptions fetchOptions) {
        return fetchOptions;
    }

    public SettableFuture<FetchResult> awaitAvailability(DisplayOptions displayOptions) {
        if (isCapable(displayOptions)) {
            FetchStateMachine bestFetch = null;
            for (Entry<FetchOptions, FetchStateMachine> entry : this.fetchStateMap.toMap().entrySet()) {
                if (fetchSupportsDisplay((FetchOptions) entry.getKey(), displayOptions)) {
                    if (bestFetch == null) {
                        bestFetch = (FetchStateMachine) entry.getValue();
                    } else if (((FetchStateMachine) entry.getValue()).getState() == FetchState.ready) {
                        bestFetch = (FetchStateMachine) entry.getValue();
                    } else if (((FetchStateMachine) entry.getValue()).getState() == FetchState.fetching && bestFetch.getState() == FetchState.failed) {
                        bestFetch = (FetchStateMachine) entry.getValue();
                    }
                }
            }
            final SettableFuture<FetchResult> resultFuture = SettableFuture.create();
            if (bestFetch == null || bestFetch.getState() != FetchState.fetching) {
                resultFuture.set(getCurrentFetchResult(bestFetch));
            } else {
                final FetchStateMachine finalBestFetch = bestFetch;
                bestFetch.getStateFinishedFuture().addListener(new Runnable() {
                    public void run() {
                        resultFuture.set(FetchBackedNetworkAdapter.this.getCurrentFetchResult(finalBestFetch));
                    }
                }, this.executorService);
            }
            return resultFuture;
        }
        SettableFuture<FetchResult> result = SettableFuture.create();
        result.set(new FetchResult(FetchFailureReason.SKIPPED, "Rejected by Segmentation"));
        return result;
    }

    private FetchResult getCurrentFetchResult(FetchStateMachine fetchStateMachine) {
        if (fetchStateMachine == null) {
            return new FetchResult(FetchFailureReason.CONFIGURATION_ERROR, "no valid fetch found");
        }
        if (fetchStateMachine.getState() == FetchState.fetching) {
            return new FetchResult(FetchFailureReason.TIMEOUT, "fetch not ready");
        }
        if (fetchStateMachine.getState() == FetchState.failed) {
            return new FetchResult(fetchStateMachine.getFetchFailure().getErrorType(), fetchStateMachine.getFetchFailure().getMessage());
        }
        if (fetchStateMachine.getState() == FetchState.ready) {
            return new FetchResult();
        }
        return new FetchResult(FetchFailureReason.UNKNOWN, "fetch not in any known state");
    }

    public SettableFuture<FetchResult> start(final FetchOptions fetchOptions) {
        final SettableFuture<FetchResult> onStartCompleted = SettableFuture.create();
        try {
            super.start(fetchOptions).addListener(new Runnable() {
                public void run() {
                    FutureUtils.bind(FetchBackedNetworkAdapter.this.start(fetchOptions, true), onStartCompleted, FetchBackedNetworkAdapter.this.executorService);
                }
            }, this.executorService);
        } catch (Exception e) {
            Logger.error("Could not start adapter for " + getMarketingName());
        }
        return onStartCompleted;
    }

    public SettableFuture start(FetchOptions fetchOptions, boolean cannonize) {
        FetchOptions canonFetchOptions;
        SettableFuture access$200;
        if (cannonize) {
            canonFetchOptions = canonizeFetch(fetchOptions);
        } else {
            canonFetchOptions = fetchOptions;
        }
        synchronized (this.stateLock) {
            FetchStateMachine fsm = this.fetchStateMap.findOrCreate(canonFetchOptions);
            if (fsm.getState() == FetchState.init) {
                fetchWithRetries(fsm, canonFetchOptions);
            }
            if (fsm.getState() == FetchState.fetching) {
                access$200 = fsm.stateFinishedFuture;
            } else {
                access$200 = SettableFuture.create();
                access$200.set(Boolean.valueOf(true));
            }
        }
        return access$200;
    }

    private void fetchWithRetries(final FetchStateMachine fsm, final FetchOptions fetchOptions) {
        fsm.setFetching();
        new RetryManager(new RetryableTask() {
            public void run() {
                FetchBackedNetworkAdapter.this.getFetchConsumer().consumeAny(fetchOptions.getAdUnits().intersect(EnumSet.allOf(AdUnit.class)), new PausableRunnable(FetchBackedNetworkAdapter.this.pauseSignal, FetchBackedNetworkAdapter.this.executorService) {
                    public void runWhenUnpaused() {
                        fsm.setFetching();
                        final SettableFuture<DisplayableFetchResult> resultFuture = FetchBackedNetworkAdapter.this.fetch(fetchOptions);
                        resultFuture.addListener(new Runnable() {
                            public void run() {
                                DisplayableFetchResult fetchResult = (DisplayableFetchResult) FutureUtils.getImmediatelyOrDefault(resultFuture, new DisplayableFetchResult(new FetchFailure(FetchFailureReason.NO_FILL, "Unknown error")));
                                if (fetchResult.success) {
                                    fsm.setReady(fetchResult.cachedAd);
                                    return;
                                }
                                fsm.setFailed(fetchResult.fetchFailure);
                                C14103.this.retry();
                            }
                        }, FetchBackedNetworkAdapter.this.executorService);
                    }
                }, FetchBackedNetworkAdapter.this.executorService);
            }
        }, new ExponentialSchedule(2.0d, 5, TimeUnit.SECONDS), this.executorService).start();
    }

    public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
        for (final Entry<FetchOptions, FetchStateMachine> entry : this.fetchStateMap.toMap().entrySet()) {
            if (fetchSupportsDisplay((FetchOptions) entry.getKey(), displayOptions) && ((FetchStateMachine) entry.getValue()).getState() == FetchState.ready) {
                AdDisplay adDisplay = ((FetchStateMachine) entry.getValue()).getCachedAd().show(mediationRequest, mediationResult, displayOptions);
                adDisplay.impressionOptions = generateImpressionOptions((FetchOptions) entry.getKey(), displayOptions);
                ((FetchStateMachine) entry.getValue()).setFetching();
                FutureUtils.wrapTimeout(adDisplay.impressionRegisteredListener, this.executorService, (long) adDisplay.getRefetchDelay(), TimeUnit.SECONDS).addListener(new Runnable() {
                    public void run() {
                        FetchBackedNetworkAdapter.this.fetchWithRetries((FetchStateMachine) entry.getValue(), (FetchOptions) entry.getKey());
                    }
                }, this.executorService);
                return adDisplay;
            }
        }
        AdDisplay failedDisplay = new AdDisplay();
        failedDisplay.displayEventStream.sendEvent(new DisplayResult("not ready", FetchFailureReason.UNKNOWN));
        return failedDisplay;
    }

    public CachedAd getCachedAd(DisplayOptions displayOptions) {
        for (Entry<FetchOptions, FetchStateMachine> entry : this.fetchStateMap.toMap().entrySet()) {
            if (fetchSupportsDisplay((FetchOptions) entry.getKey(), displayOptions) && ((FetchStateMachine) entry.getValue()).getState() == FetchState.ready) {
                return ((FetchStateMachine) entry.getValue()).getCachedAd();
            }
        }
        return null;
    }

    public boolean isReadyForFetch(FetchOptions fetchOptions) {
        return this.fetchStateMap.get(canonizeFetch(fetchOptions)) != null;
    }

    public FetchFailure getLastFetchFailure(DisplayOptions displayOptions) {
        for (Entry<FetchOptions, FetchStateMachine> entry : this.fetchStateMap.toMap().entrySet()) {
            if (fetchSupportsDisplay((FetchOptions) entry.getKey(), displayOptions)) {
                FetchFailure fetchFailure = ((FetchStateMachine) entry.getValue()).getFetchFailure();
                if (fetchFailure != null) {
                    return fetchFailure;
                }
            }
        }
        return null;
    }

    public void addFetchStartedListener(final FetchStartedListener fetchStartedListener, ExecutorService executorService) {
        this.fetchStateMap.addStateTransitionListener(new StateTransitionListener() {
            public void onStateTransition(FetchStateMachine fetchStateMachine, FetchState from, FetchState to) {
                if (from == FetchState.fetching) {
                    fetchStartedListener.onFetchStarted((AdUnit) fetchStateMachine.getFetchOptions().getAdUnits().getBackingSet().iterator().next(), fetchStateMachine.getFetchFuture());
                }
            }
        });
    }

    public boolean fetchSupportsDisplay(FetchOptions fetchOptions, DisplayOptions displayOptions) {
        return fetchOptions.getAdUnits().contains(displayOptions.getAdUnit()) && fetchOptions.getTags().contains(displayOptions.getTag()) && displayOptions.getCreativeTypes().contains(fetchOptions.getCreativeType()) && displayOptions.getNetworks().contains(fetchOptions.getNetwork());
    }

    public ImpressionOptions generateImpressionOptions(FetchOptions fetchOptions, DisplayOptions displayOptions) {
        return new ImpressionOptions(displayOptions.getAdUnit(), displayOptions.getTag(), getCanonicalName(), fetchOptions.getAuctionType(), fetchOptions.getCreativeType());
    }

    public Double getScoreOverride(DisplayOptions displayOptions) {
        return Double.valueOf(0.0d);
    }
}
