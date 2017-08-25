package com.vungle.publisher;

import android.media.AudioManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class me implements MembersInjector<mc> {
    static final /* synthetic */ boolean f2558a = (!me.class.desiredAssertionStatus());
    private final Provider<AudioManager> f2559b;

    public final /* synthetic */ void injectMembers(Object obj) {
        mc mcVar = (mc) obj;
        if (mcVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        mcVar.f2555b = (AudioManager) this.f2559b.get();
    }

    private me(Provider<AudioManager> provider) {
        if (f2558a || provider != null) {
            this.f2559b = provider;
            return;
        }
        throw new AssertionError();
    }

    public static MembersInjector<mc> m2164a(Provider<AudioManager> provider) {
        return new me(provider);
    }
}
