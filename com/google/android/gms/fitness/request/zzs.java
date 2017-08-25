package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class zzs implements Creator<SensorRegistrationRequest> {
    static void zza(SensorRegistrationRequest sensorRegistrationRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, sensorRegistrationRequest.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, sensorRegistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, sensorRegistrationRequest.getDataType(), i, false);
        zzb.zza(parcel, 3, sensorRegistrationRequest.zzrl(), false);
        zzb.zzc(parcel, 4, sensorRegistrationRequest.zzams);
        zzb.zzc(parcel, 5, sensorRegistrationRequest.zzamt);
        zzb.zza(parcel, 6, sensorRegistrationRequest.zzqL());
        zzb.zza(parcel, 7, sensorRegistrationRequest.zzri());
        zzb.zza(parcel, 8, sensorRegistrationRequest.zzrg(), i, false);
        zzb.zza(parcel, 9, sensorRegistrationRequest.zzrh());
        zzb.zzc(parcel, 10, sensorRegistrationRequest.getAccuracyMode());
        zzb.zzc(parcel, 11, sensorRegistrationRequest.zzrj(), false);
        zzb.zza(parcel, 12, sensorRegistrationRequest.zzrk());
        zzb.zza(parcel, 13, sensorRegistrationRequest.zzqU(), false);
        zzb.zza(parcel, 14, sensorRegistrationRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcR(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeL(x0);
    }

    public SensorRegistrationRequest zzcR(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        DataSource dataSource = null;
        DataType dataType = null;
        IBinder iBinder = null;
        int i2 = 0;
        int i3 = 0;
        long j = 0;
        long j2 = 0;
        PendingIntent pendingIntent = null;
        long j3 = 0;
        int i4 = 0;
        List list = null;
        long j4 = 0;
        IBinder iBinder2 = null;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 2:
                    dataType = (DataType) zza.zza(parcel, zzaa, DataType.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 7:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 8:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzaa, PendingIntent.CREATOR);
                    break;
                case 9:
                    j3 = zza.zzi(parcel, zzaa);
                    break;
                case 10:
                    i4 = zza.zzg(parcel, zzaa);
                    break;
                case 11:
                    list = zza.zzc(parcel, zzaa, LocationRequest.CREATOR);
                    break;
                case 12:
                    j4 = zza.zzi(parcel, zzaa);
                    break;
                case 13:
                    iBinder2 = zza.zzp(parcel, zzaa);
                    break;
                case 14:
                    str = zza.zzo(parcel, zzaa);
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
            return new SensorRegistrationRequest(i, dataSource, dataType, iBinder, i2, i3, j, j2, pendingIntent, j3, i4, list, j4, iBinder2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SensorRegistrationRequest[] zzeL(int i) {
        return new SensorRegistrationRequest[i];
    }
}
