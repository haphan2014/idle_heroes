package com.vungle.publisher;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class rk implements Factory<un> {
    static final /* synthetic */ boolean f3075a = (!rk.class.desiredAssertionStatus());
    private final ra f3076b;
    private final Provider<uh> f3077c;

    private rk(ra raVar, Provider<uh> provider) {
        if (f3075a || raVar != null) {
            this.f3076b = raVar;
            if (f3075a || provider != null) {
                this.f3077c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<un> m2390a(ra raVar, Provider<uh> provider) {
        return new rk(raVar, provider);
    }

    public final /* synthetic */ Object get() {
        return (un) Preconditions.checkNotNull((uh) this.f3077c.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
