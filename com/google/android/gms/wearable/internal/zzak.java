package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzak implements Creator<GetConfigResponse> {
    static void zza(GetConfigResponse getConfigResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getConfigResponse.versionCode);
        zzb.zzc(parcel, 2, getConfigResponse.statusCode);
        zzb.zza(parcel, 3, getConfigResponse.zzaUu, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkk(x0);
    }

    public GetConfigResponse zzhc(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        ConnectionConfiguration connectionConfiguration = null;
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
                    connectionConfiguration = (ConnectionConfiguration) zza.zza(parcel, zzaa, ConnectionConfiguration.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetConfigResponse(i2, i, connectionConfiguration);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GetConfigResponse[] zzkk(int i) {
        return new GetConfigResponse[i];
    }
}
