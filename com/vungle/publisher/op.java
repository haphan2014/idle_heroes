package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.on.C1847a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class op implements MembersInjector<C1847a> {
    static final /* synthetic */ boolean f2772a = (!op.class.desiredAssertionStatus());
    private final Provider<Context> f2773b;
    private final Provider<qh> f2774c;
    private final Provider<mq> f2775d;
    private final Provider<mn> f2776e;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1847a c1847a = (C1847a) obj;
        if (c1847a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1847a.f2599a = (Context) this.f2773b.get();
        c1847a.f2600b = (qh) this.f2774c.get();
        c1847a.f2768c = (mq) this.f2775d.get();
        c1847a.f2769d = (mn) this.f2776e.get();
    }

    private op(Provider<Context> provider, Provider<qh> provider2, Provider<mq> provider3, Provider<mn> provider4) {
        if (f2772a || provider != null) {
            this.f2773b = provider;
            if (f2772a || provider2 != null) {
                this.f2774c = provider2;
                if (f2772a || provider3 != null) {
                    this.f2775d = provider3;
                    if (f2772a || provider4 != null) {
                        this.f2776e = provider4;
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

    public static MembersInjector<C1847a> m2274a(Provider<Context> provider, Provider<qh> provider2, Provider<mq> provider3, Provider<mn> provider4) {
        return new op(provider, provider2, provider3, provider4);
    }
}
