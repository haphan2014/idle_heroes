package com.heyzap.sdk.mediation.adapter;

import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.common.lifecycle.FetchResult.FetchStartedListener;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.RetryManager;
import com.heyzap.internal.RetryManager.ExponentialSchedule;
import com.heyzap.internal.RetryManager.RetryableTask;
import com.heyzap.internal.Utils;
import com.heyzap.mediation.MediationManager;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.abstr.AdUnitNetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter.ConfigurationError;
import com.heyzap.mediation.adapter.AdUnitAliasMap;
import com.heyzap.mediation.adapter.AdUnitStateManager;
import com.heyzap.mediation.adapter.FetchStateManager;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.HeyzapAds.Network;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallback;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAds.FinishState;
import com.unity3d.ads.UnityAds.UnityAdsError;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class UnityadsAdapter extends AdUnitNetworkAdapter {
    private static AdUnit AD_UNIT = AdUnit.VIDEO;
    private static String CANON = Network.UNITYADS;
    private static String KLASS = "com.unity3d.ads.UnityAds";
    private static String MARKETING_NAME = "UnityAds";
    private AdUnitAliasMap adUnitAliasMap;
    private AdUnitStateManager adUnitStateManager = new AdUnitStateManager();
    private DisplayHolder displayHolder;
    private final FetchStateManager<FetchHolder> fetchStateManager = new FetchStateManager();
    private String incentivizedPlacementId;
    private String videoPlacementId;

    static /* synthetic */ class C15894 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError = new int[UnityAdsError.values().length];

        static {
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAdsError.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAdsError.INITIALIZE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAdsError.INVALID_ARGUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAdsError.AD_BLOCKER_DETECTED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAdsError.FILE_IO_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAdsError.DEVICE_ID_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAdsError.INIT_SANITY_CHECK_FAIL.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAdsError.INTERNAL_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAdsError.SHOW_ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAdsError.VIDEO_PLAYER_ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            $SwitchMap$com$heyzap$internal$Constants$CreativeType = new int[CreativeType.values().length];
            try {
                $SwitchMap$com$heyzap$internal$Constants$CreativeType[CreativeType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$heyzap$internal$Constants$CreativeType[CreativeType.INCENTIVIZED.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            $SwitchMap$com$heyzap$internal$Constants$AdUnit = new int[AdUnit.values().length];
            try {
                $SwitchMap$com$heyzap$internal$Constants$AdUnit[AdUnit.INCENTIVIZED.ordinal()] = 1;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$heyzap$internal$Constants$AdUnit[AdUnit.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$heyzap$internal$Constants$AdUnit[AdUnit.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    private class AdListener implements IUnityAdsListener {
        private final NetworkAdapter adapter;

        public AdListener(NetworkAdapter adapter) {
            this.adapter = adapter;
        }

        public void onUnityAdsReady(String placementId) {
            this.adapter.onCallbackEvent(NetworkCallback.AVAILABLE);
            ((FetchHolder) UnityadsAdapter.this.fetchStateManager.get(UnityadsAdapter.this.getAdUnitForPlacement(placementId))).fetchListener.set(new FetchResult());
        }

        public void onUnityAdsStart(String s) {
            this.adapter.onCallbackEvent(NetworkCallback.AUDIO_STARTING);
            this.adapter.onCallbackEvent(NetworkCallback.SHOW);
            UnityadsAdapter.this.displayHolder.displayEventStream.sendEvent(new DisplayResult());
        }

        public void onUnityAdsFinish(String s, FinishState finishState) {
            if (UnityadsAdapter.this.displayHolder.adUnit.equals(AdUnit.INCENTIVIZED)) {
                if (finishState == FinishState.COMPLETED) {
                    this.adapter.onCallbackEvent(NetworkCallback.INCENTIVIZED_RESULT_COMPLETE);
                    UnityadsAdapter.this.displayHolder.incentiveListener.set(Boolean.valueOf(true));
                }
                if (finishState == FinishState.SKIPPED) {
                    this.adapter.onCallbackEvent(NetworkCallback.INCENTIVIZED_RESULT_INCOMPLETE);
                    UnityadsAdapter.this.displayHolder.incentiveListener.set(Boolean.valueOf(false));
                }
            }
            if (finishState != FinishState.ERROR) {
                this.adapter.onCallbackEvent(NetworkCallback.HIDE);
                this.adapter.onCallbackEvent(NetworkCallback.AUDIO_FINISHED);
                UnityadsAdapter.this.displayHolder.closeListener.set(Boolean.valueOf(true));
                return;
            }
            this.adapter.onCallbackEvent(NetworkCallback.DISPLAY_FAILED);
        }

        public void onUnityAdsError(UnityAdsError unityAdsError, String message) {
            FetchResult failure;
            switch (C15894.$SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[unityAdsError.ordinal()]) {
                case 1:
                case 2:
                    failure = new FetchResult(FetchFailureReason.CONFIGURATION_ERROR, message);
                    break;
                case 3:
                    failure = new FetchResult(FetchFailureReason.BAD_CREDENTIALS, message);
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    this.adapter.onCallbackEvent(NetworkCallback.FETCH_FAILED);
                    break;
                case 8:
                case 9:
                case 10:
                    break;
                default:
                    failure = new FetchResult(FetchFailureReason.UNKNOWN, message);
                    break;
            }
            failure = new FetchResult(FetchFailureReason.INTERNAL, message);
            ((FetchHolder) UnityadsAdapter.this.fetchStateManager.get(UnityadsAdapter.AD_UNIT)).fetchListener.set(failure);
        }
    }

    private static class DisplayHolder extends AdDisplay {
        public final AdUnit adUnit;

        private DisplayHolder(AdUnit adUnit) {
            this.adUnit = adUnit;
        }
    }

    private static class FetchHolder {
        public final SettableFuture<FetchResult> fetchListener;

        public FetchHolder() {
            this.fetchListener = SettableFuture.create();
        }

        public FetchHolder(FetchResult result) {
            SettableFuture<FetchResult> fetchListener = SettableFuture.create();
            fetchListener.set(result);
            this.fetchListener = fetchListener;
        }
    }

    public boolean isInterstitialVideo() {
        return this.adUnitAliasMap.translate(AdUnit.INTERSTITIAL) == AdUnit.VIDEO;
    }

    public Boolean isOnBoard() {
        return Utils.classExists(KLASS);
    }

    public String getMarketingName() {
        return MARKETING_NAME;
    }

    public String getMarketingVersion() {
        return UnityAds.getVersion();
    }

    public String getCanonicalName() {
        return CANON;
    }

    public SettableFuture<FetchResult> awaitAvailability(AdUnit adUnit) {
        return ((FetchHolder) this.fetchStateManager.get(this.adUnitAliasMap.translate(adUnit))).fetchListener;
    }

    private String getPlacementId(AdUnit adUnit) {
        switch (this.adUnitAliasMap.translate(adUnit)) {
            case INCENTIVIZED:
                return this.incentivizedPlacementId;
            default:
                return this.videoPlacementId;
        }
    }

    private void attemptNextFetch(AdUnit adUnit) {
        final AdUnit translatedAdUnit = this.adUnitAliasMap.translate(adUnit);
        getFetchConsumer().consumeAny(this.adUnitAliasMap.getAliases(adUnit), new Runnable() {

            class C15851 extends RetryableTask {
                C15851() {
                }

                public void run() {
                    UnityadsAdapter.this.fetchStateManager.start(translatedAdUnit);
                    final FetchHolder fetchHolder = (FetchHolder) UnityadsAdapter.this.fetchStateManager.get(translatedAdUnit);
                    fetchHolder.fetchListener.addListener(new Runnable() {
                        public void run() {
                            FetchResult fetchResult = (FetchResult) FutureUtils.getImmediatelyOrDefault(fetchHolder.fetchListener, FetchResult.NOT_READY);
                            if (!fetchResult.success) {
                                UnityadsAdapter.this.setLastFailure(translatedAdUnit, fetchResult.fetchFailure);
                                UnityadsAdapter.this.fetchStateManager.set(translatedAdUnit, new FetchHolder());
                                C15851.this.retry();
                            }
                        }
                    }, UnityadsAdapter.this.executorService);
                    new RetryManager(new RetryableTask() {
                        public void run() {
                            if (UnityAds.isReady(UnityadsAdapter.this.getPlacementId(translatedAdUnit))) {
                                fetchHolder.fetchListener.set(new FetchResult());
                            }
                            if (!fetchHolder.fetchListener.isDone()) {
                                retry();
                            }
                        }
                    }, new ExponentialSchedule(1.5d, 4, TimeUnit.SECONDS), UnityadsAdapter.this.executorService).start();
                }
            }

            public void run() {
                new RetryManager(new C15851(), new ExponentialSchedule(1.5d, 4, TimeUnit.SECONDS), UnityadsAdapter.this.executorService).start();
            }
        }, this.executorService);
    }

    public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult) {
        AdUnit adUnit = this.adUnitAliasMap.translate(mediationRequest.getAdUnit());
        DisplayHolder localDisplayHolder = new DisplayHolder(adUnit);
        this.displayHolder = localDisplayHolder;
        if (UnityAds.isReady(getPlacementId(adUnit))) {
            MediationMetaData m = new MediationMetaData(getContextRef().getActivity());
            m.setName("Heyzap");
            m.setVersion(HeyzapAds.getVersion());
            MediationManager.getInstance();
            m.setOrdinal(MediationManager.getSessionFullscreenAdImpressions() + 1);
            m.commit();
            UnityAds.show(getContextRef().getActivity(), getPlacementId(adUnit));
        } else {
            localDisplayHolder.displayEventStream.sendEvent(DisplayResult.NOT_READY);
        }
        if (((FetchHolder) this.fetchStateManager.get(adUnit)).fetchListener.isDone()) {
            this.fetchStateManager.set(adUnit, new FetchHolder());
            attemptNextFetch(adUnit);
        }
        return localDisplayHolder;
    }

    public EnumSet<AdUnit> getAllAdUnitCapabilities() {
        return EnumSet.of(AdUnit.VIDEO, AdUnit.INCENTIVIZED, AdUnit.INTERSTITIAL);
    }

    public EnumSet<AdUnit> getConfiguredAdUnitCapabilities() {
        return EnumSet.of(AdUnit.VIDEO, AdUnit.INCENTIVIZED, AdUnit.INTERSTITIAL);
    }

    public EnumSet<AdUnit> getAdUnitsForCreativeType(CreativeType creativeType) {
        switch (creativeType) {
            case VIDEO:
                return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.VIDEO);
            case INCENTIVIZED:
                return EnumSet.of(AdUnit.INCENTIVIZED);
            default:
                return EnumSet.noneOf(AdUnit.class);
        }
    }

    public void addFetchStartedListener(final FetchStartedListener fetchStartedListener, ExecutorService executorService) {
        this.fetchStateManager.addFetchStartedListener(new FetchStateManager.FetchStartedListener<FetchHolder>() {
            public void onFetchStarted(AdUnit adUnit, FetchHolder fetchHolder) {
                fetchStartedListener.onFetchStarted(adUnit, fetchHolder.fetchListener);
            }
        }, executorService);
    }

    public void onInit() throws ConfigurationError {
        if (getContextRef().getActivity() == null) {
            throw new ConfigurationError("Context is not an Activity. Please pass an Activity to HeyzapAds.start to enable unity ads.");
        } else if (UnityAds.isSupported()) {
            this.adUnitAliasMap = new AdUnitAliasMap();
            this.adUnitAliasMap.add(AdUnit.INTERSTITIAL, AdUnit.VIDEO);
            this.adUnitStateManager.setAliasMap(this.adUnitAliasMap);
            this.incentivizedPlacementId = getConfiguration().getValue("incentivized_placement_id");
            this.videoPlacementId = getConfiguration().getValue("video_placement_id");
            this.fetchStateManager.set(AdUnit.INCENTIVIZED, new FetchHolder());
            this.fetchStateManager.set(AdUnit.VIDEO, new FetchHolder());
        } else {
            throw new ConfigurationError("UnityAds is not supported on this device.");
        }
    }

    protected void onStart() {
        MediationMetaData m = new MediationMetaData(getContextRef().getActivity());
        m.setName("Heyzap");
        m.setVersion(HeyzapAds.getVersion());
        m.commit();
        UnityAds.initialize(getContextRef().getActivity(), getConfiguration().getValue("game_id"), new AdListener(this));
        UnityAds.setDebugMode(HeyzapAds.isThirdPartyVerboseLogging());
    }

    public SettableFuture startAdUnits(Collection<AdUnit> adUnits) {
        Set<AdUnit> startedUnits = this.adUnitStateManager.start(adUnits);
        startedUnits.retainAll(getConfiguredAdUnitCapabilities());
        final SettableFuture<FetchResult> result = SettableFuture.create();
        if (startedUnits.isEmpty()) {
            result.set(new FetchResult());
        } else {
            List<SettableFuture<FetchResult>> futures = new ArrayList(startedUnits.size());
            for (AdUnit adUnit : startedUnits) {
                attemptNextFetch(adUnit);
                futures.add(awaitAvailability(adUnit));
            }
            FutureUtils.allOf(futures, this.executorService).addListener(new Runnable() {
                public void run() {
                    result.set(new FetchResult());
                }
            }, this.executorService);
        }
        return result;
    }

    public boolean isAdUnitStarted(Collection<AdUnit> adUnitList) {
        return this.adUnitStateManager.allStarted(adUnitList);
    }

    private AdUnit getAdUnitForPlacement(String placementId) {
        if (placementId == this.incentivizedPlacementId) {
            return AdUnit.INCENTIVIZED;
        }
        return AdUnit.VIDEO;
    }

    public List<String> getPermissions() {
        return Arrays.asList(new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public List<String> getActivities() {
        return Arrays.asList(new String[]{"com.unity3d.ads.adunit.AdUnitActivity", "com.unity3d.ads.adunit.AdUnitSoftwareActivity"});
    }

    public boolean onBackPressed() {
        return false;
    }
}
