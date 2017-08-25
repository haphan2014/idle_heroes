package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaz implements Creator<OpenChannelResponse> {
    static void zza(OpenChannelResponse openChannelResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, openChannelResponse.versionCode);
        zzb.zzc(parcel, 2, openChannelResponse.statusCode);
        zzb.zza(parcel, 3, openChannelResponse.zzaTP, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhk(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzks(x0);
    }

    public OpenChannelResponse zzhk(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        ChannelImpl channelImpl = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    channelImpl = (ChannelImpl) zza.zza(parcel, zzaa, ChannelImpl.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new OpenChannelResponse(i2, i, channelImpl);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public OpenChannelResponse[] zzks(int i) {
        return new OpenChannelResponse[i];
    }
}
