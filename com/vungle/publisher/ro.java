package com.vungle.publisher;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* compiled from: vungle */
public final class ro implements Factory<Class> {
    static final /* synthetic */ boolean f3088a = (!ro.class.desiredAssertionStatus());
    private final ra f3089b;

    private ro(ra raVar) {
        if (f3088a || raVar != null) {
            this.f3089b = raVar;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<Class> m2394a(ra raVar) {
        return new ro(raVar);
    }

    public final /* synthetic */ Object get() {
        Object obj;
        ra raVar = this.f3089b;
        if (raVar.f3045c == null) {
            obj = VideoFullScreenAdActivity.class;
        } else {
            obj = raVar.f3045c;
        }
        return (Class) Preconditions.checkNotNull(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
