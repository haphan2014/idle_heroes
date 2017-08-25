package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

public class AddPermissionRequest implements SafeParcelable {
    public static final Creator<AddPermissionRequest> CREATOR = new zzb();
    final int zzCY;
    final DriveId zzacT;
    final String zzadn;
    final Permission zzaek;
    final boolean zzael;
    final String zzaem;
    final boolean zzaen;

    AddPermissionRequest(int versionCode, DriveId driveId, Permission permission, boolean sendNotificationEmail, String emailMessage, boolean sendEventOnCompletion, String trackingTag) {
        this.zzCY = versionCode;
        this.zzacT = driveId;
        this.zzaek = permission;
        this.zzael = sendNotificationEmail;
        this.zzaem = emailMessage;
        this.zzaen = sendEventOnCompletion;
        this.zzadn = trackingTag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
