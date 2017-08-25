package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wearable.ConnectionConfiguration;

public class zzal implements Creator<GetConfigsResponse> {
    static void zza(GetConfigsResponse getConfigsResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getConfigsResponse.versionCode);
        zzb.zzc(parcel, 2, getConfigsResponse.statusCode);
        zzb.zza(parcel, 3, getConfigsResponse.zzaUv, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzhd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkl(x0);
    }

    public GetConfigsResponse zzhd(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        ConnectionConfiguration[] connectionConfigurationArr = null;
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
                    connectionConfigurationArr = (ConnectionConfiguration[]) zza.zzb(parcel, zzaa, ConnectionConfiguration.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetConfigsResponse(i2, i, connectionConfigurationArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GetConfigsResponse[] zzkl(int i) {
        return new GetConfigsResponse[i];
    }
}
