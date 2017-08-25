package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.zzrf;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrh;
import com.google.android.gms.internal.zzrm;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.location.places.Place;
import java.io.IOException;

public final class zzar extends zzrh<zzar> {
    public int versionCode;
    public long zzafV;
    public String zzafX;
    public long zzafY;
    public int zzafZ;

    public zzar() {
        zzpH();
    }

    public static zzar zzl(byte[] bArr) throws zzrm {
        return (zzar) zzrn.zza(new zzar(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzar)) {
            return false;
        }
        zzar com_google_android_gms_drive_internal_zzar = (zzar) o;
        if (this.versionCode != com_google_android_gms_drive_internal_zzar.versionCode) {
            return false;
        }
        if (this.zzafX == null) {
            if (com_google_android_gms_drive_internal_zzar.zzafX != null) {
                return false;
            }
        } else if (!this.zzafX.equals(com_google_android_gms_drive_internal_zzar.zzafX)) {
            return false;
        }
        return (this.zzafY == com_google_android_gms_drive_internal_zzar.zzafY && this.zzafV == com_google_android_gms_drive_internal_zzar.zzafV && this.zzafZ == com_google_android_gms_drive_internal_zzar.zzafZ) ? zza((zzrh) com_google_android_gms_drive_internal_zzar) : false;
    }

    public int hashCode() {
        return (((((((((this.zzafX == null ? 0 : this.zzafX.hashCode()) + ((this.versionCode + 527) * 31)) * 31) + ((int) (this.zzafY ^ (this.zzafY >>> 32)))) * 31) + ((int) (this.zzafV ^ (this.zzafV >>> 32)))) * 31) + this.zzafZ) * 31) + zzBI();
    }

    protected int zzB() {
        int zzB = (((super.zzB() + zzrg.zzA(1, this.versionCode)) + zzrg.zzk(2, this.zzafX)) + zzrg.zze(3, this.zzafY)) + zzrg.zze(4, this.zzafV);
        return this.zzafZ != -1 ? zzB + zzrg.zzA(5, this.zzafZ) : zzB;
    }

    public void zza(zzrg com_google_android_gms_internal_zzrg) throws IOException {
        com_google_android_gms_internal_zzrg.zzy(1, this.versionCode);
        com_google_android_gms_internal_zzrg.zzb(2, this.zzafX);
        com_google_android_gms_internal_zzrg.zzc(3, this.zzafY);
        com_google_android_gms_internal_zzrg.zzc(4, this.zzafV);
        if (this.zzafZ != -1) {
            com_google_android_gms_internal_zzrg.zzy(5, this.zzafZ);
        }
        super.zza(com_google_android_gms_internal_zzrg);
    }

    public /* synthetic */ zzrn zzb(zzrf com_google_android_gms_internal_zzrf) throws IOException {
        return zzn(com_google_android_gms_internal_zzrf);
    }

    public zzar zzn(zzrf com_google_android_gms_internal_zzrf) throws IOException {
        while (true) {
            int zzBr = com_google_android_gms_internal_zzrf.zzBr();
            switch (zzBr) {
                case 0:
                    break;
                case 8:
                    this.versionCode = com_google_android_gms_internal_zzrf.zzBu();
                    continue;
                case 18:
                    this.zzafX = com_google_android_gms_internal_zzrf.readString();
                    continue;
                case Place.TYPE_CITY_HALL /*24*/:
                    this.zzafY = com_google_android_gms_internal_zzrf.zzBx();
                    continue;
                case 32:
                    this.zzafV = com_google_android_gms_internal_zzrf.zzBx();
                    continue;
                case 40:
                    this.zzafZ = com_google_android_gms_internal_zzrf.zzBu();
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

    public zzar zzpH() {
        this.versionCode = 1;
        this.zzafX = "";
        this.zzafY = -1;
        this.zzafV = -1;
        this.zzafZ = -1;
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }
}
