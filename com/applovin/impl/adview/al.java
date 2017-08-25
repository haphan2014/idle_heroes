package com.applovin.impl.adview;

class al implements Runnable {
    final /* synthetic */ int f153a;
    final /* synthetic */ ah f154b;

    al(ah ahVar, int i) {
        this.f154b = ahVar;
        this.f153a = i;
    }

    public void run() {
        if (this.f154b.f137g != null) {
            this.f154b.f137g.failedToReceiveAd(this.f153a);
        }
    }
}
