package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DrivePreferences;

public class SetDrivePreferencesRequest implements SafeParcelable {
    public static final Creator<SetDrivePreferencesRequest> CREATOR = new zzbn();
    final int zzCY;
    final DrivePreferences zzagi;

    SetDrivePreferencesRequest(int versionCode, DrivePreferences prefs) {
        this.zzCY = versionCode;
        this.zzagi = prefs;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbn.zza(this, dest, flags);
    }
}
