package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<InstrumentInfo> {
    static void zza(InstrumentInfo instrumentInfo, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, instrumentInfo.getVersionCode());
        zzb.zza(parcel, 2, instrumentInfo.getInstrumentType(), false);
        zzb.zza(parcel, 3, instrumentInfo.getInstrumentDetails(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjj(x0);
    }

    public InstrumentInfo zzgh(Parcel parcel) {
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
            return new InstrumentInfo(i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public InstrumentInfo[] zzjj(int i) {
        return new InstrumentInfo[i];
    }
}
