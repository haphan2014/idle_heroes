package com.google.android.gms.ads.internal;

import android.net.Uri.Builder;
import android.text.TextUtils;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzid;

@zzgd
public class zzd {
    private zza zzow;
    private boolean zzox;
    private boolean zzoy;

    public interface zza {
        void zzp(String str);
    }

    @zzgd
    public static class zzb implements zza {
        private final zzid zzoA;
        private final com.google.android.gms.internal.zzha.zza zzoz;

        public zzb(com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza, zzid com_google_android_gms_internal_zzid) {
            this.zzoz = com_google_android_gms_internal_zzha_zza;
            this.zzoA = com_google_android_gms_internal_zzid;
        }

        public void zzp(String str) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("An auto-clicking creative is blocked");
            Builder builder = new Builder();
            builder.scheme("https");
            builder.path("//pagead2.googlesyndication.com/pagead/gen_204");
            builder.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(str)) {
                builder.appendQueryParameter("navigationURL", str);
            }
            if (!(this.zzoz == null || this.zzoz.zzFs == null || TextUtils.isEmpty(this.zzoz.zzFs.zzCP))) {
                builder.appendQueryParameter("debugDialog", this.zzoz.zzFs.zzCP);
            }
            zzo.zzbv().zzc(this.zzoA.getContext(), this.zzoA.zzgI().zzGG, builder.toString());
        }
    }

    public zzd() {
        this.zzoy = ((Boolean) zzbz.zztI.get()).booleanValue();
    }

    public zzd(boolean z) {
        this.zzoy = z;
    }

    public void recordClick() {
        this.zzox = true;
    }

    public void zza(zza com_google_android_gms_ads_internal_zzd_zza) {
        this.zzow = com_google_android_gms_ads_internal_zzd_zza;
    }

    public boolean zzbd() {
        return !this.zzoy || this.zzox;
    }

    public void zzo(String str) {
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Action was blocked because no click was detected.");
        if (this.zzow != null) {
            this.zzow.zzp(str);
        }
    }
}
