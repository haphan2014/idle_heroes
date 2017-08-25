package com.vungle.publisher;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class aeh {
    public Map<String, aeg> f1221a;

    @Singleton
    /* compiled from: vungle */
    public static class C1680a extends abi<aeh> {
        protected final /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
            return C1680a.m1137a(jSONObject);
        }

        @Inject
        C1680a() {
        }

        protected static aeh m1137a(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            aeh com_vungle_publisher_aeh = new aeh();
            com_vungle_publisher_aeh.f1221a = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                com_vungle_publisher_aeh.f1221a.put(str, new aeg(str, jSONObject.getJSONObject(str)));
            }
            return com_vungle_publisher_aeh;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new aeh();
        }
    }
}
