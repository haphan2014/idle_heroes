package com.vungle.publisher;

import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class ady extends aar {
    String f1191a;
    String f1192b;
    String f1193c;
    Long f1194d;

    @Singleton
    /* compiled from: vungle */
    public static class C1678a {
        @Inject
        pj f1189a;
        @Inject
        pq f1190b;

        @Inject
        C1678a() {
        }

        public final ady m1110a(long j) {
            ady com_vungle_publisher_ady = new ady();
            com_vungle_publisher_ady.f1191a = this.f1189a.mo4423a();
            com_vungle_publisher_ady.f1192b = this.f1189a.mo4426c();
            com_vungle_publisher_ady.f1193c = this.f1190b.mo4525b();
            com_vungle_publisher_ady.f1194d = Long.valueOf(j);
            return com_vungle_publisher_ady;
        }
    }

    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    ady() {
    }

    public final JSONObject mo4355a() throws JSONException {
        JSONObject a = super.mo4355a();
        a.putOpt("ifa", this.f1191a);
        a.putOpt("isu", this.f1192b);
        aas.m855a("pubAppId", this.f1193c);
        a.put("pubAppId", this.f1193c);
        aas.m855a("start", this.f1194d);
        a.put("start", this.f1194d);
        return a;
    }
}
