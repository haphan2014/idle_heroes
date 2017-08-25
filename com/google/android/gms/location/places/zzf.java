package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzf implements Creator<PlaceFilter> {
    static void zza(PlaceFilter placeFilter, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, placeFilter.zzazs, false);
        zzb.zzc(parcel, 1000, placeFilter.zzCY);
        zzb.zza(parcel, 3, placeFilter.zzazC);
        zzb.zzc(parcel, 4, placeFilter.zzazv, false);
        zzb.zzb(parcel, 6, placeFilter.zzazu, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzer(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgN(x0);
    }

    public PlaceFilter zzer(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzab = zza.zzab(parcel);
        List list2 = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    list3 = zza.zzB(parcel, zzaa);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzaa, UserDataType.CREATOR);
                    break;
                case 6:
                    list2 = zza.zzC(parcel, zzaa);
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
            return new PlaceFilter(i, list3, z, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public PlaceFilter[] zzgN(int i) {
        return new PlaceFilter[i];
    }
}
