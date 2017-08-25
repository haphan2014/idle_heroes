package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.ICancelToken.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DriveServiceResponse implements SafeParcelable {
    public static final Creator<DriveServiceResponse> CREATOR = new zzab();
    final int zzCY;
    final IBinder zzafB;

    DriveServiceResponse(int versionCode, IBinder cancelToken) {
        this.zzCY = versionCode;
        this.zzafB = cancelToken;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzab.zza(this, dest, flags);
    }

    public ICancelToken zzpF() {
        return zza.zzaE(this.zzafB);
    }
}
