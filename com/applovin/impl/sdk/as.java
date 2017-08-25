package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.util.Timer;

class as {
    private final AppLovinSdkImpl f426a;
    private final ab f427b;
    private Activity f428c;
    private AppLovinAdDisplayListener f429d;
    private AppLovinAdVideoPlaybackListener f430e;
    private AppLovinAdClickListener f431f;
    private AppLovinAdRewardListener f432g;
    private final Timer f433h = new Timer("IncentivizedAdLauncher");

    as(AppLovinSdkImpl appLovinSdkImpl, ab abVar) {
        this.f426a = appLovinSdkImpl;
        this.f427b = abVar;
    }

    private void m328b() {
        this.f427b.m306a(this.f428c, this.f432g, this.f430e, this.f429d, this.f431f);
    }

    void m333a() {
        this.f428c.runOnUiThread(new at(this));
    }

    public void m334a(Activity activity) {
        this.f428c = activity;
    }

    public void m335a(AppLovinAdClickListener appLovinAdClickListener) {
        this.f431f = appLovinAdClickListener;
    }

    public void m336a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f429d = appLovinAdDisplayListener;
    }

    public void m337a(AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f432g = appLovinAdRewardListener;
    }

    public void m338a(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f430e = appLovinAdVideoPlaybackListener;
    }
}
