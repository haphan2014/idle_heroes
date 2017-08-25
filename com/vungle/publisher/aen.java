package com.vungle.publisher;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class aen extends aar {
    Map<String, String> f1231a;

    @Singleton
    /* compiled from: vungle */
    public static class C1683a extends abi<aen> {
        @Inject
        C1683a() {
        }

        protected final /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            aen com_vungle_publisher_aen = new aen();
            com_vungle_publisher_aen.f1231a = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                com_vungle_publisher_aen.f1231a.put(str, sa.m2430d(jSONObject, str));
            }
            return com_vungle_publisher_aen;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new aen();
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4353a(int i) {
            return new aen[i];
        }
    }
}
