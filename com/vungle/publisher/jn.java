package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.dw.C1717a;
import com.vungle.publisher.gx.C1778a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: vungle */
public final class jn extends dw<Integer> {
    @Inject
    C1796a f2276a;
    String f2277b;
    String f2278c;
    String f2279d;

    @Singleton
    /* compiled from: vungle */
    public static class C1796a extends C1717a<jn, Integer> {
        @Inject
        C1778a f2273a;
        @Inject
        Provider<jn> f2274b;

        protected final /* synthetic */ dw mo4382a(dw dwVar, Cursor cursor) {
            jn jnVar = (jn) dwVar;
            jnVar.f2279d = cm.m1261f(cursor, "ad_id");
            jnVar.f2277b = cm.m1261f(cursor, "key");
            jnVar.f2278c = cm.m1261f(cursor, "value");
            return jnVar;
        }

        public final /* bridge */ /* synthetic */ List mo4386c(int i) {
            return super.mo4386c(i);
        }

        protected final /* synthetic */ dw c_() {
            return m2010a();
        }

        public final /* bridge */ /* synthetic */ List mo4387d() {
            return super.mo4387d();
        }

        @Inject
        C1796a() {
        }

        public final jn m2014a(String str, String str2, String str3) {
            jn a = m2010a();
            a.f2279d = str;
            a.f2277b = str2;
            a.f2278c = str3;
            return a;
        }

        public final List<jn> m2015a(String str, JSONObject jSONObject) {
            List<jn> arrayList = new ArrayList();
            try {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    arrayList.add(m2014a(str, str2, jSONObject.getString(str2)));
                }
            } catch (Throwable e) {
                this.f2273a.m1865a("VungleDatabase", "could not create template replacement list", e);
            }
            return arrayList;
        }

        public final C1797b m2013a(String str) {
            return new C1797b(super.mo4383a("ad_id = ?", new String[]{str}));
        }

        protected final String mo4385c() {
            return "template_replacements";
        }

        private jn m2010a() {
            return (jn) this.f2274b.get();
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4384b(int i) {
            return new Integer[i];
        }
    }

    /* compiled from: vungle */
    public static class C1797b extends aar {
        private final JSONObject f2275a = new JSONObject();

        public C1797b(List<jn> list) {
            try {
                for (jn jnVar : list) {
                    this.f2275a.put(jnVar.f2277b, jnVar.f2278c);
                }
            } catch (Throwable e) {
                so.m2471a("VungleProtocol", "could not parse json", e);
            }
        }

        public final JSONObject mo4355a() throws JSONException {
            return this.f2275a;
        }

        public final /* bridge */ /* synthetic */ Object mo4352b() throws JSONException {
            return this.f2275a;
        }
    }

    @Inject
    jn() {
    }

    protected final String mo4391c() {
        return "template_replacements";
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("id", (Integer) this.u);
            contentValues.put("ad_id", this.f2279d);
        }
        contentValues.put("key", this.f2277b);
        contentValues.put("value", this.f2278c);
        return contentValues;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f2276a;
    }
}
