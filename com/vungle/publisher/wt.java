package com.vungle.publisher;

import com.vungle.publisher.vr.C1626a;
import com.vungle.publisher.wk.C1901a;
import com.vungle.publisher.wo.C1902a;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;

@Singleton
/* compiled from: vungle */
public final class wt extends C1626a {
    @Inject
    C1901a f3536b;
    @Inject
    C1902a f3537c;

    public final vr m2589a(List<gx> list) throws JSONException {
        vf a = this.f3536b.m2578a(list);
        wo woVar = (wo) this.f3537c.f3523a.get();
        woVar.f3524g = list;
        return super.m842a(a, woVar);
    }
}
