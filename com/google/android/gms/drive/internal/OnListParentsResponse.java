package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.WriteAwareParcelable;

public class OnListParentsResponse extends WriteAwareParcelable implements SafeParcelable {
    public static final Creator<OnListParentsResponse> CREATOR = new zzbc();
    final int zzCY;
    final DataHolder zzagq;

    OnListParentsResponse(int versionCode, DataHolder parents) {
        this.zzCY = versionCode;
        this.zzagq = parents;
    }

    public int describeContents() {
        return 0;
    }

    protected void zzI(Parcel parcel, int i) {
        zzbc.zza(this, parcel, i);
    }

    public DataHolder zzpR() {
        return this.zzagq;
    }
}
