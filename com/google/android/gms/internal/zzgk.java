package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.games.Games;
import java.util.Locale;

@zzgd
public final class zzgk {
    public final int zzCw;
    public final int zzCx;
    public final float zzCy;
    public final int zzEA;
    public final int zzEB;
    public final int zzEC;
    public final double zzED;
    public final boolean zzEE;
    public final boolean zzEF;
    public final int zzEG;
    public final int zzEn;
    public final boolean zzEo;
    public final boolean zzEp;
    public final String zzEq;
    public final String zzEr;
    public final boolean zzEs;
    public final boolean zzEt;
    public final boolean zzEu;
    public final String zzEv;
    public final String zzEw;
    public final int zzEx;
    public final int zzEy;
    public final int zzEz;

    public static final class zza {
        private int zzCw;
        private int zzCx;
        private float zzCy;
        private int zzEA;
        private int zzEB;
        private int zzEC;
        private double zzED;
        private boolean zzEE;
        private boolean zzEF;
        private int zzEG;
        private int zzEn;
        private boolean zzEo;
        private boolean zzEp;
        private String zzEq;
        private String zzEr;
        private boolean zzEs;
        private boolean zzEt;
        private boolean zzEu;
        private String zzEv;
        private String zzEw;
        private int zzEx;
        private int zzEy;
        private int zzEz;

        public zza(Context context) {
            boolean z = true;
            PackageManager packageManager = context.getPackageManager();
            zzA(context);
            zza(context, packageManager);
            zzB(context);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Locale locale = Locale.getDefault();
            this.zzEo = zza(packageManager, "geo:0,0?q=donuts") != null;
            if (zza(packageManager, "http://www.google.com") == null) {
                z = false;
            }
            this.zzEp = z;
            this.zzEr = locale.getCountry();
            this.zzEs = zzk.zzcA().zzgv();
            this.zzEv = locale.getLanguage();
            this.zzEw = zza(packageManager);
            this.zzCy = displayMetrics.density;
            this.zzCw = displayMetrics.widthPixels;
            this.zzCx = displayMetrics.heightPixels;
        }

        public zza(Context context, zzgk com_google_android_gms_internal_zzgk) {
            PackageManager packageManager = context.getPackageManager();
            zzA(context);
            zza(context, packageManager);
            zzB(context);
            this.zzEo = com_google_android_gms_internal_zzgk.zzEo;
            this.zzEp = com_google_android_gms_internal_zzgk.zzEp;
            this.zzEr = com_google_android_gms_internal_zzgk.zzEr;
            this.zzEs = com_google_android_gms_internal_zzgk.zzEs;
            this.zzEv = com_google_android_gms_internal_zzgk.zzEv;
            this.zzEw = com_google_android_gms_internal_zzgk.zzEw;
            this.zzCy = com_google_android_gms_internal_zzgk.zzCy;
            this.zzCw = com_google_android_gms_internal_zzgk.zzCw;
            this.zzCx = com_google_android_gms_internal_zzgk.zzCx;
        }

        private void zzA(Context context) {
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            this.zzEn = audioManager.getMode();
            this.zzEt = audioManager.isMusicActive();
            this.zzEu = audioManager.isSpeakerphoneOn();
            this.zzEx = audioManager.getStreamVolume(3);
            this.zzEB = audioManager.getRingerMode();
            this.zzEC = audioManager.getStreamVolume(2);
        }

        private void zzB(Context context) {
            boolean z = false;
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra(Games.EXTRA_STATUS, -1);
                this.zzED = (double) (((float) registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
                if (intExtra == 2 || intExtra == 5) {
                    z = true;
                }
                this.zzEE = z;
                return;
            }
            this.zzED = -1.0d;
            this.zzEE = false;
        }

        private static int zza(Context context, ConnectivityManager connectivityManager, PackageManager packageManager) {
            if (!zzo.zzbv().zza(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
                return -2;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null ? activeNetworkInfo.getType() : -1;
        }

        private static ResolveInfo zza(PackageManager packageManager, String str) {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        }

        private static String zza(PackageManager packageManager) {
            String str = null;
            ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
            if (zza != null) {
                ActivityInfo activityInfo = zza.activityInfo;
                if (activityInfo != null) {
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                        if (packageInfo != null) {
                            str = packageInfo.versionCode + "." + activityInfo.packageName;
                        }
                    } catch (NameNotFoundException e) {
                    }
                }
            }
            return str;
        }

        private void zza(Context context, PackageManager packageManager) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.zzEq = telephonyManager.getNetworkOperator();
            this.zzEy = zza(context, connectivityManager, packageManager);
            this.zzEz = telephonyManager.getNetworkType();
            this.zzEA = telephonyManager.getPhoneType();
            if (VERSION.SDK_INT >= 16) {
                this.zzEF = connectivityManager.isActiveNetworkMetered();
                if (connectivityManager.getActiveNetworkInfo() != null) {
                    this.zzEG = connectivityManager.getActiveNetworkInfo().getDetailedState().ordinal();
                    return;
                } else {
                    this.zzEG = -1;
                    return;
                }
            }
            this.zzEF = false;
            this.zzEG = -1;
        }

        public zzgk zzfJ() {
            return new zzgk(this.zzEn, this.zzEo, this.zzEp, this.zzEq, this.zzEr, this.zzEs, this.zzEt, this.zzEu, this.zzEv, this.zzEw, this.zzEx, this.zzEy, this.zzEz, this.zzEA, this.zzEB, this.zzEC, this.zzCy, this.zzCw, this.zzCx, this.zzED, this.zzEE, this.zzEF, this.zzEG);
        }
    }

    zzgk(int i, boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, double d, boolean z6, boolean z7, int i10) {
        this.zzEn = i;
        this.zzEo = z;
        this.zzEp = z2;
        this.zzEq = str;
        this.zzEr = str2;
        this.zzEs = z3;
        this.zzEt = z4;
        this.zzEu = z5;
        this.zzEv = str3;
        this.zzEw = str4;
        this.zzEx = i2;
        this.zzEy = i3;
        this.zzEz = i4;
        this.zzEA = i5;
        this.zzEB = i6;
        this.zzEC = i7;
        this.zzCy = f;
        this.zzCw = i8;
        this.zzCx = i9;
        this.zzED = d;
        this.zzEE = z6;
        this.zzEF = z7;
        this.zzEG = i10;
    }
}
