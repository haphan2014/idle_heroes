package com.applovin.adview;

import android.app.Activity;
import android.util.AttributeSet;
import android.view.View;
import com.applovin.impl.adview.InterstitialAdDialogCreatorImpl;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinInterstitialAd extends View {
    private AppLovinInterstitialAdDialog f43a;

    public AppLovinInterstitialAd(Activity activity, AttributeSet attributeSet) {
        this(activity, attributeSet, 0);
    }

    public AppLovinInterstitialAd(Activity activity, AttributeSet attributeSet, int i) {
        super(activity, attributeSet, i);
        this.f43a = null;
        AppLovinSdk instance = AppLovinSdk.getInstance(activity);
        if (!(instance == null || instance.hasCriticalErrors())) {
            this.f43a = new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(instance, activity);
        }
        setVisibility(8);
    }

    public static AppLovinInterstitialAdDialog create(AppLovinSdk appLovinSdk, Activity activity) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity != null) {
            return new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(appLovinSdk, activity);
        } else {
            throw new IllegalArgumentException("No activity specified");
        }
    }

    public static boolean isAdReadyToDisplay(Activity activity) {
        return AppLovinSdk.getInstance(activity).getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public static void show(Activity activity) {
        show(activity, null);
    }

    public static void show(Activity activity, String str) {
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        AppLovinSdk instance = AppLovinSdk.getInstance(activity);
        if (instance != null && !instance.hasCriticalErrors()) {
            show(instance, activity, str);
        }
    }

    public static void show(AppLovinSdk appLovinSdk, Activity activity, String str) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else {
            activity.runOnUiThread(new C0120x(appLovinSdk, activity, str));
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f43a != null) {
            this.f43a.show();
        }
    }
}
