package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetPermissionsRequest implements SafeParcelable {
    public static final Creator<GetPermissionsRequest> CREATOR = new zzai();
    final int zzCY;
    final DriveId zzacT;

    GetPermissionsRequest(int versionCode, DriveId driveId) {
        this.zzCY = versionCode;
        this.zzacT = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzai.zza(this, dest, flags);
    }
}
