package com.vungle.publisher;

import com.vungle.publisher.cu.C1722c;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ed {
    dy<?> f1723a;

    @Singleton
    /* compiled from: vungle */
    public static class C1741a {
        @Inject
        Provider<ed> f1722a;

        @Inject
        C1741a() {
        }

        public final ed m1560a(dy<?> dyVar) {
            ed edVar = (ed) this.f1722a.get();
            edVar.f1723a = dyVar;
            return edVar;
        }
    }

    @Inject
    ed() {
    }

    public final void m1561a(C1722c c1722c, C1722c c1722c2) {
        if (c1722c2 != c1722c && c1722c2 != C1722c.failed) {
            so.m2470a(2, "VunglePrepare", "resetting prepare_retry_count from " + this.f1723a.m1548i() + " to 0 for " + this.f1723a.m1551z(), null);
            this.f1723a.m1549j();
        }
    }
}
