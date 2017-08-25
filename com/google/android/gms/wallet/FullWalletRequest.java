package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class FullWalletRequest implements SafeParcelable {
    public static final Creator<FullWalletRequest> CREATOR = new zzf();
    private final int zzCY;
    String zzaQm;
    String zzaQn;
    Cart zzaQx;

    public final class Builder {
        final /* synthetic */ FullWalletRequest zzaQy;

        private Builder(FullWalletRequest fullWalletRequest) {
            this.zzaQy = fullWalletRequest;
        }

        public FullWalletRequest build() {
            return this.zzaQy;
        }

        public Builder setCart(Cart cart) {
            this.zzaQy.zzaQx = cart;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.zzaQy.zzaQm = googleTransactionId;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.zzaQy.zzaQn = merchantTransactionId;
            return this;
        }
    }

    FullWalletRequest() {
        this.zzCY = 1;
    }

    FullWalletRequest(int versionCode, String googleTransactionId, String merchantTransactionId, Cart cart) {
        this.zzCY = versionCode;
        this.zzaQm = googleTransactionId;
        this.zzaQn = merchantTransactionId;
        this.zzaQx = cart;
    }

    public static Builder newBuilder() {
        FullWalletRequest fullWalletRequest = new FullWalletRequest();
        fullWalletRequest.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public Cart getCart() {
        return this.zzaQx;
    }

    public String getGoogleTransactionId() {
        return this.zzaQm;
    }

    public String getMerchantTransactionId() {
        return this.zzaQn;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }
}
