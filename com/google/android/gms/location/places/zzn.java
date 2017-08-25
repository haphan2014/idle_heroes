package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Creator<UserDataType> {
    static void zza(UserDataType userDataType, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, userDataType.zzEl, false);
        zzb.zzc(parcel, 1000, userDataType.zzCY);
        zzb.zzc(parcel, 2, userDataType.zzaAd);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzew(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzgV(x0);
    }

    public UserDataType zzew(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 1000:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new UserDataType(i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public UserDataType[] zzgV(int i) {
        return new UserDataType[i];
    }
}
