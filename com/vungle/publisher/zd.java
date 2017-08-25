package com.vungle.publisher;

import com.vungle.publisher.ada.C1666a;
import com.vungle.publisher.vf.C1894b;
import com.vungle.publisher.vf.C1895c;
import com.vungle.publisher.xs.C1624a;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class zd extends xs {
    ada f3748e;

    @Singleton
    /* compiled from: vungle */
    public static class C1923a extends C1624a<zd> {
        @Inject
        C1666a f3747g;

        public final /* synthetic */ vf mo4345b() {
            return m2684d();
        }

        public final /* synthetic */ xs mo4347c() {
            return m2684d();
        }

        @Inject
        C1923a() {
        }

        public final zd m2684d() throws rz {
            try {
                zd zdVar = (zd) super.mo4347c();
                zdVar.f788b = this.d + "requestAd";
                zdVar.f789c.putString("Content-Type", "application/json");
                ada d = this.f3747g.m1031d();
                zdVar.f3748e = d;
                zdVar.f790d = d.m857d();
                return zdVar;
            } catch (Throwable e) {
                throw new rz(e);
            }
        }

        protected final /* synthetic */ vf mo4346a() {
            return new zd();
        }
    }

    protected zd() {
    }

    protected final C1895c mo4349b() {
        return C1895c.requestLocalAd;
    }

    protected final C1894b mo4348a() {
        return C1894b.GET;
    }
}
