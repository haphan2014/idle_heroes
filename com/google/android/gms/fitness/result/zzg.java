package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzg implements Creator<DataTypeResult> {
    static void zza(DataTypeResult dataTypeResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, dataTypeResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, dataTypeResult.getVersionCode());
        zzb.zza(parcel, 3, dataTypeResult.getDataType(), i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzff(x0);
    }

    public DataTypeResult zzdk(Parcel parcel) {
        DataType dataType = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            DataType dataType2;
            Status status2;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    dataType2 = dataType;
                    status2 = status3;
                    break;
                case 3:
                    dataType2 = (DataType) zza.zza(parcel, zzaa, DataType.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    DataType dataType3 = dataType;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzaa);
                    dataType2 = dataType3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    dataType2 = dataType;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            dataType = dataType2;
        }
        if (parcel.dataPosition() == zzab) {
            return new DataTypeResult(i, status, dataType);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DataTypeResult[] zzff(int i) {
        return new DataTypeResult[i];
    }
}
