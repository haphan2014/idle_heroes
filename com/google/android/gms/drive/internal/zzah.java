package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzah implements Creator<GetMetadataRequest> {
    static void zza(GetMetadataRequest getMetadataRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getMetadataRequest.zzCY);
        zzb.zza(parcel, 2, getMetadataRequest.zzaeq, i, false);
        zzb.zza(parcel, 3, getMetadataRequest.zzafN);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaT(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcI(x0);
    }

    public GetMetadataRequest zzaT(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        DriveId driveId = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            DriveId driveId2;
            int zzg;
            boolean z2;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    boolean z3 = z;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzaa);
                    z2 = z3;
                    break;
                case 2:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    z2 = z;
                    driveId2 = driveId3;
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzaa);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    z2 = z;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            z = z2;
        }
        if (parcel.dataPosition() == zzab) {
            return new GetMetadataRequest(i, driveId, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GetMetadataRequest[] zzcI(int i) {
        return new GetMetadataRequest[i];
    }
}
