package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.Collection;

public class zzc implements Creator<AutocompleteFilter> {
    static void zza(AutocompleteFilter autocompleteFilter, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, autocompleteFilter.zzuE());
        zzb.zzc(parcel, 1000, autocompleteFilter.zzCY);
        zzb.zza(parcel, 2, autocompleteFilter.zzazs, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzeo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgK(x0);
    }

    public AutocompleteFilter zzeo(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        Collection collection = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 2:
                    collection = zza.zzB(parcel, zzaa);
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
            return new AutocompleteFilter(i, z, collection);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public AutocompleteFilter[] zzgK(int i) {
        return new AutocompleteFilter[i];
    }
}
