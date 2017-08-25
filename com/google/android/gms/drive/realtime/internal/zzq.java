package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Creator<ParcelableIndexReference> {
    static void zza(ParcelableIndexReference parcelableIndexReference, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, parcelableIndexReference.zzCY);
        zzb.zza(parcel, 2, parcelableIndexReference.zzaiw, false);
        zzb.zzc(parcel, 3, parcelableIndexReference.mIndex);
        zzb.zza(parcel, 4, parcelableIndexReference.zzaix);
        zzb.zzc(parcel, 5, parcelableIndexReference.zzaiy);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbW(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdM(x0);
    }

    public ParcelableIndexReference zzbW(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        String str = null;
        int i = -1;
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
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ParcelableIndexReference(i3, str, i2, z, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ParcelableIndexReference[] zzdM(int i) {
        return new ParcelableIndexReference[i];
    }
}
