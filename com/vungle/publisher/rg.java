package com.vungle.publisher;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class rg implements Factory<SharedPreferences> {
    static final /* synthetic */ boolean f3064a = (!rg.class.desiredAssertionStatus());
    private final ra f3065b;
    private final Provider<Context> f3066c;

    private rg(ra raVar, Provider<Context> provider) {
        if (f3064a || raVar != null) {
            this.f3065b = raVar;
            if (f3064a || provider != null) {
                this.f3066c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<SharedPreferences> m2386a(ra raVar, Provider<Context> provider) {
        return new rg(raVar, provider);
    }

    public final /* synthetic */ Object get() {
        return (SharedPreferences) Preconditions.checkNotNull(((Context) this.f3066c.get()).getSharedPreferences("VUNGLE_PUB_APP_INFO", 0), "Cannot return null from a non-@Nullable @Provides method");
    }
}
