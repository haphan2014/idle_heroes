package com.vungle.publisher;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import com.google.android.gms.drive.DriveFile;
import com.vungle.publisher.aft.C1704a;
import com.vungle.publisher.jw.C1798a;
import com.vungle.publisher.oc.C1844a;
import com.vungle.publisher.oq.C1853a;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ov extends ni<jv<?, ?, ?>> {
    @Inject
    C1857a f2845k;
    @Inject
    C1704a f2846l;
    @Inject
    C1853a f2847m;
    @Inject
    C1844a f2848n;
    private oq f2849o;
    private oc f2850p;

    @Singleton
    /* compiled from: vungle */
    public static class C1858a extends mv<ov> {

        @Singleton
        /* compiled from: vungle */
        public static class C1857a {
            @Inject
            C1858a f2844a;

            @Inject
            C1857a() {
            }

            public final C1858a m2307a(ov ovVar) {
                this.f2844a.a = ovVar;
                return this.f2844a;
            }
        }

        @Inject
        C1858a() {
        }

        public final void onEvent(ai event) {
            boolean z;
            C1798a c1798a = event.f1414a;
            so.m2470a(2, "VungleEvent", "cta click event: " + c1798a, null);
            ov ovVar = (ov) this.a;
            try {
                String s = ((jv) ovVar.a).m1749s();
                so.m2470a(2, "VungleAd", "call to action destination " + s, null);
                if (s != null) {
                    Intent a = agc.m1209a("android.intent.action.VIEW", Uri.parse(s));
                    a.addFlags(DriveFile.MODE_READ_ONLY);
                    ovVar.g.m2361a(new aj(ovVar.a, c1798a));
                    ovVar.b.startActivity(a);
                }
                z = true;
            } catch (Throwable e) {
                ovVar.h.m1865a("VungleAd", "error loading call-to-action URL " + null, e);
                z = false;
            }
            ovVar.m2208a(z, true);
        }

        public final void onEvent(bg bgVar) {
            so.m2470a(2, "VungleEvent", "video.onCancel()", null);
            ((ov) this.a).m2311c();
        }

        public final void onEvent(bh bhVar) {
            so.m2470a(2, "VungleEvent", "video.onNext()", null);
            ((ov) this.a).m2311c();
        }

        public final void onEvent(at atVar) {
            so.m2470a(2, "VungleEvent", "postRoll.onCancel()", null);
            ((ov) this.a).m2208a(true, false);
        }
    }

    public final /* synthetic */ void mo4516a(C1618d c1618d, cu cuVar, C1617z c1617z, Bundle bundle) {
        int i = 10;
        boolean z = true;
        jv jvVar = (jv) cuVar;
        try {
            so.m2470a(3, "VungleAd", "create video ad", null);
            c1618d.getWindow().setBackgroundDrawable(new ColorDrawable(ViewCompat.MEASURED_STATE_MASK));
            super.mo4516a(c1618d, jvVar, c1617z, bundle);
            ju u = jvVar.m1751u();
            Orientation orientation = c1617z.getOrientation();
            switch (orientation) {
                case autoRotate:
                    so.m2470a(3, "VungleAd", "ad orientation " + orientation, null);
                    break;
                default:
                    boolean z2;
                    if (u.f1830g == null || u.f1837n == null || u.f1837n.intValue() <= u.f1830g.intValue()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        if (u.f1830g == null || u.f1837n == null || u.f1830g.intValue() <= u.f1837n.intValue()) {
                            z = false;
                        }
                        if (!z) {
                            so.m2470a(3, "VungleAd", "ad orientation " + orientation + " (unknown) --> auto-rotate", null);
                            break;
                        }
                        so.m2470a(3, "VungleAd", "ad orientation " + orientation + " (portrait)", null);
                        i = 7;
                        break;
                    }
                    so.m2470a(3, "VungleAd", "ad orientation " + orientation + " (landscape)", null);
                    i = 6;
                    break;
                    break;
            }
            c1618d.setRequestedOrientation(i);
            C1853a c1853a = this.f2847m;
            oq oqVar = (oq) c1618d.getFragmentManager().findFragmentByTag("videoFragment");
            if (oqVar == null) {
                oqVar = (oq) c1853a.f2785a.get();
            }
            String s = jvVar.m1749s();
            ju u2 = jvVar.m1751u();
            if (u2 != null) {
                oqVar.b = c1617z;
                oqVar.f2803e = u2;
                oqVar.f2795H = s;
            } else {
                oqVar = null;
            }
            this.f2849o = oqVar;
            if (jvVar instanceof ez) {
                fa p = ((ez) jvVar).m1757p();
                if (p != null) {
                    this.f2850p = (oc) this.f2848n.m2182a(c1618d, (String) jvVar.mo4410w(), p.f1872j.m2134a(p.m1663B().toURI().toString()), c1617z);
                }
            }
            if ("postRollFragment".equals(this.f)) {
                m2311c();
            } else if (this.f2849o == null) {
                m2311c();
            } else {
                m2207a(this.f2849o);
            }
        } catch (Throwable e) {
            this.h.m1865a("VungleAd", "error playing video ad", e);
            m2208a(false, false);
        }
    }

    @Inject
    ov() {
    }

    protected final mv<?> mo4514a() {
        return this.f2845k.m2307a(this);
    }

    protected final afk<?> mo4517b() {
        C1704a c1704a = this.f2846l;
        c1704a.f1385a.m1188a((cu) (jv) this.a);
        return c1704a.f1385a;
    }

    final void m2311c() {
        if (this.f2850p == null) {
            m2208a(true, false);
            return;
        }
        this.g.m2361a(new au());
        m2207a(this.f2850p);
    }
}
