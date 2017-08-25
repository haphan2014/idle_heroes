package com.vungle.publisher;

import com.vungle.publisher.adq.C1669b;
import com.vungle.publisher.aeb.C1640a;
import com.vungle.publisher.aec.C1679a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class ade extends adq {
    public String f1117k;
    public Integer f1118l;
    public String f1119m;

    @Singleton
    /* compiled from: vungle */
    public static class C1670a extends C1669b<ade, C1679a> {
        @Inject
        agg f1106b;
        @Inject
        C1679a f1107c;

        public final /* synthetic */ acr mo4363a(JSONObject jSONObject) throws JSONException {
            return m1048b(jSONObject);
        }

        public final /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
            return m1048b(jSONObject);
        }

        public final /* synthetic */ adq mo4366d(JSONObject jSONObject) throws JSONException {
            return m1048b(jSONObject);
        }

        public final ade m1048b(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            ade com_vungle_publisher_ade = (ade) super.mo4366d(jSONObject);
            com_vungle_publisher_ade.f1117k = sa.m2430d(jSONObject, "postBundle");
            com_vungle_publisher_ade.f1118l = sa.m2429c(jSONObject, "size");
            com_vungle_publisher_ade.f1119m = jSONObject.optString("md5");
            abi.m911a(jSONObject, "md5", com_vungle_publisher_ade.f1119m);
            return com_vungle_publisher_ade;
        }

        protected final /* bridge */ /* synthetic */ C1640a mo4365a() {
            return this.f1107c;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new ade(this.f1106b);
        }
    }

    protected ade(agg com_vungle_publisher_agg) {
        super(com_vungle_publisher_agg);
    }
}
