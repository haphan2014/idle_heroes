package com.applovin.impl.adview;

import android.support.v4.view.ViewCompat;
import android.view.Window;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.impl.sdk.dp;
import com.applovin.sdk.AppLovinAd;

class ab implements Runnable {
    final /* synthetic */ AppLovinAd f122a;
    final /* synthetic */ String f123b;
    final /* synthetic */ C0143x f124c;

    ab(C0143x c0143x, AppLovinAd appLovinAd, String str) {
        this.f124c = c0143x;
        this.f122a = appLovinAd;
        this.f123b = str;
    }

    public void run() {
        this.f124c.f243e.renderAd(this.f122a, this.f123b);
        if (((AppLovinAdImpl) this.f122a).isAccelerateHardware()) {
            Window window = this.f124c.getWindow();
            if (window != null) {
                window.setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
            }
        }
        if (((AppLovinAdImpl) this.f122a).isCloseButtonHidden()) {
            this.f124c.f241c.mo635d("InterstitialAdDialog", "Skip showing of close button");
            return;
        }
        this.f124c.m214a(((AppLovinAdImpl) this.f122a).getCloseButtonStyle());
        float closeDelay = ((AppLovinAdImpl) this.f122a).getCloseDelay();
        if (closeDelay > 0.0f) {
            this.f124c.m213a(dp.m707c(closeDelay));
            return;
        }
        this.f124c.f245g.setVisibility(0);
        this.f124c.f245g.setClickable(true);
    }
}
