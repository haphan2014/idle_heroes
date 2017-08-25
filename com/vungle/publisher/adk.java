package com.vungle.publisher;

import com.vungle.publisher.abg.C1642a;
import com.vungle.publisher.acq.C1661a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class adk extends acq {
    abg f1137g;
    String f1138h;
    String f1139i;

    @Singleton
    /* compiled from: vungle */
    public static class C1672a extends C1661a<adk> {
        @Inject
        protected C1642a f1136f;

        @Inject
        C1672a() {
        }

        public final adk m1070a(String str, ab abVar) {
            adk com_vungle_publisher_adk = (adk) super.mo4364c();
            String placement = abVar.getPlacement();
            if (agf.m1219a(placement)) {
                com_vungle_publisher_adk.f1139i = placement;
            }
            com_vungle_publisher_adk.f1137g = C1642a.m928a(abVar.getExtras());
            com_vungle_publisher_adk.f1138h = str;
            return com_vungle_publisher_adk;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new adk();
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4353a(int i) {
            return new adk[i];
        }
    }

    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    public final JSONObject mo4355a() throws JSONException {
        JSONObject a = super.mo4355a();
        a.putOpt("campaignId", this.f1138h);
        a.putOpt("extraInfo", sa.m2427a(this.f1137g));
        a.putOpt("placement", this.f1139i);
        return a;
    }
}
