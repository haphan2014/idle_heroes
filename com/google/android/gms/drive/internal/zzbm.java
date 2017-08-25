package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbm implements Creator<RemovePermissionRequest> {
    static void zza(RemovePermissionRequest removePermissionRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, removePermissionRequest.zzCY);
        zzb.zza(parcel, 2, removePermissionRequest.zzacT, i, false);
        zzb.zza(parcel, 3, removePermissionRequest.zzadz, false);
        zzb.zza(parcel, 4, removePermissionRequest.zzaen);
        zzb.zza(parcel, 5, removePermissionRequest.zzadn, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdf(x0);
    }

    public RemovePermissionRequest zzbq(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzab = zza.zzab(parcel);
        String str2 = null;
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new RemovePermissionRequest(i, driveId, str2, z, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public RemovePermissionRequest[] zzdf(int i) {
        return new RemovePermissionRequest[i];
    }
}
