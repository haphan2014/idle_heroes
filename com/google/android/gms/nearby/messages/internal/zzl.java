package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<UnsubscribeRequest> {
    static void zza(UnsubscribeRequest unsubscribeRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, unsubscribeRequest.zzCY);
        zzb.zza(parcel, 2, unsubscribeRequest.zzxb(), false);
        zzb.zza(parcel, 3, unsubscribeRequest.zzxa(), false);
        zzb.zza(parcel, 4, unsubscribeRequest.zzaGh, i, false);
        zzb.zzc(parcel, 5, unsubscribeRequest.zzaGi);
        zzb.zza(parcel, 6, unsubscribeRequest.zzayp, false);
        zzb.zza(parcel, 7, unsubscribeRequest.zzaGe, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzim(x0);
    }

    public UnsubscribeRequest zzfx(Parcel parcel) {
        int i = 0;
        String str = null;
        int zzab = zza.zzab(parcel);
        String str2 = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder = null;
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
                    iBinder = zza.zzp(parcel, zzaa);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) zza.zza(parcel, zzaa, PendingIntent.CREATOR);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new UnsubscribeRequest(i2, iBinder2, iBinder, pendingIntent, i, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public UnsubscribeRequest[] zzim(int i) {
        return new UnsubscribeRequest[i];
    }
}
