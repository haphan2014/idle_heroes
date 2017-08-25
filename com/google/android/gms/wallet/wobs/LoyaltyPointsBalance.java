package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LoyaltyPointsBalance implements SafeParcelable {
    public static final Creator<LoyaltyPointsBalance> CREATOR = new zzd();
    private final int zzCY;
    String zzaQD;
    int zzaSB;
    String zzaSC;
    double zzaSD;
    long zzaSE;
    int zzaSF;

    LoyaltyPointsBalance() {
        this.zzCY = 1;
        this.zzaSF = -1;
        this.zzaSB = -1;
        this.zzaSD = -1.0d;
    }

    LoyaltyPointsBalance(int versionCode, int balanceInt, String balanceString, double balanceDouble, String currencyCode, long currencyMicros, int balanceType) {
        this.zzCY = versionCode;
        this.zzaSB = balanceInt;
        this.zzaSC = balanceString;
        this.zzaSD = balanceDouble;
        this.zzaQD = currencyCode;
        this.zzaSE = currencyMicros;
        this.zzaSF = balanceType;
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
