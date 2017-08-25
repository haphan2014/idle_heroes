package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import java.util.List;

public class zzf implements Creator<DataReadRequest> {
    static void zza(DataReadRequest dataReadRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, dataReadRequest.getDataTypes(), false);
        zzb.zzc(parcel, 2, dataReadRequest.getDataSources(), false);
        zzb.zza(parcel, 3, dataReadRequest.zzkt());
        zzb.zza(parcel, 4, dataReadRequest.zzqs());
        zzb.zzc(parcel, 5, dataReadRequest.getAggregatedDataTypes(), false);
        zzb.zzc(parcel, 6, dataReadRequest.getAggregatedDataSources(), false);
        zzb.zzc(parcel, 7, dataReadRequest.getBucketType());
        zzb.zza(parcel, 8, dataReadRequest.zzrb());
        zzb.zza(parcel, 9, dataReadRequest.getActivityDataSource(), i, false);
        zzb.zzc(parcel, 10, dataReadRequest.getLimit());
        zzb.zza(parcel, 12, dataReadRequest.zzra());
        zzb.zza(parcel, 13, dataReadRequest.zzqZ());
        zzb.zza(parcel, 14, dataReadRequest.zzqU(), false);
        zzb.zza(parcel, 15, dataReadRequest.getPackageName(), false);
        zzb.zzc(parcel, 16, dataReadRequest.zzrc(), false);
        zzb.zzc(parcel, 1000, dataReadRequest.getVersionCode());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcF(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzez(x0);
    }

    public DataReadRequest zzcF(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        long j = 0;
        long j2 = 0;
        List list3 = null;
        List list4 = null;
        int i2 = 0;
        long j3 = 0;
        DataSource dataSource = null;
        int i3 = 0;
        boolean z = false;
        boolean z2 = false;
        IBinder iBinder = null;
        String str = null;
        List list5 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    list = zza.zzc(parcel, zzaa, DataType.CREATOR);
                    break;
                case 2:
                    list2 = zza.zzc(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 5:
                    list3 = zza.zzc(parcel, zzaa, DataType.CREATOR);
                    break;
                case 6:
                    list4 = zza.zzc(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 8:
                    j3 = zza.zzi(parcel, zzaa);
                    break;
                case 9:
                    dataSource = (DataSource) zza.zza(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 10:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 12:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 13:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 14:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 15:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 16:
                    list5 = zza.zzc(parcel, zzaa, Device.CREATOR);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new DataReadRequest(i, list, list2, j, j2, list3, list4, i2, j3, dataSource, i3, z, z2, iBinder, str, list5);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DataReadRequest[] zzez(int i) {
        return new DataReadRequest[i];
    }
}
