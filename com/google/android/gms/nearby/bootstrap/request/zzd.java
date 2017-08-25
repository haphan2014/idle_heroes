package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzd implements Creator<DisconnectRequest> {
    static void zza(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, disconnectRequest.zzwM(), i, false);
        zzb.zzc(parcel, 1000, disconnectRequest.versionCode);
        zzb.zza(parcel, 2, disconnectRequest.zzqU(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfi(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhQ(x0);
    }

    public DisconnectRequest zzfi(Parcel parcel) {
        IBinder iBinder = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        Device device = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            IBinder iBinder2;
            Device device2;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    Device device3 = (Device) zza.zza(parcel, zzaa, Device.CREATOR);
                    iBinder2 = iBinder;
                    device2 = device3;
                    break;
                case 2:
                    iBinder2 = zza.zzp(parcel, zzaa);
                    device2 = device;
                    i2 = i;
                    break;
                case 1000:
                    IBinder iBinder3 = iBinder;
                    device2 = device;
                    i2 = zza.zzg(parcel, zzaa);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    iBinder2 = iBinder;
                    device2 = device;
                    i2 = i;
                    break;
            }
            i = i2;
            device = device2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzab) {
            return new DisconnectRequest(i, device, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DisconnectRequest[] zzhQ(int i) {
        return new DisconnectRequest[i];
    }
}
