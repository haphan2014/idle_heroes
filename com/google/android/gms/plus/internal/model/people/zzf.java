package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.ImageEntity;
import java.util.HashSet;
import java.util.Set;

public class zzf implements Creator<ImageEntity> {
    static void zza(ImageEntity imageEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        Set set = imageEntity.zzaHQ;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, imageEntity.zzCY);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, imageEntity.zzF, true);
        }
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziH(x0);
    }

    public ImageEntity zzfR(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    hashSet.add(Integer.valueOf(2));
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ImageEntity(hashSet, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ImageEntity[] zziH(int i) {
        return new ImageEntity[i];
    }
}
