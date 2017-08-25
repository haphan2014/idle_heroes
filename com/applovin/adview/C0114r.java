package com.applovin.adview;

class C0114r implements Runnable {
    final /* synthetic */ int f75a;
    final /* synthetic */ int f76b;
    final /* synthetic */ C0113q f77c;

    C0114r(C0113q c0113q, int i, int i2) {
        this.f77c = c0113q;
        this.f75a = i;
        this.f76b = i2;
    }

    public void run() {
        this.f77c.f74a.f20d.mo636e("AppLovinInterstitialActivity", "Video view error (" + this.f75a + "," + this.f76b + ").");
        this.f77c.f74a.m58i();
    }
}
