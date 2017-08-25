package com.google.android.gms.internal;

import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.places.Place;
import java.io.IOException;
import java.util.Arrays;

public final class zzrc extends zzrh<zzrc> {
    public zza[] zzaVl;

    public static final class zza extends zzrh<zza> {
        private static volatile zza[] zzaVm;
        public String name;
        public zza zzaVn;

        public static final class zza extends zzrh<zza> {
            private static volatile zza[] zzaVo;
            public int type;
            public zza zzaVp;

            public static final class zza extends zzrh<zza> {
                public String[] zzaVA;
                public long[] zzaVB;
                public float[] zzaVC;
                public long zzaVD;
                public byte[] zzaVq;
                public String zzaVr;
                public double zzaVs;
                public float zzaVt;
                public long zzaVu;
                public int zzaVv;
                public int zzaVw;
                public boolean zzaVx;
                public zza[] zzaVy;
                public zza[] zzaVz;

                public zza() {
                    zzBp();
                }

                public boolean equals(Object o) {
                    if (o == this) {
                        return true;
                    }
                    if (!(o instanceof zza)) {
                        return false;
                    }
                    zza com_google_android_gms_internal_zzrc_zza_zza_zza = (zza) o;
                    if (!Arrays.equals(this.zzaVq, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVq)) {
                        return false;
                    }
                    if (this.zzaVr == null) {
                        if (com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVr != null) {
                            return false;
                        }
                    } else if (!this.zzaVr.equals(com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVr)) {
                        return false;
                    }
                    return (Double.doubleToLongBits(this.zzaVs) == Double.doubleToLongBits(com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVs) && Float.floatToIntBits(this.zzaVt) == Float.floatToIntBits(com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVt) && this.zzaVu == com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVu && this.zzaVv == com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVv && this.zzaVw == com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVw && this.zzaVx == com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVx && zzrl.equals(this.zzaVy, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVy) && zzrl.equals(this.zzaVz, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVz) && zzrl.equals(this.zzaVA, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVA) && zzrl.equals(this.zzaVB, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVB) && zzrl.equals(this.zzaVC, com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVC) && this.zzaVD == com_google_android_gms_internal_zzrc_zza_zza_zza.zzaVD) ? zza((zzrh) com_google_android_gms_internal_zzrc_zza_zza_zza) : false;
                }

                public int hashCode() {
                    int hashCode = (this.zzaVr == null ? 0 : this.zzaVr.hashCode()) + ((Arrays.hashCode(this.zzaVq) + 527) * 31);
                    long doubleToLongBits = Double.doubleToLongBits(this.zzaVs);
                    return (((((((((((((((this.zzaVx ? 1231 : 1237) + (((((((((((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + Float.floatToIntBits(this.zzaVt)) * 31) + ((int) (this.zzaVu ^ (this.zzaVu >>> 32)))) * 31) + this.zzaVv) * 31) + this.zzaVw) * 31)) * 31) + zzrl.hashCode(this.zzaVy)) * 31) + zzrl.hashCode(this.zzaVz)) * 31) + zzrl.hashCode(this.zzaVA)) * 31) + zzrl.hashCode(this.zzaVB)) * 31) + zzrl.hashCode(this.zzaVC)) * 31) + ((int) (this.zzaVD ^ (this.zzaVD >>> 32)))) * 31) + zzBI();
                }

                protected int zzB() {
                    int i;
                    int i2 = 0;
                    int zzB = super.zzB();
                    if (!Arrays.equals(this.zzaVq, zzrq.zzaWo)) {
                        zzB += zzrg.zzb(1, this.zzaVq);
                    }
                    if (!this.zzaVr.equals("")) {
                        zzB += zzrg.zzk(2, this.zzaVr);
                    }
                    if (Double.doubleToLongBits(this.zzaVs) != Double.doubleToLongBits(0.0d)) {
                        zzB += zzrg.zzb(3, this.zzaVs);
                    }
                    if (Float.floatToIntBits(this.zzaVt) != Float.floatToIntBits(0.0f)) {
                        zzB += zzrg.zzc(4, this.zzaVt);
                    }
                    if (this.zzaVu != 0) {
                        zzB += zzrg.zzd(5, this.zzaVu);
                    }
                    if (this.zzaVv != 0) {
                        zzB += zzrg.zzA(6, this.zzaVv);
                    }
                    if (this.zzaVw != 0) {
                        zzB += zzrg.zzB(7, this.zzaVw);
                    }
                    if (this.zzaVx) {
                        zzB += zzrg.zzc(8, this.zzaVx);
                    }
                    if (this.zzaVy != null && this.zzaVy.length > 0) {
                        i = zzB;
                        for (zzrn com_google_android_gms_internal_zzrn : this.zzaVy) {
                            if (com_google_android_gms_internal_zzrn != null) {
                                i += zzrg.zzc(9, com_google_android_gms_internal_zzrn);
                            }
                        }
                        zzB = i;
                    }
                    if (this.zzaVz != null && this.zzaVz.length > 0) {
                        i = zzB;
                        for (zzrn com_google_android_gms_internal_zzrn2 : this.zzaVz) {
                            if (com_google_android_gms_internal_zzrn2 != null) {
                                i += zzrg.zzc(10, com_google_android_gms_internal_zzrn2);
                            }
                        }
                        zzB = i;
                    }
                    if (this.zzaVA != null && this.zzaVA.length > 0) {
                        int i3 = 0;
                        int i4 = 0;
                        for (String str : this.zzaVA) {
                            if (str != null) {
                                i4++;
                                i3 += zzrg.zzfj(str);
                            }
                        }
                        zzB = (zzB + i3) + (i4 * 1);
                    }
                    if (this.zzaVB != null && this.zzaVB.length > 0) {
                        i = 0;
                        while (i2 < this.zzaVB.length) {
                            i += zzrg.zzY(this.zzaVB[i2]);
                            i2++;
                        }
                        zzB = (zzB + i) + (this.zzaVB.length * 1);
                    }
                    if (this.zzaVD != 0) {
                        zzB += zzrg.zzd(13, this.zzaVD);
                    }
                    return (this.zzaVC == null || this.zzaVC.length <= 0) ? zzB : (zzB + (this.zzaVC.length * 4)) + (this.zzaVC.length * 1);
                }

                public zza zzBp() {
                    this.zzaVq = zzrq.zzaWo;
                    this.zzaVr = "";
                    this.zzaVs = 0.0d;
                    this.zzaVt = 0.0f;
                    this.zzaVu = 0;
                    this.zzaVv = 0;
                    this.zzaVw = 0;
                    this.zzaVx = false;
                    this.zzaVy = zza.zzBl();
                    this.zzaVz = zza.zzBn();
                    this.zzaVA = zzrq.zzaWm;
                    this.zzaVB = zzrq.zzaWi;
                    this.zzaVC = zzrq.zzaWj;
                    this.zzaVD = 0;
                    this.zzaVU = null;
                    this.zzaWf = -1;
                    return this;
                }

                public void zza(zzrg com_google_android_gms_internal_zzrg) throws IOException {
                    int i = 0;
                    if (!Arrays.equals(this.zzaVq, zzrq.zzaWo)) {
                        com_google_android_gms_internal_zzrg.zza(1, this.zzaVq);
                    }
                    if (!this.zzaVr.equals("")) {
                        com_google_android_gms_internal_zzrg.zzb(2, this.zzaVr);
                    }
                    if (Double.doubleToLongBits(this.zzaVs) != Double.doubleToLongBits(0.0d)) {
                        com_google_android_gms_internal_zzrg.zza(3, this.zzaVs);
                    }
                    if (Float.floatToIntBits(this.zzaVt) != Float.floatToIntBits(0.0f)) {
                        com_google_android_gms_internal_zzrg.zzb(4, this.zzaVt);
                    }
                    if (this.zzaVu != 0) {
                        com_google_android_gms_internal_zzrg.zzb(5, this.zzaVu);
                    }
                    if (this.zzaVv != 0) {
                        com_google_android_gms_internal_zzrg.zzy(6, this.zzaVv);
                    }
                    if (this.zzaVw != 0) {
                        com_google_android_gms_internal_zzrg.zzz(7, this.zzaVw);
                    }
                    if (this.zzaVx) {
                        com_google_android_gms_internal_zzrg.zzb(8, this.zzaVx);
                    }
                    if (this.zzaVy != null && this.zzaVy.length > 0) {
                        for (zzrn com_google_android_gms_internal_zzrn : this.zzaVy) {
                            if (com_google_android_gms_internal_zzrn != null) {
                                com_google_android_gms_internal_zzrg.zza(9, com_google_android_gms_internal_zzrn);
                            }
                        }
                    }
                    if (this.zzaVz != null && this.zzaVz.length > 0) {
                        for (zzrn com_google_android_gms_internal_zzrn2 : this.zzaVz) {
                            if (com_google_android_gms_internal_zzrn2 != null) {
                                com_google_android_gms_internal_zzrg.zza(10, com_google_android_gms_internal_zzrn2);
                            }
                        }
                    }
                    if (this.zzaVA != null && this.zzaVA.length > 0) {
                        for (String str : this.zzaVA) {
                            if (str != null) {
                                com_google_android_gms_internal_zzrg.zzb(11, str);
                            }
                        }
                    }
                    if (this.zzaVB != null && this.zzaVB.length > 0) {
                        for (long zzb : this.zzaVB) {
                            com_google_android_gms_internal_zzrg.zzb(12, zzb);
                        }
                    }
                    if (this.zzaVD != 0) {
                        com_google_android_gms_internal_zzrg.zzb(13, this.zzaVD);
                    }
                    if (this.zzaVC != null && this.zzaVC.length > 0) {
                        while (i < this.zzaVC.length) {
                            com_google_android_gms_internal_zzrg.zzb(14, this.zzaVC[i]);
                            i++;
                        }
                    }
                    super.zza(com_google_android_gms_internal_zzrg);
                }

                public /* synthetic */ zzrn zzb(zzrf com_google_android_gms_internal_zzrf) throws IOException {
                    return zzy(com_google_android_gms_internal_zzrf);
                }

                public zza zzy(zzrf com_google_android_gms_internal_zzrf) throws IOException {
                    while (true) {
                        int zzBr = com_google_android_gms_internal_zzrf.zzBr();
                        int zzb;
                        Object obj;
                        int zzkC;
                        switch (zzBr) {
                            case 0:
                                break;
                            case 10:
                                this.zzaVq = com_google_android_gms_internal_zzrf.readBytes();
                                continue;
                            case 18:
                                this.zzaVr = com_google_android_gms_internal_zzrf.readString();
                                continue;
                            case Place.TYPE_CLOTHING_STORE /*25*/:
                                this.zzaVs = com_google_android_gms_internal_zzrf.readDouble();
                                continue;
                            case Place.TYPE_FLORIST /*37*/:
                                this.zzaVt = com_google_android_gms_internal_zzrf.readFloat();
                                continue;
                            case 40:
                                this.zzaVu = com_google_android_gms_internal_zzrf.zzBt();
                                continue;
                            case Place.TYPE_HINDU_TEMPLE /*48*/:
                                this.zzaVv = com_google_android_gms_internal_zzrf.zzBu();
                                continue;
                            case Place.TYPE_LIQUOR_STORE /*56*/:
                                this.zzaVw = com_google_android_gms_internal_zzrf.zzBw();
                                continue;
                            case 64:
                                this.zzaVx = com_google_android_gms_internal_zzrf.zzBv();
                                continue;
                            case Place.TYPE_PLACE_OF_WORSHIP /*74*/:
                                zzb = zzrq.zzb(com_google_android_gms_internal_zzrf, 74);
                                zzBr = this.zzaVy == null ? 0 : this.zzaVy.length;
                                obj = new zza[(zzb + zzBr)];
                                if (zzBr != 0) {
                                    System.arraycopy(this.zzaVy, 0, obj, 0, zzBr);
                                }
                                while (zzBr < obj.length - 1) {
                                    obj[zzBr] = new zza();
                                    com_google_android_gms_internal_zzrf.zza(obj[zzBr]);
                                    com_google_android_gms_internal_zzrf.zzBr();
                                    zzBr++;
                                }
                                obj[zzBr] = new zza();
                                com_google_android_gms_internal_zzrf.zza(obj[zzBr]);
                                this.zzaVy = obj;
                                continue;
                            case Place.TYPE_SCHOOL /*82*/:
                                zzb = zzrq.zzb(com_google_android_gms_internal_zzrf, 82);
                                zzBr = this.zzaVz == null ? 0 : this.zzaVz.length;
                                obj = new zza[(zzb + zzBr)];
                                if (zzBr != 0) {
                                    System.arraycopy(this.zzaVz, 0, obj, 0, zzBr);
                                }
                                while (zzBr < obj.length - 1) {
                                    obj[zzBr] = new zza();
                                    com_google_android_gms_internal_zzrf.zza(obj[zzBr]);
                                    com_google_android_gms_internal_zzrf.zzBr();
                                    zzBr++;
                                }
                                obj[zzBr] = new zza();
                                com_google_android_gms_internal_zzrf.zza(obj[zzBr]);
                                this.zzaVz = obj;
                                continue;
                            case 90:
                                zzb = zzrq.zzb(com_google_android_gms_internal_zzrf, 90);
                                zzBr = this.zzaVA == null ? 0 : this.zzaVA.length;
                                obj = new String[(zzb + zzBr)];
                                if (zzBr != 0) {
                                    System.arraycopy(this.zzaVA, 0, obj, 0, zzBr);
                                }
                                while (zzBr < obj.length - 1) {
                                    obj[zzBr] = com_google_android_gms_internal_zzrf.readString();
                                    com_google_android_gms_internal_zzrf.zzBr();
                                    zzBr++;
                                }
                                obj[zzBr] = com_google_android_gms_internal_zzrf.readString();
                                this.zzaVA = obj;
                                continue;
                            case Place.TYPE_ZOO /*96*/:
                                zzb = zzrq.zzb(com_google_android_gms_internal_zzrf, 96);
                                zzBr = this.zzaVB == null ? 0 : this.zzaVB.length;
                                obj = new long[(zzb + zzBr)];
                                if (zzBr != 0) {
                                    System.arraycopy(this.zzaVB, 0, obj, 0, zzBr);
                                }
                                while (zzBr < obj.length - 1) {
                                    obj[zzBr] = com_google_android_gms_internal_zzrf.zzBt();
                                    com_google_android_gms_internal_zzrf.zzBr();
                                    zzBr++;
                                }
                                obj[zzBr] = com_google_android_gms_internal_zzrf.zzBt();
                                this.zzaVB = obj;
                                continue;
                            case 98:
                                zzkC = com_google_android_gms_internal_zzrf.zzkC(com_google_android_gms_internal_zzrf.zzBy());
                                zzb = com_google_android_gms_internal_zzrf.getPosition();
                                zzBr = 0;
                                while (com_google_android_gms_internal_zzrf.zzBD() > 0) {
                                    com_google_android_gms_internal_zzrf.zzBt();
                                    zzBr++;
                                }
                                com_google_android_gms_internal_zzrf.zzkE(zzb);
                                zzb = this.zzaVB == null ? 0 : this.zzaVB.length;
                                Object obj2 = new long[(zzBr + zzb)];
                                if (zzb != 0) {
                                    System.arraycopy(this.zzaVB, 0, obj2, 0, zzb);
                                }
                                while (zzb < obj2.length) {
                                    obj2[zzb] = com_google_android_gms_internal_zzrf.zzBt();
                                    zzb++;
                                }
                                this.zzaVB = obj2;
                                com_google_android_gms_internal_zzrf.zzkD(zzkC);
                                continue;
                            case LocationRequest.PRIORITY_LOW_POWER /*104*/:
                                this.zzaVD = com_google_android_gms_internal_zzrf.zzBt();
                                continue;
                            case 114:
                                zzBr = com_google_android_gms_internal_zzrf.zzBy();
                                zzb = com_google_android_gms_internal_zzrf.zzkC(zzBr);
                                zzkC = zzBr / 4;
                                zzBr = this.zzaVC == null ? 0 : this.zzaVC.length;
                                Object obj3 = new float[(zzkC + zzBr)];
                                if (zzBr != 0) {
                                    System.arraycopy(this.zzaVC, 0, obj3, 0, zzBr);
                                }
                                while (zzBr < obj3.length) {
                                    obj3[zzBr] = com_google_android_gms_internal_zzrf.readFloat();
                                    zzBr++;
                                }
                                this.zzaVC = obj3;
                                com_google_android_gms_internal_zzrf.zzkD(zzb);
                                continue;
                            case 117:
                                zzb = zzrq.zzb(com_google_android_gms_internal_zzrf, 117);
                                zzBr = this.zzaVC == null ? 0 : this.zzaVC.length;
                                obj = new float[(zzb + zzBr)];
                                if (zzBr != 0) {
                                    System.arraycopy(this.zzaVC, 0, obj, 0, zzBr);
                                }
                                while (zzBr < obj.length - 1) {
                                    obj[zzBr] = com_google_android_gms_internal_zzrf.readFloat();
                                    com_google_android_gms_internal_zzrf.zzBr();
                                    zzBr++;
                                }
                                obj[zzBr] = com_google_android_gms_internal_zzrf.readFloat();
                                this.zzaVC = obj;
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

            public zza() {
                zzBo();
            }

            public static zza[] zzBn() {
                if (zzaVo == null) {
                    synchronized (zzrl.zzaWe) {
                        if (zzaVo == null) {
                            zzaVo = new zza[0];
                        }
                    }
                }
                return zzaVo;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof zza)) {
                    return false;
                }
                zza com_google_android_gms_internal_zzrc_zza_zza = (zza) o;
                if (this.type != com_google_android_gms_internal_zzrc_zza_zza.type) {
                    return false;
                }
                if (this.zzaVp == null) {
                    if (com_google_android_gms_internal_zzrc_zza_zza.zzaVp != null) {
                        return false;
                    }
                } else if (!this.zzaVp.equals(com_google_android_gms_internal_zzrc_zza_zza.zzaVp)) {
                    return false;
                }
                return zza((zzrh) com_google_android_gms_internal_zzrc_zza_zza);
            }

            public int hashCode() {
                return (((this.zzaVp == null ? 0 : this.zzaVp.hashCode()) + ((this.type + 527) * 31)) * 31) + zzBI();
            }

            protected int zzB() {
                int zzB = super.zzB() + zzrg.zzA(1, this.type);
                return this.zzaVp != null ? zzB + zzrg.zzc(2, this.zzaVp) : zzB;
            }

            public zza zzBo() {
                this.type = 1;
                this.zzaVp = null;
                this.zzaVU = null;
                this.zzaWf = -1;
                return this;
            }

            public void zza(zzrg com_google_android_gms_internal_zzrg) throws IOException {
                com_google_android_gms_internal_zzrg.zzy(1, this.type);
                if (this.zzaVp != null) {
                    com_google_android_gms_internal_zzrg.zza(2, this.zzaVp);
                }
                super.zza(com_google_android_gms_internal_zzrg);
            }

            public /* synthetic */ zzrn zzb(zzrf com_google_android_gms_internal_zzrf) throws IOException {
                return zzx(com_google_android_gms_internal_zzrf);
            }

            public zza zzx(zzrf com_google_android_gms_internal_zzrf) throws IOException {
                while (true) {
                    int zzBr = com_google_android_gms_internal_zzrf.zzBr();
                    switch (zzBr) {
                        case 0:
                            break;
                        case 8:
                            zzBr = com_google_android_gms_internal_zzrf.zzBu();
                            switch (zzBr) {
                                case 1:
                                case 2:
                                case 3:
                                case 4:
                                case 5:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                    this.type = zzBr;
                                    break;
                                default:
                                    continue;
                            }
                        case 18:
                            if (this.zzaVp == null) {
                                this.zzaVp = new zza();
                            }
                            com_google_android_gms_internal_zzrf.zza(this.zzaVp);
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

        public zza() {
            zzBm();
        }

        public static zza[] zzBl() {
            if (zzaVm == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzaVm == null) {
                        zzaVm = new zza[0];
                    }
                }
            }
            return zzaVm;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zzrc_zza = (zza) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zzrc_zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zzrc_zza.name)) {
                return false;
            }
            if (this.zzaVn == null) {
                if (com_google_android_gms_internal_zzrc_zza.zzaVn != null) {
                    return false;
                }
            } else if (!this.zzaVn.equals(com_google_android_gms_internal_zzrc_zza.zzaVn)) {
                return false;
            }
            return zza((zzrh) com_google_android_gms_internal_zzrc_zza);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.zzaVn != null) {
                i = this.zzaVn.hashCode();
            }
            return ((hashCode + i) * 31) + zzBI();
        }

        protected int zzB() {
            int zzB = super.zzB() + zzrg.zzk(1, this.name);
            return this.zzaVn != null ? zzB + zzrg.zzc(2, this.zzaVn) : zzB;
        }

        public zza zzBm() {
            this.name = "";
            this.zzaVn = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }

        public void zza(zzrg com_google_android_gms_internal_zzrg) throws IOException {
            com_google_android_gms_internal_zzrg.zzb(1, this.name);
            if (this.zzaVn != null) {
                com_google_android_gms_internal_zzrg.zza(2, this.zzaVn);
            }
            super.zza(com_google_android_gms_internal_zzrg);
        }

        public /* synthetic */ zzrn zzb(zzrf com_google_android_gms_internal_zzrf) throws IOException {
            return zzw(com_google_android_gms_internal_zzrf);
        }

        public zza zzw(zzrf com_google_android_gms_internal_zzrf) throws IOException {
            while (true) {
                int zzBr = com_google_android_gms_internal_zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zzrf.readString();
                        continue;
                    case 18:
                        if (this.zzaVn == null) {
                            this.zzaVn = new zza();
                        }
                        com_google_android_gms_internal_zzrf.zza(this.zzaVn);
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

    public zzrc() {
        zzBk();
    }

    public static zzrc zzw(byte[] bArr) throws zzrm {
        return (zzrc) zzrn.zza(new zzrc(), bArr);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzrc)) {
            return false;
        }
        zzrc com_google_android_gms_internal_zzrc = (zzrc) o;
        return zzrl.equals(this.zzaVl, com_google_android_gms_internal_zzrc.zzaVl) ? zza((zzrh) com_google_android_gms_internal_zzrc) : false;
    }

    public int hashCode() {
        return ((zzrl.hashCode(this.zzaVl) + 527) * 31) + zzBI();
    }

    protected int zzB() {
        int zzB = super.zzB();
        if (this.zzaVl != null && this.zzaVl.length > 0) {
            for (zzrn com_google_android_gms_internal_zzrn : this.zzaVl) {
                if (com_google_android_gms_internal_zzrn != null) {
                    zzB += zzrg.zzc(1, com_google_android_gms_internal_zzrn);
                }
            }
        }
        return zzB;
    }

    public zzrc zzBk() {
        this.zzaVl = zza.zzBl();
        this.zzaVU = null;
        this.zzaWf = -1;
        return this;
    }

    public void zza(zzrg com_google_android_gms_internal_zzrg) throws IOException {
        if (this.zzaVl != null && this.zzaVl.length > 0) {
            for (zzrn com_google_android_gms_internal_zzrn : this.zzaVl) {
                if (com_google_android_gms_internal_zzrn != null) {
                    com_google_android_gms_internal_zzrg.zza(1, com_google_android_gms_internal_zzrn);
                }
            }
        }
        super.zza(com_google_android_gms_internal_zzrg);
    }

    public /* synthetic */ zzrn zzb(zzrf com_google_android_gms_internal_zzrf) throws IOException {
        return zzv(com_google_android_gms_internal_zzrf);
    }

    public zzrc zzv(zzrf com_google_android_gms_internal_zzrf) throws IOException {
        while (true) {
            int zzBr = com_google_android_gms_internal_zzrf.zzBr();
            switch (zzBr) {
                case 0:
                    break;
                case 10:
                    int zzb = zzrq.zzb(com_google_android_gms_internal_zzrf, 10);
                    zzBr = this.zzaVl == null ? 0 : this.zzaVl.length;
                    Object obj = new zza[(zzb + zzBr)];
                    if (zzBr != 0) {
                        System.arraycopy(this.zzaVl, 0, obj, 0, zzBr);
                    }
                    while (zzBr < obj.length - 1) {
                        obj[zzBr] = new zza();
                        com_google_android_gms_internal_zzrf.zza(obj[zzBr]);
                        com_google_android_gms_internal_zzrf.zzBr();
                        zzBr++;
                    }
                    obj[zzBr] = new zza();
                    com_google_android_gms_internal_zzrf.zza(obj[zzBr]);
                    this.zzaVl = obj;
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
