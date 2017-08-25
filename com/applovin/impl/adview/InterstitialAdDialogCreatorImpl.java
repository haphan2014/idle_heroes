package com.applovin.impl.adview;

import android.app.Activity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.adview.InterstitialAdDialogCreator;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

public class InterstitialAdDialogCreatorImpl implements InterstitialAdDialogCreator {
    private static final Object f115a = new Object();
    private static WeakReference f116b = new WeakReference(null);
    private static WeakReference f117c = new WeakReference(null);

    public AppLovinInterstitialAdDialog createInterstitialAdDialog(AppLovinSdk appLovinSdk, Activity activity) {
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialog;
        if (appLovinSdk == null) {
            appLovinSdk = AppLovinSdk.getInstance(activity);
        }
        synchronized (f115a) {
            appLovinInterstitialAdDialog = (ah) f116b.get();
            if (appLovinInterstitialAdDialog != null && appLovinInterstitialAdDialog.isShowing() && f117c.get() == activity) {
                appLovinSdk.getLogger().mo641w("InterstitialAdDialogCreator", "An interstitial dialog is already showing, returning it");
            } else {
                appLovinInterstitialAdDialog = new ah(appLovinSdk, activity);
                f116b = new WeakReference(appLovinInterstitialAdDialog);
                f117c = new WeakReference(activity);
            }
        }
        return appLovinInterstitialAdDialog;
    }
}
