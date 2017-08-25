package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;

@zzgd
public final class zzdw {
    private final Context mContext;
    private final zzef zzoq;
    private final Object zzqt = new Object();
    private final AdRequestInfoParcel zzxm;
    private final zzdy zzxn;
    private boolean zzxo = false;
    private zzeb zzxp;

    public zzdw(Context context, AdRequestInfoParcel adRequestInfoParcel, zzef com_google_android_gms_internal_zzef, zzdy com_google_android_gms_internal_zzdy) {
        this.mContext = context;
        this.zzxm = adRequestInfoParcel;
        this.zzoq = com_google_android_gms_internal_zzef;
        this.zzxn = com_google_android_gms_internal_zzdy;
    }

    public void cancel() {
        synchronized (this.zzqt) {
            this.zzxo = true;
            if (this.zzxp != null) {
                this.zzxp.cancel();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzec zza(long r18, long r20) {
        /*
        r17 = this;
        r4 = "Starting mediation.";
        com.google.android.gms.ads.internal.util.client.zzb.zzay(r4);
        r0 = r17;
        r4 = r0.zzxn;
        r4 = r4.zzxD;
        r13 = r4.iterator();
    L_0x000f:
        r4 = r13.hasNext();
        if (r4 == 0) goto L_0x00aa;
    L_0x0015:
        r9 = r13.next();
        r9 = (com.google.android.gms.internal.zzdx) r9;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Trying mediation network: ";
        r4 = r4.append(r5);
        r5 = r9.zzxt;
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.google.android.gms.ads.internal.util.client.zzb.zzaA(r4);
        r4 = r9.zzxu;
        r14 = r4.iterator();
    L_0x0039:
        r4 = r14.hasNext();
        if (r4 == 0) goto L_0x000f;
    L_0x003f:
        r6 = r14.next();
        r6 = (java.lang.String) r6;
        r0 = r17;
        r15 = r0.zzqt;
        monitor-enter(r15);
        r0 = r17;
        r4 = r0.zzxo;	 Catch:{ all -> 0x0096 }
        if (r4 == 0) goto L_0x0058;
    L_0x0050:
        r4 = new com.google.android.gms.internal.zzec;	 Catch:{ all -> 0x0096 }
        r5 = -1;
        r4.<init>(r5);	 Catch:{ all -> 0x0096 }
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
    L_0x0057:
        return r4;
    L_0x0058:
        r4 = new com.google.android.gms.internal.zzeb;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r5 = r0.mContext;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r7 = r0.zzoq;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r8 = r0.zzxn;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r10 = r0.zzxm;	 Catch:{ all -> 0x0096 }
        r10 = r10.zzCm;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r11 = r0.zzxm;	 Catch:{ all -> 0x0096 }
        r11 = r11.zzpN;	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r12 = r0.zzxm;	 Catch:{ all -> 0x0096 }
        r12 = r12.zzpJ;	 Catch:{ all -> 0x0096 }
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12);	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r0.zzxp = r4;	 Catch:{ all -> 0x0096 }
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
        r0 = r17;
        r4 = r0.zzxp;
        r0 = r18;
        r2 = r20;
        r4 = r4.zzb(r0, r2);
        r5 = r4.zzxY;
        if (r5 != 0) goto L_0x0099;
    L_0x0090:
        r5 = "Adapter succeeded.";
        com.google.android.gms.ads.internal.util.client.zzb.zzay(r5);
        goto L_0x0057;
    L_0x0096:
        r4 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x0096 }
        throw r4;
    L_0x0099:
        r5 = r4.zzya;
        if (r5 == 0) goto L_0x0039;
    L_0x009d:
        r5 = com.google.android.gms.internal.zzhl.zzGk;
        r6 = new com.google.android.gms.internal.zzdw$1;
        r0 = r17;
        r6.<init>(r0, r4);
        r5.post(r6);
        goto L_0x0039;
    L_0x00aa:
        r4 = new com.google.android.gms.internal.zzec;
        r5 = 1;
        r4.<init>(r5);
        goto L_0x0057;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdw.zza(long, long):com.google.android.gms.internal.zzec");
    }
}
