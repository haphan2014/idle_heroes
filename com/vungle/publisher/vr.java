package com.vungle.publisher;

import android.os.SystemClock;
import com.vungle.publisher.ce.C1713b;
import com.vungle.publisher.vf.C1895c;
import java.util.EnumMap;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class vr {
    public vf f3468a;
    vm f3469b;
    public wx f3470c;
    C1713b f3471d;
    @Inject
    vv f3472e;

    @Singleton
    /* compiled from: vungle */
    public static class C1626a {
        private static final EnumMap<C1895c, C1713b> f816b;
        @Inject
        Provider<vr> f817a;

        static {
            EnumMap enumMap = new EnumMap(C1895c.class);
            f816b = enumMap;
            enumMap.put(C1895c.download, C1713b.downloadLocalAd);
            f816b.put(C1895c.reportAd, C1713b.reportAd);
            f816b.put(C1895c.requestConfig, C1713b.requestConfig);
            f816b.put(C1895c.requestLocalAd, C1713b.requestLocalAd);
            f816b.put(C1895c.requestStreamingAd, C1713b.requestStreamingAd);
            f816b.put(C1895c.sessionEnd, C1713b.sessionEnd);
            f816b.put(C1895c.sessionStart, C1713b.sessionStart);
            f816b.put(C1895c.trackEvent, C1713b.externalNetworkRequest);
            f816b.put(C1895c.trackInstall, C1713b.reportInstall);
            f816b.put(C1895c.unfilledAd, C1713b.unfilledAd);
            f816b.put(C1895c.appFingerprint, C1713b.appFingerprint);
            f816b.put(C1895c.reportExceptions, C1713b.reportExceptions);
        }

        @Inject
        protected C1626a() {
        }

        public final vr m842a(vf vfVar, vm vmVar) {
            wx wxVar = new wx();
            vr vrVar = (vr) this.f817a.get();
            vrVar.f3468a = vfVar;
            vrVar.f3469b = vmVar;
            C1713b c1713b = (C1713b) f816b.get(vfVar.mo4349b());
            if (c1713b == null) {
                so.m2470a(5, "VungleNetwork", "missing mapping for HttpTransaction requestType = " + vfVar.mo4349b().toString(), null);
                c1713b = C1713b.otherTask;
            }
            vrVar.f3471d = c1713b;
            vrVar.f3470c = wxVar;
            return vrVar;
        }
    }

    @Inject
    vr() {
    }

    public final void m2553a() {
        wx wxVar = this.f3470c;
        if (wxVar.f3545a <= 0) {
            wxVar.f3545a = SystemClock.elapsedRealtime();
        }
        wxVar.f3546b++;
        wxVar.f3547c++;
        this.f3469b.m834a(this, this.f3472e.m2561a(this.f3468a));
    }

    public final String toString() {
        return "{" + this.f3468a + ", " + this.f3470c + "}";
    }
}
