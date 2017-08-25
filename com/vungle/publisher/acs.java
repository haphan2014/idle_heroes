package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.acr.C1662a;
import com.vungle.publisher.aeb.C1640a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class acs extends acr {
    public boolean f1054k;
    public JSONObject f1055l;

    @Singleton
    /* compiled from: vungle */
    public static class C1663a extends C1662a<acs, C1640a<?>> {
        @Inject
        agg f1052b;
        @Inject
        C1892a f1053c;

        public final /* synthetic */ acr mo4363a(JSONObject jSONObject) throws JSONException {
            return m1011b(jSONObject);
        }

        public final /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
            return m1011b(jSONObject);
        }

        @Inject
        C1663a() {
        }

        private acs m1011b(JSONObject jSONObject) throws JSONException {
            acs com_vungle_publisher_acs = (acs) super.mo4363a(jSONObject);
            com_vungle_publisher_acs.f1055l = jSONObject;
            com_vungle_publisher_acs.f1054k = com_vungle_publisher_acs.m1010b() == null;
            return com_vungle_publisher_acs;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new acs(this.f1052b);
        }
    }

    protected acs(agg com_vungle_publisher_agg) {
        super(com_vungle_publisher_agg);
    }
}
