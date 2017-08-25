package com.heyzap.sdk.ads;

import android.app.Activity;
import com.heyzap.internal.Constants;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Logger;
import com.heyzap.mediation.MediationManager;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds.OnIncentiveResultListener;
import com.heyzap.sdk.ads.HeyzapAds.OnStatusListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public final class IncentivizedAd {
    private static AdUnit AD_UNIT = AdUnit.INCENTIVIZED;
    private static final ArrayList<String> CREATIVE_TYPES = new ArrayList(Arrays.asList(new String[]{"video", "interstitial_video"}));
    private static volatile HashMap<String, String> ads = new HashMap();
    private static Integer campaignId = Integer.valueOf(0);
    private static Integer creativeId = Integer.valueOf(0);
    private static String creativeType = null;
    private static Boolean debugEnabled = Boolean.valueOf(false);
    private static long lastDisplayTimeMillis = 0;
    private static volatile HashMap<String, Boolean> loadingAds = new HashMap();
    private static long minimumDisplayIntervalMillis = 5000;

    private IncentivizedAd() {
    }

    public static void fetch(String tag) {
        fetch(tag, MediationManager.getInstance());
    }

    static void fetch(String tag, MediationManager manager) {
        if (HeyzapAds.assertStarted()) {
            manager.fetch(AD_UNIT, tag);
        }
    }

    public static void fetch() {
        fetch(Constants.DEFAULT_TAG);
    }

    public static Boolean isAvailable(String tag) {
        if (HeyzapAds.assertStarted()) {
            return Boolean.valueOf(MediationManager.getInstance().isAvailable(AD_UNIT, tag));
        }
        return Boolean.valueOf(false);
    }

    public static Boolean isAvailable() {
        return isAvailable(Constants.DEFAULT_TAG);
    }

    public static void display(Activity activity, String tag, String customInfo) {
        display(activity, tag, customInfo, MediationManager.getInstance());
    }

    static void display(Activity activity, String tag, String customInfo, MediationManager manager) {
        if (HeyzapAds.assertStarted()) {
            MediationRequest mediationRequest = new MediationRequest(AD_UNIT, tag, activity);
            mediationRequest.setIncentivizedInfo(customInfo);
            manager.display(mediationRequest);
        }
    }

    public static void display(String customInfo, Activity activity) {
        display(activity, Constants.DEFAULT_TAG, customInfo);
    }

    public static void display(Activity activity) {
        display(activity, Constants.DEFAULT_TAG, "");
    }

    public static void display(Activity activity, String tag) {
        display(activity, tag, "");
    }

    public static void setOnStatusListener(OnStatusListener listener) {
        try {
            MediationManager.getInstance().setOnStatusListener(AD_UNIT, listener);
        } catch (Throwable e) {
            Logger.trace(e);
        }
    }

    public static void setOnIncentiveResultListener(OnIncentiveResultListener listener) {
        MediationManager.getInstance().setOnIncentiveResultListener(listener);
    }

    public static void setCreativeId(int cid) {
        creativeId = Integer.valueOf(cid);
    }

    public static void setCampaignId(int cid) {
        campaignId = Integer.valueOf(cid);
    }

    public static void setTargetCreativeType(String type) {
        creativeType = type;
    }
}
