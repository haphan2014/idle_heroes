package com.vungle.publisher;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* compiled from: vungle */
public final class rr implements Factory<String> {
    static final /* synthetic */ boolean f3095a = (!rr.class.desiredAssertionStatus());
    private final ra f3096b;

    private rr(ra raVar) {
        if (f3095a || raVar != null) {
            this.f3096b = raVar;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<String> m2397a(ra raVar) {
        return new rr(raVar);
    }

    public final /* synthetic */ Object get() {
        Object obj;
        ra raVar = this.f3096b;
        if (raVar.f3048f == null) {
            obj = "";
        } else {
            obj = raVar.f3048f;
        }
        return (String) Preconditions.checkNotNull(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
