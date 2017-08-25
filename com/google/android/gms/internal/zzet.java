package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzes.zza;

@zzgd
public class zzet extends zzeu {
    private final Context mContext;
    private final zzid zzoA;
    private final WindowManager zzqF;
    private final zzbq zzyT;
    DisplayMetrics zzyU;
    private float zzyV;
    int zzyW = -1;
    int zzyX = -1;
    private int zzyY;
    int zzyZ = -1;
    int zzza = -1;
    int zzzb = -1;
    int zzzc = -1;

    public zzet(zzid com_google_android_gms_internal_zzid, Context context, zzbq com_google_android_gms_internal_zzbq) {
        super(com_google_android_gms_internal_zzid);
        this.zzoA = com_google_android_gms_internal_zzid;
        this.mContext = context;
        this.zzyT = com_google_android_gms_internal_zzbq;
        this.zzqF = (WindowManager) context.getSystemService("window");
    }

    private void zzeh() {
        this.zzyU = new DisplayMetrics();
        Display defaultDisplay = this.zzqF.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzyU);
        this.zzyV = this.zzyU.density;
        this.zzyY = defaultDisplay.getRotation();
    }

    private void zzem() {
        int[] iArr = new int[2];
        this.zzoA.getLocationOnScreen(iArr);
        zze(zzk.zzcA().zzc(this.mContext, iArr[0]), zzk.zzcA().zzc(this.mContext, iArr[1]));
    }

    private zzes zzep() {
        return new zza().zzp(this.zzyT.zzcQ()).zzo(this.zzyT.zzcR()).zzq(this.zzyT.zzcV()).zzr(this.zzyT.zzcS()).zzs(this.zzyT.zzcT()).zzeg();
    }

    public void zze(int i, int i2) {
        zzc(i, i2 - (this.mContext instanceof Activity ? zzo.zzbv().zzj((Activity) this.mContext)[0] : 0), this.zzzb, this.zzzc);
        this.zzoA.zzgF().zzd(i, i2);
    }

    void zzei() {
        this.zzyW = zzk.zzcA().zzb(this.zzyU, this.zzyU.widthPixels);
        this.zzyX = zzk.zzcA().zzb(this.zzyU, this.zzyU.heightPixels);
        Activity zzgB = this.zzoA.zzgB();
        if (zzgB == null || zzgB.getWindow() == null) {
            this.zzyZ = this.zzyW;
            this.zzza = this.zzyX;
            return;
        }
        int[] zzg = zzo.zzbv().zzg(zzgB);
        this.zzyZ = zzk.zzcA().zzb(this.zzyU, zzg[0]);
        this.zzza = zzk.zzcA().zzb(this.zzyU, zzg[1]);
    }

    void zzej() {
        if (this.zzoA.zzaN().zzsn) {
            this.zzzb = this.zzyW;
            this.zzzc = this.zzyX;
            return;
        }
        this.zzoA.measure(0, 0);
        this.zzzb = zzk.zzcA().zzc(this.mContext, this.zzoA.getMeasuredWidth());
        this.zzzc = zzk.zzcA().zzc(this.mContext, this.zzoA.getMeasuredHeight());
    }

    public void zzek() {
        zzeh();
        zzei();
        zzej();
        zzen();
        zzeo();
        zzem();
        zzel();
    }

    void zzel() {
        if (zzb.zzL(2)) {
            zzb.zzaA("Dispatching Ready Event.");
        }
        zzaf(this.zzoA.zzgI().zzGG);
    }

    void zzen() {
        zza(this.zzyW, this.zzyX, this.zzyZ, this.zzza, this.zzyV, this.zzyY);
    }

    void zzeo() {
        this.zzoA.zzb("onDeviceFeaturesReceived", zzep().toJson());
    }
}
