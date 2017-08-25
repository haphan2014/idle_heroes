package com.google.android.gms.internal;

import com.google.android.gms.location.places.Place;
import java.io.IOException;

public interface zznj {

    public static final class zza extends zzrh<zza> {
        public zza[] zzawk;

        public static final class zza extends zzrh<zza> {
            private static volatile zza[] zzawl;
            public int viewId;
            public String zzawm;
            public String zzawn;

            public zza() {
                zztW();
            }

            public static zza[] zztV() {
                if (zzawl == null) {
                    synchronized (zzrl.zzaWe) {
                        if (zzawl == null) {
                            zzawl = new zza[0];
                        }
                    }
                }
                return zzawl;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof zza)) {
                    return false;
                }
                zza com_google_android_gms_internal_zznj_zza_zza = (zza) o;
                if (this.zzawm == null) {
                    if (com_google_android_gms_internal_zznj_zza_zza.zzawm != null) {
                        return false;
                    }
                } else if (!this.zzawm.equals(com_google_android_gms_internal_zznj_zza_zza.zzawm)) {
                    return false;
                }
                if (this.zzawn == null) {
                    if (com_google_android_gms_internal_zznj_zza_zza.zzawn != null) {
                        return false;
                    }
                } else if (!this.zzawn.equals(com_google_android_gms_internal_zznj_zza_zza.zzawn)) {
                    return false;
                }
                return this.viewId == com_google_android_gms_internal_zznj_zza_zza.viewId ? zza((zzrh) com_google_android_gms_internal_zznj_zza_zza) : false;
            }

            public int hashCode() {
                int i = 0;
                int hashCode = ((this.zzawm == null ? 0 : this.zzawm.hashCode()) + 527) * 31;
                if (this.zzawn != null) {
                    i = this.zzawn.hashCode();
                }
                return ((((hashCode + i) * 31) + this.viewId) * 31) + zzBI();
            }

            protected int zzB() {
                int zzB = super.zzB();
                if (!this.zzawm.equals("")) {
                    zzB += zzrg.zzk(1, this.zzawm);
                }
                if (!this.zzawn.equals("")) {
                    zzB += zzrg.zzk(2, this.zzawn);
                }
                return this.viewId != 0 ? zzB + zzrg.zzA(3, this.viewId) : zzB;
            }

            public void zza(zzrg com_google_android_gms_internal_zzrg) throws IOException {
                if (!this.zzawm.equals("")) {
                    com_google_android_gms_internal_zzrg.zzb(1, this.zzawm);
                }
                if (!this.zzawn.equals("")) {
                    com_google_android_gms_internal_zzrg.zzb(2, this.zzawn);
                }
                if (this.viewId != 0) {
                    com_google_android_gms_internal_zzrg.zzy(3, this.viewId);
                }
                super.zza(com_google_android_gms_internal_zzrg);
            }

            public /* synthetic */ zzrn zzb(zzrf com_google_android_gms_internal_zzrf) throws IOException {
                return zzq(com_google_android_gms_internal_zzrf);
            }

            public zza zzq(zzrf com_google_android_gms_internal_zzrf) throws IOException {
                while (true) {
                    int zzBr = com_google_android_gms_internal_zzrf.zzBr();
                    switch (zzBr) {
                        case 0:
                            break;
                        case 10:
                            this.zzawm = com_google_android_gms_internal_zzrf.readString();
                            continue;
                        case 18:
                            this.zzawn = com_google_android_gms_internal_zzrf.readString();
                            continue;
                        case Place.TYPE_CITY_HALL /*24*/:
                            this.viewId = com_google_android_gms_internal_zzrf.zzBu();
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

            public zza zztW() {
                this.zzawm = "";
                this.zzawn = "";
                this.viewId = 0;
                this.zzaVU = null;
                this.zzaWf = -1;
                return this;
            }
        }

        public zza() {
            zztU();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza com_google_android_gms_internal_zznj_zza = (zza) o;
            return zzrl.equals(this.zzawk, com_google_android_gms_internal_zznj_zza.zzawk) ? zza((zzrh) com_google_android_gms_internal_zznj_zza) : false;
        }

        public int hashCode() {
            return ((zzrl.hashCode(this.zzawk) + 527) * 31) + zzBI();
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzawk != null && this.zzawk.length > 0) {
                for (zzrn com_google_android_gms_internal_zzrn : this.zzawk) {
                    if (com_google_android_gms_internal_zzrn != null) {
                        zzB += zzrg.zzc(1, com_google_android_gms_internal_zzrn);
                    }
                }
            }
            return zzB;
        }

        public void zza(zzrg com_google_android_gms_internal_zzrg) throws IOException {
            if (this.zzawk != null && this.zzawk.length > 0) {
                for (zzrn com_google_android_gms_internal_zzrn : this.zzawk) {
                    if (com_google_android_gms_internal_zzrn != null) {
                        com_google_android_gms_internal_zzrg.zza(1, com_google_android_gms_internal_zzrn);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzrg);
        }

        public /* synthetic */ zzrn zzb(zzrf com_google_android_gms_internal_zzrf) throws IOException {
            return zzp(com_google_android_gms_internal_zzrf);
        }

        public zza zzp(zzrf com_google_android_gms_internal_zzrf) throws IOException {
            while (true) {
                int zzBr = com_google_android_gms_internal_zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 10:
                        int zzb = zzrq.zzb(com_google_android_gms_internal_zzrf, 10);
                        zzBr = this.zzawk == null ? 0 : this.zzawk.length;
                        Object obj = new zza[(zzb + zzBr)];
                        if (zzBr != 0) {
                            System.arraycopy(this.zzawk, 0, obj, 0, zzBr);
                        }
                        while (zzBr < obj.length - 1) {
                            obj[zzBr] = new zza();
                            com_google_android_gms_internal_zzrf.zza(obj[zzBr]);
                            com_google_android_gms_internal_zzrf.zzBr();
                            zzBr++;
                        }
                        obj[zzBr] = new zza();
                        com_google_android_gms_internal_zzrf.zza(obj[zzBr]);
                        this.zzawk = obj;
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

        public zza zztU() {
            this.zzawk = zza.zztV();
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzb extends zzrh<zzb> {
        private static volatile zzb[] zzawo;
        public String name;
        public zzd zzawp;

        public zzb() {
            zztY();
        }

        public static zzb[] zztX() {
            if (zzawo == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzawo == null) {
                        zzawo = new zzb[0];
                    }
                }
            }
            return zzawo;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb com_google_android_gms_internal_zznj_zzb = (zzb) o;
            if (this.name == null) {
                if (com_google_android_gms_internal_zznj_zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(com_google_android_gms_internal_zznj_zzb.name)) {
                return false;
            }
            if (this.zzawp == null) {
                if (com_google_android_gms_internal_zznj_zzb.zzawp != null) {
                    return false;
                }
            } else if (!this.zzawp.equals(com_google_android_gms_internal_zznj_zzb.zzawp)) {
                return false;
            }
            return zza((zzrh) com_google_android_gms_internal_zznj_zzb);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.name == null ? 0 : this.name.hashCode()) + 527) * 31;
            if (this.zzawp != null) {
                i = this.zzawp.hashCode();
            }
            return ((hashCode + i) * 31) + zzBI();
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (!this.name.equals("")) {
                zzB += zzrg.zzk(1, this.name);
            }
            return this.zzawp != null ? zzB + zzrg.zzc(2, this.zzawp) : zzB;
        }

        public void zza(zzrg com_google_android_gms_internal_zzrg) throws IOException {
            if (!this.name.equals("")) {
                com_google_android_gms_internal_zzrg.zzb(1, this.name);
            }
            if (this.zzawp != null) {
                com_google_android_gms_internal_zzrg.zza(2, this.zzawp);
            }
            super.zza(com_google_android_gms_internal_zzrg);
        }

        public /* synthetic */ zzrn zzb(zzrf com_google_android_gms_internal_zzrf) throws IOException {
            return zzr(com_google_android_gms_internal_zzrf);
        }

        public zzb zzr(zzrf com_google_android_gms_internal_zzrf) throws IOException {
            while (true) {
                int zzBr = com_google_android_gms_internal_zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 10:
                        this.name = com_google_android_gms_internal_zzrf.readString();
                        continue;
                    case 18:
                        if (this.zzawp == null) {
                            this.zzawp = new zzd();
                        }
                        com_google_android_gms_internal_zzrf.zza(this.zzawp);
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

        public zzb zztY() {
            this.name = "";
            this.zzawp = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzc extends zzrh<zzc> {
        public String type;
        public zzb[] zzawq;

        public zzc() {
            zztZ();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc com_google_android_gms_internal_zznj_zzc = (zzc) o;
            if (this.type == null) {
                if (com_google_android_gms_internal_zznj_zzc.type != null) {
                    return false;
                }
            } else if (!this.type.equals(com_google_android_gms_internal_zznj_zzc.type)) {
                return false;
            }
            return zzrl.equals(this.zzawq, com_google_android_gms_internal_zznj_zzc.zzawq) ? zza((zzrh) com_google_android_gms_internal_zznj_zzc) : false;
        }

        public int hashCode() {
            return (((((this.type == null ? 0 : this.type.hashCode()) + 527) * 31) + zzrl.hashCode(this.zzawq)) * 31) + zzBI();
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (!this.type.equals("")) {
                zzB += zzrg.zzk(1, this.type);
            }
            if (this.zzawq == null || this.zzawq.length <= 0) {
                return zzB;
            }
            int i = zzB;
            for (zzrn com_google_android_gms_internal_zzrn : this.zzawq) {
                if (com_google_android_gms_internal_zzrn != null) {
                    i += zzrg.zzc(2, com_google_android_gms_internal_zzrn);
                }
            }
            return i;
        }

        public void zza(zzrg com_google_android_gms_internal_zzrg) throws IOException {
            if (!this.type.equals("")) {
                com_google_android_gms_internal_zzrg.zzb(1, this.type);
            }
            if (this.zzawq != null && this.zzawq.length > 0) {
                for (zzrn com_google_android_gms_internal_zzrn : this.zzawq) {
                    if (com_google_android_gms_internal_zzrn != null) {
                        com_google_android_gms_internal_zzrg.zza(2, com_google_android_gms_internal_zzrn);
                    }
                }
            }
            super.zza(com_google_android_gms_internal_zzrg);
        }

        public /* synthetic */ zzrn zzb(zzrf com_google_android_gms_internal_zzrf) throws IOException {
            return zzs(com_google_android_gms_internal_zzrf);
        }

        public zzc zzs(zzrf com_google_android_gms_internal_zzrf) throws IOException {
            while (true) {
                int zzBr = com_google_android_gms_internal_zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 10:
                        this.type = com_google_android_gms_internal_zzrf.readString();
                        continue;
                    case 18:
                        int zzb = zzrq.zzb(com_google_android_gms_internal_zzrf, 18);
                        zzBr = this.zzawq == null ? 0 : this.zzawq.length;
                        Object obj = new zzb[(zzb + zzBr)];
                        if (zzBr != 0) {
                            System.arraycopy(this.zzawq, 0, obj, 0, zzBr);
                        }
                        while (zzBr < obj.length - 1) {
                            obj[zzBr] = new zzb();
                            com_google_android_gms_internal_zzrf.zza(obj[zzBr]);
                            com_google_android_gms_internal_zzrf.zzBr();
                            zzBr++;
                        }
                        obj[zzBr] = new zzb();
                        com_google_android_gms_internal_zzrf.zza(obj[zzBr]);
                        this.zzawq = obj;
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

        public zzc zztZ() {
            this.type = "";
            this.zzawq = zzb.zztX();
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzd extends zzrh<zzd> {
        public String zzabE;
        public boolean zzawr;
        public long zzaws;
        public double zzawt;
        public zzc zzawu;

        public zzd() {
            zzua();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd com_google_android_gms_internal_zznj_zzd = (zzd) o;
            if (this.zzawr != com_google_android_gms_internal_zznj_zzd.zzawr) {
                return false;
            }
            if (this.zzabE == null) {
                if (com_google_android_gms_internal_zznj_zzd.zzabE != null) {
                    return false;
                }
            } else if (!this.zzabE.equals(com_google_android_gms_internal_zznj_zzd.zzabE)) {
                return false;
            }
            if (this.zzaws != com_google_android_gms_internal_zznj_zzd.zzaws || Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(com_google_android_gms_internal_zznj_zzd.zzawt)) {
                return false;
            }
            if (this.zzawu == null) {
                if (com_google_android_gms_internal_zznj_zzd.zzawu != null) {
                    return false;
                }
            } else if (!this.zzawu.equals(com_google_android_gms_internal_zznj_zzd.zzawu)) {
                return false;
            }
            return zza((zzrh) com_google_android_gms_internal_zznj_zzd);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (((this.zzabE == null ? 0 : this.zzabE.hashCode()) + (((this.zzawr ? 1231 : 1237) + 527) * 31)) * 31) + ((int) (this.zzaws ^ (this.zzaws >>> 32)));
            long doubleToLongBits = Double.doubleToLongBits(this.zzawt);
            hashCode = ((hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31;
            if (this.zzawu != null) {
                i = this.zzawu.hashCode();
            }
            return ((hashCode + i) * 31) + zzBI();
        }

        protected int zzB() {
            int zzB = super.zzB();
            if (this.zzawr) {
                zzB += zzrg.zzc(1, this.zzawr);
            }
            if (!this.zzabE.equals("")) {
                zzB += zzrg.zzk(2, this.zzabE);
            }
            if (this.zzaws != 0) {
                zzB += zzrg.zzd(3, this.zzaws);
            }
            if (Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(0.0d)) {
                zzB += zzrg.zzb(4, this.zzawt);
            }
            return this.zzawu != null ? zzB + zzrg.zzc(5, this.zzawu) : zzB;
        }

        public void zza(zzrg com_google_android_gms_internal_zzrg) throws IOException {
            if (this.zzawr) {
                com_google_android_gms_internal_zzrg.zzb(1, this.zzawr);
            }
            if (!this.zzabE.equals("")) {
                com_google_android_gms_internal_zzrg.zzb(2, this.zzabE);
            }
            if (this.zzaws != 0) {
                com_google_android_gms_internal_zzrg.zzb(3, this.zzaws);
            }
            if (Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(0.0d)) {
                com_google_android_gms_internal_zzrg.zza(4, this.zzawt);
            }
            if (this.zzawu != null) {
                com_google_android_gms_internal_zzrg.zza(5, this.zzawu);
            }
            super.zza(com_google_android_gms_internal_zzrg);
        }

        public /* synthetic */ zzrn zzb(zzrf com_google_android_gms_internal_zzrf) throws IOException {
            return zzt(com_google_android_gms_internal_zzrf);
        }

        public zzd zzt(zzrf com_google_android_gms_internal_zzrf) throws IOException {
            while (true) {
                int zzBr = com_google_android_gms_internal_zzrf.zzBr();
                switch (zzBr) {
                    case 0:
                        break;
                    case 8:
                        this.zzawr = com_google_android_gms_internal_zzrf.zzBv();
                        continue;
                    case 18:
                        this.zzabE = com_google_android_gms_internal_zzrf.readString();
                        continue;
                    case Place.TYPE_CITY_HALL /*24*/:
                        this.zzaws = com_google_android_gms_internal_zzrf.zzBt();
                        continue;
                    case Place.TYPE_EMBASSY /*33*/:
                        this.zzawt = com_google_android_gms_internal_zzrf.readDouble();
                        continue;
                    case Place.TYPE_GENERAL_CONTRACTOR /*42*/:
                        if (this.zzawu == null) {
                            this.zzawu = new zzc();
                        }
                        com_google_android_gms_internal_zzrf.zza(this.zzawu);
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

        public zzd zzua() {
            this.zzawr = false;
            this.zzabE = "";
            this.zzaws = 0;
            this.zzawt = 0.0d;
            this.zzawu = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }
}
