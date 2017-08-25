package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzk implements Creator<ParentDriveIdSet> {
    static void zza(ParentDriveIdSet parentDriveIdSet, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, parentDriveIdSet.zzCY);
        zzb.zzc(parcel, 2, parentDriveIdSet.zzagJ, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzds(x0);
    }

    public ParentDriveIdSet zzbD(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzaa, PartialDriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ParentDriveIdSet(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ParentDriveIdSet[] zzds(int i) {
        return new ParentDriveIdSet[i];
    }
}
