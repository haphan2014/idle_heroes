package com.vungle.publisher;

import com.vungle.publisher.env.AndroidDevice.DeviceIdStrategy;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class rw implements Factory<DeviceIdStrategy> {
    static final /* synthetic */ boolean f3158a = (!rw.class.desiredAssertionStatus());
    private final rv f3159b;
    private final Provider<pc> f3160c;

    private rw(rv rvVar, Provider<pc> provider) {
        if (f3158a || rvVar != null) {
            this.f3159b = rvVar;
            if (f3158a || provider != null) {
                this.f3160c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<DeviceIdStrategy> m2421a(rv rvVar, Provider<pc> provider) {
        return new rw(rvVar, provider);
    }

    public final /* synthetic */ Object get() {
        return (DeviceIdStrategy) Preconditions.checkNotNull((pc) this.f3160c.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
