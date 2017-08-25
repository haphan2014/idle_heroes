package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.bootstrap.Device;

public class zza implements Creator<ConnectRequest> {
    static void zza(ConnectRequest connectRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, connectRequest.zzwM(), i, false);
        zzb.zzc(parcel, 1000, connectRequest.versionCode);
        zzb.zza(parcel, 2, connectRequest.getName(), false);
        zzb.zza(parcel, 3, connectRequest.getDescription(), false);
        zzb.zza(parcel, 4, connectRequest.zzwO(), false);
        zzb.zza(parcel, 5, connectRequest.zzwP(), false);
        zzb.zza(parcel, 6, connectRequest.zzqU(), false);
        zzb.zza(parcel, 7, connectRequest.zzwK());
        zzb.zza(parcel, 8, connectRequest.zzwN());
        zzb.zza(parcel, 9, connectRequest.getToken(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzff(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhN(x0);
    }

    public ConnectRequest zzff(Parcel parcel) {
        byte b = (byte) 0;
        IBinder iBinder = null;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        long j = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        Device device = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    device = (Device) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, Device.CREATOR);
                    break;
                case 2:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzaa);
                    break;
                case 5:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzaa);
                    break;
                case 6:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzaa);
                    break;
                case 7:
                    b = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzaa);
                    break;
                case 8:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzaa);
                    break;
                case 9:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, zzaa);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ConnectRequest(i, device, str3, str2, b, j, str, iBinder3, iBinder2, iBinder);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ConnectRequest[] zzhN(int i) {
        return new ConnectRequest[i];
    }
}
