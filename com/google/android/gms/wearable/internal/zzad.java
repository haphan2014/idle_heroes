package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad implements Creator<DeleteDataItemsResponse> {
    static void zza(DeleteDataItemsResponse deleteDataItemsResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, deleteDataItemsResponse.versionCode);
        zzb.zzc(parcel, 2, deleteDataItemsResponse.statusCode);
        zzb.zzc(parcel, 3, deleteDataItemsResponse.zzaUp);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgV(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkd(x0);
    }

    public DeleteDataItemsResponse zzgV(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzaa);
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
            return new DeleteDataItemsResponse(i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public DeleteDataItemsResponse[] zzkd(int i) {
        return new DeleteDataItemsResponse[i];
    }
}
