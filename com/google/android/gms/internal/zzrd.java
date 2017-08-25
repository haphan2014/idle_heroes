package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;
import java.io.IOException;

public final class zzrd extends zzrh<zzrd> {
    public String[] zzaVE;
    public int[] zzaVF;
    public byte[][] zzaVG;

    public zzrd() {
        zzBq();
    }

    public static zzrd zzx(byte[] bArr) throws zzrm {
        return (zzrd) zzrn.zza(new zzrd(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzrd)) {
            return false;
        }
        zzrd com_google_android_gms_internal_zzrd = (zzrd) o;
        return (zzrl.equals(this.zzaVE, com_google_android_gms_internal_zzrd.zzaVE) && zzrl.equals(this.zzaVF, com_google_android_gms_internal_zzrd.zzaVF) && zzrl.zza(this.zzaVG, com_google_android_gms_internal_zzrd.zzaVG)) ? zza((zzrh) com_google_android_gms_internal_zzrd) : false;
    }

    public int hashCode() {
        return ((((((zzrl.hashCode(this.zzaVE) + 527) * 31) + zzrl.hashCode(this.zzaVF)) * 31) + zzrl.zza(this.zzaVG)) * 31) + zzBI();
    }

    protected int zzB() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int zzB = super.zzB();
        if (this.zzaVE == null || this.zzaVE.length <= 0) {
            i = zzB;
        } else {
            i2 = 0;
            i3 = 0;
            for (String str : this.zzaVE) {
                if (str != null) {
                    i3++;
                    i2 += zzrg.zzfj(str);
                }
            }
            i = (zzB + i2) + (i3 * 1);
        }
        if (this.zzaVF != null && this.zzaVF.length > 0) {
            i3 = 0;
            for (int zzB2 : this.zzaVF) {
                i3 += zzrg.zzkJ(zzB2);
            }
            i = (i + i3) + (this.zzaVF.length * 1);
        }
        if (this.zzaVG == null || this.zzaVG.length <= 0) {
            return i;
        }
        i2 = 0;
        i3 = 0;
        while (i4 < this.zzaVG.length) {
            byte[] bArr = this.zzaVG[i4];
            if (bArr != null) {
                i3++;
                i2 += zzrg.zzC(bArr);
            }
            i4++;
        }
        return (i + i2) + (i3 * 1);
    }

    public zzrd zzBq() {
        this.zzaVE = zzrq.zzaWm;
        this.zzaVF = zzrq.zzaWh;
        this.zzaVG = zzrq.zzaWn;
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }

    public void zza(zzrg com_google_android_gms_internal_zzrg) throws IOException {
        int i = 0;
        if (this.zzaVE != null && this.zzaVE.length > 0) {
            for (String str : this.zzaVE) {
                if (str != null) {
                    com_google_android_gms_internal_zzrg.zzb(1, str);
                }
            }
        }
        if (this.zzaVF != null && this.zzaVF.length > 0) {
            for (int zzy : this.zzaVF) {
                com_google_android_gms_internal_zzrg.zzy(2, zzy);
            }
        }
        if (this.zzaVG != null && this.zzaVG.length > 0) {
            while (i < this.zzaVG.length) {
                byte[] bArr = this.zzaVG[i];
                if (bArr != null) {
                    com_google_android_gms_internal_zzrg.zza(3, bArr);
                }
                i++;
            }
        }
        super.zza(com_google_android_gms_internal_zzrg);
    }

    public /* synthetic */ zzrn zzb(zzrf com_google_android_gms_internal_zzrf) throws IOException {
        return zzz(com_google_android_gms_internal_zzrf);
    }

    public zzrd zzz(zzrf com_google_android_gms_internal_zzrf) throws IOException {
        while (true) {
            int zzBr = com_google_android_gms_internal_zzrf.zzBr();
            int zzb;
            Object obj;
            switch (zzBr) {
                case 0:
                    break;
                case 10:
                    zzb = zzrq.zzb(com_google_android_gms_internal_zzrf, 10);
                    zzBr = this.zzaVE == null ? 0 : this.zzaVE.length;
                    obj = new String[(zzb + zzBr)];
                    if (zzBr != 0) {
                        System.arraycopy(this.zzaVE, 0, obj, 0, zzBr);
                    }
                    while (zzBr < obj.length - 1) {
                        obj[zzBr] = com_google_android_gms_internal_zzrf.readString();
                        com_google_android_gms_internal_zzrf.zzBr();
                        zzBr++;
                    }
                    obj[zzBr] = com_google_android_gms_internal_zzrf.readString();
                    this.zzaVE = obj;
                    continue;
                case 16:
                    zzb = zzrq.zzb(com_google_android_gms_internal_zzrf, 16);
                    zzBr = this.zzaVF == null ? 0 : this.zzaVF.length;
                    obj = new int[(zzb + zzBr)];
                    if (zzBr != 0) {
                        System.arraycopy(this.zzaVF, 0, obj, 0, zzBr);
                    }
                    while (zzBr < obj.length - 1) {
                        obj[zzBr] = com_google_android_gms_internal_zzrf.zzBu();
                        com_google_android_gms_internal_zzrf.zzBr();
                        zzBr++;
                    }
                    obj[zzBr] = com_google_android_gms_internal_zzrf.zzBu();
                    this.zzaVF = obj;
                    continue;
                case 18:
                    int zzkC = com_google_android_gms_internal_zzrf.zzkC(com_google_android_gms_internal_zzrf.zzBy());
                    zzb = com_google_android_gms_internal_zzrf.getPosition();
                    zzBr = 0;
                    while (com_google_android_gms_internal_zzrf.zzBD() > 0) {
                        com_google_android_gms_internal_zzrf.zzBu();
                        zzBr++;
                    }
                    com_google_android_gms_internal_zzrf.zzkE(zzb);
                    zzb = this.zzaVF == null ? 0 : this.zzaVF.length;
                    Object obj2 = new int[(zzBr + zzb)];
                    if (zzb != 0) {
                        System.arraycopy(this.zzaVF, 0, obj2, 0, zzb);
                    }
                    while (zzb < obj2.length) {
                        obj2[zzb] = com_google_android_gms_internal_zzrf.zzBu();
                        zzb++;
                    }
                    this.zzaVF = obj2;
                    com_google_android_gms_internal_zzrf.zzkD(zzkC);
                    continue;
                case Place.TYPE_CONVENIENCE_STORE /*26*/:
                    zzb = zzrq.zzb(com_google_android_gms_internal_zzrf, 26);
                    zzBr = this.zzaVG == null ? 0 : this.zzaVG.length;
                    obj = new byte[(zzb + zzBr)][];
                    if (zzBr != 0) {
                        System.arraycopy(this.zzaVG, 0, obj, 0, zzBr);
                    }
                    while (zzBr < obj.length - 1) {
                        obj[zzBr] = com_google_android_gms_internal_zzrf.readBytes();
                        com_google_android_gms_internal_zzrf.zzBr();
                        zzBr++;
                    }
                    obj[zzBr] = com_google_android_gms_internal_zzrf.readBytes();
                    this.zzaVG = obj;
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
}
