package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.List;

public final class RawDataSet implements SafeParcelable {
    public static final Creator<RawDataSet> CREATOR = new zzo();
    final int zzCY;
    public final boolean zzajU;
    public final int zzakH;
    public final int zzakJ;
    public final List<RawDataPoint> zzakK;

    public RawDataSet(int versionCode, int dataSourceIndex, int dataTypeIndex, List<RawDataPoint> rawDataPoints, boolean serverHasMoreData) {
        this.zzCY = versionCode;
        this.zzakH = dataSourceIndex;
        this.zzakJ = dataTypeIndex;
        this.zzakK = rawDataPoints;
        this.zzajU = serverHasMoreData;
    }

    public RawDataSet(DataSet dataSet, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.zzCY = 3;
        this.zzakK = dataSet.zzk(uniqueDataSources);
        this.zzajU = dataSet.zzqr();
        this.zzakH = zzs.zza(dataSet.getDataSource(), uniqueDataSources);
        this.zzakJ = zzs.zza(dataSet.getDataType(), uniqueDataTypes);
    }

    private boolean zza(RawDataSet rawDataSet) {
        return this.zzakH == rawDataSet.zzakH && this.zzajU == rawDataSet.zzajU && zzt.equal(this.zzakK, rawDataSet.zzakK);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof RawDataSet) && zza((RawDataSet) o));
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzakH));
    }

    public String toString() {
        return String.format("RawDataSet{%s@[%s]}", new Object[]{Integer.valueOf(this.zzakH), this.zzakK});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzo.zza(this, parcel, flags);
    }
}
