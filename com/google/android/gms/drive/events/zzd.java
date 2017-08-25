package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;

public class zzd implements Creator<ChangesAvailableOptions> {
    static void zza(ChangesAvailableOptions changesAvailableOptions, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, changesAvailableOptions.zzCY);
        zzb.zzc(parcel, 2, changesAvailableOptions.zzadP);
        zzb.zza(parcel, 3, changesAvailableOptions.zzadQ);
        zzb.zzc(parcel, 4, changesAvailableOptions.zzadR, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzax(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcg(x0);
    }

    public ChangesAvailableOptions zzax(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        List list = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    list = zza.zzc(parcel, zzaa, DriveSpace.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ChangesAvailableOptions(i2, i, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ChangesAvailableOptions[] zzcg(int i) {
        return new ChangesAvailableOptions[i];
    }
}
