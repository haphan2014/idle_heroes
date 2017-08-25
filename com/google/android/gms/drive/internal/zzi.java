package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveFile;

public class zzi implements Creator<CreateContentsRequest> {
    static void zza(CreateContentsRequest createContentsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, createContentsRequest.zzCY);
        zzb.zzc(parcel, 2, createContentsRequest.zzacS);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaI(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcs(x0);
    }

    public CreateContentsRequest zzaI(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        int i2 = DriveFile.MODE_WRITE_ONLY;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new CreateContentsRequest(i, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CreateContentsRequest[] zzcs(int i) {
        return new CreateContentsRequest[i];
    }
}
