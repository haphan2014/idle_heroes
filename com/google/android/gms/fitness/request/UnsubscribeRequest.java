package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmu.zza;

public class UnsubscribeRequest implements SafeParcelable {
    public static final Creator<UnsubscribeRequest> CREATOR = new zzae();
    private final int zzCY;
    private final String zzMZ;
    private final DataType zzajF;
    private final DataSource zzajG;
    private final zzmu zzalN;

    UnsubscribeRequest(int versionCode, DataType dataType, DataSource dataSource, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.zzajF = dataType;
        this.zzajG = dataSource;
        this.zzalN = callback == null ? null : zza.zzbF(callback);
        this.zzMZ = packageName;
    }

    public UnsubscribeRequest(DataType dataType, DataSource dataSource, zzmu callback, String packageName) {
        this.zzCY = 2;
        this.zzajF = dataType;
        this.zzajG = dataSource;
        this.zzalN = callback;
        this.zzMZ = packageName;
    }

    private boolean zzb(UnsubscribeRequest unsubscribeRequest) {
        return zzt.equal(this.zzajG, unsubscribeRequest.zzajG) && zzt.equal(this.zzajF, unsubscribeRequest.zzajF);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return this == o || ((o instanceof UnsubscribeRequest) && zzb((UnsubscribeRequest) o));
    }

    public DataSource getDataSource() {
        return this.zzajG;
    }

    public DataType getDataType() {
        return this.zzajF;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzajG, this.zzajF);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzae.zza(this, parcel, flags);
    }

    public IBinder zzqU() {
        return this.zzalN == null ? null : this.zzalN.asBinder();
    }
}
