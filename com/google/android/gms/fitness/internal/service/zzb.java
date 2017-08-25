package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.DataSource;

public class zzb implements Creator<FitnessUnregistrationRequest> {
    static void zza(FitnessUnregistrationRequest fitnessUnregistrationRequest, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, fitnessUnregistrationRequest.getDataSource(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, fitnessUnregistrationRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzcA(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeu(x0);
    }

    public FitnessUnregistrationRequest zzcA(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        DataSource dataSource = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    dataSource = (DataSource) zza.zza(parcel, zzaa, DataSource.CREATOR);
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
            return new FitnessUnregistrationRequest(i, dataSource);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public FitnessUnregistrationRequest[] zzeu(int i) {
        return new FitnessUnregistrationRequest[i];
    }
}
