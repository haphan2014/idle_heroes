package com.vungle.publisher;

import com.vungle.publisher.vr.C1626a;
import com.vungle.publisher.xt.C1915b;
import com.vungle.publisher.xt.C1915b.C19141;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONException;

@Singleton
/* compiled from: vungle */
public final class xz extends C1626a {
    @Inject
    C1915b f3645b;
    @Inject
    Provider<xw> f3646c;

    @Inject
    xz() {
    }

    public final vr m2637a(db<?, ?, ?, ?> dbVar) throws JSONException {
        C1915b c1915b = this.f3645b;
        return super.m842a((xt) new C19141(c1915b, dbVar).m811a(dbVar.mo4476b().mo4474f()), (vm) this.f3646c.get());
    }
}
