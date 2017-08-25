package com.vungle.publisher;

import com.vungle.publisher.vf.C1894b;
import com.vungle.publisher.vf.C1895c;
import com.vungle.publisher.xs.C1624a;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class yt extends xs {
    boolean f3710e;

    @Singleton
    /* compiled from: vungle */
    public static class C1921a extends C1624a<yt> {
        @Inject
        yt f3708g;
        @Inject
        acv f3709h;

        public final /* synthetic */ vf mo4345b() {
            return m2669d();
        }

        public final /* synthetic */ xs mo4347c() {
            return m2669d();
        }

        @Inject
        C1921a() {
        }

        public final yt m2669d() throws rz {
            try {
                if (this.f3708g.f3710e) {
                    return this.f3708g;
                }
                yt ytVar = (yt) super.mo4347c();
                ytVar.f788b = this.d + "config";
                ytVar.f789c.putString("Content-Type", "application/json");
                ytVar.f790d = this.f3709h.m857d();
                return ytVar;
            } catch (Throwable e) {
                throw new rz(e);
            }
        }

        protected final /* bridge */ /* synthetic */ vf mo4346a() {
            return this.f3708g;
        }
    }

    @Inject
    yt() {
    }

    protected final C1894b mo4348a() {
        return C1894b.GET;
    }

    protected final C1895c mo4349b() {
        return C1895c.requestConfig;
    }
}
