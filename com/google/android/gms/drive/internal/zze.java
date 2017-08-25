package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zze implements Creator<CancelPendingActionsRequest> {
    static void zza(CancelPendingActionsRequest cancelPendingActionsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, cancelPendingActionsRequest.zzCY);
        zzb.zzb(parcel, 2, cancelPendingActionsRequest.zzadW, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzco(x0);
    }

    public CancelPendingActionsRequest zzaE(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    list = zza.zzC(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CancelPendingActionsRequest(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CancelPendingActionsRequest[] zzco(int i) {
        return new CancelPendingActionsRequest[i];
    }
}
