package com.vungle.publisher;

import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;

@Singleton
/* compiled from: vungle */
public final class aae extends vb {
    @Inject
    pu f808g;

    @Inject
    aae() {
    }

    protected final void mo4351c(vr vrVar, vl vlVar) throws IOException, JSONException {
        super.mo4351c(vrVar, vlVar);
        this.f808g.f2943l.edit().putBoolean("IsVgAppInstalled", true).apply();
    }
}
