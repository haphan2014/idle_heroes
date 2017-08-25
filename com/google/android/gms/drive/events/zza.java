package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zza implements Creator<ChangeEvent> {
    static void zza(ChangeEvent changeEvent, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, changeEvent.zzCY);
        zzb.zza(parcel, 2, changeEvent.zzacT, i, false);
        zzb.zzc(parcel, 3, changeEvent.zzadN);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzav(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzce(x0);
    }

    public ChangeEvent zzav(Parcel parcel) {
        int i = 0;
        int zzab = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel);
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            DriveId driveId2;
            int zzg;
            int zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbA(zzaa)) {
                case 1:
                    int i3 = i;
                    driveId2 = driveId;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    zzaa = i3;
                    break;
                case 2:
                    zzg = i2;
                    DriveId driveId3 = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzaa, DriveId.CREATOR);
                    zzaa = i;
                    driveId2 = driveId3;
                    break;
                case 3:
                    zzaa = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzaa);
                    driveId2 = driveId;
                    zzg = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzaa);
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
            return new ChangeEvent(i2, driveId, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ChangeEvent[] zzce(int i) {
        return new ChangeEvent[i];
    }
}
