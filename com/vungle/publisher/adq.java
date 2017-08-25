package com.vungle.publisher;

import com.vungle.publisher.acr.C1662a;
import com.vungle.publisher.aeb.C1640a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public abstract class adq extends acr {
    protected String f1108n;
    protected C1675a f1109o;
    protected String f1110p;
    protected Integer f1111q;
    protected Integer f1112r;
    protected Integer f1113s;
    protected Integer f1114t;
    protected String f1115u;
    protected Integer f1116v;

    /* compiled from: vungle */
    public static abstract class C1669b<R extends adq, T extends C1640a<?>> extends C1662a<R, T> {
        @Inject
        protected C1674a f1105d;

        protected abstract T mo4365a();

        public /* synthetic */ acr mo4363a(JSONObject jSONObject) throws JSONException {
            return mo4366d(jSONObject);
        }

        public /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
            return mo4366d(jSONObject);
        }

        protected C1669b() {
        }

        public R mo4366d(JSONObject jSONObject) throws JSONException {
            adq com_vungle_publisher_adq = (adq) super.mo4363a(jSONObject);
            if (com_vungle_publisher_adq != null) {
                com_vungle_publisher_adq.f1108n = sa.m2430d(jSONObject, "callToActionDest");
                com_vungle_publisher_adq.f1109o = C1674a.m1087a(jSONObject.optJSONObject("cta_overlay"));
                com_vungle_publisher_adq.f1110p = sa.m2430d(jSONObject, "callToActionUrl");
                com_vungle_publisher_adq.f1111q = sa.m2429c(jSONObject, "showCloseIncentivized");
                com_vungle_publisher_adq.f1112r = sa.m2429c(jSONObject, "showClose");
                com_vungle_publisher_adq.f1113s = sa.m2429c(jSONObject, "countdown");
                com_vungle_publisher_adq.f1114t = sa.m2429c(jSONObject, "videoHeight");
                abi.m911a(jSONObject, "videoHeight", com_vungle_publisher_adq.f1114t);
                com_vungle_publisher_adq.f1115u = sa.m2430d(jSONObject, "url");
                abi.m911a(jSONObject, "url", com_vungle_publisher_adq.f1115u);
                com_vungle_publisher_adq.f1116v = sa.m2429c(jSONObject, "videoWidth");
                abi.m911a(jSONObject, "videoWidth", com_vungle_publisher_adq.f1116v);
                com_vungle_publisher_adq.d = mo4365a().mo4357b(jSONObject.optJSONObject("tpat"));
            }
            return com_vungle_publisher_adq;
        }
    }

    /* compiled from: vungle */
    public static class C1675a extends aar {
        protected Float f1159a;
        protected Integer f1160b;
        protected Boolean f1161c;
        protected Boolean f1162d;
        protected Integer f1163e;

        @Singleton
        /* compiled from: vungle */
        public static class C1674a extends abi<C1675a> {
            protected final /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
                return C1674a.m1087a(jSONObject);
            }

            @Inject
            C1674a() {
            }

            protected static C1675a m1087a(JSONObject jSONObject) throws JSONException {
                if (jSONObject == null) {
                    return null;
                }
                C1675a c1675a = new C1675a();
                c1675a.f1159a = sa.m2428b(jSONObject, "click_area");
                c1675a.f1161c = sa.m2424a(jSONObject, "enabled");
                c1675a.f1162d = sa.m2424a(jSONObject, "show_onclick");
                c1675a.f1163e = sa.m2429c(jSONObject, "time_show");
                c1675a.f1160b = sa.m2429c(jSONObject, "time_enabled");
                return c1675a;
            }

            protected final /* synthetic */ Object mo4354b() {
                return new C1675a();
            }
        }

        public final /* synthetic */ Object mo4352b() throws JSONException {
            return mo4355a();
        }

        protected C1675a() {
        }

        public final Float m1093c() {
            return this.f1159a;
        }

        public final Boolean m1094e() {
            return this.f1161c;
        }

        public final Boolean m1095f() {
            return this.f1162d;
        }

        public final Integer m1096g() {
            return this.f1163e;
        }

        public final Integer m1097h() {
            return this.f1160b;
        }

        public final JSONObject mo4355a() throws JSONException {
            JSONObject a = super.mo4355a();
            a.putOpt("click_area", this.f1159a);
            a.putOpt("enabled", this.f1161c);
            a.putOpt("show_onclick", this.f1162d);
            a.putOpt("time_show", this.f1163e);
            a.putOpt("time_enabled", this.f1160b);
            return a;
        }
    }

    protected adq(agg com_vungle_publisher_agg) {
        super(com_vungle_publisher_agg);
    }

    public final String m1052c() {
        return this.f1108n;
    }

    public final C1675a m1053d() {
        return this.f1109o;
    }

    public final String m1054e() {
        return this.f1110p;
    }

    public final Integer m1055f() {
        return this.f1111q;
    }

    public final Integer m1056g() {
        return this.f1112r;
    }

    public final Integer m1057h() {
        return this.f1113s;
    }

    public final Integer m1058i() {
        return this.f1114t;
    }

    public final String m1059j() {
        return this.f1115u;
    }

    public final Integer m1060k() {
        return this.f1116v;
    }
}
