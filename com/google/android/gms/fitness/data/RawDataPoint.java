package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class RawDataPoint implements SafeParcelable {
    public static final Creator<RawDataPoint> CREATOR = new zzn();
    final int zzCY;
    public final long zzajV;
    public final long zzajW;
    public final Value[] zzajX;
    public final long zzajZ;
    public final int zzakH;
    public final int zzakI;
    public final long zzaka;

    public RawDataPoint(int versionCode, long timestampNanos, long startTimeNanos, Value[] values, int dataSourceIndex, int originalDataSourceIndex, long rawTimestamp, long insertionTimeMillis) {
        this.zzCY = versionCode;
        this.zzajV = timestampNanos;
        this.zzajW = startTimeNanos;
        this.zzakH = dataSourceIndex;
        this.zzakI = originalDataSourceIndex;
        this.zzajZ = rawTimestamp;
        this.zzaka = insertionTimeMillis;
        this.zzajX = values;
    }

    RawDataPoint(DataPoint dataPoint, List<DataSource> dataSources) {
        this.zzCY = 4;
        this.zzajV = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
        this.zzajW = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
        this.zzajX = dataPoint.zzqu();
        this.zzakH = zzs.zza(dataPoint.getDataSource(), dataSources);
        this.zzakI = zzs.zza(dataPoint.getOriginalDataSource(), dataSources);
        this.zzajZ = dataPoint.zzqv();
        this.zzaka = dataPoint.zzqw();
    }

    private boolean zza(RawDataPoint rawDataPoint) {
        return this.zzajV == rawDataPoint.zzajV && this.zzajW == rawDataPoint.zzajW && Arrays.equals(this.zzajX, rawDataPoint.zzajX) && this.zzakH == rawDataPoint.zzakH && this.zzakI == rawDataPoint.zzakI && this.zzajZ == rawDataPoint.zzajZ;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataPoint) && zza((RawDataPoint) o));
    }

    public int hashCode() {
        return zzt.hashCode(Long.valueOf(this.zzajV), Long.valueOf(this.zzajW));
    }

    public String toString() {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[]{Arrays.toString(this.zzajX), Long.valueOf(this.zzajW), Long.valueOf(this.zzajV), Integer.valueOf(this.zzakH), Integer.valueOf(this.zzakI)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzn.zza(this, parcel, flags);
    }
}
