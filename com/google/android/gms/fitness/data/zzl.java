package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<MapValue> {
    static void zza(MapValue mapValue, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, mapValue.getFormat());
        zzb.zzc(parcel, 1000, mapValue.getVersionCode());
        zzb.zza(parcel, 2, mapValue.zzqI());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzek(x0);
    }

    public MapValue zzcr(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        float f = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    f = zza.zzl(parcel, zzaa);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new MapValue(i2, i, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public MapValue[] zzek(int i) {
        return new MapValue[i];
    }
}
