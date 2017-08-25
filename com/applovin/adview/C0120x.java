package com.applovin.adview;

import android.app.Activity;
import com.applovin.impl.adview.InterstitialAdDialogCreatorImpl;
import com.applovin.sdk.AppLovinSdk;

final class C0120x implements Runnable {
    final /* synthetic */ AppLovinSdk f83a;
    final /* synthetic */ Activity f84b;
    final /* synthetic */ String f85c;

    C0120x(AppLovinSdk appLovinSdk, Activity activity, String str) {
        this.f83a = appLovinSdk;
        this.f84b = activity;
        this.f85c = str;
    }

    public void run() {
        new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(this.f83a, this.f84b).show(this.f85c);
    }
}
