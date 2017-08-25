package com.vungle.publisher;

import com.vungle.publisher.db.C1730b;
import com.vungle.publisher.fu.C1771a;
import com.vungle.publisher.ho.C1783a;
import com.vungle.publisher.iq.C1792a;
import com.vungle.publisher.ky.C1806a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class dj implements MembersInjector<C1730b> {
    static final /* synthetic */ boolean f1648a = (!dj.class.desiredAssertionStatus());
    private final Provider<cq> f1649b;
    private final Provider<C1771a> f1650c;
    private final Provider<C1792a> f1651d;
    private final Provider<C1806a> f1652e;
    private final Provider<C1783a> f1653f;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1730b c1730b = (C1730b) obj;
        if (c1730b == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1730b.f1594a = (cq) this.f1649b.get();
        c1730b.f1595b = (C1771a) this.f1650c.get();
        c1730b.f1596c = (C1792a) this.f1651d.get();
        c1730b.f1597d = (C1806a) this.f1652e.get();
        c1730b.f1598e = (C1783a) this.f1653f.get();
    }

    private dj(Provider<cq> provider, Provider<C1771a> provider2, Provider<C1792a> provider3, Provider<C1806a> provider4, Provider<C1783a> provider5) {
        if (f1648a || provider != null) {
            this.f1649b = provider;
            if (f1648a || provider2 != null) {
                this.f1650c = provider2;
                if (f1648a || provider3 != null) {
                    this.f1651d = provider3;
                    if (f1648a || provider4 != null) {
                        this.f1652e = provider4;
                        if (f1648a || provider5 != null) {
                            this.f1653f = provider5;
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

    public static MembersInjector<C1730b> m1460a(Provider<cq> provider, Provider<C1771a> provider2, Provider<C1792a> provider3, Provider<C1806a> provider4, Provider<C1783a> provider5) {
        return new dj(provider, provider2, provider3, provider4, provider5);
    }
}
