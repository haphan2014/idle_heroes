package com.vungle.publisher;

import javax.inject.Inject;

/* compiled from: vungle */
public class qa implements qj {
    private boolean f1340a;
    @Inject
    public qh f1341v;

    @Inject
    protected qa() {
    }

    public final void m1181d() {
        if (this.f1340a) {
            so.m2470a(5, "VungleEvent", getClass().getName() + " already listening", null);
            return;
        }
        so.m2470a(3, "VungleEvent", getClass().getName() + " listening", null);
        this.f1341v.m2362b(this);
        this.f1340a = true;
    }

    public final void mo4376e() {
        if (this.f1340a) {
            so.m2470a(5, "VungleEvent", getClass().getName() + " already listening sticky", null);
            return;
        }
        so.m2470a(3, "VungleEvent", getClass().getName() + " listening sticky", null);
        this.f1341v.f3008a.registerSticky(this);
        this.f1340a = true;
    }

    public final void mo4377f() {
        so.m2470a(3, "VungleEvent", getClass().getName() + " unregistered", null);
        this.f1341v.f3008a.unregister(this);
        this.f1340a = false;
    }

    public final void m1184g() {
        if (this.f1340a) {
            so.m2470a(2, "VungleEvent", getClass().getName() + " already listening", null);
            return;
        }
        so.m2470a(3, "VungleEvent", getClass().getName() + " listening", null);
        this.f1341v.m2362b(this);
        this.f1340a = true;
    }
}
