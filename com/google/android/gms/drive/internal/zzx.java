package com.google.android.gms.drive.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzn;

public final class zzx {
    private static final zzn zzaft = new zzn("GmsDrive");

    public static void zza(String str, Throwable th, String str2) {
        zzaft.zzc(str, str2, th);
    }

    public static void zze(Context context, String str, String str2) {
        zzaft.zza(context, str, str2, new Throwable());
    }

    public static void zzt(String str, String str2) {
        zzaft.zzt(str, str2);
    }

    public static void zzu(String str, String str2) {
        zzaft.zzu(str, str2);
    }

    public static void zzv(String str, String str2) {
        zzaft.zzv(str, str2);
    }
}
