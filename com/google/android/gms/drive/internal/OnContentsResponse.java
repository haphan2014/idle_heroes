package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Contents;

public class OnContentsResponse implements SafeParcelable {
    public static final Creator<OnContentsResponse> CREATOR = new zzau();
    final int zzCY;
    final Contents zzafa;
    final boolean zzage;

    OnContentsResponse(int versionCode, Contents contents, boolean outOfDate) {
        this.zzCY = versionCode;
        this.zzafa = contents;
        this.zzage = outOfDate;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzau.zza(this, dest, flags);
    }

    public Contents zzpJ() {
        return this.zzafa;
    }

    public boolean zzpK() {
        return this.zzage;
    }
}
