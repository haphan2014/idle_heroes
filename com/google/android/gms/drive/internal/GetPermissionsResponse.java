package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.Permission;
import java.util.List;

public class GetPermissionsResponse implements SafeParcelable {
    public static final Creator<GetPermissionsResponse> CREATOR = new zzaj();
    final int zzCY;
    final List<Permission> zzafO;
    final int zzws;

    GetPermissionsResponse(int versionCode, List<Permission> permissionList, int responseCode) {
        this.zzCY = versionCode;
        this.zzafO = permissionList;
        this.zzws = responseCode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaj.zza(this, dest, flags);
    }
}
