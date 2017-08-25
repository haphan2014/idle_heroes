package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Subscription;

public class zzac implements Creator<SubscribeRequest> {
    static void zza(SubscribeRequest subscribeRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, subscribeRequest.zzrr(), i, false);
        zzb.zzc(parcel, 1000, subscribeRequest.getVersionCode());
        zzb.zza(parcel, 2, subscribeRequest.zzrs());
        zzb.zza(parcel, 3, subscribeRequest.zzqU(), false);
        zzb.zza(parcel, 4, subscribeRequest.getPackageName(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzdb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzeW(x0);
    }

    public SubscribeRequest zzdb(Parcel parcel) {
        boolean z = false;
        String str = null;
        int zzab = zza.zzab(parcel);
        IBinder iBinder = null;
        Subscription subscription = null;
        int i = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    subscription = (Subscription) zza.zza(parcel, zzaa, Subscription.CREATOR);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 3:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 1000:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new SubscribeRequest(i, subscription, z, iBinder, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SubscribeRequest[] zzeW(int i) {
        return new SubscribeRequest[i];
    }
}
