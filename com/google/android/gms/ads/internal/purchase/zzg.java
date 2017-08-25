package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zzfi.zza;
import com.google.android.gms.internal.zzgd;

@zzgd
public final class zzg extends zza implements ServiceConnection {
    private Context mContext;
    zzb zzAE;
    private String zzAK;
    private zzf zzAO;
    private boolean zzAU = false;
    private int zzAV;
    private Intent zzAW;

    public zzg(Context context, String str, boolean z, int i, Intent intent, zzf com_google_android_gms_ads_internal_purchase_zzf) {
        this.zzAK = str;
        this.zzAV = i;
        this.zzAW = intent;
        this.zzAU = z;
        this.mContext = context;
        this.zzAO = com_google_android_gms_ads_internal_purchase_zzf;
    }

    public void finishPurchase() {
        int zzd = zzo.zzbF().zzd(this.zzAW);
        if (this.zzAV == -1 && zzd == 0) {
            this.zzAE = new zzb(this.mContext);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            zzb.zzoO().zza(this.mContext, intent, (ServiceConnection) this, 1);
        }
    }

    public String getProductId() {
        return this.zzAK;
    }

    public Intent getPurchaseData() {
        return this.zzAW;
    }

    public int getResultCode() {
        return this.zzAV;
    }

    public boolean isVerified() {
        return this.zzAU;
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaA("In-app billing service connected.");
        this.zzAE.zzK(service);
        String zzaj = zzo.zzbF().zzaj(zzo.zzbF().zze(this.zzAW));
        if (zzaj != null) {
            if (this.zzAE.zzh(this.mContext.getPackageName(), zzaj) == 0) {
                zzh.zzy(this.mContext).zza(this.zzAO);
            }
            zzb.zzoO().zza(this.mContext, (ServiceConnection) this);
            this.zzAE.destroy();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaA("In-app billing service disconnected.");
        this.zzAE.destroy();
    }
}
