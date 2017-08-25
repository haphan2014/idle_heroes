package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzi implements Creator<RealtimeDocumentSyncRequest> {
    static void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, realtimeDocumentSyncRequest.zzCY);
        zzb.zzb(parcel, 2, realtimeDocumentSyncRequest.zzadF, false);
        zzb.zzb(parcel, 3, realtimeDocumentSyncRequest.zzadG, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzat(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcc(x0);
    }

    public RealtimeDocumentSyncRequest zzat(Parcel parcel) {
        List list = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        List list2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    list2 = zza.zzC(parcel, zzaa);
                    break;
                case 3:
                    list = zza.zzC(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new RealtimeDocumentSyncRequest(i, list2, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public RealtimeDocumentSyncRequest[] zzcc(int i) {
        return new RealtimeDocumentSyncRequest[i];
    }
}
