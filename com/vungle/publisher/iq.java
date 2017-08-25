package com.vungle.publisher;

import com.vungle.publisher.C1789if.C1788a;
import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.da.C1726a;
import com.vungle.publisher.db.C1727a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.il.C1791a;
import com.vungle.publisher.jy.C1770a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class iq extends jy<iq, il, ir, C1789if, ie> {
    @Inject
    C1792a f2195w;
    @Inject
    C1791a f2196x;

    @Singleton
    /* compiled from: vungle */
    public static class C1792a extends C1770a<iq, il, ir, C1789if, ie, adn> {
        @Inject
        C1791a f2192c;
        @Inject
        C1788a f2193e;
        @Inject
        Provider<iq> f2194f;

        @Inject
        protected C1792a() {
        }

        public final C1893v mo4474f() {
            return C1893v.vungle_streaming;
        }

        protected final /* bridge */ /* synthetic */ C1726a mo4473e() {
            return this.f2192c;
        }

        protected final /* bridge */ /* synthetic */ C1718a mo4470a() {
            return this.f2193e;
        }

        protected final /* bridge */ /* synthetic */ dw[] mo4396a(int i) {
            return new iq[i];
        }

        protected final /* synthetic */ dw c_() {
            return (iq) this.f2194f.get();
        }
    }

    @Inject
    protected iq() {
    }

    protected final /* bridge */ /* synthetic */ C1726a mo4477e() {
        return this.f2196x;
    }

    public final /* bridge */ /* synthetic */ C1727a mo4476b() {
        return this.f2195w;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2195w;
    }
}
