package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CheckResourceIdsExistRequest implements SafeParcelable {
    public static final Creator<CheckResourceIdsExistRequest> CREATOR = new zzf();
    private final int zzCY;
    private final List<String> zzaep;

    CheckResourceIdsExistRequest(int versionCode, List<String> resourceIds) {
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
        zzf.zza(this, dest, flags);
    }

    public List<String> zzpA() {
        return this.zzaep;
    }
}
