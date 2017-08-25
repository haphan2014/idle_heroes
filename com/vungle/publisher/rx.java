package com.vungle.publisher;

import android.content.Context;
import android.net.wifi.WifiManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class rx implements Factory<WifiManager> {
    static final /* synthetic */ boolean f3161a = (!rx.class.desiredAssertionStatus());
    private final rv f3162b;
    private final Provider<Context> f3163c;

    private rx(rv rvVar, Provider<Context> provider) {
        if (f3161a || rvVar != null) {
            this.f3162b = rvVar;
            if (f3161a || provider != null) {
                this.f3163c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<WifiManager> m2422a(rv rvVar, Provider<Context> provider) {
        return new rx(rvVar, provider);
    }

    public final /* synthetic */ Object get() {
        return (WifiManager) Preconditions.checkNotNull((WifiManager) ((Context) this.f3163c.get()).getSystemService("wifi"), "Cannot return null from a non-@Nullable @Provides method");
    }
}
