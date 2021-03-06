package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<CameraPosition> {
    static void zza(CameraPosition cameraPosition, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, cameraPosition.getVersionCode());
        zzb.zza(parcel, 2, cameraPosition.target, i, false);
        zzb.zza(parcel, 3, cameraPosition.zoom);
        zzb.zza(parcel, 4, cameraPosition.tilt);
        zzb.zza(parcel, 5, cameraPosition.bearing);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhl(x0);
    }

    public CameraPosition zzeL(Parcel parcel) {
        float f = 0.0f;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        int i = 0;
        LatLng latLng = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (parcel.dataPosition() < zzab) {
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    latLng = (LatLng) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, LatLng.CREATOR);
                    break;
                case 3:
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzaa);
                    break;
                case 4:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzaa);
                    break;
                case 5:
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, zzaa);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CameraPosition(i, latLng, f3, f2, f);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CameraPosition[] zzhl(int i) {
        return new CameraPosition[i];
    }
}
