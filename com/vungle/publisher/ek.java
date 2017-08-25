package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.cu.C1721b;
import com.vungle.publisher.ei.C1747b;
import com.vungle.publisher.ei.C1748c;
import com.vungle.publisher.ff.C1765a;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.kj.C1803a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ek implements MembersInjector<C1747b> {
    static final /* synthetic */ boolean f1751a = (!ek.class.desiredAssertionStatus());
    private final Provider<cq> f1752b;
    private final Provider<C1892a> f1753c;
    private final Provider<C1721b> f1754d;
    private final Provider<C1778a> f1755e;
    private final Provider<C1803a> f1756f;
    private final Provider<C1765a> f1757g;
    private final Provider<C1748c> f1758h;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1747b c1747b = (C1747b) obj;
        if (c1747b == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1747b.f1734a = (cq) this.f1752b.get();
        c1747b.f1735b = (C1892a) this.f1753c.get();
        c1747b.f1736c = (C1721b) this.f1754d.get();
        c1747b.f1737d = (C1778a) this.f1755e.get();
        c1747b.f1738e = (C1803a) this.f1756f.get();
        c1747b.f1739f = (C1765a) this.f1757g.get();
        c1747b.f1740g = (C1748c) this.f1758h.get();
    }

    private ek(Provider<cq> provider, Provider<C1892a> provider2, Provider<C1721b> provider3, Provider<C1778a> provider4, Provider<C1803a> provider5, Provider<C1765a> provider6, Provider<C1748c> provider7) {
        if (f1751a || provider != null) {
            this.f1752b = provider;
            if (f1751a || provider2 != null) {
                this.f1753c = provider2;
                if (f1751a || provider3 != null) {
                    this.f1754d = provider3;
                    if (f1751a || provider4 != null) {
                        this.f1755e = provider4;
                        if (f1751a || provider5 != null) {
                            this.f1756f = provider5;
                            if (f1751a || provider6 != null) {
                                this.f1757g = provider6;
                                if (f1751a || provider7 != null) {
                                    this.f1758h = provider7;
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
        throw new AssertionError();
    }

    public static MembersInjector<C1747b> m1585a(Provider<cq> provider, Provider<C1892a> provider2, Provider<C1721b> provider3, Provider<C1778a> provider4, Provider<C1803a> provider5, Provider<C1765a> provider6, Provider<C1748c> provider7) {
        return new ek(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
