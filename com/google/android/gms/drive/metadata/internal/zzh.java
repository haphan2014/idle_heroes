package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<MetadataBundle> {
    static void zza(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, metadataBundle.zzCY);
        zzb.zza(parcel, 2, metadataBundle.zzagI, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbC(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdr(x0);
    }

    public MetadataBundle zzbC(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new MetadataBundle(i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public MetadataBundle[] zzdr(int i) {
        return new MetadataBundle[i];
    }
}
