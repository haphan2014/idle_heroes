package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzg implements Creator<CloseContentsAndUpdateMetadataRequest> {
    static void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, closeContentsAndUpdateMetadataRequest.zzCY);
        zzb.zza(parcel, 2, closeContentsAndUpdateMetadataRequest.zzaeq, i, false);
        zzb.zza(parcel, 3, closeContentsAndUpdateMetadataRequest.zzaer, i, false);
        zzb.zza(parcel, 4, closeContentsAndUpdateMetadataRequest.zzaes, i, false);
        zzb.zza(parcel, 5, closeContentsAndUpdateMetadataRequest.zzado);
        zzb.zza(parcel, 6, closeContentsAndUpdateMetadataRequest.zzadn, false);
        zzb.zzc(parcel, 7, closeContentsAndUpdateMetadataRequest.zzaet);
        zzb.zzc(parcel, 8, closeContentsAndUpdateMetadataRequest.zzaeu);
        zzb.zza(parcel, 9, closeContentsAndUpdateMetadataRequest.zzaev);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcq(x0);
    }

    public CloseContentsAndUpdateMetadataRequest zzaG(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzab = zza.zzab(parcel);
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
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
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 6:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 8:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CloseContentsAndUpdateMetadataRequest(i3, driveId, metadataBundle, contents, z2, str, i2, i, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CloseContentsAndUpdateMetadataRequest[] zzcq(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }
}
