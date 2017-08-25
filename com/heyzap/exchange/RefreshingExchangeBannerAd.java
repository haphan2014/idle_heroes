package com.heyzap.exchange;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.heyzap.common.banner.BannerWrapper;
import com.heyzap.common.banner.BannerWrapper.OnSizeChangeListener;
import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.EventStream;
import com.heyzap.exchange.ExchangeClient.ExchangeFetch;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.Logger;
import com.heyzap.sdk.ads.HeyzapAds.BannerOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class RefreshingExchangeBannerAd extends ExchangeAd implements BannerWrapper {
    private MRAIDExchangeAd activeBannerAd = null;
    private ExchangeFetch activeFetch = null;
    private boolean bannerIsActive = false;
    private BannerOptions bannerOptions;
    private int bannerOrdinal = 0;
    private int bannerRefreshAttempt = 0;
    private final long bannerRefreshInterval;
    private ScheduledFuture<?> bannerRefreshTimer = null;
    private final BannerWrapperFrame bannerWrapperView;
    private HashMap<String, String> clientParams;
    private final ContextReference contextRef;
    private final boolean coppaEnabled;
    private final String exchangeUrl;
    private final ScheduledExecutorService executorService;
    AtomicBoolean firstRefreshScheduled = new AtomicBoolean(false);
    private boolean isDestroyed = false;
    private final ExchangeEventReporter reporter;
    private OnSizeChangeListener sizeChangeListener;
    private final ExecutorService uiThreadExecutorService;
    private AtomicBoolean unloaded = new AtomicBoolean(true);
    protected int visibility = 0;

    class C13266 implements Runnable {
        C13266() {
        }

        public void run() {
            RefreshingExchangeBannerAd.this.destroyBanner(true);
        }
    }

    class C13287 implements Runnable {
        C13287() {
        }

        public void run() {
            String delayCause = (RefreshingExchangeBannerAd.this.activeBannerAd.isExpanded() ? "banner expanded, " : "") + (RefreshingExchangeBannerAd.this.contextRef.getForegroundActivity() == null ? "app in background, " : "") + (!RefreshingExchangeBannerAd.this.bannerWrapperView.attached ? "banner detached, " : "") + (RefreshingExchangeBannerAd.this.visibility != 0 ? "banner not visibile, " : "");
            if (delayCause.isEmpty()) {
                RefreshingExchangeBannerAd.this.bannerOrdinal = RefreshingExchangeBannerAd.this.bannerOrdinal + 1;
                RefreshingExchangeBannerAd.this.activeFetch = null;
                Logger.debug("RefreshingExchangeBannerAd - banner refresh interval hit, refreshing");
                final SettableFuture<ExchangeAd> fetchResultFuture = RefreshingExchangeBannerAd.this.ensureFetchStarted().adLoadedFuture;
                fetchResultFuture.addListener(new Runnable() {
                    public void run() {
                        ExchangeAd ad = (ExchangeAd) FutureUtils.getImmediatelyOrDefault(fetchResultFuture, null);
                        Logger.debug("RefreshingExchangeBannerAd - refresh got new banner: " + ad);
                        if (ad != null && (ad instanceof MRAIDExchangeAd)) {
                            RefreshingExchangeBannerAd.this.bindAd((MRAIDExchangeAd) ad);
                        }
                        RefreshingExchangeBannerAd.this.scheduleNextRefresh();
                    }
                }, RefreshingExchangeBannerAd.this.executorService);
                return;
            }
            Logger.debug("RefreshingExchangeBannerAd - " + delayCause + "waiting for next refresh interval");
            RefreshingExchangeBannerAd.this.scheduleNextRefresh();
        }
    }

    private class BannerWrapperFrame extends FrameLayout {
        public boolean attached = false;

        public BannerWrapperFrame(Context context) {
            super(context);
        }

        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            Logger.debug("RefreshingExchangeBannerAd - onDetachedFromWindow");
            this.attached = true;
            RefreshingExchangeBannerAd.this.fireActiveBannerDisplay();
        }

        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.attached = false;
            Logger.debug("RefreshingExchangeBannerAd - onDetachedFromWindow");
        }

        public void onVisibilityChanged(View view, int visibility) {
            super.onVisibilityChanged(view, visibility);
            RefreshingExchangeBannerAd.this.visibility = visibility;
            Logger.debug("RefreshingExchangeBannerAd - onVisibilityChanged: " + visibility);
        }
    }

    public int getAdHeight() {
        return this.activeBannerAd.getAdHeight();
    }

    public int getAdWidth() {
        return this.activeBannerAd.getAdWidth();
    }

    public RefreshingExchangeBannerAd(ContextReference contextRef, ExchangeEventReporter reporter, String exchangeUrl, ScheduledExecutorService executorService, ExecutorService uiThreadExecutorService, boolean coppaEnabled, long bannerRefreshInterval) {
        super(contextRef);
        this.contextRef = contextRef;
        this.reporter = reporter;
        this.exchangeUrl = exchangeUrl;
        this.executorService = executorService;
        this.uiThreadExecutorService = uiThreadExecutorService;
        this.coppaEnabled = coppaEnabled;
        this.bannerWrapperView = new BannerWrapperFrame(contextRef.getActivity());
        this.bannerRefreshInterval = 20;
    }

    public AdDisplay preload() {
        final AdDisplay retDisplay = new AdDisplay();
        final ExchangeFetch thisFetch = ensureFetchStarted();
        thisFetch.adFetchedFuture.addListener(new Runnable() {
            public void run() {
                ExchangeAd ad = (ExchangeAd) FutureUtils.getImmediatelyOrDefault(thisFetch.adFetchedFuture, null);
                if (ad != null) {
                    RefreshingExchangeBannerAd.this.score = ad.score;
                    RefreshingExchangeBannerAd.this.expiry = ad.expiry;
                    DisplayResult displayResult = new DisplayResult();
                    displayResult.bannerWrapper = RefreshingExchangeBannerAd.this;
                    retDisplay.displayEventStream.sendEvent(displayResult);
                }
            }
        }, this.executorService);
        return retDisplay;
    }

    public void load() {
        if (this.unloaded.compareAndSet(true, false)) {
            final ExchangeFetch thisFetch = ensureFetchStarted();
            thisFetch.adLoadedFuture.addListener(new Runnable() {
                public void run() {
                    try {
                        ExchangeAd ad = (ExchangeAd) thisFetch.adLoadedFuture.get();
                        if (ad == null || !(ad instanceof MRAIDExchangeAd)) {
                            RefreshingExchangeBannerAd.this.displayEventStream.sendEvent(new DisplayResult("Invalid ad format for banner: " + ad, FetchFailureReason.UNKNOWN));
                            RefreshingExchangeBannerAd.this.activeFetch = null;
                        }
                        RefreshingExchangeBannerAd.this.bindAd((MRAIDExchangeAd) ad);
                        RefreshingExchangeBannerAd.this.scheduleFirestRefresh();
                        RefreshingExchangeBannerAd.this.activeFetch = null;
                    } catch (InterruptedException e) {
                        RefreshingExchangeBannerAd.this.displayEventStream.sendEvent(new DisplayResult("interrupted", FetchFailureReason.UNKNOWN));
                    } catch (ExecutionException e2) {
                        RefreshingExchangeBannerAd.this.displayEventStream.sendEvent(new DisplayResult(e2.getMessage(), FetchFailureReason.UNKNOWN));
                    }
                }
            }, this.executorService);
        }
    }

    public void onShowRequest(HashMap<String, String> clientParams) {
        this.bannerIsActive = true;
        this.clientParams = clientParams;
        bindDisplayReport(this.activeBannerAd, clientParams);
        fireActiveBannerDisplay();
        scheduleFirestRefresh();
    }

    private void scheduleFirestRefresh() {
        if (this.bannerIsActive && this.activeBannerAd != null && this.firstRefreshScheduled.compareAndSet(false, true)) {
            scheduleNextRefresh();
        }
    }

    private void fireActiveBannerDisplay() {
        MRAIDExchangeAd localBannerAd = this.activeBannerAd;
        if (localBannerAd != null && this.bannerIsActive && this.bannerWrapperView.getParent() != null && !localBannerAd.displayEventStream.getFirstEventFuture().isDone()) {
            localBannerAd.displayEventStream.sendEvent(new DisplayResult());
        }
    }

    public synchronized ExchangeFetch ensureFetchStarted() {
        ExchangeFetch thisFetch;
        thisFetch = this.activeFetch;
        Logger.debug("RefreshingExchangeBannerAd - ensureFetchStarted - activeFetch: " + this.activeFetch);
        if (thisFetch == null) {
            thisFetch = ExchangeClient.fetch(this.contextRef, this.reporter, CreativeType.BANNER, this.exchangeUrl, this.bannerOptions, this.bannerOrdinal, this.bannerRefreshAttempt, this.coppaEnabled, this.executorService, this.uiThreadExecutorService);
            this.activeFetch = thisFetch;
            final ExchangeFetch finalFetch = thisFetch;
            thisFetch.adLoadedFuture.addListener(new Runnable() {
                public void run() {
                    if (((ExchangeAd) FutureUtils.getImmediatelyOrDefault(finalFetch.adLoadedFuture, null)) == null) {
                        RefreshingExchangeBannerAd.this.activeFetch = null;
                    }
                }
            }, this.executorService);
        }
        return thisFetch;
    }

    private void bindDisplayReport(ExchangeAd ad, Map<String, String> clientParams) {
        if (ad != null && clientParams != null) {
            this.reporter.bindDisplay(ad, clientParams);
        }
    }

    private synchronized void bindAd(final MRAIDExchangeAd ad) {
        Logger.debug("RefreshingExchangeBannerAd - bindAd ");
        if (this.isDestroyed) {
            Logger.debug("RefreshingExchangeBannerAd - bindAd - is destroyed, destroying new banner");
            this.uiThreadExecutorService.execute(new Runnable() {
                public void run() {
                    ad.destroyBanner(true);
                }
            });
        } else {
            EventStream.bind(ad.clickEventStream, this.clickEventStream, this.executorService);
            this.score = ad.score;
            this.expiry = ad.expiry;
            this.refetchOnExpiry = ad.refetchOnExpiry;
            this.url = ad.getUrl();
            this.adId = ad.getAdId();
            final MRAIDExchangeAd bannerToDestroy = this.activeBannerAd;
            this.activeBannerAd = ad;
            DisplayResult displayResult = new DisplayResult();
            displayResult.bannerWrapper = this;
            this.displayEventStream.sendEvent(displayResult);
            bindDisplayReport(ad, this.clientParams);
            fireActiveBannerDisplay();
            if (this.sizeChangeListener != null) {
                this.sizeChangeListener.onSizeChange(ad.getAdWidth(), ad.getAdHeight());
            }
            this.uiThreadExecutorService.execute(new Runnable() {
                public void run() {
                    View bannerView = ad.getRealBannerView();
                    RefreshingExchangeBannerAd.this.bannerWrapperView.removeAllViews();
                    RefreshingExchangeBannerAd.this.bannerWrapperView.addView(bannerView);
                    if (bannerToDestroy != null) {
                        bannerToDestroy.destroyBanner(true);
                    }
                }
            });
        }
    }

    public ExchangeRequestParams getRequestParams() {
        if (this.activeBannerAd != null) {
            return this.activeBannerAd.getRequestParams();
        }
        return ExchangeRequestParams.create(this.contextRef.getApp());
    }

    public void show(Activity activity) {
    }

    public void setBannerOptions(BannerOptions bannerOptions) {
        this.bannerOptions = bannerOptions;
    }

    public boolean onBackPressed() {
        return false;
    }

    public View getRealBannerView() {
        return this.bannerWrapperView;
    }

    public void cancel() {
        this.uiThreadExecutorService.execute(new C13266());
    }

    public synchronized boolean destroyBanner(boolean permaDeath) {
        Logger.debug("RefreshingExchangeBannerAd - destroyBanner permadeath");
        if (this.bannerRefreshTimer != null) {
            this.bannerRefreshTimer.cancel(false);
        }
        this.bannerIsActive = false;
        this.isDestroyed = true;
        this.activeBannerAd = null;
        this.bannerOrdinal = 0;
        this.bannerRefreshAttempt = 0;
        if (this.activeBannerAd != null) {
            this.activeBannerAd.destroyBanner(permaDeath);
        }
        return false;
    }

    public void setSizeChangeListener(OnSizeChangeListener onSizeChangeListener) {
        this.sizeChangeListener = onSizeChangeListener;
    }

    public void scheduleNextRefresh() {
        try {
            Logger.debug("RefreshingExchangeBannerAd - starting banner refresh timer");
            if (this.bannerRefreshTimer != null) {
                this.bannerRefreshTimer.cancel(false);
            }
            if (this.bannerRefreshInterval <= 0 || !this.bannerIsActive || this.activeBannerAd == null) {
                Logger.debug("RefreshingExchangeBannerAd - canceling refreshes - interval: " + this.bannerRefreshInterval + ", active: " + this.bannerIsActive + ", activeBannerAd: " + this.activeBannerAd);
            } else {
                this.bannerRefreshTimer = this.executorService.schedule(new C13287(), this.bannerRefreshInterval, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            Logger.error("Could not schedule banner refresh", e);
            this.displayEventStream.sendEvent(DisplayResult.UNKNOWN_FAILURE);
        }
    }
}
