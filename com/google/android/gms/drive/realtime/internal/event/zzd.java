package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzd implements Creator<ParcelableEventList> {
    static void zza(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, parcelableEventList.zzCY);
        zzb.zzc(parcel, 2, parcelableEventList.zzoB, false);
        zzb.zza(parcel, 3, parcelableEventList.zzaiQ, i, false);
        zzb.zza(parcel, 4, parcelableEventList.zzaiR);
        zzb.zzb(parcel, 5, parcelableEventList.zzaiS, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzca(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzdQ(x0);
    }

    public ParcelableEventList zzca(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzab = zza.zzab(parcel);
        DataHolder dataHolder = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    list2 = zza.zzc(parcel, zzaa, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) zza.zza(parcel, zzaa, DataHolder.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 5:
                    list = zza.zzC(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ParcelableEventList(i, list2, dataHolder, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ParcelableEventList[] zzdQ(int i) {
        return new ParcelableEventList[i];
    }
}
