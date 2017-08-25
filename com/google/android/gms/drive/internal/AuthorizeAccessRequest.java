package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class AuthorizeAccessRequest implements SafeParcelable {
    public static final Creator<AuthorizeAccessRequest> CREATOR = new zzc();
    final int zzCY;
    final DriveId zzacT;
    final long zzaeo;

    AuthorizeAccessRequest(int versionCode, long appId, DriveId driveId) {
        this.zzCY = versionCode;
        this.zzaeo = appId;
        this.zzacT = driveId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
