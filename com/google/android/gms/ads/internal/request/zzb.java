package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzhh;
import com.google.android.gms.internal.zzhl;
import org.json.JSONException;
import org.json.JSONObject;

@zzgd
public class zzb extends zzhh implements com.google.android.gms.ads.internal.request.zzc.zza {
    private final Context mContext;
    private final Object zzBr = new Object();
    AdResponseParcel zzBt;
    private final com.google.android.gms.ads.internal.request.zza.zza zzCd;
    private final com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza zzCe;
    zzhh zzCf;
    Object zzqt = new Object();
    private final zzan zzvA;
    zzdy zzxn;

    class C03601 implements Runnable {
        final /* synthetic */ zzb zzCg;

        C03601(zzb com_google_android_gms_ads_internal_request_zzb) {
            this.zzCg = com_google_android_gms_ads_internal_request_zzb;
        }

        public void run() {
            this.zzCg.onStop();
        }
    }

    @zzgd
    static final class zza extends Exception {
        private final int zzBv;

        public zza(String str, int i) {
            super(str);
            this.zzBv = i;
        }

        public int getErrorCode() {
            return this.zzBv;
        }
    }

    public zzb(Context context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel.zza com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza, zzan com_google_android_gms_internal_zzan, com.google.android.gms.ads.internal.request.zza.zza com_google_android_gms_ads_internal_request_zza_zza) {
        this.zzCd = com_google_android_gms_ads_internal_request_zza_zza;
        this.mContext = context;
        this.zzCe = com_google_android_gms_ads_internal_request_AdRequestInfoParcel_zza;
        this.zzvA = com_google_android_gms_internal_zzan;
    }

    public void onStop() {
        synchronized (this.zzBr) {
            if (this.zzCf != null) {
                this.zzCf.cancel();
            }
        }
    }

    zzhh zzb(AdRequestInfoParcel adRequestInfoParcel) {
        return zzc.zza(this.mContext, adRequestInfoParcel, this);
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        synchronized (this.zzqt) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Received ad response.");
            this.zzBt = adResponseParcel;
            this.zzqt.notify();
        }
    }

    protected AdSizeParcel zzc(AdRequestInfoParcel adRequestInfoParcel) throws zza {
        if (this.zzBt.zzCN == null) {
            throw new zza("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.zzBt.zzCN.split("x");
        if (split.length != 2) {
            throw new zza("Invalid ad size format from the ad response: " + this.zzBt.zzCN, 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzpN.zzso) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = adSizeParcel.width == -1 ? (int) (((float) adSizeParcel.widthPixels) / f) : adSizeParcel.width;
                int i2 = adSizeParcel.height == -2 ? (int) (((float) adSizeParcel.heightPixels) / f) : adSizeParcel.height;
                if (parseInt == i && parseInt2 == i2) {
                    return new AdSizeParcel(adSizeParcel, adRequestInfoParcel.zzpN.zzso);
                }
            }
            throw new zza("The ad size from the ad response was not one of the requested sizes: " + this.zzBt.zzCN, 0);
        } catch (NumberFormatException e) {
            throw new zza("Invalid ad size number from the ad response: " + this.zzBt.zzCN, 0);
        }
    }

    public void zzdP() {
        zza e;
        synchronized (this.zzqt) {
            long elapsedRealtime;
            AdSizeParcel zzc;
            JSONObject jSONObject;
            final com.google.android.gms.internal.zzha.zza com_google_android_gms_internal_zzha_zza;
            com.google.android.gms.ads.internal.util.client.zzb.zzay("AdLoaderBackgroundTask started.");
            AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.zzCe, this.zzvA.zzab().zzb(this.mContext), zzl.zzq(this.mContext).getClientId());
            int i = -2;
            long j = -1;
            try {
                elapsedRealtime = zzo.zzbz().elapsedRealtime();
                zzhh zzb = zzb(adRequestInfoParcel);
                synchronized (this.zzBr) {
                    this.zzCf = zzb;
                    if (this.zzCf == null) {
                        throw new zza("Could not start the ad request service.", 0);
                    }
                }
                zzi(elapsedRealtime);
                j = zzo.zzbz().elapsedRealtime();
                zzfu();
                zzc = adRequestInfoParcel.zzpN.zzso != null ? zzc(adRequestInfoParcel) : null;
                try {
                    zzw(this.zzBt.zzCU);
                    elapsedRealtime = j;
                } catch (zza e2) {
                    e = e2;
                    i = e.getErrorCode();
                    if (i == 3 || i == -1) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaA(e.getMessage());
                    } else {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaC(e.getMessage());
                    }
                    if (this.zzBt == null) {
                        this.zzBt = new AdResponseParcel(i);
                    } else {
                        this.zzBt = new AdResponseParcel(i, this.zzBt.zzxJ);
                    }
                    zzhl.zzGk.post(new C03601(this));
                    elapsedRealtime = j;
                    if (!TextUtils.isEmpty(this.zzBt.zzCS)) {
                        try {
                            jSONObject = new JSONObject(this.zzBt.zzCS);
                        } catch (Throwable e3) {
                            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error parsing the JSON for Active View.", e3);
                        }
                        com_google_android_gms_internal_zzha_zza = new com.google.android.gms.internal.zzha.zza(adRequestInfoParcel, this.zzBt, this.zzxn, zzc, i, elapsedRealtime, this.zzBt.zzCO, jSONObject);
                        zzhl.zzGk.post(new Runnable(this) {
                            final /* synthetic */ zzb zzCg;

                            public void run() {
                                synchronized (this.zzCg.zzqt) {
                                    this.zzCg.zzCd.zza(com_google_android_gms_internal_zzha_zza);
                                }
                            }
                        });
                    }
                    jSONObject = null;
                    com_google_android_gms_internal_zzha_zza = new com.google.android.gms.internal.zzha.zza(adRequestInfoParcel, this.zzBt, this.zzxn, zzc, i, elapsedRealtime, this.zzBt.zzCO, jSONObject);
                    zzhl.zzGk.post(/* anonymous class already generated */);
                }
            } catch (zza e4) {
                e = e4;
                zzc = null;
            }
            if (TextUtils.isEmpty(this.zzBt.zzCS)) {
                jSONObject = new JSONObject(this.zzBt.zzCS);
                com_google_android_gms_internal_zzha_zza = new com.google.android.gms.internal.zzha.zza(adRequestInfoParcel, this.zzBt, this.zzxn, zzc, i, elapsedRealtime, this.zzBt.zzCO, jSONObject);
                zzhl.zzGk.post(/* anonymous class already generated */);
            }
            jSONObject = null;
            com_google_android_gms_internal_zzha_zza = new com.google.android.gms.internal.zzha.zza(adRequestInfoParcel, this.zzBt, this.zzxn, zzc, i, elapsedRealtime, this.zzBt.zzCO, jSONObject);
            zzhl.zzGk.post(/* anonymous class already generated */);
        }
    }

    protected boolean zze(long j) throws zza {
        long elapsedRealtime = 60000 - (zzo.zzbz().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzqt.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new zza("Ad request cancelled.", -1);
        }
    }

    protected void zzfu() throws zza {
        if (this.zzBt.errorCode != -3) {
            if (TextUtils.isEmpty(this.zzBt.zzCI)) {
                throw new zza("No fill from ad server.", 3);
            }
            zzo.zzby().zza(this.mContext, this.zzBt.zzCu);
            if (this.zzBt.zzCK) {
                try {
                    this.zzxn = new zzdy(this.zzBt.zzCI);
                } catch (JSONException e) {
                    throw new zza("Could not parse mediation config: " + this.zzBt.zzCI, 0);
                }
            }
        }
    }

    protected void zzi(long j) throws zza {
        while (zze(j)) {
            if (this.zzBt != null) {
                synchronized (this.zzBr) {
                    this.zzCf = null;
                }
                if (this.zzBt.errorCode != -2 && this.zzBt.errorCode != -3) {
                    throw new zza("There was a problem getting an ad response. ErrorCode: " + this.zzBt.errorCode, this.zzBt.errorCode);
                }
                return;
            }
        }
        throw new zza("Timed out waiting for ad response.", 2);
    }

    protected void zzw(boolean z) {
        zzo.zzby().zzA(z);
        zzbk zzD = zzo.zzby().zzD(this.mContext);
        if (zzD != null && !zzD.isAlive()) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("start fetching content...");
            zzD.zzcp();
        }
    }
}
