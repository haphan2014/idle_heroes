package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<GetBuyFlowInitializationTokenRequest> {
    static void zza(GetBuyFlowInitializationTokenRequest getBuyFlowInitializationTokenRequest, Parcel parcel, int i) {
        int zzac = com.google.android.gms.common.internal.safeparcel.zzb.zzac(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, getBuyFlowInitializationTokenRequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, getBuyFlowInitializationTokenRequest.zzaRJ, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgr(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjt(x0);
    }

    public GetBuyFlowInitializationTokenRequest zzgr(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    bArr = zza.zzr(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new GetBuyFlowInitializationTokenRequest(i, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public GetBuyFlowInitializationTokenRequest[] zzjt(int i) {
        return new GetBuyFlowInitializationTokenRequest[i];
    }
}
