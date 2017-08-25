package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<NotFilter> {
    static void zza(NotFilter notFilter, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1000, notFilter.zzCY);
        zzb.zza(parcel, 1, notFilter.zzaig, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdF(x0);
    }

    public NotFilter zzbQ(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    filterHolder = (FilterHolder) zza.zza(parcel, zzaa, FilterHolder.CREATOR);
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
            return new NotFilter(i, filterHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public NotFilter[] zzdF(int i) {
        return new NotFilter[i];
    }
}
