package com.vungle.publisher;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.WindowManager;
import com.vungle.publisher.env.AndroidDevice;
import com.vungle.publisher.env.AndroidDevice.DeviceIdStrategy;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class ph implements MembersInjector<AndroidDevice> {
    static final /* synthetic */ boolean f2888a = (!ph.class.desiredAssertionStatus());
    private final Provider<mc> f2889b;
    private final Provider<WindowManager> f2890c;
    private final Provider<Context> f2891d;
    private final Provider<qh> f2892e;
    private final Provider<SharedPreferences> f2893f;
    private final Provider<DeviceIdStrategy> f2894g;
    private final Provider<String> f2895h;

    public final /* synthetic */ void injectMembers(Object obj) {
        AndroidDevice androidDevice = (AndroidDevice) obj;
        if (androidDevice == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        androidDevice.f1771f = (mc) this.f2889b.get();
        androidDevice.f1772g = (WindowManager) this.f2890c.get();
        androidDevice.f1773h = (Context) this.f2891d.get();
        androidDevice.f1774i = (qh) this.f2892e.get();
        androidDevice.f1775j = (SharedPreferences) this.f2893f.get();
        androidDevice.f1776k = (DeviceIdStrategy) this.f2894g.get();
        androidDevice.f1777l = (String) this.f2895h.get();
    }

    private ph(Provider<mc> provider, Provider<WindowManager> provider2, Provider<Context> provider3, Provider<qh> provider4, Provider<SharedPreferences> provider5, Provider<DeviceIdStrategy> provider6, Provider<String> provider7) {
        if (f2888a || provider != null) {
            this.f2889b = provider;
            if (f2888a || provider2 != null) {
                this.f2890c = provider2;
                if (f2888a || provider3 != null) {
                    this.f2891d = provider3;
                    if (f2888a || provider4 != null) {
                        this.f2892e = provider4;
                        if (f2888a || provider5 != null) {
                            this.f2893f = provider5;
                            if (f2888a || provider6 != null) {
                                this.f2894g = provider6;
                                if (f2888a || provider7 != null) {
                                    this.f2895h = provider7;
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
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<AndroidDevice> m2328a(Provider<mc> provider, Provider<WindowManager> provider2, Provider<Context> provider3, Provider<qh> provider4, Provider<SharedPreferences> provider5, Provider<DeviceIdStrategy> provider6, Provider<String> provider7) {
        return new ph(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }
}
