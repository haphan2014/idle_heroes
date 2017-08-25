package com.vungle.publisher;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.drive.DriveFile;
import com.vungle.publisher.gx.C1778a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public abstract class ni<A extends cu> {
    A f2637a;
    C1618d f2638b;
    public mw f2639c;
    mv<?> f2640d;
    afk<?> f2641e;
    protected String f2642f;
    @Inject
    qh f2643g;
    @Inject
    public C1778a f2644h;
    @Inject
    agc f2645i;
    @Inject
    pj f2646j;
    private C1617z f2647k;

    @Singleton
    /* compiled from: vungle */
    public static class C1832a {
        @Inject
        Provider<ov> f2635a;
        @Inject
        Provider<nu> f2636b;

        /* compiled from: vungle */
        public class C18311 extends aa<P> {
            final /* synthetic */ C1832a f2634a;

            public C18311(C1832a c1832a) {
                this.f2634a = c1832a;
            }

            protected final /* synthetic */ Object mo4375d() {
                return (ni) this.f2634a.f2636b.get();
            }

            protected final /* synthetic */ Object mo4374c() {
                return (ni) this.f2634a.f2636b.get();
            }

            protected final /* synthetic */ Object mo4373b() {
                return (ni) this.f2634a.f2635a.get();
            }

            protected final /* synthetic */ Object mo4372a() {
                return (ni) this.f2634a.f2635a.get();
            }
        }

        @Inject
        C1832a() {
        }
    }

    protected abstract mv<?> mo4514a();

    protected abstract afk<?> mo4517b();

    public void mo4516a(C1618d c1618d, A a, C1617z c1617z, Bundle bundle) {
        this.f2637a = a;
        this.f2638b = c1618d;
        this.f2647k = c1617z;
        this.f2640d = mo4514a();
        this.f2641e = mo4517b();
        this.f2640d.m1184g();
        this.f2641e.m1184g();
        Object obj = bundle != null ? 1 : null;
        if (obj == null) {
            this.f2643g.m2361a(new bb(a, c1617z));
        }
        this.f2642f = obj != null ? bundle.getString("currentFragment") : null;
    }

    public void mo4515a(C1618d c1618d) {
    }

    final void m2204a(Uri uri) {
        try {
            Intent a = agc.m1209a("android.intent.action.VIEW", uri);
            a.addFlags(DriveFile.MODE_READ_ONLY);
            this.f2638b.startActivity(a);
        } catch (Throwable e) {
            this.f2644h.m1865a("VungleAd", "error loading URL: " + uri.toString(), e);
        }
    }

    protected final void m2207a(mw mwVar) {
        if (mwVar != this.f2639c) {
            FragmentTransaction beginTransaction = this.f2638b.getFragmentManager().beginTransaction();
            if (this.f2647k == null || this.f2647k.isTransitionAnimationEnabled()) {
                beginTransaction.setTransition(android.support.v4.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            }
            this.f2639c = mwVar;
            beginTransaction.replace(16908290, mwVar, mwVar.mo4507b());
            beginTransaction.commit();
        }
    }

    protected final void m2203a(int i) {
        try {
            this.f2638b.setRequestedOrientation(i);
        } catch (Throwable e) {
            this.f2644h.m1865a("VungleAd", "could not set orientation", e);
        }
    }

    final void m2208a(boolean z, boolean z2) {
        try {
            Object cbVar;
            qh qhVar = this.f2643g;
            if (z) {
                cbVar = new cb(this.f2637a, z2);
            } else {
                cbVar = new ca(this.f2637a, z2);
            }
            qhVar.m2361a(cbVar);
        } catch (Throwable e) {
            this.f2644h.m1865a("VungleAd", "error exiting ad", e);
        } finally {
            this.f2638b.finish();
        }
    }
}
