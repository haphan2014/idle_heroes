package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<CameraUpdateParcelable> {
    static void zza(CameraUpdateParcelable cameraUpdateParcelable, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, cameraUpdateParcelable.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, cameraUpdateParcelable.getType());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, cameraUpdateParcelable.getParameters(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzhB(x0);
    }

    public CameraUpdateParcelable zzfb(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        Bundle bundle = null;
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
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CameraUpdateParcelable(i2, i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CameraUpdateParcelable[] zzhB(int i) {
        return new CameraUpdateParcelable[i];
    }
}
