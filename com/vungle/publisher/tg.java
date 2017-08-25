package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.tm.C1888a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class tg implements MembersInjector<te> {
    static final /* synthetic */ boolean f3261a = (!tg.class.desiredAssertionStatus());
    private final Provider<nf> f3262b;
    private final Provider<C1778a> f3263c;
    private final Provider<sp> f3264d;
    private final Provider<C1888a> f3265e;

    public final /* synthetic */ void injectMembers(Object obj) {
        te teVar = (te) obj;
        if (teVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        teVar.f3255a = (nf) this.f3262b.get();
        teVar.f3256b = (C1778a) this.f3263c.get();
        teVar.f3257c = (sp) this.f3264d.get();
        teVar.f3258d = (C1888a) this.f3265e.get();
    }

    private tg(Provider<nf> provider, Provider<C1778a> provider2, Provider<sp> provider3, Provider<C1888a> provider4) {
        if (f3261a || provider != null) {
            this.f3262b = provider;
            if (f3261a || provider2 != null) {
                this.f3263c = provider2;
                if (f3261a || provider3 != null) {
                    this.f3264d = provider3;
                    if (f3261a || provider4 != null) {
                        this.f3265e = provider4;
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

    public static MembersInjector<te> m2497a(Provider<nf> provider, Provider<C1778a> provider2, Provider<sp> provider3, Provider<C1888a> provider4) {
        return new tg(provider, provider2, provider3, provider4);
    }
}
