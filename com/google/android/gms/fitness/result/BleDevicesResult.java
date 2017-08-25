package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BleDevicesResult implements Result, SafeParcelable {
    public static final Creator<BleDevicesResult> CREATOR = new zza();
    private final int zzCY;
    private final Status zzOt;
    private final List<BleDevice> zzamO;

    BleDevicesResult(int versionCode, List<BleDevice> bleDevices, Status status) {
        this.zzCY = versionCode;
        this.zzamO = Collections.unmodifiableList(bleDevices);
        this.zzOt = status;
    }

    public BleDevicesResult(List<BleDevice> bleDevices, Status status) {
        this.zzCY = 3;
        this.zzamO = Collections.unmodifiableList(bleDevices);
        this.zzOt = status;
    }

    public static BleDevicesResult zzJ(Status status) {
        return new BleDevicesResult(Collections.emptyList(), status);
    }

    private boolean zzb(BleDevicesResult bleDevicesResult) {
        return this.zzOt.equals(bleDevicesResult.zzOt) && zzt.equal(this.zzamO, bleDevicesResult.zzamO);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof BleDevicesResult) && zzb((BleDevicesResult) that));
    }

    public List<BleDevice> getClaimedBleDevices() {
        return this.zzamO;
    }

    public List<BleDevice> getClaimedBleDevices(DataType dataType) {
        List arrayList = new ArrayList();
        for (BleDevice bleDevice : this.zzamO) {
            if (bleDevice.getDataTypes().contains(dataType)) {
                arrayList.add(bleDevice);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Status getStatus() {
        return this.zzOt;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOt, this.zzamO);
    }

    public String toString() {
        return zzt.zzt(this).zzg(Games.EXTRA_STATUS, this.zzOt).zzg("bleDevices", this.zzamO).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
