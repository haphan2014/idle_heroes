package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem implements SafeParcelable {
    public static final Creator<LineItem> CREATOR = new zzi();
    String description;
    private final int zzCY;
    String zzaQI;
    String zzaQJ;
    int zzaQK;
    String zzaQf;
    String zzaQg;

    public final class Builder {
        final /* synthetic */ LineItem zzaQL;

        private Builder(LineItem lineItem) {
            this.zzaQL = lineItem;
        }

        public LineItem build() {
            return this.zzaQL;
        }

        public Builder setCurrencyCode(String currencyCode) {
            this.zzaQL.zzaQg = currencyCode;
            return this;
        }

        public Builder setDescription(String description) {
            this.zzaQL.description = description;
            return this;
        }

        public Builder setQuantity(String quantity) {
            this.zzaQL.zzaQI = quantity;
            return this;
        }

        public Builder setRole(int role) {
            this.zzaQL.zzaQK = role;
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            this.zzaQL.zzaQf = totalPrice;
            return this;
        }

        public Builder setUnitPrice(String unitPrice) {
            this.zzaQL.zzaQJ = unitPrice;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    LineItem() {
        this.zzCY = 1;
        this.zzaQK = 0;
    }

    LineItem(int versionCode, String description, String quantity, String unitPrice, String totalPrice, int role, String currencyCode) {
        this.zzCY = versionCode;
        this.description = description;
        this.zzaQI = quantity;
        this.zzaQJ = unitPrice;
        this.zzaQf = totalPrice;
        this.zzaQK = role;
        this.zzaQg = currencyCode;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzaQg;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.zzaQI;
    }

    public int getRole() {
        return this.zzaQK;
    }

    public String getTotalPrice() {
        return this.zzaQf;
    }

    public String getUnitPrice() {
        return this.zzaQJ;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
