package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import com.vungle.publisher.dw.C1717a;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class dm extends dw<Integer> {
    ex<?, ?> f1662a;
    String f1663b;
    Integer f1664c;
    @Inject
    C1734a f1665d;

    @Singleton
    /* compiled from: vungle */
    public static class C1734a extends C1717a<dm, Integer> {
        @Inject
        Provider<dm> f1661a;

        protected final /* synthetic */ dw mo4382a(dw dwVar, Cursor cursor) {
            dm dmVar = (dm) dwVar;
            dmVar.u = cm.m1259d(cursor, "id");
            dmVar.f1663b = cm.m1261f(cursor, "relative_path");
            dmVar.f1664c = cm.m1259d(cursor, "size");
            return dmVar;
        }

        public final /* bridge */ /* synthetic */ List mo4386c(int i) {
            return super.mo4386c(i);
        }

        protected final /* synthetic */ dw c_() {
            return m1465a();
        }

        public final /* bridge */ /* synthetic */ List mo4387d() {
            return super.mo4387d();
        }

        @Inject
        C1734a() {
        }

        final int m1463a(Integer num) {
            if (num == null) {
                throw new IllegalArgumentException("null viewable_id");
            }
            int delete = this.d.getWritableDatabase().delete("archive_entry", "viewable_id = ?", new String[]{String.valueOf(num)});
            so.m2470a(3, "VungleDatabase", "deleted " + delete + " archive_entry rows for viewable_id " + num, null);
            return delete;
        }

        final dm[] m1468a(ex<?, ?> exVar) {
            Cursor query;
            Throwable th;
            if (exVar == null) {
                throw new IllegalArgumentException("null archive");
            }
            Integer D = exVar.m1502D();
            if (D == null) {
                throw new IllegalArgumentException("null viewable_id");
            }
            try {
                so.m2470a(3, "VungleDatabase", "fetching archive_entry records by viewable_id " + D, null);
                query = this.d.getReadableDatabase().query("archive_entry", null, "viewable_id = ?", new String[]{String.valueOf(D)}, null, null, null);
                try {
                    dm[] dmVarArr = new dm[query.getCount()];
                    int i = 0;
                    while (query.moveToNext()) {
                        dw a = m1465a();
                        m1280b(a, query);
                        a.f1662a = exVar;
                        dmVarArr[i] = a;
                        so.m2470a(2, "VungleDatabase", "fetched " + a, null);
                        i++;
                    }
                    if (query != null) {
                        query.close();
                    }
                    return dmVarArr;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }

        protected final String mo4385c() {
            return "archive_entry";
        }

        final dm m1465a() {
            return (dm) this.f1661a.get();
        }

        protected final /* bridge */ /* synthetic */ Object[] mo4384b(int i) {
            return new Integer[i];
        }
    }

    @Inject
    dm() {
    }

    protected final String mo4391c() {
        return "archive_entry";
    }

    private Integer m1474e() {
        return this.f1662a == null ? null : this.f1662a.m1502D();
    }

    public final int b_() {
        if (this.u != null) {
            return super.b_();
        }
        Integer e = m1474e();
        so.m2470a(3, "VungleDatabase", "updating archive_entry by viewable_id " + e + ", relative_path " + this.f1663b, null);
        int updateWithOnConflict = this.v.getWritableDatabase().updateWithOnConflict("archive_entry", mo4390a(false), "viewable_id = ? AND relative_path = ?", new String[]{String.valueOf(e), r7}, 3);
        m1321x();
        return updateWithOnConflict;
    }

    protected final ContentValues mo4390a(boolean z) {
        ContentValues contentValues = new ContentValues();
        if (this.u != null) {
            contentValues.put("id", (Integer) this.u);
        }
        contentValues.put("viewable_id", m1474e());
        contentValues.put("relative_path", this.f1663b);
        contentValues.put("size", this.f1664c);
        return contentValues;
    }

    protected final StringBuilder mo4394m() {
        StringBuilder m = super.mo4394m();
        dw.m1312a(m, "viewable_id", m1474e(), false);
        dw.m1312a(m, "relative_path", this.f1663b, false);
        dw.m1312a(m, "size", this.f1664c, false);
        return m;
    }

    protected final /* bridge */ /* synthetic */ C1717a a_() {
        return this.f1665d;
    }
}
