package com.vungle.publisher;

import com.vungle.publisher.vr.C1626a;
import com.vungle.publisher.wy.C1903a;
import dagger.Lazy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class xb extends C1626a {
    @Inject
    C1903a f3556b;
    @Inject
    Lazy<us> f3557c;
    @Inject
    Lazy<vb> f3558d;

    @Inject
    xb() {
    }

    public final vr m2598a(cu cuVar, jt jtVar, String str) {
        vm vmVar;
        if (jtVar.mo4482a()) {
            vmVar = (vm) this.f3557c.get();
        } else {
            vmVar = (vm) this.f3558d.get();
        }
        wy wyVar = (wy) this.f3556b.mo4345b();
        wyVar.f3548e = cuVar;
        wyVar.f3549f = jtVar;
        wyVar.f788b = str;
        return super.m842a(wyVar, vmVar);
    }
}
