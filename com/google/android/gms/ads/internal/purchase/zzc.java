package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.droidhang.pay.util.IabHelper;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzfj;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhh;
import com.google.android.gms.internal.zzhl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzgd
public class zzc extends zzhh implements ServiceConnection {
    private Context mContext;
    private boolean zzAC;
    private zzfj zzAD;
    private zzb zzAE;
    private zzh zzAF;
    private List<zzf> zzAG;
    private zzk zzAH;
    private final Object zzqt;

    public zzc(Context context, zzfj com_google_android_gms_internal_zzfj, zzk com_google_android_gms_ads_internal_purchase_zzk) {
        this(context, com_google_android_gms_internal_zzfj, com_google_android_gms_ads_internal_purchase_zzk, new zzb(context), zzh.zzy(context.getApplicationContext()));
    }

    zzc(Context context, zzfj com_google_android_gms_internal_zzfj, zzk com_google_android_gms_ads_internal_purchase_zzk, zzb com_google_android_gms_ads_internal_purchase_zzb, zzh com_google_android_gms_ads_internal_purchase_zzh) {
        this.zzqt = new Object();
        this.zzAC = false;
        this.zzAG = null;
        this.mContext = context;
        this.zzAD = com_google_android_gms_internal_zzfj;
        this.zzAH = com_google_android_gms_ads_internal_purchase_zzk;
        this.zzAE = com_google_android_gms_ads_internal_purchase_zzb;
        this.zzAF = com_google_android_gms_ads_internal_purchase_zzh;
        this.zzAG = this.zzAF.zzf(10);
    }

    private void zzd(long j) {
        do {
            if (!zze(j)) {
                zzb.zzaB("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.zzAC);
    }

    private boolean zze(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzqt.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            zzb.zzaC("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        synchronized (this.zzqt) {
            this.zzAE.zzK(service);
            zzfe();
            this.zzAC = true;
            this.zzqt.notify();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        zzb.zzaA("In-app billing service disconnected.");
        this.zzAE.destroy();
    }

    public void onStop() {
        synchronized (this.zzqt) {
            com.google.android.gms.common.stats.zzb.zzoO().zza(this.mContext, (ServiceConnection) this);
            this.zzAE.destroy();
        }
    }

    protected void zza(final zzf com_google_android_gms_ads_internal_purchase_zzf, String str, String str2) {
        final Intent intent = new Intent();
        zzo.zzbF();
        intent.putExtra(IabHelper.RESPONSE_CODE, 0);
        zzo.zzbF();
        intent.putExtra(IabHelper.RESPONSE_INAPP_PURCHASE_DATA, str);
        zzo.zzbF();
        intent.putExtra(IabHelper.RESPONSE_INAPP_SIGNATURE, str2);
        zzhl.zzGk.post(new Runnable(this) {
            final /* synthetic */ zzc zzAJ;

            public void run() {
                try {
                    if (this.zzAJ.zzAH.zza(com_google_android_gms_ads_internal_purchase_zzf.zzAS, -1, intent)) {
                        this.zzAJ.zzAD.zza(new zzg(this.zzAJ.mContext, com_google_android_gms_ads_internal_purchase_zzf.zzAT, true, -1, intent, com_google_android_gms_ads_internal_purchase_zzf));
                    } else {
                        this.zzAJ.zzAD.zza(new zzg(this.zzAJ.mContext, com_google_android_gms_ads_internal_purchase_zzf.zzAT, false, -1, intent, com_google_android_gms_ads_internal_purchase_zzf));
                    }
                } catch (RemoteException e) {
                    zzb.zzaC("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    public void zzdP() {
        synchronized (this.zzqt) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            com.google.android.gms.common.stats.zzb.zzoO().zza(this.mContext, intent, (ServiceConnection) this, 1);
            zzd(SystemClock.elapsedRealtime());
            com.google.android.gms.common.stats.zzb.zzoO().zza(this.mContext, (ServiceConnection) this);
            this.zzAE.destroy();
        }
    }

    protected void zzfe() {
        if (!this.zzAG.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (zzf com_google_android_gms_ads_internal_purchase_zzf : this.zzAG) {
                hashMap.put(com_google_android_gms_ads_internal_purchase_zzf.zzAT, com_google_android_gms_ads_internal_purchase_zzf);
            }
            String str = null;
            while (true) {
                Bundle zzi = this.zzAE.zzi(this.mContext.getPackageName(), str);
                if (zzi == null || zzo.zzbF().zzb(zzi) != 0) {
                    break;
                }
                ArrayList stringArrayList = zzi.getStringArrayList(IabHelper.RESPONSE_INAPP_ITEM_LIST);
                ArrayList stringArrayList2 = zzi.getStringArrayList(IabHelper.RESPONSE_INAPP_PURCHASE_DATA_LIST);
                ArrayList stringArrayList3 = zzi.getStringArrayList(IabHelper.RESPONSE_INAPP_SIGNATURE_LIST);
                String string = zzi.getString(IabHelper.INAPP_CONTINUATION_TOKEN);
                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (hashMap.containsKey(stringArrayList.get(i))) {
                        str = (String) stringArrayList.get(i);
                        String str2 = (String) stringArrayList2.get(i);
                        String str3 = (String) stringArrayList3.get(i);
                        zzf com_google_android_gms_ads_internal_purchase_zzf2 = (zzf) hashMap.get(str);
                        if (com_google_android_gms_ads_internal_purchase_zzf2.zzAS.equals(zzo.zzbF().zzai(str2))) {
                            zza(com_google_android_gms_ads_internal_purchase_zzf2, str2, str3);
                            hashMap.remove(str);
                        }
                    }
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str4 : hashMap.keySet()) {
                this.zzAF.zza((zzf) hashMap.get(str4));
            }
        }
    }
}
