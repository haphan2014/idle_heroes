package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinPostbackListener;

class bu implements AppLovinPostbackListener {
    final /* synthetic */ bv f507a;
    final /* synthetic */ bt f508b;

    bu(bt btVar, bv bvVar) {
        this.f508b = btVar;
        this.f507a = bvVar;
    }

    public void onPostbackFailure(String str, int i) {
        this.f508b.f502b.mo638i("PersistentPostbackManager", "Failed to submit postback with errorCode " + i + ". Will retry later...  Postback: " + this.f507a);
        this.f508b.m451e(this.f507a);
    }

    public void onPostbackSuccess(String str) {
        this.f508b.m450d(this.f507a);
        this.f508b.f502b.mo635d("PersistentPostbackManager", "Successfully submitted postback: " + this.f507a);
        this.f508b.m455b();
    }
}
