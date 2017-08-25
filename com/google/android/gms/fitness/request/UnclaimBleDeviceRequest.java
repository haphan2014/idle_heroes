package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmu.zza;

public class UnclaimBleDeviceRequest implements SafeParcelable {
    public static final Creator<UnclaimBleDeviceRequest> CREATOR = new zzad();
    private final int zzCY;
    private final String zzMZ;
    private final String zzalL;
    private final zzmu zzalN;

    UnclaimBleDeviceRequest(int versionCode, String deviceAddress, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.zzalL = deviceAddress;
        this.zzalN = callback == null ? null : zza.zzbF(callback);
        this.zzMZ = packageName;
    }

    public UnclaimBleDeviceRequest(String deviceAddress, zzmu callback, String packageName) {
        this.zzCY = 4;
        this.zzalL = deviceAddress;
        this.zzalN = callback;
        this.zzMZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public String getDeviceAddress() {
        return this.zzalL;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return String.format("UnclaimBleDeviceRequest{%s}", new Object[]{this.zzalL});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzad.zza(this, parcel, flags);
    }

    public IBinder zzqU() {
        return this.zzalN == null ? null : this.zzalN.asBinder();
    }
}
