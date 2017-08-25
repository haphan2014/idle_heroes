package com.applovin.adview;

class C0111o implements Runnable {
    final /* synthetic */ int f70a;
    final /* synthetic */ int f71b;
    final /* synthetic */ C0110n f72c;

    C0111o(C0110n c0110n, int i, int i2) {
        this.f72c = c0110n;
        this.f70a = i;
        this.f71b = i2;
    }

    public void run() {
        this.f72c.f69a.f68a.f20d.mo636e("AppLovinInterstitialActivity", "Media player error (" + this.f70a + "," + this.f71b + ").");
        this.f72c.f69a.f68a.m58i();
    }
}
