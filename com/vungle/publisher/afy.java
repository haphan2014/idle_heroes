package com.vungle.publisher;

/* compiled from: vungle */
public final class afy {
    public static String m1205a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class}).invoke(null, new Object[]{str});
        } catch (Throwable e) {
            so.m2470a(5, "VungleConfig", "error getting Android system property " + str, e);
            return null;
        }
    }
}
