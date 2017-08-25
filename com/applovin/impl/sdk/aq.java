package com.applovin.impl.sdk;

import android.app.Activity;
import android.widget.Toast;

public class aq {
    private final AppLovinSdkImpl f422a;
    private final String f423b;
    private final Activity f424c;

    public aq(AppLovinSdkImpl appLovinSdkImpl, Activity activity, String str) {
        this.f422a = appLovinSdkImpl;
        this.f423b = str;
        this.f424c = activity;
    }

    void m323a() {
        this.f424c.runOnUiThread(new ar(this));
    }

    void m324a(String str, Throwable th) {
        this.f422a.getLogger().userError("IncentivizedConfirmationManager", "Unable to show incentivized ad reward dialog. Have you defined com.applovin.adview.AppLovinConfirmationActivity in your manifest?", th);
        Toast.makeText(this.f424c, str, 1).show();
    }

    String m325b() {
        return this.f423b.equals("accepted") ? (String) this.f422a.m253a(cd.f552Q) : this.f423b.equals("quota_exceeded") ? (String) this.f422a.m253a(cd.f553R) : this.f423b.equals("rejected") ? (String) this.f422a.m253a(cd.f554S) : (String) this.f422a.m253a(cd.f555T);
    }
}
