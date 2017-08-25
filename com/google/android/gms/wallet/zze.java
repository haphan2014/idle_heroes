package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.identity.intents.model.UserAddress;

public class zze implements Creator<FullWallet> {
    static void zza(FullWallet fullWallet, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, fullWallet.getVersionCode());
        zzb.zza(parcel, 2, fullWallet.zzaQm, false);
        zzb.zza(parcel, 3, fullWallet.zzaQn, false);
        zzb.zza(parcel, 4, fullWallet.zzaQo, i, false);
        zzb.zza(parcel, 5, fullWallet.zzaQp, false);
        zzb.zza(parcel, 6, fullWallet.zzaQq, i, false);
        zzb.zza(parcel, 7, fullWallet.zzaQr, i, false);
        zzb.zza(parcel, 8, fullWallet.zzaQs, false);
        zzb.zza(parcel, 9, fullWallet.zzaQt, i, false);
        zzb.zza(parcel, 10, fullWallet.zzaQu, i, false);
        zzb.zza(parcel, 11, fullWallet.zzaQv, i, false);
        zzb.zza(parcel, 12, fullWallet.zzaQw, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzge(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjg(x0);
    }

    public FullWallet zzge(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ProxyCard proxyCard = null;
        String str3 = null;
        Address address = null;
        Address address2 = null;
        String[] strArr = null;
        UserAddress userAddress = null;
        UserAddress userAddress2 = null;
        InstrumentInfo[] instrumentInfoArr = null;
        PaymentMethodToken paymentMethodToken = null;
        while (parcel.dataPosition() < zzab) {
            int zzaa = zza.zzaa(parcel);
            switch (zza.zzbA(zzaa)) {
                case 1:
                    i = zza.zzg(parcel, zzaa);
                    break;
                case 2:
                    str = zza.zzo(parcel, zzaa);
                    break;
                case 3:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 4:
                    proxyCard = (ProxyCard) zza.zza(parcel, zzaa, ProxyCard.CREATOR);
                    break;
                case 5:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 6:
                    address = (Address) zza.zza(parcel, zzaa, Address.CREATOR);
                    break;
                case 7:
                    address2 = (Address) zza.zza(parcel, zzaa, Address.CREATOR);
                    break;
                case 8:
                    strArr = zza.zzA(parcel, zzaa);
                    break;
                case 9:
                    userAddress = (UserAddress) zza.zza(parcel, zzaa, UserAddress.CREATOR);
                    break;
                case 10:
                    userAddress2 = (UserAddress) zza.zza(parcel, zzaa, UserAddress.CREATOR);
                    break;
                case 11:
                    instrumentInfoArr = (InstrumentInfo[]) zza.zzb(parcel, zzaa, InstrumentInfo.CREATOR);
                    break;
                case 12:
                    paymentMethodToken = (PaymentMethodToken) zza.zza(parcel, zzaa, PaymentMethodToken.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new FullWallet(i, str, str2, proxyCard, str3, address, address2, strArr, userAddress, userAddress2, instrumentInfoArr, paymentMethodToken);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public FullWallet[] zzjg(int i) {
        return new FullWallet[i];
    }
}
