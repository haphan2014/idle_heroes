package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.HashSet;
import java.util.Set;

public class zzb implements Creator<MomentEntity> {
    static void zza(MomentEntity momentEntity, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        Set set = momentEntity.zzaHQ;
        if (set.contains(Integer.valueOf(1))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, momentEntity.zzCY);
        }
        if (set.contains(Integer.valueOf(2))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, momentEntity.zzKI, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, momentEntity.zzaIL, i, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, momentEntity.zzaID, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, momentEntity.zzaIM, i, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, momentEntity.zzEl, true);
        }
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziB(x0);
    }

    public MomentEntity zzfL(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        ItemScopeEntity itemScopeEntity = null;
        String str2 = null;
        ItemScopeEntity itemScopeEntity2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            ItemScopeEntity itemScopeEntity3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzaa);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 4:
                    itemScopeEntity3 = (ItemScopeEntity) zza.zza(parcel, zzaa, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(4));
                    itemScopeEntity2 = itemScopeEntity3;
                    break;
                case 5:
                    str2 = zza.zzo(parcel, zzaa);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    itemScopeEntity3 = (ItemScopeEntity) zza.zza(parcel, zzaa, ItemScopeEntity.CREATOR);
                    hashSet.add(Integer.valueOf(6));
                    itemScopeEntity = itemScopeEntity3;
                    break;
                case 7:
                    str = zza.zzo(parcel, zzaa);
                    hashSet.add(Integer.valueOf(7));
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new MomentEntity(hashSet, i, str3, itemScopeEntity2, str2, itemScopeEntity, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public MomentEntity[] zziB(int i) {
        return new MomentEntity[i];
    }
}
