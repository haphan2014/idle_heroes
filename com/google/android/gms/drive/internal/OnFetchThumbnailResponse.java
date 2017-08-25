package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnFetchThumbnailResponse implements SafeParcelable {
    public static final Creator<OnFetchThumbnailResponse> CREATOR = new zzba();
    final int zzCY;
    final ParcelFileDescriptor zzago;

    OnFetchThumbnailResponse(int versionCode, ParcelFileDescriptor thumbnailPfd) {
        this.zzCY = versionCode;
        this.zzago = thumbnailPfd;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzba.zza(this, dest, flags | 1);
    }
}
