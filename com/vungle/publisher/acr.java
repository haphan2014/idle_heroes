package com.vungle.publisher;

import com.google.android.gms.fitness.FitnessActivities;
import com.vungle.publisher.C1893v.C1892a;
import com.vungle.publisher.aeb.C1640a;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public abstract class acr {
    String f1042a;
    Integer f1043b;
    public Long f1044c;
    public aeb f1045d;
    public C1893v f1046e;
    public String f1047f;
    public Integer f1048g;
    public String f1049h;
    protected String f1050i;
    agg f1051j;

    /* compiled from: vungle */
    public static abstract class C1662a<R extends acr, T extends C1640a<?>> extends abi<R> {
        @Inject
        protected C1892a f1041a;

        public /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
            return mo4363a(jSONObject);
        }

        public R mo4363a(JSONObject jSONObject) throws JSONException {
            Long l = null;
            if (jSONObject == null) {
                return null;
            }
            acr com_vungle_publisher_acr = (acr) mo4354b();
            com_vungle_publisher_acr.f1049h = sa.m2430d(jSONObject, "app_id");
            com_vungle_publisher_acr.f1048g = sa.m2429c(jSONObject, "delay");
            com_vungle_publisher_acr.f1050i = sa.m2430d(jSONObject, "id");
            com_vungle_publisher_acr.f1046e = this.f1041a.m2540a(sa.m2430d(jSONObject, "adType"));
            com_vungle_publisher_acr.f1047f = sa.m2430d(jSONObject, "campaign");
            abi.m911a(jSONObject, "campaign", com_vungle_publisher_acr.f1047f);
            String str = "expiry";
            long optLong = jSONObject.optLong(str, -1);
            if (optLong == -1) {
                long optLong2 = jSONObject.optLong(str, -2);
                if (optLong2 != -2) {
                    l = Long.valueOf(optLong2);
                }
            } else {
                l = Long.valueOf(optLong);
            }
            com_vungle_publisher_acr.f1044c = l;
            abi.m911a(jSONObject, "expiry", l);
            com_vungle_publisher_acr.f1043b = sa.m2429c(jSONObject, FitnessActivities.SLEEP);
            com_vungle_publisher_acr.f1042a = sa.m2430d(jSONObject, "sleepCode");
            return com_vungle_publisher_acr;
        }
    }

    public acr(agg com_vungle_publisher_agg) {
        this.f1051j = com_vungle_publisher_agg;
    }

    public final String m1009a() {
        return this.f1050i;
    }

    public final Long m1010b() {
        long j = Long.MAX_VALUE;
        if (this.f1043b == null) {
            return null;
        }
        long intValue = (long) this.f1043b.intValue();
        if (intValue < 0 || 1000 < 0 || Long.MAX_VALUE < 0) {
            throw new IllegalArgumentException("inputs must be positive");
        }
        if (intValue == 0 || 1000 == 0) {
            j = 0;
        } else if (1000 < Long.MAX_VALUE / intValue) {
            j = intValue * 1000;
        }
        return Long.valueOf(j);
    }
}
