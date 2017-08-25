package com.vungle.publisher;

import com.vungle.publisher.aeb.C1640a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class abc extends aeb {
    protected Map<String, List<String>> f924a;

    @Singleton
    /* compiled from: vungle */
    public static class C1641a extends C1640a<abc> {
        @Inject
        Provider<abc> f923a;

        public final /* synthetic */ aeb mo4357b(JSONObject jSONObject) throws JSONException {
            return m918a(jSONObject);
        }

        protected final /* synthetic */ Object mo4354b() {
            return m917a();
        }

        public final /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
            return m918a(jSONObject);
        }

        @Inject
        C1641a() {
        }

        public final abc m918a(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            abc a = m917a();
            a.f924a = new HashMap();
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                List e = sa.m2431e(jSONObject, str);
                if (!(str == null || e == null)) {
                    a.f924a.put(str, e);
                }
            }
            return a;
        }

        private abc m917a() {
            return (abc) this.f923a.get();
        }
    }

    @Inject
    abc() {
    }

    public final Collection<String> m924c() {
        if (this.f924a != null) {
            return this.f924a.keySet();
        }
        return null;
    }

    public final List<String> m923a(String str) {
        if (this.f924a != null) {
            return (List) this.f924a.get(str);
        }
        return null;
    }
}
