package com.vungle.publisher;

import com.vungle.publisher.ady.C1678a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class adv extends aar {
    public Long f1183a;
    public ady f1184b;

    @Singleton
    /* compiled from: vungle */
    public static class C1677a {
        @Inject
        public C1678a f1182a;

        @Inject
        C1677a() {
        }
    }

    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    public final JSONObject mo4355a() throws JSONException {
        JSONObject a = this.f1184b == null ? super.mo4355a() : this.f1184b.mo4355a();
        aas.m855a("end", this.f1183a);
        a.put("end", this.f1183a);
        return a;
    }
}
