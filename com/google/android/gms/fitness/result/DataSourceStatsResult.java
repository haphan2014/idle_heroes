package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;

public class DataSourceStatsResult implements SafeParcelable {
    public static final Creator<DataSourceStatsResult> CREATOR = new zzd();
    final int zzCY;
    public final long zzOw;
    public final DataSource zzajG;
    public final boolean zzamS;
    public final long zzamT;
    public final long zzamU;

    DataSourceStatsResult(int versionCode, DataSource dataSource, long id, boolean isRemote, long minEndTimeNanos, long maxEndTimeNanos) {
        this.zzCY = versionCode;
        this.zzajG = dataSource;
        this.zzOw = id;
        this.zzamS = isRemote;
        this.zzamT = minEndTimeNanos;
        this.zzamU = maxEndTimeNanos;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
