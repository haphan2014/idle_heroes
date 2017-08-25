package com.vungle.publisher;

import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: vungle */
public final class acv extends aar {
    @Inject
    pj f1061a;
    @Inject
    pq f1062b;

    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    @Inject
    acv() {
    }

    public final JSONObject mo4355a() throws JSONException {
        JSONObject a = super.mo4355a();
        a.putOpt("pubAppId", this.f1062b.mo4525b());
        a.putOpt("ifa", this.f1061a.mo4423a());
        a.putOpt("isu", this.f1061a.mo4426c());
        return a;
    }
}
