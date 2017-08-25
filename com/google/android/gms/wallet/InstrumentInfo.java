package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class InstrumentInfo implements SafeParcelable {
    public static final Creator<InstrumentInfo> CREATOR = new zzh();
    private final int zzCY;
    private String zzaQG;
    private String zzaQH;

    InstrumentInfo(int versionCode, String instrumentType, String instrumentDetails) {
        this.zzCY = versionCode;
        this.zzaQG = instrumentType;
        this.zzaQH = instrumentDetails;
    }

    public int describeContents() {
        return 0;
    }

    public String getInstrumentDetails() {
        return this.zzaQH;
    }

    public String getInstrumentType() {
        return this.zzaQG;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }
}
