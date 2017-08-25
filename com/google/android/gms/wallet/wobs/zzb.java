package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<LabelValue> {
    static void zza(LabelValue labelValue, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, labelValue.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, labelValue.label, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, labelValue.value, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjE(x0);
    }

    public LabelValue zzgz(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LabelValue(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public LabelValue[] zzjE(int i) {
        return new LabelValue[i];
    }
}
