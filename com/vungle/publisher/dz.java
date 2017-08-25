package com.vungle.publisher;

import android.content.ContentValues;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/* compiled from: vungle */
public final class dz {
    db<?, ?, ?, ?> f1706a;

    @Singleton
    /* compiled from: vungle */
    static class C1739a {
        @Inject
        Provider<dz> f1705a;

        @Inject
        C1739a() {
        }

        public final dz m1552a(db<?, ?, ?, ?> dbVar) {
            dz dzVar = (dz) this.f1705a.get();
            dzVar.f1706a = dbVar;
            return dzVar;
        }
    }

    @Inject
    dz() {
    }

    public final int m1553a() {
        Long l = this.f1706a.f1619o;
        Long l2 = this.f1706a.f1608d;
        String z = this.f1706a.mo4389z();
        if (l == null) {
            so.m2470a(5, "VungleReport", "download end millis null for " + z, null);
            return -1;
        } else if (l.longValue() < 0) {
            return 0;
        } else {
            if (l2 != null) {
                return (int) (l.longValue() - l2.longValue());
            }
            so.m2470a(5, "VungleReport", "insert timestamp millis null for " + z, null);
            return -1;
        }
    }

    protected final ContentValues m1554a(ContentValues contentValues) {
        contentValues.put("download_end_millis", this.f1706a.f1619o);
        return contentValues;
    }

    public final void m1555a(Long l) {
        this.f1706a.f1619o = l;
        so.m2470a(3, "VungleReport", "setting ad download end millis " + l + " (duration " + m1553a() + " ms) for " + this.f1706a.mo4389z(), null);
        this.f1706a.m1322y();
    }
}
