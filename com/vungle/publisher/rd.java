package com.vungle.publisher;

import android.content.Context;
import android.media.AudioManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* compiled from: vungle */
public final class rd implements Factory<AudioManager> {
    static final /* synthetic */ boolean f3055a = (!rd.class.desiredAssertionStatus());
    private final ra f3056b;
    private final Provider<Context> f3057c;

    private rd(ra raVar, Provider<Context> provider) {
        if (f3055a || raVar != null) {
            this.f3056b = raVar;
            if (f3055a || provider != null) {
                this.f3057c = provider;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static Factory<AudioManager> m2383a(ra raVar, Provider<Context> provider) {
        return new rd(raVar, provider);
    }

    public final /* synthetic */ Object get() {
        AudioManager audioManager = (AudioManager) ((Context) this.f3057c.get()).getSystemService("audio");
        if (audioManager == null) {
            so.m2470a(3, "VungleDevice", "AudioManager not avaialble", null);
        }
        return (AudioManager) Preconditions.checkNotNull(audioManager, "Cannot return null from a non-@Nullable @Provides method");
    }
}
