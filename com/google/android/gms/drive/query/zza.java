package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.List;

public class zza implements Creator<Query> {
    static void zza(Query query, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1000, query.zzCY);
        zzb.zza(parcel, 1, query.zzahG, i, false);
        zzb.zza(parcel, 3, query.zzahH, false);
        zzb.zza(parcel, 4, query.zzahI, i, false);
        zzb.zzb(parcel, 5, query.zzahJ, false);
        zzb.zza(parcel, 6, query.zzahK);
        zzb.zzc(parcel, 7, query.zzadR, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdu(x0);
    }

    public Query zzbF(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        List list2 = null;
        SortOrder sortOrder = null;
        String str = null;
        LogicalFilter logicalFilter = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    logicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, LogicalFilter.CREATOR);
                    break;
                case 3:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    sortOrder = (SortOrder) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, SortOrder.CREATOR);
                    break;
                case 5:
                    list2 = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, zzaa);
                    break;
                case 6:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa);
                    break;
                case 7:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, DriveSpace.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new Query(i, logicalFilter, str, sortOrder, list2, z, list);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public Query[] zzdu(int i) {
        return new Query[i];
    }
}
