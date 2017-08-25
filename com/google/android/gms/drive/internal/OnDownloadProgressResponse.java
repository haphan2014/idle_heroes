package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Creator<OnDownloadProgressResponse> CREATOR = new zzaw();
    final int zzCY;
    final long zzagg;
    final long zzagh;

    OnDownloadProgressResponse(int versionCode, long bytesLoaded, long bytesExpected) {
        this.zzCY = versionCode;
        this.zzagg = bytesLoaded;
        this.zzagh = bytesExpected;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaw.zza(this, dest, flags);
    }

    public long zzpM() {
        return this.zzagg;
    }

    public long zzpN() {
        return this.zzagh;
    }
}
