package com.vungle.publisher;

import com.vungle.publisher.cv.C1723a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class cy implements MembersInjector<C1723a> {
    static final /* synthetic */ boolean f1575a = (!cy.class.desiredAssertionStatus());
    private final Provider<cq> f1576b;
    private final Provider<cv> f1577c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1723a c1723a = (C1723a) obj;
        if (c1723a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1723a.f1530d = (cq) this.f1576b.get();
        c1723a.f1567a = this.f1577c;
    }

    private cy(Provider<cq> provider, Provider<cv> provider2) {
        if (f1575a || provider != null) {
            this.f1576b = provider;
            if (f1575a || provider2 != null) {
                this.f1577c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1723a> m1356a(Provider<cq> provider, Provider<cv> provider2) {
        return new cy(provider, provider2);
    }
}
