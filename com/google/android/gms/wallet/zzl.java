package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;

public class zzl implements Creator<MaskedWalletRequest> {
    static void zza(MaskedWalletRequest maskedWalletRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, maskedWalletRequest.getVersionCode());
        zzb.zza(parcel, 2, maskedWalletRequest.zzaQn, false);
        zzb.zza(parcel, 3, maskedWalletRequest.zzaRi);
        zzb.zza(parcel, 4, maskedWalletRequest.zzaRj);
        zzb.zza(parcel, 5, maskedWalletRequest.zzaRk);
        zzb.zza(parcel, 6, maskedWalletRequest.zzaRl, false);
        zzb.zza(parcel, 7, maskedWalletRequest.zzaQg, false);
        zzb.zza(parcel, 8, maskedWalletRequest.zzaRm, false);
        zzb.zza(parcel, 9, maskedWalletRequest.zzaQx, i, false);
        zzb.zza(parcel, 10, maskedWalletRequest.zzaRn);
        zzb.zza(parcel, 11, maskedWalletRequest.zzaRo);
        zzb.zza(parcel, 12, maskedWalletRequest.zzaRp, i, false);
        zzb.zza(parcel, 13, maskedWalletRequest.zzaRq);
        zzb.zza(parcel, 14, maskedWalletRequest.zzaRr);
        zzb.zzc(parcel, 15, maskedWalletRequest.zzaRs, false);
        zzb.zza(parcel, 17, maskedWalletRequest.zzaRu, false);
        zzb.zza(parcel, 16, maskedWalletRequest.zzaRt, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgl(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjn(x0);
    }

    public MaskedWalletRequest zzgl(Parcel parcel) {
        int zzab = zza.zzab(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Cart cart = null;
        boolean z4 = false;
        boolean z5 = false;
        CountrySpecification[] countrySpecificationArr = null;
        boolean z6 = true;
        boolean z7 = true;
        ArrayList arrayList = null;
        PaymentMethodTokenizationParameters paymentMethodTokenizationParameters = null;
        ArrayList arrayList2 = null;
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
                    z = zza.zzc(parcel, zzaa);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzaa);
                    break;
                case 5:
                    z3 = zza.zzc(parcel, zzaa);
                    break;
                case 6:
                    str2 = zza.zzo(parcel, zzaa);
                    break;
                case 7:
                    str3 = zza.zzo(parcel, zzaa);
                    break;
                case 8:
                    str4 = zza.zzo(parcel, zzaa);
                    break;
                case 9:
                    cart = (Cart) zza.zza(parcel, zzaa, Cart.CREATOR);
                    break;
                case 10:
                    z4 = zza.zzc(parcel, zzaa);
                    break;
                case 11:
                    z5 = zza.zzc(parcel, zzaa);
                    break;
                case 12:
                    countrySpecificationArr = (CountrySpecification[]) zza.zzb(parcel, zzaa, CountrySpecification.CREATOR);
                    break;
                case 13:
                    z6 = zza.zzc(parcel, zzaa);
                    break;
                case 14:
                    z7 = zza.zzc(parcel, zzaa);
                    break;
                case 15:
                    arrayList = zza.zzc(parcel, zzaa, CountrySpecification.CREATOR);
                    break;
                case 16:
                    paymentMethodTokenizationParameters = (PaymentMethodTokenizationParameters) zza.zza(parcel, zzaa, PaymentMethodTokenizationParameters.CREATOR);
                    break;
                case 17:
                    arrayList2 = zza.zzB(parcel, zzaa);
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    break;
            }
        }
        if (parcel.dataPosition() == zzab) {
            return new MaskedWalletRequest(i, str, z, z2, z3, str2, str3, str4, cart, z4, z5, countrySpecificationArr, z6, z7, arrayList, paymentMethodTokenizationParameters, arrayList2);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public MaskedWalletRequest[] zzjn(int i) {
        return new MaskedWalletRequest[i];
    }
}
