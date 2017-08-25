package com.heyzap.mediation.handler;

import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.FutureUtils.FutureRunnable;
import com.heyzap.common.concurrency.ListenableFuture;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Logger;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.adapter.AdapterPool;
import com.heyzap.mediation.config.MediationConfig;
import com.heyzap.mediation.filters.FilterContext;
import com.heyzap.sdk.ads.HeyzapAds.OnIncentiveResultListener;
import com.heyzap.sdk.ads.HeyzapAds.OnStatusListener;
import com.heyzap.sdk.segmentation.SegmentManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class StatusListenerMultiplexer {
    private final ScheduledExecutorService executorService;
    private List<OnIncentiveResultListener> incentiveListeners = Collections.synchronizedList(new ArrayList());
    private List<OnStatusListener> statusListeners = Collections.synchronizedList(new ArrayList());
    public boolean usesAudio = false;

    public StatusListenerMultiplexer(ScheduledExecutorService executorService) {
        this.executorService = executorService;
    }

    public void setUsesAudio(boolean usesAudio) {
        this.usesAudio = usesAudio;
    }

    public void setListener(OnStatusListener listener) {
        List<OnStatusListener> newStatusListeners = Collections.synchronizedList(new ArrayList());
        newStatusListeners.add(listener);
        this.statusListeners = newStatusListeners;
    }

    public void setIncentiveListener(OnIncentiveResultListener listener) {
        List<OnIncentiveResultListener> newStatusListeners = Collections.synchronizedList(new ArrayList());
        newStatusListeners.add(listener);
        this.incentiveListeners = newStatusListeners;
    }

    public void sendDisplayFailed(String tag) {
        for (OnStatusListener listener : this.statusListeners) {
            listener.onFailedToShow(tag);
        }
    }

    public void addDisplay(final AdDisplay display, final String tag) {
        display.displayEventStream.getFirstEventFuture().addListener(new Runnable() {
            public void run() {
                boolean displaySuccess = false;
                try {
                    displaySuccess = ((DisplayResult) display.displayEventStream.getFirstEventFuture().get()).success;
                } catch (Throwable e) {
                    Logger.trace(e);
                } catch (Throwable e2) {
                    Logger.trace(e2);
                }
                for (OnStatusListener listener : StatusListenerMultiplexer.this.statusListeners) {
                    if (displaySuccess) {
                        listener.onShow(tag);
                        if (StatusListenerMultiplexer.this.usesAudio) {
                            listener.onAudioStarted();
                        }
                    } else {
                        listener.onFailedToShow(tag);
                    }
                }
            }
        }, this.executorService);
        display.closeListener.addListener(new Runnable() {
            public void run() {
                for (OnStatusListener listener : StatusListenerMultiplexer.this.statusListeners) {
                    listener.onHide(tag);
                    if (StatusListenerMultiplexer.this.usesAudio) {
                        listener.onAudioFinished();
                    }
                }
            }
        }, this.executorService);
        display.clickEventStream.getFirstEventFuture().addListener(new Runnable() {
            public void run() {
                for (OnStatusListener listener : StatusListenerMultiplexer.this.statusListeners) {
                    listener.onClick(tag);
                }
            }
        }, this.executorService);
        display.incentiveListener.addListener(new Runnable() {
            public void run() {
                boolean success = ((Boolean) FutureUtils.getImmediatelyOrDefault(display.incentiveListener, Boolean.valueOf(false))).booleanValue();
                for (OnIncentiveResultListener listener : StatusListenerMultiplexer.this.incentiveListeners) {
                    if (success) {
                        listener.onComplete(tag);
                    } else {
                        listener.onIncomplete(tag);
                    }
                }
            }
        }, this.executorService);
    }

    public void addFetch(AdUnit adUnit, final String tag, ListenableFuture<MediationConfig> configFuture) {
        final SettableFuture<Boolean> fetchSuccessFuture = FutureUtils.wrapTimeout(SettableFuture.create(), this.executorService, 30, TimeUnit.SECONDS);
        final DisplayOptions displayOptions = DisplayOptions.builder(adUnit).setTag(tag).build();
        final AdUnit adUnit2 = adUnit;
        final String str = tag;
        configFuture.addListener(new FutureRunnable<MediationConfig>(configFuture) {
            public void run(MediationConfig config, Exception exception) {
                if (config == null || !config.getFilterManager().accept(new FilterContext(adUnit2, str))) {
                    fetchSuccessFuture.set(Boolean.valueOf(false));
                    return;
                }
                AdapterPool adapterPool = config.getAdapterPool();
                List<DisplayOptions> optionsList = ((SegmentManager) config.getSegmentManager().get()).transform(displayOptions);
                final int poolSize = adapterPool.getAll().size();
                final AtomicInteger failureCount = new AtomicInteger(0);
                for (DisplayOptions options : optionsList) {
                    for (NetworkAdapter adapter : adapterPool.getAll()) {
                        if (adapter.isCapable(options)) {
                            SettableFuture<FetchResult> fetchResultFuture = adapter.awaitAvailability(options);
                            fetchResultFuture.addListener(new FutureRunnable<FetchResult>(fetchResultFuture) {
                                public void run(FetchResult result, Exception exception) {
                                    if (result != null && result.success) {
                                        fetchSuccessFuture.set(Boolean.valueOf(true));
                                    } else if (failureCount.incrementAndGet() >= poolSize) {
                                        fetchSuccessFuture.set(Boolean.valueOf(false));
                                    }
                                }
                            }, StatusListenerMultiplexer.this.executorService);
                        }
                    }
                }
            }
        }, this.executorService);
        fetchSuccessFuture.addListener(new Runnable() {
            public void run() {
                boolean success = false;
                try {
                    success = ((Boolean) fetchSuccessFuture.get()).booleanValue();
                } catch (InterruptedException e) {
                } catch (ExecutionException e2) {
                }
                for (OnStatusListener statusListener : StatusListenerMultiplexer.this.statusListeners) {
                    if (success) {
                        statusListener.onAvailable(tag);
                    } else {
                        statusListener.onFailedToFetch(tag);
                    }
                }
            }
        }, this.executorService);
    }
}
