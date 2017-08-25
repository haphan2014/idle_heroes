package com.vungle.publisher;

import com.vungle.publisher.ce.C1713b;
import javax.inject.Inject;

/* compiled from: vungle */
public abstract class cc {
    @Inject
    protected ce f1443a;

    protected abstract Runnable mo4555a();

    protected cc() {
    }

    protected C1713b mo4556b() {
        return C1713b.otherTask;
    }

    public final void m1238a(long j) {
        this.f1443a.m1246a(mo4555a(), mo4556b(), j);
    }
}
