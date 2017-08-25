package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Creator<Cart> CREATOR = new zzb();
    private final int zzCY;
    String zzaQf;
    String zzaQg;
    ArrayList<LineItem> zzaQh;

    public final class Builder {
        final /* synthetic */ Cart zzaQi;

        private Builder(Cart cart) {
            this.zzaQi = cart;
        }

        public Builder addLineItem(LineItem lineItem) {
            this.zzaQi.zzaQh.add(lineItem);
            return this;
        }

        public Cart build() {
            return this.zzaQi;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzaQi.zzaQg = currencyCode;
            return this;
        }

        public Builder setLineItems(List<LineItem> lineItems) {
            this.zzaQi.zzaQh.clear();
            this.zzaQi.zzaQh.addAll(lineItems);
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.zzaQi.zzaQf = totalPrice;
            return this;
        }
    }

    Cart() {
        this.zzCY = 1;
        this.zzaQh = new ArrayList();
    }

    Cart(int versionCode, String totalPrice, String currencyCode, ArrayList<LineItem> lineItems) {
        this.zzCY = versionCode;
        this.zzaQf = totalPrice;
        this.zzaQg = currencyCode;
        this.zzaQh = lineItems;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzaQg;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.zzaQh;
    }

    public String getTotalPrice() {
        return this.zzaQf;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
