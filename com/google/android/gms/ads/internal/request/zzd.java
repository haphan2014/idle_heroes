package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzge;
import com.google.android.gms.internal.zzgf;
import com.google.android.gms.internal.zzhh;
import com.heyzap.house.abstr.AbstractActivity;

@zzgd
public abstract class zzd extends zzhh implements com.google.android.gms.ads.internal.request.zzc.zza {
    private AdResponseParcel zzBt;
    private final com.google.android.gms.ads.internal.request.zzc.zza zzCi;
    private final Object zzqt = new Object();
    private final AdRequestInfoParcel zzxm;

    @zzgd
    public static final class zza extends zzd {
        private final Context mContext;

        public zza(Context context, AdRequestInfoParcel adRequestInfoParcel, com.google.android.gms.ads.internal.request.zzc.zza com_google_android_gms_ads_internal_request_zzc_zza) {
            super(adRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza);
            this.mContext = context;
        }

        public void zzfv() {
        }

        public zzi zzfw() {
            return zzgf.zza(this.mContext, new zzbr((String) zzbz.zztD.get()), zzge.zzfC());
        }
    }

    @zzgd
    public static class zzb extends zzd implements ConnectionCallbacks, OnConnectionFailedListener {
        private Context mContext;
        private final com.google.android.gms.ads.internal.request.zzc.zza zzCi;
        protected zze zzCj;
        private final Object zzqt = new Object();
        private AdRequestInfoParcel zzxm;

        public zzb(Context context, AdRequestInfoParcel adRequestInfoParcel, com.google.android.gms.ads.internal.request.zzc.zza com_google_android_gms_ads_internal_request_zzc_zza) {
            super(adRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza);
            this.mContext = context;
            this.zzxm = adRequestInfoParcel;
            this.zzCi = com_google_android_gms_ads_internal_request_zzc_zza;
            this.zzCj = new zze(context, this, this, adRequestInfoParcel.zzpJ.zzGI);
            connect();
        }

        protected void connect() {
            this.zzCj.zznJ();
        }

        public void onConnected(Bundle connectionHint) {
            zzgi();
        }

        public void onConnectionFailed(ConnectionResult result) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Cannot connect to remote service, fallback to local instance.");
            zzfx().zzgi();
            Bundle bundle = new Bundle();
            bundle.putString(AbstractActivity.ACTIVITY_INTENT_ACTION_KEY, "gms_connection_failed_fallback_to_local");
            zzo.zzbv().zza(this.mContext, this.zzxm.zzpJ.zzGG, "gmob-apps", bundle, true);
        }

        public void onConnectionSuspended(int cause) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Disconnected from remote ad request service.");
        }

        public void zzfv() {
            synchronized (this.zzqt) {
                if (this.zzCj.isConnected() || this.zzCj.isConnecting()) {
                    this.zzCj.disconnect();
                }
                Binder.flushPendingCommands();
            }
        }

        public zzi zzfw() {
            zzi zzfy;
            synchronized (this.zzqt) {
                try {
                    zzfy = this.zzCj.zzfy();
                } catch (IllegalStateException e) {
                    zzfy = null;
                    return zzfy;
                } catch (DeadObjectException e2) {
                    zzfy = null;
                    return zzfy;
                }
            }
            return zzfy;
        }

        zzhh zzfx() {
            return new zza(this.mContext, this.zzxm, this.zzCi);
        }
    }

    public zzd(AdRequestInfoParcel adRequestInfoParcel, com.google.android.gms.ads.internal.request.zzc.zza com_google_android_gms_ads_internal_request_zzc_zza) {
        this.zzxm = adRequestInfoParcel;
        this.zzCi = com_google_android_gms_ads_internal_request_zzc_zza;
    }

    public final void onStop() {
        zzfv();
    }

    boolean zza(zzi com_google_android_gms_ads_internal_request_zzi, AdRequestInfoParcel adRequestInfoParcel) {
        try {
            com_google_android_gms_ads_internal_request_zzi.zza(adRequestInfoParcel, new zzg(this));
            return true;
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service.", e);
            zzo.zzby().zzc(e, true);
        } catch (Throwable e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", e2);
            zzo.zzby().zzc(e2, true);
        } catch (Throwable e22) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", e22);
            zzo.zzby().zzc(e22, true);
        } catch (Throwable e222) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", e222);
            zzo.zzby().zzc(e222, true);
        }
        this.zzCi.zzb(new AdResponseParcel(0));
        return false;
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        synchronized (this.zzqt) {
            this.zzBt = adResponseParcel;
            this.zzqt.notify();
        }
    }

    public void zzdP() {
        try {
            zzi zzfw = zzfw();
            if (zzfw == null) {
                this.zzCi.zzb(new AdResponseParcel(0));
            } else if (zza(zzfw, this.zzxm)) {
                zzi(zzo.zzbz().elapsedRealtime());
            }
            zzfv();
        } catch (Throwable th) {
            zzfv();
        }
    }

    protected boolean zze(long j) {
        long elapsedRealtime = 60000 - (zzo.zzbz().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzqt.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public abstract void zzfv();

    public abstract zzi zzfw();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void zzi(long r6) {
        /*
        r5 = this;
        r1 = r5.zzqt;
        monitor-enter(r1);
    L_0x0003:
        r0 = r5.zzBt;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x0010;
    L_0x0007:
        r0 = r5.zzCi;	 Catch:{ all -> 0x0023 }
        r2 = r5.zzBt;	 Catch:{ all -> 0x0023 }
        r0.zzb(r2);	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r5.zze(r6);	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0003;
    L_0x0016:
        r0 = r5.zzBt;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x0026;
    L_0x001a:
        r0 = r5.zzCi;	 Catch:{ all -> 0x0023 }
        r2 = r5.zzBt;	 Catch:{ all -> 0x0023 }
        r0.zzb(r2);	 Catch:{ all -> 0x0023 }
    L_0x0021:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000f;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
    L_0x0026:
        r0 = r5.zzCi;	 Catch:{ all -> 0x0023 }
        r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0023 }
        r3 = 0;
        r2.<init>(r3);	 Catch:{ all -> 0x0023 }
        r0.zzb(r2);	 Catch:{ all -> 0x0023 }
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.zzd.zzi(long):void");
    }
}
