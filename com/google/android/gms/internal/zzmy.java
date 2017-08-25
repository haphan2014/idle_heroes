package com.google.android.gms.internal;

import com.google.android.gms.auth.GoogleAuthUtil;

public class zzmy {
    private static final ThreadLocal<String> zzakW = new ThreadLocal();

    public static String zzcL(String str) {
        return zzqQ() ? str : zzx(str, (String) zzakW.get());
    }

    public static boolean zzqQ() {
        String str = (String) zzakW.get();
        return str == null || str.startsWith(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
    }

    public static String zzx(String str, String str2) {
        if (str == null || str2 == null) {
            return str;
        }
        Object obj = new byte[(str.length() + str2.length())];
        System.arraycopy(str.getBytes(), 0, obj, 0, str.length());
        System.arraycopy(str2.getBytes(), 0, obj, str.length(), str2.length());
        return Integer.toHexString(zzlj.zza(obj, 0, obj.length, 0));
    }
}
