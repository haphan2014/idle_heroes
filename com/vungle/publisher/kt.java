package com.vungle.publisher;

import com.vungle.publisher.da.C1726a;
import com.vungle.publisher.dc.C1732a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.kz.C1807a;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class kt extends da<ky, kt, kz> {
    @Inject
    C1805a f2400e;

    @Singleton
    /* compiled from: vungle */
    public static class C1805a extends C1726a<ky, kt, kz> {
        @Inject
        Provider<kt> f2398a;
        @Inject
        C1807a f2399b;

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
        C1805a() {
        }

        protected final /* synthetic */ dw c_() {
            return (kt) this.f2398a.get();
        }
    }

    @Inject
    kt() {
    }

    protected final /* bridge */ /* synthetic */ C1732a mo4469b() {
        return this.f2400e.f2399b;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2400e;
    }
}
