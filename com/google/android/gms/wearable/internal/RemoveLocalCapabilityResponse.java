package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RemoveLocalCapabilityResponse implements SafeParcelable {
    public static final Creator<RemoveLocalCapabilityResponse> CREATOR = new zzbd();
    public final int statusCode;
    public final int versionCode;

    RemoveLocalCapabilityResponse(int versionCode, int statusCode) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbd.zza(this, dest, flags);
    }
}
