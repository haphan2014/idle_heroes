package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class OnResourceIdSetResponse implements SafeParcelable {
    public static final Creator<OnResourceIdSetResponse> CREATOR = new zzbf();
    private final int zzCY;
    private final List<String> zzaep;

    OnResourceIdSetResponse(int versionCode, List<String> resourceIds) {
        this.zzCY = versionCode;
        this.zzaep = resourceIds;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbf.zza(this, dest, flags);
    }

    public List<String> zzpA() {
        return this.zzaep;
    }
}
