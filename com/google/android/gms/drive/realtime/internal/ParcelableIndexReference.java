package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference implements SafeParcelable {
    public static final Creator<ParcelableIndexReference> CREATOR = new zzq();
    final int mIndex;
    final int zzCY;
    final String zzaiw;
    final boolean zzaix;
    final int zzaiy;

    ParcelableIndexReference(int versionCode, String objectId, int index, boolean legacyCanBeDeleted, int deleteMode) {
        this.zzCY = versionCode;
        this.zzaiw = objectId;
        this.mIndex = index;
        this.zzaix = legacyCanBeDeleted;
        this.zzaiy = deleteMode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }
}
