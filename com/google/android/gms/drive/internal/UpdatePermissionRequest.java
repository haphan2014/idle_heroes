package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UpdatePermissionRequest implements SafeParcelable {
    public static final Creator<UpdatePermissionRequest> CREATOR = new zzbv();
    final int zzCY;
    final DriveId zzacT;
    final String zzadn;
    final String zzadz;
    final boolean zzaen;
    final int zzagx;

    UpdatePermissionRequest(int versionCode, DriveId driveId, String accountIdentifier, int newRole, boolean sendEventOnCompletion, String trackingTag) {
        this.zzCY = versionCode;
        this.zzacT = driveId;
        this.zzadz = accountIdentifier;
        this.zzagx = newRole;
        this.zzaen = sendEventOnCompletion;
        this.zzadn = trackingTag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbv.zza(this, dest, flags);
    }
}
