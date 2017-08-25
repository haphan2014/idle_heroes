package com.heyzap.sdk.mediation.adapter;

import com.apptracker.android.listener.AppModuleListener;
import com.apptracker.android.track.AppTracker;
import com.droidhang.pay.util.IabHelper;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayOptions;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.FetchFailure;
import com.heyzap.common.lifecycle.FetchOptions;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter.CachedAd.ExpiryListener;
import com.heyzap.mediation.abstr.FetchBackedNetworkAdapter.DisplayableFetchResult;
import com.heyzap.mediation.abstr.NetworkAdapter.ConfigurationError;
import com.heyzap.mediation.request.MediationRequest;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class LeadboltAdapter extends FetchBackedNetworkAdapter {
    private static String APP_ID_KEY = "app_api_key";
    private static String CANON = "leadbolt";
    private static String KLASS = "com.apptracker.android.track.AppTracker";
    private static String MARKETING_NAME = "Leadbolt";
    private static Boolean isConfigured = Boolean.valueOf(false);
    private String appApiKey;
    private final Map<String, AdDisplay> displayMap = new ConcurrentHashMap();
    private final Map<String, SettableFuture<DisplayableFetchResult>> fetchMap = new ConcurrentHashMap();
    private final AtomicBoolean started = new AtomicBoolean(false);

    private class AdapterModuleListener implements AppModuleListener {
        private AdapterModuleListener() {
        }

        public void onModuleLoaded(String location) {
            AdDisplay adDisplay = (AdDisplay) LeadboltAdapter.this.displayMap.get(location);
            if (adDisplay != null) {
                adDisplay.displayEventStream.sendEvent(new DisplayResult());
            }
        }

        public void onModuleFailed(String location, String error, boolean isCache) {
            boolean z = false;
            if (isCache) {
                SettableFuture<DisplayableFetchResult> fetch = (SettableFuture) LeadboltAdapter.this.fetchMap.get(location);
                StringBuilder append = new StringBuilder().append("Leadbolt - cached onModuleFauled at: ").append(location).append(" fetchFuture null? ");
                if (fetch == null) {
                    z = true;
                }
                Logger.debug(append.append(z).toString());
                if (fetch != null) {
                    fetch.set(new DisplayableFetchResult(new FetchFailure(FetchFailureReason.NO_FILL, error)));
                    LeadboltAdapter.this.fetchMap.remove(location);
                    return;
                }
                return;
            }
            AdDisplay adDisplay = (AdDisplay) LeadboltAdapter.this.displayMap.get(location);
            if (adDisplay != null) {
                adDisplay.impressionRegisteredListener.set(Boolean.valueOf(false));
                adDisplay.displayEventStream.sendEvent(new DisplayResult(error, FetchFailureReason.UNKNOWN));
                LeadboltAdapter.this.displayMap.remove(location);
            }
        }

        public void onModuleClosed(String location) {
            AdDisplay adDisplay = (AdDisplay) LeadboltAdapter.this.displayMap.get(location);
            if (adDisplay != null) {
                adDisplay.impressionRegisteredListener.set(Boolean.valueOf(true));
                adDisplay.closeListener.set(Boolean.valueOf(true));
            }
        }

        public void onModuleCached(String location) {
            SettableFuture<DisplayableFetchResult> fetchFuture = (SettableFuture) LeadboltAdapter.this.fetchMap.get(location);
            Logger.debug("Leadbolt - onModuleCached at: " + location + " fetchFuture null? " + (fetchFuture == null));
            if (fetchFuture != null) {
                fetchFuture.set(new DisplayableFetchResult(new LeadboltCachedAd(location)));
                LeadboltAdapter.this.fetchMap.remove(location);
            }
        }

        public void onModuleClicked(String location) {
            AdDisplay adDisplay = (AdDisplay) LeadboltAdapter.this.displayMap.get(location);
            if (adDisplay != null) {
                adDisplay.clickEventStream.sendEvent(Boolean.valueOf(true));
            }
        }

        public void onMediaFinished(boolean viewCompleted) {
            AdDisplay adDisplay = (AdDisplay) LeadboltAdapter.this.displayMap.get("video");
            if (adDisplay != null) {
                adDisplay.incentiveListener.set(Boolean.valueOf(viewCompleted));
            }
        }
    }

    private class FetchPoll implements Runnable {
        private FetchPoll() {
        }

        public void run() {
            for (String location : LeadboltAdapter.this.fetchMap.keySet()) {
                if (AppTracker.isAdReady(location)) {
                    SettableFuture<DisplayableFetchResult> fetch = (SettableFuture) LeadboltAdapter.this.fetchMap.get(location);
                    if (fetch != null) {
                        Logger.log("Leadbolt - poll found isReady at: " + location);
                        fetch.set(new DisplayableFetchResult(new LeadboltCachedAd(location)));
                    }
                }
            }
        }
    }

    private class LeadboltCachedAd implements CachedAd {
        private final String location;

        class C15821 implements Runnable {
            C15821() {
            }

            public void run() {
                AppTracker.loadModule(LeadboltAdapter.this.getContextRef().getApp(), LeadboltCachedAd.this.location);
            }
        }

        private LeadboltCachedAd(String location) {
            this.location = location;
        }

        public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult, DisplayOptions displayOptions) {
            AdDisplay adDisplay = new AdDisplay(false);
            adDisplay.setRefetchDelay(60);
            LeadboltAdapter.this.displayMap.put(this.location, adDisplay);
            LeadboltAdapter.this.uiThreadExecutorService.execute(new C15821());
            return adDisplay;
        }

        public void setExpiryListener(ExpiryListener expiryListener) {
        }
    }

    protected SettableFuture<DisplayableFetchResult> fetch(final FetchOptions fetchOptions) {
        final SettableFuture<DisplayableFetchResult> resultFuture = SettableFuture.create();
        this.uiThreadExecutorService.execute(new Runnable() {
            public void run() {
                LeadboltAdapter.this.doInitialSetupIfNeeded();
                String leadboltTag = fetchOptions.getCreativeType() == CreativeType.INCENTIVIZED ? "video" : IabHelper.ITEM_TYPE_INAPP;
                LeadboltAdapter.this.fetchMap.put(leadboltTag, resultFuture);
                AppTracker.loadModuleToCache(LeadboltAdapter.this.getContextRef().getApp(), leadboltTag);
                Logger.debug("Leadbolt - caching ad for tag: " + leadboltTag);
            }
        });
        return resultFuture;
    }

    private void doInitialSetupIfNeeded() {
        if (this.started.compareAndSet(false, true)) {
            AppTracker.startSession(getContextRef().getApp(), this.appApiKey);
            AppTracker.setModuleListener(new AdapterModuleListener());
            this.executorService.scheduleAtFixedRate(new FetchPoll(), 5, 5, TimeUnit.SECONDS);
        }
    }

    public void onInit() throws ConfigurationError {
        this.appApiKey = getConfiguration().getValue(APP_ID_KEY);
        if (this.appApiKey == null) {
            throw new ConfigurationError("No app_api_key");
        }
    }

    protected void onStart() {
    }

    public Boolean isOnBoard() {
        return Utils.classExists(KLASS);
    }

    public String getMarketingName() {
        return MARKETING_NAME;
    }

    public String getMarketingVersion() {
        return "6.0";
    }

    public String getCanonicalName() {
        return CANON;
    }

    public boolean onBackPressed() {
        return false;
    }

    public EnumSet<AdUnit> getAllAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INCENTIVIZED, AdUnit.INTERSTITIAL);
    }

    public EnumSet<AdUnit> getConfiguredAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INCENTIVIZED, AdUnit.INTERSTITIAL);
    }

    public EnumSet<AdUnit> getAdUnitsForCreativeType(CreativeType creativeType) {
        switch (creativeType) {
            case STATIC:
                return EnumSet.of(AdUnit.INTERSTITIAL);
            case INCENTIVIZED:
                return EnumSet.of(AdUnit.INCENTIVIZED);
            default:
                return EnumSet.noneOf(AdUnit.class);
        }
    }

    public FetchOptions canonizeFetch(FetchOptions fetchOptions) {
        return FetchOptions.builder(fetchOptions.getNetwork(), fetchOptions.getCreativeType(), fetchOptions.getAuctionType()).setTags(fetchOptions.getTags()).build();
    }

    public List<String> getPermissions() {
        return Arrays.asList(new String[]{"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"});
    }

    public List<String> getActivities() {
        return Arrays.asList(new String[]{"com.apptracker.android.module.AppModuleActivity"});
    }
}
