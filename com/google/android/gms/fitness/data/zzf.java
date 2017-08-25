package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<DataSource> {
    static void zza(DataSource dataSource, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, dataSource.getDataType(), i, false);
        zzb.zzc(parcel, 1000, dataSource.getVersionCode());
        zzb.zza(parcel, 2, dataSource.getName(), false);
        zzb.zzc(parcel, 3, dataSource.getType());
        zzb.zza(parcel, 4, dataSource.getDevice(), i, false);
        zzb.zza(parcel, 5, dataSource.zzqB(), i, false);
        zzb.zza(parcel, 6, dataSource.getStreamName(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeg(x0);
    }

    public DataSource zzcn(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        Application application = null;
        Device device = null;
        String str2 = null;
        DataType dataType = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    dataType = (DataType) zza.zza(parcel, zzaa, DataType.CREATOR);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    device = (Device) zza.zza(parcel, zzaa, Device.CREATOR);
                    break;
                case 5:
                    application = (Application) zza.zza(parcel, zzaa, Application.CREATOR);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new DataSource(i2, dataType, str2, i, device, application, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DataSource[] zzeg(int i) {
        return new DataSource[i];
    }
}
