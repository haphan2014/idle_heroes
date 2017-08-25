package com.vungle.publisher;

import com.vungle.publisher.adq.C1669b;
import com.vungle.publisher.aeb.C1640a;
import com.vungle.publisher.aec.C1679a;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class adn extends adq {
    public Boolean f1151k;

    @Singleton
    /* compiled from: vungle */
    public static class C1673a extends C1669b<adn, C1679a> {
        @Inject
        agg f1149b;
        @Inject
        C1679a f1150c;

        public final /* synthetic */ acr mo4363a(JSONObject jSONObject) throws JSONException {
            return m1081b(jSONObject);
        }

        protected final /* synthetic */ Object mo4354b() {
            return m1077c();
        }

        public final /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
            return m1081b(jSONObject);
        }

        public final /* synthetic */ adq mo4366d(JSONObject jSONObject) throws JSONException {
            return m1081b(jSONObject);
        }

        @Inject
        C1673a() {
        }

        public final adn m1081b(JSONObject jSONObject) throws JSONException {
            adn com_vungle_publisher_adn = null;
            if (jSONObject != null) {
                Boolean a = sa.m2424a(jSONObject, "shouldStream");
                if (Boolean.TRUE.equals(a)) {
                    com_vungle_publisher_adn = (adn) super.mo4366d(jSONObject);
                } else {
                    com_vungle_publisher_adn = m1077c();
                }
                com_vungle_publisher_adn.f1151k = a;
            }
            return com_vungle_publisher_adn;
        }

        private adn m1077c() {
            return new adn(this.f1149b);
        }

        protected final /* bridge */ /* synthetic */ C1640a mo4365a() {
            return this.f1150c;
        }
    }

    protected adn(agg com_vungle_publisher_agg) {
        super(com_vungle_publisher_agg);
    }
}
