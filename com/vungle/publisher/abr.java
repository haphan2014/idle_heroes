package com.vungle.publisher;

import android.text.TextUtils;
import com.vungle.publisher.aat.C1637c;
import com.vungle.publisher.abg.C1642a;
import com.vungle.publisher.abo.C1645a;
import com.vungle.publisher.abo.C1647b;
import com.vungle.publisher.jz.C1799a;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public abstract class abr extends aat {
    protected abg f952g;
    protected Integer f953h;
    protected Long f954i;
    protected String f955j;
    protected String f956k;
    protected Integer f957l;
    protected String f958m;
    protected Boolean f959n;
    protected String f960o;
    protected abo[] f961p;
    protected List<cv> f962q;
    protected C1893v f963r;

    /* compiled from: vungle */
    public static abstract class C1649a<P extends da<T, P, ?>, O extends abr, T extends db<T, P, ?, A>, A extends cu> extends C1637c<O> {
        @Inject
        protected C1642a f951f;

        protected abstract C1645a<P, ?, ?> mo4361c();

        protected C1649a() {
        }

        public O mo4360a(T t) {
            abr com_vungle_publisher_abr = (abr) super.mo4362a();
            if (t != null) {
                cu h = t.m1418h();
                com_vungle_publisher_abr.f954i = t.m1426r();
                com_vungle_publisher_abr.f955j = h.m1332e();
                if (TextUtils.isEmpty(com_vungle_publisher_abr.f955j)) {
                    com_vungle_publisher_abr.f955j = h.m1332e();
                }
                com_vungle_publisher_abr.f956k = (String) h.mo4410w();
                com_vungle_publisher_abr.f957l = Integer.valueOf(t.m1425q());
                com_vungle_publisher_abr.f958m = t.m1421k();
                com_vungle_publisher_abr.f959n = Boolean.valueOf(t.m1420j());
                com_vungle_publisher_abr.f960o = t.m1423o();
                com_vungle_publisher_abr.f961p = mo4361c().m939a(t.m1428t());
                com_vungle_publisher_abr.f962q = t.m1416f();
                com_vungle_publisher_abr.f963r = h.m1333f();
                com_vungle_publisher_abr.f952g = C1642a.m929b(t.m1419i());
            }
            return com_vungle_publisher_abr;
        }
    }

    public /* synthetic */ Object mo4352b() throws JSONException {
        return mo4355a();
    }

    public JSONObject mo4355a() throws JSONException {
        Object valueOf;
        JSONObject a = super.mo4355a();
        a.putOpt("adType", this.f963r);
        a.putOpt("ttDownload", this.f953h);
        a.putOpt("adStartTime", this.f954i);
        a.putOpt("app_id", this.f955j);
        a.putOpt("campaign", this.f956k);
        a.putOpt("adDuration", this.f957l);
        if (Boolean.TRUE.equals(this.f959n)) {
            a.putOpt("name", this.f958m);
        }
        String str = "incentivized";
        Boolean bool = this.f959n;
        if (bool != null) {
            int i;
            if (bool.booleanValue()) {
                i = 1;
            } else {
                i = 0;
            }
            valueOf = Integer.valueOf(i);
        } else {
            valueOf = null;
        }
        a.putOpt(str, valueOf);
        a.putOpt("placement", this.f960o);
        a.putOpt("plays", sa.m2426a(this.f961p));
        a.putOpt("clickedThrough", new JSONArray(m957c()));
        a.putOpt("errors", sa.m2425a(this.f962q));
        a.putOpt("extraInfo", sa.m2427a(this.f952g));
        return a;
    }

    private List<String> m957c() {
        List<String> arrayList = new ArrayList();
        if (this.f961p != null && this.f961p.length > 0) {
            String c1799a = C1799a.volume.toString();
            for (abo com_vungle_publisher_abo : this.f961p) {
                C1647b[] c1647bArr = com_vungle_publisher_abo.f937c;
                if (c1647bArr != null) {
                    for (C1647b c1647b : c1647bArr) {
                        if (!c1799a.equals(c1647b.f944a)) {
                            arrayList.add(c1647b.f944a);
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
