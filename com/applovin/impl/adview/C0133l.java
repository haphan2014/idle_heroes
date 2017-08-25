package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdUpdateListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

class C0133l implements AppLovinAdLoadListener, AppLovinAdUpdateListener {
    private final WeakReference f197a;
    private final AppLovinAdService f198b;
    private final AppLovinLogger f199c;

    C0133l(AdViewControllerImpl adViewControllerImpl, AppLovinSdk appLovinSdk) {
        if (adViewControllerImpl == null) {
            throw new IllegalArgumentException("No view specified");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            this.f197a = new WeakReference(adViewControllerImpl);
            this.f199c = appLovinSdk.getLogger();
            this.f198b = appLovinSdk.getAdService();
        }
    }

    public void adReceived(AppLovinAd appLovinAd) {
        AdViewControllerImpl adViewControllerImpl = (AdViewControllerImpl) this.f197a.get();
        if (adViewControllerImpl != null) {
            adViewControllerImpl.m122a(appLovinAd);
        } else {
            this.f199c.userError("AppLovinAdView", "Ad view has been garbage collected by the time an ad was recieved");
        }
    }

    public void adUpdated(AppLovinAd appLovinAd) {
        AdViewControllerImpl adViewControllerImpl = (AdViewControllerImpl) this.f197a.get();
        if (adViewControllerImpl != null) {
            adViewControllerImpl.m122a(appLovinAd);
            return;
        }
        this.f198b.removeAdUpdateListener(this, appLovinAd.getSize());
        this.f199c.userError("AppLovinAdView", "Ad view has been garbage collected by the time an ad was updated");
    }

    public void failedToReceiveAd(int i) {
        AdViewControllerImpl adViewControllerImpl = (AdViewControllerImpl) this.f197a.get();
        if (adViewControllerImpl != null) {
            adViewControllerImpl.m121a(i);
        }
    }

    public String toString() {
        return "[AdViewController listener: " + hashCode() + "]";
    }
}
