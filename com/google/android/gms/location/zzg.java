package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzg implements Creator<LocationSettingsRequest> {
    static void zza(LocationSettingsRequest locationSettingsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, locationSettingsRequest.zzrj(), false);
        zzb.zzc(parcel, 1000, locationSettingsRequest.getVersionCode());
        zzb.zza(parcel, 2, locationSettingsRequest.zzup());
        zzb.zza(parcel, 3, locationSettingsRequest.zzuq());
        zzb.zza(parcel, 4, locationSettingsRequest.zzur());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzef(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgx(x0);
    }

    public LocationSettingsRequest zzef(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        List list = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    list = zza.zzc(parcel, zzaa, LocationRequest.CREATOR);
                    break;
                case 2:
                    z3 = zza.zzc(parcel, zzaa);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzaa);
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
            return new LocationSettingsRequest(i, list, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public LocationSettingsRequest[] zzgx(int i) {
        return new LocationSettingsRequest[i];
    }
}
