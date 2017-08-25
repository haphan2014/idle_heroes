package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.android.gms.tagmanager.DataLayer;
import com.vungle.publisher.dw.C1717a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: vungle */
public abstract class eo extends dw<Integer> {
    String f1780a;
    String f1781b;
    jt f1782c;

    /* compiled from: vungle */
    static abstract class C1749a<E extends eo, T extends aeb, R extends acr> extends C1717a<E, Integer> {
        abstract Map<jt, List<E>> mo4468a(String str, T t);

        C1749a() {
        }

        private static void m1626a(Map<jt, List<E>> map) {
            if (map != null) {
                for (List<eo> list : map.values()) {
                    if (list != null) {
                        for (eo v : list) {
                            v.mo4400v();
                        }
                    }
                }
            }
        }

        final Map<jt, List<E>> m1630a(String str) {
            Throwable th;
            Cursor cursor = null;
            if (str == null) {
                so.m2470a(5, "VungleDatabase", "failed to fetch event_tracking records by ad_id: " + str, null);
                return null;
            }
            try {
                so.m2470a(3, "VungleDatabase", "fetching event_tracking records by ad_id: " + str, null);
                Cursor query = this.d.getReadableDatabase().query("event_tracking", null, "ad_id = ?", new String[]{str}, null, null, null);
                try {
                    Map<jt, List<E>> map;
                    int count = query.getCount();
                    so.m2470a(2, "VungleDatabase", count + " event_tracking for ad_id: " + str, null);
                    if (count > 0) {
                        Map<jt, List<E>> hashMap = new HashMap();
                        while (query.moveToNext()) {
                            eo eoVar = (eo) c_();
                            m1280b((dw) eoVar, query);
                            if (eoVar != null) {
                                jt jtVar = eoVar.f1782c;
                                List list = (List) hashMap.get(jtVar);
                                if (list == null) {
                                    list = new ArrayList();
                                    hashMap.put(jtVar, list);
                                }
                                list.add(eoVar);
                            }
                        }
                        map = hashMap;
                    } else {
                        map = null;
                    }
                    if (query == null) {
                        return map;
                    }
                    query.close();
                    return map;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        final void m1632a(String str, Map<jt, List<E>> map, jt jtVar, List<String> list) {
            if (list != null && list.size() > 0) {
                List list2;
                if (list == null || list.size() <= 0) {
                    list2 = null;
                } else {
                    List arrayList = new ArrayList();
                    for (String str2 : list) {
                        Object obj;
                        if (jtVar == null || str2 == null) {
                            obj = null;
                        } else {
                            obj = (eo) c_();
                            obj.f1781b = str;
                            obj.f1782c = jtVar;
                            obj.f1780a = str2;
                        }
                        if (obj != null) {
                            arrayList.add(obj);
                        }
                    }
                    list2 = arrayList;
                }
                if (list2 == null || list2.isEmpty()) {
                    list2 = null;
                }
                if (list2 != null && !list2.isEmpty()) {
                    map.put(jtVar, list2);
                }
            }
        }

        protected E mo4467a(E e, Cursor cursor, boolean z) {
            e.u = cm.m1259d(cursor, "id");
            e.f1781b = cm.m1261f(cursor, "ad_id");
            e.f1780a = cm.m1261f(cursor, "url");
            return e;
        }

        protected final String mo4385c() {
            return "event_tracking";
        }

        final Map<jt, List<E>> m1629a(R r) {
            String str = r.f1047f;
            so.m2470a(2, "VungleDatabase", "deleted " + this.d.getWritableDatabase().delete("event_tracking", "ad_id = ?", new String[]{str}) + " expired event_tracking records for adId: " + str, null);
            Map a = mo4468a(str, r.f1045d);
            C1749a.m1626a(a);
            return a;
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4384b(int i) {
            return new Integer[i];
        }
    }

    protected final String mo4391c() {
        return "event_tracking";
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", (Integer) this.u);
        contentValues.put("ad_id", this.f1781b);
        contentValues.put(DataLayer.EVENT_KEY, this.f1782c.toString());
        contentValues.put("url", this.f1780a);
        return contentValues;
    }

    public final StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        dw.m1312a(m, "ad_id", this.f1781b, false);
        dw.m1312a(m, DataLayer.EVENT_KEY, this.f1782c, false);
        dw.m1312a(m, "url", this.f1780a, false);
        return m;
    }
}
