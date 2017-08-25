package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.internal.zzol;

public class EnableTargetRequest implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private final String description;
    private final String name;
    final int versionCode;
    private final byte zzaFg;
    private final zzoj zzaFi;
    private final zzok zzaFj;
    private final zzol zzaFk;

    EnableTargetRequest(int versionCode, String name, String description, byte deviceType, IBinder connectionListener, IBinder dataListener, IBinder callback) {
        this.versionCode = versionCode;
        this.name = zzu.zzcj(name);
        this.description = (String) zzu.zzu(description);
        this.zzaFg = deviceType;
        zzu.zzu(connectionListener);
        this.zzaFi = zza.zzcV(connectionListener);
        zzu.zzu(dataListener);
        this.zzaFj = zzok.zza.zzcW(dataListener);
        zzu.zzu(callback);
        this.zzaFk = zzol.zza.zzcX(callback);
    }

    public int describeContents() {
        zze com_google_android_gms_nearby_bootstrap_request_zze = CREATOR;
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze com_google_android_gms_nearby_bootstrap_request_zze = CREATOR;
        zze.zza(this, out, flags);
    }

    public IBinder zzqU() {
        return this.zzaFk == null ? null : this.zzaFk.asBinder();
    }

    public byte zzwK() {
        return this.zzaFg;
    }

    public IBinder zzwO() {
        return this.zzaFi == null ? null : this.zzaFi.asBinder();
    }

    public IBinder zzwP() {
        return this.zzaFj == null ? null : this.zzaFj.asBinder();
    }
}
