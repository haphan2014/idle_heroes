package com.vungle.publisher;

import android.os.Bundle;
import com.vungle.publisher.inject.Injector;
import com.vungle.publisher.mz.C1825a;
import com.vungle.publisher.on.C1847a;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class oc extends mz<on> {
    @Inject
    C1847a f2731m;

    @Singleton
    /* compiled from: vungle */
    public static class C1844a extends C1825a<oc> {
        @Inject
        Provider<oc> f2730a;

        @Inject
        C1844a() {
        }

        protected final String mo4501b() {
            return "postRollFragment";
        }

        protected final /* synthetic */ mz mo4500a() {
            return (oc) this.f2730a.get();
        }
    }

    public final void mo4505a() {
        try {
            this.j.m2361a(new at());
        } catch (Throwable e) {
            so.m2470a(5, "VungleAd", "exception in onBackPressed", e);
        }
    }

    public final String mo4507b() {
        return "postRollFragment";
    }

    public final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Injector.getInstance().m1976c()) {
            Injector.m1974b().mo4530a(this);
            return;
        }
        so.m2470a(5, "VungleAd", "SDK not initialized", null);
        getActivity().finish();
    }

    protected final /* bridge */ /* synthetic */ mx mo4504a(String str, C1617z c1617z) {
        return (on) this.f2731m.m2178a(str, c1617z);
    }
}
