package com.vungle.publisher;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class rb implements Factory<String> {
    static final /* synthetic */ boolean f3050a = (!rb.class.desiredAssertionStatus());
    private final ra f3051b;
    private final Provider<Context> f3052c;

    private rb(ra raVar, Provider<Context> provider) {
        if (f3050a || raVar != null) {
            this.f3051b = raVar;
            if (f3050a || provider != null) {
                this.f3052c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<String> m2381a(ra raVar, Provider<Context> provider) {
        return new rb(raVar, provider);
    }

    public final /* synthetic */ Object get() {
        if (((Context) this.f3052c.get()).getExternalFilesDir(null) == null) {
            throw new qo();
        }
        return (String) Preconditions.checkNotNull(qt.m2369a(((Context) this.f3052c.get()).getExternalFilesDir(null).getAbsolutePath(), ".vungle"), "Cannot return null from a non-@Nullable @Provides method");
    }
}
