package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzlu;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class DataPoint implements SafeParcelable {
    public static final Creator<DataPoint> CREATOR = new zzd();
    private final int zzCY;
    private final DataSource zzajG;
    private long zzajV;
    private long zzajW;
    private final Value[] zzajX;
    private DataSource zzajY;
    private long zzajZ;
    private long zzaka;

    DataPoint(int versionCode, DataSource dataSource, long timestampNanos, long startTimeNanos, Value[] values, DataSource originalDataSource, long rawTimestamp, long insertionTimeMillis) {
        this.zzCY = versionCode;
        this.zzajG = dataSource;
        this.zzajY = originalDataSource;
        this.zzajV = timestampNanos;
        this.zzajW = startTimeNanos;
        this.zzajX = values;
        this.zzajZ = rawTimestamp;
        this.zzaka = insertionTimeMillis;
    }

    private DataPoint(DataSource dataSource) {
        this.zzCY = 4;
        this.zzajG = (DataSource) zzu.zzb((Object) dataSource, (Object) "Data source cannot be null");
        List<Field> fields = dataSource.getDataType().getFields();
        this.zzajX = new Value[fields.size()];
        int i = 0;
        for (Field format : fields) {
            this.zzajX[i] = new Value(format.getFormat());
            i++;
        }
    }

    public DataPoint(DataSource dataSource, DataSource originalDataSource, RawDataPoint rawDataPoint) {
        this(4, dataSource, zza(Long.valueOf(rawDataPoint.zzajV), 0), zza(Long.valueOf(rawDataPoint.zzajW), 0), rawDataPoint.zzajX, originalDataSource, zza(Long.valueOf(rawDataPoint.zzajZ), 0), zza(Long.valueOf(rawDataPoint.zzaka), 0));
    }

    DataPoint(List<DataSource> dataSources, RawDataPoint rawDataPoint) {
        this(zza((List) dataSources, rawDataPoint.zzakH), zza((List) dataSources, rawDataPoint.zzakI), rawDataPoint);
    }

    public static DataPoint create(DataSource dataSource) {
        return new DataPoint(dataSource);
    }

    public static DataPoint extract(Intent intent) {
        return intent == null ? null : (DataPoint) zzc.zza(intent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
    }

    private static long zza(Long l, long j) {
        return l != null ? l.longValue() : j;
    }

    private static DataSource zza(List<DataSource> list, int i) {
        return (i < 0 || i >= list.size()) ? null : (DataSource) list.get(i);
    }

    private boolean zza(DataPoint dataPoint) {
        return zzt.equal(this.zzajG, dataPoint.zzajG) && this.zzajV == dataPoint.zzajV && this.zzajW == dataPoint.zzajW && Arrays.equals(this.zzajX, dataPoint.zzajX) && zzt.equal(this.zzajY, dataPoint.zzajY);
    }

    private void zzed(int i) {
        zzu.zzb(i == getDataType().getFields().size(), "Attempting to insert %s values, but needed %s: %s", Integer.valueOf(i), Integer.valueOf(getDataType().getFields().size()), getDataType().getFields());
    }

    private boolean zzqt() {
        return getDataType() == DataType.TYPE_LOCATION_SAMPLE;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof DataPoint) && zza((DataPoint) o));
    }

    public DataSource getDataSource() {
        return this.zzajG;
    }

    public DataType getDataType() {
        return this.zzajG.getDataType();
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzajV, TimeUnit.NANOSECONDS);
    }

    public DataSource getOriginalDataSource() {
        return this.zzajY;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzajW, TimeUnit.NANOSECONDS);
    }

    public long getTimestamp(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzajV, TimeUnit.NANOSECONDS);
    }

    public long getTimestampNanos() {
        return this.zzajV;
    }

    public Value getValue(Field field) {
        return this.zzajX[getDataType().indexOf(field)];
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzajG, Long.valueOf(this.zzajV), Long.valueOf(this.zzajW));
    }

    public DataPoint setFloatValues(float... values) {
        zzed(values.length);
        for (int i = 0; i < values.length; i++) {
            this.zzajX[i].setFloat(values[i]);
        }
        return this;
    }

    public DataPoint setIntValues(int... values) {
        zzed(values.length);
        for (int i = 0; i < values.length; i++) {
            this.zzajX[i].setInt(values[i]);
        }
        return this;
    }

    public DataPoint setTimeInterval(long startTime, long endTime, TimeUnit timeUnit) {
        this.zzajW = timeUnit.toNanos(startTime);
        this.zzajV = timeUnit.toNanos(endTime);
        return this;
    }

    public DataPoint setTimestamp(long timestamp, TimeUnit timeUnit) {
        this.zzajV = timeUnit.toNanos(timestamp);
        if (zzqt() && zzlu.zza(timeUnit)) {
            Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
            this.zzajV = zzlu.zza(this.zzajV, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public String toString() {
        String str = "DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}";
        Object[] objArr = new Object[7];
        objArr[0] = Arrays.toString(this.zzajX);
        objArr[1] = Long.valueOf(this.zzajW);
        objArr[2] = Long.valueOf(this.zzajV);
        objArr[3] = Long.valueOf(this.zzajZ);
        objArr[4] = Long.valueOf(this.zzaka);
        objArr[5] = this.zzajG.toDebugString();
        objArr[6] = this.zzajY != null ? this.zzajY.toDebugString() : "N/A";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzd.zza(this, parcel, flags);
    }

    public Value[] zzqu() {
        return this.zzajX;
    }

    public long zzqv() {
        return this.zzajZ;
    }

    public long zzqw() {
        return this.zzaka;
    }

    public void zzqx() {
        zzu.zzb(getDataType().getName().equals(getDataSource().getDataType().getName()), "Conflicting data types found %s vs %s", getDataType(), getDataType());
        zzu.zzb(this.zzajV > 0, "Data point does not have the timestamp set: %s", this);
        zzu.zzb(this.zzajW <= this.zzajV, "Data point with start time greater than end time found: %s", this);
    }

    public long zzqy() {
        return this.zzajW;
    }
}
