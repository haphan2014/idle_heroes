package com.vungle.publisher;

import android.database.Cursor;
import com.vungle.publisher.gx.C1778a;
import javax.inject.Inject;
import javax.inject.Singleton;

/* compiled from: vungle */
public enum C1893v {
    vungle_local,
    vungle_streaming,
    vungle_mraid,
    third_party_mraid;

    @Singleton
    /* compiled from: vungle */
    public static class C1892a {
        @Inject
        C1778a f3409a;

        public final C1893v m2540a(String str) {
            if (str == null) {
                return null;
            }
            for (C1893v c1893v : C1893v.values()) {
                if (c1893v.toString().equals(str)) {
                    return c1893v;
                }
            }
            this.f3409a.m1865a("VungleProtocol", "unknown AdType: " + str, new RuntimeException());
            return null;
        }

        public final C1893v m2539a(Cursor cursor, String str) {
            if (cursor != null && cursor.getCount() == 1 && cursor.moveToFirst()) {
                return m2540a(cm.m1261f(cursor, str));
            }
            this.f3409a.m1865a("VungleProtocol", "AdType not found", new RuntimeException());
            return null;
        }
    }
}
