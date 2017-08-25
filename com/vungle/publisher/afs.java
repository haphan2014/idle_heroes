package com.vungle.publisher;

import com.vungle.publisher.cv.C1723a;
import com.vungle.publisher.db.C1730b;
import com.vungle.publisher.gx.C1778a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class afs implements MembersInjector<afo> {
    static final /* synthetic */ boolean f1378a = (!afs.class.desiredAssertionStatus());
    private final Provider<qh> f1379b;
    private final Provider<C1730b> f1380c;
    private final Provider<C1778a> f1381d;
    private final Provider<afl> f1382e;
    private final Provider<uy> f1383f;
    private final Provider<C1723a> f1384g;

    public final /* synthetic */ void injectMembers(Object obj) {
        afo com_vungle_publisher_afo = (afo) obj;
        if (com_vungle_publisher_afo == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_vungle_publisher_afo.f1341v = (qh) this.f1379b.get();
        com_vungle_publisher_afo.f1345d = (C1730b) this.f1380c.get();
        com_vungle_publisher_afo.f1346e = (C1778a) this.f1381d.get();
        com_vungle_publisher_afo.f1347f = (afl) this.f1382e.get();
        com_vungle_publisher_afo.f1348g = (uy) this.f1383f.get();
        com_vungle_publisher_afo.f1371h = (C1723a) this.f1384g.get();
    }

    private afs(Provider<qh> provider, Provider<C1730b> provider2, Provider<C1778a> provider3, Provider<afl> provider4, Provider<uy> provider5, Provider<C1723a> provider6) {
        if (f1378a || provider != null) {
            this.f1379b = provider;
            if (f1378a || provider2 != null) {
                this.f1380c = provider2;
                if (f1378a || provider3 != null) {
                    this.f1381d = provider3;
                    if (f1378a || provider4 != null) {
                        this.f1382e = provider4;
                        if (f1378a || provider5 != null) {
                            this.f1383f = provider5;
                            if (f1378a || provider6 != null) {
                                this.f1384g = provider6;
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

    public static MembersInjector<afo> m1198a(Provider<qh> provider, Provider<C1730b> provider2, Provider<C1778a> provider3, Provider<afl> provider4, Provider<uy> provider5, Provider<C1723a> provider6) {
        return new afs(provider, provider2, provider3, provider4, provider5, provider6);
    }
}
