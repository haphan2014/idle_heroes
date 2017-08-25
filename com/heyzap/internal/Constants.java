package com.heyzap.internal;

import android.text.TextUtils;
import com.google.android.gms.fitness.FitnessStatusCodes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;

public class Constants {
    public static final String DEFAULT_CUSTOM_INFO = "";
    public static String DEFAULT_TAG = "default";
    public static Integer FETCH_DISPLAY_TTL = Integer.valueOf(FitnessStatusCodes.NEEDS_OAUTH_PERMISSIONS);
    public static int MINIMUM_SUPPORTED_SDK_VERSION = 9;
    public static String NEEDED_RECEIVER = "com.heyzap.sdk.ads.PackageAddedReceiver";
    public static final String PREFERENCES_KEY = "com.heyzap.sdk.ads";
    public static String[] REQUIRED_PERMISSIONS = new String[]{"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"};
    public static String SNAKE_PACKAGE = "com.example.android.snake";

    public enum AdUnit {
        UNKNOWN,
        INTERSTITIAL,
        VIDEO,
        INCENTIVIZED,
        NATIVE,
        BANNER;

        public EnumSet<CreativeType> creativeTypes() {
            switch (this) {
                case INTERSTITIAL:
                    return EnumSet.of(CreativeType.STATIC, CreativeType.VIDEO);
                case VIDEO:
                    return EnumSet.of(CreativeType.VIDEO);
                case INCENTIVIZED:
                    return EnumSet.of(CreativeType.INCENTIVIZED);
                case BANNER:
                    return EnumSet.of(CreativeType.BANNER);
                case NATIVE:
                    return EnumSet.of(CreativeType.NATIVE);
                case UNKNOWN:
                    return EnumSet.of(CreativeType.UNKNOWN);
                default:
                    return EnumSet.of(CreativeType.UNKNOWN);
            }
        }
    }

    public enum AuctionType {
        MONETIZATION(0),
        CROSS_PROMO(1);
        
        public int value;

        private AuctionType(int value) {
            this.value = value;
        }

        public String toInt() {
            return String.valueOf(this.value);
        }
    }

    public enum CreativeType {
        UNKNOWN(0),
        STATIC(1),
        VIDEO(2),
        INCENTIVIZED(4),
        BANNER(8),
        NATIVE(16);
        
        public int value;

        public static String requestString(Collection<CreativeType> creativeTypes) {
            ArrayList<String> list = new ArrayList();
            if (creativeTypes.contains(STATIC)) {
                list.add("full_screen_interstitial");
                list.add("interstitial");
            }
            if (creativeTypes.contains(VIDEO)) {
                list.add("interstitial_video");
                list.add("video");
            }
            if (creativeTypes.contains(NATIVE)) {
                list.add("native");
            }
            return TextUtils.join(",", list);
        }

        public static String exchangeRequestString(EnumSet<CreativeType> creativeTypes) {
            ArrayList<String> list = new ArrayList();
            Iterator it = creativeTypes.iterator();
            while (it.hasNext()) {
                list.add(((CreativeType) it.next()).toInt());
            }
            return TextUtils.join(",", list);
        }

        public static CreativeType parseInt(int in) {
            for (CreativeType type : values()) {
                if (type.value == in) {
                    return type;
                }
            }
            return null;
        }

        private CreativeType(int value) {
            this.value = value;
        }

        public String toInt() {
            return String.valueOf(this.value);
        }

        public EnumSet<AdUnit> adUnits() {
            switch (this) {
                case STATIC:
                    return EnumSet.of(AdUnit.INTERSTITIAL);
                case VIDEO:
                    return EnumSet.of(AdUnit.INTERSTITIAL, AdUnit.VIDEO);
                case INCENTIVIZED:
                    return EnumSet.of(AdUnit.INCENTIVIZED);
                case BANNER:
                    return EnumSet.of(AdUnit.BANNER);
                case NATIVE:
                    return EnumSet.of(AdUnit.NATIVE);
                default:
                    return EnumSet.of(AdUnit.UNKNOWN);
            }
        }
    }

    public enum FetchFailureReason {
        UNKNOWN,
        INTERNAL,
        TIMEOUT,
        NO_FILL,
        BAD_CREDENTIALS,
        REMOTE_ERROR,
        CONFIGURATION_ERROR,
        SKIPPED,
        NETWORK_ERROR
    }

    public enum MediationCancellationReason {
        UNKNOWN,
        FETCH_TIMEOUT,
        DISPLAY_TIMEOUT,
        ERROR,
        USER_INITIATED,
        INTERNAL,
        FINISHED
    }

    public enum MediationFetchMode {
        MEDIATION,
        HEYZAP
    }

    public static String normalizeTag(String tag) {
        if (tag == null || tag.trim().equals("")) {
            tag = DEFAULT_TAG;
        }
        return tag.trim();
    }
}
