package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<DriveId> {
    static void zza(DriveId driveId, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, driveId.zzCY);
        zzb.zza(parcel, 2, driveId.zzadd, false);
        zzb.zza(parcel, 3, driveId.zzade);
        zzb.zza(parcel, 4, driveId.zzacO);
        zzb.zzc(parcel, 5, driveId.zzadf);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzap(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbU(x0);
    }

    public DriveId zzap(Parcel parcel) {
        long j = 0;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        int i2 = -1;
        long j2 = 0;
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
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 4:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new DriveId(i, str, j2, j, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DriveId[] zzbU(int i) {
        return new DriveId[i];
    }
}
