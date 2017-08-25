package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbc implements Creator<OnListParentsResponse> {
    static void zza(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, onListParentsResponse.zzCY);
        zzb.zza(parcel, 2, onListParentsResponse.zzagq, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcW(x0);
    }

    public OnListParentsResponse zzbh(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    dataHolder = (DataHolder) zza.zza(parcel, zzaa, DataHolder.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public OnListParentsResponse[] zzcW(int i) {
        return new OnListParentsResponse[i];
    }
}
