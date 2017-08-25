package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class TextModuleData implements SafeParcelable {
    public static final Creator<TextModuleData> CREATOR = new zzf();
    String zzCI;
    private final int zzCY;
    String zzaSG;

    TextModuleData() {
        this.zzCY = 1;
    }

    TextModuleData(int versionCode, String header, String body) {
        this.zzCY = versionCode;
        this.zzaSG = header;
        this.zzCI = body;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }
}
