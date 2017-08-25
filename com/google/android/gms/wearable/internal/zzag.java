package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzag implements Creator<GetChannelInputStreamResponse> {
    static void zza(GetChannelInputStreamResponse getChannelInputStreamResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getChannelInputStreamResponse.versionCode);
        zzb.zzc(parcel, 2, getChannelInputStreamResponse.statusCode);
        zzb.zza(parcel, 3, getChannelInputStreamResponse.zzaUs, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgY(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkg(x0);
    }

    public GetChannelInputStreamResponse zzgY(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
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
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzaa, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetChannelInputStreamResponse(i2, i, parcelFileDescriptor);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GetChannelInputStreamResponse[] zzkg(int i) {
        return new GetChannelInputStreamResponse[i];
    }
}
