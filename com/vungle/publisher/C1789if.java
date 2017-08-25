package com.vungle.publisher;

import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.cu.C1722c;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.ie.C1787a;
import com.vungle.publisher.ja.C1795a;
import com.vungle.publisher.js.C1775a;
import com.vungle.publisher.ju.C1757a;
import com.vungle.publisher.jv.C1759a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class C1789if extends jv<C1789if, ie, adn> {
    @Inject
    C1788a f2158p;

    @Singleton
    /* compiled from: vungle */
    public static class C1788a extends C1759a<C1789if, ie, adn> {
        @Inject
        Provider<C1789if> f2155c;
        @Inject
        C1787a f2156e;
        @Inject
        C1795a f2157f;

        @Inject
        C1788a() {
        }

        public final C1789if m1955a(adn com_vungle_publisher_adn) {
            C1789if c1789if = (C1789if) super.mo4449a((adq) com_vungle_publisher_adn);
            c1789if.mo4457a(C1722c.ready);
            return c1789if;
        }

        protected final C1893v mo4451a() {
            return C1893v.vungle_streaming;
        }

        protected final String mo4385c() {
            return "ad";
        }

        protected final String[] a_(int i) {
            return new String[i];
        }

        protected final /* bridge */ /* synthetic */ C1775a mo4452e() {
            return this.f2157f;
        }

        protected final /* bridge */ /* synthetic */ C1757a mo4453f() {
            return this.f2156e;
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4384b(int i) {
            return new String[i];
        }

        protected final /* synthetic */ dw c_() {
            return (C1789if) this.f2155c.get();
        }
    }

    @Inject
    protected C1789if() {
    }

    protected final boolean mo4458b() {
        return true;
    }

    protected final /* bridge */ /* synthetic */ C1759a mo4464r() {
        return this.f2158p;
    }

    protected final /* bridge */ /* synthetic */ C1718a mo4456a() {
        return this.f2158p;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2158p;
    }
}
