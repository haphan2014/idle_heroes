package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbh implements Creator<OpenContentsRequest> {
    static void zza(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, openContentsRequest.zzCY);
        zzb.zza(parcel, 2, openContentsRequest.zzaeq, i, false);
        zzb.zzc(parcel, 3, openContentsRequest.zzacS);
        zzb.zzc(parcel, 4, openContentsRequest.zzagr);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbm(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdb(x0);
    }

    public OpenContentsRequest zzbm(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            DriveId driveId2;
            int zzg;
            int zzaa = zza.zzaa(parcel);
            int i4;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i4 = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzaa);
                    zzaa = i4;
                    break;
                case 2:
                    zzg = i3;
                    i4 = i2;
                    driveId2 = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    zzaa = i;
                    i = i4;
                    break;
                case 3:
                    driveId2 = driveId;
                    zzg = i3;
                    i4 = i;
                    i = zza.zzg(parcel, zzaa);
                    zzaa = i4;
                    break;
                case 4:
                    zzaa = zza.zzg(parcel, zzaa);
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzaa = i;
                    i = i2;
                    driveId2 = driveId;
                    zzg = i3;
                    break;
            }
            i3 = zzg;
            driveId = driveId2;
            i2 = i;
            i = zzaa;
        }
        if (parcel.dataPosition() == zzab) {
            return new OpenContentsRequest(i3, driveId, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public OpenContentsRequest[] zzdb(int i) {
        return new OpenContentsRequest[i];
    }
}
