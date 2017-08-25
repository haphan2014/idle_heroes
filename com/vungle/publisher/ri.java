package com.vungle.publisher;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ri implements Factory<sn> {
    static final /* synthetic */ boolean f3070a = (!ri.class.desiredAssertionStatus());
    private final ra f3071b;
    private final Provider<sb> f3072c;

    private ri(ra raVar, Provider<sb> provider) {
        if (f3070a || raVar != null) {
            this.f3071b = raVar;
            if (f3070a || provider != null) {
                this.f3072c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<sn> m2388a(ra raVar, Provider<sb> provider) {
        return new ri(raVar, provider);
    }

    public final /* synthetic */ Object get() {
        return (sn) Preconditions.checkNotNull((sb) this.f3072c.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
