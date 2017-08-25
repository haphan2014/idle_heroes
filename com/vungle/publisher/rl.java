package com.vungle.publisher;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class rl implements Factory<String> {
    static final /* synthetic */ boolean f3078a = (!rl.class.desiredAssertionStatus());
    private final ra f3079b;
    private final Provider<Context> f3080c;

    private rl(ra raVar, Provider<Context> provider) {
        if (f3078a || raVar != null) {
            this.f3079b = raVar;
            if (f3078a || provider != null) {
                this.f3080c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<String> m2391a(ra raVar, Provider<Context> provider) {
        return new rl(raVar, provider);
    }

    public final /* synthetic */ Object get() {
        if (((Context) this.f3080c.get()).getExternalCacheDir() == null) {
            throw new qo();
        }
        return (String) Preconditions.checkNotNull(qt.m2369a(((Context) this.f3080c.get()).getExternalCacheDir(), ".VungleCacheDir"), "Cannot return null from a non-@Nullable @Provides method");
    }
}
