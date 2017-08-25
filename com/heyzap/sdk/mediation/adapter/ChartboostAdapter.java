package com.heyzap.sdk.mediation.adapter;

import android.app.Activity;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Chartboost.CBFramework;
import com.chartboost.sdk.Chartboost.CBMediation;
import com.chartboost.sdk.ChartboostDelegate;
import com.chartboost.sdk.Libraries.CBLogging.Level;
import com.chartboost.sdk.Model.CBError.CBClickError;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.PausableRunnable;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.common.lifecycle.FetchResult.FetchStartedListener;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.ContextReference;
import com.heyzap.internal.Logger;
import com.heyzap.internal.RetryManager;
import com.heyzap.internal.RetryManager.ExponentialSchedule;
import com.heyzap.internal.RetryManager.RetryableTask;
import com.heyzap.internal.Utils;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.abstr.AdUnitNetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter.ConfigurationError;
import com.heyzap.mediation.adapter.AdUnitStateManager;
import com.heyzap.mediation.adapter.FetchStateManager;
import com.heyzap.mediation.hacks.ChartboostHack;
import com.heyzap.mediation.hacks.ChartboostHack.Fetcher;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.HeyzapAds.Framework;
import com.heyzap.sdk.ads.HeyzapAds.Network;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class ChartboostAdapter extends AdUnitNetworkAdapter {
    private static boolean threwError = false;
    private final AdUnitStateManager adUnitStateManager = new AdUnitStateManager();
    private String appId;
    private String appSignature;
    private ChartboostDelegate delegate;
    private final FetchStateManager<ChartboostFetchHolder> fetchStateManager = new FetchStateManager();
    private AdDisplay incentivizedDisplay;
    private String incentivizedLocation;
    private AdDisplay interstitialDisplay;
    private String interstitialLocation;

    class C15361 implements Runnable {
        C15361() {
        }

        public void run() {
            Activity previousActivity = ChartboostAdapter.this.getContextRef().getPreviousActivity();
            if (previousActivity != null) {
                Chartboost.onPause(previousActivity);
                Chartboost.onStop(previousActivity);
                Chartboost.onDestroy(previousActivity);
            }
            ChartboostAdapter.this.startChartboostSDKForContext(ChartboostAdapter.this.getContextRef());
        }
    }

    static /* synthetic */ class C15435 {
        static final /* synthetic */ int[] $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError = new int[CBImpressionError.values().length];

        static {
            try {
                $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[CBImpressionError.INTERNAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[CBImpressionError.NO_AD_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[CBImpressionError.TOO_MANY_CONNECTIONS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[CBImpressionError.INTERNET_UNAVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[CBImpressionError.NETWORK_FAILURE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[CBImpressionError.WRONG_ORIENTATION.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[CBImpressionError.SESSION_NOT_STARTED.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[CBImpressionError.NO_HOST_ACTIVITY.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[CBImpressionError.IMPRESSION_ALREADY_VISIBLE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[CBImpressionError.FIRST_SESSION_INTERSTITIALS_DISABLED.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[CBImpressionError.USER_CANCELLATION.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            $SwitchMap$com$heyzap$internal$Constants$CreativeType = new int[CreativeType.values().length];
            try {
                $SwitchMap$com$heyzap$internal$Constants$CreativeType[CreativeType.STATIC.ordinal()] = 1;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$heyzap$internal$Constants$CreativeType[CreativeType.INCENTIVIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e13) {
            }
            $SwitchMap$com$heyzap$internal$Constants$AdUnit = new int[AdUnit.values().length];
            try {
                $SwitchMap$com$heyzap$internal$Constants$AdUnit[AdUnit.INCENTIVIZED.ordinal()] = 1;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$heyzap$internal$Constants$AdUnit[AdUnit.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    private class CallbackListener extends ChartboostDelegate {
        ChartboostAdapter adapter;

        public CallbackListener(ChartboostAdapter adapter) {
            this.adapter = adapter;
        }

        public boolean shouldRequestInterstitial(String location) {
            return true;
        }

        public boolean shouldDisplayInterstitial(String location) {
            return true;
        }

        public void didCacheInterstitial(String location) {
            this.adapter.onCallbackEvent(NetworkCallback.AVAILABLE);
            if (location != null && location.equals(ChartboostAdapter.this.interstitialLocation)) {
                ChartboostAdapter.threwError = false;
                ((ChartboostFetchHolder) ChartboostAdapter.this.fetchStateManager.get(AdUnit.INTERSTITIAL)).fetchListener.set(new FetchResult());
            }
        }

        public void didFailToLoadInterstitial(String location, CBImpressionError error) {
            if (location != null && location.equals(ChartboostAdapter.this.interstitialLocation)) {
                ((ChartboostFetchHolder) ChartboostAdapter.this.fetchStateManager.get(AdUnit.INTERSTITIAL)).fetchListener.set(new FetchResult(getFailureCause(error), error.toString()));
            }
            this.adapter.onCallbackEvent(NetworkCallback.FETCH_FAILED);
        }

        public void didDismissInterstitial(String location) {
            this.adapter.onCallbackEvent(NetworkCallback.DISMISS);
            if (location != null && location.equals(ChartboostAdapter.this.interstitialLocation)) {
                try {
                    ChartboostAdapter.this.interstitialDisplay.closeListener.set(Boolean.valueOf(true));
                } catch (Exception e) {
                    Logger.error("closeListener not available");
                }
            }
        }

        public void didCloseInterstitial(String location) {
            this.adapter.onCallbackEvent(NetworkCallback.HIDE);
        }

        public void didClickInterstitial(String location) {
            this.adapter.onCallbackEvent("click");
            if (location != null && location.equals(ChartboostAdapter.this.interstitialLocation)) {
                ChartboostAdapter.this.interstitialDisplay.clickEventStream.sendEvent(Boolean.valueOf(true));
            }
        }

        public void didDisplayInterstitial(String location) {
            this.adapter.onCallbackEvent(NetworkCallback.SHOW);
            if (location != null && location.equals(ChartboostAdapter.this.interstitialLocation)) {
                ChartboostAdapter.this.interstitialDisplay.displayEventStream.sendEvent(new DisplayResult());
            }
        }

        public boolean shouldRequestMoreApps(String location) {
            return true;
        }

        public boolean shouldDisplayMoreApps(String location) {
            return true;
        }

        public void didFailToLoadMoreApps(String location, CBImpressionError error) {
            this.adapter.onCallbackEvent(NetworkCallback.CHARTBOOST_MOREAPPS_FETCH_FAILED);
        }

        public void didCacheMoreApps(String location) {
            this.adapter.onCallbackEvent(NetworkCallback.CHARTBOOST_MOREAPPS_AVAILABLE);
        }

        public void didDismissMoreApps(String location) {
            this.adapter.onCallbackEvent(NetworkCallback.CHARTBOOST_MOREAPPS_DISMISS);
        }

        public void didCloseMoreApps(String location) {
            this.adapter.onCallbackEvent(NetworkCallback.CHARTBOOST_MOREAPPS_HIDE);
        }

        public void didClickMoreApps(String location) {
            this.adapter.onCallbackEvent(NetworkCallback.CHARTBOOST_MOREAPPS_CLICK);
        }

        public void didDisplayMoreApps(String location) {
            this.adapter.onCallbackEvent(NetworkCallback.CHARTBOOST_MOREAPPS_SHOW);
        }

        public void didFailToRecordClick(String uri, CBClickError error) {
            this.adapter.onCallbackEvent(NetworkCallback.CHARTBOOST_MOREAPPS_CLICK_FAILED);
        }

        public boolean shouldDisplayRewardedVideo(String location) {
            return true;
        }

        public void didCacheRewardedVideo(String location) {
            this.adapter.onCallbackEvent(NetworkCallback.AVAILABLE);
            ChartboostAdapter.threwError = false;
            ((ChartboostFetchHolder) ChartboostAdapter.this.fetchStateManager.get(AdUnit.INCENTIVIZED)).fetchListener.set(new FetchResult());
        }

        public void didFailToLoadRewardedVideo(String location, CBImpressionError error) {
            this.adapter.onCallbackEvent(NetworkCallback.FETCH_FAILED);
            ((ChartboostFetchHolder) ChartboostAdapter.this.fetchStateManager.get(AdUnit.INCENTIVIZED)).fetchListener.set(new FetchResult(getFailureCause(error), error.toString()));
        }

        public void didDismissRewardedVideo(String location) {
            this.adapter.onCallbackEvent(NetworkCallback.DISMISS);
            ChartboostAdapter.this.incentivizedDisplay.closeListener.set(Boolean.valueOf(true));
            ChartboostAdapter.this.incentivizedDisplay.incentiveListener.set(Boolean.valueOf(false));
        }

        public void didCloseRewardedVideo(String location) {
            this.adapter.onCallbackEvent(NetworkCallback.HIDE);
        }

        public void didClickRewardedVideo(String location) {
            this.adapter.onCallbackEvent("click");
            ChartboostAdapter.this.incentivizedDisplay.clickEventStream.sendEvent(Boolean.valueOf(true));
        }

        public void didCompleteRewardedVideo(String location, int reward) {
            this.adapter.onCallbackEvent(NetworkCallback.INCENTIVIZED_RESULT_COMPLETE);
            ChartboostAdapter.this.incentivizedDisplay.incentiveListener.set(Boolean.valueOf(true));
        }

        public void didDisplayRewardedVideo(String location) {
            this.adapter.onCallbackEvent(NetworkCallback.SHOW);
            ChartboostAdapter.this.incentivizedDisplay.displayEventStream.sendEvent(new DisplayResult());
        }

        public FetchFailureReason getFailureCause(CBImpressionError error) {
            switch (C15435.$SwitchMap$com$chartboost$sdk$Model$CBError$CBImpressionError[error.ordinal()]) {
                case 1:
                    return FetchFailureReason.INTERNAL;
                case 2:
                    ChartboostAdapter.threwError = true;
                    return FetchFailureReason.NO_FILL;
                case 3:
                    return FetchFailureReason.REMOTE_ERROR;
                case 4:
                case 5:
                    return FetchFailureReason.NETWORK_ERROR;
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                    return FetchFailureReason.CONFIGURATION_ERROR;
                default:
                    return FetchFailureReason.UNKNOWN;
            }
        }
    }

    private static class ChartboostFetchHolder {
        public final SettableFuture<FetchResult> fetchListener = SettableFuture.create();

        ChartboostFetchHolder() {
        }
    }

    public static class ChartboostHackFetcher implements Fetcher {
        public void fetch(String location) {
            Logger.format("ChartboostHackFetcher - fetch - location: %s", location);
            Chartboost.cacheInterstitial(location);
        }

        public boolean isAvailable(String location) {
            Logger.format("ChartboostHackFetcher - isAvailable - location: %s", location);
            return Chartboost.hasInterstitial(location);
        }

        public void show(String location) {
            Logger.format("ChartboostHackFetcher - show - location: %s", location);
            Chartboost.showInterstitial(location);
        }
    }

    public boolean isInterstitialVideo() {
        return false;
    }

    public Boolean isOnBoard() {
        boolean z = Utils.classExists("com.chartboost.sdk.Chartboost").booleanValue() && Utils.classExists("com.chartboost.sdk.Model.CBError").booleanValue();
        return Boolean.valueOf(z);
    }

    public String getMarketingName() {
        return "Chartboost";
    }

    public String getMarketingVersion() {
        return Chartboost.getSDKVersion();
    }

    public String getCanonicalName() {
        return Network.CHARTBOOST;
    }

    public void onInit() throws ConfigurationError {
        this.interstitialLocation = "Default";
        this.incentivizedLocation = "Main Menu";
        if (getContextRef().getActivity() == null) {
            throw new ConfigurationError("Context is not an Activity. Please pass an Activity to HeyzapAds.start to enable chartboost.");
        }
        this.appId = getConfiguration().getValue("app_id");
        this.appSignature = getConfiguration().getValue("app_signature");
        if (this.appId == null || this.appSignature == null) {
            throw new ConfigurationError("App id or signature not defined.");
        }
        this.delegate = new CallbackListener(this);
        ChartboostFetchHolder unsupportedFetch = new ChartboostFetchHolder();
        unsupportedFetch.fetchListener.set(FetchResult.UNSUPPORTED_AD_UNIT);
        for (AdUnit adUnit : AdUnit.values()) {
            this.fetchStateManager.set(adUnit, unsupportedFetch);
        }
        this.fetchStateManager.set(AdUnit.INTERSTITIAL, new ChartboostFetchHolder());
        this.fetchStateManager.set(AdUnit.INCENTIVIZED, new ChartboostFetchHolder());
    }

    protected void onStart() {
        startChartboostSDKForContext(getContextRef());
        getContextRef().addActivityUpdateListener(new C15361(), this.uiThreadExecutorService);
        onCallbackEvent(NetworkCallback.INITIALIZED);
        ChartboostHack.instance().setFetcher(new ChartboostHackFetcher());
    }

    private void startChartboostSDKForContext(ContextReference ref) {
        Activity activity = ref.getActivity();
        Chartboost.startWithAppId(activity, this.appId, this.appSignature);
        Chartboost.setMediation(CBMediation.CBMediationHeyZap, HeyzapAds.getVersion());
        if (HeyzapAds.framework != null) {
            String str = HeyzapAds.framework;
            Object obj = -1;
            switch (str.hashCode()) {
                case -286501690:
                    if (str.equals(Framework.UNITY)) {
                        obj = null;
                        break;
                    }
                    break;
                case 96586:
                    if (str.equals(Framework.AIR)) {
                        obj = 1;
                        break;
                    }
                    break;
                case 954757884:
                    if (str.equals(Framework.CORDOVA)) {
                        obj = 2;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    Chartboost.setFramework(CBFramework.CBFrameworkUnity, HeyzapAds.frameworkVersion);
                    break;
                case 1:
                    Chartboost.setFramework(CBFramework.CBFrameworkAir, HeyzapAds.frameworkVersion);
                    break;
                case 2:
                    Chartboost.setFramework(CBFramework.CBFrameworkCordova, HeyzapAds.frameworkVersion);
                    break;
            }
        }
        Chartboost.onCreate(activity);
        Chartboost.onStart(activity);
        Chartboost.setLoggingLevel(Utils.isDebug(activity).booleanValue() ? Level.ALL : Level.NONE);
        Chartboost.setDelegate(this.delegate);
    }

    public SettableFuture startAdUnits(Collection<AdUnit> adUnits) {
        final SettableFuture result = SettableFuture.create();
        adUnits.retainAll(getConfiguredAdUnitCapabilities());
        Set<AdUnit> startedUnits = this.adUnitStateManager.start(adUnits);
        if (startedUnits.isEmpty()) {
            result.set(Boolean.valueOf(true));
        } else {
            List<SettableFuture<FetchResult>> fetches = new ArrayList(startedUnits.size());
            for (AdUnit adUnit : startedUnits) {
                attemptNextFetch(adUnit);
                fetches.add(awaitAvailability(adUnit));
            }
            FutureUtils.allOf(fetches, this.executorService).addListener(new Runnable() {
                public void run() {
                    result.set(Boolean.valueOf(true));
                }
            }, this.executorService);
        }
        return result;
    }

    public boolean isAdUnitStarted(Collection<AdUnit> adUnits) {
        return this.adUnitStateManager.allStarted(adUnits);
    }

    public SettableFuture<FetchResult> awaitAvailability(AdUnit adUnit) {
        return ((ChartboostFetchHolder) this.fetchStateManager.get(adUnit)).fetchListener;
    }

    private boolean checkReady(AdUnit adUnit) {
        if (threwError) {
            return false;
        }
        switch (adUnit) {
            case INCENTIVIZED:
                return Chartboost.hasRewardedVideo(this.incentivizedLocation);
            case INTERSTITIAL:
                return Chartboost.hasInterstitial(this.interstitialLocation);
            default:
                return false;
        }
    }

    private void fetch(AdUnit adUnit) {
        switch (adUnit) {
            case INCENTIVIZED:
                Chartboost.cacheRewardedVideo(this.incentivizedLocation);
                return;
            case INTERSTITIAL:
                try {
                    Chartboost.cacheInterstitial(this.interstitialLocation);
                    return;
                } catch (Throwable e) {
                    Logger.trace(e);
                    return;
                }
            default:
                return;
        }
    }

    private void attemptNextFetch(final AdUnit adUnit) {
        getFetchConsumer().consumeAny(Collections.singletonList(adUnit), new PausableRunnable(this.pauseSignal, this.executorService) {

            class C15401 extends RetryableTask {
                C15401() {
                }

                public void run() {
                    ChartboostAdapter.this.fetchStateManager.start(adUnit);
                    final ChartboostFetchHolder localFetch = (ChartboostFetchHolder) ChartboostAdapter.this.fetchStateManager.get(adUnit);
                    ChartboostAdapter.this.fetch(adUnit);
                    new RetryManager(new RetryableTask() {
                        public void run() {
                            if (ChartboostAdapter.this.checkReady(adUnit)) {
                                localFetch.fetchListener.set(new FetchResult());
                            }
                            if (!localFetch.fetchListener.isDone()) {
                                retry();
                            }
                        }
                    }, new ExponentialSchedule(1.5d, 4, TimeUnit.SECONDS), ChartboostAdapter.this.executorService).start();
                    localFetch.fetchListener.addListener(new Runnable() {
                        public void run() {
                            FetchResult fetchResult = (FetchResult) FutureUtils.getImmediatelyOrDefault(localFetch.fetchListener, FetchResult.NOT_READY);
                            if (!fetchResult.success) {
                                ChartboostAdapter.this.setLastFailure(adUnit, fetchResult.fetchFailure);
                                ChartboostAdapter.this.fetchStateManager.set(adUnit, new ChartboostFetchHolder());
                                C15401.this.retry();
                            }
                        }
                    }, ChartboostAdapter.this.executorService);
                }
            }

            public void runWhenUnpaused() {
                new RetryManager(new C15401(), new ExponentialSchedule(2.0d, 5, TimeUnit.SECONDS), ChartboostAdapter.this.executorService).start();
            }
        }, this.executorService);
    }

    public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult) {
        switch (mediationRequest.getAdUnit()) {
            case INCENTIVIZED:
                this.incentivizedDisplay = new AdDisplay();
                Chartboost.showRewardedVideo(this.incentivizedLocation);
                this.fetchStateManager.set(AdUnit.INCENTIVIZED, new ChartboostFetchHolder());
                attemptNextFetch(AdUnit.INCENTIVIZED);
                return this.incentivizedDisplay;
            case INTERSTITIAL:
                this.interstitialDisplay = new AdDisplay();
                Chartboost.showInterstitial(this.interstitialLocation);
                this.fetchStateManager.set(AdUnit.INTERSTITIAL, new ChartboostFetchHolder());
                attemptNextFetch(AdUnit.INTERSTITIAL);
                return this.interstitialDisplay;
            default:
                AdDisplay failedHolder = new AdDisplay();
                failedHolder.displayEventStream.sendEvent(new DisplayResult("invalid ad unit"));
                return failedHolder;
        }
    }

    public EnumSet<AdUnit> getAllAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.INCENTIVIZED);
    }

    public EnumSet<AdUnit> getConfiguredAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.INCENTIVIZED);
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

    public void addFetchStartedListener(final FetchStartedListener fetchStartedListener, ExecutorService executorService) {
        this.fetchStateManager.addFetchStartedListener(new FetchStateManager.FetchStartedListener<ChartboostFetchHolder>() {
            public void onFetchStarted(AdUnit adUnit, ChartboostFetchHolder value) {
                fetchStartedListener.onFetchStarted(adUnit, value.fetchListener);
            }
        }, executorService);
    }

    public boolean onBackPressed() {
        if (isStarted()) {
            return Chartboost.onBackPressed();
        }
        return false;
    }

    public List<String> getPermissions() {
        return Arrays.asList(new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.ACCESS_WIFI_STATE", "android.permission.INTERNET", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public List<String> getActivities() {
        return Collections.emptyList();
    }
}
