package com.vungle.publisher;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class abp extends aar {
    public Float f947a;
    public List<String> f948b;

    @Singleton
    /* compiled from: vungle */
    public static class C1648a extends abi<abp> {
        @Inject
        protected C1648a() {
        }

        protected final /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            abp com_vungle_publisher_abp = new abp();
            com_vungle_publisher_abp.f947a = sa.m2428b(jSONObject, "checkpoint");
            abi.m911a(jSONObject, "checkpoint", com_vungle_publisher_abp.f947a);
            com_vungle_publisher_abp.f948b = sa.m2431e(jSONObject, "urls");
            abi.m911a(jSONObject, "urls", com_vungle_publisher_abp.f948b);
            return com_vungle_publisher_abp;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new abp();
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4353a(int i) {
            return new abp[i];
        }
    }

    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    protected abp() {
    }

    public final JSONObject mo4355a() throws JSONException {
        JSONObject a = super.mo4355a();
        a.putOpt("checkpoint", this.f947a);
        a.putOpt("urls", this.f948b);
        return a;
    }
}
