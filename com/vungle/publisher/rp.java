package com.vungle.publisher;

import android.content.Context;
import android.view.WindowManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class rp implements Factory<WindowManager> {
    static final /* synthetic */ boolean f3090a = (!rp.class.desiredAssertionStatus());
    private final ra f3091b;
    private final Provider<Context> f3092c;

    private rp(ra raVar, Provider<Context> provider) {
        if (f3090a || raVar != null) {
            this.f3091b = raVar;
            if (f3090a || provider != null) {
                this.f3092c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<WindowManager> m2395a(ra raVar, Provider<Context> provider) {
        return new rp(raVar, provider);
    }

    public final /* synthetic */ Object get() {
        WindowManager windowManager = (WindowManager) ((Context) this.f3092c.get()).getSystemService("window");
        if (windowManager == null) {
            so.m2470a(3, "VungleDevice", "WindowManager not available", null);
        }
        return (WindowManager) Preconditions.checkNotNull(windowManager, "Cannot return null from a non-@Nullable @Provides method");
    }
}
