package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<QueryResultEventParcelable> {
    static void zza(QueryResultEventParcelable queryResultEventParcelable, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, queryResultEventParcelable.zzCY);
        zzb.zza(parcel, 2, queryResultEventParcelable.zzWu, i, false);
        zzb.zza(parcel, 3, queryResultEventParcelable.zzaei);
        zzb.zzc(parcel, 4, queryResultEventParcelable.zzaej);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcj(x0);
    }

    public QueryResultEventParcelable zzaA(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        DataHolder dataHolder = null;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            boolean z2;
            DataHolder dataHolder2;
            int zzg;
            int zzaa = zza.zzaa(parcel);
            int i3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = i;
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = zza.zzg(parcel, zzaa);
                    zzaa = i3;
                    break;
                case 2:
                    zzg = i2;
                    boolean z3 = z;
                    dataHolder2 = (DataHolder) zza.zza(parcel, zzaa, DataHolder.CREATOR);
                    zzaa = i;
                    z2 = z3;
                    break;
                case 3:
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    i3 = i;
                    z2 = zza.zzc(parcel, zzaa);
                    zzaa = i3;
                    break;
                case 4:
                    zzaa = zza.zzg(parcel, zzaa);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzaa = i;
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            dataHolder = dataHolder2;
            z = z2;
            i = zzaa;
        }
        if (parcel.dataPosition() == zzab) {
            return new QueryResultEventParcelable(i2, dataHolder, z, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public QueryResultEventParcelable[] zzcj(int i) {
        return new QueryResultEventParcelable[i];
    }
}
