package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetFdForAssetResponse implements SafeParcelable {
    public static final Creator<GetFdForAssetResponse> CREATOR = new zzao();
    public final int statusCode;
    public final int versionCode;
    public final ParcelFileDescriptor zzaUy;

    GetFdForAssetResponse(int versionCode, int statusCode, ParcelFileDescriptor pfd) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzaUy = pfd;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzao.zza(this, dest, flags | 1);
    }
}
