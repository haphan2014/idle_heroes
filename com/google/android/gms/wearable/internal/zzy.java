package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy implements Creator<DataItemAssetParcelable> {
    static void zza(DataItemAssetParcelable dataItemAssetParcelable, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, dataItemAssetParcelable.zzCY);
        zzb.zza(parcel, 2, dataItemAssetParcelable.getId(), false);
        zzb.zza(parcel, 3, dataItemAssetParcelable.getDataItemKey(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkb(x0);
    }

    public DataItemAssetParcelable zzgT(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new DataItemAssetParcelable(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DataItemAssetParcelable[] zzkb(int i) {
        return new DataItemAssetParcelable[i];
    }
}
