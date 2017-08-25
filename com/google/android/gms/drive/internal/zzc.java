package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzc implements Creator<AuthorizeAccessRequest> {
    static void zza(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, authorizeAccessRequest.zzCY);
        zzb.zza(parcel, 2, authorizeAccessRequest.zzaeo);
        zzb.zza(parcel, 3, authorizeAccessRequest.zzacT, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaD(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcn(x0);
    }

    public AuthorizeAccessRequest zzaD(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 3:
                    driveId = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public AuthorizeAccessRequest[] zzcn(int i) {
        return new AuthorizeAccessRequest[i];
    }
}
