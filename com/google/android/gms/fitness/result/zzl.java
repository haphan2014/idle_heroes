package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<SyncInfoResult> {
    static void zza(SyncInfoResult syncInfoResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, syncInfoResult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, syncInfoResult.getVersionCode());
        zzb.zza(parcel, 2, syncInfoResult.zzrz());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfk(x0);
    }

    public SyncInfoResult zzdp(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        Status status = null;
        long j = 0;
        while (parcel.dataPosition() < zzab) {
            Status status2;
            int i2;
            long j2;
            int zzaa = zza.zzaa(parcel);
            long j3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    j3 = j;
                    status2 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    i2 = i;
                    j2 = j3;
                    break;
                case 2:
                    j2 = zza.zzi(parcel, zzaa);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    j3 = j;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzaa);
                    j2 = j3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    j2 = j;
                    status2 = status;
                    i2 = i;
                    break;
            }
            status = status2;
            i = i2;
            j = j2;
        }
        if (parcel.dataPosition() == zzab) {
            return new SyncInfoResult(i, status, j);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SyncInfoResult[] zzfk(int i) {
        return new SyncInfoResult[i];
    }
}
