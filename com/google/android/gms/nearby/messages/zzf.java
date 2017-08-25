package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<Strategy> {
    static void zza(Strategy strategy, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, strategy.zzaFT);
        zzb.zzc(parcel, 1000, strategy.versionCode);
        zzb.zzc(parcel, 2, strategy.zzaFU);
        zzb.zzc(parcel, 3, strategy.zzaFV);
        zzb.zza(parcel, 4, strategy.zzaFW);
        zzb.zzc(parcel, 5, strategy.zzaFX);
        zzb.zzc(parcel, 6, strategy.zzaFY);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzig(x0);
    }

    public Strategy zzfr(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i5 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i4 = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 1000:
                    i6 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new Strategy(i6, i5, i4, i3, z, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public Strategy[] zzig(int i) {
        return new Strategy[i];
    }
}
