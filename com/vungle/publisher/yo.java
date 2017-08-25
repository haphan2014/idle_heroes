package com.vungle.publisher;

import com.vungle.publisher.ce.C1713b;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class yo extends cc {
    @Inject
    C1920a f3698b;

    @Singleton
    /* compiled from: vungle */
    static class C1920a implements Runnable {
        @Inject
        xp f3697a;

        @Inject
        C1920a() {
        }

        public final void run() {
            this.f3697a.m2612a();
        }
    }

    @Inject
    yo() {
    }

    protected final C1713b mo4556b() {
        return C1713b.requestConfig;
    }

    protected final Runnable mo4555a() {
        return this.f3698b;
    }
}
