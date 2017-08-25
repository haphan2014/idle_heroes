package com.google.android.gms.location.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

public class zzk implements Creator<LocationRequestInternal> {
    static void zza(LocationRequestInternal locationRequestInternal, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, locationRequestInternal.zzamz, i, false);
        zzb.zzc(parcel, 1000, locationRequestInternal.getVersionCode());
        zzb.zza(parcel, 2, locationRequestInternal.zzazb);
        zzb.zza(parcel, 3, locationRequestInternal.zzazc);
        zzb.zza(parcel, 4, locationRequestInternal.zzazd);
        zzb.zzc(parcel, 5, locationRequestInternal.zzaze, false);
        zzb.zza(parcel, 6, locationRequestInternal.mTag, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzek(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgE(x0);
    }

    public LocationRequestInternal zzek(Parcel parcel) {
        String str = null;
        boolean z = true;
        boolean z2 = false;
        int zzab = zza.zzab(parcel);
        List list = LocationRequestInternal.zzaza;
        boolean z3 = true;
        LocationRequest locationRequest = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    locationRequest = (LocationRequest) zza.zza(parcel, zzaa, LocationRequest.CREATOR);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 3:
                    z3 = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 5:
                    list = zza.zzc(parcel, zzaa, ClientIdentity.CREATOR);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzaa);
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
            return new LocationRequestInternal(i, locationRequest, z2, z3, z, list, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public LocationRequestInternal[] zzgE(int i) {
        return new LocationRequestInternal[i];
    }
}
