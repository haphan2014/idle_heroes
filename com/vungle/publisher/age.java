package com.vungle.publisher;

import android.content.Context;
import android.os.Build.VERSION;

/* compiled from: vungle */
public final class age {
    public static boolean m1211a(Context context) {
        return VERSION.SDK_INT >= 19 || context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
