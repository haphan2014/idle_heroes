package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import com.applovin.sdk.AppLovinLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class bt {
    private final AppLovinSdkImpl f501a;
    private final AppLovinLogger f502b;
    private ArrayList f503c;
    private ArrayList f504d;
    private final Object f505e;
    private final SharedPreferences f506f;

    bt(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f501a = appLovinSdkImpl;
        this.f502b = appLovinSdkImpl.getLogger();
        this.f506f = appLovinSdkImpl.getApplicationContext().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
        this.f505e = new Object();
        this.f503c = m447c();
        this.f504d = new ArrayList();
    }

    private bv m441a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new bv(this, jSONObject.getString("targetUrl"), be.m385a(jSONObject.getJSONObject("requestBody")), jSONObject.getInt("attemptNumber"));
        } catch (Throwable e) {
            this.f502b.mo642w("PersistentPostbackManager", "Unable to inflate postback request from JSON.", e);
            return null;
        }
    }

    private void m444a(bv bvVar) {
        synchronized (this.f505e) {
            m446b(bvVar);
            m448c(bvVar);
        }
    }

    private void m446b(bv bvVar) {
        synchronized (this.f505e) {
            if (this.f503c.size() < ((Integer) this.f501a.m253a(cd.bg)).intValue()) {
                this.f503c.add(bvVar);
                m449d();
                this.f502b.mo635d("PersistentPostbackManager", "Enqueued postback: " + bvVar);
            } else {
                this.f502b.mo641w("PersistentPostbackManager", "Persistent queue has reached maximum size; postback retried in memory only." + bvVar);
            }
        }
    }

    private ArrayList m447c() {
        if (C0163n.m734b()) {
            Set<String> stringSet = this.f506f.getStringSet("com.applovin.sdk.impl.postbackQueue.key", new LinkedHashSet(0));
            ArrayList arrayList = new ArrayList(Math.max(1, stringSet.size()));
            int intValue = ((Integer) this.f501a.m253a(cd.bh)).intValue();
            this.f502b.mo635d("PersistentPostbackManager", "Deserializing " + stringSet.size() + " postback(s).");
            for (String str : stringSet) {
                bv a = m441a(str);
                if (a == null) {
                    this.f502b.mo636e("PersistentPostbackManager", "Unable to deserialize postback json: " + str);
                } else if (a.m456a() > intValue) {
                    arrayList.add(a);
                } else {
                    this.f502b.mo635d("PersistentPostbackManager", "Skipping deserialization because maximum attempt count exceeded for postback: " + a);
                }
            }
            this.f502b.mo635d("PersistentPostbackManager", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
            return arrayList;
        }
        this.f502b.mo635d("PersistentPostbackManager", "Loading new postback queue due to old Android version...");
        return new ArrayList();
    }

    private void m448c(bv bvVar) {
        this.f502b.mo635d("PersistentPostbackManager", "Preparing to submit postback..." + bvVar);
        synchronized (this.f505e) {
            bvVar.m457a(bvVar.m456a() + 1);
            m449d();
        }
        int intValue = ((Integer) this.f501a.m253a(cd.bh)).intValue();
        if (bvVar.m456a() > intValue) {
            this.f502b.mo641w("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + intValue + ". Dequeuing postback: " + bvVar);
            m450d(bvVar);
            return;
        }
        this.f501a.getPostbackService().dispatchPostbackAsync(bvVar.m458b(), bvVar.m459c(), new bu(this, bvVar));
    }

    private void m449d() {
        if (C0163n.m734b()) {
            Set linkedHashSet = new LinkedHashSet(this.f503c.size());
            Iterator it = this.f503c.iterator();
            while (it.hasNext()) {
                String f = m452f((bv) it.next());
                if (f != null) {
                    linkedHashSet.add(f);
                }
            }
            this.f506f.edit().putStringSet("com.applovin.sdk.impl.postbackQueue.key", linkedHashSet).commit();
            this.f502b.mo635d("PersistentPostbackManager", "Wrote updated postback queue to disk.");
            return;
        }
        this.f502b.mo635d("PersistentPostbackManager", "Skipping writing postback queue to disk due to old Android version...");
    }

    private void m450d(bv bvVar) {
        synchronized (this.f505e) {
            this.f503c.remove(bvVar);
            m449d();
        }
        this.f502b.mo635d("PersistentPostbackManager", "Dequeued successfully transmitted postback: " + bvVar);
    }

    private void m451e(bv bvVar) {
        synchronized (this.f505e) {
            this.f504d.add(bvVar);
        }
    }

    private String m452f(bv bvVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("attemptNumber", bvVar.m456a()).put("targetUrl", bvVar.m458b());
            Map c = bvVar.m459c();
            if (c != null) {
                jSONObject.put("requestBody", new JSONObject(c));
            }
            return jSONObject.toString();
        } catch (Throwable e) {
            this.f502b.mo642w("PersistentPostbackManager", "Unable to serialize postback request to JSON.", e);
            return null;
        }
    }

    public void m453a() {
        synchronized (this.f505e) {
            Iterator it = this.f503c.iterator();
            while (it.hasNext()) {
                m448c((bv) it.next());
            }
        }
    }

    public void m454a(String str, Map map) {
        m444a(new bv(this, str, map));
    }

    public void m455b() {
        synchronized (this.f505e) {
            Iterator it = this.f504d.iterator();
            while (it.hasNext()) {
                m448c((bv) it.next());
            }
            this.f504d.clear();
        }
    }
}
