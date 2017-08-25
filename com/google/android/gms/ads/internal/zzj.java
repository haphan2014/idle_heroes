package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Window;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzaw;
import com.google.android.gms.internal.zzaz;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzdk;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzid;
import com.heyzap.house.abstr.AbstractActivity;

@zzgd
public class zzj extends zzc implements zzdk {
    protected transient boolean zzoT = false;

    public zzj(Context context, AdSizeParcel adSizeParcel, String str, zzef com_google_android_gms_internal_zzef, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, com_google_android_gms_internal_zzef, versionInfoParcel);
    }

    private void zza(Bundle bundle) {
        zzo.zzbv().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, "gmob-apps", bundle, false);
    }

    private void zzbk() {
        if (this.zzon.zzbM()) {
            this.zzon.zzbJ();
            this.zzon.zzpO = null;
            this.zzon.zzoU = false;
            this.zzoT = false;
        }
    }

    public void showInterstitial() {
        zzu.zzbY("showInterstitial must be called on the main UI thread.");
        if (this.zzon.zzpO == null) {
            zzb.zzaC("The interstitial has not loaded.");
            return;
        }
        String packageName = this.zzon.zzpH.getApplicationContext() != null ? this.zzon.zzpH.getApplicationContext().getPackageName() : this.zzon.zzpH.getPackageName();
        if (!this.zzoT) {
            zzb.zzaC("It is not recommended to show an interstitial before onAdLoaded completes.");
            Bundle bundle = new Bundle();
            bundle.putString(AppsFlyerProperties.APP_ID, packageName);
            bundle.putString(AbstractActivity.ACTIVITY_INTENT_ACTION_KEY, "show_interstitial_before_load_finish");
            zza(bundle);
        }
        if (!zzo.zzbv().zzM(this.zzon.zzpH)) {
            zzb.zzaC("It is not recommended to show an interstitial when app is not in foreground.");
            bundle = new Bundle();
            bundle.putString(AppsFlyerProperties.APP_ID, packageName);
            bundle.putString(AbstractActivity.ACTIVITY_INTENT_ACTION_KEY, "show_interstitial_app_not_in_foreground");
            zza(bundle);
        }
        if (!this.zzon.zzbN()) {
            if (this.zzon.zzpO.zzzE.zzgJ()) {
                zzb.zzaC("The interstitial is already showing.");
                return;
            }
            this.zzon.zzpO.zzzE.zzB(true);
            if (this.zzon.zzpO.zzzE.zzgF().zzbU() || this.zzon.zzpO.zzFl != null) {
                zzaz zza = this.zzop.zza(this.zzon.zzpN, this.zzon.zzpO);
                if (this.zzon.zzpO.zzzE.zzgF().zzbU() && zza != null) {
                    zza.zza((zzaw) this);
                }
            }
            if (this.zzon.zzpO.zzCK) {
                try {
                    this.zzon.zzpO.zzya.showInterstitial();
                    return;
                } catch (Throwable e) {
                    zzb.zzd("Could not show interstitial.", e);
                    zzbk();
                    return;
                }
            }
            InterstitialAdParameterParcel interstitialAdParameterParcel = new InterstitialAdParameterParcel(this.zzon.zzoU, zzbj());
            int requestedOrientation = this.zzon.zzpO.zzzE.getRequestedOrientation();
            if (requestedOrientation == -1) {
                requestedOrientation = this.zzon.zzpO.orientation;
            }
            zzo.zzbt().zza(this.zzon.zzpH, new AdOverlayInfoParcel(this, this, this, this.zzon.zzpO.zzzE, requestedOrientation, this.zzon.zzpJ, this.zzon.zzpO.zzCP, interstitialAdParameterParcel));
        }
    }

    protected zzid zza(zzd com_google_android_gms_ads_internal_zzd) {
        zzid zza = zzo.zzbw().zza(this.zzon.zzpH, this.zzon.zzpN, false, false, this.zzon.zzpI, this.zzon.zzpJ);
        zza.zzgF().zzb(this, null, this, this, ((Boolean) zzbz.zzuk.get()).booleanValue(), this, this, com_google_android_gms_ads_internal_zzd, null);
        return zza;
    }

    protected boolean zza(AdRequestParcel adRequestParcel, zzha com_google_android_gms_internal_zzha, boolean z) {
        if (this.zzon.zzbM()) {
            zzo.zzbx().zza(com_google_android_gms_internal_zzha.zzzE.getWebView());
        }
        return this.zzom.zzbp();
    }

    public boolean zza(zzha com_google_android_gms_internal_zzha, zzha com_google_android_gms_internal_zzha2) {
        if (!super.zza(com_google_android_gms_internal_zzha, com_google_android_gms_internal_zzha2)) {
            return false;
        }
        if (this.zzon.zzbM()) {
            if (com_google_android_gms_internal_zzha2.zzzE != null) {
                com_google_android_gms_internal_zzha2.zzzE.zzgF().zzgS();
            }
        } else if (!(this.zzon.zzqg == null || com_google_android_gms_internal_zzha2.zzFl == null)) {
            this.zzop.zza(this.zzon.zzpN, com_google_android_gms_internal_zzha2, this.zzon.zzqg);
        }
        return true;
    }

    protected boolean zzaT() {
        if (!super.zzaT()) {
            return false;
        }
        this.zzoT = true;
        return true;
    }

    public void zzaV() {
        zzbk();
        super.zzaV();
    }

    public void zzaW() {
        recordImpression();
        super.zzaW();
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        if (this.zzon.zzpO == null) {
            return super.zzb(adRequestParcel);
        }
        zzb.zzaC("An interstitial is already loading. Aborting.");
        return false;
    }

    protected boolean zzbj() {
        if (!(this.zzon.zzpH instanceof Activity)) {
            return false;
        }
        Window window = ((Activity) this.zzon.zzpH).getWindow();
        if (window == null || window.getDecorView() == null) {
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        window.getDecorView().getGlobalVisibleRect(rect, null);
        window.getDecorView().getWindowVisibleDisplayFrame(rect2);
        boolean z = (rect.bottom == 0 || rect2.bottom == 0 || rect.top != rect2.top) ? false : true;
        return z;
    }

    public void zzd(boolean z) {
        this.zzon.zzoU = z;
    }
}
