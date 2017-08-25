package com.applovin.impl.adview;

class ag implements Runnable {
    final /* synthetic */ C0143x f129a;

    private ag(C0143x c0143x) {
        this.f129a = c0143x;
    }

    public void run() {
        try {
            this.f129a.dismiss();
        } catch (Throwable th) {
            if (this.f129a.f241c != null) {
                this.f129a.f241c.mo637e("InterstitialAdDialog", "dismiss() threw exception", th);
            }
        }
    }
}
