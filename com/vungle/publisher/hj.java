package com.vungle.publisher;

import com.vungle.publisher.da.C1726a;
import com.vungle.publisher.dc.C1732a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.hp.C1784a;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class hj extends da<ho, hj, hp> {
    @Inject
    C1782a f2072e;

    @Singleton
    /* compiled from: vungle */
    public static class C1782a extends C1726a<ho, hj, hp> {
        @Inject
        Provider<hj> f2070a;
        @Inject
        C1784a f2071b;

        public final /* bridge */ /* synthetic */ List mo4383a(String str, String[] strArr) {
            return super.mo4383a(str, strArr);
        }

        public final /* bridge */ /* synthetic */ List mo4386c(int i) {
            return super.mo4386c(i);
        }

        public final /* bridge */ /* synthetic */ List mo4387d() {
            return super.mo4387d();
        }

        @Inject
        C1782a() {
        }

        protected final /* synthetic */ dw c_() {
            return (hj) this.f2070a.get();
        }
    }

    @Inject
    hj() {
    }

    protected final /* bridge */ /* synthetic */ C1732a mo4469b() {
        return this.f2072e.f2071b;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2072e;
    }
}
