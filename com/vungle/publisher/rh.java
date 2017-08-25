package com.vungle.publisher;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class rh implements Factory<sf> {
    static final /* synthetic */ boolean f3067a = (!rh.class.desiredAssertionStatus());
    private final ra f3068b;
    private final Provider<sg> f3069c;

    private rh(ra raVar, Provider<sg> provider) {
        if (f3067a || raVar != null) {
            this.f3068b = raVar;
            if (f3067a || provider != null) {
                this.f3069c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<sf> m2387a(ra raVar, Provider<sg> provider) {
        return new rh(raVar, provider);
    }

    public final /* synthetic */ Object get() {
        return (sf) Preconditions.checkNotNull((sg) this.f3069c.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
