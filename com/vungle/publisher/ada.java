package com.vungle.publisher;

import com.google.android.gms.tagmanager.DataLayer;
import com.vungle.publisher.acq.C1661a;
import com.vungle.publisher.ep.C1750a;
import dagger.Lazy;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class ada extends acq {
    List<ep> f1090g;
    C1668b[] f1091h;

    @Singleton
    /* compiled from: vungle */
    public static class C1666a extends C1661a<ada> {
        @Inject
        C1750a f1080f;
        @Inject
        C1667a f1081g;
        @Inject
        Lazy<pu> f1082h;

        public final /* synthetic */ aat mo4362a() {
            return m1031d();
        }

        public final /* synthetic */ acq mo4364c() {
            return m1031d();
        }

        @Inject
        C1666a() {
        }

        public final ada m1031d() {
            C1668b[] c1668bArr = null;
            ada com_vungle_publisher_ada = (ada) super.mo4364c();
            List<ep> d = this.f1080f.mo4387d();
            com_vungle_publisher_ada.f1090g = d;
            int size = d == null ? 0 : d.size();
            if (size > 0) {
                so.m2470a(3, "VungleReport", "sending " + size + " event_tracking_http_log records", null);
                C1668b[] c1668bArr2 = new C1668b[size];
                int i = 0;
                for (ep epVar : d) {
                    C1668b c1668b;
                    so.m2470a(2, "VungleReport", "sending " + epVar.mo4389z(), null);
                    int i2 = i + 1;
                    if (epVar != null) {
                        C1668b c1668b2 = new C1668b();
                        c1668b2.f1083a = epVar.f1784a;
                        c1668b2.f1084b = epVar.f1785b;
                        c1668b2.f1085c = Long.valueOf(epVar.f1787d);
                        c1668b2.f1086d = String.valueOf(epVar.f1786c);
                        c1668b2.f1087e = epVar.f1788e;
                        c1668b2.f1088f = epVar.f1789f;
                        c1668b2.f1089g = epVar.f1790g;
                        c1668b = c1668b2;
                    } else {
                        c1668b = null;
                    }
                    c1668bArr2[i] = c1668b;
                    i = i2;
                }
                c1668bArr = c1668bArr2;
            }
            com_vungle_publisher_ada.f1091h = c1668bArr;
            return com_vungle_publisher_ada;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new ada();
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4353a(int i) {
            return new ada[i];
        }
    }

    /* compiled from: vungle */
    static class C1668b extends aar {
        String f1083a;
        String f1084b;
        Long f1085c;
        String f1086d;
        Integer f1087e;
        Long f1088f;
        String f1089g;

        @Singleton
        /* compiled from: vungle */
        static class C1667a extends abj<C1668b> {
            @Inject
            C1667a() {
            }

            protected final /* synthetic */ Object mo4354b() {
                return new C1668b();
            }

            protected final /* bridge */ /* synthetic */ Object[] mo4353a(int i) {
                return new C1668b[i];
            }
        }

        C1668b() {
        }

        public final /* synthetic */ Object mo4352b() throws JSONException {
            return mo4355a();
        }

        public final JSONObject mo4355a() throws JSONException {
            JSONObject a = super.mo4355a();
            a.putOpt("campaignId", this.f1083a);
            a.putOpt("deliveryId", this.f1084b);
            a.putOpt("deviceMillis", this.f1085c);
            a.putOpt(DataLayer.EVENT_KEY, this.f1086d);
            a.putOpt("responseCode", this.f1087e);
            a.putOpt("responseMillis", this.f1088f);
            a.putOpt("url", this.f1089g);
            return a;
        }
    }

    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    ada() {
    }

    public final JSONObject mo4355a() throws JSONException {
        JSONObject a = super.mo4355a();
        a.putOpt("httpLog", sa.m2426a(this.f1091h));
        return a;
    }
}
