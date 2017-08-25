package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataSource.Builder;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.RawBucket;
import com.google.android.gms.fitness.data.RawDataSet;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataReadResult implements Result, SafeParcelable {
    public static final Creator<DataReadResult> CREATOR = new zzc();
    private final int zzCY;
    private final Status zzOt;
    private final List<DataSet> zzajS;
    private final List<DataSource> zzakc;
    private final List<Bucket> zzamP;
    private int zzamQ;
    private final List<DataType> zzamR;

    DataReadResult(int versionCode, List<RawDataSet> dataSets, Status status, List<RawBucket> buckets, int batchCount, List<DataSource> uniqueDataSources, List<DataType> uniqueDataTypes) {
        this.zzCY = versionCode;
        this.zzOt = status;
        this.zzamQ = batchCount;
        this.zzakc = uniqueDataSources;
        this.zzamR = uniqueDataTypes;
        this.zzajS = new ArrayList(dataSets.size());
        for (RawDataSet dataSet : dataSets) {
            this.zzajS.add(new DataSet(dataSet, uniqueDataSources));
        }
        this.zzamP = new ArrayList(buckets.size());
        for (RawBucket bucket : buckets) {
            this.zzamP.add(new Bucket(bucket, uniqueDataSources));
        }
    }

    public DataReadResult(List<DataSet> dataSets, List<Bucket> buckets, Status status) {
        this.zzCY = 5;
        this.zzajS = dataSets;
        this.zzOt = status;
        this.zzamP = buckets;
        this.zzamQ = 1;
        this.zzakc = new ArrayList();
        this.zzamR = new ArrayList();
    }

    public static DataReadResult zza(Status status, DataReadRequest dataReadRequest) {
        List arrayList = new ArrayList();
        for (DataSource create : dataReadRequest.getDataSources()) {
            arrayList.add(DataSet.create(create));
        }
        for (DataType dataType : dataReadRequest.getDataTypes()) {
            arrayList.add(DataSet.create(new Builder().setDataType(dataType).setType(1).setName("Default").build()));
        }
        return new DataReadResult(arrayList, Collections.emptyList(), status);
    }

    private void zza(Bucket bucket, List<Bucket> list) {
        for (Bucket bucket2 : list) {
            if (bucket2.zzb(bucket)) {
                for (DataSet zza : bucket.getDataSets()) {
                    zza(zza, bucket2.getDataSets());
                }
                return;
            }
        }
        this.zzamP.add(bucket);
    }

    private void zza(DataSet dataSet, List<DataSet> list) {
        for (DataSet dataSet2 : list) {
            if (dataSet2.getDataSource().equals(dataSet.getDataSource())) {
                dataSet2.zzb(dataSet.getDataPoints());
                return;
            }
        }
        list.add(dataSet);
    }

    private boolean zzc(DataReadResult dataReadResult) {
        return this.zzOt.equals(dataReadResult.zzOt) && zzt.equal(this.zzajS, dataReadResult.zzajS) && zzt.equal(this.zzamP, dataReadResult.zzamP);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataReadResult) && zzc((DataReadResult) that));
    }

    public List<Bucket> getBuckets() {
        return this.zzamP;
    }

    public DataSet getDataSet(DataSource dataSource) {
        for (DataSet dataSet : this.zzajS) {
            if (dataSource.equals(dataSet.getDataSource())) {
                return dataSet;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{dataSource.getStreamIdentifier()}));
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzajS) {
            if (dataType.equals(dataSet.getDataType())) {
                return dataSet;
            }
        }
        throw new IllegalArgumentException(String.format("Attempting to read data for %s, which was not requested", new Object[]{dataType.getName()}));
    }

    public List<DataSet> getDataSets() {
        return this.zzajS;
    }

    public Status getStatus() {
        return this.zzOt;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOt, this.zzajS, this.zzamP);
    }

    public String toString() {
        return zzt.zzt(this).zzg(Games.EXTRA_STATUS, this.zzOt).zzg("dataSets", this.zzajS.size() > 5 ? this.zzajS.size() + " data sets" : this.zzajS).zzg("buckets", this.zzamP.size() > 5 ? this.zzamP.size() + " buckets" : this.zzamP).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public void zzb(DataReadResult dataReadResult) {
        for (DataSet zza : dataReadResult.getDataSets()) {
            zza(zza, this.zzajS);
        }
        for (Bucket zza2 : dataReadResult.getBuckets()) {
            zza(zza2, this.zzamP);
        }
    }

    List<DataSource> zzqA() {
        return this.zzakc;
    }

    public int zzrt() {
        return this.zzamQ;
    }

    List<RawBucket> zzru() {
        List<RawBucket> arrayList = new ArrayList(this.zzamP.size());
        for (Bucket rawBucket : this.zzamP) {
            arrayList.add(new RawBucket(rawBucket, this.zzakc, this.zzamR));
        }
        return arrayList;
    }

    List<RawDataSet> zzrv() {
        List<RawDataSet> arrayList = new ArrayList(this.zzajS.size());
        for (DataSet rawDataSet : this.zzajS) {
            arrayList.add(new RawDataSet(rawDataSet, this.zzakc, this.zzamR));
        }
        return arrayList;
    }

    List<DataType> zzrw() {
        return this.zzamR;
    }
}
