package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Creator<WalletFragmentInitParams> CREATOR = new zza();
    final int zzCY;
    private String zzOx;
    private MaskedWalletRequest zzaRU;
    private MaskedWallet zzaRV;
    private int zzaSi;

    public final class Builder {
        final /* synthetic */ WalletFragmentInitParams zzaSj;

        private Builder(WalletFragmentInitParams walletFragmentInitParams) {
            this.zzaSj = walletFragmentInitParams;
        }

        public WalletFragmentInitParams build() {
            boolean z = true;
            boolean z2 = (this.zzaSj.zzaRV != null && this.zzaSj.zzaRU == null) || (this.zzaSj.zzaRV == null && this.zzaSj.zzaRU != null);
            zzu.zza(z2, (Object) "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            if (this.zzaSj.zzaSi < 0) {
                z = false;
            }
            zzu.zza(z, (Object) "masked wallet request code is required and must be non-negative");
            return this.zzaSj;
        }

        public Builder setAccountName(String accountName) {
            this.zzaSj.zzOx = accountName;
            return this;
        }

        public Builder setMaskedWallet(MaskedWallet maskedWallet) {
            this.zzaSj.zzaRV = maskedWallet;
            return this;
        }

        public Builder setMaskedWalletRequest(MaskedWalletRequest request) {
            this.zzaSj.zzaRU = request;
            return this;
        }

        public Builder setMaskedWalletRequestCode(int requestCode) {
            this.zzaSj.zzaSi = requestCode;
            return this;
        }
    }

    private WalletFragmentInitParams() {
        this.zzCY = 1;
        this.zzaSi = -1;
    }

    WalletFragmentInitParams(int versionCode, String accountName, MaskedWalletRequest maskedWalletRequest, int maskedWalletRequestCode, MaskedWallet maskedWallet) {
        this.zzCY = versionCode;
        this.zzOx = accountName;
        this.zzaRU = maskedWalletRequest;
        this.zzaSi = maskedWalletRequestCode;
        this.zzaRV = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.zzOx;
    }

    public MaskedWallet getMaskedWallet() {
        return this.zzaRV;
    }

    public MaskedWalletRequest getMaskedWalletRequest() {
        return this.zzaRU;
    }

    public int getMaskedWalletRequestCode() {
        return this.zzaSi;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
