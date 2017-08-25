package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzlu;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmu.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest implements SafeParcelable {
    public static final Creator<SessionInsertRequest> CREATOR = new zzu();
    private final int zzCY;
    private final String zzMZ;
    private final Session zzajJ;
    private final List<DataSet> zzajS;
    private final zzmu zzalN;
    private final List<DataPoint> zzamC;

    public static class Builder {
        private Session zzajJ;
        private List<DataSet> zzajS = new ArrayList();
        private List<DataPoint> zzamC = new ArrayList();
        private List<DataSource> zzamD = new ArrayList();

        private void zzd(DataPoint dataPoint) {
            zzf(dataPoint);
            zze(dataPoint);
        }

        private void zze(DataPoint dataPoint) {
            long startTime = this.zzajJ.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzajJ.getEndTime(TimeUnit.NANOSECONDS);
            long startTime2 = dataPoint.getStartTime(TimeUnit.NANOSECONDS);
            long endTime2 = dataPoint.getEndTime(TimeUnit.NANOSECONDS);
            if (startTime2 != 0 && endTime2 != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (endTime2 > endTime) {
                    endTime2 = zzlu.zza(endTime2, TimeUnit.NANOSECONDS, timeUnit);
                }
                boolean z = startTime2 >= startTime && endTime2 <= endTime;
                zzu.zza(z, "Data point %s has start and end times outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (endTime2 != dataPoint.getEndTime(TimeUnit.NANOSECONDS)) {
                    Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.getEndTime(TimeUnit.NANOSECONDS)), Long.valueOf(endTime2), timeUnit}));
                    dataPoint.setTimeInterval(startTime2, endTime2, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void zzf(DataPoint dataPoint) {
            long startTime = this.zzajJ.getStartTime(TimeUnit.NANOSECONDS);
            long endTime = this.zzajJ.getEndTime(TimeUnit.NANOSECONDS);
            long timestamp = dataPoint.getTimestamp(TimeUnit.NANOSECONDS);
            if (timestamp != 0) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                if (timestamp < startTime || timestamp > endTime) {
                    timestamp = zzlu.zza(timestamp, TimeUnit.NANOSECONDS, timeUnit);
                }
                boolean z = timestamp >= startTime && timestamp <= endTime;
                zzu.zza(z, "Data point %s has time stamp outside session interval [%d, %d]", dataPoint, Long.valueOf(startTime), Long.valueOf(endTime));
                if (dataPoint.getTimestamp(TimeUnit.NANOSECONDS) != timestamp) {
                    Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", new Object[]{Long.valueOf(dataPoint.getTimestamp(TimeUnit.NANOSECONDS)), Long.valueOf(timestamp), timeUnit}));
                    dataPoint.setTimestamp(timestamp, TimeUnit.NANOSECONDS);
                }
            }
        }

        private void zzrn() {
            for (DataSet dataPoints : this.zzajS) {
                for (DataPoint zzd : dataPoints.getDataPoints()) {
                    zzd(zzd);
                }
            }
            for (DataPoint zzd2 : this.zzamC) {
                zzd(zzd2);
            }
        }

        public Builder addAggregateDataPoint(DataPoint aggregateDataPoint) {
            zzu.zzb(aggregateDataPoint != null, (Object) "Must specify a valid aggregate data point.");
            long startTime = aggregateDataPoint.getStartTime(TimeUnit.NANOSECONDS);
            boolean z = startTime > 0 && aggregateDataPoint.getEndTime(TimeUnit.NANOSECONDS) > startTime;
            zzu.zzb(z, "Aggregate data point should have valid start and end times: %s", aggregateDataPoint);
            DataSource dataSource = aggregateDataPoint.getDataSource();
            zzu.zza(!this.zzamD.contains(dataSource), "Data set/Aggregate data point for this data source %s is already added.", dataSource);
            this.zzamD.add(dataSource);
            this.zzamC.add(aggregateDataPoint);
            return this;
        }

        public Builder addDataSet(DataSet dataSet) {
            boolean z = true;
            zzu.zzb(dataSet != null, (Object) "Must specify a valid data set.");
            DataSource dataSource = dataSet.getDataSource();
            zzu.zza(!this.zzamD.contains(dataSource), "Data set for this data source %s is already added.", dataSource);
            if (dataSet.getDataPoints().isEmpty()) {
                z = false;
            }
            zzu.zzb(z, (Object) "No data points specified in the input data set.");
            this.zzamD.add(dataSource);
            this.zzajS.add(dataSet);
            return this;
        }

        public SessionInsertRequest build() {
            boolean z = true;
            zzu.zza(this.zzajJ != null, (Object) "Must specify a valid session.");
            if (this.zzajJ.getEndTime(TimeUnit.MILLISECONDS) == 0) {
                z = false;
            }
            zzu.zza(z, (Object) "Must specify a valid end time, cannot insert a continuing session.");
            zzrn();
            return new SessionInsertRequest();
        }

        public Builder setSession(Session session) {
            this.zzajJ = session;
            return this;
        }
    }

    SessionInsertRequest(int versionCode, Session session, List<DataSet> dataSets, List<DataPoint> aggregateDataPoints, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.zzajJ = session;
        this.zzajS = Collections.unmodifiableList(dataSets);
        this.zzamC = Collections.unmodifiableList(aggregateDataPoints);
        this.zzalN = callback == null ? null : zza.zzbF(callback);
        this.zzMZ = packageName;
    }

    public SessionInsertRequest(Session session, List<DataSet> dataSets, List<DataPoint> aggregateDataPoints, zzmu callback, String packageName) {
        this.zzCY = 2;
        this.zzajJ = session;
        this.zzajS = Collections.unmodifiableList(dataSets);
        this.zzamC = Collections.unmodifiableList(aggregateDataPoints);
        this.zzalN = callback;
        this.zzMZ = packageName;
    }

    private SessionInsertRequest(Builder builder) {
        this(builder.zzajJ, builder.zzajS, builder.zzamC, null, null);
    }

    public SessionInsertRequest(SessionInsertRequest request, zzmu callback, String packageName) {
        this(request.zzajJ, request.zzajS, request.zzamC, callback, packageName);
    }

    private boolean zzb(SessionInsertRequest sessionInsertRequest) {
        return zzt.equal(this.zzajJ, sessionInsertRequest.zzajJ) && zzt.equal(this.zzajS, sessionInsertRequest.zzajS) && zzt.equal(this.zzamC, sessionInsertRequest.zzamC);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionInsertRequest) && zzb((SessionInsertRequest) o));
    }

    public List<DataPoint> getAggregateDataPoints() {
        return this.zzamC;
    }

    public List<DataSet> getDataSets() {
        return this.zzajS;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    public Session getSession() {
        return this.zzajJ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzajJ, this.zzajS, this.zzamC);
    }

    public String toString() {
        return zzt.zzt(this).zzg("session", this.zzajJ).zzg("dataSets", this.zzajS).zzg("aggregateDataPoints", this.zzamC).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzu.zza(this, dest, flags);
    }

    public IBinder zzqU() {
        return this.zzalN == null ? null : this.zzalN.asBinder();
    }
}
