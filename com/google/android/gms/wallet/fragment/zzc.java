package com.google.android.gms.wallet.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<WalletFragmentStyle> {
    static void zza(WalletFragmentStyle walletFragmentStyle, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, walletFragmentStyle.zzCY);
        zzb.zza(parcel, 2, walletFragmentStyle.zzaSm, false);
        zzb.zzc(parcel, 3, walletFragmentStyle.zzaSn);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgx(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjA(x0);
    }

    public WalletFragmentStyle zzgx(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        Bundle bundle = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    bundle = zza.zzq(parcel, zzaa);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new WalletFragmentStyle(i2, bundle, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public WalletFragmentStyle[] zzjA(int i) {
        return new WalletFragmentStyle[i];
    }
}
