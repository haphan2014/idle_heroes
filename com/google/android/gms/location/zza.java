package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.List;

public class zza implements Creator<GeofencingRequest> {
    static void zza(GeofencingRequest geofencingRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, geofencingRequest.zzun(), false);
        zzb.zzc(parcel, 1000, geofencingRequest.getVersionCode());
        zzb.zzc(parcel, 2, geofencingRequest.getInitialTrigger());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzec(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgs(x0);
    }

    public GeofencingRequest zzec(Parcel parcel) {
        int i = 0;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzaa, ParcelableGeofence.CREATOR);
                    break;
                case 2:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 1000:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GeofencingRequest(i2, list, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GeofencingRequest[] zzgs(int i) {
        return new GeofencingRequest[i];
    }
}
