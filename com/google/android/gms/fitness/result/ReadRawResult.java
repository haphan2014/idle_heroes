package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ReadRawResult implements Result, SafeParcelable {
    public static final Creator<ReadRawResult> CREATOR = new zzi();
    private final int zzCY;
    private final DataHolder zzWu;

    ReadRawResult(int versionCode, DataHolder dataHolder) {
        this.zzCY = versionCode;
        this.zzWu = dataHolder;
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return new Status(this.zzWu.getStatusCode());
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    DataHolder zzpx() {
        return this.zzWu;
    }
}
