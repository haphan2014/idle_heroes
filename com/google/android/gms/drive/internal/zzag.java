package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzag implements Creator<GetDriveIdFromUniqueIdentifierRequest> {
    static void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getDriveIdFromUniqueIdentifierRequest.zzCY);
        zzb.zza(parcel, 2, getDriveIdFromUniqueIdentifierRequest.zzafL, false);
        zzb.zza(parcel, 3, getDriveIdFromUniqueIdentifierRequest.zzafM);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaS(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcH(x0);
    }

    public GetDriveIdFromUniqueIdentifierRequest zzaS(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GetDriveIdFromUniqueIdentifierRequest[] zzcH(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }
}
