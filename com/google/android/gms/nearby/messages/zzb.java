package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.List;

public class zzb implements Creator<MessageFilter> {
    static void zza(MessageFilter messageFilter, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, messageFilter.zzwW(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, messageFilter.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzfq(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzid(x0);
    }

    public MessageFilter zzfq(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    list = zza.zzc(parcel, zzaa, MessageType.CREATOR);
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
            return new MessageFilter(i, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public MessageFilter[] zzid(int i) {
        return new MessageFilter[i];
    }
}
