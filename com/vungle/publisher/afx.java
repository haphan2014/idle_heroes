package com.vungle.publisher;

import com.vungle.publisher.db.C1730b;
import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class afx implements MembersInjector<aft> {
    static final /* synthetic */ boolean f1395a = (!afx.class.desiredAssertionStatus());
    private final Provider<qh> f1396b;
    private final Provider<C1730b> f1397c;
    private final Provider<C1778a> f1398d;
    private final Provider<afl> f1399e;
    private final Provider<uy> f1400f;

    public final /* synthetic */ void injectMembers(Object obj) {
        aft com_vungle_publisher_aft = (aft) obj;
        if (com_vungle_publisher_aft == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_vungle_publisher_aft.f1341v = (qh) this.f1396b.get();
        com_vungle_publisher_aft.f1345d = (C1730b) this.f1397c.get();
        com_vungle_publisher_aft.f1346e = (C1778a) this.f1398d.get();
        com_vungle_publisher_aft.f1347f = (afl) this.f1399e.get();
        com_vungle_publisher_aft.f1348g = (uy) this.f1400f.get();
    }

    private afx(Provider<qh> provider, Provider<C1730b> provider2, Provider<C1778a> provider3, Provider<afl> provider4, Provider<uy> provider5) {
        if (f1395a || provider != null) {
            this.f1396b = provider;
            if (f1395a || provider2 != null) {
                this.f1397c = provider2;
                if (f1395a || provider3 != null) {
                    this.f1398d = provider3;
                    if (f1395a || provider4 != null) {
                        this.f1399e = provider4;
                        if (f1395a || provider5 != null) {
                            this.f1400f = provider5;
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

    public static MembersInjector<aft> m1204a(Provider<qh> provider, Provider<C1730b> provider2, Provider<C1778a> provider3, Provider<afl> provider4, Provider<uy> provider5) {
        return new afx(provider, provider2, provider3, provider4, provider5);
    }
}
