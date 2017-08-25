package com.vungle.publisher;

import com.vungle.publisher.db.C1730b;
import com.vungle.publisher.fu.C1771a;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.ho.C1783a;
import com.vungle.publisher.iq.C1792a;
import com.vungle.publisher.ky.C1806a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class afn implements MembersInjector<afl> {
    static final /* synthetic */ boolean f1360a = (!afn.class.desiredAssertionStatus());
    private final Provider<qh> f1361b;
    private final Provider<C1730b> f1362c;
    private final Provider<C1771a> f1363d;
    private final Provider<C1806a> f1364e;
    private final Provider<C1783a> f1365f;
    private final Provider<xp> f1366g;
    private final Provider<pu> f1367h;
    private final Provider<C1792a> f1368i;
    private final Provider<C1778a> f1369j;

    public final /* synthetic */ void injectMembers(Object obj) {
        afl com_vungle_publisher_afl = (afl) obj;
        if (com_vungle_publisher_afl == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_vungle_publisher_afl.f1349a = (qh) this.f1361b.get();
        com_vungle_publisher_afl.f1350b = (C1730b) this.f1362c.get();
        com_vungle_publisher_afl.f1351c = (C1771a) this.f1363d.get();
        com_vungle_publisher_afl.f1352d = (C1806a) this.f1364e.get();
        com_vungle_publisher_afl.f1353e = (C1783a) this.f1365f.get();
        com_vungle_publisher_afl.f1354f = (xp) this.f1366g.get();
        com_vungle_publisher_afl.f1355g = (pu) this.f1367h.get();
        com_vungle_publisher_afl.f1356h = (C1792a) this.f1368i.get();
        com_vungle_publisher_afl.f1357i = (C1778a) this.f1369j.get();
    }

    private afn(Provider<qh> provider, Provider<C1730b> provider2, Provider<C1771a> provider3, Provider<C1806a> provider4, Provider<C1783a> provider5, Provider<xp> provider6, Provider<pu> provider7, Provider<C1792a> provider8, Provider<C1778a> provider9) {
        if (f1360a || provider != null) {
            this.f1361b = provider;
            if (f1360a || provider2 != null) {
                this.f1362c = provider2;
                if (f1360a || provider3 != null) {
                    this.f1363d = provider3;
                    if (f1360a || provider4 != null) {
                        this.f1364e = provider4;
                        if (f1360a || provider5 != null) {
                            this.f1365f = provider5;
                            if (f1360a || provider6 != null) {
                                this.f1366g = provider6;
                                if (f1360a || provider7 != null) {
                                    this.f1367h = provider7;
                                    if (f1360a || provider8 != null) {
                                        this.f1368i = provider8;
                                        if (f1360a || provider9 != null) {
                                            this.f1369j = provider9;
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
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<afl> m1193a(Provider<qh> provider, Provider<C1730b> provider2, Provider<C1771a> provider3, Provider<C1806a> provider4, Provider<C1783a> provider5, Provider<xp> provider6, Provider<pu> provider7, Provider<C1792a> provider8, Provider<C1778a> provider9) {
        return new afn(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }
}
