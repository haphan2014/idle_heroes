package com.vungle.publisher;

import com.vungle.publisher.dm.C1734a;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.kd.C1801a;
import com.vungle.publisher.ke.C1802a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ki implements MembersInjector<ke> {
    static final /* synthetic */ boolean f2368a = (!ki.class.desiredAssertionStatus());
    private final Provider<cq> f2369b;
    private final Provider<C1778a> f2370c;
    private final Provider<C1734a> f2371d;
    private final Provider<gs> f2372e;
    private final Provider<C1801a> f2373f;
    private final Provider<C1802a> f2374g;

    public final /* synthetic */ void injectMembers(Object obj) {
        ke keVar = (ke) obj;
        if (keVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        keVar.f1551v = (cq) this.f2369b.get();
        keVar.f1822e = (C1778a) this.f2370c.get();
        keVar.f1823f = (C1734a) this.f2371d.get();
        keVar.f1824g = (gs) this.f2372e.get();
        keVar.f2357h = (C1801a) this.f2373f.get();
        keVar.f2358i = (C1802a) this.f2374g.get();
    }

    private ki(Provider<cq> provider, Provider<C1778a> provider2, Provider<C1734a> provider3, Provider<gs> provider4, Provider<C1801a> provider5, Provider<C1802a> provider6) {
        if (f2368a || provider != null) {
            this.f2369b = provider;
            if (f2368a || provider2 != null) {
                this.f2370c = provider2;
                if (f2368a || provider3 != null) {
                    this.f2371d = provider3;
                    if (f2368a || provider4 != null) {
                        this.f2372e = provider4;
                        if (f2368a || provider5 != null) {
                            this.f2373f = provider5;
                            if (f2368a || provider6 != null) {
                                this.f2374g = provider6;
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

    public static MembersInjector<ke> m2067a(Provider<cq> provider, Provider<C1778a> provider2, Provider<C1734a> provider3, Provider<gs> provider4, Provider<C1801a> provider5, Provider<C1802a> provider6) {
        return new ki(provider, provider2, provider3, provider4, provider5, provider6);
    }
}
