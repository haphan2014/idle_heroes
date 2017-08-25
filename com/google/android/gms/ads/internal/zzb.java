package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.ads.internal.purchase.GInAppPurchaseManagerInfoParcel;
import com.google.android.gms.ads.internal.purchase.zzc;
import com.google.android.gms.ads.internal.purchase.zzd;
import com.google.android.gms.ads.internal.purchase.zzg;
import com.google.android.gms.ads.internal.purchase.zzj;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzef;
import com.google.android.gms.internal.zzfc;
import com.google.android.gms.internal.zzfe;
import com.google.android.gms.internal.zzff;
import com.google.android.gms.internal.zzfj;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhb;
import com.google.android.gms.internal.zzhl;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@zzgd
public abstract class zzb extends zza implements zzf, zzj, zzdi, zzdz {
    private final Messenger mMessenger;
    protected final zzef zzoq;
    protected transient boolean zzor;

    public zzb(Context context, AdSizeParcel adSizeParcel, String str, zzef com_google_android_gms_internal_zzef, VersionInfoParcel versionInfoParcel) {
        this(new zzp(context, adSizeParcel, str, versionInfoParcel), com_google_android_gms_internal_zzef, null);
    }

    zzb(zzp com_google_android_gms_ads_internal_zzp, zzef com_google_android_gms_internal_zzef, zzn com_google_android_gms_ads_internal_zzn) {
        super(com_google_android_gms_ads_internal_zzp, com_google_android_gms_ads_internal_zzn);
        this.zzoq = com_google_android_gms_internal_zzef;
        this.mMessenger = new Messenger(new zzfc(this.zzon.zzpH));
        this.zzor = false;
    }

    private zza zza(AdRequestParcel adRequestParcel, Bundle bundle) {
        PackageInfo packageInfo;
        int i;
        ApplicationInfo applicationInfo = this.zzon.zzpH.getApplicationInfo();
        try {
            packageInfo = this.zzon.zzpH.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        DisplayMetrics displayMetrics = this.zzon.zzpH.getResources().getDisplayMetrics();
        Bundle bundle2 = null;
        if (!(this.zzon.zzpK == null || this.zzon.zzpK.getParent() == null)) {
            int[] iArr = new int[2];
            this.zzon.zzpK.getLocationOnScreen(iArr);
            int i2 = iArr[0];
            int i3 = iArr[1];
            int width = this.zzon.zzpK.getWidth();
            int height = this.zzon.zzpK.getHeight();
            i = 0;
            if (this.zzon.zzpK.isShown() && i2 + width > 0 && i3 + height > 0 && i2 <= displayMetrics.widthPixels && i3 <= displayMetrics.heightPixels) {
                i = 1;
            }
            bundle2 = new Bundle(5);
            bundle2.putInt("x", i2);
            bundle2.putInt("y", i3);
            bundle2.putInt("width", width);
            bundle2.putInt("height", height);
            bundle2.putInt("visible", i);
        }
        String zzfW = zzo.zzby().zzfW();
        this.zzon.zzpQ = new zzhb(zzfW, this.zzon.zzpG);
        this.zzon.zzpQ.zzh(adRequestParcel);
        String zza = zzo.zzbv().zza(this.zzon.zzpH, this.zzon.zzpK, this.zzon.zzpN);
        int zzbn = zzl.zzq(this.zzon.zzpH).zzbn();
        boolean zzbl = zzl.zzq(this.zzon.zzpH).zzbl();
        long j = 0;
        if (this.zzon.zzpU != null) {
            try {
                j = this.zzon.zzpU.getValue();
            } catch (RemoteException e2) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Cannot get correlation id, default to 0.");
            }
        }
        String uuid = UUID.randomUUID().toString();
        Bundle zza2 = zzo.zzby().zza(this.zzon.zzpH, this, zzfW);
        List arrayList = new ArrayList();
        for (i = 0; i < this.zzon.zzqa.size(); i++) {
            arrayList.add(this.zzon.zzqa.keyAt(i));
        }
        return new zza(bundle2, adRequestParcel, this.zzon.zzpN, this.zzon.zzpG, applicationInfo, packageInfo, zzfW, zzo.zzby().getSessionId(), this.zzon.zzpJ, zza2, this.zzon.zzqd, arrayList, bundle, zzo.zzby().zzga(), this.mMessenger, displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density, zza, zzbl, zzbn, j, uuid, zzbz.zzdb(), this.zzon.zzpF, this.zzon.zzqb);
    }

    public String getMediationAdapterClassName() {
        return this.zzon.zzpO == null ? null : this.zzon.zzpO.zzyb;
    }

    public void onAdClicked() {
        if (this.zzon.zzpO == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Ad state was null when trying to ping click URLs.");
            return;
        }
        if (!(this.zzon.zzpO.zzFm == null || this.zzon.zzpO.zzFm.zzxF == null)) {
            zzo.zzbG().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, this.zzon.zzpO, this.zzon.zzpG, false, zza(this.zzon.zzpO.zzFm.zzxF, this.zzon.zzpO.zzCC));
        }
        if (!(this.zzon.zzpO.zzxZ == null || this.zzon.zzpO.zzxZ.zzxx == null)) {
            zzo.zzbG().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, this.zzon.zzpO, this.zzon.zzpG, false, this.zzon.zzpO.zzxZ.zzxx);
        }
        super.onAdClicked();
    }

    public void pause() {
        zzu.zzbY("pause must be called on the main UI thread.");
        if (this.zzon.zzpO != null && this.zzon.zzbM()) {
            zzo.zzbx().zza(this.zzon.zzpO.zzzE.getWebView());
        }
        if (!(this.zzon.zzpO == null || this.zzon.zzpO.zzya == null)) {
            try {
                this.zzon.zzpO.zzya.pause();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not pause mediation adapter.");
            }
        }
        this.zzop.zzi(this.zzon.zzpO);
        this.zzom.pause();
    }

    public void resume() {
        zzu.zzbY("resume must be called on the main UI thread.");
        if (this.zzon.zzpO != null && this.zzon.zzbM()) {
            zzo.zzbx().zzb(this.zzon.zzpO.zzzE.getWebView());
        }
        if (!(this.zzon.zzpO == null || this.zzon.zzpO.zzya == null)) {
            try {
                this.zzon.zzpO.zzya.resume();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not resume mediation adapter.");
            }
        }
        this.zzom.resume();
        this.zzop.zzj(this.zzon.zzpO);
    }

    public void showInterstitial() {
        throw new IllegalStateException("showInterstitial is not supported for current ad type");
    }

    public void zza(zzff com_google_android_gms_internal_zzff) {
        zzu.zzbY("setInAppPurchaseListener must be called on the main UI thread.");
        this.zzon.zzpV = com_google_android_gms_internal_zzff;
    }

    public void zza(zzfj com_google_android_gms_internal_zzfj, String str) {
        zzu.zzbY("setPlayStorePurchaseParams must be called on the main UI thread.");
        this.zzon.zzqe = new zzk(str);
        this.zzon.zzpW = com_google_android_gms_internal_zzfj;
        if (!zzo.zzby().zzfZ() && com_google_android_gms_internal_zzfj != null) {
            new zzc(this.zzon.zzpH, this.zzon.zzpW, this.zzon.zzqe).zzgi();
        }
    }

    protected void zza(zzha com_google_android_gms_internal_zzha, boolean z) {
        if (com_google_android_gms_internal_zzha == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Ad state was null when trying to ping impression URLs.");
            return;
        }
        super.zzc(com_google_android_gms_internal_zzha);
        if (!(com_google_android_gms_internal_zzha.zzFm == null || com_google_android_gms_internal_zzha.zzFm.zzxG == null)) {
            zzo.zzbG().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, com_google_android_gms_internal_zzha, this.zzon.zzpG, z, zza(com_google_android_gms_internal_zzha.zzFm.zzxG, com_google_android_gms_internal_zzha.zzCC));
        }
        if (com_google_android_gms_internal_zzha.zzxZ != null && com_google_android_gms_internal_zzha.zzxZ.zzxy != null) {
            zzo.zzbG().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, com_google_android_gms_internal_zzha, this.zzon.zzpG, z, com_google_android_gms_internal_zzha.zzxZ.zzxy);
        }
    }

    public void zza(String str, ArrayList<String> arrayList) {
        zzfe com_google_android_gms_ads_internal_purchase_zzd = new zzd(str, arrayList, this.zzon.zzpH, this.zzon.zzpJ.zzGG);
        if (this.zzon.zzpV == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("InAppPurchaseListener is not set. Try to launch default purchase flow.");
            if (!com.google.android.gms.ads.internal.client.zzk.zzcA().zzP(this.zzon.zzpH)) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Google Play Service unavailable, cannot launch default purchase flow.");
                return;
            } else if (this.zzon.zzpW == null) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("PlayStorePurchaseListener is not set.");
                return;
            } else if (this.zzon.zzqe == null) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("PlayStorePurchaseVerifier is not initialized.");
                return;
            } else if (this.zzon.zzqi) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("An in-app purchase request is already in progress, abort");
                return;
            } else {
                this.zzon.zzqi = true;
                try {
                    if (this.zzon.zzpW.isValidPurchase(str)) {
                        zzo.zzbF().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGJ, new GInAppPurchaseManagerInfoParcel(this.zzon.zzpH, this.zzon.zzqe, com_google_android_gms_ads_internal_purchase_zzd, this));
                        return;
                    } else {
                        this.zzon.zzqi = false;
                        return;
                    }
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not start In-App purchase.");
                    this.zzon.zzqi = false;
                    return;
                }
            }
        }
        try {
            this.zzon.zzpV.zza(com_google_android_gms_ads_internal_purchase_zzd);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Could not start In-App purchase.");
        }
    }

    public void zza(String str, boolean z, int i, final Intent intent, com.google.android.gms.ads.internal.purchase.zzf com_google_android_gms_ads_internal_purchase_zzf) {
        try {
            if (this.zzon.zzpW != null) {
                this.zzon.zzpW.zza(new zzg(this.zzon.zzpH, str, z, i, intent, com_google_android_gms_ads_internal_purchase_zzf));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Fail to invoke PlayStorePurchaseListener.");
        }
        zzhl.zzGk.postDelayed(new Runnable(this) {
            final /* synthetic */ zzb zzot;

            public void run() {
                int zzd = zzo.zzbF().zzd(intent);
                zzo.zzbF();
                if (!(zzd != 0 || this.zzot.zzon.zzpO == null || this.zzot.zzon.zzpO.zzzE == null || this.zzot.zzon.zzpO.zzzE.zzgD() == null)) {
                    this.zzot.zzon.zzpO.zzzE.zzgD().close();
                }
                this.zzot.zzon.zzqi = false;
            }
        }, 500);
    }

    protected boolean zza(AdRequestParcel adRequestParcel, zzha com_google_android_gms_internal_zzha, boolean z) {
        if (!z && this.zzon.zzbM()) {
            if (com_google_android_gms_internal_zzha.zzxJ > 0) {
                this.zzom.zza(adRequestParcel, com_google_android_gms_internal_zzha.zzxJ);
            } else if (com_google_android_gms_internal_zzha.zzFm != null && com_google_android_gms_internal_zzha.zzFm.zzxJ > 0) {
                this.zzom.zza(adRequestParcel, com_google_android_gms_internal_zzha.zzFm.zzxJ);
            } else if (!com_google_android_gms_internal_zzha.zzCK && com_google_android_gms_internal_zzha.errorCode == 2) {
                this.zzom.zzf(adRequestParcel);
            }
        }
        return this.zzom.zzbp();
    }

    boolean zza(zzha com_google_android_gms_internal_zzha) {
        AdRequestParcel adRequestParcel;
        boolean z = false;
        if (this.zzoo != null) {
            adRequestParcel = this.zzoo;
            this.zzoo = null;
        } else {
            adRequestParcel = com_google_android_gms_internal_zzha.zzCm;
            if (adRequestParcel.extras != null) {
                z = adRequestParcel.extras.getBoolean("_noRefresh", false);
            }
        }
        return zza(adRequestParcel, com_google_android_gms_internal_zzha, z);
    }

    protected boolean zza(zzha com_google_android_gms_internal_zzha, zzha com_google_android_gms_internal_zzha2) {
        int i;
        int i2 = 0;
        if (!(com_google_android_gms_internal_zzha == null || com_google_android_gms_internal_zzha.zzyc == null)) {
            com_google_android_gms_internal_zzha.zzyc.zza(null);
        }
        if (com_google_android_gms_internal_zzha2.zzyc != null) {
            com_google_android_gms_internal_zzha2.zzyc.zza((zzdz) this);
        }
        if (com_google_android_gms_internal_zzha2.zzFm != null) {
            i = com_google_android_gms_internal_zzha2.zzFm.zzxM;
            i2 = com_google_android_gms_internal_zzha2.zzFm.zzxN;
        } else {
            i = 0;
        }
        this.zzon.zzqf.zzf(i, i2);
        return true;
    }

    protected boolean zzaU() {
        return zzo.zzbv().zza(this.zzon.zzpH.getPackageManager(), this.zzon.zzpH.getPackageName(), "android.permission.INTERNET") && zzo.zzbv().zzG(this.zzon.zzpH);
    }

    public void zzaV() {
        this.zzop.zzg(this.zzon.zzpO);
        this.zzor = false;
        zzaQ();
        this.zzon.zzpQ.zzfR();
    }

    public void zzaW() {
        this.zzor = true;
        zzaS();
    }

    public void zzaX() {
        onAdClicked();
    }

    public void zzaY() {
        zzaV();
    }

    public void zzaZ() {
        zzaO();
    }

    public void zzb(zzha com_google_android_gms_internal_zzha) {
        super.zzb(com_google_android_gms_internal_zzha);
        if (com_google_android_gms_internal_zzha.errorCode == 3 && com_google_android_gms_internal_zzha.zzFm != null && com_google_android_gms_internal_zzha.zzFm.zzxH != null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Pinging no fill URLs.");
            zzo.zzbG().zza(this.zzon.zzpH, this.zzon.zzpJ.zzGG, com_google_android_gms_internal_zzha, this.zzon.zzpG, false, com_google_android_gms_internal_zzha.zzFm.zzxH);
        }
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        if (!zzaU()) {
            return false;
        }
        Bundle zza = zza(zzo.zzby().zzD(this.zzon.zzpH));
        this.zzom.cancel();
        this.zzon.zzqh = 0;
        zza zza2 = zza(adRequestParcel, zza);
        this.zzon.zzpL = zzo.zzbr().zza(this.zzon.zzpH, zza2, this.zzon.zzpI, this);
        return true;
    }

    public void zzba() {
        zzaW();
    }

    public void zzbb() {
        if (this.zzon.zzpO != null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Mediation adapter " + this.zzon.zzpO.zzyb + " refreshed, but mediation adapters should never refresh.");
        }
        zza(this.zzon.zzpO, true);
        zzaT();
    }

    protected boolean zzc(AdRequestParcel adRequestParcel) {
        return super.zzc(adRequestParcel) && !this.zzor;
    }
}
