package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public class DeviceStatus implements SafeParcelable {
    public static final Creator<DeviceStatus> CREATOR = new zzg();
    private final int zzCY;
    private double zzSh;
    private boolean zzSi;
    private ApplicationMetadata zzUF;
    private int zzUu;
    private int zzUv;

    public DeviceStatus() {
        this(3, Double.NaN, false, -1, null, -1);
    }

    DeviceStatus(int versionCode, double volume, boolean muteState, int activeInputState, ApplicationMetadata applicationMetadata, int standbyState) {
        this.zzCY = versionCode;
        this.zzSh = volume;
        this.zzSi = muteState;
        this.zzUu = activeInputState;
        this.zzUF = applicationMetadata;
        this.zzUv = standbyState;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeviceStatus)) {
            return false;
        }
        DeviceStatus deviceStatus = (DeviceStatus) obj;
        return this.zzSh == deviceStatus.zzSh && this.zzSi == deviceStatus.zzSi && this.zzUu == deviceStatus.zzUu && zzf.zza(this.zzUF, deviceStatus.zzUF) && this.zzUv == deviceStatus.zzUv;
    }

    public ApplicationMetadata getApplicationMetadata() {
        return this.zzUF;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Double.valueOf(this.zzSh), Boolean.valueOf(this.zzSi), Integer.valueOf(this.zzUu), this.zzUF, Integer.valueOf(this.zzUv));
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }

    public double zzlO() {
        return this.zzSh;
    }

    public int zzlP() {
        return this.zzUu;
    }

    public int zzlQ() {
        return this.zzUv;
    }

    public boolean zzlX() {
        return this.zzSi;
    }
}
