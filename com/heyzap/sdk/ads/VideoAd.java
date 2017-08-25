package com.heyzap.sdk.ads;

import android.app.Activity;
import com.heyzap.internal.Constants;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.DevLogger;
import com.heyzap.internal.Logger;
import com.heyzap.mediation.MediationManager;
import com.heyzap.mediation.request.MediationRequest;
import com.heyzap.sdk.ads.HeyzapAds.OnStatusListener;

public final class VideoAd {
    private static AdUnit AD_UNIT = AdUnit.VIDEO;

    private VideoAd() {
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

    public static Boolean isAvailable() {
        return isAvailable(Constants.DEFAULT_TAG);
    }

    public static Boolean isAvailable(String tag) {
        if (HeyzapAds.assertStarted()) {
            return Boolean.valueOf(MediationManager.getInstance().isAvailable(AD_UNIT, tag));
        }
        return Boolean.valueOf(false);
    }

    public static void display(Activity activity, String tag) {
        display(activity, tag, MediationManager.getInstance());
    }

    static void display(Activity activity, String tag, MediationManager manager) {
        if (!HeyzapAds.assertStarted()) {
            return;
        }
        if (MediationManager.getInstance().adsTimedOut()) {
            DevLogger.info("Ads disabled because of an IAP");
        } else {
            manager.display(new MediationRequest(AD_UNIT, tag, activity));
        }
    }

    public static void display(Activity activity) {
        display(activity, Constants.DEFAULT_TAG);
    }

    public static void setOnStatusListener(OnStatusListener listener) {
        try {
            MediationManager.getInstance().setOnStatusListener(AD_UNIT, listener);
        } catch (Throwable e) {
            Logger.trace(e);
        }
    }

    public static void setCreativeId(int cid) {
    }

    public static void setCampaignId(int cid) {
    }

    public static void setTargetCreativeType(String type) {
    }
}
