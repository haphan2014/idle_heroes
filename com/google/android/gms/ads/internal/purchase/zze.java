package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.droidhang.pay.util.IabHelper;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzfe;
import com.google.android.gms.internal.zzfg.zza;
import com.google.android.gms.internal.zzgd;

@zzgd
public class zze extends zza implements ServiceConnection {
    private final Activity mActivity;
    private zzb zzAE;
    zzh zzAF;
    private zzk zzAH;
    private Context zzAM;
    private zzfe zzAN;
    private zzf zzAO;
    private zzj zzAP;
    private String zzAQ = null;

    public zze(Activity activity) {
        this.mActivity = activity;
        this.zzAF = zzh.zzy(this.mActivity.getApplicationContext());
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1001) {
            boolean z = false;
            try {
                int zzd = zzo.zzbF().zzd(data);
                if (resultCode == -1) {
                    zzo.zzbF();
                    if (zzd == 0) {
                        if (this.zzAH.zza(this.zzAQ, resultCode, data)) {
                            z = true;
                        }
                        this.zzAN.recordPlayBillingResolution(zzd);
                        this.mActivity.finish();
                        zza(this.zzAN.getProductId(), z, resultCode, data);
                    }
                }
                this.zzAF.zza(this.zzAO);
                this.zzAN.recordPlayBillingResolution(zzd);
                this.mActivity.finish();
                zza(this.zzAN.getProductId(), z, resultCode, data);
            } catch (RemoteException e) {
                zzb.zzaC("Fail to process purchase result.");
                this.mActivity.finish();
            } finally {
                this.zzAQ = null;
            }
        }
    }

    public void onCreate() {
        GInAppPurchaseManagerInfoParcel zzc = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
        this.zzAP = zzc.zzAA;
        this.zzAH = zzc.zzqe;
        this.zzAN = zzc.zzAy;
        this.zzAE = new zzb(this.mActivity.getApplicationContext());
        this.zzAM = zzc.zzAz;
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            this.mActivity.setRequestedOrientation(zzo.zzbx().zzgq());
        } else {
            this.mActivity.setRequestedOrientation(zzo.zzbx().zzgr());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        this.mActivity.bindService(intent, this, 1);
    }

    public void onDestroy() {
        this.mActivity.unbindService(this);
        this.zzAE.destroy();
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        Throwable e;
        this.zzAE.zzK(service);
        try {
            this.zzAQ = this.zzAH.zzfi();
            Bundle zzb = this.zzAE.zzb(this.mActivity.getPackageName(), this.zzAN.getProductId(), this.zzAQ);
            PendingIntent pendingIntent = (PendingIntent) zzb.getParcelable(IabHelper.RESPONSE_BUY_INTENT);
            if (pendingIntent == null) {
                int zzb2 = zzo.zzbF().zzb(zzb);
                this.zzAN.recordPlayBillingResolution(zzb2);
                zza(this.zzAN.getProductId(), false, zzb2, null);
                this.mActivity.finish();
                return;
            }
            this.zzAO = new zzf(this.zzAN.getProductId(), this.zzAQ);
            this.zzAF.zzb(this.zzAO);
            this.mActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
        } catch (RemoteException e2) {
            e = e2;
            zzb.zzd("Error when connecting in-app billing service", e);
            this.mActivity.finish();
        } catch (SendIntentException e3) {
            e = e3;
            zzb.zzd("Error when connecting in-app billing service", e);
            this.mActivity.finish();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        zzb.zzaA("In-app billing service disconnected.");
        this.zzAE.destroy();
    }

    protected void zza(String str, boolean z, int i, Intent intent) {
        if (this.zzAP != null) {
            this.zzAP.zza(str, z, i, intent, this.zzAO);
        }
    }
}
