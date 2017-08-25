package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity.SubstringEntity;
import java.util.List;

public class zza implements Creator<AutocompletePredictionEntity> {
    static void zza(AutocompletePredictionEntity autocompletePredictionEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, autocompletePredictionEntity.zzakM, false);
        zzb.zzc(parcel, 1000, autocompletePredictionEntity.zzCY);
        zzb.zza(parcel, 2, autocompletePredictionEntity.zzazK, false);
        zzb.zza(parcel, 3, autocompletePredictionEntity.zzazo, false);
        zzb.zzc(parcel, 4, autocompletePredictionEntity.zzaAe, false);
        zzb.zzc(parcel, 5, autocompletePredictionEntity.zzaAf);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzex(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgW(x0);
    }

    public AutocompletePredictionEntity zzex(Parcel parcel) {
        int i = 0;
        List list = null;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        List list2 = null;
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    list2 = com.google.android.gms.common.internal.safeparcel.zza.zzB(parcel, zzaa);
                    break;
                case 4:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, SubstringEntity.CREATOR);
                    break;
                case 5:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 1000:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AutocompletePredictionEntity(i2, str2, str, list2, list, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public AutocompletePredictionEntity[] zzgW(int i) {
        return new AutocompletePredictionEntity[i];
    }
}
