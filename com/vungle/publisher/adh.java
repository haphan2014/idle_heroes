package com.vungle.publisher;

import com.vungle.publisher.abc.C1641a;
import com.vungle.publisher.acr.C1662a;
import com.vungle.publisher.gx.C1778a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class adh extends acr {
    public String f1129k;

    @Singleton
    /* compiled from: vungle */
    public static class C1671a extends C1662a<adh, C1641a> {
        @Inject
        agg f1127b;
        @Inject
        C1778a f1128c;

        public final /* synthetic */ acr mo4363a(JSONObject jSONObject) throws JSONException {
            return m1065b(jSONObject);
        }

        public final /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
            return m1065b(jSONObject);
        }

        @Inject
        C1671a() {
        }

        public final adh m1065b(JSONObject jSONObject) throws JSONException {
            adh com_vungle_publisher_adh = (adh) super.mo4363a(jSONObject);
            if (com_vungle_publisher_adh != null) {
                com_vungle_publisher_adh.f1129k = sa.m2430d(jSONObject, "mraidContent");
            }
            return com_vungle_publisher_adh;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new adh(this.f1127b);
        }
    }

    protected adh(agg com_vungle_publisher_agg) {
        super(com_vungle_publisher_agg);
    }
}
