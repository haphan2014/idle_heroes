package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zzf implements Creator<SendDataRequest> {
    static void zza(SendDataRequest sendDataRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, sendDataRequest.zzwM(), i, false);
        zzb.zzc(parcel, 1000, sendDataRequest.versionCode);
        zzb.zza(parcel, 2, sendDataRequest.getData(), false);
        zzb.zza(parcel, 3, sendDataRequest.zzqU(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhS(x0);
    }

    public SendDataRequest zzfk(Parcel parcel) {
        IBinder iBinder = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        byte[] bArr = null;
        Device device = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            Device device2;
            IBinder iBinder2;
            byte[] bArr2;
            int zzaa = zza.zzaa(parcel);
            IBinder iBinder3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = i;
                    byte[] bArr3 = bArr;
                    device2 = (Device) zza.zza(parcel, zzaa, Device.CREATOR);
                    iBinder2 = iBinder;
                    bArr2 = bArr3;
                    break;
                case 2:
                    device2 = device;
                    i2 = i;
                    iBinder3 = iBinder;
                    bArr2 = zza.zzr(parcel, zzaa);
                    iBinder2 = iBinder3;
                    break;
                case 3:
                    iBinder2 = zza.zzp(parcel, zzaa);
                    bArr2 = bArr;
                    device2 = device;
                    i2 = i;
                    break;
                case 1000:
                    iBinder3 = iBinder;
                    bArr2 = bArr;
                    device2 = device;
                    i2 = zza.zzg(parcel, zzaa);
                    iBinder2 = iBinder3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    iBinder2 = iBinder;
                    bArr2 = bArr;
                    device2 = device;
                    i2 = i;
                    break;
            }
            i = i2;
            device = device2;
            bArr = bArr2;
            iBinder = iBinder2;
        }
        if (parcel.dataPosition() == zzab) {
            return new SendDataRequest(i, device, bArr, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SendDataRequest[] zzhS(int i) {
        return new SendDataRequest[i];
    }
}
