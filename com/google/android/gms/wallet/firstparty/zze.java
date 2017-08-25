package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<GetInstrumentsResponse> {
    static void zza(GetInstrumentsResponse getInstrumentsResponse, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getInstrumentsResponse.getVersionCode());
        zzb.zza(parcel, 2, getInstrumentsResponse.zzaRM, false);
        zzb.zza(parcel, 3, getInstrumentsResponse.zzaRN, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgu(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjw(x0);
    }

    public GetInstrumentsResponse zzgu(Parcel parcel) {
        String[] strArr = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        byte[][] bArr = (byte[][]) null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    strArr = zza.zzA(parcel, zzaa);
                    break;
                case 3:
                    bArr = zza.zzs(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetInstrumentsResponse(i, strArr, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GetInstrumentsResponse[] zzjw(int i) {
        return new GetInstrumentsResponse[i];
    }
}
