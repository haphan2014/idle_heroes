package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaf implements Creator<GetCapabilityResponse> {
    static void zza(GetCapabilityResponse getCapabilityResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getCapabilityResponse.versionCode);
        zzb.zzc(parcel, 2, getCapabilityResponse.statusCode);
        zzb.zza(parcel, 3, getCapabilityResponse.zzaUr, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgX(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzkf(x0);
    }

    public GetCapabilityResponse zzgX(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        CapabilityInfoParcelable capabilityInfoParcelable = null;
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
                    capabilityInfoParcelable = (CapabilityInfoParcelable) zza.zza(parcel, zzaa, CapabilityInfoParcelable.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetCapabilityResponse(i2, i, capabilityInfoParcelable);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GetCapabilityResponse[] zzkf(int i) {
        return new GetCapabilityResponse[i];
    }
}
