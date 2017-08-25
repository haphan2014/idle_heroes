package com.vungle.publisher;

import com.vungle.publisher.C1789if.C1788a;
import com.vungle.publisher.cu.C1721b;
import com.vungle.publisher.ez.C1760a;
import com.vungle.publisher.hd.C1780a;
import com.vungle.publisher.kd.C1801a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class dl implements MembersInjector<C1721b> {
    static final /* synthetic */ boolean f1656a = (!dl.class.desiredAssertionStatus());
    private final Provider<C1760a> f1657b;
    private final Provider<C1788a> f1658c;
    private final Provider<C1801a> f1659d;
    private final Provider<C1780a> f1660e;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1721b c1721b = (C1721b) obj;
        if (c1721b == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1721b.f1537a = (C1760a) this.f1657b.get();
        c1721b.f1538b = (C1788a) this.f1658c.get();
        c1721b.f1539c = (C1801a) this.f1659d.get();
        c1721b.f1540d = (C1780a) this.f1660e.get();
    }

    private dl(Provider<C1760a> provider, Provider<C1788a> provider2, Provider<C1801a> provider3, Provider<C1780a> provider4) {
        if (f1656a || provider != null) {
            this.f1657b = provider;
            if (f1656a || provider2 != null) {
                this.f1658c = provider2;
                if (f1656a || provider3 != null) {
                    this.f1659d = provider3;
                    if (f1656a || provider4 != null) {
                        this.f1660e = provider4;
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

    public static MembersInjector<C1721b> m1462a(Provider<C1760a> provider, Provider<C1788a> provider2, Provider<C1801a> provider3, Provider<C1780a> provider4) {
        return new dl(provider, provider2, provider3, provider4);
    }
}
