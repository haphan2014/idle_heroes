package com.heyzap.sdk.mediation.adapter;

import com.heyzap.common.concurrency.FutureUtils;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.lifecycle.AdDisplay;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.EventStream;
import com.heyzap.common.lifecycle.FetchResult;
import com.heyzap.common.lifecycle.FetchResult.FetchStartedListener;
import com.heyzap.internal.Constants;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.Logger;
import com.heyzap.internal.RetryManager;
import com.heyzap.internal.RetryManager.DelayedSchedule;
import com.heyzap.internal.RetryManager.ExponentialSchedule;
import com.heyzap.internal.RetryManager.RetryableTask;
import com.heyzap.internal.Utils;
import com.heyzap.internal.VungleTagNormalizer;
import com.heyzap.mediation.MediationResult;
import com.heyzap.mediation.abstr.AdUnitNetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.abstr.NetworkAdapter.ConfigurationError;
import com.heyzap.mediation.adapter.FetchStateManager;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds.Network;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallback;
import com.vungle.publisher.AdConfig;
import com.vungle.publisher.EventListener;
import com.vungle.publisher.Orientation;
import com.vungle.publisher.VunglePub;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class VungleAdapter extends AdUnitNetworkAdapter {
    private final AdUnit AD_UNIT = AdUnit.VIDEO;
    private String appId;
    private DisplayHolder displayHolder;
    private final FetchStateManager<FetchHolder> fetchStateManager = new FetchStateManager();
    private VunglePub vungleSDK;
    private final VungleTagNormalizer vungleTagNormalizer = new VungleTagNormalizer();

    class C15932 extends RetryableTask {
        C15932() {
        }

        public void run() {
            VungleAdapter.this.fetchStateManager.start(VungleAdapter.this.AD_UNIT);
            final FetchHolder holder = (FetchHolder) VungleAdapter.this.fetchStateManager.get(VungleAdapter.this.AD_UNIT);
            new RetryManager(new RetryableTask() {
                public void run() {
                    if (VungleAdapter.this.checkAvailability()) {
                        holder.fetchListener.set(new FetchResult());
                    }
                    if (!holder.fetchListener.isDone()) {
                        retry();
                    }
                }
            }, new DelayedSchedule(1, TimeUnit.SECONDS, new ExponentialSchedule(1.5d, 4, TimeUnit.SECONDS)), VungleAdapter.this.executorService).start();
            holder.fetchListener.addListener(new Runnable() {
                public void run() {
                    FetchResult fetchResult = (FetchResult) FutureUtils.getImmediatelyOrDefault(holder.fetchListener, FetchResult.NOT_READY);
                    if (!fetchResult.success) {
                        VungleAdapter.this.setLastFailure(VungleAdapter.this.AD_UNIT, fetchResult.fetchFailure);
                        VungleAdapter.this.fetchStateManager.set(VungleAdapter.this.AD_UNIT, new FetchHolder());
                        C15932.this.retry();
                    }
                }
            }, VungleAdapter.this.executorService);
        }
    }

    private class AdListener implements EventListener {
        NetworkAdapter adapter;

        public AdListener(NetworkAdapter adapter) {
            this.adapter = adapter;
        }

        public void onAdStart() {
            this.adapter.onCallbackEvent(NetworkCallback.SHOW);
            VungleAdapter.this.displayHolder.displayEventStream.sendEvent(new DisplayResult());
        }

        public void onAdPlayableChanged(boolean adAvailable) {
            if (adAvailable) {
                this.adapter.onCallbackEvent(NetworkCallback.AVAILABLE);
                ((FetchHolder) VungleAdapter.this.fetchStateManager.get(VungleAdapter.this.AD_UNIT)).fetchListener.set(new FetchResult());
            }
        }

        @Deprecated
        public void onVideoView(boolean b, int i, int i1) {
        }

        public void onAdUnavailable(String param) {
            this.adapter.onCallbackEvent(NetworkCallback.FETCH_FAILED);
            FetchHolder wrapper = (FetchHolder) VungleAdapter.this.fetchStateManager.get(VungleAdapter.this.AD_UNIT);
            if (wrapper.fetchListener.isDone() && ((FetchResult) FutureUtils.getImmediatelyOrDefault(wrapper.fetchListener, FetchResult.NOT_READY)).success) {
                Logger.debug("(Vungle) onAdUnavailable - previously available ad has become unavailable, retrying");
                VungleAdapter.this.fetchStateManager.set(VungleAdapter.this.AD_UNIT, new FetchHolder());
                VungleAdapter.this.attemptNextFetch();
                return;
            }
            wrapper.fetchListener.set(new FetchResult(FetchFailureReason.NO_FILL, param));
        }

        public void onAdEnd(boolean wasSuccessfulView, boolean wasCallToActionClicked) {
            if (wasCallToActionClicked) {
                this.adapter.onCallbackEvent("click");
                VungleAdapter.this.displayHolder.clickEventStream.sendEvent(Boolean.valueOf(true));
            }
            if (VungleAdapter.this.displayHolder.adUnit == AdUnit.INCENTIVIZED) {
                this.adapter.onCallbackEvent(wasSuccessfulView ? NetworkCallback.INCENTIVIZED_RESULT_COMPLETE : NetworkCallback.INCENTIVIZED_RESULT_INCOMPLETE);
                VungleAdapter.this.displayHolder.incentiveListener.set(Boolean.valueOf(wasSuccessfulView));
            }
            this.adapter.onCallbackEvent(NetworkCallback.HIDE);
            VungleAdapter.this.displayHolder.closeListener.set(Boolean.valueOf(true));
        }
    }

    private static class DisplayHolder {
        public final AdUnit adUnit;
        public final EventStream<Boolean> clickEventStream;
        public final SettableFuture<Boolean> closeListener;
        public final EventStream<DisplayResult> displayEventStream;
        public final SettableFuture<Boolean> incentiveListener;

        private DisplayHolder(AdUnit adUnit) {
            this.displayEventStream = EventStream.create();
            this.closeListener = SettableFuture.create();
            this.clickEventStream = EventStream.create();
            this.incentiveListener = SettableFuture.create();
            this.adUnit = adUnit;
        }
    }

    private static class FetchHolder {
        public final SettableFuture<FetchResult> fetchListener;

        private FetchHolder() {
            this.fetchListener = SettableFuture.create();
        }
    }

    public boolean isInterstitialVideo() {
        return true;
    }

    public String getCanonicalName() {
        return Network.VUNGLE;
    }

    public Boolean isOnBoard() {
        return Utils.classExists("com.vungle.publisher.VunglePub");
    }

    public String getMarketingName() {
        return "Vungle";
    }

    public String getMarketingVersion() {
        return "VungleDroid/4.0.2";
    }

    public void onInit() throws ConfigurationError {
        this.appId = getConfiguration().getValue("app_id");
        if (this.appId == null) {
            throw new ConfigurationError("Vungle App ID not present.");
        }
        this.vungleSDK = VunglePub.getInstance();
        this.fetchStateManager.set(this.AD_UNIT, new FetchHolder());
        if (Utils.isDebug(getContextRef().getActivity()).booleanValue()) {
            System.setProperty("log.tag.Vungle", "VERBOSE");
            System.setProperty("log.tag.VungleDebug", "VERBOSE");
        }
    }

    protected void onStart() {
        this.vungleSDK.init(getContextRef().getApp(), this.appId);
    }

    public EnumSet<AdUnit> getAllAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.VIDEO, AdUnit.INCENTIVIZED);
    }

    public EnumSet<AdUnit> getConfiguredAdUnitCapabilities() {
        return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.VIDEO, AdUnit.INCENTIVIZED);
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

    public SettableFuture<FetchResult> awaitAvailability(AdUnit adUnit) {
        return ((FetchHolder) this.fetchStateManager.get(this.AD_UNIT)).fetchListener;
    }

    public SettableFuture<FetchResult> startAdUnits(Collection<AdUnit> collection) {
        AdConfig globalAdConfig = this.vungleSDK.getGlobalAdConfig();
        globalAdConfig.setSoundEnabled(true);
        globalAdConfig.setOrientation(Orientation.autoRotate);
        setListener(new AdListener(this));
        attemptNextFetch();
        onCallbackEvent(NetworkCallback.INITIALIZED);
        return ((FetchHolder) this.fetchStateManager.get(this.AD_UNIT)).fetchListener;
    }

    public boolean isAdUnitStarted(Collection<AdUnit> collection) {
        return isStarted();
    }

    public AdDisplay show(MediationRequest mediationRequest, MediationResult mediationResult) {
        AdUnit adUnit = mediationRequest.getAdUnit();
        AdDisplay display = new AdDisplay();
        this.displayHolder = new DisplayHolder(adUnit);
        if (checkAvailability()) {
            AdConfig overrideConfig = new AdConfig();
            if (adUnit.equals(AdUnit.INCENTIVIZED)) {
                overrideConfig.setIncentivized(true);
            }
            String normalizedTag = this.vungleTagNormalizer.normalize(mediationRequest.getTag());
            if (!(normalizedTag.equals(Constants.DEFAULT_TAG) || normalizedTag.equals(""))) {
                overrideConfig.setPlacement(normalizedTag);
            }
            this.vungleSDK.playAd(overrideConfig);
            display.clickEventStream = this.displayHolder.clickEventStream;
            display.closeListener = this.displayHolder.closeListener;
            display.displayEventStream = this.displayHolder.displayEventStream;
            display.incentiveListener = this.displayHolder.incentiveListener;
        } else {
            display.displayEventStream.sendEvent(DisplayResult.NOT_READY);
        }
        this.fetchStateManager.set(this.AD_UNIT, new FetchHolder());
        attemptNextFetch();
        return display;
    }

    private void setListener(EventListener event) {
        try {
            VunglePub.class.getMethod("setEventListener", new Class[]{EventListener.class}).invoke(this.vungleSDK, new Object[]{event});
        } catch (NoSuchMethodException e) {
            try {
                Method method = VunglePub.class.getMethod("setEventListeners", new Class[]{EventListener[].class});
                VunglePub vunglePub = this.vungleSDK;
                Object[] objArr = new Object[1];
                objArr[0] = new EventListener[]{event};
                method.invoke(vunglePub, objArr);
            } catch (Throwable e1) {
                Logger.trace(e1);
            }
        } catch (Throwable e2) {
            Logger.trace(e2);
        }
    }

    private boolean checkAvailability() {
        try {
            return ((Boolean) VunglePub.class.getMethod("isAdPlayable", new Class[0]).invoke(this.vungleSDK, new Object[0])).booleanValue();
        } catch (NoSuchMethodException e) {
            try {
                return ((Boolean) VunglePub.class.getMethod("isCachedAdAvailable", new Class[0]).invoke(this.vungleSDK, new Object[0])).booleanValue();
            } catch (Throwable e1) {
                Logger.trace(e1);
                return false;
            }
        } catch (Throwable e2) {
            Logger.trace(e2);
            return false;
        }
    }

    private void attemptNextFetch() {
        new RetryManager(new C15932(), new ExponentialSchedule(2.0d, 5, TimeUnit.SECONDS), this.executorService).start();
    }

    public List<String> getPermissions() {
        return Arrays.asList(new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public List<String> getActivities() {
        return Arrays.asList(new String[]{"com.vungle.publisher.VideoFullScreenAdActivity", "com.vungle.publisher.MraidFullScreenAdActivity"});
    }

    public boolean onBackPressed() {
        return false;
    }
}
