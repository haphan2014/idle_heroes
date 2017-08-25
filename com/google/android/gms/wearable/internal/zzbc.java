package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbc implements Creator<RemoveListenerRequest> {
    static void zza(RemoveListenerRequest removeListenerRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, removeListenerRequest.zzCY);
        zzb.zza(parcel, 2, removeListenerRequest.zzAT(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkv(x0);
    }

    public RemoveListenerRequest zzhn(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new RemoveListenerRequest(i, iBinder);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public RemoveListenerRequest[] zzkv(int i) {
        return new RemoveListenerRequest[i];
    }
}
