package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.List;

public class zzb implements Creator<GestureRequest> {
    static void zza(GestureRequest gestureRequest, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, gestureRequest.zzuo(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, gestureRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzed(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgt(x0);
    }

    public GestureRequest zzed(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    list = zza.zzB(parcel, zzaa);
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
            return new GestureRequest(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GestureRequest[] zzgt(int i) {
        return new GestureRequest[i];
    }
}
