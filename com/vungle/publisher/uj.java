package com.vungle.publisher;

import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class uj implements MembersInjector<uh> {
    static final /* synthetic */ boolean f3342a = (!uj.class.desiredAssertionStatus());
    private final Provider<ConnectivityManager> f3343b;
    private final Provider<uo> f3344c;
    private final Provider<TelephonyManager> f3345d;

    public final /* synthetic */ void injectMembers(Object obj) {
        uh uhVar = (uh) obj;
        if (uhVar == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        uhVar.f3337a = (ConnectivityManager) this.f3343b.get();
        uhVar.f3338b = this.f3344c;
        uhVar.f3339c = (TelephonyManager) this.f3345d.get();
    }

    private uj(Provider<ConnectivityManager> provider, Provider<uo> provider2, Provider<TelephonyManager> provider3) {
        if (f3342a || provider != null) {
            this.f3343b = provider;
            if (f3342a || provider2 != null) {
                this.f3344c = provider2;
                if (f3342a || provider3 != null) {
                    this.f3345d = provider3;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<uh> m2526a(Provider<ConnectivityManager> provider, Provider<uo> provider2, Provider<TelephonyManager> provider3) {
        return new uj(provider, provider2, provider3);
    }
}
