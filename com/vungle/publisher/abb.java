package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.aat.C1636b.C1633a.C1632a;
import com.vungle.publisher.aat.C1636b.C1634b;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class abb implements MembersInjector<C1634b> {
    static final /* synthetic */ boolean f916a = (!abb.class.desiredAssertionStatus());
    private final Provider<Context> f917b;
    private final Provider<AdConfig> f918c;
    private final Provider<pj> f919d;
    private final Provider<C1632a> f920e;
    private final Provider<un> f921f;
    private final Provider<pq> f922g;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1634b c1634b = (C1634b) obj;
        if (c1634b == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1634b.f859a = (Context) this.f917b.get();
        c1634b.f860b = (AdConfig) this.f918c.get();
        c1634b.f861c = (pj) this.f919d.get();
        c1634b.f862d = (C1632a) this.f920e.get();
        c1634b.f863e = (un) this.f921f.get();
        c1634b.f864f = (pq) this.f922g.get();
    }

    private abb(Provider<Context> provider, Provider<AdConfig> provider2, Provider<pj> provider3, Provider<C1632a> provider4, Provider<un> provider5, Provider<pq> provider6) {
        if (f916a || provider != null) {
            this.f917b = provider;
            if (f916a || provider2 != null) {
                this.f918c = provider2;
                if (f916a || provider3 != null) {
                    this.f919d = provider3;
                    if (f916a || provider4 != null) {
                        this.f920e = provider4;
                        if (f916a || provider5 != null) {
                            this.f921f = provider5;
                            if (f916a || provider6 != null) {
                                this.f922g = provider6;
                                return;
                            }
                            throw new AssertionError();
                        }
                        throw new AssertionError();
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1634b> m910a(Provider<Context> provider, Provider<AdConfig> provider2, Provider<pj> provider3, Provider<C1632a> provider4, Provider<un> provider5, Provider<pq> provider6) {
        return new abb(provider, provider2, provider3, provider4, provider5, provider6);
    }
}
