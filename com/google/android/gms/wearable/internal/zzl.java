package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<ChannelImpl> {
    static void zza(ChannelImpl channelImpl, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, channelImpl.zzCY);
        zzb.zza(parcel, 2, channelImpl.getToken(), false);
        zzb.zza(parcel, 3, channelImpl.getNodeId(), false);
        zzb.zza(parcel, 4, channelImpl.getPath(), false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgP(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjW(x0);
    }

    public ChannelImpl zzgP(Parcel parcel) {
        String str = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ChannelImpl(i, str3, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ChannelImpl[] zzjW(int i) {
        return new ChannelImpl[i];
    }
}
