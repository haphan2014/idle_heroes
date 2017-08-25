package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<MarkerOptionsParcelable> {
    static void zza(MarkerOptionsParcelable markerOptionsParcelable, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, markerOptionsParcelable.getVersionCode());
        zzb.zza(parcel, 2, markerOptionsParcelable.zzvO(), i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhE(x0);
    }

    public MarkerOptionsParcelable zzfd(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        BitmapDescriptorParcelable bitmapDescriptorParcelable = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    bitmapDescriptorParcelable = (BitmapDescriptorParcelable) zza.zza(parcel, zzaa, BitmapDescriptorParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new MarkerOptionsParcelable(i, bitmapDescriptorParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public MarkerOptionsParcelable[] zzhE(int i) {
        return new MarkerOptionsParcelable[i];
    }
}
