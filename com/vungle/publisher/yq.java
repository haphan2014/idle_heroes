package com.vungle.publisher;

import com.vungle.publisher.yo.C1920a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class yq implements MembersInjector<yo> {
    static final /* synthetic */ boolean f3701a = (!yq.class.desiredAssertionStatus());
    private final Provider<ce> f3702b;
    private final Provider<C1920a> f3703c;

    public final /* synthetic */ void injectMembers(Object obj) {
        yo yoVar = (yo) obj;
        if (yoVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        cd.m1240a(yoVar, this.f3702b);
        yoVar.f3698b = (C1920a) this.f3703c.get();
    }

    private yq(Provider<ce> provider, Provider<C1920a> provider2) {
        if (f3701a || provider != null) {
            this.f3702b = provider;
            if (f3701a || provider2 != null) {
                this.f3703c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<yo> m2663a(Provider<ce> provider, Provider<C1920a> provider2) {
        return new yq(provider, provider2);
    }
}
