package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.adn.C1673a;
import com.vungle.publisher.adq.C1675a.C1674a;
import com.vungle.publisher.aec.C1679a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class adp implements MembersInjector<C1673a> {
    static final /* synthetic */ boolean f1154a = (!adp.class.desiredAssertionStatus());
    private final Provider<C1892a> f1155b;
    private final Provider<C1674a> f1156c;
    private final Provider<agg> f1157d;
    private final Provider<C1679a> f1158e;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1673a c1673a = (C1673a) obj;
        if (c1673a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1673a.f1041a = (C1892a) this.f1155b.get();
        c1673a.f1105d = (C1674a) this.f1156c.get();
        c1673a.f1149b = (agg) this.f1157d.get();
        c1673a.f1150c = (C1679a) this.f1158e.get();
    }

    private adp(Provider<C1892a> provider, Provider<C1674a> provider2, Provider<agg> provider3, Provider<C1679a> provider4) {
        if (f1154a || provider != null) {
            this.f1155b = provider;
            if (f1154a || provider2 != null) {
                this.f1156c = provider2;
                if (f1154a || provider3 != null) {
                    this.f1157d = provider3;
                    if (f1154a || provider4 != null) {
                        this.f1158e = provider4;
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

    public static MembersInjector<C1673a> m1086a(Provider<C1892a> provider, Provider<C1674a> provider2, Provider<agg> provider3, Provider<C1679a> provider4) {
        return new adp(provider, provider2, provider3, provider4);
    }
}
