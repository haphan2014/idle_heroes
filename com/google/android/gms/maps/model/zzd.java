package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<LatLngBounds> {
    static void zza(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, latLngBounds.getVersionCode());
        zzb.zza(parcel, 2, latLngBounds.southwest, i, false);
        zzb.zza(parcel, 3, latLngBounds.northeast, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzho(x0);
    }

    public LatLngBounds zzeO(Parcel parcel) {
        LatLng latLng = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzg;
            LatLng latLng3;
            int zzaa = zza.zzaa(parcel);
            LatLng latLng4;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    latLng4 = latLng;
                    latLng = latLng2;
                    zzg = zza.zzg(parcel, zzaa);
                    latLng3 = latLng4;
                    break;
                case 2:
                    zzg = i;
                    latLng4 = (LatLng) zza.zza(parcel, zzaa, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case 3:
                    latLng3 = (LatLng) zza.zza(parcel, zzaa, LatLng.CREATOR);
                    latLng = latLng2;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    latLng3 = latLng;
                    latLng = latLng2;
                    zzg = i;
                    break;
            }
            i = zzg;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == zzab) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public LatLngBounds[] zzho(int i) {
        return new LatLngBounds[i];
    }
}
