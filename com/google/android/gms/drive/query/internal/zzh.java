package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<FullTextSearchFilter> {
    static void zza(FullTextSearchFilter fullTextSearchFilter, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1000, fullTextSearchFilter.zzCY);
        zzb.zza(parcel, 1, fullTextSearchFilter.mValue, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbL(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdA(x0);
    }

    public FullTextSearchFilter zzbL(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
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
            return new FullTextSearchFilter(i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public FullTextSearchFilter[] zzdA(int i) {
        return new FullTextSearchFilter[i];
    }
}
