package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.List;

public class zzc implements Creator<DataReadResult> {
    static void zza(DataReadResult dataReadResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzd(parcel, 1, dataReadResult.zzrv(), false);
        zzb.zzc(parcel, 1000, dataReadResult.getVersionCode());
        zzb.zza(parcel, 2, dataReadResult.getStatus(), i, false);
        zzb.zzd(parcel, 3, dataReadResult.zzru(), false);
        zzb.zzc(parcel, 5, dataReadResult.zzrt());
        zzb.zzc(parcel, 6, dataReadResult.zzqA(), false);
        zzb.zzc(parcel, 7, dataReadResult.zzrw(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfb(x0);
    }

    public DataReadResult zzdg(Parcel parcel) {
        int i = 0;
        List list = null;
        int zzab = zza.zzab(parcel);
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        List list2 = null;
        Status status = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    zza.zza(parcel, zzaa, arrayList, getClass().getClassLoader());
                    break;
                case 2:
                    status = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    break;
                case 3:
                    zza.zza(parcel, zzaa, arrayList2, getClass().getClassLoader());
                    break;
                case 5:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 6:
                    list2 = zza.zzc(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 7:
                    list = zza.zzc(parcel, zzaa, DataType.CREATOR);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new DataReadResult(i2, arrayList, status, arrayList2, i, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DataReadResult[] zzfb(int i) {
        return new DataReadResult[i];
    }
}
