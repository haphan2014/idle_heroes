package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<LatLng> {
    static void zza(LatLng latLng, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, latLng.getVersionCode());
        zzb.zza(parcel, 2, latLng.latitude);
        zzb.zza(parcel, 3, latLng.longitude);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhp(x0);
    }

    public LatLng zzeP(Parcel parcel) {
        double d = 0.0d;
        int zzab = zza.zzab(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    d2 = zza.zzm(parcel, zzaa);
                    break;
                case 3:
                    d = zza.zzm(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LatLng(i, d2, d);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public LatLng[] zzhp(int i) {
        return new LatLng[i];
    }
}
