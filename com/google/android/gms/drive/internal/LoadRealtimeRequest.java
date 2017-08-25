package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class LoadRealtimeRequest implements SafeParcelable {
    public static final Creator<LoadRealtimeRequest> CREATOR = new zzap();
    final int zzCY;
    final DriveId zzacT;
    final boolean zzafQ;
    final List<String> zzafR;
    final boolean zzafS;
    final DataHolder zzafT;

    LoadRealtimeRequest(int versionCode, DriveId driveId, boolean useTestMode, List<String> customTypeWhitelist, boolean isInMemory, DataHolder json) {
        this.zzCY = versionCode;
        this.zzacT = driveId;
        this.zzafQ = useTestMode;
        this.zzafR = customTypeWhitelist;
        this.zzafS = isInMemory;
        this.zzafT = json;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzap.zza(this, dest, flags);
    }
}
