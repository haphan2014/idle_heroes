package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Permission;
import java.util.List;

public class zzaj implements Creator<GetPermissionsResponse> {
    static void zza(GetPermissionsResponse getPermissionsResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getPermissionsResponse.zzCY);
        zzb.zzc(parcel, 2, getPermissionsResponse.zzafO, false);
        zzb.zzc(parcel, 3, getPermissionsResponse.zzws);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzaV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcK(x0);
    }

    public GetPermissionsResponse zzaV(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        List list = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzaa, Permission.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetPermissionsResponse(i2, list, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GetPermissionsResponse[] zzcK(int i) {
        return new GetPermissionsResponse[i];
    }
}
