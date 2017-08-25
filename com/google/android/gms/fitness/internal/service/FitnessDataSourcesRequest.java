package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.DataType;
import java.util.Collections;
import java.util.List;

public class FitnessDataSourcesRequest implements SafeParcelable {
    public static final Creator<FitnessDataSourcesRequest> CREATOR = new zza();
    private final int zzCY;
    private final List<DataType> zzajQ;

    FitnessDataSourcesRequest(int versionCode, List<DataType> dataTypes) {
        this.zzCY = versionCode;
        this.zzajQ = dataTypes;
    }

    public int describeContents() {
        return 0;
    }

    public List<DataType> getDataTypes() {
        return Collections.unmodifiableList(this.zzajQ);
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return zzt.zzt(this).zzg("dataTypes", this.zzajQ).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }
}
