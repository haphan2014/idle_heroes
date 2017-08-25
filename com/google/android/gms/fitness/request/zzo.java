package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Creator<ListClaimedBleDevicesRequest> {
    static void zza(ListClaimedBleDevicesRequest listClaimedBleDevicesRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, listClaimedBleDevicesRequest.zzqU(), false);
        zzb.zzc(parcel, 1000, listClaimedBleDevicesRequest.getVersionCode());
        zzb.zza(parcel, 2, listClaimedBleDevicesRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeH(x0);
    }

    public ListClaimedBleDevicesRequest zzcN(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 2:
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
            return new ListClaimedBleDevicesRequest(i, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ListClaimedBleDevicesRequest[] zzeH(int i) {
        return new ListClaimedBleDevicesRequest[i];
    }
}
