package com.applovin.impl.sdk;

class af implements Runnable {
    final /* synthetic */ int f389a;
    final /* synthetic */ ad f390b;

    af(ad adVar, int i) {
        this.f390b = adVar;
        this.f389a = i;
    }

    public void run() {
        this.f390b.f386b.failedToReceiveAd(this.f389a);
    }
}
