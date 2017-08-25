package com.vungle.publisher;

import com.vungle.publisher.uv.C1890a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class afa implements MembersInjector<aey> {
    static final /* synthetic */ boolean f1302a = (!afa.class.desiredAssertionStatus());
    private final Provider<C1890a> f1303b;
    private final Provider<xe> f1304c;
    private final Provider<xm> f1305d;
    private final Provider<afb> f1306e;

    public final /* synthetic */ void injectMembers(Object obj) {
        aey com_vungle_publisher_aey = (aey) obj;
        if (com_vungle_publisher_aey == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_vungle_publisher_aey.f1295a = (C1890a) this.f1303b.get();
        com_vungle_publisher_aey.f1296b = (xe) this.f1304c.get();
        com_vungle_publisher_aey.f1297c = (xm) this.f1305d.get();
        com_vungle_publisher_aey.f1298d = (afb) this.f1306e.get();
    }

    private afa(Provider<C1890a> provider, Provider<xe> provider2, Provider<xm> provider3, Provider<afb> provider4) {
        if (f1302a || provider != null) {
            this.f1303b = provider;
            if (f1302a || provider2 != null) {
                this.f1304c = provider2;
                if (f1302a || provider3 != null) {
                    this.f1305d = provider3;
                    if (f1302a || provider4 != null) {
                        this.f1306e = provider4;
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

    public static MembersInjector<aey> m1164a(Provider<C1890a> provider, Provider<xe> provider2, Provider<xm> provider3, Provider<afb> provider4) {
        return new afa(provider, provider2, provider3, provider4);
    }
}
