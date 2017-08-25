package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class DataStatsResult implements Result, SafeParcelable {
    public static final Creator<DataStatsResult> CREATOR = new zzf();
    private final int zzCY;
    private final Status zzOt;
    private final List<DataSourceStatsResult> zzamV;

    DataStatsResult(int versionCode, Status status, List<DataSourceStatsResult> dataSourceStats) {
        this.zzCY = versionCode;
        this.zzOt = status;
        this.zzamV = dataSourceStats;
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return this.zzOt;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    List<DataSourceStatsResult> zzrx() {
        return this.zzamV;
    }
}
