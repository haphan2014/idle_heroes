package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class StringParcel implements SafeParcelable {
    public static final Creator<StringParcel> CREATOR = new zzm();
    final int zzCY;
    String zzuU;

    StringParcel(int versionCode, String content) {
        this.zzCY = versionCode;
        this.zzuU = content;
    }

    public StringParcel(String content) {
        this.zzCY = 1;
        this.zzuU = content;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzm.zza(this, dest, flags);
    }

    public String zzfB() {
        return this.zzuU;
    }
}
