package com.vungle.publisher;

import com.vungle.publisher.acs.C1663a;
import com.vungle.publisher.adh.C1671a;
import com.vungle.publisher.adn.C1673a;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: vungle */
public final class zj extends wi {
    @Inject
    qh f3775g;
    @Inject
    C1673a f3776h;
    @Inject
    C1671a f3777i;
    @Inject
    C1663a f3778j;

    @Inject
    zj() {
    }

    protected final void mo4557d(vr vrVar, vl vlVar) {
        this.f3775g.m2361a(new ar());
    }

    protected final void mo4351c(vr vrVar, vl vlVar) throws IOException, JSONException {
        acs com_vungle_publisher_acs = (acs) this.f3778j.m912a(m833a(vlVar.f3455a));
        C1893v c1893v = com_vungle_publisher_acs.f1046e;
        final JSONObject jSONObject = com_vungle_publisher_acs.f1055l;
        if (c1893v == null) {
            so.m2470a(5, "VungleNetwork", "received ad with null ad type", null);
            mo4557d(vrVar, vlVar);
            return;
        }
        final wx wxVar = vrVar.f3470c;
        final vr vrVar2 = vrVar;
        final vl vlVar2 = vlVar;
        new aa<Void>(this) {
            final /* synthetic */ zj f3774e;

            protected final /* synthetic */ Object mo4373b() {
                return m2695e();
            }

            protected final /* synthetic */ Object mo4375d() {
                return m2696f();
            }

            private Void m2695e() {
                try {
                    this.f3774e.f3775g.m2361a(new ba(this.f3774e.f3776h.m1081b(jSONObject), wxVar));
                } catch (Throwable e) {
                    this.f3774e.a.m1867b("VungleNetwork", "error parsing json response from RequestStreamingAd for vungle streaming ad", e);
                }
                return null;
            }

            private Void m2696f() {
                try {
                    this.f3774e.f3775g.m2361a(new az(this.f3774e.f3777i.m1065b(jSONObject), wxVar));
                } catch (Throwable e) {
                    this.f3774e.a.m1867b("VungleNetwork", "error parsing json response from RequestStreamingAd for third party mraid ad", e);
                }
                return null;
            }

            protected final /* synthetic */ Object mo4374c() {
                this.f3774e.a.m1867b("VungleNetwork", "received vungle mraid ad, expected streaming ad from server, ignoring", new RuntimeException());
                this.f3774e.mo4557d(vrVar2, vlVar2);
                return null;
            }

            protected final /* synthetic */ Object mo4372a() {
                this.f3774e.a.m1867b("VungleNetwork", "received local ad, expected streaming ad from server, ignoring", new RuntimeException());
                this.f3774e.mo4557d(vrVar2, vlVar2);
                return null;
            }
        }.m811a(c1893v);
    }
}
