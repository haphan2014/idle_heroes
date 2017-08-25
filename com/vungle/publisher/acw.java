package com.vungle.publisher;

import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class acw extends aar {
    public Boolean f1066a;
    public Integer f1067b;
    public Integer f1068c;
    public C1665b f1069d;
    public Boolean f1070e;

    @Singleton
    /* compiled from: vungle */
    public static class C1664a extends abi<acw> {
        protected final /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
            Object obj = null;
            if (jSONObject == null) {
                return null;
            }
            acw com_vungle_publisher_acw = new acw();
            com_vungle_publisher_acw.f1066a = sa.m2424a(jSONObject, "optIn");
            com_vungle_publisher_acw.f1067b = sa.m2429c(jSONObject, "updateDelay");
            com_vungle_publisher_acw.f1068c = sa.m2429c(jSONObject, "threshold");
            Class cls = C1665b.class;
            String d = sa.m2430d(jSONObject, "connection");
            if (d != null) {
                obj = Enum.valueOf(cls, d);
            }
            com_vungle_publisher_acw.f1069d = (C1665b) obj;
            com_vungle_publisher_acw.f1070e = sa.m2424a(jSONObject, "exceptionReportingEnabled");
            return com_vungle_publisher_acw;
        }

        @Inject
        C1664a() {
        }

        protected final /* synthetic */ Object mo4354b() {
            return new acw();
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4353a(int i) {
            return new acw[i];
        }
    }

    /* compiled from: vungle */
    public enum C1665b {
        all,
        wifi
    }
}
