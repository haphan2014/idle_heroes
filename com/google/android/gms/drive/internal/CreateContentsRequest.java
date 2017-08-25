package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.DriveFile;

public class CreateContentsRequest implements SafeParcelable {
    public static final Creator<CreateContentsRequest> CREATOR = new zzi();
    final int zzCY;
    final int zzacS;

    public CreateContentsRequest(int mode) {
        this(1, mode);
    }

    CreateContentsRequest(int versionCode, int mode) {
        this.zzCY = versionCode;
        boolean z = mode == DriveFile.MODE_WRITE_ONLY || mode == DriveFile.MODE_READ_WRITE;
        zzu.zzb(z, (Object) "Cannot create a new read-only contents!");
        this.zzacS = mode;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
