package com.vungle.publisher;

import com.vungle.publisher.vf.C1623a;
import com.vungle.publisher.vf.C1894b;
import com.vungle.publisher.vf.C1895c;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class wy extends vf {
    cu f3548e;
    jt f3549f;

    @Singleton
    /* compiled from: vungle */
    public static class C1903a extends C1623a<wy> {
        @Inject
        C1903a() {
        }

        protected final /* synthetic */ vf mo4346a() {
            return new wy();
        }
    }

    wy() {
    }

    protected final C1895c mo4349b() {
        return C1895c.trackEvent;
    }

    protected final C1894b mo4348a() {
        return C1894b.GET;
    }

    public final String toString() {
        return "{" + C1895c.trackEvent + ": " + this.f788b + "}";
    }
}
