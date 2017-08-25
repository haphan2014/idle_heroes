package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
    public static final Creator<MaskedWalletRequest> CREATOR = new zzl();
    private final int zzCY;
    String zzaQg;
    String zzaQn;
    Cart zzaQx;
    boolean zzaRi;
    boolean zzaRj;
    boolean zzaRk;
    String zzaRl;
    String zzaRm;
    boolean zzaRn;
    boolean zzaRo;
    CountrySpecification[] zzaRp;
    boolean zzaRq;
    boolean zzaRr;
    ArrayList<CountrySpecification> zzaRs;
    PaymentMethodTokenizationParameters zzaRt;
    ArrayList<Integer> zzaRu;

    public final class Builder {
        final /* synthetic */ MaskedWalletRequest zzaRv;

        private Builder(MaskedWalletRequest maskedWalletRequest) {
            this.zzaRv = maskedWalletRequest;
        }

        public Builder addAllowedCardNetwork(int allowedCardNetwork) {
            if (this.zzaRv.zzaRu == null) {
                this.zzaRv.zzaRu = new ArrayList();
            }
            this.zzaRv.zzaRu.add(Integer.valueOf(allowedCardNetwork));
            return this;
        }

        public Builder addAllowedCardNetworks(Collection<Integer> allowedCardNetworks) {
            if (allowedCardNetworks != null) {
                if (this.zzaRv.zzaRu == null) {
                    this.zzaRv.zzaRu = new ArrayList();
                }
                this.zzaRv.zzaRu.addAll(allowedCardNetworks);
            }
            return this;
        }

        public Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (this.zzaRv.zzaRs == null) {
                this.zzaRv.zzaRs = new ArrayList();
            }
            this.zzaRv.zzaRs.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> countrySpecifications) {
            if (countrySpecifications != null) {
                if (this.zzaRv.zzaRs == null) {
                    this.zzaRv.zzaRs = new ArrayList();
                }
                this.zzaRv.zzaRs.addAll(countrySpecifications);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return this.zzaRv;
        }

        public Builder setAllowDebitCard(boolean allowDebitCard) {
            this.zzaRv.zzaRr = allowDebitCard;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean allowPrepaidCard) {
            this.zzaRv.zzaRq = allowPrepaidCard;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.zzaRv.zzaQx = cart;
            return this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzaRv.zzaQg = currencyCode;
            return this;
        }

        public Builder setEstimatedTotalPrice(String estimatedTotalPrice) {
            this.zzaRv.zzaRl = estimatedTotalPrice;
            return this;
        }

        public Builder setIsBillingAgreement(boolean isBillingAgreement) {
            this.zzaRv.zzaRo = isBillingAgreement;
            return this;
        }

        public Builder setMerchantName(String merchantName) {
            this.zzaRv.zzaRm = merchantName;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            this.zzaRv.zzaQn = merchantTransactionId;
            return this;
        }

        public Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters) {
            this.zzaRv.zzaRt = paymentMethodTokenizationParameters;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean phoneNumberRequired) {
            this.zzaRv.zzaRi = phoneNumberRequired;
            return this;
        }

        public Builder setShippingAddressRequired(boolean shippingAddressRequired) {
            this.zzaRv.zzaRj = shippingAddressRequired;
            return this;
        }

        public Builder setShouldRetrieveWalletObjects(boolean shouldRetrieveWalletObjects) {
            this.zzaRv.zzaRn = shouldRetrieveWalletObjects;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean useMinimalBillingAddress) {
            this.zzaRv.zzaRk = useMinimalBillingAddress;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.zzCY = 3;
        this.zzaRq = true;
        this.zzaRr = true;
    }

    MaskedWalletRequest(int versionCode, String merchantTransactionId, boolean phoneNumberRequired, boolean shippingAddressRequired, boolean useMinimalBillingAddress, String estimatedTotalPrice, String currencyCode, String merchantName, Cart cart, boolean shouldRetrieveWalletObjects, boolean isBillingAgreement, CountrySpecification[] allowedShippingCountrySpecifications, boolean allowPrepaidCard, boolean allowDebitCard, ArrayList<CountrySpecification> allowedCountrySpecificationsForShipping, PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, ArrayList<Integer> allowedCardNetworks) {
        this.zzCY = versionCode;
        this.zzaQn = merchantTransactionId;
        this.zzaRi = phoneNumberRequired;
        this.zzaRj = shippingAddressRequired;
        this.zzaRk = useMinimalBillingAddress;
        this.zzaRl = estimatedTotalPrice;
        this.zzaQg = currencyCode;
        this.zzaRm = merchantName;
        this.zzaQx = cart;
        this.zzaRn = shouldRetrieveWalletObjects;
        this.zzaRo = isBillingAgreement;
        this.zzaRp = allowedShippingCountrySpecifications;
        this.zzaRq = allowPrepaidCard;
        this.zzaRr = allowDebitCard;
        this.zzaRs = allowedCountrySpecificationsForShipping;
        this.zzaRt = paymentMethodTokenizationParameters;
        this.zzaRu = allowedCardNetworks;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public boolean allowDebitCard() {
        return this.zzaRr;
    }

    public boolean allowPrepaidCard() {
        return this.zzaRq;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<Integer> getAllowedCardNetworks() {
        return this.zzaRu;
    }

    public ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.zzaRs;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.zzaRp;
    }

    public Cart getCart() {
        return this.zzaQx;
    }

    public String getCurrencyCode() {
        return this.zzaQg;
    }

    public String getEstimatedTotalPrice() {
        return this.zzaRl;
    }

    public String getMerchantName() {
        return this.zzaRm;
    }

    public String getMerchantTransactionId() {
        return this.zzaQn;
    }

    public PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters() {
        return this.zzaRt;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public boolean isBillingAgreement() {
        return this.zzaRo;
    }

    public boolean isPhoneNumberRequired() {
        return this.zzaRi;
    }

    public boolean isShippingAddressRequired() {
        return this.zzaRj;
    }

    public boolean shouldRetrieveWalletObjects() {
        return this.zzaRn;
    }

    public boolean useMinimalBillingAddress() {
        return this.zzaRk;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }
}
