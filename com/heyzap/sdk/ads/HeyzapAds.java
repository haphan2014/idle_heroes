package com.heyzap.sdk.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.widget.Toast;
import com.heyzap.common.concurrency.ExecutorPool;
import com.heyzap.common.concurrency.SettableFuture;
import com.heyzap.common.net.APIClient;
import com.heyzap.house.Manager;
import com.heyzap.house.handler.AttributionHandler;
import com.heyzap.http.AsyncHttpResponseHandler;
import com.heyzap.http.RequestParams;
import com.heyzap.internal.Constants;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Constants.FetchFailureReason;
import com.heyzap.internal.DevLogger;
import com.heyzap.internal.DeveloperErrorMessages;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import com.heyzap.mediation.MediationManager;
import com.heyzap.mediation.abstr.NetworkAdapter;
import com.heyzap.mediation.config.ConfigLoader.MediationConfigListener;
import com.heyzap.mediation.config.MediationConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

public class HeyzapAds {
    public static final int AMAZON = 4;
    public static final int CHILD_DIRECTED_ADVERTISING = 64;
    public static final int DISABLE_AUTOMATIC_FETCH = 1;
    public static final int DISABLE_MEDIATION = 8;
    public static final int INSTALL_TRACKING_ONLY = 2;
    public static final int NATIVE_ADS_ONLY = 32;
    public static final int NONE = 0;
    public static final AdsConfig config = new AdsConfig();
    public static DemographicInfo demographicInfo = new DemographicInfo();
    @Nullable
    public static String framework = null;
    public static String frameworkVersion = null;
    static AtomicReference<SettableFuture> initializationFuture = new AtomicReference();
    private static boolean intentionallyDisabled = false;
    @Nullable
    public static String mediator = null;
    public static final int minimumSdkVersion = 9;
    private static boolean thirdPartyVerboseLogging = false;

    public interface OnStatusListener {
        void onAudioFinished();

        void onAudioStarted();

        void onAvailable(String str);

        void onClick(String str);

        void onFailedToFetch(String str);

        void onFailedToShow(String str);

        void onHide(String str);

        void onShow(String str);
    }

    public interface OnIncentiveResultListener {
        void onComplete(String str);

        void onIncomplete(String str);
    }

    public interface NetworkCallbackListener {
        void onNetworkCallback(String str, String str2);
    }

    public interface BannerListener {
        void onAdClicked(BannerAdView bannerAdView);

        void onAdError(BannerAdView bannerAdView, BannerError bannerError);

        void onAdLoaded(BannerAdView bannerAdView);
    }

    public interface BannerError {
        FetchFailureReason getErrorCode();

        String getErrorMessage();
    }

    public static class AdsConfig {
        public int flags;
        public String publisherId;
        public Long startTime;
        public String store = "google";
    }

    public static class CreativeSize {
        public static final int AUTO_HEIGHT = -2;
        public static final CreativeSize BANNER = new CreativeSize(320, 50);
        public static final CreativeSize BANNER_320_50 = new CreativeSize(320, 50);
        public static final CreativeSize BANNER_HEIGHT_50 = new CreativeSize(-1, 50);
        public static final CreativeSize BANNER_HEIGHT_90 = new CreativeSize(-1, 90);
        public static final CreativeSize BANNER_RECTANGLE_250 = new CreativeSize(-1, 250);
        public static final CreativeSize FULLSCREEN = new CreativeSize(-1, -1);
        public static final CreativeSize FULL_BANNER = new CreativeSize(468, 60);
        public static final int FULL_WIDTH = -1;
        public static final CreativeSize LARGE_BANNER = new CreativeSize(320, 100);
        public static final CreativeSize LEADERBOARD = new CreativeSize(728, 90);
        public static final CreativeSize MEDIUM_RECTANGLE = new CreativeSize(300, 250);
        public static final CreativeSize SMART_BANNER = new CreativeSize(-1, -2);
        public static final CreativeSize WIDE_SKYSCRAPER = new CreativeSize(160, 600);
        private int height = 50;
        private int width = 320;

        public CreativeSize(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }

        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if (!(other instanceof CreativeSize)) {
                return false;
            }
            CreativeSize otherAdSize = (CreativeSize) other;
            if (this.width == otherAdSize.width && this.height == otherAdSize.height) {
                return true;
            }
            return false;
        }

        public String toString() {
            return String.format("<CreativeSize %dx%d>", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)});
        }
    }

    @Deprecated
    public static class BannerAdSize extends CreativeSize {
        public BannerAdSize(int width, int height) {
            super(width, height);
        }
    }

    public static class BannerOptions {
        private CreativeSize admobBannerSize = CreativeSize.SMART_BANNER;
        private CreativeSize containerViewSize = null;
        private CreativeSize facebookBannerSize = CreativeSize.SMART_BANNER;
        private CreativeSize genericBannerSize = CreativeSize.SMART_BANNER;
        private int position = 80;

        protected BannerOptions(BannerOptions b) {
            this.facebookBannerSize = b.facebookBannerSize;
            this.admobBannerSize = b.admobBannerSize;
            this.genericBannerSize = b.genericBannerSize;
            this.containerViewSize = b.containerViewSize;
            this.position = b.position;
        }

        public CreativeSize getFacebookBannerSize() {
            return this.facebookBannerSize;
        }

        public CreativeSize getAdmobBannerSize() {
            return this.admobBannerSize;
        }

        public CreativeSize getGenericBannerSize() {
            return this.genericBannerSize;
        }

        public BannerOptions setFacebookBannerSize(CreativeSize facebookBannerSize) {
            this.facebookBannerSize = facebookBannerSize;
            return this;
        }

        public BannerOptions setAdmobBannerSize(CreativeSize admobBannerSize) {
            this.admobBannerSize = admobBannerSize;
            return this;
        }

        public BannerOptions setGenericBannerSize(CreativeSize genericBannerSize) {
            this.genericBannerSize = genericBannerSize;
            return this;
        }

        protected BannerOptions setContainerViewSize(CreativeSize containerViewSize) {
            this.containerViewSize = containerViewSize;
            return this;
        }

        public CreativeSize getContainerViewSize() {
            return this.containerViewSize;
        }

        protected void setPosition(int position) {
            this.position = position;
        }

        public int getPosition() {
            return this.position;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            BannerOptions that = (BannerOptions) o;
            if (this.admobBannerSize == null ? that.admobBannerSize != null : !this.admobBannerSize.equals(that.admobBannerSize)) {
                return false;
            }
            if (this.facebookBannerSize == null ? that.facebookBannerSize != null : !this.facebookBannerSize.equals(that.facebookBannerSize)) {
                return false;
            }
            if (this.genericBannerSize == null ? that.genericBannerSize != null : !this.genericBannerSize.equals(that.genericBannerSize)) {
                return false;
            }
            if (this.position != that.position) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int result;
            int i = 0;
            if (this.facebookBannerSize != null) {
                result = this.facebookBannerSize.hashCode();
            } else {
                result = 0;
            }
            int i2 = result * 31;
            if (this.admobBannerSize != null) {
                i = this.admobBannerSize.hashCode();
            }
            return i2 + i;
        }
    }

    public static final class Framework {
        public static final String AIR = "air";
        public static final String CORDOVA = "cordova";
        public static final String UNITY = "unity3d";
    }

    public interface NativeError {
        FetchFailureReason getErrorCode();

        String getErrorMessage();
    }

    public static final class Network {
        public static final String ADCOLONY = "adcolony";
        public static final String ADMOB = "admob";
        public static final String APPLOVIN = "applovin";
        public static final String CHARTBOOST = "chartboost";
        public static final String FACEBOOK = "facebook";
        public static final String HEYZAP = "heyzap";
        public static final String HYPRMX = "hyprmx";
        public static final String IAD = "iad";
        public static final String INMOBI = "inmobi";
        public static final String UNITYADS = "unityads";
        public static final String VUNGLE = "vungle";
    }

    public static final class NetworkCallback {
        public static final String AUDIO_FINISHED = "audio_finished";
        public static final String AUDIO_STARTING = "audio_starting";
        public static final String AVAILABLE = "available";
        public static final String BANNER_CLICK = "banner-click";
        public static final String BANNER_DISMISS = "banner-dismiss";
        public static final String BANNER_FETCH_FAILED = "banner-fetch_failed";
        public static final String BANNER_HIDE = "banner-hide";
        public static final String BANNER_LOADED = "banner-loaded";
        public static final String CHARTBOOST_MOREAPPS_AVAILABLE = "moreapps-available";
        public static final String CHARTBOOST_MOREAPPS_CLICK = "moreapps-click";
        public static final String CHARTBOOST_MOREAPPS_CLICK_FAILED = "moreapps-click_failed";
        public static final String CHARTBOOST_MOREAPPS_DISMISS = "moreapps-dismiss";
        public static final String CHARTBOOST_MOREAPPS_FETCH_FAILED = "moreapps-fetch_failed";
        public static final String CHARTBOOST_MOREAPPS_HIDE = "moreapps-hide";
        public static final String CHARTBOOST_MOREAPPS_SHOW = "moreapps-show";
        public static final String CLICK = "click";
        public static final String DISMISS = "dismiss";
        public static final String DISPLAY_FAILED = "display_failed";
        public static final String FACEBOOK_LOGGING_IMPRESSION = "logging_impression";
        public static final String FETCH_FAILED = "fetch_failed";
        public static final String HIDE = "hide";
        public static final String INCENTIVIZED_RESULT_COMPLETE = "incentivized_result_complete";
        public static final String INCENTIVIZED_RESULT_INCOMPLETE = "incentivized_result_incomplete";
        public static final String INITIALIZED = "initialized";
        public static final String LEAVE_APPLICATION = "leave_application";
        public static final String SHOW = "show";
    }

    public static void start(String publisherId, Activity activity, int flags, OnStatusListener listener) {
        internalStart(publisherId, activity, flags, listener);
    }

    public static void startTestActivity(final Activity activity) {
        if (!hasStarted()) {
            DevLogger.error(DeveloperErrorMessages.HEYZAP_NOT_STARTED);
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(activity, "You must call HeyzapAds.start() first", 1).show();
                }
            });
        } else if (Utils.activityExistsInPackage(activity, MediationTestActivity.class)) {
            activity.startActivity(new Intent(activity, MediationTestActivity.class));
        } else {
            DevLogger.error(DeveloperErrorMessages.TEST_ACTIVITY_NOT_PRESENT);
        }
    }

    public static void setNetworkCallbackListener(NetworkCallbackListener listener) {
        MediationManager.getInstance().setNetworkCallbackListener(listener);
    }

    public static boolean isNetworkInitialized(String network) {
        NetworkAdapter adapter = MediationManager.getInstance().getConfigLoader().getPool().get(network);
        if (adapter == null) {
            return false;
        }
        return adapter.isInitialized();
    }

    private static void internalStart(final String publisherId, Context context, int flags, OnStatusListener listener) {
        if (initializationFuture.compareAndSet(null, SettableFuture.create())) {
            try {
                config.flags = flags;
                config.startTime = Long.valueOf(System.currentTimeMillis());
                if (context instanceof Activity) {
                    if (!Utils.activityExistsInPackage((Activity) context, HeyzapInterstitialActivity.class) || !Utils.activityExistsInPackage((Activity) context, HeyzapVideoActivity.class)) {
                        DevLogger.error(DeveloperErrorMessages.ACTIVITIES_NOT_PRESENT);
                        intentionallyDisabled = true;
                        ((SettableFuture) initializationFuture.get()).set(Boolean.valueOf(false));
                        return;
                    } else if (Utils.packageHasPermissions((Activity) context, new ArrayList(Arrays.asList(Constants.REQUIRED_PERMISSIONS)))) {
                        if (!Utils.packageHasReceiver((Activity) context, Constants.NEEDED_RECEIVER).booleanValue()) {
                            DevLogger.warn(DeveloperErrorMessages.RECEIVER_NOT_PRESENT);
                        }
                        if (!Utils.probablyHasGooglePlayServices((Activity) context).booleanValue()) {
                            DevLogger.warn(DeveloperErrorMessages.GPS_NOT_INSTALLED);
                        }
                    } else {
                        DevLogger.error(DeveloperErrorMessages.PERMISSIONS_NOT_PRESENT);
                        intentionallyDisabled = true;
                        ((SettableFuture) initializationFuture.get()).set(Boolean.valueOf(false));
                        return;
                    }
                }
                if (VERSION.SDK_INT < Constants.MINIMUM_SUPPORTED_SDK_VERSION) {
                    DevLogger.error(DeveloperErrorMessages.UNSUPPORTED_ANDROID_SDK_VERSION);
                    intentionallyDisabled = true;
                    ((SettableFuture) initializationFuture.get()).set(Boolean.valueOf(false));
                    return;
                }
                Manager.applicationContext = context.getApplicationContext();
                Utils.load(context);
                Logger.init(context);
                if ((flags & 4) == 4 || Utils.isAmazon()) {
                    config.store = "amazon";
                    DevLogger.info("App is running in Amazon AppStore mode. Amazon version of app will provide credentials and configuration.");
                }
                config.publisherId = publisherId;
                AttributionHandler.getInstance().doSelfInstallOnce(context);
                if ((flags & 2) > 0) {
                    intentionallyDisabled = true;
                    ((SettableFuture) initializationFuture.get()).set(Boolean.valueOf(false));
                    return;
                }
                if (listener != null) {
                    MediationManager.getInstance().setOnStatusListener(AdUnit.INTERSTITIAL, listener);
                    MediationManager.getInstance().setOnStatusListener(AdUnit.VIDEO, listener);
                    MediationManager.getInstance().setOnStatusListener(AdUnit.INCENTIVIZED, listener);
                }
                MediationManager.getInstance().start(context);
                ExecutorPool.getInstance().execute(new Runnable() {
                    public void run() {
                        Manager.start(MediationManager.getInstance().getContextRef(), publisherId);
                    }
                });
                ((SettableFuture) initializationFuture.get()).set(Boolean.valueOf(true));
            } catch (RuntimeException e) {
                DevLogger.error(String.format(DeveloperErrorMessages.HEYZAP_RUNTIME_EXCEPTION, new Object[]{e.getMessage()}));
                intentionallyDisabled = true;
                initializationFuture.set(null);
                throw e;
            }
        }
    }

    public static void start(String publisherId, Activity activity, int flags) {
        start(publisherId, activity, flags, null);
    }

    public static void start(String publisherId, Activity activity) {
        start(publisherId, activity, 0, null);
    }

    public static void start(String publisherId, Context context, int flags, OnStatusListener listener) {
        if ((flags & 8) == 0 && (flags & 32) == 0) {
            DevLogger.warn(DeveloperErrorMessages.HEYZAP_BAD_CONTEXT);
        } else {
            internalStart(publisherId, context.getApplicationContext(), flags, listener);
        }
    }

    public static boolean hasStarted() {
        if (intentionallyDisabled) {
            return false;
        }
        SettableFuture future = (SettableFuture) initializationFuture.get();
        if (future == null || !future.isDone()) {
            return false;
        }
        return true;
    }

    public static boolean assertStarted() {
        if (hasStarted()) {
            return true;
        }
        if (intentionallyDisabled) {
            return false;
        }
        DevLogger.warn(DeveloperErrorMessages.HEYZAP_NOT_STARTED);
        return false;
    }

    public static void changeActivity(Activity activity) {
        MediationManager.getInstance().setRecentActivity(activity);
    }

    public static void setBundleId(String bundleId) {
        if (initializationFuture.get() == null || bundleId.equals(Utils.packageName) || "unknown".equals(Utils.packageName)) {
            Utils.packageName = bundleId;
        } else {
            DevLogger.error("HeyzapAds.setBundleId() cannot be called after HeyzapAds.start()");
            throw new RuntimeException("HeyzapAds.setBundleId() cannot be called after HeyzapAds.start()");
        }
    }

    public static String getVersion() {
        return "9.11.3";
    }

    public static void pauseExpensiveWork() {
        MediationManager.getInstance().getPauseExpensiveWorkSignal().pause();
    }

    public static void resumeExpensiveWork() {
        MediationManager.getInstance().getPauseExpensiveWorkSignal().resume();
    }

    public static void slowClose(Boolean slowClose) {
        Manager.SLOW_CLOSE = slowClose;
    }

    public static void setThirdPartyVerboseLogging(boolean in) {
        thirdPartyVerboseLogging = in;
    }

    public static boolean isThirdPartyVerboseLogging() {
        return thirdPartyVerboseLogging;
    }

    public static JSONObject getRemoteData() {
        try {
            return new JSONObject(((MediationConfig) MediationManager.getInstance().getConfigLoader().getFuture().get(0, TimeUnit.SECONDS)).getCustomPublisherData());
        } catch (JSONException e) {
            Logger.error("The remote data is not a valid JSONObject");
            return new JSONObject();
        } catch (Throwable e2) {
            Logger.trace(e2);
            return new JSONObject();
        }
    }

    public static boolean onBackPressed() {
        if (!hasStarted()) {
            return false;
        }
        Future<MediationConfig> configFuture = MediationManager.getInstance().getConfigLoader().getFuture();
        if (!configFuture.isDone()) {
            return false;
        }
        boolean changedSomething = false;
        try {
            for (NetworkAdapter adapter : ((MediationConfig) configFuture.get()).getAdapterPool().getAll()) {
                changedSomething = adapter.onBackPressed();
                if (changedSomething) {
                    return changedSomething;
                }
            }
            return changedSomething;
        } catch (Exception e) {
            return false;
        }
    }

    public static void setDemographicInfo(DemographicInfo demographics) {
        if (demographicInfo == null) {
            demographics = new DemographicInfo();
        } else {
            demographicInfo = demographicInfo;
        }
    }

    public static DemographicInfo getDemographicInfo() {
        return demographicInfo;
    }

    public static void setLocation(final Location location) {
        MediationManager.getInstance().getConfigLoader().get(new MediationConfigListener() {
            public void onConfigLoaded(MediationConfig config) {
                config.getLocationProvider().setLocation(location);
            }
        });
        demographicInfo.setLocationWithoutProviderUpdate(location);
    }

    public static void onPurchaseComplete(String name, String id, int usdPriceCents) {
        if (assertStarted()) {
            Future<MediationConfig> future = MediationManager.getInstance().getConfigLoader().getFuture();
            if (future.isDone()) {
                try {
                    MediationManager.getInstance().setAdsTimeout(((MediationConfig) future.get()).getIapAdDisableTime());
                } catch (Throwable e) {
                    Logger.trace(e);
                } catch (Throwable e2) {
                    Logger.trace(e2);
                } catch (Throwable e22) {
                    Logger.trace(e22);
                }
            }
            final RequestParams params = new RequestParams();
            params.put("usd_price_cents", Integer.valueOf(usdPriceCents));
            params.put("name", name);
            params.put("iap_id", id);
            ExecutorPool.getInstance().execute(new Runnable() {

                class C14721 extends AsyncHttpResponseHandler {
                    C14721() {
                    }

                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    }

                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    }
                }

                public void run() {
                    APIClient.post(MediationManager.getInstance().getContextRef().getApp(), "/in_game_api/metrics/iap", params, new C14721());
                }
            });
        }
    }

    @Deprecated
    public static void setOnStatusListener(OnStatusListener listener) {
        MediationManager.getInstance().setOnStatusListener(AdUnit.INTERSTITIAL, listener);
        MediationManager.getInstance().setOnStatusListener(AdUnit.VIDEO, listener);
        MediationManager.getInstance().setOnStatusListener(AdUnit.INCENTIVIZED, listener);
    }

    @Deprecated
    public static void setOnIncentiveResultListener(OnIncentiveResultListener listener) {
        MediationManager.getInstance().setOnIncentiveResultListener(listener);
    }

    public static void changeServer(String url) {
        Manager.AD_SERVER = url;
    }

    public static int getFlags() {
        return config.flags;
    }

    public static void shutdown() {
        intentionallyDisabled = true;
    }

    private HeyzapAds() {
    }
}
