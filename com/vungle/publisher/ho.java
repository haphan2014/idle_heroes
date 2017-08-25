package com.vungle.publisher;

import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.da.C1726a;
import com.vungle.publisher.db.C1727a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.hd.C1780a;
import com.vungle.publisher.hj.C1782a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ho extends db<ho, hj, hp, hd> implements en {
    @Inject
    C1783a f2087w;

    @Singleton
    /* compiled from: vungle */
    public static class C1783a extends C1727a<ho, hj, hp, hd, adh> {
        @Inject
        C1780a f2084c;
        @Inject
        C1782a f2085e;
        @Inject
        Provider<ho> f2086f;

        @Inject
        C1783a() {
        }

        public final C1893v mo4474f() {
            return C1893v.third_party_mraid;
        }

        protected final /* bridge */ /* synthetic */ C1726a mo4473e() {
            return this.f2085e;
        }

        protected final /* bridge */ /* synthetic */ C1718a mo4470a() {
            return this.f2084c;
        }

        protected final /* bridge */ /* synthetic */ dw[] mo4396a(int i) {
            return new ho[i];
        }

        protected final /* synthetic */ dw c_() {
            return (ho) this.f2086f.get();
        }
    }

    @Inject
    ho() {
    }

    public final void a_(Long l) {
    }

    protected final /* bridge */ /* synthetic */ C1726a mo4477e() {
        return this.f2087w.f2085e;
    }

    public final /* bridge */ /* synthetic */ C1727a mo4476b() {
        return this.f2087w;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2087w;
    }
}
