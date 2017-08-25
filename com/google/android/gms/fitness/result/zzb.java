package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSet;

public class zzb implements Creator<DailyTotalResult> {
    static void zza(DailyTotalResult dailyTotalResult, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, dailyTotalResult.getStatus(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, dailyTotalResult.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, dailyTotalResult.getTotal(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfa(x0);
    }

    public DailyTotalResult zzdf(Parcel parcel) {
        DataSet dataSet = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            DataSet dataSet2;
            Status status2;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    dataSet2 = dataSet;
                    status2 = status3;
                    break;
                case 2:
                    dataSet2 = (DataSet) zza.zza(parcel, zzaa, DataSet.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    DataSet dataSet3 = dataSet;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzaa);
                    dataSet2 = dataSet3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    dataSet2 = dataSet;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            dataSet = dataSet2;
        }
        if (parcel.dataPosition() == zzab) {
            return new DailyTotalResult(i, status, dataSet);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DailyTotalResult[] zzfa(int i) {
        return new DailyTotalResult[i];
    }
}
