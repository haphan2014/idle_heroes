package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.bl.C1708a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class cl implements MembersInjector<cj> {
    static final /* synthetic */ boolean f1502a = (!cl.class.desiredAssertionStatus());
    private final Provider<mc> f1503b;
    private final Provider<C1708a> f1504c;
    private final Provider<qh> f1505d;
    private final Provider<Context> f1506e;

    public final /* synthetic */ void injectMembers(Object obj) {
        cj cjVar = (cj) obj;
        if (cjVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        cjVar.f1496c = (mc) this.f1503b.get();
        cjVar.f1497d = (C1708a) this.f1504c.get();
        cjVar.f1498e = (qh) this.f1505d.get();
        cjVar.f1499f = (Context) this.f1506e.get();
    }

    private cl(Provider<mc> provider, Provider<C1708a> provider2, Provider<qh> provider3, Provider<Context> provider4) {
        if (f1502a || provider != null) {
            this.f1503b = provider;
            if (f1502a || provider2 != null) {
                this.f1504c = provider2;
                if (f1502a || provider3 != null) {
                    this.f1505d = provider3;
                    if (f1502a || provider4 != null) {
                        this.f1506e = provider4;
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

    public static MembersInjector<cj> m1251a(Provider<mc> provider, Provider<C1708a> provider2, Provider<qh> provider3, Provider<Context> provider4) {
        return new cl(provider, provider2, provider3, provider4);
    }
}
