package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmu.zza;

public class DisableFitRequest implements SafeParcelable {
    public static final Creator<DisableFitRequest> CREATOR = new zzl();
    private final int zzCY;
    private final String zzMZ;
    private final zzmu zzalN;

    DisableFitRequest(int versionCode, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.zzalN = zza.zzbF(callback);
        this.zzMZ = packageName;
    }

    public DisableFitRequest(zzmu callback, String packageName) {
        this.zzCY = 1;
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

    public String toString() {
        return String.format("DisableFitRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzl.zza(this, parcel, flags);
    }

    public IBinder zzqU() {
        return this.zzalN.asBinder();
    }
}
