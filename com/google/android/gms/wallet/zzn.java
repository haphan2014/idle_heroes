package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public class zzn implements Creator<OfferWalletObject> {
    static void zza(OfferWalletObject offerWalletObject, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, offerWalletObject.getVersionCode());
        zzb.zza(parcel, 2, offerWalletObject.zzhI, false);
        zzb.zza(parcel, 3, offerWalletObject.zzaRy, false);
        zzb.zza(parcel, 4, offerWalletObject.zzaQz, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgn(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjp(x0);
    }

    public OfferWalletObject zzgn(Parcel parcel) {
        CommonWalletObject commonWalletObject = null;
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
                    commonWalletObject = (CommonWalletObject) zza.zza(parcel, zzaa, CommonWalletObject.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new OfferWalletObject(i, str2, str, commonWalletObject);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public OfferWalletObject[] zzjp(int i) {
        return new OfferWalletObject[i];
    }
}
