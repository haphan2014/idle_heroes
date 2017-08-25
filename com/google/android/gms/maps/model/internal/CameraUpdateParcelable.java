package com.google.android.gms.maps.model.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CameraUpdateParcelable implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    private int type;
    private final int zzCY;
    private Bundle zzaDN;

    CameraUpdateParcelable(int versionCode, int type, Bundle parameters) {
        this.zzCY = versionCode;
        this.type = type;
        this.zzaDN = parameters;
    }

    public int describeContents() {
        return 0;
    }

    public Bundle getParameters() {
        return this.zzaDN;
    }

    public int getType() {
        return this.type;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
