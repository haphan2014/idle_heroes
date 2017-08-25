package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<NearbyAlertRequest> {
    static void zza(NearbyAlertRequest nearbyAlertRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, nearbyAlertRequest.zzuC());
        zzb.zzc(parcel, 1000, nearbyAlertRequest.getVersionCode());
        zzb.zzc(parcel, 2, nearbyAlertRequest.zzuF());
        zzb.zza(parcel, 3, nearbyAlertRequest.zzuG(), i, false);
        zzb.zza(parcel, 4, nearbyAlertRequest.zzuH(), i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgM(x0);
    }

    public NearbyAlertRequest zzeq(Parcel parcel) {
        NearbyAlertFilter nearbyAlertFilter = null;
        int i = 0;
        int zzab = zza.zzab(parcel);
        int i2 = -1;
        PlaceFilter placeFilter = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    placeFilter = (PlaceFilter) zza.zza(parcel, zzaa, PlaceFilter.CREATOR);
                    break;
                case 4:
                    nearbyAlertFilter = (NearbyAlertFilter) zza.zza(parcel, zzaa, NearbyAlertFilter.CREATOR);
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
            return new NearbyAlertRequest(i3, i, i2, placeFilter, nearbyAlertFilter);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public NearbyAlertRequest[] zzgM(int i) {
        return new NearbyAlertRequest[i];
    }
}
