package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.Games;

public class DataTypeResult implements Result, SafeParcelable {
    public static final Creator<DataTypeResult> CREATOR = new zzg();
    private final int zzCY;
    private final Status zzOt;
    private final DataType zzajF;

    DataTypeResult(int versionCode, Status status, DataType dataType) {
        this.zzCY = versionCode;
        this.zzOt = status;
        this.zzajF = dataType;
    }

    public DataTypeResult(Status status, DataType dataType) {
        this.zzCY = 2;
        this.zzOt = status;
        this.zzajF = dataType;
    }

    public static DataTypeResult zzM(Status status) {
        return new DataTypeResult(status, null);
    }

    private boolean zzb(DataTypeResult dataTypeResult) {
        return this.zzOt.equals(dataTypeResult.zzOt) && zzt.equal(this.zzajF, dataTypeResult.zzajF);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof DataTypeResult) && zzb((DataTypeResult) that));
    }

    public DataType getDataType() {
        return this.zzajF;
    }

    public Status getStatus() {
        return this.zzOt;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOt, this.zzajF);
    }

    public String toString() {
        return zzt.zzt(this).zzg(Games.EXTRA_STATUS, this.zzOt).zzg("dataType", this.zzajF).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }
}
