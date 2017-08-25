package com.google.android.gms.internal;

import com.google.android.gms.internal.zzeh.zza;

@zzgd
public final class zzea extends zza {
    private final Object zzqt = new Object();
    private zzec.zza zzxO;
    private zzdz zzxP;

    public void onAdClicked() {
        synchronized (this.zzqt) {
            if (this.zzxP != null) {
                this.zzxP.zzaX();
            }
        }
    }

    public void onAdClosed() {
        synchronized (this.zzqt) {
            if (this.zzxP != null) {
                this.zzxP.zzaY();
            }
        }
    }

    public void onAdFailedToLoad(int error) {
        synchronized (this.zzqt) {
            if (this.zzxO != null) {
                this.zzxO.zzs(error == 3 ? 1 : 2);
                this.zzxO = null;
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.zzqt) {
            if (this.zzxP != null) {
                this.zzxP.zzaZ();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdLoaded() {
        /*
        r3 = this;
        r1 = r3.zzqt;
        monitor-enter(r1);
        r0 = r3.zzxO;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0012;
    L_0x0007:
        r0 = r3.zzxO;	 Catch:{ all -> 0x001d }
        r2 = 0;
        r0.zzs(r2);	 Catch:{ all -> 0x001d }
        r0 = 0;
        r3.zzxO = r0;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0011:
        return;
    L_0x0012:
        r0 = r3.zzxP;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001b;
    L_0x0016:
        r0 = r3.zzxP;	 Catch:{ all -> 0x001d }
        r0.zzbb();	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        goto L_0x0011;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzea.onAdLoaded():void");
    }

    public void onAdOpened() {
        synchronized (this.zzqt) {
            if (this.zzxP != null) {
                this.zzxP.zzba();
            }
        }
    }

    public void zza(zzdz com_google_android_gms_internal_zzdz) {
        synchronized (this.zzqt) {
            this.zzxP = com_google_android_gms_internal_zzdz;
        }
    }

    public void zza(zzec.zza com_google_android_gms_internal_zzec_zza) {
        synchronized (this.zzqt) {
            this.zzxO = com_google_android_gms_internal_zzec_zza;
        }
    }
}
