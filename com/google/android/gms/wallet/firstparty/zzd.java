package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<GetInstrumentsRequest> {
    static void zza(GetInstrumentsRequest getInstrumentsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, getInstrumentsRequest.getVersionCode());
        zzb.zza(parcel, 2, getInstrumentsRequest.zzaRL, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgt(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjv(x0);
    }

    public GetInstrumentsRequest zzgt(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        int[] iArr = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    iArr = zza.zzu(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetInstrumentsRequest(i, iArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GetInstrumentsRequest[] zzjv(int i) {
        return new GetInstrumentsRequest[i];
    }
}
