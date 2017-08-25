package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<CreateWalletObjectsRequest> {
    static void zza(CreateWalletObjectsRequest createWalletObjectsRequest, Parcel parcel, int i) {
        int zzac = zzb.zzac(parcel);
        zzb.zzc(parcel, 1, createWalletObjectsRequest.getVersionCode());
        zzb.zza(parcel, 2, createWalletObjectsRequest.zzaQj, i, false);
        zzb.zza(parcel, 3, createWalletObjectsRequest.zzaQk, i, false);
        zzb.zza(parcel, 4, createWalletObjectsRequest.zzaQl, i, false);
        zzb.zzH(parcel, zzac);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzgd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzjf(x0);
    }

    public CreateWalletObjectsRequest zzgd(Parcel parcel) {
        GiftCardWalletObject giftCardWalletObject = null;
        int zzab = zza.zzab(parcel);
        int i = 0;
        OfferWalletObject offerWalletObject = null;
        LoyaltyWalletObject loyaltyWalletObject = null;
        while (parcel.dataPosition() < zzab) {
            OfferWalletObject offerWalletObject2;
            LoyaltyWalletObject loyaltyWalletObject2;
            int zzg;
            GiftCardWalletObject giftCardWalletObject2;
            int zzaa = zza.zzaa(parcel);
            GiftCardWalletObject giftCardWalletObject3;
            switch (zza.zzbA(zzaa)) {
                case 1:
                    giftCardWalletObject3 = giftCardWalletObject;
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = zza.zzg(parcel, zzaa);
                    giftCardWalletObject2 = giftCardWalletObject3;
                    break;
                case 2:
                    zzg = i;
                    OfferWalletObject offerWalletObject3 = offerWalletObject;
                    loyaltyWalletObject2 = (LoyaltyWalletObject) zza.zza(parcel, zzaa, LoyaltyWalletObject.CREATOR);
                    giftCardWalletObject2 = giftCardWalletObject;
                    offerWalletObject2 = offerWalletObject3;
                    break;
                case 3:
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = i;
                    giftCardWalletObject3 = giftCardWalletObject;
                    offerWalletObject2 = (OfferWalletObject) zza.zza(parcel, zzaa, OfferWalletObject.CREATOR);
                    giftCardWalletObject2 = giftCardWalletObject3;
                    break;
                case 4:
                    giftCardWalletObject2 = (GiftCardWalletObject) zza.zza(parcel, zzaa, GiftCardWalletObject.CREATOR);
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzaa);
                    giftCardWalletObject2 = giftCardWalletObject;
                    offerWalletObject2 = offerWalletObject;
                    loyaltyWalletObject2 = loyaltyWalletObject;
                    zzg = i;
                    break;
            }
            i = zzg;
            loyaltyWalletObject = loyaltyWalletObject2;
            offerWalletObject = offerWalletObject2;
            giftCardWalletObject = giftCardWalletObject2;
        }
        if (parcel.dataPosition() == zzab) {
            return new CreateWalletObjectsRequest(i, loyaltyWalletObject, offerWalletObject, giftCardWalletObject);
        }
        throw new zza.zza("Overread allowed size end=" + zzab, parcel);
    }

    public CreateWalletObjectsRequest[] zzjf(int i) {
        return new CreateWalletObjectsRequest[i];
    }
}
