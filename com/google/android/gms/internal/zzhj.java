package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.heyzap.sdk.ads.HeyzapAds.Network;
import java.util.concurrent.Future;

@zzgd
public final class zzhj {

    public interface zzb {
        void zzc(Bundle bundle);
    }

    private static abstract class zza extends zzhh {
        private zza() {
        }

        public void onStop() {
        }
    }

    public static Future zza(final Context context, final int i) {
        return new zza() {
            public void zzdP() {
                Editor edit = zzhj.zzv(context).edit();
                edit.putInt("webview_cache_version", i);
                edit.commit();
            }
        }.zzgi();
    }

    public static Future zza(final Context context, final zzb com_google_android_gms_internal_zzhj_zzb) {
        return new zza() {
            public void zzdP() {
                SharedPreferences zzF = zzhj.zzv(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("use_https", zzF.getBoolean("use_https", true));
                if (com_google_android_gms_internal_zzhj_zzb != null) {
                    com_google_android_gms_internal_zzhj_zzb.zzc(bundle);
                }
            }
        }.zzgi();
    }

    public static Future zza(final Context context, final boolean z) {
        return new zza() {
            public void zzdP() {
                Editor edit = zzhj.zzv(context).edit();
                edit.putBoolean("use_https", z);
                edit.commit();
            }
        }.zzgi();
    }

    public static Future zzb(final Context context, final zzb com_google_android_gms_internal_zzhj_zzb) {
        return new zza() {
            public void zzdP() {
                SharedPreferences zzF = zzhj.zzv(context);
                Bundle bundle = new Bundle();
                bundle.putInt("webview_cache_version", zzF.getInt("webview_cache_version", 0));
                if (com_google_android_gms_internal_zzhj_zzb != null) {
                    com_google_android_gms_internal_zzhj_zzb.zzc(bundle);
                }
            }
        }.zzgi();
    }

    private static SharedPreferences zzv(Context context) {
        return context.getSharedPreferences(Network.ADMOB, 0);
    }
}
