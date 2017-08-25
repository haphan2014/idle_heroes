package com.vungle.publisher;

import com.vungle.publisher.abp.C1648a;
import com.vungle.publisher.aeb.C1640a;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class aec extends aeb {
    protected List<String> f1203a;
    protected List<String> f1204b;
    protected List<String> f1205c;
    protected List<String> f1206d;
    protected List<String> f1207e;
    protected List<String> f1208f;
    protected abp[] f1209g;
    protected List<String> f1210h;
    protected List<String> f1211i;
    protected List<String> f1212j;

    @Singleton
    /* compiled from: vungle */
    public static class C1679a extends C1640a<aec> {
        @Inject
        protected C1648a f1202a;

        public final /* synthetic */ aeb mo4357b(JSONObject jSONObject) throws JSONException {
            return m1116a(jSONObject);
        }

        public final /* synthetic */ Object mo4356c(JSONObject jSONObject) throws JSONException {
            return m1116a(jSONObject);
        }

        @Inject
        C1679a() {
        }

        private aec m1116a(JSONObject jSONObject) throws JSONException {
            if (jSONObject == null) {
                return null;
            }
            aec com_vungle_publisher_aec = new aec();
            com_vungle_publisher_aec.f1203a = sa.m2431e(jSONObject, "postroll_click");
            com_vungle_publisher_aec.f1204b = sa.m2431e(jSONObject, "video_click");
            com_vungle_publisher_aec.f1205c = sa.m2431e(jSONObject, "video_close");
            com_vungle_publisher_aec.f1206d = sa.m2431e(jSONObject, "error");
            com_vungle_publisher_aec.f1207e = sa.m2431e(jSONObject, "mute");
            com_vungle_publisher_aec.f1208f = sa.m2431e(jSONObject, "pause");
            com_vungle_publisher_aec.f1209g = (abp[]) this.f1202a.m913a(jSONObject.optJSONArray("play_percentage"));
            com_vungle_publisher_aec.f1210h = sa.m2431e(jSONObject, "postroll_view");
            com_vungle_publisher_aec.f1211i = sa.m2431e(jSONObject, "resume");
            com_vungle_publisher_aec.f1212j = sa.m2431e(jSONObject, "unmute");
            return com_vungle_publisher_aec;
        }

        protected final /* synthetic */ Object mo4354b() {
            return new aec();
        }
    }

    public final /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    protected aec() {
    }

    public final List<String> m1123c() {
        return this.f1203a;
    }

    public final List<String> m1124e() {
        return this.f1204b;
    }

    public final List<String> m1125f() {
        return this.f1205c;
    }

    public final List<String> m1126g() {
        return this.f1206d;
    }

    public final List<String> m1127h() {
        return this.f1207e;
    }

    public final List<String> m1128i() {
        return this.f1208f;
    }

    public final abp[] m1129j() {
        return this.f1209g;
    }

    public final List<String> m1130k() {
        return this.f1210h;
    }

    public final List<String> m1131l() {
        return this.f1211i;
    }

    public final List<String> m1132m() {
        return this.f1212j;
    }

    public final JSONObject mo4355a() throws JSONException {
        JSONObject a = super.mo4355a();
        a.putOpt("postroll_click", this.f1203a);
        a.putOpt("video_click", this.f1204b);
        a.putOpt("video_close", this.f1205c);
        a.putOpt("error", this.f1206d);
        a.putOpt("mute", this.f1207e);
        a.putOpt("pause", this.f1208f);
        a.putOpt("play_percentage", sa.m2426a(this.f1209g));
        a.putOpt("postroll_view", this.f1210h);
        a.putOpt("resume", this.f1211i);
        a.putOpt("unmute", this.f1212j);
        return a;
    }
}
