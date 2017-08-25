package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbb implements Creator<OnListEntriesResponse> {
    static void zza(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, onListEntriesResponse.zzCY);
        zzb.zza(parcel, 2, onListEntriesResponse.zzagp, i, false);
        zzb.zza(parcel, 3, onListEntriesResponse.zzaeL);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzbg(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzcV(x0);
    }

    public OnListEntriesResponse zzbg(Parcel parcel) {
        boolean z = false;
        int zzab = zza.zzab(parcel);
        DataHolder dataHolder = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            DataHolder dataHolder2;
            int zzg;
            boolean z2;
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    boolean z3 = z;
                    dataHolder2 = dataHolder;
                    zzg = zza.zzg(parcel, zzaa);
                    z2 = z3;
                    break;
                case 2:
                    zzg = i;
                    DataHolder dataHolder3 = (DataHolder) zza.zza(parcel, zzaa, DataHolder.CREATOR);
                    z2 = z;
                    dataHolder2 = dataHolder3;
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzaa);
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    z2 = z;
                    dataHolder2 = dataHolder;
                    zzg = i;
                    break;
            }
            i = zzg;
            dataHolder = dataHolder2;
            z = z2;
        }
        if (parcel.dataPosition() == zzab) {
            return new OnListEntriesResponse(i, dataHolder, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public OnListEntriesResponse[] zzcV(int i) {
        return new OnListEntriesResponse[i];
    }
}
