package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<AddListenerRequest> {
    static void zza(AddListenerRequest addListenerRequest, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, addListenerRequest.zzCY);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, addListenerRequest.zzAT(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, addListenerRequest.zzaTr, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, addListenerRequest.zzaTs, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, addListenerRequest.zzaTt, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgK(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjP(x0);
    }

    public AddListenerRequest zzgK(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str2 = null;
        IntentFilter[] intentFilterArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 3:
                    intentFilterArr = (IntentFilter[]) zza.zzb(parcel, zzaa, IntentFilter.CREATOR);
                    break;
                case 4:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new AddListenerRequest(i, iBinder, intentFilterArr, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public AddListenerRequest[] zzjP(int i) {
        return new AddListenerRequest[i];
    }
}
