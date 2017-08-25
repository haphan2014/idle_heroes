package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DataSet implements SafeParcelable {
    public static final Creator<DataSet> CREATOR = new zze();
    private final int zzCY;
    private final DataType zzajF;
    private final DataSource zzajG;
    private boolean zzajU;
    private final List<DataPoint> zzakb;
    private final List<DataSource> zzakc;

    DataSet(int versionCode, DataSource dataSource, DataType dataType, List<RawDataPoint> dataPoints, List<DataSource> uniqueDataSources, boolean serverHasMoreData) {
        this.zzajU = false;
        this.zzCY = versionCode;
        this.zzajG = dataSource;
        this.zzajF = dataSource.getDataType();
        this.zzajU = serverHasMoreData;
        this.zzakb = new ArrayList(dataPoints.size());
        if (versionCode < 2) {
            uniqueDataSources = Collections.singletonList(dataSource);
        }
        this.zzakc = uniqueDataSources;
        for (RawDataPoint dataPoint : dataPoints) {
            this.zzakb.add(new DataPoint(this.zzakc, dataPoint));
        }
    }

    public DataSet(DataSource dataSource) {
        this.zzajU = false;
        this.zzCY = 3;
        this.zzajG = (DataSource) zzu.zzu(dataSource);
        this.zzajF = dataSource.getDataType();
        this.zzakb = new ArrayList();
        this.zzakc = new ArrayList();
        this.zzakc.add(this.zzajG);
    }

    public DataSet(RawDataSet dataSet, List<DataSource> uniqueDataSources) {
        this.zzajU = false;
        this.zzCY = 3;
        this.zzajG = (DataSource) zzb(uniqueDataSources, dataSet.zzakH);
        this.zzajF = this.zzajG.getDataType();
        this.zzakc = uniqueDataSources;
        this.zzajU = dataSet.zzajU;
        List<RawDataPoint> list = dataSet.zzakK;
        this.zzakb = new ArrayList(list.size());
        for (RawDataPoint dataPoint : list) {
            this.zzakb.add(new DataPoint(this.zzakc, dataPoint));
        }
    }

    public static DataSet create(DataSource dataSource) {
        zzu.zzb((Object) dataSource, (Object) "DataSource should be specified");
        return new DataSet(dataSource);
    }

    private boolean zza(DataSet dataSet) {
        return zzt.equal(getDataType(), dataSet.getDataType()) && zzt.equal(this.zzajG, dataSet.zzajG) && zzt.equal(this.zzakb, dataSet.zzakb) && this.zzajU == dataSet.zzajU;
    }

    private static <T> T zzb(List<T> list, int i) {
        return (i < 0 || i >= list.size()) ? null : list.get(i);
    }

    public void add(DataPoint dataPoint) {
        Object[] objArr = new Object[]{dataPoint.getDataSource(), this.zzajG};
        zzu.zzb(dataPoint.getDataSource().getStreamIdentifier().equals(this.zzajG.getStreamIdentifier()), "Conflicting data sources found %s vs %s", objArr);
        dataPoint.zzqx();
        zzb(dataPoint);
    }

    public void addAll(Iterable<DataPoint> dataPoints) {
        for (DataPoint add : dataPoints) {
            add(add);
        }
    }

    public DataPoint createDataPoint() {
        return DataPoint.create(this.zzajG);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataSet) && zza((DataSet) o));
    }

    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.zzakb);
    }

    public DataSource getDataSource() {
        return this.zzajG;
    }

    public DataType getDataType() {
        return this.zzajG.getDataType();
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzajG);
    }

    public boolean isEmpty() {
        return this.zzakb.isEmpty();
    }

    public String toString() {
        List zzqz = zzqz();
        String str = "DataSet{%s %s}";
        Object[] objArr = new Object[2];
        objArr[0] = this.zzajG.toDebugString();
        if (this.zzakb.size() >= 10) {
            zzqz = String.format("%d data points, first 5: %s", new Object[]{Integer.valueOf(this.zzakb.size()), zzqz.subList(0, 5)});
        }
        objArr[1] = zzqz;
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }

    public void zzb(DataPoint dataPoint) {
        this.zzakb.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null && !this.zzakc.contains(originalDataSource)) {
            this.zzakc.add(originalDataSource);
        }
    }

    public void zzb(Iterable<DataPoint> iterable) {
        for (DataPoint zzb : iterable) {
            zzb(zzb);
        }
    }

    List<RawDataPoint> zzk(List<DataSource> list) {
        List<RawDataPoint> arrayList = new ArrayList(this.zzakb.size());
        for (DataPoint rawDataPoint : this.zzakb) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }

    List<DataSource> zzqA() {
        return this.zzakc;
    }

    public boolean zzqr() {
        return this.zzajU;
    }

    List<RawDataPoint> zzqz() {
        return zzk(this.zzakc);
    }
}
