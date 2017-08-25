package com.vungle.publisher;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* compiled from: vungle */
public final class rj implements Factory<Class> {
    static final /* synthetic */ boolean f3073a = (!rj.class.desiredAssertionStatus());
    private final ra f3074b;

    private rj(ra raVar) {
        if (f3073a || raVar != null) {
            this.f3074b = raVar;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<Class> m2389a(ra raVar) {
        return new rj(raVar);
    }

    public final /* synthetic */ Object get() {
        Object obj;
        ra raVar = this.f3074b;
        if (raVar.f3046d == null) {
            obj = MraidFullScreenAdActivity.class;
        } else {
            obj = raVar.f3046d;
        }
        return (Class) Preconditions.checkNotNull(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
