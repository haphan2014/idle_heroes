package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<Device> {
    static void zza(Device device, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, device.getManufacturer(), false);
        zzb.zzc(parcel, 1000, device.getVersionCode());
        zzb.zza(parcel, 2, device.getModel(), false);
        zzb.zza(parcel, 3, device.getVersion(), false);
        zzb.zza(parcel, 4, device.zzqG(), false);
        zzb.zzc(parcel, 5, device.getType());
        zzb.zzc(parcel, 6, device.zzqE());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzei(x0);
    }

    public Device zzcp(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new Device(i3, str4, str3, str2, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public Device[] zzei(int i) {
        return new Device[i];
    }
}
