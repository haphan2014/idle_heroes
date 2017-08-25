package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class OnMetadataResponse implements SafeParcelable {
    public static final Creator<OnMetadataResponse> CREATOR = new zzbd();
    final int zzCY;
    final MetadataBundle zzaeA;

    OnMetadataResponse(int versionCode, MetadataBundle metadata) {
        this.zzCY = versionCode;
        this.zzaeA = metadata;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbd.zza(this, dest, flags);
    }

    public MetadataBundle zzpS() {
        return this.zzaeA;
    }
}
