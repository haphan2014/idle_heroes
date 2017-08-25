package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<ChangesAvailableEvent> {
    static void zza(ChangesAvailableEvent changesAvailableEvent, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, changesAvailableEvent.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, changesAvailableEvent.zzOx, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, changesAvailableEvent.zzadO, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaw(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcf(x0);
    }

    public ChangesAvailableEvent zzaw(Parcel parcel) {
        ChangesAvailableOptions changesAvailableOptions = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    changesAvailableOptions = (ChangesAvailableOptions) zza.zza(parcel, zzaa, ChangesAvailableOptions.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ChangesAvailableEvent(i, str, changesAvailableOptions);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ChangesAvailableEvent[] zzcf(int i) {
        return new ChangesAvailableEvent[i];
    }
}
