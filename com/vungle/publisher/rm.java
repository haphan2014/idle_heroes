package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.env.WrapperFramework;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class rm implements Factory<pq> {
    static final /* synthetic */ boolean f3081a = (!rm.class.desiredAssertionStatus());
    private final ra f3082b;
    private final Provider<Context> f3083c;
    private final Provider<WrapperFramework> f3084d;

    private rm(ra raVar, Provider<Context> provider, Provider<WrapperFramework> provider2) {
        if (f3081a || raVar != null) {
            this.f3082b = raVar;
            if (f3081a || provider != null) {
                this.f3083c = provider;
                if (f3081a || provider2 != null) {
                    this.f3084d = provider2;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<pq> m2392a(ra raVar, Provider<Context> provider, Provider<WrapperFramework> provider2) {
        return new rm(raVar, provider, provider2);
    }

    public final /* synthetic */ Object get() {
        return (pq) Preconditions.checkNotNull(new pi(((Context) this.f3083c.get()).getPackageName(), this.f3082b.f3044b, (WrapperFramework) this.f3084d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
