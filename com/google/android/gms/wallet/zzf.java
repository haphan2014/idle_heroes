package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Creator<FullWalletRequest> {
    static void zza(FullWalletRequest fullWalletRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, fullWalletRequest.getVersionCode());
        zzb.zza(parcel, 2, fullWalletRequest.zzaQm, false);
        zzb.zza(parcel, 3, fullWalletRequest.zzaQn, false);
        zzb.zza(parcel, 4, fullWalletRequest.zzaQx, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgf(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjh(x0);
    }

    public FullWalletRequest zzgf(Parcel parcel) {
        Cart cart = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    cart = (Cart) zza.zza(parcel, zzaa, Cart.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new FullWalletRequest(i, str2, str, cart);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public FullWalletRequest[] zzjh(int i) {
        return new FullWalletRequest[i];
    }
}
