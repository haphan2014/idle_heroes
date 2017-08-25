package com.vungle.publisher;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.vungle.publisher.C1821m.C18152;
import com.vungle.publisher.ce.C1713b;
import com.vungle.publisher.cq.C17161;
import com.vungle.publisher.inject.EndpointModule;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.mx.C1823a;
import com.vungle.publisher.mx.C1823a.C18221;
import com.vungle.publisher.rs.C1871a;
import dagger.internal.Preconditions;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: vungle */
public abstract class C1620k {
    public static final String VERSION = "VungleDroid/4.1.0";
    @Inject
    C1821m f757a;
    @Inject
    C1763f f758b;
    @Inject
    qq f759c;
    @Inject
    cq f760d;
    @Inject
    C1707b f761e;
    @Inject
    protected pj f762f;
    @Inject
    qh f763g;
    @Inject
    AdConfig f764h;
    @Inject
    ac f765i;
    @Inject
    pr f766j;
    @Inject
    pu f767k;
    @Inject
    pl f768l;
    @Inject
    C1823a f769m;
    private boolean f770n;

    protected C1620k() {
    }

    public boolean init(Context context, String vungleAppId) {
        Object obj = 1;
        boolean c = Injector.getInstance().m1976c();
        if (c) {
            try {
                so.m2470a(3, "Vungle", "already initialized", null);
                return c;
            } catch (Throwable e) {
                Throwable th = e;
                r0 = c;
                r1 = th;
                so.m2471a("Vungle", "VunglePub initialization failed", r1);
                return r0;
            }
        }
        boolean z;
        if (VERSION.SDK_INT < 11) {
            so.m2470a(5, "VungleDevice", "Device Android API level " + VERSION.SDK_INT + " does not meet required minimum 11", null);
            obj = null;
        }
        if (obj != null) {
            if (Injector.getInstance().m1976c()) {
                so.m2470a(3, "Vungle", "already injected", null);
            } else {
                Injector instance = Injector.getInstance();
                try {
                    if (instance.m1976c()) {
                        so.m2470a(3, "VungleInject", "already initialized", null);
                    } else {
                        so.m2470a(3, "VungleInject", "initializing", null);
                        ra a = instance.m1975a();
                        if (a.f3049g) {
                            so.m2470a(3, "VungleInject", "publisher module already initialized", null);
                        } else {
                            so.m2470a(3, "VungleInject", "initializing publisher module", null);
                            a.f3043a = context.getApplicationContext();
                            a.f3044b = vungleAppId;
                            a.f3049g = true;
                        }
                        C1871a a2 = rs.m2407a();
                        a2.f3097a = (ra) Preconditions.checkNotNull(instance.m1975a());
                        if (instance.f2181a == null) {
                            instance.f2181a = new EndpointModule();
                        }
                        a2.f3099c = (EndpointModule) Preconditions.checkNotNull(instance.f2181a);
                        if (instance.f2182b == null) {
                            instance.f2182b = new rv();
                        }
                        a2.f3098b = (rv) Preconditions.checkNotNull(instance.f2182b);
                        if (a2.f3097a == null) {
                            a2.f3097a = new ra();
                        }
                        if (a2.f3098b == null) {
                            a2.f3098b = new rv();
                        }
                        if (a2.f3099c == null) {
                            a2.f3099c = new EndpointModule();
                        }
                        instance.f2183c = new rs(a2);
                    }
                } catch (Throwable e2) {
                    so.m2471a("VungleInject", "error initializing injector", e2);
                }
                Injector.m1974b().mo4528a(this);
                so.m2470a(3, "Vungle", "injection successful", null);
                this.f770n = true;
            }
            if (mo4336a(context)) {
                so.m2470a(4, "Vungle", "VungleDroid/4.1.0 init(" + vungleAppId + ")", null);
                qq qqVar = this.f759c;
                so.m2470a(3, "VungleFile", "deleting old ad temp directory", null);
                qq.m2366a((String) qqVar.f3021b.get());
                this.f758b.m1181d();
                cq cqVar = this.f760d;
                cqVar.f1521d.m1245a(new C17161(cqVar), C1713b.databaseWrite);
                this.f762f.mo4435o();
                C1823a c1823a = this.f769m;
                ch chVar = c1823a.f2598c;
                chVar.f1490a.post(new C18221(c1823a, context));
                z = Injector.getInstance().m1976c();
                try {
                    so.m2470a(2, "Vungle", "initialization successful", null);
                    return z;
                } catch (Exception e3) {
                    Throwable th2;
                    th2 = e3;
                    so.m2471a("Vungle", "VunglePub initialization failed", th2);
                    return z;
                }
            }
            so.m2470a(5, "Vungle", "initialization failed", null);
        }
        return c;
    }

    private static boolean m803a(boolean z, String str) {
        boolean c = Injector.getInstance().m1976c();
        if (c) {
            so.m2470a(2, "Vungle", "VunglePub was initialized", null);
        } else if (z) {
            so.m2470a(5, "Vungle", "Please call VunglePub.init() before " + str, null);
        }
        return c;
    }

    private boolean m802a(String str) {
        if (!this.f770n) {
            so.m2470a(3, "Vungle", "Error in " + str + ": VunglePub not injected", null);
        }
        return this.f770n;
    }

    public C1707b getDemographic() {
        m802a("getDemographic()");
        return this.f761e;
    }

    public void addEventListeners(EventListener... eventListeners) {
        try {
            if (m802a("addEventListeners()")) {
                this.f766j.m2342a(eventListeners);
            }
        } catch (Throwable e) {
            so.m2471a("Vungle", "error adding event listeners", e);
        }
    }

    public void setEventListeners(EventListener... eventListeners) {
        try {
            if (m802a("setEventListeners()")) {
                pr prVar = this.f766j;
                prVar.m2341a();
                prVar.m2342a(eventListeners);
            }
        } catch (Throwable e) {
            so.m2471a("Vungle", "error setting event listeners", e);
        }
    }

    public void clearEventListeners() {
        try {
            if (m802a("clearEventListener()")) {
                this.f766j.m2341a();
            }
        } catch (Throwable e) {
            so.m2471a("Vungle", "error clearing event listeners", e);
        }
    }

    public void removeEventListeners(EventListener... eventListeners) {
        try {
            if (m802a("removeEventListeners()")) {
                pr prVar = this.f766j;
                if (eventListeners != null) {
                    for (Object obj : eventListeners) {
                        Object obj2;
                        qj qjVar = (qj) prVar.f2916a.remove(obj);
                        if (qjVar != null) {
                            obj2 = 1;
                        } else {
                            obj2 = null;
                        }
                        if (obj2 != null) {
                            so.m2470a(3, "VungleConfig", "removing event listener " + obj, null);
                            qjVar.mo4377f();
                        } else {
                            so.m2470a(3, "VungleConfig", "event listener not found for remove " + obj, null);
                        }
                    }
                }
            }
        } catch (Throwable e) {
            so.m2471a("Vungle", "error removing event listeners", e);
        }
    }

    public AdConfig getGlobalAdConfig() {
        try {
            m802a("getGlobalAdConfig()");
        } catch (Throwable e) {
            so.m2471a("Vungle", "error getting globalAdConfig", e);
        }
        return this.f764h;
    }

    public void onResume() {
        try {
            if (C1620k.m803a(false, "onResume()")) {
                pu puVar = this.f767k;
                so.m2470a(3, "VungleAd", "onDeveloperActivityResume()", null);
                puVar.m2349a(true);
            }
        } catch (Throwable e) {
            so.m2471a("Vungle", "error onResume()", e);
        }
    }

    public void onPause() {
        try {
            if (C1620k.m803a(false, "onPause()")) {
                pu puVar = this.f767k;
                so.m2470a(3, "VungleAd", "onDeveloperActivityPause()", null);
                puVar.m2350b();
            }
        } catch (Throwable e) {
            so.m2471a("Vungle", "error onPause()", e);
        }
    }

    public boolean isAdPlayable() {
        boolean z = false;
        try {
            if (C1620k.m803a(true, "isAdPlayable()")) {
                z = this.f757a.m2157a();
            }
        } catch (Throwable e) {
            so.m2471a("Vungle", "error returning ad playable", e);
        }
        return z;
    }

    public void playAd() {
        playAd(null);
    }

    public void playAd(AdConfig adConfig) {
        try {
            so.m2470a(3, "VungleAd", "VunglePub.playAd()", null);
            if (mo4335a()) {
                C1821m c1821m = this.f757a;
                AdConfig[] adConfigArr = new AdConfig[]{this.f764h, adConfig};
                C1639y[] c1639yArr = new C1639y[2];
                int i = 0;
                int i2 = 0;
                while (i < 2) {
                    int i3;
                    AdConfig adConfig2 = adConfigArr[i];
                    if (adConfig2 != null) {
                        i3 = i2 + 1;
                        c1639yArr[i2] = adConfig2.getDelegateAdConfig();
                    } else {
                        i3 = i2;
                    }
                    i++;
                    i2 = i3;
                }
                c1821m.f2535g.m1245a(new C18152(c1821m, new ab(c1639yArr)), C1713b.otherTask);
            }
        } catch (Throwable e) {
            so.m2471a("VungleAd", "error playing ad", e);
            if (this.f770n) {
                this.f763g.m2361a(new bt());
            }
        }
    }

    protected boolean mo4335a() {
        boolean z = false;
        if (C1620k.m803a(true, "playAd()")) {
            pl plVar = this.f768l;
            if (!plVar.m2334a()) {
                plVar.v.m2361a(new bv((int) ((SystemClock.elapsedRealtime() - plVar.m2335b()) / 1000), plVar.m2336c()));
            } else if (plVar.f2903d.compareAndSet(false, true)) {
                z = true;
            } else {
                so.m2470a(3, "VungleAd", "ad already playing", null);
                plVar.v.m2361a(new br());
            }
            if (z) {
                plVar.m1181d();
            }
        } else if (this.f770n) {
            this.f763g.m2361a(new bu());
        }
        return z;
    }

    protected boolean mo4336a(Context context) {
        Iterable arrayList = new ArrayList();
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            arrayList.add("android.permission.INTERNET");
        }
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        }
        if (!age.m1211a(context)) {
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (arrayList.size() > 0) {
            so.m2470a(6, "Vungle", "Make sure to add <uses-permission> for \"" + agf.m1215a(", ", arrayList) + "\" in your AndroidManifest.xml? AND request if revoked in the runtime, which might be possible on Android Marshmallow (API 23) and above.", null);
        }
        return ((String[]) arrayList.toArray(new String[arrayList.size()])).length == 0;
    }
}
