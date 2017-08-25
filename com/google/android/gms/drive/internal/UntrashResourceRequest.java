package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class UntrashResourceRequest implements SafeParcelable {
    public static final Creator<UntrashResourceRequest> CREATOR = new zzbt();
    final int zzCY;
    final DriveId zzaeq;

    UntrashResourceRequest(int versionCode, DriveId id) {
        this.zzCY = versionCode;
        this.zzaeq = id;
    }

    public UntrashResourceRequest(DriveId id) {
        this(1, id);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbt.zza(this, dest, flags);
    }
}
