package com.vungle.publisher;

import com.vungle.publisher.abo.C1645a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class aef extends abo {
    protected Integer f1217d;

    /* compiled from: vungle */
    public static abstract class C1652a<P extends da<?, P, E>, E extends dc<P>> extends C1645a<P, E, aef> {
        protected final /* synthetic */ abo mo4359a(da daVar) {
            return m966b(daVar);
        }

        protected C1652a() {
        }

        private aef m966b(P p) {
            aef com_vungle_publisher_aef = (aef) super.mo4359a((da) p);
            if (com_vungle_publisher_aef != null) {
                try {
                    com_vungle_publisher_aef.f1217d = p.f1584a.m1424p();
                } catch (NullPointerException e) {
                    so.m2470a(5, "VungleProtocol", "null play report parent", null);
                }
                com_vungle_publisher_aef.a = p.f1585b;
            }
            return com_vungle_publisher_aef;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new aef();
        }
    }

    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    aef() {
    }

    public final JSONObject mo4355a() throws JSONException {
        JSONObject a = super.mo4355a();
        a.putOpt("videoLength", this.f1217d);
        a.putOpt("videoViewed", this.a);
        return a;
    }
}
