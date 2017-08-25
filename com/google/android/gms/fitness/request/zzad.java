package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad implements Creator<UnclaimBleDeviceRequest> {
    static void zza(UnclaimBleDeviceRequest unclaimBleDeviceRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1000, unclaimBleDeviceRequest.getVersionCode());
        zzb.zza(parcel, 2, unclaimBleDeviceRequest.getDeviceAddress(), false);
        zzb.zza(parcel, 3, unclaimBleDeviceRequest.zzqU(), false);
        zzb.zza(parcel, 4, unclaimBleDeviceRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeX(x0);
    }

    public UnclaimBleDeviceRequest zzdc(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        IBinder iBinder = null;
        String str2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
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
            return new UnclaimBleDeviceRequest(i, str2, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public UnclaimBleDeviceRequest[] zzeX(int i) {
        return new UnclaimBleDeviceRequest[i];
    }
}
