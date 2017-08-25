package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zzni.zza;

public class ListClaimedBleDevicesRequest implements SafeParcelable {
    public static final Creator<ListClaimedBleDevicesRequest> CREATOR = new zzo();
    private final int zzCY;
    private final String zzMZ;
    private final zzni zzamm;

    ListClaimedBleDevicesRequest(int versionCode, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.zzamm = zza.zzbH(callback);
        this.zzMZ = packageName;
    }

    public ListClaimedBleDevicesRequest(zzni callback, String packageName) {
        this.zzCY = 1;
        this.zzamm = callback;
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

    public String toString() {
        return String.format("ListClaimedBleDevicesRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzo.zza(this, parcel, flags);
    }

    public IBinder zzqU() {
        return this.zzamm.asBinder();
    }
}
