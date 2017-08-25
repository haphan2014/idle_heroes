package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<SafeParcelResponse> {
    static void zza(SafeParcelResponse safeParcelResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, safeParcelResponse.getVersionCode());
        zzb.zza(parcel, 2, safeParcelResponse.zzoE(), false);
        zzb.zza(parcel, 3, safeParcelResponse.zzoF(), i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzal(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzbL(x0);
    }

    public SafeParcelResponse zzal(Parcel parcel) {
        FieldMappingDictionary fieldMappingDictionary = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        Parcel parcel2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    parcel2 = zza.zzD(parcel, zzaa);
                    break;
                case 3:
                    fieldMappingDictionary = (FieldMappingDictionary) zza.zza(parcel, zzaa, FieldMappingDictionary.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new SafeParcelResponse(i, parcel2, fieldMappingDictionary);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public SafeParcelResponse[] zzbL(int i) {
        return new SafeParcelResponse[i];
    }
}
