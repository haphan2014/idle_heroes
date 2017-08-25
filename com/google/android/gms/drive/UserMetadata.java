package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class UserMetadata implements SafeParcelable {
    public static final Creator<UserMetadata> CREATOR = new zzj();
    final int zzCY;
    final String zzadH;
    final String zzadI;
    final String zzadJ;
    final boolean zzadK;
    final String zzadL;

    UserMetadata(int versionCode, String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this.zzCY = versionCode;
        this.zzadH = permissionId;
        this.zzadI = displayName;
        this.zzadJ = pictureUrl;
        this.zzadK = isAuthenticatedUser;
        this.zzadL = emailAddress;
    }

    public UserMetadata(String permissionId, String displayName, String pictureUrl, boolean isAuthenticatedUser, String emailAddress) {
        this(1, permissionId, displayName, pictureUrl, isAuthenticatedUser, emailAddress);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("Permission ID: '%s', Display Name: '%s', Picture URL: '%s', Authenticated User: %b, Email: '%s'", new Object[]{this.zzadH, this.zzadI, this.zzadJ, Boolean.valueOf(this.zzadK), this.zzadL});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }
}
