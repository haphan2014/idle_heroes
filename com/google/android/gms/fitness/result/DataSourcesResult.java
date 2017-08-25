package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSourcesResult implements Result, SafeParcelable {
    public static final Creator<DataSourcesResult> CREATOR = new zze();
    private final int zzCY;
    private final Status zzOt;
    private final List<DataSource> zzalP;

    DataSourcesResult(int versionCode, List<DataSource> dataSources, Status status) {
        this.zzCY = versionCode;
        this.zzalP = Collections.unmodifiableList(dataSources);
        this.zzOt = status;
    }

    public DataSourcesResult(List<DataSource> dataSources, Status status) {
        this.zzCY = 3;
        this.zzalP = Collections.unmodifiableList(dataSources);
        this.zzOt = status;
    }

    public static DataSourcesResult zzL(Status status) {
        return new DataSourcesResult(Collections.emptyList(), status);
    }

    private boolean zzb(DataSourcesResult dataSourcesResult) {
        return this.zzOt.equals(dataSourcesResult.zzOt) && zzt.equal(this.zzalP, dataSourcesResult.zzalP);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataSourcesResult) && zzb((DataSourcesResult) that));
    }

    public List<DataSource> getDataSources() {
        return this.zzalP;
    }

    public List<DataSource> getDataSources(DataType dataType) {
        List arrayList = new ArrayList();
        for (DataSource dataSource : this.zzalP) {
            if (dataSource.getDataType().equals(dataType)) {
                arrayList.add(dataSource);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzOt;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOt, this.zzalP);
    }

    public String toString() {
        return zzt.zzt(this).zzg(Games.EXTRA_STATUS, this.zzOt).zzg("dataSets", this.zzalP).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }
}
