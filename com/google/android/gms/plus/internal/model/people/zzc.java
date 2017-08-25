package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity.CoverInfoEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity.CoverEntity.CoverPhotoEntity;
import java.util.HashSet;
import java.util.Set;

public class zzc implements Creator<CoverEntity> {
    static void zza(CoverEntity coverEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        Set set = coverEntity.zzaHQ;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, coverEntity.zzCY);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, coverEntity.zzaJj, i, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, coverEntity.zzaJk, i, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zzc(parcel, 4, coverEntity.zzaJl);
        }
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziE(x0);
    }

    public CoverEntity zzfO(Parcel parcel) {
        CoverPhotoEntity coverPhotoEntity = null;
        int i = 0;
        int zzab = zza.zzab(parcel);
        Set hashSet = new HashSet();
        CoverInfoEntity coverInfoEntity = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    CoverInfoEntity coverInfoEntity2 = (CoverInfoEntity) zza.zza(parcel, zzaa, CoverInfoEntity.CREATOR);
                    hashSet.add(Integer.valueOf(2));
                    coverInfoEntity = coverInfoEntity2;
                    break;
                case 3:
                    CoverPhotoEntity coverPhotoEntity2 = (CoverPhotoEntity) zza.zza(parcel, zzaa, CoverPhotoEntity.CREATOR);
                    hashSet.add(Integer.valueOf(3));
                    coverPhotoEntity = coverPhotoEntity2;
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
            return new CoverEntity(hashSet, i2, coverInfoEntity, coverPhotoEntity, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CoverEntity[] zziE(int i) {
        return new CoverEntity[i];
    }
}
