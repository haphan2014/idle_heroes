package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzj.zza;
import com.google.android.gms.internal.zzmu;

public class SensorUnregistrationRequest implements SafeParcelable {
    public static final Creator<SensorUnregistrationRequest> CREATOR = new zzt();
    private final PendingIntent mPendingIntent;
    private final int zzCY;
    private final String zzMZ;
    private final zzmu zzalN;
    private final zzj zzamr;

    SensorUnregistrationRequest(int versionCode, IBinder listenerBinder, PendingIntent pendingIntent, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.zzamr = listenerBinder == null ? null : zza.zzbh(listenerBinder);
        this.mPendingIntent = pendingIntent;
        this.zzalN = zzmu.zza.zzbF(callback);
        this.zzMZ = packageName;
    }

    public SensorUnregistrationRequest(zzj listener, PendingIntent pendingIntent, zzmu callback, String packageName) {
        this.zzCY = 3;
        this.zzamr = listener;
        this.mPendingIntent = pendingIntent;
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
        return String.format("SensorUnregistrationRequest{%s}", new Object[]{this.zzamr});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzt.zza(this, parcel, flags);
    }

    public IBinder zzqU() {
        return this.zzalN == null ? null : this.zzalN.asBinder();
    }

    public PendingIntent zzrg() {
        return this.mPendingIntent;
    }

    IBinder zzrl() {
        return this.zzamr == null ? null : this.zzamr.asBinder();
    }
}
