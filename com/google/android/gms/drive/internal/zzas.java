package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrh;
import com.google.android.gms.internal.zzrn;
import java.io.IOException;

public final class zzas extends zzrh<zzas> {
    public long zzafV;
    public long zzafY;

    public zzas() {
        zzpI();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzas)) {
            return false;
        }
        zzas com_google_android_gms_drive_internal_zzas = (zzas) o;
        return (this.zzafY == com_google_android_gms_drive_internal_zzas.zzafY && this.zzafV == com_google_android_gms_drive_internal_zzas.zzafV) ? zza((zzrh) com_google_android_gms_drive_internal_zzas) : false;
    }

    public int hashCode() {
        return ((((((int) (this.zzafY ^ (this.zzafY >>> 32))) + 527) * 31) + ((int) (this.zzafV ^ (this.zzafV >>> 32)))) * 31) + zzBI();
    }

    protected int zzB() {
        return (super.zzB() + zzrg.zze(1, this.zzafY)) + zzrg.zze(2, this.zzafV);
    }

    public void zza(zzrg com_google_android_gms_internal_zzrg) throws IOException {
        com_google_android_gms_internal_zzrg.zzc(1, this.zzafY);
        com_google_android_gms_internal_zzrg.zzc(2, this.zzafV);
        super.zza(com_google_android_gms_internal_zzrg);
    }

    public /* synthetic */ zzrn zzb(zzrf com_google_android_gms_internal_zzrf) throws IOException {
        return zzo(com_google_android_gms_internal_zzrf);
    }

    public zzas zzo(zzrf com_google_android_gms_internal_zzrf) throws IOException {
        while (true) {
            int zzBr = com_google_android_gms_internal_zzrf.zzBr();
            switch (zzBr) {
                case 0:
                    break;
                case 8:
                    this.zzafY = com_google_android_gms_internal_zzrf.zzBx();
                    continue;
                case 16:
                    this.zzafV = com_google_android_gms_internal_zzrf.zzBx();
                    continue;
                default:
                    if (!zza(com_google_android_gms_internal_zzrf, zzBr)) {
                        break;
                    }
                    continue;
            }
            return this;
        }
    }

    public zzas zzpI() {
        this.zzafY = -1;
        this.zzafV = -1;
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }
}
