package com.vungle.publisher;

import com.heyzap.http.AsyncHttpClient;
import com.vungle.publisher.abr.C1649a;
import com.vungle.publisher.vf.C1894b;
import com.vungle.publisher.vf.C1895c;
import com.vungle.publisher.xs.C1624a;
import com.vungle.publisher.yc.C1916a;
import com.vungle.publisher.yf.C1917a;
import com.vungle.publisher.yi.C1918a;
import com.vungle.publisher.yl.C1919a;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public abstract class xt<O extends abr> extends xs {
    cu f3627e;
    Integer f3628f;
    O f3629g;

    /* compiled from: vungle */
    public static abstract class C1913a<O extends abr, H extends xt<O>, T extends db<T, ?, ?, ?>> extends C1624a<H> {
        protected abstract C1649a<?, O, T, ?> mo4553d();

        protected abstract H mo4554e();

        protected C1913a() {
        }

        protected /* synthetic */ vf mo4346a() {
            return mo4554e();
        }

        public final H m2623a(T t) throws rz {
            try {
                xt xtVar = (xt) mo4347c();
                xtVar.f3627e = t == null ? null : t.m1418h();
                xtVar.f788b = this.d + "reportAd";
                xtVar.m825a("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
                xtVar.m825a("Content-Type", "application/json");
                xtVar.f3628f = (Integer) t.mo4410w();
                xtVar.f788b = this.d + "reportAd";
                abr a = mo4553d().mo4360a(t);
                xtVar.f3629g = a;
                if (a != null) {
                    xtVar.f790d = a.m857d();
                }
                return xtVar;
            } catch (Throwable e) {
                throw new rz(e);
            }
        }
    }

    @Singleton
    /* compiled from: vungle */
    public static class C1915b {
        @Inject
        C1916a f3623a;
        @Inject
        C1918a f3624b;
        @Inject
        C1919a f3625c;
        @Inject
        C1917a f3626d;

        /* compiled from: vungle */
        class C19141 extends aa<xt<?>> {
            final /* synthetic */ db f3621a;
            final /* synthetic */ C1915b f3622b;

            C19141(C1915b c1915b, db dbVar) {
                this.f3622b = c1915b;
                this.f3621a = dbVar;
            }

            protected final /* synthetic */ Object mo4375d() {
                return this.f3622b.f3626d.m2623a((ho) this.f3621a);
            }

            protected final /* synthetic */ Object mo4374c() {
                return this.f3622b.f3625c.m2623a((ky) this.f3621a);
            }

            protected final /* synthetic */ Object mo4373b() {
                return this.f3622b.f3624b.m2623a((iq) this.f3621a);
            }

            protected final /* bridge */ /* synthetic */ Object mo4372a() {
                return this.f3622b.f3623a.m2623a((fu) this.f3621a);
            }
        }

        @Inject
        C1915b() {
        }
    }

    protected xt() {
    }

    protected final C1895c mo4349b() {
        return C1895c.reportAd;
    }

    protected final C1894b mo4348a() {
        return C1894b.POST;
    }
}
