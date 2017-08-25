package com.vungle.publisher;

import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.ew.C1753b;
import com.vungle.publisher.ex.C1756a;
import com.vungle.publisher.kd.C1801a;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ke extends ex<kd, ke> {
    @Inject
    C1801a f2357h;
    @Inject
    C1802a f2358i;

    @Singleton
    /* compiled from: vungle */
    public static class C1802a extends C1756a<kd, ke, ads> {
        @Inject
        Provider<ke> f2356b;

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
        C1802a() {
        }

        final ke m2057a(kd kdVar, ads com_vungle_publisher_ads, C1753b c1753b) {
            if (com_vungle_publisher_ads == null) {
                return null;
            }
            String str = com_vungle_publisher_ads.f1172m;
            if (str == null) {
                return null;
            }
            ke keVar = (ke) super.mo4465a((cu) kdVar, (acr) com_vungle_publisher_ads, c1753b);
            keVar.m1667a(str);
            return keVar;
        }

        protected final /* synthetic */ dw c_() {
            ke keVar = (ke) this.f2356b.get();
            keVar.g = this.a.m1841a(keVar);
            return keVar;
        }
    }

    @Inject
    ke() {
    }

    public final String mo4486C() {
        return qt.m2369a(m1680u(), "index.html");
    }

    protected final /* bridge */ /* synthetic */ C1718a mo4421r() {
        return this.f2357h;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2358i;
    }
}
