package com.vungle.publisher;

import com.vungle.publisher.eo.C1749a;
import com.vungle.publisher.js.C1775a;
import com.vungle.publisher.ko.C1804a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class li extends js<li, kd, ads, ko, C1804a, abc> {
    @Inject
    C1809a f2464a;

    @Singleton
    /* compiled from: vungle */
    public static class C1809a extends C1775a<li, kd, ads, ko, C1804a, abc> {
        @Inject
        Provider<li> f2462a;
        @Inject
        C1804a f2463b;

        @Inject
        C1809a() {
        }

        public final /* bridge */ /* synthetic */ C1749a mo4478a() {
            return this.f2463b;
        }

        protected final /* synthetic */ js mo4479b() {
            return (li) this.f2462a.get();
        }
    }

    @Inject
    li() {
    }

    protected final /* bridge */ /* synthetic */ C1775a mo4480a() {
        return this.f2464a;
    }
}
