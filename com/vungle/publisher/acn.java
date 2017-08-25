package com.vungle.publisher;

import com.vungle.publisher.abo.C1645a;
import com.vungle.publisher.abr.C1649a;
import com.vungle.publisher.aej.C1682a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class acn extends abr {
    String f1030s;

    @Singleton
    /* compiled from: vungle */
    public static class C1660a extends C1649a<kt, acn, ky, kd> {
        @Inject
        C1682a f1029g;

        public final /* synthetic */ abr mo4360a(db dbVar) {
            ky kyVar = (ky) dbVar;
            acn com_vungle_publisher_acn = (acn) super.mo4360a(kyVar);
            if (com_vungle_publisher_acn != null) {
                com_vungle_publisher_acn.h = Integer.valueOf(kyVar.f2416w.m1553a());
                com_vungle_publisher_acn.f1030s = kyVar.f2417x;
            }
            return com_vungle_publisher_acn;
        }

        @Inject
        C1660a() {
        }

        protected final C1645a<kt, ?, ?> mo4361c() {
            return this.f1029g;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new acn();
        }
    }

    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    public final JSONObject mo4355a() throws JSONException {
        JSONObject a = super.mo4355a();
        a.putOpt("templateId", this.f1030s);
        return a;
    }
}
