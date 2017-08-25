package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbv implements Creator<UpdatePermissionRequest> {
    static void zza(UpdatePermissionRequest updatePermissionRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, updatePermissionRequest.zzCY);
        zzb.zza(parcel, 2, updatePermissionRequest.zzacT, i, false);
        zzb.zza(parcel, 3, updatePermissionRequest.zzadz, false);
        zzb.zzc(parcel, 4, updatePermissionRequest.zzagx);
        zzb.zza(parcel, 5, updatePermissionRequest.zzaen);
        zzb.zza(parcel, 6, updatePermissionRequest.zzadn, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzby(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdn(x0);
    }

    public UpdatePermissionRequest zzby(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str2 = null;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new UpdatePermissionRequest(i2, driveId, str2, i, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public UpdatePermissionRequest[] zzdn(int i) {
        return new UpdatePermissionRequest[i];
    }
}
