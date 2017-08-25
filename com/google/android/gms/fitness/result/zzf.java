package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzf implements Creator<DataStatsResult> {
    static void zza(DataStatsResult dataStatsResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, dataStatsResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, dataStatsResult.getVersionCode());
        zzb.zzc(parcel, 2, dataStatsResult.zzrx(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfe(x0);
    }

    public DataStatsResult zzdj(Parcel parcel) {
        List list = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            Status status2;
            ArrayList zzc;
            int zzaa = zza.zzaa(parcel);
            List list2;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    list2 = list;
                    status2 = status3;
                    break;
                case 2:
                    zzc = zza.zzc(parcel, zzaa, DataSourceStatsResult.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzaa);
                    list2 = list3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzc = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzab) {
            return new DataStatsResult(i, status, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DataStatsResult[] zzfe(int i) {
        return new DataStatsResult[i];
    }
}
