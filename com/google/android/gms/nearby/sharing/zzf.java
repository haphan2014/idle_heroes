package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<ViewableItem> {
    static void zza(ViewableItem viewableItem, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, viewableItem.getVersionCode());
        zzb.zza(parcel, 2, viewableItem.zzxg(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zziq(x0);
    }

    public ViewableItem zzfB(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        String[] strArr = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    strArr = zza.zzA(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ViewableItem(i, strArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ViewableItem[] zziq(int i) {
        return new ViewableItem[i];
    }
}
