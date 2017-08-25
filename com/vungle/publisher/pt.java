package com.vungle.publisher;

import android.content.SharedPreferences;
import com.vungle.publisher.qb.C1868a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class pt implements MembersInjector<pr> {
    static final /* synthetic */ boolean f2925a = (!pt.class.desiredAssertionStatus());
    private final Provider<C1868a> f2926b;
    private final Provider<SharedPreferences> f2927c;

    public final /* synthetic */ void injectMembers(Object obj) {
        pr prVar = (pr) obj;
        if (prVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        prVar.f2921f = (C1868a) this.f2926b.get();
        prVar.f2922g = (SharedPreferences) this.f2927c.get();
    }

    private pt(Provider<C1868a> provider, Provider<SharedPreferences> provider2) {
        if (f2925a || provider != null) {
            this.f2926b = provider;
            if (f2925a || provider2 != null) {
                this.f2927c = provider2;
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<pr> m2346a(Provider<C1868a> provider, Provider<SharedPreferences> provider2) {
        return new pt(provider, provider2);
    }
}
