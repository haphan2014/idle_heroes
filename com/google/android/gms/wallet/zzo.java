package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Creator<PaymentMethodToken> {
    static void zza(PaymentMethodToken paymentMethodToken, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, paymentMethodToken.getVersionCode());
        zzb.zzc(parcel, 2, paymentMethodToken.zzaRz);
        zzb.zza(parcel, 3, paymentMethodToken.zzaFl, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgo(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjq(x0);
    }

    public PaymentMethodToken zzgo(Parcel parcel) {
        int i = 0;
        int zzab = zza.zzab(parcel);
        String str = null;
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
                    str = zza.zzo(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new PaymentMethodToken(i2, i, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public PaymentMethodToken[] zzjq(int i) {
        return new PaymentMethodToken[i];
    }
}
