package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class LocationAvailabilityCreator implements Creator<LocationAvailability> {
    public static final int CONTENT_DESCRIPTION = 0;

    static void zza(LocationAvailability locationAvailability, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, locationAvailability.zzaxQ);
        zzb.zzc(parcel, 1000, locationAvailability.getVersionCode());
        zzb.zzc(parcel, 2, locationAvailability.zzaxR);
        zzb.zza(parcel, 3, locationAvailability.zzaxS);
        zzb.zzc(parcel, 4, locationAvailability.zzaxT);
        zzb.zzH(parcel, zzac);
    }

    public LocationAvailability createFromParcel(Parcel parcel) {
        int i = 1;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        int i3 = 1000;
        long j = 0;
        int i4 = 1;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i4 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 4:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LocationAvailability(i2, i3, i4, i, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public LocationAvailability[] newArray(int size) {
        return new LocationAvailability[size];
    }
}
