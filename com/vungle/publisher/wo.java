package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONException;

/* compiled from: vungle */
public final class wo extends vb {
    List<gx> f3524g;
    @Inject
    C1778a f3525h;

    @Singleton
    /* compiled from: vungle */
    public static class C1902a {
        @Inject
        Provider<wo> f3523a;

        @Inject
        C1902a() {
        }
    }

    @Inject
    wo() {
    }

    protected final void mo4351c(vr vrVar, vl vlVar) throws IOException, JSONException {
        super.mo4351c(vrVar, vlVar);
        this.f3525h.mo4381a(this.f3524g);
    }
}
