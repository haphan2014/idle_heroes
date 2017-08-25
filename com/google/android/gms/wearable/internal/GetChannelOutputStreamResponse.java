package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetChannelOutputStreamResponse implements SafeParcelable {
    public static final Creator<GetChannelOutputStreamResponse> CREATOR = new zzah();
    public final int statusCode;
    public final int versionCode;
    public final ParcelFileDescriptor zzaUs;

    GetChannelOutputStreamResponse(int versionCode, int statusCode, ParcelFileDescriptor fileDescriptor) {
        this.versionCode = versionCode;
        this.statusCode = statusCode;
        this.zzaUs = fileDescriptor;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzah.zza(this, dest, flags);
    }
}
