package com.applovin.adview;

import android.view.View;
import android.view.View.OnClickListener;

class C0116t implements OnClickListener {
    final /* synthetic */ AppLovinInterstitialActivity f79a;

    C0116t(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f79a = appLovinInterstitialActivity;
    }

    public void onClick(View view) {
        this.f79a.dismiss();
    }
}
