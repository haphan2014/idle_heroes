package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import java.util.List;

public class zzj implements Creator<SessionReadResult> {
    static void zza(SessionReadResult sessionReadResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, sessionReadResult.getSessions(), false);
        zzb.zzc(parcel, 1000, sessionReadResult.getVersionCode());
        zzb.zzc(parcel, 2, sessionReadResult.zzry(), false);
        zzb.zza(parcel, 3, sessionReadResult.getStatus(), i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfi(x0);
    }

    public SessionReadResult zzdn(Parcel parcel) {
        Status status = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        List list = null;
        List list2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    list2 = zza.zzc(parcel, zzaa, Session.CREATOR);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzaa, SessionDataSet.CREATOR);
                    break;
                case 3:
                    status = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
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
            return new SessionReadResult(i, list2, list, status);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SessionReadResult[] zzfi(int i) {
        return new SessionReadResult[i];
    }
}
