package com.vungle.publisher;

import dagger.Lazy;
import java.io.IOException;
import javax.inject.Inject;
import org.json.JSONException;

/* compiled from: vungle */
public final class xw extends wd {
    @Inject
    protected Lazy<afl> f3637g;

    @Inject
    xw() {
    }

    protected final void mo4351c(vr vrVar, vl vlVar) throws IOException, JSONException {
        xt xtVar = (xt) vrVar.f3468a;
        afl com_vungle_publisher_afl = (afl) this.f3637g.get();
        so.m2470a(4, "VungleReport", "deleting report " + xtVar.f3628f, null);
        com_vungle_publisher_afl.f1351c.m1272a((Object[]) new Integer[]{r2});
        xtVar.f3627e.m1341o();
    }
}
