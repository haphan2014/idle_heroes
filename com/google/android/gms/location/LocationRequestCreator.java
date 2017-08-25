package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class LocationRequestCreator implements Creator<LocationRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(LocationRequest locationRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, locationRequest.mPriority);
        zzb.zzc(parcel, 1000, locationRequest.getVersionCode());
        zzb.zza(parcel, 2, locationRequest.zzaxU);
        zzb.zza(parcel, 3, locationRequest.zzaxV);
        zzb.zza(parcel, 4, locationRequest.zzamB);
        zzb.zza(parcel, 5, locationRequest.zzaxz);
        zzb.zzc(parcel, 6, locationRequest.zzaxW);
        zzb.zza(parcel, 7, locationRequest.zzaxX);
        zzb.zza(parcel, 8, locationRequest.zzaxY);
        zzb.zzH(parcel, zzac);
    }

    public LocationRequest createFromParcel(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        int i2 = 102;
        long j = 3600000;
        long j2 = 600000;
        boolean z = false;
        long j3 = Long.MAX_VALUE;
        int i3 = Integer.MAX_VALUE;
        float f = 0.0f;
        long j4 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 5:
                    j3 = zza.zzi(parcel, zzaa);
                    break;
                case 6:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 7:
                    f = zza.zzl(parcel, zzaa);
                    break;
                case 8:
                    j4 = zza.zzi(parcel, zzaa);
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
            return new LocationRequest(i, i2, j, j2, z, j3, i3, f, j4);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public LocationRequest[] newArray(int size) {
        return new LocationRequest[size];
    }
}
