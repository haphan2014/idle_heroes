package com.vungle.publisher;

import com.vungle.publisher.fk.C1767a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class fo implements MembersInjector<fk> {
    static final /* synthetic */ boolean f1910a = (!fo.class.desiredAssertionStatus());
    private final Provider<cq> f1911b;
    private final Provider<C1767a> f1912c;

    public final /* synthetic */ void injectMembers(Object obj) {
        fk fkVar = (fk) obj;
        if (fkVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        fkVar.f1551v = (cq) this.f1911b.get();
        fkVar.f1902d = (C1767a) this.f1912c.get();
    }

    private fo(Provider<cq> provider, Provider<C1767a> provider2) {
        if (f1910a || provider != null) {
            this.f1911b = provider;
            if (f1910a || provider2 != null) {
                this.f1912c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<fk> m1787a(Provider<cq> provider, Provider<C1767a> provider2) {
        return new fo(provider, provider2);
    }
}
