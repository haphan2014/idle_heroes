package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzl implements Creator<CreateFileRequest> {
    static void zza(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, createFileRequest.zzCY);
        zzb.zza(parcel, 2, createFileRequest.zzaeC, i, false);
        zzb.zza(parcel, 3, createFileRequest.zzaeA, i, false);
        zzb.zza(parcel, 4, createFileRequest.zzaes, i, false);
        zzb.zza(parcel, 5, createFileRequest.zzaeB, false);
        zzb.zza(parcel, 6, createFileRequest.zzaen);
        zzb.zza(parcel, 7, createFileRequest.zzadn, false);
        zzb.zzc(parcel, 8, createFileRequest.zzaeD);
        zzb.zzc(parcel, 9, createFileRequest.zzaeE);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcv(x0);
    }

    public CreateFileRequest zzaK(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        boolean z = false;
        Integer num = null;
        Contents contents = null;
        MetadataBundle metadataBundle = null;
        DriveId driveId = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzaa, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) zza.zza(parcel, zzaa, Contents.CREATOR);
                    break;
                case 5:
                    num = zza.zzh(parcel, zzaa);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 7:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 9:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CreateFileRequest(i3, driveId, metadataBundle, contents, num, z, str, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CreateFileRequest[] zzcv(int i) {
        return new CreateFileRequest[i];
    }
}
