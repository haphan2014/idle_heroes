package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LoyaltyPoints implements SafeParcelable {
    public static final Creator<LoyaltyPoints> CREATOR = new zze();
    String label;
    String type;
    private final int zzCY;
    TimeInterval zzaQV;
    LoyaltyPointsBalance zzaSA;

    LoyaltyPoints() {
        this.zzCY = 1;
    }

    LoyaltyPoints(int versionCode, String label, LoyaltyPointsBalance balance, String type, TimeInterval validTimeInterval) {
        this.zzCY = versionCode;
        this.label = label;
        this.zzaSA = balance;
        this.type = type;
        this.zzaQV = validTimeInterval;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
