package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzd implements Creator<NearbyAlertFilter> {
    static void zza(NearbyAlertFilter nearbyAlertFilter, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzb(parcel, 1, nearbyAlertFilter.zzazu, false);
        zzb.zzc(parcel, 1000, nearbyAlertFilter.zzCY);
        zzb.zza(parcel, 2, nearbyAlertFilter.zzazs, false);
        zzb.zzc(parcel, 3, nearbyAlertFilter.zzazv, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzep(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgL(x0);
    }

    public NearbyAlertFilter zzep(Parcel parcel) {
        List list = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        List list2 = null;
        List list3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    list3 = zza.zzC(parcel, zzaa);
                    break;
                case 2:
                    list2 = zza.zzB(parcel, zzaa);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzaa, UserDataType.CREATOR);
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
            return new NearbyAlertFilter(i, list3, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public NearbyAlertFilter[] zzgL(int i) {
        return new NearbyAlertFilter[i];
    }
}
