package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Creator<ChannelEventParcelable> {
    static void zza(ChannelEventParcelable channelEventParcelable, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, channelEventParcelable.zzCY);
        zzb.zza(parcel, 2, channelEventParcelable.zzaTP, i, false);
        zzb.zzc(parcel, 3, channelEventParcelable.type);
        zzb.zzc(parcel, 4, channelEventParcelable.zzaTN);
        zzb.zzc(parcel, 5, channelEventParcelable.zzaTO);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgO(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjV(x0);
    }

    public ChannelEventParcelable zzgO(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        ChannelImpl channelImpl = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i4 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    channelImpl = (ChannelImpl) zza.zza(parcel, zzaa, ChannelImpl.CREATOR);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ChannelEventParcelable(i4, channelImpl, i3, i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ChannelEventParcelable[] zzjV(int i) {
        return new ChannelEventParcelable[i];
    }
}
