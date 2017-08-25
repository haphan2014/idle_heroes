package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzay implements Creator<NodeParcelable> {
    static void zza(NodeParcelable nodeParcelable, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, nodeParcelable.zzCY);
        zzb.zza(parcel, 2, nodeParcelable.getId(), false);
        zzb.zza(parcel, 3, nodeParcelable.getDisplayName(), false);
        zzb.zzc(parcel, 4, nodeParcelable.getHopCount());
        zzb.zza(parcel, 5, nodeParcelable.isNearby());
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkr(x0);
    }

    public NodeParcelable zzhj(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
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
            return new NodeParcelable(i2, str2, str, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public NodeParcelable[] zzkr(int i) {
        return new NodeParcelable[i];
    }
}
