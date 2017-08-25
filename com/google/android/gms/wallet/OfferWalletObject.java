package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wallet.wobs.CommonWalletObject;

public final class OfferWalletObject implements SafeParcelable {
    public static final Creator<OfferWalletObject> CREATOR = new zzn();
    private final int zzCY;
    CommonWalletObject zzaQz;
    String zzaRy;
    String zzhI;

    OfferWalletObject() {
        this.zzCY = 3;
    }

    OfferWalletObject(int versionCode, String id, String redemptionCode, CommonWalletObject commonWalletObject) {
        this.zzCY = versionCode;
        this.zzaRy = redemptionCode;
        if (versionCode < 3) {
            this.zzaQz = CommonWalletObject.zzAN().zzff(id).zzAO();
        } else {
            this.zzaQz = commonWalletObject;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.zzaQz.getId();
    }

    public String getRedemptionCode() {
        return this.zzaRy;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }
}
