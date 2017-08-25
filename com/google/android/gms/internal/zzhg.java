package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.math.BigInteger;
import java.util.Locale;

@zzgd
public final class zzhg {
    private static zzcb zzFX;
    private static String zzFY;
    private static final Object zzoW = new Object();

    public static String zza(Context context, String str, String str2) {
        String str3;
        synchronized (zzoW) {
            if (zzFY == null && !TextUtils.isEmpty(str)) {
                zzb(context, str, str2);
            }
            str3 = zzFY;
        }
        return str3;
    }

    private static void zzb(Context context, String str, String str2) {
        try {
            ClassLoader classLoader = context.createPackageContext(str2, 3).getClassLoader();
            Class cls = Class.forName("com.google.ads.mediation.MediationAdapter", false, classLoader);
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str.split(",");
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (zzo.zzbv().zza(classLoader, cls, split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            zzFY = String.format(Locale.US, "%X", new Object[]{bigInteger2});
        } catch (Throwable th) {
            zzFY = "err";
        }
    }

    public static void zze(Context context, String str) {
        synchronized (zzoW) {
            if (zzFX == null) {
                zzca com_google_android_gms_internal_zzca = new zzca();
                com_google_android_gms_internal_zzca.zzb(context, str);
                try {
                    zzFX = zzo.zzbA().zzb(com_google_android_gms_internal_zzca);
                } catch (IllegalArgumentException e) {
                    zzb.zzaC("Cannot initialize CSI reporter." + e.getMessage());
                }
            }
        }
    }

    public static zzcb zzfY() {
        zzcb com_google_android_gms_internal_zzcb;
        synchronized (zzoW) {
            com_google_android_gms_internal_zzcb = zzFX;
        }
        return com_google_android_gms_internal_zzcb;
    }

    public static String zzgh() {
        String str;
        synchronized (zzoW) {
            str = zzFY;
        }
        return str;
    }
}
