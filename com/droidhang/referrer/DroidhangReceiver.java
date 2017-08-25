package com.droidhang.referrer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.droidhang.util.InstallReferrerStatistic;

public class DroidhangReceiver extends BroadcastReceiver {
    private static String promotionTypeOfUser = "natural";

    static boolean isStringEmpty(String s) {
        return s == null || s.length() == 0;
    }

    public static String getPromotionTypeOfUser() {
        return promotionTypeOfUser;
    }

    public void onReceive(Context context, Intent intent) {
        String referrer = intent.getStringExtra("referrer");
        if (!isStringEmpty(referrer)) {
            InstallReferrerStatistic.install(referrer, context);
            Log.e("DroidhangReceiver referrer", "referrer: " + referrer);
            if (referrer.startsWith("utm_source=cross")) {
                promotionTypeOfUser = "dh-cross-promotion";
            } else if (referrer.startsWith("utm_source=dhofferwall")) {
                promotionTypeOfUser = "dh-offerwall";
            } else if (referrer.startsWith("utm_source%3DSponsorPay") || referrer.startsWith("utm_source=SponsorPay")) {
                promotionTypeOfUser = "fyber";
            }
        }
    }
}
