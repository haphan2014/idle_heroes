package com.vungle.publisher;

import com.vungle.publisher.env.AndroidDevice;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class rf implements Factory<pj> {
    static final /* synthetic */ boolean f3061a = (!rf.class.desiredAssertionStatus());
    private final ra f3062b;
    private final Provider<AndroidDevice> f3063c;

    private rf(ra raVar, Provider<AndroidDevice> provider) {
        if (f3061a || raVar != null) {
            this.f3062b = raVar;
            if (f3061a || provider != null) {
                this.f3063c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<pj> m2385a(ra raVar, Provider<AndroidDevice> provider) {
        return new rf(raVar, provider);
    }

    public final /* synthetic */ Object get() {
        return (pj) Preconditions.checkNotNull((AndroidDevice) this.f3063c.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
