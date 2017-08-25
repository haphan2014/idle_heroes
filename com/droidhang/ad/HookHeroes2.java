package com.droidhang.ad;

import android.os.Bundle;
import com.appsflyer.AppsFlyerLib;
import com.droidhang.pay.util.PurchaseOnlineActivity;
import com.droidhang.util.AdKeyManager;
import com.droidhang.util.AndroidUtil;
import com.facebook.AppEventsLogger;
import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.IncentivizedAd;

public class HookHeroes2 extends PurchaseOnlineActivity {
    private static String KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsiq9GqDTzxDHsgpZ96zCYFH7vTeK0Tdxltd8FQM4Zu1P6Ueeum1o+cUCrzbVtMeKjxZ/P7zeJCYhCbbM0e1rQJDIl0CkvTWSQH6JPdVe7vTOUhEHWkP4LQxXNE3Gigt+agZ0R33+Shw7J2n2Tk3bPakyj2U2BZPWhyW2uVYTf+lHxGCVkA+0zmBjw5dbMGe3RO/HvK1uhBKPlGN+SptGbaM7y7+vNUE7opLrg6qmB7jsz6hvYmYI4ydJ90uY6g9TsvQH/INteQI2b5veR5GfGgwWZ3ZEmsLexORp2q3TBJJd1/WsTV2hsP/FXI+xyjxtxklXcjgeLcvqJjZGl0k4dwIDAQAB";

    static {
        System.loadLibrary("game");
    }

    public HookHeroes2() {
        super(KEY, 1241);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(128, 128);
        AndroidUtil.init(this);
        AndroidUtil.printKeyHash();
        AppsFlyerLib.getInstance().startTracking(getApplication(), "36FfNk244xi9BCxEURqa5n");
        AdKeyManager.init(this);
        HeyzapAds.start("bee0c6583d95c9e3f461f7b618b78653", this, 1);
        IncentivizedAd.fetch();
    }

    public void onStart() {
        super.onStart();
    }

    protected void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
    }

    protected void onResume() {
        super.onResume();
        AndroidUtil.hideToolbar();
        AppEventsLogger.activateApp(this);
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            AndroidUtil.hideToolbar();
        }
    }
}
