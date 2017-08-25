package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrh;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.location.places.Place;
import java.io.IOException;

public final class zzaq extends zzrh<zzaq> {
    public int versionCode;
    public long zzafU;
    public long zzafV;
    public long zzafW;

    public zzaq() {
        zzpG();
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzaq)) {
            return false;
        }
        zzaq com_google_android_gms_drive_internal_zzaq = (zzaq) o;
        return (this.versionCode == com_google_android_gms_drive_internal_zzaq.versionCode && this.zzafU == com_google_android_gms_drive_internal_zzaq.zzafU && this.zzafV == com_google_android_gms_drive_internal_zzaq.zzafV && this.zzafW == com_google_android_gms_drive_internal_zzaq.zzafW) ? zza((zzrh) com_google_android_gms_drive_internal_zzaq) : false;
    }

    public int hashCode() {
        return ((((((((this.versionCode + 527) * 31) + ((int) (this.zzafU ^ (this.zzafU >>> 32)))) * 31) + ((int) (this.zzafV ^ (this.zzafV >>> 32)))) * 31) + ((int) (this.zzafW ^ (this.zzafW >>> 32)))) * 31) + zzBI();
    }

    protected int zzB() {
        return (((super.zzB() + zzrg.zzA(1, this.versionCode)) + zzrg.zze(2, this.zzafU)) + zzrg.zze(3, this.zzafV)) + zzrg.zze(4, this.zzafW);
    }

    public void zza(zzrg com_google_android_gms_internal_zzrg) throws IOException {
        com_google_android_gms_internal_zzrg.zzy(1, this.versionCode);
        com_google_android_gms_internal_zzrg.zzc(2, this.zzafU);
        com_google_android_gms_internal_zzrg.zzc(3, this.zzafV);
        com_google_android_gms_internal_zzrg.zzc(4, this.zzafW);
        super.zza(com_google_android_gms_internal_zzrg);
    }

    public /* synthetic */ zzrn zzb(zzrf com_google_android_gms_internal_zzrf) throws IOException {
        return zzm(com_google_android_gms_internal_zzrf);
    }

    public zzaq zzm(zzrf com_google_android_gms_internal_zzrf) throws IOException {
        while (true) {
            int zzBr = com_google_android_gms_internal_zzrf.zzBr();
            switch (zzBr) {
                case 0:
                    break;
                case 8:
                    this.versionCode = com_google_android_gms_internal_zzrf.zzBu();
                    continue;
                case 16:
                    this.zzafU = com_google_android_gms_internal_zzrf.zzBx();
                    continue;
                case Place.TYPE_CITY_HALL /*24*/:
                    this.zzafV = com_google_android_gms_internal_zzrf.zzBx();
                    continue;
                case 32:
                    this.zzafW = com_google_android_gms_internal_zzrf.zzBx();
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

    public zzaq zzpG() {
        this.versionCode = 1;
        this.zzafU = -1;
        this.zzafV = -1;
        this.zzafW = -1;
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }
}
