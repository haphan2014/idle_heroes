package com.heyzap.sdk.mediation.adapter;

import com.heyzap.common.concurrency.FutureUtils.FutureRunnable;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.FetchFailure;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.common.vast.VASTInterstitial;
import com.heyzap.exchange.ExchangeAd;
import com.heyzap.exchange.ExchangeClient;
import com.heyzap.exchange.ExchangeEventReporter;
import com.heyzap.exchange.RefreshingExchangeBannerAd;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.AuctionType;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.LargeSet;
import com.heyzap.internal.Logger;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter.CachedAd.ExpiryListener;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter.DisplayableFetchResult;
import com.heyzap.mediation.abstr.NetworkAdapter.ConfigurationError;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallback;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class HeyzapExchangeAdapter extends FetchBackedNetworkAdapter {
    private static final String DEFAULT_EXCHANGE_URL = "https://x.heyzap.com/_/0/ad";
    private long bannerRefreshInterval;
    private boolean coppaEnabled;
    private String exchangeUrl;
    private WeakReference<ExchangeAd> lastShownAd = new WeakReference(null);
    private ExchangeEventReporter reporter;

    public class CachedBannerExchangeAd implements CachedAd {
        private RefreshingExchangeBannerAd exchangeAd = createRefreshingExchangeAd();

        class C15591 implements Runnable {
            C15591() {
            }

            public void run() {
                CachedBannerExchangeAd.this.exchangeAd.destroyBanner(true);
            }
        }

        public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
            checkBannerExpiry();
            HashMap<String, String> clientParams = HeyzapExchangeAdapter.this.generateClientParams(mediationRequest, mediationResult);
            this.exchangeAd.setBannerOptions(mediationRequest.getBannerOptions());
            this.exchangeAd.load();
            this.exchangeAd.onShowRequest(clientParams);
            return this.exchangeAd;
        }

        public AdDisplay prefetch(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
            checkBannerExpiry();
            this.exchangeAd.setBannerOptions(mediationRequest.getBannerOptions());
            return this.exchangeAd.preload();
        }

        public void setExpiryListener(ExpiryListener expiryListener) {
        }

        public Double getScore() {
            return Double.valueOf(this.exchangeAd.getScore());
        }

        private void checkBannerExpiry() {
            if (this.exchangeAd.getTtl() != null && this.exchangeAd.getTtl().longValue() < 0) {
                RefreshingExchangeBannerAd toDestroy = this.exchangeAd;
                HeyzapExchangeAdapter.this.uiThreadExecutorService.execute(new C15591());
                this.exchangeAd = createRefreshingExchangeAd();
            }
        }

        private RefreshingExchangeBannerAd createRefreshingExchangeAd() {
            return new RefreshingExchangeBannerAd(HeyzapExchangeAdapter.this.getContextRef(), HeyzapExchangeAdapter.this.reporter, HeyzapExchangeAdapter.this.exchangeUrl, HeyzapExchangeAdapter.this.executorService, HeyzapExchangeAdapter.this.uiThreadExecutorService, HeyzapExchangeAdapter.this.coppaEnabled, HeyzapExchangeAdapter.this.bannerRefreshInterval);
        }
    }

    public class CachedExchangeAd implements CachedAd {
        private ExchangeAd exchangeAd;
        protected ExpiryListener expiryListener;

        public CachedExchangeAd(final ExchangeAd exchangeAd) {
            this.exchangeAd = exchangeAd;
            if (exchangeAd.getTtl() != null) {
                HeyzapExchangeAdapter.this.executorService.schedule(new Runnable(HeyzapExchangeAdapter.this) {
                    public void run() {
                        if (CachedExchangeAd.this.expiryListener != null) {
                            CachedExchangeAd.this.expiryListener.onExpired(exchangeAd.getRefetchOnExpiry());
                        }
                    }
                }, exchangeAd.getTtl().longValue(), TimeUnit.SECONDS);
            }
        }

        public AdDisplay show(final MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
            final HashMap<String, String> clientParams = HeyzapExchangeAdapter.this.generateClientParams(mediationRequest, mediationResult);
            AdDisplay display = this.exchangeAd;
            HeyzapExchangeAdapter.this.uiThreadExecutorService.execute(new Runnable() {
                public void run() {
                    HeyzapExchangeAdapter.this.lastShownAd = new WeakReference(CachedExchangeAd.this.exchangeAd);
                    HeyzapExchangeAdapter.this.reporter.bindDisplay(CachedExchangeAd.this.exchangeAd, clientParams);
                    if (CachedExchangeAd.this.exchangeAd instanceof VASTInterstitial) {
                        ((VASTInterstitial) CachedExchangeAd.this.exchangeAd).show(mediationRequest.getRequestingActivity(), mediationRequest.getAdUnit());
                    } else if (CachedExchangeAd.this.exchangeAd != null) {
                        CachedExchangeAd.this.exchangeAd.displayEventStream.sendEvent(new DisplayResult());
                        CachedExchangeAd.this.exchangeAd.show(mediationRequest.getRequestingActivity());
                    }
                }
            });
            return display;
        }

        public void setExpiryListener(ExpiryListener expiryListener) {
            this.expiryListener = expiryListener;
        }

        public Double getScore() {
            return Double.valueOf(this.exchangeAd.getScore());
        }
    }

    public Boolean isOnBoard() {
        return Boolean.valueOf(true);
    }

    public String getMarketingName() {
        return "Heyzap Exchange";
    }

    public String getMarketingVersion() {
        return "9.11.3";
    }

    public String getCanonicalName() {
        return "heyzap_exchange";
    }

    public EnumSet<AdUnit> getAllAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.INCENTIVIZED, AdUnit.VIDEO, AdUnit.BANNER);
    }

    public EnumSet<AdUnit> getConfiguredAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.INCENTIVIZED, AdUnit.VIDEO, AdUnit.BANNER);
    }

    public EnumSet<AdUnit> getAdUnitsForCreativeType(CreativeType creativeType) {
        switch (creativeType) {
            case STATIC:
                return EnumSet.of(AdUnit.INTERSTITIAL);
            case INCENTIVIZED:
                return EnumSet.of(AdUnit.INCENTIVIZED);
            case BANNER:
                return EnumSet.of(AdUnit.BANNER);
            case VIDEO:
                return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.VIDEO);
            default:
                return EnumSet.noneOf(AdUnit.class);
        }
    }

    protected SettableFuture<DisplayableFetchResult> fetch(final FetchOptions fetchOptions) {
        final SettableFuture<DisplayableFetchResult> resultFuture = SettableFuture.create();
        if (fetchOptions.getCreativeType() == CreativeType.BANNER) {
            resultFuture.set(new DisplayableFetchResult(new CachedBannerExchangeAd()));
        } else {
            SettableFuture<ExchangeAd> adFuture = ExchangeClient.fetch(getContextRef(), this.reporter, fetchOptions.getCreativeType(), this.exchangeUrl, null, 0, 0, this.coppaEnabled, this.executorService, this.uiThreadExecutorService).adLoadedFuture;
            adFuture.addListener(new FutureRunnable<ExchangeAd>(adFuture) {
                public void run(ExchangeAd result, Exception exception) {
                    FetchFailure fetchFailure;
                    if (result != null) {
                        DisplayableFetchResult fetchResult = new DisplayableFetchResult(new CachedExchangeAd(result));
                        Logger.debug("HeyzapExchangeAdapter - attemptNextFetch success for unit: " + fetchOptions.getCreativeType());
                        resultFuture.set(fetchResult);
                    }
                    if (exception != null) {
                        fetchFailure = new FetchFailure(FetchFailureReason.NO_FILL, exception.getMessage());
                    } else {
                        fetchFailure = new FetchFailure(FetchFailureReason.UNKNOWN, "Unknown error during fetch (No Exception)");
                    }
                    resultFuture.set(new DisplayableFetchResult(fetchFailure));
                }
            }, this.uiThreadExecutorService);
        }
        return resultFuture;
    }

    public List<String> getPermissions() {
        return Arrays.asList(new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET"});
    }

    public List<String> getActivities() {
        return Collections.singletonList("com.heyzap.sdk.ads.VASTActivity");
    }

    public void onInit() throws ConfigurationError {
        Logger.debug("HeyzapExchangeAdapter - onInit ");
        this.exchangeUrl = getConfiguration().optValue("url", DEFAULT_EXCHANGE_URL);
        this.coppaEnabled = getConfiguration().optValue("coppa_enabled", "disabled").equals("enabled");
        this.reporter = new ExchangeEventReporter(getContextRef(), this.executorService);
        String bannerRefreshIntervalString = getConfiguration().optValue("banner_refresh_interval", "60");
        try {
            this.bannerRefreshInterval = Long.parseLong(bannerRefreshIntervalString);
            start(FetchOptions.builder("heyzap_exchange", CreativeType.BANNER, AuctionType.MONETIZATION).setAdUnit(LargeSet.of(AdUnit.BANNER)).build());
            onCallbackEvent(NetworkCallback.INITIALIZED);
        } catch (NumberFormatException e) {
            throw new ConfigurationError("banner_refresh_interval invalid: " + bannerRefreshIntervalString);
        }
    }

    protected void onStart() {
    }

    public Double getScoreOverride(DisplayOptions displayOptions) {
        CachedAd cachedAd = getCachedAd(displayOptions);
        if (cachedAd == null || !(cachedAd instanceof CachedExchangeAd)) {
            return Double.valueOf(Double.MAX_VALUE);
        }
        return ((CachedExchangeAd) cachedAd).getScore();
    }

    public boolean onBackPressed() {
        ExchangeAd ad = (ExchangeAd) this.lastShownAd.get();
        return ad != null && ad.onBackPressed();
    }

    private HashMap<String, String> generateClientParams(MediationRequest mediationRequest, MediationResult mediationResult) {
        HashMap<String, String> clientParams = new HashMap(3);
        clientParams.put("mediation_id", mediationResult.id);
        clientParams.put("mediation_tag", mediationRequest.getTag());
        clientParams.put("ad_unit", mediationRequest.getAdUnit().toString().toLowerCase(Locale.US));
        return clientParams;
    }

    public AdDisplay prefetchBanner(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
        CachedAd cachedAd = getCachedAd(displayOptions);
        if (cachedAd != null && (cachedAd instanceof CachedBannerExchangeAd)) {
            return ((CachedBannerExchangeAd) cachedAd).prefetch(mediationRequest, mediationResult, displayOptions);
        }
        AdDisplay failedDisplay = new AdDisplay();
        failedDisplay.displayEventStream.sendEvent(new DisplayResult("Exchange Banners Not Ready", FetchFailureReason.UNKNOWN));
        return failedDisplay;
    }
}
