package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<VersionInfoParcel> {
    static void zza(VersionInfoParcel versionInfoParcel, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, versionInfoParcel.versionCode);
        zzb.zza(parcel, 2, versionInfoParcel.zzGG, false);
        zzb.zzc(parcel, 3, versionInfoParcel.zzGH);
        zzb.zzc(parcel, 4, versionInfoParcel.zzGI);
        zzb.zza(parcel, 5, versionInfoParcel.zzGJ);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzM(x0);
    }

    public VersionInfoParcel[] zzM(int i) {
        return new VersionInfoParcel[i];
    }

    public VersionInfoParcel zzp(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new VersionInfoParcel(i3, str, i2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }
}
