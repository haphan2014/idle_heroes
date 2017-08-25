package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzo implements Creator<RawDataSet> {
    static void zza(RawDataSet rawDataSet, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, rawDataSet.zzakH);
        zzb.zzc(parcel, 1000, rawDataSet.zzCY);
        zzb.zzc(parcel, 2, rawDataSet.zzakJ);
        zzb.zzc(parcel, 3, rawDataSet.zzakK, false);
        zzb.zza(parcel, 4, rawDataSet.zzajU);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzen(x0);
    }

    public RawDataSet zzcu(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        List list = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzaa, RawDataPoint.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 1000:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new RawDataSet(i3, i2, i, list, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public RawDataSet[] zzen(int i) {
        return new RawDataSet[i];
    }
}
