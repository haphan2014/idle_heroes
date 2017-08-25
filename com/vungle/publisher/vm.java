package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import java.io.IOException;
import java.net.HttpURLConnection;
import javax.inject.Inject;
import org.json.JSONException;

/* compiled from: vungle */
public abstract class vm {
    @Inject
    protected C1778a f800a;
    @Inject
    protected wa f801b;

    protected void mo4350b(vr vrVar, vl vlVar) {
        mo4557d(vrVar, vlVar);
    }

    public void mo4351c(vr vrVar, vl vlVar) throws IOException, JSONException {
    }

    public void mo4557d(vr vrVar, vl vlVar) {
        so.m2470a(5, "VungleNetwork", vrVar.f3468a + " failed permanently with response code " + vlVar.f3456b, null);
    }

    protected static boolean m832a(int i) {
        return i == 200;
    }

    protected final String m833a(HttpURLConnection httpURLConnection) throws IOException {
        return this.f801b.m2566a(httpURLConnection);
    }

    protected final void m834a(vr vrVar, vl vlVar) {
        try {
            if (m832a(vlVar.f3456b)) {
                try {
                    mo4351c(vrVar, vlVar);
                    return;
                } catch (Throwable e) {
                    so.m2470a(3, "VungleNetwork", null, e);
                    vlVar.f3456b = 603;
                } catch (Throwable e2) {
                    this.f800a.m1867b("VungleNetwork", "IOException while handling response: " + vlVar, e2);
                    vlVar.f3456b = 600;
                } catch (Throwable e22) {
                    this.f800a.m1867b("VungleNetwork", "JSONException while handling response: " + vlVar, e22);
                    vlVar.f3456b = 604;
                }
            }
            mo4350b(vrVar, vlVar);
        } catch (Throwable e222) {
            this.f800a.m1865a("VungleNetwork", "error while handling response: " + vlVar, e222);
            mo4557d(vrVar, vlVar);
        }
    }
}
