package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbg implements Creator<OnSyncMoreResponse> {
    static void zza(OnSyncMoreResponse onSyncMoreResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, onSyncMoreResponse.zzCY);
        zzb.zza(parcel, 2, onSyncMoreResponse.zzaeL);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbl(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzda(x0);
    }

    public OnSyncMoreResponse zzbl(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new OnSyncMoreResponse(i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public OnSyncMoreResponse[] zzda(int i) {
        return new OnSyncMoreResponse[i];
    }
}
