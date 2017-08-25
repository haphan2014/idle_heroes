package com.vungle.publisher;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
final class abg extends aar {
    protected Map<String, String> f931a;

    @Singleton
    /* compiled from: vungle */
    static class C1642a extends abj<abg> {
        @Inject
        C1642a() {
        }

        protected static abg m928a(Map<String, String> map) {
            if (map != null) {
                Object obj;
                for (Entry value : map.entrySet()) {
                    if (agf.m1219a((String) value.getValue())) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    abg com_vungle_publisher_abg = new abg();
                    com_vungle_publisher_abg.f931a = new HashMap(map);
                    return com_vungle_publisher_abg;
                }
            }
            return null;
        }

        protected static abg m929b(Map<String, dd> map) {
            if (map != null) {
                Object obj;
                for (Entry value : map.entrySet()) {
                    if (agf.m1219a(((dd) value.getValue()).f1633c)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    abg com_vungle_publisher_abg = new abg();
                    Map hashMap = new HashMap();
                    com_vungle_publisher_abg.f931a = hashMap;
                    for (dd ddVar : map.values()) {
                        hashMap.put(ddVar.f1632b, ddVar.f1633c);
                    }
                    return com_vungle_publisher_abg;
                }
            }
            return null;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new abg();
        }
    }

    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    abg() {
    }

    public final JSONObject mo4355a() throws JSONException {
        return (this.f931a == null || this.f931a.isEmpty()) ? null : new JSONObject(this.f931a);
    }
}
