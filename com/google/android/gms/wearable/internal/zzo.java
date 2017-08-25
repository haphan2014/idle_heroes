package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Creator<ChannelReceiveFileResponse> {
    static void zza(ChannelReceiveFileResponse channelReceiveFileResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, channelReceiveFileResponse.versionCode);
        zzb.zzc(parcel, 2, channelReceiveFileResponse.statusCode);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgQ(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjY(x0);
    }

    public ChannelReceiveFileResponse zzgQ(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
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
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new ChannelReceiveFileResponse(i2, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public ChannelReceiveFileResponse[] zzjY(int i) {
        return new ChannelReceiveFileResponse[i];
    }
}
