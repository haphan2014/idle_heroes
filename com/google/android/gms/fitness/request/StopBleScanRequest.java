package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.request.zzn.zza;
import com.google.android.gms.internal.zzmu;

public class StopBleScanRequest implements SafeParcelable {
    public static final Creator<StopBleScanRequest> CREATOR = new zzab();
    private final int zzCY;
    private final String zzMZ;
    private final zzmu zzalN;
    private final zzn zzamK;

    StopBleScanRequest(int versionCode, IBinder bleScanCallback, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.zzamK = zza.zzbI(bleScanCallback);
        this.zzalN = callback == null ? null : zzmu.zza.zzbF(callback);
        this.zzMZ = packageName;
    }

    public StopBleScanRequest(BleScanCallback bleScanCallback, zzmu callback, String packageName) {
        this(zza.zza.zzqS().zzb(bleScanCallback), callback, packageName);
    }

    public StopBleScanRequest(zzn bleScanCallback, zzmu callback, String packageName) {
        this.zzCY = 2;
        this.zzamK = bleScanCallback;
        this.zzalN = callback;
        this.zzMZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzab.zza(this, parcel, flags);
    }

    public IBinder zzqU() {
        return this.zzalN == null ? null : this.zzalN.asBinder();
    }

    public IBinder zzrq() {
        return this.zzamK.asBinder();
    }
}
