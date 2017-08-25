package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ProxyCard implements SafeParcelable {
    public static final Creator<ProxyCard> CREATOR = new zzq();
    private final int zzCY;
    String zzaRB;
    String zzaRC;
    int zzaRD;
    int zzaRE;

    ProxyCard(int versionCode, String pan, String cvn, int expirationMonth, int expirationYear) {
        this.zzCY = versionCode;
        this.zzaRB = pan;
        this.zzaRC = cvn;
        this.zzaRD = expirationMonth;
        this.zzaRE = expirationYear;
    }

    public int describeContents() {
        return 0;
    }

    public String getCvn() {
        return this.zzaRC;
    }

    public int getExpirationMonth() {
        return this.zzaRD;
    }

    public int getExpirationYear() {
        return this.zzaRE;
    }

    public String getPan() {
        return this.zzaRB;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzq.zza(this, out, flags);
    }
}
