package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzme;
import com.google.android.gms.internal.zzme.zza;

public class DailyTotalRequest implements SafeParcelable {
    public static final Creator<DailyTotalRequest> CREATOR = new zzc();
    private final int zzCY;
    private final String zzMZ;
    private final DataType zzajF;
    private final zzme zzalO;

    DailyTotalRequest(int versionCode, IBinder callback, DataType dataType, String packageName) {
        this.zzCY = versionCode;
        this.zzalO = zza.zzbp(callback);
        this.zzajF = dataType;
        this.zzMZ = packageName;
    }

    public DailyTotalRequest(zzme callback, DataType dataType, String packageName) {
        this.zzCY = 1;
        this.zzalO = callback;
        this.zzajF = dataType;
        this.zzMZ = packageName;
    }

    public int describeContents() {
        return 0;
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

    public String toString() {
        return String.format("DailyTotalRequest{%s}", new Object[]{this.zzajF.zzqD()});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzc.zza(this, parcel, flags);
    }

    public IBinder zzqU() {
        return this.zzalO.asBinder();
    }
}
