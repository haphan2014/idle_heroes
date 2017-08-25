package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

public class zzc implements Creator<DailyTotalRequest> {
    static void zza(DailyTotalRequest dailyTotalRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, dailyTotalRequest.zzqU(), false);
        zzb.zzc(parcel, 1000, dailyTotalRequest.getVersionCode());
        zzb.zza(parcel, 2, dailyTotalRequest.getDataType(), i, false);
        zzb.zza(parcel, 3, dailyTotalRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzew(x0);
    }

    public DailyTotalRequest zzcC(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        DataType dataType = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            IBinder zzp;
            String str2;
            DataType dataType2;
            int zzaa = zza.zzaa(parcel);
            String str3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    DataType dataType3 = dataType;
                    zzp = zza.zzp(parcel, zzaa);
                    str2 = str;
                    dataType2 = dataType3;
                    break;
                case 2:
                    zzp = iBinder;
                    i2 = i;
                    str3 = str;
                    dataType2 = (DataType) zza.zza(parcel, zzaa, DataType.CREATOR);
                    str2 = str3;
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    dataType2 = dataType;
                    zzp = iBinder;
                    i2 = i;
                    break;
                case 1000:
                    str3 = str;
                    dataType2 = dataType;
                    zzp = iBinder;
                    i2 = zza.zzg(parcel, zzaa);
                    str2 = str3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    str2 = str;
                    dataType2 = dataType;
                    zzp = iBinder;
                    i2 = i;
                    break;
            }
            i = i2;
            iBinder = zzp;
            dataType = dataType2;
            str = str2;
        }
        if (parcel.dataPosition() == zzab) {
            return new DailyTotalRequest(i, iBinder, dataType, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DailyTotalRequest[] zzew(int i) {
        return new DailyTotalRequest[i];
    }
}
