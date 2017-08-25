package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CreateWalletObjectsRequest implements SafeParcelable {
    public static final Creator<CreateWalletObjectsRequest> CREATOR = new zzd();
    private final int zzCY;
    LoyaltyWalletObject zzaQj;
    OfferWalletObject zzaQk;
    GiftCardWalletObject zzaQl;

    CreateWalletObjectsRequest() {
        this.zzCY = 3;
    }

    CreateWalletObjectsRequest(int versionCode, LoyaltyWalletObject loyaltyWalletObject, OfferWalletObject offerWalletObject, GiftCardWalletObject giftCardWalletObject) {
        this.zzCY = versionCode;
        this.zzaQj = loyaltyWalletObject;
        this.zzaQk = offerWalletObject;
        this.zzaQl = giftCardWalletObject;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
