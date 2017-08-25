package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmu.zza;

public class ClaimBleDeviceRequest implements SafeParcelable {
    public static final Creator<ClaimBleDeviceRequest> CREATOR = new zzb();
    private final int zzCY;
    private final String zzMZ;
    private final String zzalL;
    private final BleDevice zzalM;
    private final zzmu zzalN;

    ClaimBleDeviceRequest(int versionCode, String deviceAddress, BleDevice bleDevice, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.zzalL = deviceAddress;
        this.zzalM = bleDevice;
        this.zzalN = callback == null ? null : zza.zzbF(callback);
        this.zzMZ = packageName;
    }

    public ClaimBleDeviceRequest(String deviceAddress, BleDevice bleDevice, zzmu callback, String packageName) {
        this.zzCY = 3;
        this.zzalL = deviceAddress;
        this.zzalM = bleDevice;
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
        return String.format("ClaimBleDeviceRequest{%s %s}", new Object[]{this.zzalL, this.zzalM});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb.zza(this, parcel, flags);
    }

    public BleDevice zzqT() {
        return this.zzalM;
    }

    public IBinder zzqU() {
        return this.zzalN == null ? null : this.zzalN.asBinder();
    }
}
