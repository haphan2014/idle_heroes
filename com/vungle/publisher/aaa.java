package com.vungle.publisher;

import com.vungle.publisher.zv.C1927a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aaa implements MembersInjector<zy> {
    static final /* synthetic */ boolean f775a = (!aaa.class.desiredAssertionStatus());
    private final Provider<vr> f776b;
    private final Provider<C1927a> f777c;
    private final Provider<vb> f778d;

    public final /* synthetic */ void injectMembers(Object obj) {
        zy zyVar = (zy) obj;
        if (zyVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        vt.m2555a(zyVar, this.f776b);
        zyVar.f3827b = (C1927a) this.f777c.get();
        zyVar.f3828c = (vb) this.f778d.get();
    }

    private aaa(Provider<vr> provider, Provider<C1927a> provider2, Provider<vb> provider3) {
        if (f775a || provider != null) {
            this.f776b = provider;
            if (f775a || provider2 != null) {
                this.f777c = provider2;
                if (f775a || provider3 != null) {
                    this.f778d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<zy> m815a(Provider<vr> provider, Provider<C1927a> provider2, Provider<vb> provider3) {
        return new aaa(provider, provider2, provider3);
    }
}
