package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.List;

public class zzbp implements Creator<SetResourceParentsRequest> {
    static void zza(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, setResourceParentsRequest.zzCY);
        zzb.zza(parcel, 2, setResourceParentsRequest.zzagv, i, false);
        zzb.zzc(parcel, 3, setResourceParentsRequest.zzagw, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdi(x0);
    }

    public SetResourceParentsRequest zzbt(Parcel parcel) {
        List list = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzab) {
            DriveId driveId2;
            int zzg;
            ArrayList zzc;
            int zzaa = zza.zzaa(parcel);
            List list2;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    List list3 = list;
                    driveId2 = driveId;
                    zzg = zza.zzg(parcel, zzaa);
                    list2 = list3;
                    break;
                case 2:
                    zzg = i;
                    DriveId driveId3 = (DriveId) zza.zza(parcel, zzaa, DriveId.CREATOR);
                    list2 = list;
                    driveId2 = driveId3;
                    break;
                case 3:
                    zzc = zza.zzc(parcel, zzaa, DriveId.CREATOR);
                    driveId2 = driveId;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    zzc = list;
                    driveId2 = driveId;
                    zzg = i;
                    break;
            }
            i = zzg;
            driveId = driveId2;
            Object obj = zzc;
        }
        if (parcel.dataPosition() == zzab) {
            return new SetResourceParentsRequest(i, driveId, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SetResourceParentsRequest[] zzdi(int i) {
        return new SetResourceParentsRequest[i];
    }
}
