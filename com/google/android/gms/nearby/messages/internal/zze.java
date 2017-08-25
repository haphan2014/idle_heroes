package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.nearby.messages.Message;

public class zze implements Creator<MessageWrapper> {
    static void zza(MessageWrapper messageWrapper, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zza(parcel, 1, messageWrapper.zzaFZ, i, false);
        zzb.zzc(parcel, 1000, messageWrapper.versionCode);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzft(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzii(x0);
    }

    public MessageWrapper zzft(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        Message message = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    message = (Message) zza.zza(parcel, zzaa, Message.CREATOR);
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
            return new MessageWrapper(i, message);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public MessageWrapper[] zzii(int i) {
        return new MessageWrapper[i];
    }
}
