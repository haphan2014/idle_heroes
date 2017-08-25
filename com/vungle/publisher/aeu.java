package com.vungle.publisher;

import com.vungle.publisher.afd.C1699a;
import com.vungle.publisher.afg.C1700a;
import com.vungle.publisher.afg.C1702b;
import com.vungle.publisher.zd.C1923a;
import dagger.MembersInjector;
import javax.inject.Provider;

/* compiled from: vungle */
public final class aeu implements MembersInjector<aes> {
    static final /* synthetic */ boolean f1259a = (!aeu.class.desiredAssertionStatus());
    private final Provider<C1923a> f1260b;
    private final Provider<xm> f1261c;
    private final Provider<aev> f1262d;
    private final Provider<xj> f1263e;
    private final Provider<xg> f1264f;
    private final Provider<C1699a> f1265g;
    private final Provider<C1702b> f1266h;
    private final Provider<C1700a> f1267i;
    private final Provider<aep> f1268j;
    private final Provider<pu> f1269k;
    private final Provider<afb> f1270l;

    public final /* synthetic */ void injectMembers(Object obj) {
        aes com_vungle_publisher_aes = (aes) obj;
        if (com_vungle_publisher_aes == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        com_vungle_publisher_aes.f1246b = (C1923a) this.f1260b.get();
        com_vungle_publisher_aes.f1247c = (xm) this.f1261c.get();
        com_vungle_publisher_aes.f1248d = (aev) this.f1262d.get();
        com_vungle_publisher_aes.f1249e = (xj) this.f1263e.get();
        com_vungle_publisher_aes.f1250f = (xg) this.f1264f.get();
        com_vungle_publisher_aes.f1251g = (C1699a) this.f1265g.get();
        com_vungle_publisher_aes.f1252h = (C1702b) this.f1266h.get();
        com_vungle_publisher_aes.f1253i = (C1700a) this.f1267i.get();
        com_vungle_publisher_aes.f1254j = (aep) this.f1268j.get();
        com_vungle_publisher_aes.f1255k = (pu) this.f1269k.get();
        com_vungle_publisher_aes.f1256l = (afb) this.f1270l.get();
    }

    private aeu(Provider<C1923a> provider, Provider<xm> provider2, Provider<aev> provider3, Provider<xj> provider4, Provider<xg> provider5, Provider<C1699a> provider6, Provider<C1702b> provider7, Provider<C1700a> provider8, Provider<aep> provider9, Provider<pu> provider10, Provider<afb> provider11) {
        if (f1259a || provider != null) {
            this.f1260b = provider;
            if (f1259a || provider2 != null) {
                this.f1261c = provider2;
                if (f1259a || provider3 != null) {
                    this.f1262d = provider3;
                    if (f1259a || provider4 != null) {
                        this.f1263e = provider4;
                        if (f1259a || provider5 != null) {
                            this.f1264f = provider5;
                            if (f1259a || provider6 != null) {
                                this.f1265g = provider6;
                                if (f1259a || provider7 != null) {
                                    this.f1266h = provider7;
                                    if (f1259a || provider8 != null) {
                                        this.f1267i = provider8;
                                        if (f1259a || provider9 != null) {
                                            this.f1268j = provider9;
                                            if (f1259a || provider10 != null) {
                                                this.f1269k = provider10;
                                                if (f1259a || provider11 != null) {
                                                    this.f1270l = provider11;
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
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public static MembersInjector<aes> m1155a(Provider<C1923a> provider, Provider<xm> provider2, Provider<aev> provider3, Provider<xj> provider4, Provider<xg> provider5, Provider<C1699a> provider6, Provider<C1702b> provider7, Provider<C1700a> provider8, Provider<aep> provider9, Provider<pu> provider10, Provider<afb> provider11) {
        return new aeu(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11);
    }
}
