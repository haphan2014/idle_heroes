package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class OnDriveIdResponse implements SafeParcelable {
    public static final Creator<OnDriveIdResponse> CREATOR = new zzax();
    final int zzCY;
    DriveId zzaeq;

    OnDriveIdResponse(int versionCode, DriveId driveId) {
        this.zzCY = versionCode;
        this.zzaeq = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzaeq;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzax.zza(this, dest, flags);
    }
}
