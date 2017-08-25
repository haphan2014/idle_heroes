package com.vungle.publisher;

import android.content.Context;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;

/* compiled from: vungle */
public final class cr implements Factory<cq> {
    static final /* synthetic */ boolean f1522a = (!cr.class.desiredAssertionStatus());
    private final MembersInjector<cq> f1523b;
    private final Provider<Context> f1524c;

    private cr(MembersInjector<cq> membersInjector, Provider<Context> provider) {
        if (f1522a || membersInjector != null) {
            this.f1523b = membersInjector;
            if (f1522a || provider != null) {
                this.f1524c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<cq> m1267a(MembersInjector<cq> membersInjector, Provider<Context> provider) {
        return new cr(membersInjector, provider);
    }

    public final /* synthetic */ Object get() {
        return (cq) MembersInjectors.injectMembers(this.f1523b, new cq((Context) this.f1524c.get()));
    }
}
