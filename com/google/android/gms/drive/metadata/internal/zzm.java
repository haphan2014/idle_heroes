package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<PartialDriveId> {
    static void zza(PartialDriveId partialDriveId, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, partialDriveId.zzCY);
        zzb.zza(parcel, 2, partialDriveId.zzadd, false);
        zzb.zza(parcel, 3, partialDriveId.zzade);
        zzb.zzc(parcel, 4, partialDriveId.zzadf);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbE(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdt(x0);
    }

    public PartialDriveId zzbE(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        long j = 0;
        int i2 = -1;
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
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PartialDriveId(i, str, j, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public PartialDriveId[] zzdt(int i) {
        return new PartialDriveId[i];
    }
}
