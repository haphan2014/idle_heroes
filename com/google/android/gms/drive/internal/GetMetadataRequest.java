package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;

public class GetMetadataRequest implements SafeParcelable {
    public static final Creator<GetMetadataRequest> CREATOR = new zzah();
    final int zzCY;
    final DriveId zzaeq;
    final boolean zzafN;

    GetMetadataRequest(int versionCode, DriveId id, boolean forceFromServer) {
        this.zzCY = versionCode;
        this.zzaeq = id;
        this.zzafN = forceFromServer;
    }

    public GetMetadataRequest(DriveId id, boolean forceFromServer) {
        this(1, id, forceFromServer);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzah.zza(this, dest, flags);
    }
}
