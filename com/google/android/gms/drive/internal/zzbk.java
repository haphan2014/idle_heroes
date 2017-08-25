package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.query.Query;

public class zzbk implements Creator<QueryRequest> {
    static void zza(QueryRequest queryRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, queryRequest.zzCY);
        zzb.zza(parcel, 2, queryRequest.zzagu, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdd(x0);
    }

    public QueryRequest zzbo(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    query = (Query) zza.zza(parcel, zzaa, Query.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new QueryRequest(i, query);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public QueryRequest[] zzdd(int i) {
        return new QueryRequest[i];
    }
}
