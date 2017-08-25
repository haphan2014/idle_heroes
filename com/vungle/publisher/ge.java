package com.vungle.publisher;

import com.vungle.publisher.eo.C1749a;
import com.vungle.publisher.fk.C1767a;
import com.vungle.publisher.js.C1775a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class ge extends js<ge, ez, ade, jw, C1767a, aec> {
    @Inject
    C1776a f1970a;

    @Singleton
    /* compiled from: vungle */
    public static class C1776a extends C1775a<ge, ez, ade, jw, C1767a, aec> {
        @Inject
        Provider<ge> f1966a;
        @Inject
        C1767a f1967b;

        @Inject
        C1776a() {
        }

        public final /* bridge */ /* synthetic */ C1749a mo4478a() {
            return this.f1967b;
        }

        protected final /* synthetic */ js mo4479b() {
            return (ge) this.f1966a.get();
        }
    }

    @Inject
    ge() {
    }

    protected final /* bridge */ /* synthetic */ C1775a mo4480a() {
        return this.f1970a;
    }
}
