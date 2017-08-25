package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzh implements Creator<ProgressEvent> {
    static void zza(ProgressEvent progressEvent, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, progressEvent.zzCY);
        zzb.zza(parcel, 2, progressEvent.zzacT, i, false);
        zzb.zzc(parcel, 3, progressEvent.zzwS);
        zzb.zza(parcel, 4, progressEvent.zzaeg);
        zzb.zza(parcel, 5, progressEvent.zzaeh);
        zzb.zzc(parcel, 6, progressEvent.zzSq);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaz(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzci(x0);
    }

    public ProgressEvent zzaz(Parcel parcel) {
        long j = 0;
        int i = 0;
        int zzab = zza.zzab(parcel);
        DriveId driveId = null;
        long j2 = 0;
        int i2 = 0;
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
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    j2 = zza.zzi(parcel, zzaa);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ProgressEvent(i3, driveId, i2, j2, j, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ProgressEvent[] zzci(int i) {
        return new ProgressEvent[i];
    }
}
