package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Session;
import java.util.ArrayList;
import java.util.List;

public class zzk implements Creator<SessionStopResult> {
    static void zza(SessionStopResult sessionStopResult, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1000, sessionStopResult.getVersionCode());
        zzb.zza(parcel, 2, sessionStopResult.getStatus(), i, false);
        zzb.zzc(parcel, 3, sessionStopResult.getSessions(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzfj(x0);
    }

    public SessionStopResult zzdo(Parcel parcel) {
        List list = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        Status status = null;
        while (parcel.dataPosition() < zzab) {
            int i2;
            Status status2;
            ArrayList zzc;
            int zzaa = zza.zzaa(parcel);
            List list2;
            switch (zza.zzbA(zzaa)) {
                case 2:
                    i2 = i;
                    Status status3 = (Status) zza.zza(parcel, zzaa, Status.CREATOR);
                    list2 = list;
                    status2 = status3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzaa, Session.CREATOR);
                    status2 = status;
                    i2 = i;
                    break;
                case 1000:
                    List list3 = list;
                    status2 = status;
                    i2 = zza.zzg(parcel, zzaa);
                    list2 = list3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzc = list;
                    status2 = status;
                    i2 = i;
                    break;
            }
            i = i2;
            status = status2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzab) {
            return new SessionStopResult(i, status, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SessionStopResult[] zzfj(int i) {
        return new SessionStopResult[i];
    }
}
