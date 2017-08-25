package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class bx implements C0148y, AppLovinNativeAdLoadListener {
    protected final AppLovinSdkImpl f443a;
    protected final AppLovinLogger f444b;
    protected final Object f445c = new Object();
    protected final Map f446d = mo601a();
    protected final Map f447e = new HashMap();
    protected final Set f448f = new HashSet();

    bx(AppLovinSdkImpl appLovinSdkImpl) {
        this.f443a = appLovinSdkImpl;
        this.f444b = appLovinSdkImpl.getLogger();
    }

    private by m347h(C0150c c0150c) {
        return (by) this.f446d.get(c0150c);
    }

    abstract C0150c mo599a(bf bfVar);

    abstract cc mo600a(C0150c c0150c);

    abstract Map mo601a();

    abstract void mo603a(Object obj, bf bfVar);

    abstract void mo604a(Object obj, C0150c c0150c, int i);

    public boolean mo605a(C0150c c0150c, Object obj) {
        boolean z;
        synchronized (this.f445c) {
            if (m363g(c0150c)) {
                z = false;
            } else {
                mo607b(c0150c, obj);
                z = true;
            }
        }
        return z;
    }

    public bf mo606b(C0150c c0150c) {
        bf e;
        synchronized (this.f445c) {
            e = m347h(c0150c).m465e();
        }
        return e;
    }

    void m355b(bf bfVar) {
        mo611f(mo599a(bfVar));
    }

    protected void m356b(C0150c c0150c, int i) {
        this.f444b.mo635d("PreloadManager", "Failed to pre-load an ad of spec " + c0150c + ", error code " + i);
        synchronized (this.f445c) {
            Object remove = this.f447e.remove(c0150c);
            this.f448f.add(c0150c);
        }
        if (remove != null) {
            try {
                mo604a(remove, c0150c, i);
            } catch (Throwable th) {
                this.f443a.getLogger().userError("PreloadManager", "Encountered exception while invoking user callback", th);
            }
        }
    }

    public void mo607b(C0150c c0150c, Object obj) {
        synchronized (this.f445c) {
            if (this.f447e.containsKey(c0150c)) {
                this.f444b.mo641w("PreloadManager", "Possibly missing prior registered preload callback.");
            }
            this.f447e.put(c0150c, obj);
        }
    }

    protected void m358c(bf bfVar) {
        synchronized (this.f445c) {
            C0150c a = mo599a(bfVar);
            Object obj = this.f447e.get(a);
            this.f447e.remove(a);
            this.f448f.add(a);
            if (obj == null) {
                m347h(a).m461a(bfVar);
                this.f444b.mo635d("PreloadManager", "Ad enqueued: " + bfVar);
            } else {
                this.f444b.mo635d("PreloadManager", "Additional callback found, skipping enqueue.");
            }
        }
        if (obj != null) {
            this.f444b.mo635d("PreloadManager", "Called additional callback regarding " + bfVar);
            try {
                mo603a(obj, bfVar);
            } catch (Throwable th) {
                this.f443a.getLogger().userError("PreloadManager", "Encountered throwable while notifying user callback", th);
            }
            m355b(bfVar);
        }
        this.f444b.mo635d("PreloadManager", "Pulled ad from network and saved to preload cache: " + bfVar);
    }

    public boolean mo608c(C0150c c0150c) {
        boolean c;
        synchronized (this.f445c) {
            c = m347h(c0150c).m463c();
        }
        return c;
    }

    public void mo609d(C0150c c0150c) {
        int i = 0;
        if (c0150c != null) {
            int b;
            synchronized (this.f445c) {
                by h = m347h(c0150c);
                b = h != null ? h.m462b() - h.m460a() : 0;
            }
            if (b > 0) {
                while (i < b) {
                    mo611f(c0150c);
                    i++;
                }
            }
        }
    }

    public boolean mo610e(C0150c c0150c) {
        boolean z;
        synchronized (this.f445c) {
            z = !m347h(c0150c).m464d();
        }
        return z;
    }

    public void mo611f(C0150c c0150c) {
        if (((Boolean) this.f443a.m253a(cd.f536A)).booleanValue() && !mo608c(c0150c)) {
            this.f444b.mo635d("PreloadManager", "Preloading ad for spec " + c0150c + "...");
            this.f443a.m252a().m650a(mo600a(c0150c), cz.MAIN, 500);
        }
    }

    boolean m363g(C0150c c0150c) {
        boolean contains;
        synchronized (this.f445c) {
            contains = this.f448f.contains(c0150c);
        }
        return contains;
    }
}
