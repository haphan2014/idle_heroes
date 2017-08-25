package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public class zzj implements Creator<SubscribeRequest> {
    static void zza(SubscribeRequest subscribeRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, subscribeRequest.zzCY);
        zzb.zza(parcel, 2, subscribeRequest.zzxb(), false);
        zzb.zza(parcel, 3, subscribeRequest.zzaGc, i, false);
        zzb.zza(parcel, 4, subscribeRequest.zzxa(), false);
        zzb.zza(parcel, 5, subscribeRequest.zzaGg, i, false);
        zzb.zza(parcel, 6, subscribeRequest.zzaGh, i, false);
        zzb.zzc(parcel, 7, subscribeRequest.zzaGi);
        zzb.zza(parcel, 8, subscribeRequest.zzayp, false);
        zzb.zza(parcel, 9, subscribeRequest.zzaGe, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfv(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzik(x0);
    }

    public SubscribeRequest zzfv(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        String str2 = null;
        PendingIntent pendingIntent = null;
        MessageFilter messageFilter = null;
        IBinder iBinder = null;
        Strategy strategy = null;
        IBinder iBinder2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    iBinder2 = zza.zzp(parcel, zzaa);
                    break;
                case 3:
                    strategy = (Strategy) zza.zza(parcel, zzaa, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 5:
                    messageFilter = (MessageFilter) zza.zza(parcel, zzaa, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzaa, PendingIntent.CREATOR);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 8:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new SubscribeRequest(i2, iBinder2, strategy, iBinder, messageFilter, pendingIntent, i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SubscribeRequest[] zzik(int i) {
        return new SubscribeRequest[i];
    }
}
