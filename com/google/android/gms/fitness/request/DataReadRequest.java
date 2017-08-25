package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Device;
import com.google.android.gms.internal.zzmf;
import com.google.android.gms.internal.zzmf.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataReadRequest implements SafeParcelable {
    public static final Creator<DataReadRequest> CREATOR = new zzf();
    public static final int NO_LIMIT = 0;
    private final int zzCY;
    private final long zzKT;
    private final String zzMZ;
    private final long zzajH;
    private final List<DataType> zzajQ;
    private final int zzajT;
    private final List<DataSource> zzalP;
    private final List<DataType> zzalU;
    private final List<DataSource> zzalV;
    private final long zzalW;
    private final DataSource zzalX;
    private final int zzalY;
    private final boolean zzalZ;
    private final boolean zzama;
    private final zzmf zzamb;
    private final List<Device> zzamc;

    public static class Builder {
        private long zzKT;
        private long zzajH;
        private List<DataType> zzajQ = new ArrayList();
        private int zzajT = 0;
        private List<DataSource> zzalP = new ArrayList();
        private List<DataType> zzalU = new ArrayList();
        private List<DataSource> zzalV = new ArrayList();
        private long zzalW = 0;
        private DataSource zzalX;
        private int zzalY = 0;
        private boolean zzalZ = false;
        private boolean zzama = false;
        private List<Device> zzamc = new ArrayList();

        public Builder aggregate(DataSource dataSource, DataType outputDataType) {
            zzu.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            zzu.zza(!this.zzalP.contains(dataSource), (Object) "Cannot add the same data source for aggregated and detailed");
            DataType dataType = dataSource.getDataType();
            zzu.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(dataType), "Unsupported input data type specified for aggregation: %s", dataType);
            zzu.zzb(DataType.getAggregatesForInput(dataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", dataType, outputDataType);
            if (!this.zzalV.contains(dataSource)) {
                this.zzalV.add(dataSource);
            }
            return this;
        }

        public Builder aggregate(DataType inputDataType, DataType outputDataType) {
            zzu.zzb((Object) inputDataType, (Object) "Attempting to use a null data type");
            zzu.zza(!this.zzajQ.contains(inputDataType), (Object) "Cannot add the same data type as aggregated and detailed");
            zzu.zzb(DataType.AGGREGATE_INPUT_TYPES.contains(inputDataType), "Unsupported input data type specified for aggregation: %s", inputDataType);
            zzu.zzb(DataType.getAggregatesForInput(inputDataType).contains(outputDataType), "Invalid output aggregate data type specified: %s -> %s", inputDataType, outputDataType);
            if (!this.zzalU.contains(inputDataType)) {
                this.zzalU.add(inputDataType);
            }
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit) {
            zzu.zzb(this.zzajT == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzajT));
            zzu.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzajT = 4;
            this.zzalW = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivitySegment(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            zzu.zzb(this.zzajT == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzajT));
            zzu.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            zzu.zzb(activityDataSource != null, (Object) "Invalid activity data source specified");
            zzu.zzb(activityDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.zzalX = activityDataSource;
            this.zzajT = 4;
            this.zzalW = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit) {
            zzu.zzb(this.zzajT == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzajT));
            zzu.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzajT = 3;
            this.zzalW = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByActivityType(int minDuration, TimeUnit timeUnit, DataSource activityDataSource) {
            zzu.zzb(this.zzajT == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzajT));
            zzu.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            zzu.zzb(activityDataSource != null, (Object) "Invalid activity data source specified");
            zzu.zzb(activityDataSource.getDataType().equals(DataType.TYPE_ACTIVITY_SEGMENT), "Invalid activity data source specified: %s", activityDataSource);
            this.zzalX = activityDataSource;
            this.zzajT = 3;
            this.zzalW = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketBySession(int minDuration, TimeUnit timeUnit) {
            zzu.zzb(this.zzajT == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzajT));
            zzu.zzb(minDuration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(minDuration));
            this.zzajT = 2;
            this.zzalW = timeUnit.toMillis((long) minDuration);
            return this;
        }

        public Builder bucketByTime(int duration, TimeUnit timeUnit) {
            zzu.zzb(this.zzajT == 0, "Bucketing strategy already set to %s", Integer.valueOf(this.zzajT));
            zzu.zzb(duration > 0, "Must specify a valid minimum duration for an activity segment: %d", Integer.valueOf(duration));
            this.zzajT = 1;
            this.zzalW = timeUnit.toMillis((long) duration);
            return this;
        }

        public DataReadRequest build() {
            boolean z = true;
            boolean z2 = (this.zzalP.isEmpty() && this.zzajQ.isEmpty() && this.zzalV.isEmpty() && this.zzalU.isEmpty()) ? false : true;
            zzu.zza(z2, (Object) "Must add at least one data source (aggregated or detailed)");
            zzu.zza(this.zzKT > 0, "Invalid start time: %s", Long.valueOf(this.zzKT));
            z2 = this.zzajH > 0 && this.zzajH > this.zzKT;
            zzu.zza(z2, "Invalid end time: %s", Long.valueOf(this.zzajH));
            z2 = this.zzalV.isEmpty() && this.zzalU.isEmpty();
            if (!(z2 && this.zzajT == 0) && (z2 || this.zzajT == 0)) {
                z = false;
            }
            zzu.zza(z, (Object) "Must specify a valid bucketing strategy while requesting aggregation");
            return new DataReadRequest();
        }

        public Builder enableServerQueries() {
            this.zzama = true;
            return this;
        }

        public Builder read(DataSource dataSource) {
            zzu.zzb((Object) dataSource, (Object) "Attempting to add a null data source");
            zzu.zzb(!this.zzalV.contains(dataSource), (Object) "Cannot add the same data source as aggregated and detailed");
            if (!this.zzalP.contains(dataSource)) {
                this.zzalP.add(dataSource);
            }
            return this;
        }

        public Builder read(DataType dataType) {
            zzu.zzb((Object) dataType, (Object) "Attempting to use a null data type");
            zzu.zza(!this.zzalU.contains(dataType), (Object) "Cannot add the same data type as aggregated and detailed");
            if (!this.zzajQ.contains(dataType)) {
                this.zzajQ.add(dataType);
            }
            return this;
        }

        public Builder setLimit(int limit) {
            zzu.zzb(limit > 0, "Invalid limit %d is specified", Integer.valueOf(limit));
            this.zzalY = limit;
            return this;
        }

        public Builder setTimeRange(long start, long end, TimeUnit timeUnit) {
            this.zzKT = timeUnit.toMillis(start);
            this.zzajH = timeUnit.toMillis(end);
            return this;
        }
    }

    DataReadRequest(int versionCode, List<DataType> dataTypes, List<DataSource> dataSources, long startTimeMillis, long endTimeMillis, List<DataType> aggregatedDataTypes, List<DataSource> aggregatedDataSources, int bucketType, long bucketDurationMillis, DataSource activityDataSource, int limit, boolean flushBeforeRead, boolean serverQueriesEnabled, IBinder callback, String packageName, List<Device> filteredDevices) {
        this.zzCY = versionCode;
        this.zzajQ = Collections.unmodifiableList(dataTypes);
        this.zzalP = Collections.unmodifiableList(dataSources);
        this.zzKT = startTimeMillis;
        this.zzajH = endTimeMillis;
        this.zzalU = Collections.unmodifiableList(aggregatedDataTypes);
        this.zzalV = Collections.unmodifiableList(aggregatedDataSources);
        this.zzajT = bucketType;
        this.zzalW = bucketDurationMillis;
        this.zzalX = activityDataSource;
        this.zzalY = limit;
        this.zzalZ = flushBeforeRead;
        this.zzama = serverQueriesEnabled;
        this.zzamb = callback == null ? null : zza.zzbq(callback);
        this.zzMZ = packageName;
        if (filteredDevices == null) {
            filteredDevices = Collections.EMPTY_LIST;
        }
        this.zzamc = filteredDevices;
    }

    private DataReadRequest(Builder builder) {
        this(builder.zzajQ, builder.zzalP, builder.zzKT, builder.zzajH, builder.zzalU, builder.zzalV, builder.zzajT, builder.zzalW, builder.zzalX, builder.zzalY, builder.zzalZ, builder.zzama, null, null, builder.zzamc);
    }

    public DataReadRequest(DataReadRequest request, zzmf callback, String packageName) {
        this(request.zzajQ, request.zzalP, request.zzKT, request.zzajH, request.zzalU, request.zzalV, request.zzajT, request.zzalW, request.zzalX, request.zzalY, request.zzalZ, request.zzama, callback, packageName, request.zzamc);
    }

    public DataReadRequest(List<DataType> dataTypes, List<DataSource> dataSources, long startTimeMillis, long endTimeMillis, List<DataType> aggregatedDataTypes, List<DataSource> aggregatedDataSources, int bucketType, long bucketDurationMillis, DataSource activityDataSource, int limit, boolean flushBeforeRead, boolean serverQueriesEnabled, zzmf callback, String packageName, List<Device> filteredDevices) {
        this.zzCY = 4;
        this.zzajQ = Collections.unmodifiableList(dataTypes);
        this.zzalP = Collections.unmodifiableList(dataSources);
        this.zzKT = startTimeMillis;
        this.zzajH = endTimeMillis;
        this.zzalU = Collections.unmodifiableList(aggregatedDataTypes);
        this.zzalV = Collections.unmodifiableList(aggregatedDataSources);
        this.zzajT = bucketType;
        this.zzalW = bucketDurationMillis;
        this.zzalX = activityDataSource;
        this.zzalY = limit;
        this.zzalZ = flushBeforeRead;
        this.zzama = serverQueriesEnabled;
        this.zzamb = callback;
        this.zzMZ = packageName;
        this.zzamc = filteredDevices;
    }

    private boolean zzb(DataReadRequest dataReadRequest) {
        return this.zzajQ.equals(dataReadRequest.zzajQ) && this.zzalP.equals(dataReadRequest.zzalP) && this.zzKT == dataReadRequest.zzKT && this.zzajH == dataReadRequest.zzajH && this.zzajT == dataReadRequest.zzajT && this.zzalV.equals(dataReadRequest.zzalV) && this.zzalU.equals(dataReadRequest.zzalU) && zzt.equal(this.zzalX, dataReadRequest.zzalX) && this.zzalW == dataReadRequest.zzalW && this.zzama == dataReadRequest.zzama;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataReadRequest) && zzb((DataReadRequest) that));
    }

    public DataSource getActivityDataSource() {
        return this.zzalX;
    }

    public List<DataSource> getAggregatedDataSources() {
        return this.zzalV;
    }

    public List<DataType> getAggregatedDataTypes() {
        return this.zzalU;
    }

    public long getBucketDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzalW, TimeUnit.MILLISECONDS);
    }

    public int getBucketType() {
        return this.zzajT;
    }

    public List<DataSource> getDataSources() {
        return this.zzalP;
    }

    public List<DataType> getDataTypes() {
        return this.zzajQ;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzajH, TimeUnit.MILLISECONDS);
    }

    public int getLimit() {
        return this.zzalY;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzKT, TimeUnit.MILLISECONDS);
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzajT), Long.valueOf(this.zzKT), Long.valueOf(this.zzajH));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataReadRequest{");
        if (!this.zzajQ.isEmpty()) {
            for (DataType zzqD : this.zzajQ) {
                stringBuilder.append(zzqD.zzqD()).append(" ");
            }
        }
        if (!this.zzalP.isEmpty()) {
            for (DataSource toDebugString : this.zzalP) {
                stringBuilder.append(toDebugString.toDebugString()).append(" ");
            }
        }
        if (this.zzajT != 0) {
            stringBuilder.append("bucket by ").append(Bucket.zzeb(this.zzajT));
            if (this.zzalW > 0) {
                stringBuilder.append(" >").append(this.zzalW).append("ms");
            }
            stringBuilder.append(": ");
        }
        if (!this.zzalU.isEmpty()) {
            for (DataType zzqD2 : this.zzalU) {
                stringBuilder.append(zzqD2.zzqD()).append(" ");
            }
        }
        if (!this.zzalV.isEmpty()) {
            for (DataSource toDebugString2 : this.zzalV) {
                stringBuilder.append(toDebugString2.toDebugString()).append(" ");
            }
        }
        stringBuilder.append(String.format("(%tF %tT - %tF %tT)", new Object[]{Long.valueOf(this.zzKT), Long.valueOf(this.zzKT), Long.valueOf(this.zzajH), Long.valueOf(this.zzajH)}));
        if (this.zzalX != null) {
            stringBuilder.append("activities: ").append(this.zzalX.toDebugString());
        }
        if (this.zzama) {
            stringBuilder.append(" +server");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public long zzkt() {
        return this.zzKT;
    }

    public IBinder zzqU() {
        return this.zzamb == null ? null : this.zzamb.asBinder();
    }

    public boolean zzqZ() {
        return this.zzama;
    }

    public long zzqs() {
        return this.zzajH;
    }

    public boolean zzra() {
        return this.zzalZ;
    }

    public long zzrb() {
        return this.zzalW;
    }

    public List<Device> zzrc() {
        return this.zzamc;
    }
}
