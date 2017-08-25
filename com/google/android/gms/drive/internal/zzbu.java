package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzbu implements Creator<UpdateMetadataRequest> {
    static void zza(UpdateMetadataRequest updateMetadataRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, updateMetadataRequest.zzCY);
        zzb.zza(parcel, 2, updateMetadataRequest.zzaeq, i, false);
        zzb.zza(parcel, 3, updateMetadataRequest.zzaer, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdm(x0);
    }

    public UpdateMetadataRequest zzbx(Parcel parcel) {
        MetadataBundle metadataBundle = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzab) {
            DriveId driveId2;
            int zzg;
            MetadataBundle metadataBundle2;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    MetadataBundle metadataBundle3 = metadataBundle;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzaa);
                    metadataBundle2 = metadataBundle3;
                    break;
                case 2:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId3;
                    break;
                case 3:
                    metadataBundle2 = (MetadataBundle) zza.zza(parcel, zzaa, MetadataBundle.CREATOR);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    metadataBundle2 = metadataBundle;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            metadataBundle = metadataBundle2;
        }
        if (parcel.dataPosition() == zzab) {
            return new UpdateMetadataRequest(i, driveId, metadataBundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public UpdateMetadataRequest[] zzdm(int i) {
        return new UpdateMetadataRequest[i];
    }
}
