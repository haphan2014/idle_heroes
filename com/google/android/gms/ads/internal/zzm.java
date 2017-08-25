package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.formats.zzd;
import com.google.android.gms.ads.internal.formats.zze;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.formats.zzg.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzci;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzff;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhl;
import com.google.android.gms.internal.zzkw;
import java.util.List;

@zzgd
public class zzm extends zzb {
    public zzm(Context context, AdSizeParcel adSizeParcel, String str, zzef com_google_android_gms_internal_zzef, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, com_google_android_gms_internal_zzef, versionInfoParcel);
    }

    private void zza(final zzha com_google_android_gms_internal_zzha, final String str) {
        zzhl.zzGk.post(new Runnable(this) {
            final /* synthetic */ zzm zzpe;

            public void run() {
                try {
                    ((zzcx) this.zzpe.zzon.zzqa.get(str)).zza((zzf) com_google_android_gms_internal_zzha.zzFq);
                } catch (Throwable e) {
                    zzb.zzd("Could not call onCustomTemplateAdLoadedListener.onCustomTemplateAdLoaded().", e);
                }
            }
        });
    }

    private void zzd(final zzha com_google_android_gms_internal_zzha) {
        zzhl.zzGk.post(new Runnable(this) {
            final /* synthetic */ zzm zzpe;

            public void run() {
                try {
                    this.zzpe.zzon.zzpX.zza((zzd) com_google_android_gms_internal_zzha.zzFq);
                } catch (Throwable e) {
                    zzb.zzd("Could not call OnAppInstallAdLoadedListener.onAppInstallAdLoaded().", e);
                }
            }
        });
    }

    private void zze(final zzha com_google_android_gms_internal_zzha) {
        zzhl.zzGk.post(new Runnable(this) {
            final /* synthetic */ zzm zzpe;

            public void run() {
                try {
                    this.zzpe.zzon.zzpY.zza((zze) com_google_android_gms_internal_zzha.zzFq);
                } catch (Throwable e) {
                    zzb.zzd("Could not call OnContentAdLoadedListener.onContentAdLoaded().", e);
                }
            }
        });
    }

    public void pause() {
        throw new IllegalStateException("Native Ad DOES NOT support pause().");
    }

    public void resume() {
        throw new IllegalStateException("Native Ad DOES NOT support resume().");
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by NativeAdManager.");
    }

    public void zza(zzci com_google_android_gms_internal_zzci) {
        throw new IllegalStateException("CustomRendering is NOT supported by NativeAdManager.");
    }

    public void zza(zzff com_google_android_gms_internal_zzff) {
        throw new IllegalStateException("In App Purchase is NOT supported by NativeAdManager.");
    }

    public void zza(zzkw<String, zzcx> com_google_android_gms_internal_zzkw_java_lang_String__com_google_android_gms_internal_zzcx) {
        zzu.zzbY("setOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        this.zzon.zzqa = com_google_android_gms_internal_zzkw_java_lang_String__com_google_android_gms_internal_zzcx;
    }

    public void zza(List<String> list) {
        zzu.zzbY("setNativeTemplates must be called on the main UI thread.");
        this.zzon.zzqd = list;
    }

    protected boolean zza(AdRequestParcel adRequestParcel, zzha com_google_android_gms_internal_zzha, boolean z) {
        return this.zzom.zzbp();
    }

    protected boolean zza(zzha com_google_android_gms_internal_zzha, zzha com_google_android_gms_internal_zzha2) {
        zza(null);
        if (this.zzon.zzbM()) {
            zza com_google_android_gms_ads_internal_formats_zzg_zza = com_google_android_gms_internal_zzha2.zzFq;
            if ((com_google_android_gms_ads_internal_formats_zzg_zza instanceof zze) && this.zzon.zzpY != null) {
                zze(com_google_android_gms_internal_zzha2);
            } else if ((com_google_android_gms_ads_internal_formats_zzg_zza instanceof zzd) && this.zzon.zzpX != null) {
                zzd(com_google_android_gms_internal_zzha2);
            } else if (!(com_google_android_gms_ads_internal_formats_zzg_zza instanceof zzf) || this.zzon.zzqa == null || this.zzon.zzqa.get(((zzf) com_google_android_gms_ads_internal_formats_zzg_zza).getCustomTemplateId()) == null) {
                zzb.zzaC("No matching listener for retrieved native ad template.");
                zze(0);
                return false;
            } else {
                zza(com_google_android_gms_internal_zzha2, ((zzf) com_google_android_gms_ads_internal_formats_zzg_zza).getCustomTemplateId());
            }
            return super.zza(com_google_android_gms_internal_zzha, com_google_android_gms_internal_zzha2);
        }
        throw new IllegalStateException("Native ad DOES NOT have custom rendering mode.");
    }

    public void zzb(NativeAdOptionsParcel nativeAdOptionsParcel) {
        zzu.zzbY("setNativeAdOptions must be called on the main UI thread.");
        this.zzon.zzqb = nativeAdOptionsParcel;
    }

    public void zzb(zzcu com_google_android_gms_internal_zzcu) {
        zzu.zzbY("setOnAppInstallAdLoadedListener must be called on the main UI thread.");
        this.zzon.zzpX = com_google_android_gms_internal_zzcu;
    }

    public void zzb(zzcv com_google_android_gms_internal_zzcv) {
        zzu.zzbY("setOnContentAdLoadedListener must be called on the main UI thread.");
        this.zzon.zzpY = com_google_android_gms_internal_zzcv;
    }

    public void zzb(zzkw<String, zzcw> com_google_android_gms_internal_zzkw_java_lang_String__com_google_android_gms_internal_zzcw) {
        zzu.zzbY("setOnCustomClickListener must be called on the main UI thread.");
        this.zzon.zzpZ = com_google_android_gms_internal_zzkw_java_lang_String__com_google_android_gms_internal_zzcw;
    }

    public boolean zzb(zzha.zza com_google_android_gms_internal_zzha_zza) {
        if (com_google_android_gms_internal_zzha_zza.zzpN != null) {
            this.zzon.zzpN = com_google_android_gms_internal_zzha_zza.zzpN;
        }
        if (com_google_android_gms_internal_zzha_zza.errorCode != -2) {
            zzb(new zzha(com_google_android_gms_internal_zzha_zza, null, null, null, null, null, null));
            return false;
        }
        this.zzon.zzqh = 0;
        this.zzon.zzpM = zzo.zzbu().zza(this.zzon.zzpH, this, com_google_android_gms_internal_zzha_zza, this.zzon.zzpI, null, this.zzoq, this);
        return true;
    }

    public zzkw<String, zzcx> zzbo() {
        zzu.zzbY("getOnCustomTemplateAdLoadedListeners must be called on the main UI thread.");
        return this.zzon.zzqa;
    }

    public zzcw zzq(String str) {
        zzu.zzbY("getOnCustomClickListener must be called on the main UI thread.");
        return (zzcw) this.zzon.zzpZ.get(str);
    }
}
