package com.applovin.impl.sdk;

import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

class ci {
    private final AppLovinSdkImpl f597a;
    private final Map f598b = new HashMap();

    ci(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f597a = appLovinSdkImpl;
    }

    void m554a() {
        synchronized (this.f598b) {
            this.f598b.clear();
        }
        m562d();
    }

    void m555a(String str) {
        m556a(str, 1);
    }

    void m556a(String str, long j) {
        synchronized (this.f598b) {
            Long l = (Long) this.f598b.get(str);
            if (l == null) {
                l = Long.valueOf(0);
            }
            this.f598b.put(str, Long.valueOf(l.longValue() + j));
        }
        m562d();
    }

    long m557b(String str) {
        long longValue;
        synchronized (this.f598b) {
            Long l = (Long) this.f598b.get(str);
            if (l == null) {
                l = Long.valueOf(0);
            }
            longValue = l.longValue();
        }
        return longValue;
    }

    JSONObject m558b() {
        JSONObject jSONObject;
        synchronized (this.f598b) {
            jSONObject = new JSONObject();
            for (Entry entry : this.f598b.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    void m559b(String str, long j) {
        synchronized (this.f598b) {
            this.f598b.put(str, Long.valueOf(j));
        }
        m562d();
    }

    void m560c() {
        try {
            JSONObject jSONObject = new JSONObject(this.f597a.getSettingsManager().m500a().getString("stats", "{}"));
            synchronized (this.f598b) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String str = (String) keys.next();
                        this.f598b.put(str, Long.valueOf(jSONObject.getLong(str)));
                    } catch (JSONException e) {
                    }
                }
            }
        } catch (Throwable th) {
            this.f597a.getLogger().mo637e("StatsManager", "Unable to load stats", th);
        }
    }

    void m561c(String str) {
        synchronized (this.f598b) {
            this.f598b.remove(str);
        }
        m562d();
    }

    void m562d() {
        try {
            Editor edit = this.f597a.getSettingsManager().m500a().edit();
            edit.putString("stats", m558b().toString());
            edit.commit();
        } catch (Throwable e) {
            this.f597a.getLogger().mo637e("StatsManager", "Unable to save stats", e);
        }
    }
}
