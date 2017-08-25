package com.vungle.publisher;

import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.ade.C1670a;
import com.vungle.publisher.adq.C1675a.C1674a;
import com.vungle.publisher.aec.C1679a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class adg implements MembersInjector<C1670a> {
    static final /* synthetic */ boolean f1122a = (!adg.class.desiredAssertionStatus());
    private final Provider<C1892a> f1123b;
    private final Provider<C1674a> f1124c;
    private final Provider<agg> f1125d;
    private final Provider<C1679a> f1126e;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1670a c1670a = (C1670a) obj;
        if (c1670a == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1670a.f1041a = (C1892a) this.f1123b.get();
        c1670a.f1105d = (C1674a) this.f1124c.get();
        c1670a.f1106b = (agg) this.f1125d.get();
        c1670a.f1107c = (C1679a) this.f1126e.get();
    }

    private adg(Provider<C1892a> provider, Provider<C1674a> provider2, Provider<agg> provider3, Provider<C1679a> provider4) {
        if (f1122a || provider != null) {
            this.f1123b = provider;
            if (f1122a || provider2 != null) {
                this.f1124c = provider2;
                if (f1122a || provider3 != null) {
                    this.f1125d = provider3;
                    if (f1122a || provider4 != null) {
                        this.f1126e = provider4;
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

    public static MembersInjector<C1670a> m1062a(Provider<C1892a> provider, Provider<C1674a> provider2, Provider<agg> provider3, Provider<C1679a> provider4) {
        return new adg(provider, provider2, provider3, provider4);
    }
}
