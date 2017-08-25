package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzt implements Creator<SensorUnregistrationRequest> {
    static void zza(SensorUnregistrationRequest sensorUnregistrationRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, sensorUnregistrationRequest.zzrl(), false);
        zzb.zzc(parcel, 1000, sensorUnregistrationRequest.getVersionCode());
        zzb.zza(parcel, 2, sensorUnregistrationRequest.zzrg(), i, false);
        zzb.zza(parcel, 3, sensorUnregistrationRequest.zzqU(), false);
        zzb.zza(parcel, 4, sensorUnregistrationRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeN(x0);
    }

    public SensorUnregistrationRequest zzcS(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    iBinder2 = zza.zzp(parcel, zzaa);
                    break;
                case 2:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzaa, PendingIntent.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 4:
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
            return new SensorUnregistrationRequest(i, iBinder2, pendingIntent, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SensorUnregistrationRequest[] zzeN(int i) {
        return new SensorUnregistrationRequest[i];
    }
}
