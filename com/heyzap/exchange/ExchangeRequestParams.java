package com.heyzap.exchange;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.facebook.AppEventsConstants;
import com.google.android.gms.location.places.Place;
import com.heyzap.common.net.Connectivity;
import com.heyzap.common.net.Connectivity.OpenRtbConnectionType;
import com.heyzap.http.RequestParams;
import com.heyzap.internal.Constants.CreativeType;
import com.heyzap.internal.Utils;
import com.heyzap.sdk.ads.DemographicInfo;
import com.heyzap.sdk.ads.DemographicInfo.EducationLevel;
import com.heyzap.sdk.ads.DemographicInfo.Gender;
import com.heyzap.sdk.ads.DemographicInfo.MaritalStatus;
import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.HeyzapAds.BannerOptions;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Map;
import org.nexage.sourcekit.mraid.BuildConfig;

public class ExchangeRequestParams extends RequestParams {
    private static final String APP_BUNDLE = "app_bundle";
    private static final String APP_PLATFORM = "app_platform";
    private static final String APP_SDK_KEY = "app_sdk_key";
    private static final String APP_VERSION = "app_version";
    private static final String BANNER_DIRECTION = "banner_direction";
    private static final String BANNER_H = "banner_h";
    private static final String BANNER_W = "banner_w";
    private static final String DEVICE_CARRIER = "device_carrier";
    private static final String DEVICE_CONNTYPE = "device_connectiontype";
    private static final String DEVICE_DEVICETYPE = "device_devicetype";
    private static final String DEVICE_DNT = "device_dnt";
    private static final String DEVICE_DPI = "device_dpi";
    private static final String DEVICE_H = "device_h";
    private static final String DEVICE_IFA = "device_ifa";
    private static final String DEVICE_LANGUAGE = "device_language";
    private static final String DEVICE_MAKE = "device_make";
    private static final String DEVICE_MODEL = "device_model";
    private static final String DEVICE_ORIENTATION = "device_orientation";
    private static final String DEVICE_OS = "device_os";
    private static final String DEVICE_OSV = "device_osv";
    private static final String DEVICE_SCALE = "device_scale";
    private static final String DEVICE_UA = "device_ua";
    private static final String DEVICE_W = "device_w";
    private static final String IMPRESSION_ADPOSITION = "impression_adpos";
    private static final String IMPRESSION_BIDFLOOR = "impression_bidfloor";
    private static final String IMPRESSION_CREATIVETYPE = "impression_creativetype";
    private static final String IMPRESSION_INSTL = "impression_instl";
    private static final String SDK_ADTYPE = "sdk_adtype";
    private static final String SDK_API = "sdk_api";
    private static final String SDK_VERSION = "sdk_version";
    private static final String VIDEO_DELIVERY = "video_delivery";
    private static final String VIDEO_MIME = "video_mime";
    private static final String VIDEO_ONLY = "video_only";
    private static final String VIDEO_PLAYBACKMETHOD = "video_playbackmethod";
    public Context context;

    public enum APIFramework {
        VPAID_1(1),
        VPAID_2(2),
        MRAID_1(3),
        ORMMA(4),
        MRAID_2(5),
        VAST_1_0(6),
        VAST_2_0(7),
        VAST_3_0(8),
        VAST_1_0_WRAPPER(9),
        VAST_2_0_WRAPPER(10),
        VAST_3_0_WRAPPER(11);
        
        private int value;

        private APIFramework(int value) {
            this.value = value;
        }

        public static APIFramework valueOf(int i) throws IllegalArgumentException {
            for (APIFramework l : values()) {
                if (l.value == i) {
                    return l;
                }
            }
            throw new IllegalArgumentException("Leg not found. Amputated?");
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public enum AdPosition {
        UNKNOWN(0),
        ABOVE_THE_FOLD(1),
        DEPRECATED_LIKELY_BELOW_THE_FOLD(2),
        BELOW_THE_FOLD(3),
        HEADER(4),
        FOOTER(5),
        SIDEBAR(6),
        AD_POSITION_FULLSCREEN(7);
        
        private int value;

        private AdPosition(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public enum BannerAdType {
        XHTML_TEXT_AD(1),
        XHTML_BANNER_AD(2),
        JAVASCRIPT_AD(3),
        IFRAME(4);
        
        private int value;

        private BannerAdType(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public enum ContentDeliveryMethod {
        STREAMING(1),
        PROGRESSIVE(2);
        
        private int value;

        private ContentDeliveryMethod(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public enum DeviceType {
        MOBILE(1),
        PERSONAL_COMPUTER(2),
        CONNECTED_TV(3),
        PHONE(4),
        TABLET(5),
        CONNECTED_DEVICE(6),
        SET_TOP_BOX(7);
        
        private int value;

        private DeviceType(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public enum ExpandableDirection {
        LEFT(1),
        RIGHT(2),
        UP(3),
        DOWN(4),
        EXPANDABLE_FULLSCREEN(5);
        
        private int value;

        private ExpandableDirection(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public enum LocationType {
        GPS_LOCATION(1),
        IP(2),
        USER_PROVIDED(3);
        
        private int value;

        private LocationType(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public enum PlatformType {
        ANDROID(0),
        IOS(1),
        AMAZON(2);
        
        private int value;

        private PlatformType(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public enum VideoLinearity {
        LINEAR(1),
        NON_LINEAR(2);
        
        private int value;

        private VideoLinearity(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public enum VideoPlaybackMethod {
        AUTO_PLAY_SOUND_ON(1),
        AUTO_PLAY_SOUND_OFF(2),
        CLICK_TO_PLAY(3),
        MOUSE_OVER(4);
        
        private int value;

        private VideoPlaybackMethod(int value) {
            this.value = value;
        }

        public String toString() {
            return String.valueOf(this.value);
        }
    }

    private ExchangeRequestParams() {
    }

    private ExchangeRequestParams(Map<String, String> params) {
        super((Map) params);
    }

    public static ExchangeRequestParams create(Context context) {
        ExchangeRequestParams requestParams = new ExchangeRequestParams();
        requestParams.context = context;
        return requestParams.withDeviceInfo().withAppInfo().withSdkInfo().withDemographicInfo(HeyzapAds.getDemographicInfo());
    }

    public static ExchangeRequestParams from(ExchangeRequestParams toClone) {
        return new ExchangeRequestParams(toClone.urlParams);
    }

    private ExchangeRequestParams withSdkInfo() {
        put(SDK_VERSION, "9.11.3");
        put(SDK_API, TextUtils.join(",", new String[]{APIFramework.MRAID_1.toString(), APIFramework.MRAID_2.toString(), APIFramework.VAST_2_0.toString(), APIFramework.VAST_2_0_WRAPPER.toString()}));
        put(SDK_ADTYPE, TextUtils.join(",", new String[]{BannerAdType.JAVASCRIPT_AD.toString(), BannerAdType.XHTML_BANNER_AD.toString()}));
        return this;
    }

    private ExchangeRequestParams withAppInfo() {
        put(APP_BUNDLE, Utils.getPackageName(this.context));
        put(APP_PLATFORM, (Utils.isAmazon() ? PlatformType.AMAZON : PlatformType.ANDROID).toString());
        put(APP_VERSION, getAppVersion(this.context));
        put(APP_SDK_KEY, HeyzapAds.config.publisherId);
        return this;
    }

    private ExchangeRequestParams withDeviceInfo() {
        String operatorName;
        OpenRtbConnectionType connectionType = Connectivity.openRtbConnectionType(this.context);
        put(DEVICE_CONNTYPE, String.valueOf(connectionType));
        TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
        if (connectionType == OpenRtbConnectionType.WIFI) {
            operatorName = "WIFI";
        } else {
            operatorName = String.valueOf(telephonyManager.getNetworkOperator()).toLowerCase(Locale.US);
        }
        put(DEVICE_CARRIER, operatorName);
        put(DEVICE_UA, getUserAgentString());
        put(DEVICE_MAKE, Build.DEVICE);
        put(DEVICE_MODEL, Build.MODEL);
        put(DEVICE_OS, "android");
        put(DEVICE_OSV, String.valueOf(VERSION.SDK_INT));
        put(DEVICE_DEVICETYPE, (Utils.isTablet(this.context) ? DeviceType.TABLET : DeviceType.PHONE).toString());
        put(DEVICE_LANGUAGE, this.context.getResources().getConfiguration().locale.getLanguage().toLowerCase(Locale.US));
        put(DEVICE_IFA, Utils.getAdvertisingId(this.context));
        put(DEVICE_DNT, Utils.getLimitAdTrackingEnabled(this.context).booleanValue() ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        DisplayMetrics dm = this.context.getResources().getDisplayMetrics();
        put(DEVICE_W, String.valueOf(dm.widthPixels));
        put(DEVICE_H, String.valueOf(dm.heightPixels));
        if (dm.widthPixels > dm.heightPixels) {
            put(DEVICE_ORIENTATION, String.valueOf(1));
        } else {
            put(DEVICE_ORIENTATION, String.valueOf(0));
        }
        put(DEVICE_DPI, String.valueOf(dm.densityDpi));
        put(DEVICE_SCALE, String.valueOf(dm.density));
        return this;
    }

    public ExchangeRequestParams withDemographicInfo(DemographicInfo demographicInfo) {
        if (demographicInfo.getUserAgeFromBirthdate() != null) {
            put("user_age", demographicInfo.getUserAgeFromBirthdate());
        }
        if (demographicInfo.getUserGender() != Gender.UNKNOWN) {
            put("user_gender", demographicInfo.getUserGender().code);
        }
        if (demographicInfo.getUserPostalCode() != null) {
            put("user_postal", demographicInfo.getUserPostalCode());
        }
        if (demographicInfo.getUserHouseholdIncome() != null) {
            put("user_hinc", String.valueOf(demographicInfo.getUserHouseholdIncome()));
        }
        if (demographicInfo.getUserMaritalStatus() != MaritalStatus.UNKNOWN) {
            put("user_marital", demographicInfo.getUserMaritalStatus().code);
        }
        if (demographicInfo.getUserEducationLevel() != EducationLevel.UNKNOWN) {
            put("user_edu", demographicInfo.getUserEducationLevel().code);
        }
        if (demographicInfo.getLocation() != null) {
            put("device_lat", String.valueOf(demographicInfo.getLocation().getLatitude()));
            put("device_long", String.valueOf(demographicInfo.getLocation().getLongitude()));
        }
        return this;
    }

    public ExchangeRequestParams withBannerStats(int bannerOrdinal, int bannerRefreshAttempt) {
        put("banner_ordinal", String.valueOf(bannerOrdinal));
        put("banner_refresh_attempt", String.valueOf(bannerRefreshAttempt));
        return this;
    }

    public ExchangeRequestParams asBanner(BannerOptions options) {
        if (options != null && options.getGenericBannerSize() != null) {
            if (options.getGenericBannerSize().getWidth() != -1 || options.getContainerViewSize() == null) {
                put(BANNER_W, String.valueOf(options.getGenericBannerSize().getWidth()));
            } else {
                put(BANNER_W, String.valueOf(options.getContainerViewSize().getWidth()));
            }
            put(BANNER_H, String.valueOf(options.getGenericBannerSize().getHeight()));
        } else if (options == null || options.getContainerViewSize() == null) {
            put(BANNER_W, Integer.valueOf(-1));
            put(BANNER_H, Integer.valueOf(-2));
        } else {
            put(BANNER_W, String.valueOf(options.getContainerViewSize().getWidth()));
            put(BANNER_H, String.valueOf(options.getContainerViewSize().getHeight()));
        }
        put(BANNER_DIRECTION, ExpandableDirection.EXPANDABLE_FULLSCREEN.toString());
        String adPosition = AdPosition.UNKNOWN.toString();
        if (options != null) {
            switch (options.getPosition()) {
                case Place.TYPE_HINDU_TEMPLE /*48*/:
                    adPosition = String.format("%s,%s", new Object[]{AdPosition.ABOVE_THE_FOLD.toString(), AdPosition.HEADER.toString()});
                    break;
                case Place.TYPE_ROOFING_CONTRACTOR /*80*/:
                    adPosition = String.format("%s,%s", new Object[]{AdPosition.ABOVE_THE_FOLD.toString(), AdPosition.FOOTER.toString()});
                    break;
                default:
                    adPosition = AdPosition.ABOVE_THE_FOLD.toString();
                    break;
            }
        }
        put(IMPRESSION_ADPOSITION, adPosition);
        return this;
    }

    public ExchangeRequestParams asInterstitial() {
        put(IMPRESSION_INSTL, Integer.valueOf(1));
        put(IMPRESSION_ADPOSITION, AdPosition.AD_POSITION_FULLSCREEN.toString());
        put(VIDEO_PLAYBACKMETHOD, VideoPlaybackMethod.AUTO_PLAY_SOUND_ON.toString());
        put(VIDEO_DELIVERY, ContentDeliveryMethod.PROGRESSIVE.toString());
        put(VIDEO_MIME, "video/mp4");
        return this;
    }

    public ExchangeRequestParams asVideoOnly() {
        put(VIDEO_ONLY, Integer.valueOf(1));
        return this;
    }

    public ExchangeRequestParams forCreativeTypes(EnumSet<CreativeType> creativeTypes, BannerOptions bannerOptions, boolean coppaEnabled) {
        ExchangeRequestParams params = this;
        if (creativeTypes.contains(CreativeType.BANNER)) {
            params = asBanner(bannerOptions);
        } else {
            asInterstitial();
        }
        if (creativeTypes.contains(CreativeType.VIDEO) || creativeTypes.contains(CreativeType.INCENTIVIZED)) {
            params.asVideoOnly();
        }
        params.put(IMPRESSION_CREATIVETYPE, CreativeType.exchangeRequestString(creativeTypes));
        String str = "coppa_enabled";
        String str2 = (coppaEnabled || (HeyzapAds.config.flags & 64) != 0) ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        params.put(str, str2);
        return params;
    }

    public ExchangeRequestParams withBidFloor(Integer cents) {
        put(IMPRESSION_BIDFLOOR, cents);
        return this;
    }

    private static String getUserAgentString() {
        StringBuilder result = new StringBuilder(64);
        result.append("Dalvik/");
        result.append(System.getProperty("java.vm.version"));
        result.append(" (Linux; U; Android ");
        String version = VERSION.RELEASE;
        if (version.length() <= 0) {
            version = BuildConfig.VERSION_NAME;
        }
        result.append(version);
        if ("REL".equals(VERSION.CODENAME)) {
            String model = Build.MODEL;
            if (model.length() > 0) {
                result.append("; ");
                result.append(model);
            }
        }
        String id = Build.ID;
        if (id.length() > 0) {
            result.append(" Build/");
            result.append(id);
        }
        result.append(")");
        return result.toString();
    }

    private static Integer getAppVersion(Context context) {
        Integer version = Integer.valueOf(0);
        try {
            return Integer.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception e) {
            return Integer.valueOf(0);
        }
    }
}
