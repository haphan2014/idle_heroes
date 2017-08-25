package com.vungle.publisher;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: vungle */
public abstract class dw<I> implements hc<I> {
    Class<I> f1549t;
    protected I f1550u;
    @Inject
    protected cq f1551v;

    /* compiled from: vungle */
    public static abstract class C1717a<T extends dw<I>, I> {
        @Inject
        protected cq f1530d;

        protected abstract T mo4382a(T t, Cursor cursor);

        protected abstract T[] mo4396a(int i);

        protected abstract I[] mo4384b(int i);

        protected abstract String mo4385c();

        protected abstract T c_();

        protected C1717a() {
        }

        public final int m1272a(I... iArr) {
            int i = 0;
            int length = iArr == null ? 0 : iArr.length;
            if (length == 0) {
                so.m2470a(3, "VungleDatabase", "no " + mo4385c() + " records requested for delete", null);
                return 0;
            }
            int i2;
            c_();
            boolean z = iArr instanceof String[];
            String[] strArr = z ? (String[]) iArr : new String[length];
            if (!z) {
                int length2 = iArr.length;
                i2 = 0;
                while (i < length2) {
                    int i3 = i2 + 1;
                    strArr[i2] = String.valueOf(iArr[i]);
                    i++;
                    i2 = i3;
                }
            }
            i2 = this.f1530d.getWritableDatabase().delete(mo4385c(), "id IN (" + cm.m1256a(length) + ")", strArr);
            if (i2 == length) {
                so.m2470a(3, "VungleDatabase", "deleted " + i2 + " " + mo4385c() + " records by id in " + agf.m1220b((Object[]) iArr), null);
                return i2;
            }
            so.m2470a(5, "VungleDatabase", "deleted " + i2 + " of " + length + " requested records by id in " + agf.m1220b((Object[]) iArr), null);
            return i2;
        }

        public int mo4381a(List<T> list) {
            dw[] dwVarArr;
            Object[] b;
            int i = 0;
            if (list == null) {
                dwVarArr = null;
            } else {
                dwVarArr = (dw[]) list.toArray(mo4396a(list.size()));
            }
            if (dwVarArr != null) {
                b = mo4384b(dwVarArr.length);
                int length = dwVarArr.length;
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i + 1;
                    b[i] = dwVarArr[i2].mo4410w();
                    i2++;
                    i = i3;
                }
            } else {
                b = null;
            }
            return m1272a(b);
        }

        public List<T> mo4387d() {
            return m1277a(null, null, null);
        }

        public List<T> mo4383a(String str, String[] strArr) {
            return m1277a(str, strArr, null);
        }

        public List<T> mo4386c(int i) {
            return m1278a(null, null, null, Integer.toString(i));
        }

        final T m1273a(T t) {
            if (t == null) {
                throw new IllegalArgumentException("null model");
            }
            String str = "id";
            Object w = t.mo4410w();
            if (w == null) {
                throw new IllegalArgumentException("null " + str);
            }
            StringBuilder append = new StringBuilder().append(str).append(" = ?");
            Iterable arrayList = new ArrayList();
            arrayList.add(String.valueOf(w));
            String stringBuilder = append.toString();
            List a = m1278a(stringBuilder, (String[]) arrayList.toArray(new String[arrayList.size()]), null, null);
            int size = a.size();
            switch (size) {
                case 0:
                    return null;
                case 1:
                    return (dw) a.get(0);
                default:
                    throw new SQLException(size + " " + mo4385c() + " records found for query: " + stringBuilder + ", parameters: " + agf.m1214a(arrayList));
            }
        }

        protected final List<T> m1277a(String str, String[] strArr, String str2) {
            return m1278a(str, strArr, str2, null);
        }

        protected final List<T> m1278a(String str, String[] strArr, String str2, String str3) {
            Throwable th;
            Cursor cursor;
            try {
                String str4;
                String c = mo4385c();
                String str5 = "VungleDatabase";
                StringBuilder stringBuilder = new StringBuilder("fetching ");
                if (str == null) {
                    str4 = "all " + c + " records";
                } else {
                    str4 = c + " records by " + str + " " + agf.m1220b((Object[]) strArr);
                }
                so.m2470a(3, str5, stringBuilder.append(str4).toString(), null);
                Cursor query = this.f1530d.getReadableDatabase().query(c, null, str, strArr, null, null, str2, str3);
                try {
                    int count = query.getCount();
                    String str6 = "VungleDatabase";
                    StringBuilder stringBuilder2 = new StringBuilder();
                    if (count == 0) {
                        str4 = "no ";
                    } else {
                        str4 = "fetched " + count + " ";
                    }
                    so.m2470a(2, str6, stringBuilder2.append(str4).append(c).append(" records by ").append(str).append(" ").append(agf.m1220b((Object[]) strArr)).toString(), null);
                    List<T> a = mo4401a(query);
                    if (query != null) {
                        query.close();
                    }
                    return a;
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
                cursor = null;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        protected final boolean m1281b(String str, String[] strArr) {
            boolean z = false;
            Cursor cursor = null;
            try {
                cursor = this.f1530d.getWritableDatabase().rawQuery("SELECT EXISTS (SELECT 1 FROM " + mo4385c() + " WHERE " + str + " LIMIT 1)", strArr);
                if (cursor.moveToFirst() && cursor.getInt(0) != 0) {
                    z = true;
                }
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        protected final int m1286h() {
            Cursor cursor = null;
            int i = 0;
            try {
                cursor = this.f1530d.getReadableDatabase().rawQuery("SELECT COUNT(*) FROM " + mo4385c(), null);
                if (cursor.moveToFirst()) {
                    i = cursor.getInt(0);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return i;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        protected static void m1270a(T... tArr) {
            if (tArr != null) {
                for (dw v : tArr) {
                    v.mo4400v();
                }
            }
        }

        private List<T> mo4401a(Cursor cursor) {
            List<T> arrayList = new ArrayList(cursor.getCount());
            while (cursor.moveToNext()) {
                arrayList.add(m1280b(c_(), cursor));
            }
            return arrayList;
        }

        protected final T m1280b(T t, Cursor cursor) {
            mo4382a((dw) t, cursor);
            so.m2470a(2, "VungleDatabase", "fetched " + t, null);
            return t;
        }

        public final T m1275a(I i) {
            dw c_ = c_();
            c_.m1315a((Object) i);
            return m1273a(c_);
        }
    }

    protected abstract ContentValues mo4390a(boolean z);

    protected abstract <T extends dw<I>> C1717a<T, I> a_();

    protected abstract String mo4391c();

    static void m1312a(StringBuilder stringBuilder, String str, Object obj, boolean z) {
        if (!z) {
            stringBuilder.append(", ");
        }
        stringBuilder.append(str).append(": ").append(obj);
    }

    public I mo4410w() {
        return this.f1550u;
    }

    protected final void m1315a(I i) {
        this.f1550u = i;
    }

    protected boolean d_() {
        return true;
    }

    public I mo4400v() {
        Object w = mo4410w();
        if (!d_() || w == null) {
            so.m2470a(3, "VungleDatabase", "inserting " + this, null);
            cq cqVar = this.f1551v;
            long insertOrThrow = cqVar.getWritableDatabase().insertOrThrow(mo4391c(), null, mo4390a(true));
            if (this.f1549t == null || Integer.class.equals(this.f1549t)) {
                this.f1550u = Integer.valueOf((int) insertOrThrow);
            } else if (Long.class.equals(this.f1549t)) {
                this.f1550u = Long.valueOf(insertOrThrow);
            }
            so.m2470a(2, "VungleDatabase", "inserted " + this, null);
            return mo4410w();
        }
        throw new SQLException("attempt to insert with non-auto generated id " + mo4389z());
    }

    public final void m1321x() {
        a_().m1273a(this);
    }

    public final I m1322y() {
        I w = mo4410w();
        if (w == null) {
            return mo4400v();
        }
        b_();
        return w;
    }

    protected int mo4395n() {
        return a_().m1272a(mo4410w());
    }

    public final String mo4389z() {
        return e_().append('}').toString();
    }

    protected StringBuilder e_() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{').append(mo4403A()).append(":: ");
        m1312a(stringBuilder, "id", mo4410w(), true);
        return stringBuilder;
    }

    protected String mo4403A() {
        return mo4391c();
    }

    public String toString() {
        return mo4394m().append('}').toString();
    }

    protected StringBuilder mo4394m() {
        return e_();
    }

    public int b_() {
        String str = "id";
        Object w = mo4410w();
        if (w == null) {
            throw new IllegalArgumentException("null " + str);
        }
        String c = mo4391c();
        String str2 = str + " " + w;
        String[] strArr = new String[]{w.toString()};
        int updateWithOnConflict = this.f1551v.getWritableDatabase().updateWithOnConflict(c, mo4390a(false), "id = ?", strArr, 3);
        switch (updateWithOnConflict) {
            case 0:
                so.m2470a(3, "VungleDatabase", "no " + c + " rows updated by " + str2, null);
                break;
            case 1:
                so.m2470a(3, "VungleDatabase", "update successful " + mo4389z(), null);
                break;
            default:
                so.m2470a(5, "VungleDatabase", "updated " + updateWithOnConflict + " " + c + " records for " + str2, null);
                break;
        }
        return updateWithOnConflict;
    }
}
