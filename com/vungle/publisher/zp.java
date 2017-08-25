package com.vungle.publisher;

import com.vungle.publisher.adv.C1677a;
import com.vungle.publisher.vf.C1894b;
import com.vungle.publisher.vf.C1895c;
import com.vungle.publisher.xs.C1624a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;

/* compiled from: vungle */
public final class zp extends xs {

    @Singleton
    /* compiled from: vungle */
    public static class C1926a extends C1624a<zp> {
        @Inject
        C1677a f3797g;

        @Inject
        C1926a() {
        }

        protected final zp m2713a(long j, long j2) throws JSONException {
            zp zpVar = (zp) mo4347c();
            zpVar.f789c.putString("Content-Type", "application/json");
            zpVar.f788b = this.d + "sessionEnd";
            ady a = this.f3797g.f1182a.m1110a(j);
            adv com_vungle_publisher_adv = new adv();
            com_vungle_publisher_adv.f1184b = a;
            com_vungle_publisher_adv.f1183a = Long.valueOf(j2);
            zpVar.f790d = com_vungle_publisher_adv.m857d();
            return zpVar;
        }

        protected final /* synthetic */ vf mo4346a() {
            return new zp();
        }
    }

    protected zp() {
    }

    protected final C1895c mo4349b() {
        return C1895c.sessionEnd;
    }

    protected final C1894b mo4348a() {
        return C1894b.POST;
    }
}
