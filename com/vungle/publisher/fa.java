package com.vungle.publisher;

import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.ew.C1753b;
import com.vungle.publisher.ex.C1756a;
import com.vungle.publisher.ez.C1760a;
import com.vungle.publisher.lr.C1811a;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class fa extends ex<ez, fa> {
    @Inject
    C1760a f1870h;
    @Inject
    C1764a f1871i;
    @Inject
    public C1811a f1872j;

    @Singleton
    /* compiled from: vungle */
    public static class C1764a extends C1756a<ez, fa, ade> {
        @Inject
        Provider<fa> f1869b;

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
        C1764a() {
        }

        final fa m1764a(ez ezVar, ade com_vungle_publisher_ade, C1753b c1753b) {
            if (com_vungle_publisher_ade == null) {
                return null;
            }
            if (c1753b == C1753b.postRoll) {
                String str = com_vungle_publisher_ade.f1117k;
                if (str == null) {
                    return null;
                }
                fa faVar = (fa) super.mo4465a((cu) ezVar, (acr) com_vungle_publisher_ade, c1753b);
                faVar.m1667a(str);
                return faVar;
            }
            throw new IllegalArgumentException("cannot create archive of type: " + c1753b);
        }

        protected final /* synthetic */ dw c_() {
            fa faVar = (fa) this.f1869b.get();
            faVar.g = this.a.m1841a(faVar);
            return faVar;
        }
    }

    @Inject
    protected fa() {
    }

    protected final /* bridge */ /* synthetic */ C1718a mo4421r() {
        return this.f1870h;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f1871i;
    }
}
