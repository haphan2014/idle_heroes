package com.vungle.publisher;

import com.vungle.publisher.inject.EndpointModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* compiled from: vungle */
public final class rt implements Factory<String> {
    static final /* synthetic */ boolean f3154a = (!rt.class.desiredAssertionStatus());
    private final EndpointModule f3155b;

    private rt(EndpointModule endpointModule) {
        if (f3154a || endpointModule != null) {
            this.f3155b = endpointModule;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<String> m2419a(EndpointModule endpointModule) {
        return new rt(endpointModule);
    }

    public final /* synthetic */ Object get() {
        return (String) Preconditions.checkNotNull(this.f3155b.f2179b, "Cannot return null from a non-@Nullable @Provides method");
    }
}
