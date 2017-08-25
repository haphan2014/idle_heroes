package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzo;
import com.heyzap.http.AsyncHttpResponseHandler;
import org.json.JSONObject;

@zzgd
public class zzbd implements zzbb {
    private final zzid zzoA;

    public zzbd(Context context, VersionInfoParcel versionInfoParcel) {
        this.zzoA = zzo.zzbw().zza(context, new AdSizeParcel(), false, false, null, versionInfoParcel);
        this.zzoA.setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable) {
        if (zzk.zzcA().zzgw()) {
            runnable.run();
        } else {
            zzhl.zzGk.post(runnable);
        }
    }

    public void destroy() {
        this.zzoA.destroy();
    }

    public void zza(zza com_google_android_gms_ads_internal_client_zza, zzf com_google_android_gms_ads_internal_overlay_zzf, zzde com_google_android_gms_internal_zzde, com.google.android.gms.ads.internal.overlay.zzk com_google_android_gms_ads_internal_overlay_zzk, boolean z, zzdi com_google_android_gms_internal_zzdi, zzdk com_google_android_gms_internal_zzdk, zzd com_google_android_gms_ads_internal_zzd, zzev com_google_android_gms_internal_zzev) {
        this.zzoA.zzgF().zzb(com_google_android_gms_ads_internal_client_zza, com_google_android_gms_ads_internal_overlay_zzf, com_google_android_gms_internal_zzde, com_google_android_gms_ads_internal_overlay_zzk, z, com_google_android_gms_internal_zzdi, com_google_android_gms_internal_zzdk, new zzd(false), com_google_android_gms_internal_zzev);
    }

    public void zza(final zzbb.zza com_google_android_gms_internal_zzbb_zza) {
        this.zzoA.zzgF().zza(new zzie.zza(this) {
            final /* synthetic */ zzbd zzrd;

            public void zza(zzid com_google_android_gms_internal_zzid, boolean z) {
                com_google_android_gms_internal_zzbb_zza.zzcf();
            }
        });
    }

    public void zza(String str, zzdg com_google_android_gms_internal_zzdg) {
        this.zzoA.zzgF().zza(str, com_google_android_gms_internal_zzdg);
    }

    public void zza(final String str, final String str2) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzrd;

            public void run() {
                this.zzrd.zzoA.zza(str, str2);
            }
        });
    }

    public void zza(final String str, final JSONObject jSONObject) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzrd;

            public void run() {
                this.zzrd.zzoA.zza(str, jSONObject);
            }
        });
    }

    public void zzb(String str, zzdg com_google_android_gms_internal_zzdg) {
        this.zzoA.zzgF().zzb(str, com_google_android_gms_internal_zzdg);
    }

    public zzbf zzce() {
        return new zzbg(this);
    }

    public void zzr(String str) {
        final String format = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str});
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzrd;

            public void run() {
                this.zzrd.zzoA.loadData(format, "text/html", AsyncHttpResponseHandler.DEFAULT_CHARSET);
            }
        });
    }

    public void zzs(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzrd;

            public void run() {
                this.zzrd.zzoA.loadUrl(str);
            }
        });
    }

    public void zzt(final String str) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzbd zzrd;

            public void run() {
                this.zzrd.zzoA.loadData(str, "text/html", AsyncHttpResponseHandler.DEFAULT_CHARSET);
            }
        });
    }
}
