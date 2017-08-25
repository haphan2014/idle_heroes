package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LocationSettingsResult implements Result, SafeParcelable {
    public static final Creator<LocationSettingsResult> CREATOR = new zzh();
    private final int zzCY;
    private final Status zzOt;
    private final LocationSettingsStates zzayf;

    LocationSettingsResult(int version, Status status, LocationSettingsStates states) {
        this.zzCY = version;
        this.zzOt = status;
        this.zzayf = states;
    }

    public LocationSettingsResult(Status status) {
        this(1, status, null);
    }

    public int describeContents() {
        return 0;
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return this.zzayf;
    }

    public Status getStatus() {
        return this.zzOt;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }
}
