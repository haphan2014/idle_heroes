package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

public class zzd implements Creator<DataSourceStatsResult> {
    static void zza(DataSourceStatsResult dataSourceStatsResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, dataSourceStatsResult.zzajG, i, false);
        zzb.zzc(parcel, 1000, dataSourceStatsResult.zzCY);
        zzb.zza(parcel, 2, dataSourceStatsResult.zzOw);
        zzb.zza(parcel, 3, dataSourceStatsResult.zzamS);
        zzb.zza(parcel, 4, dataSourceStatsResult.zzamT);
        zzb.zza(parcel, 5, dataSourceStatsResult.zzamU);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfc(x0);
    }

    public DataSourceStatsResult zzdh(Parcel parcel) {
        boolean z = false;
        long j = 0;
        int zzab = zza.zzab(parcel);
        DataSource dataSource = null;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzaa, DataSource.CREATOR);
                    break;
                case 2:
                    j3 = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzaa);
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
            return new DataSourceStatsResult(i, dataSource, j3, z, j2, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DataSourceStatsResult[] zzfc(int i) {
        return new DataSourceStatsResult[i];
    }
}
