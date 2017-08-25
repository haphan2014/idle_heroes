package com.vungle.publisher;

import android.text.TextUtils;
import android.util.Log;

/* compiled from: vungle */
public final class so {
    public static void m2471a(String str, String str2, Throwable th) {
        m2470a(6, str, str2, th);
    }

    public static void m2470a(int i, String str, String str2, Throwable th) {
        Object obj = 1;
        boolean isLoggable = Log.isLoggable("VungleDebug", 3);
        if ((!isLoggable && i >= 5) || (isLoggable && Log.isLoggable("Vungle", i))) {
            Object obj2 = !TextUtils.isEmpty(str2) ? 1 : null;
            if (th == null) {
                obj = null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (obj2 != null) {
                stringBuilder.append(str2);
            }
            if (!(obj2 == null || obj == null)) {
                stringBuilder.append("\n");
            }
            if (obj != null) {
                stringBuilder.append(Log.getStackTraceString(th));
            }
            Log.println(i, str, stringBuilder.toString());
        }
    }
}
