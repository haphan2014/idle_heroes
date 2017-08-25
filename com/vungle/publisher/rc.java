package com.vungle.publisher;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* compiled from: vungle */
public final class rc implements Factory<Context> {
    static final /* synthetic */ boolean f3053a = (!rc.class.desiredAssertionStatus());
    private final ra f3054b;

    private rc(ra raVar) {
        if (f3053a || raVar != null) {
            this.f3054b = raVar;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<Context> m2382a(ra raVar) {
        return new rc(raVar);
    }

    public final /* synthetic */ Object get() {
        return (Context) Preconditions.checkNotNull(this.f3054b.f3043a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
