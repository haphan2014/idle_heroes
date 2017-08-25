package com.vungle.publisher;

import com.vungle.publisher.abc.C1641a;
import com.vungle.publisher.acr.C1662a;
import com.vungle.publisher.aeh.C1680a;
import com.vungle.publisher.aen.C1683a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class ads extends acr {
    public JSONObject f1170k;
    public aeh f1171l;
    public String f1172m;
    public String f1173n;

    @Singleton
    /* compiled from: vungle */
    public static class C1676a extends C1662a<ads, C1641a> {
        @Inject
        agg f1166b;
        @Inject
        C1683a f1167c;
        @Inject
        C1680a f1168d;
        @Inject
        C1641a f1169e;

        public final /* synthetic */ acr mo4363a(JSONObject jSONObject) throws JSONException {
            return m1101b(jSONObject);
        }

        public final /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
            return m1101b(jSONObject);
        }

        @Inject
        C1676a() {
        }

        public final ads m1101b(JSONObject jSONObject) throws JSONException {
            ads com_vungle_publisher_ads = (ads) super.mo4363a(jSONObject);
            if (com_vungle_publisher_ads != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("templateSettings");
                if (optJSONObject != null) {
                    com_vungle_publisher_ads.f1170k = optJSONObject.optJSONObject("normal_replacements");
                    com_vungle_publisher_ads.f1171l = C1680a.m1137a(optJSONObject.optJSONObject("cacheable_replacements"));
                }
                com_vungle_publisher_ads.f1173n = sa.m2430d(jSONObject, "templateId");
                com_vungle_publisher_ads.f1172m = sa.m2430d(jSONObject, "templateURL");
                com_vungle_publisher_ads.d = this.f1169e.m918a(jSONObject.optJSONObject("tpat"));
            }
            return com_vungle_publisher_ads;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new ads(this.f1166b);
        }
    }

    protected ads(agg com_vungle_publisher_agg) {
        super(com_vungle_publisher_agg);
    }
}
