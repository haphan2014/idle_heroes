package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.heyzap.http.AsyncHttpResponseHandler;
import com.vungle.publisher.cu.C1718a;
import com.vungle.publisher.cu.C1722c;
import com.vungle.publisher.dr.C1737a;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.ed.C1741a;
import com.vungle.publisher.ew.C1753b;
import com.vungle.publisher.jn.C1796a;
import com.vungle.publisher.ka.C1736a;
import com.vungle.publisher.ke.C1802a;
import com.vungle.publisher.kj.C1803a;
import com.vungle.publisher.ko.C1804a;
import com.vungle.publisher.li.C1809a;
import com.vungle.publisher.lr.C1811a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONObject;

/* compiled from: vungle */
public final class kd extends dx implements dy<kd> {
    @Inject
    C1801a f2346A;
    @Inject
    C1811a f2347B;
    boolean f2348p = false;
    boolean f2349q = false;
    List<dr> f2350r;
    ke f2351s;
    List<jn> f2352w;
    li f2353x;
    ed f2354y;
    String f2355z;

    @Singleton
    /* compiled from: vungle */
    public static class C1801a extends C1718a<kd, ads> implements eh<kd, ads> {
        @Inject
        Provider<kd> f2336c;
        @Inject
        agg f2337e;
        @Inject
        C1737a f2338f;
        @Inject
        Provider<String> f2339g;
        @Inject
        C1803a f2340h;
        @Inject
        C1802a f2341i;
        @Inject
        C1804a f2342j;
        @Inject
        C1809a f2343k;
        @Inject
        C1796a f2344l;
        @Inject
        C1741a f2345m;

        public final /* synthetic */ cu mo4444a(acr com_vungle_publisher_acr) {
            ads com_vungle_publisher_ads = (ads) com_vungle_publisher_acr;
            kd kdVar = (kd) super.mo4444a((acr) com_vungle_publisher_ads);
            kdVar.k = com_vungle_publisher_ads.f1044c;
            kdVar.m1327a((String) this.f2339g.get());
            kdVar.f2350r = this.f2338f.m1493a(kdVar, com_vungle_publisher_ads);
            kdVar.f2351s = this.f2341i.m2057a(kdVar, com_vungle_publisher_ads, C1753b.template);
            kdVar.f2353x = (li) this.f2343k.m1819a(kdVar, com_vungle_publisher_ads);
            kdVar.f2354y = this.f2345m.m1560a(kdVar);
            kdVar.f2355z = com_vungle_publisher_ads.f1173n;
            JSONObject jSONObject = com_vungle_publisher_ads.f1170k;
            if (jSONObject != null) {
                kdVar.f2352w = this.f2344l.m2015a((String) kdVar.u, jSONObject);
            }
            kdVar.mo4457a(C1722c.aware);
            return kdVar;
        }

        public final /* synthetic */ int mo4447b(cu cuVar, acr com_vungle_publisher_acr) {
            kd kdVar = (kd) cuVar;
            ads com_vungle_publisher_ads = (ads) com_vungle_publisher_acr;
            mo4446a((cu) kdVar, (acr) com_vungle_publisher_ads);
            kdVar.k = com_vungle_publisher_ads.f1044c;
            kdVar.f2353x.m1825a((acr) com_vungle_publisher_ads);
            return super.mo4447b(kdVar, com_vungle_publisher_ads);
        }

        public final /* synthetic */ ei i_() {
            return m2035e();
        }

        public final /* bridge */ /* synthetic */ C1718a j_() {
            return this;
        }

        @Inject
        C1801a() {
        }

        public final int mo4381a(List<kd> list) {
            return m2035e().m1581a(list);
        }

        private kd m2034a(kd kdVar, Cursor cursor, boolean z) {
            super.mo4445a(kdVar, cursor, z);
            kdVar.j = cm.m1258c(cursor, "delete_local_content_attempts");
            kdVar.k = cm.m1260e(cursor, "expiration_timestamp_seconds");
            kdVar.m1327a(cm.m1261f(cursor, "parent_path"));
            kdVar.m = cm.m1258c(cursor, "prepare_retry_count");
            kdVar.n = System.currentTimeMillis();
            kdVar.f2353x = (li) this.f2343k.m1818a(kdVar);
            kdVar.f2354y = this.f2345m.m1560a(kdVar);
            kdVar.f2355z = cm.m1261f(cursor, "template_id");
            if (z) {
                m2043a(kdVar);
                m2041a(kdVar, z);
            }
            return kdVar;
        }

        final ke m2041a(kd kdVar, boolean z) {
            if (kdVar.f2349q) {
                return kdVar.f2351s;
            }
            ke keVar = (ke) this.f2341i.m1486a((String) kdVar.u, C1753b.template, z);
            kdVar.f2351s = keVar;
            kdVar.f2349q = true;
            return keVar;
        }

        final List<dr> m2043a(kd kdVar) {
            if (kdVar.f2348p) {
                return kdVar.f2350r;
            }
            C1736a c1736a = this.f2338f;
            C1753b c1753b = C1753b.asset;
            List<dr> a = c1736a.mo4383a("ad_id = ? AND type = ?", new String[]{(String) kdVar.u, c1753b.toString()});
            kdVar.f2350r = a;
            kdVar.f2348p = true;
            return a;
        }

        protected final C1893v mo4451a() {
            return C1893v.vungle_mraid;
        }

        private kj m2035e() {
            return (kj) this.f2340h.m1569a(this);
        }

        protected final /* synthetic */ dw c_() {
            return (kd) this.f2336c.get();
        }
    }

    public final /* synthetic */ String mo4459d() {
        return (String) super.mo4410w();
    }

    public final /* bridge */ /* synthetic */ cu h_() {
        return this;
    }

    public final /* synthetic */ lv mo4481p() {
        return m2046q();
    }

    @Inject
    kd() {
    }

    private lr m2046q() {
        FileOutputStream fileOutputStream;
        Throwable e;
        this.f2346A.m2041a(this, false);
        String a = th.m2498a();
        try {
            File file = new File(qt.m2369a(this.f2351s.m1680u(), "mraid.js"));
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file, true);
            try {
                fileOutputStream.write(("\n" + a + "\n").getBytes(Charset.forName(AsyncHttpResponseHandler.DEFAULT_CHARSET)));
                try {
                    fileOutputStream.close();
                } catch (Throwable e2) {
                    so.m2470a(3, "VungleDatabase", "error closing output file", e2);
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    so.m2471a("VungleDatabase", "Failed writing to the mraid js file", e2);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            so.m2470a(3, "VungleDatabase", "error closing output file", e22);
                        }
                    }
                    return this.f2347B.m2134a(this.f2351s.m1663B().toURI().toString());
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            so.m2470a(3, "VungleDatabase", "error closing output file", e4);
                        }
                    }
                    throw e22;
                }
            }
        } catch (IOException e5) {
            e22 = e5;
            fileOutputStream = null;
            so.m2471a("VungleDatabase", "Failed writing to the mraid js file", e22);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return this.f2347B.m2134a(this.f2351s.m1663B().toURI().toString());
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
        return this.f2347B.m2134a(this.f2351s.m1663B().toURI().toString());
    }

    public final List<String> mo4485a(jt jtVar) {
        return this.f2353x.m1824a(jtVar);
    }

    public final boolean mo4458b() {
        return qt.m2372a(m1335h());
    }

    public final void mo4457a(C1722c c1722c) {
        C1722c c1722c2 = this.d;
        super.mo4457a(c1722c);
        this.f2354y.m1561a(c1722c2, c1722c);
    }

    public final int b_() {
        int b_ = super.b_();
        if (b_ == 1) {
            if (this.f2350r != null) {
                for (dr b_2 : this.f2350r) {
                    b_2.b_();
                }
            }
            if (this.f2351s != null) {
                this.f2351s.b_();
            }
            if (this.f2352w != null) {
                for (jn b_3 : this.f2352w) {
                    b_3.b_();
                }
            }
        }
        return b_;
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues a = super.mo4390a(z);
        if (z) {
            a.put("template_id", this.f2355z);
        }
        return a;
    }

    public final boolean g_() {
        boolean z = true;
        this.f2346A.m2041a(this, true);
        if (this.f2351s == null) {
            z = false;
        }
        String z2 = mo4389z();
        if (z) {
            so.m2470a(2, "VunglePrepare", z2 + " has " + C1753b.template + ": " + this.f2351s.f1824g.f2014b, null);
        } else {
            so.m2470a(5, "VunglePrepare", "vungle mraid ad is invalid. template = " + this.f2351s, null);
            mo4457a(C1722c.invalid);
        }
        return z;
    }

    public final List<gr<kd>> f_() {
        List<gr<kd>> arrayList = new ArrayList();
        C1801a c1801a = this.f2346A;
        c1801a.m2043a(this);
        if (this.f2350r != null) {
            arrayList.addAll(this.f2350r);
        } else {
            so.m2470a(3, "VungleDatabase", "vungle mraid ad assets are null", null);
        }
        c1801a.m2041a(this, true);
        if (this.f2351s != null) {
            arrayList.add(this.f2351s);
        } else {
            so.m2470a(5, "VungleDatabase", "vungle mraid ad template is null", null);
        }
        return arrayList;
    }

    public final /* bridge */ /* synthetic */ C1718a mo4456a() {
        return this.f2346A;
    }

    public final /* synthetic */ Object mo4400v() {
        String str = (String) super.mo4400v();
        if (this.f2353x != null) {
            this.f2353x.m1827b();
        }
        if (this.f2350r != null) {
            for (dr q : this.f2350r) {
                q.m1535q();
            }
        }
        if (this.f2351s != null) {
            this.f2351s.mo4400v();
        }
        if (this.f2352w != null) {
            for (jn v : this.f2352w) {
                v.mo4400v();
            }
        }
        return str;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2346A;
    }
}
