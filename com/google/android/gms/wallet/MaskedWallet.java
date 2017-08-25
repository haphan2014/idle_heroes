package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.identity.intents.model.UserAddress;

public final class MaskedWallet implements SafeParcelable {
    public static final Creator<MaskedWallet> CREATOR = new zzk();
    private final int zzCY;
    String zzaQm;
    String zzaQn;
    String zzaQp;
    Address zzaQq;
    Address zzaQr;
    String[] zzaQs;
    UserAddress zzaQt;
    UserAddress zzaQu;
    InstrumentInfo[] zzaQv;
    LoyaltyWalletObject[] zzaRf;
    OfferWalletObject[] zzaRg;

    public final class Builder {
        final /* synthetic */ MaskedWallet zzaRh;

        private Builder(MaskedWallet maskedWallet) {
            this.zzaRh = maskedWallet;
        }

        public MaskedWallet build() {
            return this.zzaRh;
        }

        public Builder setBillingAddress(Address billingAddress) {
            this.zzaRh.zzaQq = billingAddress;
            return this;
        }

        public Builder setBuyerBillingAddress(UserAddress buyerBillingAddress) {
            this.zzaRh.zzaQt = buyerBillingAddress;
            return this;
        }

        public Builder setBuyerShippingAddress(UserAddress buyerShippingAddress) {
            this.zzaRh.zzaQu = buyerShippingAddress;
            return this;
        }

        public Builder setEmail(String email) {
            this.zzaRh.zzaQp = email;
            return this;
        }

        public Builder setGoogleTransactionId(String googleTransactionId) {
            this.zzaRh.zzaQm = googleTransactionId;
            return this;
        }

        public Builder setInstrumentInfos(InstrumentInfo[] instrumentInfos) {
            this.zzaRh.zzaQv = instrumentInfos;
            return this;
        }

        public Builder setLoyaltyWalletObjects(LoyaltyWalletObject[] loyaltyWalletObjects) {
            this.zzaRh.zzaRf = loyaltyWalletObjects;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.zzaRh.zzaQn = merchantTransactionId;
            return this;
        }

        public Builder setOfferWalletObjects(OfferWalletObject[] offerWalletObjects) {
            this.zzaRh.zzaRg = offerWalletObjects;
            return this;
        }

        public Builder setPaymentDescriptions(String[] paymentDescriptions) {
            this.zzaRh.zzaQs = paymentDescriptions;
            return this;
        }

        public Builder setShippingAddress(Address shippingAddress) {
            this.zzaRh.zzaQr = shippingAddress;
            return this;
        }
    }

    private MaskedWallet() {
        this.zzCY = 2;
    }

    MaskedWallet(int versionCode, String googleTransactionId, String merchantTransactionId, String[] paymentDescriptions, String email, Address billingAddress, Address shippingAddress, LoyaltyWalletObject[] loyaltyWalletObjects, OfferWalletObject[] offerWalletObjects, UserAddress buyerBillingAddress, UserAddress buyerShippingAddress, InstrumentInfo[] instrumentInfos) {
        this.zzCY = versionCode;
        this.zzaQm = googleTransactionId;
        this.zzaQn = merchantTransactionId;
        this.zzaQs = paymentDescriptions;
        this.zzaQp = email;
        this.zzaQq = billingAddress;
        this.zzaQr = shippingAddress;
        this.zzaRf = loyaltyWalletObjects;
        this.zzaRg = offerWalletObjects;
        this.zzaQt = buyerBillingAddress;
        this.zzaQu = buyerShippingAddress;
        this.zzaQv = instrumentInfos;
    }

    public static Builder newBuilderFrom(MaskedWallet maskedWallet) {
        zzu.zzu(maskedWallet);
        return zzAJ().setGoogleTransactionId(maskedWallet.getGoogleTransactionId()).setMerchantTransactionId(maskedWallet.getMerchantTransactionId()).setPaymentDescriptions(maskedWallet.getPaymentDescriptions()).setInstrumentInfos(maskedWallet.getInstrumentInfos()).setEmail(maskedWallet.getEmail()).setLoyaltyWalletObjects(maskedWallet.getLoyaltyWalletObjects()).setOfferWalletObjects(maskedWallet.getOfferWalletObjects()).setBuyerBillingAddress(maskedWallet.getBuyerBillingAddress()).setBuyerShippingAddress(maskedWallet.getBuyerShippingAddress());
    }

    public static Builder zzAJ() {
        MaskedWallet maskedWallet = new MaskedWallet();
        maskedWallet.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    @Deprecated
    public Address getBillingAddress() {
        return this.zzaQq;
    }

    public UserAddress getBuyerBillingAddress() {
        return this.zzaQt;
    }

    public UserAddress getBuyerShippingAddress() {
        return this.zzaQu;
    }

    public String getEmail() {
        return this.zzaQp;
    }

    public String getGoogleTransactionId() {
        return this.zzaQm;
    }

    public InstrumentInfo[] getInstrumentInfos() {
        return this.zzaQv;
    }

    public LoyaltyWalletObject[] getLoyaltyWalletObjects() {
        return this.zzaRf;
    }

    public String getMerchantTransactionId() {
        return this.zzaQn;
    }

    public OfferWalletObject[] getOfferWalletObjects() {
        return this.zzaRg;
    }

    public String[] getPaymentDescriptions() {
        return this.zzaQs;
    }

    @Deprecated
    public Address getShippingAddress() {
        return this.zzaQr;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}
