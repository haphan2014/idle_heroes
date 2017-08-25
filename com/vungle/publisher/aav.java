package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.aat.C1631a.C1628a;
import com.vungle.publisher.aat.C1631a.C1630b.C1629a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aav implements MembersInjector<C1628a> {
    static final /* synthetic */ boolean f899a = (!aav.class.desiredAssertionStatus());
    private final Provider<Context> f900b;
    private final Provider<C1707b> f901c;
    private final Provider<C1629a> f902d;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1628a c1628a = (C1628a) obj;
        if (c1628a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1628a.f844a = (Context) this.f900b.get();
        c1628a.f845b = (C1707b) this.f901c.get();
        c1628a.f846c = (C1629a) this.f902d.get();
    }

    private aav(Provider<Context> provider, Provider<C1707b> provider2, Provider<C1629a> provider3) {
        if (f899a || provider != null) {
            this.f900b = provider;
            if (f899a || provider2 != null) {
                this.f901c = provider2;
                if (f899a || provider3 != null) {
                    this.f902d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<C1628a> m888a(Provider<Context> provider, Provider<C1707b> provider2, Provider<C1629a> provider3) {
        return new aav(provider, provider2, provider3);
    }
}
