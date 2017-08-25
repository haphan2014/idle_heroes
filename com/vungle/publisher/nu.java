package com.vungle.publisher;

import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.vungle.publisher.afo.C1703a;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.nl.C1835a;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class nu extends ni<dx> {
    @Inject
    C1703a f2704k;
    @Inject
    C1841a f2705l;
    @Inject
    C1835a f2706m;
    private nl f2707n;

    @Singleton
    /* compiled from: vungle */
    public static class C1842a extends mv<nu> {
        @Inject
        C1778a f2702b;
        boolean f2703c;

        @Singleton
        /* compiled from: vungle */
        public static class C1841a {
            @Inject
            C1842a f2701a;

            @Inject
            C1841a() {
            }

            public final C1842a m2240a(nu nuVar) {
                this.f2701a.a = nuVar;
                this.f2701a.f2703c = false;
                return this.f2701a;
            }
        }

        @Inject
        C1842a() {
        }

        public final void onEvent(tv tvVar) {
            so.m2470a(2, "VungleEvent", "mraidAd.onClose()", null);
            this.v.m2361a(new tu(tk.mraidClose));
            ((nu) this.a).m2208a(true, this.f2703c);
        }

        public final void onEvent(ua event) {
            ((nu) this.a).m2204a(event.f3332a);
        }

        public final void onEvent(tw twVar) {
            this.v.m2361a(new tu(tk.mraidOpen));
            this.f2703c = true;
        }

        public final void onEvent(tx txVar) {
            ((nu) this.a).m2208a(false, this.f2703c);
        }

        public final void onEvent(ud event) {
            try {
                tl tlVar = event.f3333a;
                boolean z = event.f3334b;
                if (tlVar != tl.NONE) {
                    so.m2470a(2, "VungleEvent", "force mraid orientation: " + tlVar, null);
                    ((nu) this.a).m2203a(tlVar.f3298d);
                } else if (z) {
                    ((nu) this.a).m2203a(4);
                } else if (VERSION.SDK_INT >= 18) {
                    ((nu) this.a).m2203a(14);
                } else {
                    ((nu) this.a).m2203a(5);
                }
            } catch (Throwable e) {
                this.f2702b.m1865a("VungleEvent", "error setting mraid orientation", e);
            }
        }
    }

    public final /* synthetic */ void mo4516a(C1618d c1618d, cu cuVar, C1617z c1617z, Bundle bundle) {
        dx dxVar = (dx) cuVar;
        so.m2470a(3, "VungleAd", "create mraid ad", null);
        super.mo4516a(c1618d, dxVar, c1617z, bundle);
        this.f2707n = (nl) this.f2706m.m2182a(c1618d, (String) dxVar.mo4410w(), dxVar.mo4481p(), c1617z);
        c1618d.setRequestedOrientation(4);
        c1618d.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.f2707n == null) {
            m2208a(true, false);
        } else {
            m2207a(this.f2707n);
        }
    }

    @Inject
    nu() {
    }

    public final void mo4515a(C1618d c1618d) {
        super.mo4515a(c1618d);
        if (!this.f2707n.m2231c()) {
            c1618d.finish();
        }
    }

    protected final mv<?> mo4514a() {
        return this.f2705l.m2240a(this);
    }

    protected final afk<?> mo4517b() {
        C1703a c1703a = this.f2704k;
        c1703a.f1370a.m1188a((cu) (dx) this.a);
        return c1703a.f1370a;
    }
}
