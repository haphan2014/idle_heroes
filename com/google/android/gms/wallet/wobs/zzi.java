package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<WalletObjectMessage> {
    static void zza(WalletObjectMessage walletObjectMessage, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, walletObjectMessage.getVersionCode());
        zzb.zza(parcel, 2, walletObjectMessage.zzaSG, false);
        zzb.zza(parcel, 3, walletObjectMessage.zzCI, false);
        zzb.zza(parcel, 4, walletObjectMessage.zzaSJ, i, false);
        zzb.zza(parcel, 5, walletObjectMessage.zzaSK, i, false);
        zzb.zza(parcel, 6, walletObjectMessage.zzaSL, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgG(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjL(x0);
    }

    public WalletObjectMessage zzgG(Parcel parcel) {
        UriData uriData = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        UriData uriData2 = null;
        TimeInterval timeInterval = null;
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
                    timeInterval = (TimeInterval) zza.zza(parcel, zzaa, TimeInterval.CREATOR);
                    break;
                case 5:
                    uriData2 = (UriData) zza.zza(parcel, zzaa, UriData.CREATOR);
                    break;
                case 6:
                    uriData = (UriData) zza.zza(parcel, zzaa, UriData.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new WalletObjectMessage(i, str2, str, timeInterval, uriData2, uriData);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public WalletObjectMessage[] zzjL(int i) {
        return new WalletObjectMessage[i];
    }
}
