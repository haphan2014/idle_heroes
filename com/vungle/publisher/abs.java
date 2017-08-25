package com.vungle.publisher;

import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class abs extends aaq {
    public List<gx> f965a;
    @Inject
    pj f966b;
    @Inject
    pq f967c;

    @Singleton
    /* compiled from: vungle */
    public static class C1650a {
        @Inject
        public Provider<abs> f964a;

        @Inject
        C1650a() {
        }
    }

    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4358a();
    }

    @Inject
    abs() {
    }

    public final JSONArray mo4358a() throws JSONException {
        JSONArray a = super.mo4358a();
        for (gx gxVar : this.f965a) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            String[] strArr = gxVar.f2031b;
            Object obj = null;
            if (strArr != null) {
                obj = new JSONArray(Arrays.asList(strArr));
            }
            jSONObject.putOpt("code", Integer.valueOf(gxVar.f2032c));
            jSONObject.putOpt("timestamp", Long.valueOf(gxVar.f2030a));
            jSONObject.putOpt("stack_trace", obj);
            jSONObject.putOpt("tag", gxVar.f2033d);
            jSONObject.putOpt("log_message", gxVar.f2034e);
            jSONObject.putOpt("exception_class", gxVar.f2035f);
            jSONObject.putOpt("platform", "android");
            jSONObject.putOpt("model", this.f966b.mo4430j());
            jSONObject.putOpt("os_version", gxVar.f2036g);
            jSONObject.putOpt("sdk_version", gxVar.f2037h);
            jSONObject.putOpt("app_id", this.f967c.mo4525b());
            jSONObject2.putOpt("play_services_version", gxVar.f2038i);
            jSONObject.putOpt("platform_specific", jSONObject2);
            a.put(jSONObject);
        }
        return a;
    }
}
