package com.vungle.publisher;

import com.vungle.publisher.adk.C1672a;
import com.vungle.publisher.vf.C1894b;
import com.vungle.publisher.vf.C1895c;
import com.vungle.publisher.xs.C1624a;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class zg extends xs {

    @Singleton
    /* compiled from: vungle */
    public static class C1924a extends C1624a<zg> {
        @Inject
        C1672a f3759g;

        @Inject
        C1924a() {
        }

        public final zg m2690a(String str, ab abVar) throws rz {
            try {
                zg zgVar = (zg) super.mo4347c();
                zgVar.f788b = this.d + "requestStreamingAd";
                zgVar.f789c.putString("Content-Type", "application/json");
                zgVar.f790d = this.f3759g.m1070a(str, abVar).m857d();
                return zgVar;
            } catch (Throwable e) {
                throw new rz(e);
            }
        }

        protected final /* synthetic */ vf mo4346a() {
            return new zg();
        }
    }

    protected zg() {
    }

    protected final C1895c mo4349b() {
        return C1895c.requestStreamingAd;
    }

    protected final C1894b mo4348a() {
        return C1894b.GET;
    }
}
