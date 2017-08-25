package com.vungle.publisher;

import com.vungle.publisher.env.WrapperFramework;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* compiled from: vungle */
public final class rq implements Factory<WrapperFramework> {
    static final /* synthetic */ boolean f3093a = (!rq.class.desiredAssertionStatus());
    private final ra f3094b;

    private rq(ra raVar) {
        if (f3093a || raVar != null) {
            this.f3094b = raVar;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<WrapperFramework> m2396a(ra raVar) {
        return new rq(raVar);
    }

    public final /* synthetic */ Object get() {
        Object obj;
        ra raVar = this.f3094b;
        if (raVar.f3047e == null) {
            obj = WrapperFramework.none;
        } else {
            obj = raVar.f3047e;
        }
        return (WrapperFramework) Preconditions.checkNotNull(obj, "Cannot return null from a non-@Nullable @Provides method");
    }
}
