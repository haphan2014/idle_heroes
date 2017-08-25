package com.vungle.publisher;

import android.content.Context;
import com.vungle.publisher.mx.C1824b;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class nc<W extends mx> implements MembersInjector<C1824b<W>> {
    static final /* synthetic */ boolean f2618a = (!nc.class.desiredAssertionStatus());
    private final Provider<Context> f2619b;
    private final Provider<qh> f2620c;

    public final /* synthetic */ void injectMembers(Object obj) {
        C1824b c1824b = (C1824b) obj;
        if (c1824b == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        c1824b.f2599a = (Context) this.f2619b.get();
        c1824b.f2600b = (qh) this.f2620c.get();
    }

    public static <W extends mx> void m2188a(C1824b<W> c1824b, Provider<Context> provider) {
        c1824b.f2599a = (Context) provider.get();
    }

    public static <W extends mx> void m2189b(C1824b<W> c1824b, Provider<qh> provider) {
        c1824b.f2600b = (qh) provider.get();
    }
}
