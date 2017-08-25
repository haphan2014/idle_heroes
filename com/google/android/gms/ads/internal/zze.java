package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzaw;
import com.google.android.gms.internal.zzaz;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzid;

@zzgd
public class zze extends zzc {
    public zze(Context context, AdSizeParcel adSizeParcel, String str, zzef com_google_android_gms_internal_zzef, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, com_google_android_gms_internal_zzef, versionInfoParcel);
    }

    private boolean zzb(zzha com_google_android_gms_internal_zzha, zzha com_google_android_gms_internal_zzha2) {
        View view;
        if (com_google_android_gms_internal_zzha2.zzCK) {
            try {
                zzd view2 = com_google_android_gms_internal_zzha2.zzya.getView();
                if (view2 == null) {
                    zzb.zzaC("View in mediation adapter is null.");
                    return false;
                }
                view = (View) com.google.android.gms.dynamic.zze.zzn(view2);
                View nextView = this.zzon.zzpK.getNextView();
                if (nextView != null) {
                    if (nextView instanceof zzid) {
                        ((zzid) nextView).destroy();
                    }
                    this.zzon.zzpK.removeView(nextView);
                }
                try {
                    zzb(view);
                } catch (Throwable th) {
                    zzb.zzd("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (Throwable th2) {
                zzb.zzd("Could not get View from mediation adapter.", th2);
                return false;
            }
        } else if (com_google_android_gms_internal_zzha2.zzFn != null) {
            com_google_android_gms_internal_zzha2.zzzE.zza(com_google_android_gms_internal_zzha2.zzFn);
            this.zzon.zzpK.removeAllViews();
            this.zzon.zzpK.setMinimumWidth(com_google_android_gms_internal_zzha2.zzFn.widthPixels);
            this.zzon.zzpK.setMinimumHeight(com_google_android_gms_internal_zzha2.zzFn.heightPixels);
            zzb(com_google_android_gms_internal_zzha2.zzzE.getWebView());
        }
        if (this.zzon.zzpK.getChildCount() > 1) {
            this.zzon.zzpK.showNext();
        }
        if (com_google_android_gms_internal_zzha != null) {
            view = this.zzon.zzpK.getNextView();
            if (view instanceof zzid) {
                ((zzid) view).zza(this.zzon.zzpH, this.zzon.zzpN);
            } else if (view != null) {
                this.zzon.zzpK.removeView(view);
            }
            this.zzon.zzbL();
        }
        this.zzon.zzpK.setVisibility(0);
        return true;
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    public boolean zza(zzha com_google_android_gms_internal_zzha, zzha com_google_android_gms_internal_zzha2) {
        if (!super.zza(com_google_android_gms_internal_zzha, com_google_android_gms_internal_zzha2)) {
            return false;
        }
        if (!this.zzon.zzbM() || zzb(com_google_android_gms_internal_zzha, com_google_android_gms_internal_zzha2)) {
            zza(com_google_android_gms_internal_zzha2, false);
            if (this.zzon.zzbM()) {
                if (com_google_android_gms_internal_zzha2.zzzE != null && (com_google_android_gms_internal_zzha2.zzzE.zzgF().zzbU() || com_google_android_gms_internal_zzha2.zzFl != null)) {
                    zzaz zza = this.zzop.zza(this.zzon.zzpN, com_google_android_gms_internal_zzha2);
                    if (com_google_android_gms_internal_zzha2.zzzE.zzgF().zzbU() && zza != null) {
                        zza.zza((zzaw) this);
                    }
                }
                if (com_google_android_gms_internal_zzha2.zzzE != null) {
                    com_google_android_gms_internal_zzha2.zzzE.zzgF().zzgS();
                }
            } else if (!(this.zzon.zzqg == null || com_google_android_gms_internal_zzha2.zzFl == null)) {
                this.zzop.zza(this.zzon.zzpN, com_google_android_gms_internal_zzha2, this.zzon.zzqg);
            }
            return true;
        }
        zze(0);
        return false;
    }

    protected boolean zzaU() {
        boolean z = true;
        if (!zzo.zzbv().zza(this.zzon.zzpH.getPackageManager(), this.zzon.zzpH.getPackageName(), "android.permission.INTERNET")) {
            zzk.zzcA().zza(this.zzon.zzpK, this.zzon.zzpN, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzo.zzbv().zzG(this.zzon.zzpH)) {
            zzk.zzcA().zza(this.zzon.zzpK, this.zzon.zzpN, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!(z || this.zzon.zzpK == null)) {
            this.zzon.zzpK.setVisibility(0);
        }
        return z;
    }
}
