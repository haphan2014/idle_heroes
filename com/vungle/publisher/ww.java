package com.vungle.publisher;

/* compiled from: vungle */
public final class ww implements Runnable {
    private final vr f3544a;

    public ww(vr vrVar) {
        this.f3544a = vrVar;
    }

    public final void run() {
        try {
            so.m2470a(3, "VungleNetwork", "executing " + this.f3544a, null);
            this.f3544a.m2553a();
        } catch (Throwable e) {
            so.m2471a("VungleNetwork", "error processing transaction: " + this.f3544a, e);
        }
    }
}
