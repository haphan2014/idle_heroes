package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<ReadRawResult> {
    static void zza(ReadRawResult readRawResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, readRawResult.zzpx(), i, false);
        zzb.zzc(parcel, 1000, readRawResult.getVersionCode());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdm(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfh(x0);
    }

    public ReadRawResult zzdm(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    dataHolder = (DataHolder) zza.zza(parcel, zzaa, DataHolder.CREATOR);
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
            return new ReadRawResult(i, dataHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ReadRawResult[] zzfh(int i) {
        return new ReadRawResult[i];
    }
}
