package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbl implements Creator<RemoveEventListenerRequest> {
    static void zza(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, removeEventListenerRequest.zzCY);
        zzb.zza(parcel, 2, removeEventListenerRequest.zzacT, i, false);
        zzb.zzc(parcel, 3, removeEventListenerRequest.zzaca);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbp(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzde(x0);
    }

    public RemoveEventListenerRequest zzbp(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            DriveId driveId2;
            int zzg;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzaa);
                    zzaa = i3;
                    break;
                case 2:
                    zzg = i2;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    zzaa = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    zzaa = zza.zzg(parcel, zzaa);
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzaa = i;
                    driveId2 = driveId;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            driveId = driveId2;
            i = zzaa;
        }
        if (parcel.dataPosition() == zzab) {
            return new RemoveEventListenerRequest(i2, driveId, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public RemoveEventListenerRequest[] zzde(int i) {
        return new RemoveEventListenerRequest[i];
    }
}
