package com.vungle.publisher;

import android.content.Context;
import android.net.wifi.WifiManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class pe implements MembersInjector<pc> {
    static final /* synthetic */ boolean f2879a = (!pe.class.desiredAssertionStatus());
    private final Provider<Context> f2880b;
    private final Provider<qh> f2881c;
    private final Provider<ce> f2882d;
    private final Provider<WifiManager> f2883e;

    public final /* synthetic */ void injectMembers(Object obj) {
        pc pcVar = (pc) obj;
        if (pcVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        pcVar.f2872c = (Context) this.f2880b.get();
        pcVar.f2873d = (qh) this.f2881c.get();
        pcVar.f2874e = (ce) this.f2882d.get();
        pcVar.f2875a = (Context) this.f2880b.get();
        pcVar.f2876b = (WifiManager) this.f2883e.get();
    }

    private pe(Provider<Context> provider, Provider<qh> provider2, Provider<ce> provider3, Provider<WifiManager> provider4) {
        if (f2879a || provider != null) {
            this.f2880b = provider;
            if (f2879a || provider2 != null) {
                this.f2881c = provider2;
                if (f2879a || provider3 != null) {
                    this.f2882d = provider3;
                    if (f2879a || provider4 != null) {
                        this.f2883e = provider4;
                        return;
                    }
                    throw new AssertionError();
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<pc> m2326a(Provider<Context> provider, Provider<qh> provider2, Provider<ce> provider3, Provider<WifiManager> provider4) {
        return new pe(provider, provider2, provider3, provider4);
    }
}
