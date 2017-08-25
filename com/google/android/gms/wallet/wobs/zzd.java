package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<LoyaltyPointsBalance> {
    static void zza(LoyaltyPointsBalance loyaltyPointsBalance, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, loyaltyPointsBalance.getVersionCode());
        zzb.zzc(parcel, 2, loyaltyPointsBalance.zzaSB);
        zzb.zza(parcel, 3, loyaltyPointsBalance.zzaSC, false);
        zzb.zza(parcel, 4, loyaltyPointsBalance.zzaSD);
        zzb.zza(parcel, 5, loyaltyPointsBalance.zzaQD, false);
        zzb.zza(parcel, 6, loyaltyPointsBalance.zzaSE);
        zzb.zzc(parcel, 7, loyaltyPointsBalance.zzaSF);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgB(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjG(x0);
    }

    public LoyaltyPointsBalance zzgB(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzab = zza.zzab(parcel);
        double d = 0.0d;
        long j = 0;
        int i2 = -1;
        String str2 = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i3 = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    d = zza.zzm(parcel, zzaa);
                    break;
                case 5:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    j = zza.zzi(parcel, zzaa);
                    break;
                case 7:
                    i2 = zza.zzg(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new LoyaltyPointsBalance(i3, i, str2, d, str, j, i2);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public LoyaltyPointsBalance[] zzjG(int i) {
        return new LoyaltyPointsBalance[i];
    }
}
