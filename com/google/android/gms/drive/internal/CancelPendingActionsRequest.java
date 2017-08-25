package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CancelPendingActionsRequest implements SafeParcelable {
    public static final Creator<CancelPendingActionsRequest> CREATOR = new zze();
    final int zzCY;
    final List<String> zzadW;

    CancelPendingActionsRequest(int versionCode, List<String> trackingTags) {
        this.zzCY = versionCode;
        this.zzadW = trackingTags;
    }

    public CancelPendingActionsRequest(List<String> trackingTags) {
        this(1, trackingTags);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
