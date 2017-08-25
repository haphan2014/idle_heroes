package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.plus.internal.model.people.PersonEntity.NameEntity;
import java.util.HashSet;
import java.util.Set;

public class zzg implements Creator<NameEntity> {
    static void zza(NameEntity nameEntity, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        Set set = nameEntity.zzaHQ;
        if (set.contains(Integer.valueOf(1))) {
            zzb.zzc(parcel, 1, nameEntity.zzCY);
        }
        if (set.contains(Integer.valueOf(2))) {
            zzb.zza(parcel, 2, nameEntity.zzaIo, true);
        }
        if (set.contains(Integer.valueOf(3))) {
            zzb.zza(parcel, 3, nameEntity.zzaJo, true);
        }
        if (set.contains(Integer.valueOf(4))) {
            zzb.zza(parcel, 4, nameEntity.zzaIr, true);
        }
        if (set.contains(Integer.valueOf(5))) {
            zzb.zza(parcel, 5, nameEntity.zzaJp, true);
        }
        if (set.contains(Integer.valueOf(6))) {
            zzb.zza(parcel, 6, nameEntity.zzaJq, true);
        }
        if (set.contains(Integer.valueOf(7))) {
            zzb.zza(parcel, 7, nameEntity.zzaJr, true);
        }
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziI(x0);
    }

    public NameEntity zzfS(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        Set hashSet = new HashSet();
        int i = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    hashSet.add(Integer.valueOf(1));
                    break;
                case 2:
                    str6 = zza.zzo(parcel, zzaa);
                    hashSet.add(Integer.valueOf(2));
                    break;
                case 3:
                    str5 = zza.zzo(parcel, zzaa);
                    hashSet.add(Integer.valueOf(3));
                    break;
                case 4:
                    str4 = zza.zzo(parcel, zzaa);
                    hashSet.add(Integer.valueOf(4));
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzaa);
                    hashSet.add(Integer.valueOf(5));
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzaa);
                    hashSet.add(Integer.valueOf(6));
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
            return new NameEntity(hashSet, i, str6, str5, str4, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public NameEntity[] zziI(int i) {
        return new NameEntity[i];
    }
}
