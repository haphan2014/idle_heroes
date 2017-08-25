package com.vungle.publisher;

import com.vungle.publisher.inject.EndpointModule;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* compiled from: vungle */
public final class ru implements Factory<String> {
    static final /* synthetic */ boolean f3156a = (!ru.class.desiredAssertionStatus());
    private final EndpointModule f3157b;

    private ru(EndpointModule endpointModule) {
        if (f3156a || endpointModule != null) {
            this.f3157b = endpointModule;
            return;
        }
        throw new AssertionError();
    }

    public static Factory<String> m2420a(EndpointModule endpointModule) {
        return new ru(endpointModule);
    }

    public final /* synthetic */ Object get() {
        return (String) Preconditions.checkNotNull(this.f3157b.f2178a, "Cannot return null from a non-@Nullable @Provides method");
    }
}
