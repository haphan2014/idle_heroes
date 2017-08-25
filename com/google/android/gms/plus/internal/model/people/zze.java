package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity.CoverPhotoEntity;
import java.util.HashSet;
import java.util.Set;

public class zze implements Creator<CoverPhotoEntity> {
    static void zza(CoverPhotoEntity coverPhotoEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        Set set = coverPhotoEntity.zzaHQ;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, coverPhotoEntity.zzCY);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zzc(parcel, 2, coverPhotoEntity.zznN);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, coverPhotoEntity.zzF, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zzc(parcel, 4, coverPhotoEntity.zznM);
        }
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziG(x0);
    }

    public CoverPhotoEntity zzfQ(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        Set hashSet = new HashSet();
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzaa);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    i = zza.zzg(parcel, zzaa);
                    hashSet.add(Integer.valueOf(4));
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CoverPhotoEntity(hashSet, i3, i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CoverPhotoEntity[] zziG(int i) {
        return new CoverPhotoEntity[i];
    }
}
