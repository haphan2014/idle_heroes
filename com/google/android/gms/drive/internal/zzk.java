package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzk implements Creator<CreateFileIntentSenderRequest> {
    static void zza(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, createFileIntentSenderRequest.zzCY);
        zzb.zza(parcel, 2, createFileIntentSenderRequest.zzaeA, i, false);
        zzb.zzc(parcel, 3, createFileIntentSenderRequest.zzacR);
        zzb.zza(parcel, 4, createFileIntentSenderRequest.zzadv, false);
        zzb.zza(parcel, 5, createFileIntentSenderRequest.zzady, i, false);
        zzb.zza(parcel, 6, createFileIntentSenderRequest.zzaeB, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaJ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcu(x0);
    }

    public CreateFileIntentSenderRequest zzaJ(Parcel parcel) {
        int i = 0;
        Integer num = null;
        int zzab = zza.zzab(parcel);
        DriveId driveId = null;
        String str = null;
        MetadataBundle metadataBundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzaa, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    driveId = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    break;
                case 6:
                    num = zza.zzh(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CreateFileIntentSenderRequest(i2, metadataBundle, i, str, driveId, num);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CreateFileIntentSenderRequest[] zzcu(int i) {
        return new CreateFileIntentSenderRequest[i];
    }
}
