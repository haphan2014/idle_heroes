package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzh implements Creator<PolylineOptions> {
    static void zza(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, polylineOptions.getVersionCode());
        zzb.zzc(parcel, 2, polylineOptions.getPoints(), false);
        zzb.zza(parcel, 3, polylineOptions.getWidth());
        zzb.zzc(parcel, 4, polylineOptions.getColor());
        zzb.zza(parcel, 5, polylineOptions.getZIndex());
        zzb.zza(parcel, 6, polylineOptions.isVisible());
        zzb.zza(parcel, 7, polylineOptions.isGeodesic());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhs(x0);
    }

    public PolylineOptions zzeS(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        List list = null;
        boolean z2 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzaa, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = zza.zzl(parcel, zzaa);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    f = zza.zzl(parcel, zzaa);
                    break;
                case 6:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PolylineOptions(i2, list, f2, i, f, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public PolylineOptions[] zzhs(int i) {
        return new PolylineOptions[i];
    }
}
