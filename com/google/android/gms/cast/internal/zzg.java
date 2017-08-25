package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<DeviceStatus> {
    static void zza(DeviceStatus deviceStatus, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, deviceStatus.getVersionCode());
        zzb.zza(parcel, 2, deviceStatus.zzlO());
        zzb.zza(parcel, 3, deviceStatus.zzlX());
        zzb.zzc(parcel, 4, deviceStatus.zzlP());
        zzb.zza(parcel, 5, deviceStatus.getApplicationMetadata(), i, false);
        zzb.zzc(parcel, 6, deviceStatus.zzlQ());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzaQ(x0);
    }

    public DeviceStatus zzN(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        double d = 0.0d;
        ApplicationMetadata applicationMetadata = null;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    d = zza.zzm(parcel, zzaa);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) zza.zza(parcel, zzaa, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new DeviceStatus(i3, d, z, i2, applicationMetadata, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DeviceStatus[] zzaQ(int i) {
        return new DeviceStatus[i];
    }
}
