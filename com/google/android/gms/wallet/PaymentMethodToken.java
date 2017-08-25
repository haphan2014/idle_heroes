package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PaymentMethodToken implements SafeParcelable {
    public static final Creator<PaymentMethodToken> CREATOR = new zzo();
    private final int zzCY;
    String zzaFl;
    int zzaRz;

    private PaymentMethodToken() {
        this.zzCY = 1;
    }

    PaymentMethodToken(int versionCode, int tokenizationType, String token) {
        this.zzCY = versionCode;
        this.zzaRz = tokenizationType;
        this.zzaFl = token;
    }

    public int describeContents() {
        return 0;
    }

    public int getPaymentMethodTokenizationType() {
        return this.zzaRz;
    }

    public String getToken() {
        return this.zzaFl;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzo.zza(this, out, flags);
    }
}
