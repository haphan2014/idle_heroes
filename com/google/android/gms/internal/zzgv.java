package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzha.zza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.Future;

@zzgd
public class zzgv extends zzhh implements zzgu {
    private final Context mContext;
    private final zza zzBs;
    private final String zzEO;
    private final ArrayList<Future> zzFe = new ArrayList();
    private final ArrayList<String> zzFf = new ArrayList();
    private final HashSet<String> zzFg = new HashSet();
    private final zzgo zzFh;
    private final Object zzqt = new Object();

    public zzgv(Context context, String str, zza com_google_android_gms_internal_zzha_zza, zzgo com_google_android_gms_internal_zzgo) {
        this.mContext = context;
        this.zzEO = str;
        this.zzBs = com_google_android_gms_internal_zzha_zza;
        this.zzFh = com_google_android_gms_internal_zzgo;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzj(java.lang.String r10, java.lang.String r11) {
        /*
        r9 = this;
        r8 = r9.zzqt;
        monitor-enter(r8);
        r0 = r9.zzFh;	 Catch:{ all -> 0x0037 }
        r6 = r0.zzao(r10);	 Catch:{ all -> 0x0037 }
        if (r6 == 0) goto L_0x0017;
    L_0x000b:
        r0 = r6.zzfN();	 Catch:{ all -> 0x0037 }
        if (r0 == 0) goto L_0x0017;
    L_0x0011:
        r0 = r6.zzfM();	 Catch:{ all -> 0x0037 }
        if (r0 != 0) goto L_0x0019;
    L_0x0017:
        monitor-exit(r8);	 Catch:{ all -> 0x0037 }
    L_0x0018:
        return;
    L_0x0019:
        r0 = new com.google.android.gms.internal.zzgq;	 Catch:{ all -> 0x0037 }
        r1 = r9.mContext;	 Catch:{ all -> 0x0037 }
        r3 = r9.zzEO;	 Catch:{ all -> 0x0037 }
        r5 = r9.zzBs;	 Catch:{ all -> 0x0037 }
        r2 = r10;
        r4 = r11;
        r7 = r9;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0037 }
        r1 = r9.zzFe;	 Catch:{ all -> 0x0037 }
        r0 = r0.zzgi();	 Catch:{ all -> 0x0037 }
        r1.add(r0);	 Catch:{ all -> 0x0037 }
        r0 = r9.zzFf;	 Catch:{ all -> 0x0037 }
        r0.add(r10);	 Catch:{ all -> 0x0037 }
        monitor-exit(r8);	 Catch:{ all -> 0x0037 }
        goto L_0x0018;
    L_0x0037:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0037 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgv.zzj(java.lang.String, java.lang.String):void");
    }

    public void onStop() {
    }

    public void zzap(String str) {
        synchronized (this.zzqt) {
            this.zzFg.add(str);
        }
    }

    public void zzb(String str, int i) {
    }

    public void zzdP() {
        final zzha com_google_android_gms_internal_zzha;
        for (zzdx com_google_android_gms_internal_zzdx : this.zzBs.zzFm.zzxD) {
            String str = com_google_android_gms_internal_zzdx.zzxz;
            for (String zzj : com_google_android_gms_internal_zzdx.zzxu) {
                zzj(zzj, str);
            }
        }
        int i = 0;
        while (i < this.zzFe.size()) {
            try {
                ((Future) this.zzFe.get(i)).get();
                synchronized (this.zzqt) {
                    if (this.zzFg.contains(this.zzFf.get(i))) {
                        com_google_android_gms_internal_zzha = new zzha(this.zzBs.zzFr.zzCm, null, this.zzBs.zzFs.zzxF, -2, this.zzBs.zzFs.zzxG, this.zzBs.zzFs.zzCM, this.zzBs.zzFs.orientation, this.zzBs.zzFs.zzxJ, this.zzBs.zzFr.zzCp, this.zzBs.zzFs.zzCK, (zzdx) this.zzBs.zzFm.zzxD.get(i), null, (String) this.zzFf.get(i), this.zzBs.zzFm, null, this.zzBs.zzFs.zzCL, this.zzBs.zzpN, this.zzBs.zzFs.zzCJ, this.zzBs.zzFo, this.zzBs.zzFs.zzCO, this.zzBs.zzFs.zzCP, this.zzBs.zzFl, null, this.zzBs.zzFr.zzCC);
                        com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable(this) {
                            final /* synthetic */ zzgv zzFi;

                            public void run() {
                                this.zzFi.zzFh.zzb(com_google_android_gms_internal_zzha);
                            }
                        });
                        return;
                    }
                }
            } catch (InterruptedException e) {
            } catch (Exception e2) {
            }
        }
        com_google_android_gms_internal_zzha = new zzha(this.zzBs.zzFr.zzCm, null, this.zzBs.zzFs.zzxF, 3, this.zzBs.zzFs.zzxG, this.zzBs.zzFs.zzCM, this.zzBs.zzFs.orientation, this.zzBs.zzFs.zzxJ, this.zzBs.zzFr.zzCp, this.zzBs.zzFs.zzCK, null, null, null, this.zzBs.zzFm, null, this.zzBs.zzFs.zzCL, this.zzBs.zzpN, this.zzBs.zzFs.zzCJ, this.zzBs.zzFo, this.zzBs.zzFs.zzCO, this.zzBs.zzFs.zzCP, this.zzBs.zzFl, null, this.zzBs.zzFr.zzCC);
        com.google.android.gms.ads.internal.util.client.zza.zzGF.post(new Runnable(this) {
            final /* synthetic */ zzgv zzFi;

            public void run() {
                this.zzFi.zzFh.zzb(com_google_android_gms_internal_zzha);
            }
        });
        return;
        i++;
    }
}
