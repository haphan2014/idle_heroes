package com.vungle.publisher;

import com.vungle.publisher.ady.C1678a;
import com.vungle.publisher.vf.C1894b;
import com.vungle.publisher.vf.C1895c;
import com.vungle.publisher.xs.C1624a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;

/* compiled from: vungle */
public final class zv extends xs {

    @Singleton
    /* compiled from: vungle */
    public static class C1927a extends C1624a<zv> {
        @Inject
        C1678a f3816g;

        @Inject
        C1927a() {
        }

        protected final zv m2722a(long j) throws JSONException {
            zv zvVar = (zv) mo4347c();
            zvVar.f789c.putString("Content-Type", "application/json");
            zvVar.f788b = this.d + "sessionStart";
            zvVar.f790d = this.f3816g.m1110a(j).m857d();
            return zvVar;
        }

        protected final /* synthetic */ vf mo4346a() {
            return new zv();
        }
    }

    protected zv() {
    }

    protected final C1895c mo4349b() {
        return C1895c.sessionStart;
    }

    protected final C1894b mo4348a() {
        return C1894b.POST;
    }
}
