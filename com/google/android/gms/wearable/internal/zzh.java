package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzh implements Creator<CapabilityInfoParcelable> {
    static void zza(CapabilityInfoParcelable capabilityInfoParcelable, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, capabilityInfoParcelable.zzCY);
        zzb.zza(parcel, 2, capabilityInfoParcelable.getName(), false);
        zzb.zzc(parcel, 3, capabilityInfoParcelable.zzBa(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgN(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjS(x0);
    }

    public CapabilityInfoParcelable zzgN(Parcel parcel) {
        List list = null;
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
                    list = zza.zzc(parcel, zzaa, NodeParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CapabilityInfoParcelable(i, str, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CapabilityInfoParcelable[] zzjS(int i) {
        return new CapabilityInfoParcelable[i];
    }
}
