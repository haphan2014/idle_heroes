package com.heyzap.internal;

import android.content.Context;
import com.heyzap.internal.AdvertisingIdClient.AdInfo;
import java.util.concurrent.Callable;

class AdvertisingIdCallable implements Callable<Boolean> {
    private Context context;

    public AdvertisingIdCallable(Context context) {
        this.context = context;
    }

    public Boolean call() throws Exception {
        try {
            String id;
            Boolean isLAT = Boolean.valueOf(false);
            try {
                Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                AdInfo gAdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
                Logger.log("Using Google Play Services...");
                id = gAdInfo.getId();
                isLAT = Boolean.valueOf(gAdInfo.isLimitAdTrackingEnabled());
            } catch (Exception e) {
                Logger.log("Using Heyzap Google Play Services Client as fallback...");
                AdInfo adInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
                id = adInfo.getId();
                isLAT = Boolean.valueOf(adInfo.isLimitAdTrackingEnabled());
            }
            Utils.setAdvertisingId(id);
            Utils.setLimitAdTracking(isLAT);
        } catch (Throwable e2) {
            Logger.trace(e2);
            Utils.setAdvertisingId(null);
            Utils.setLimitAdTracking(Boolean.valueOf(false));
        }
        return Boolean.valueOf(true);
    }
}
