package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzoj;
import com.google.android.gms.internal.zzoj.zza;
import com.google.android.gms.internal.zzok;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.nearby.bootstrap.Device;

public class ConnectRequest implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final String description;
    private final String name;
    final int versionCode;
    private final long zzPr;
    private final byte zzaFg;
    private final Device zzaFh;
    private final zzoj zzaFi;
    private final zzok zzaFj;
    private final zzol zzaFk;
    private final String zzaFl;

    ConnectRequest(int versionCode, Device device, String name, String description, byte deviceType, long timeoutMillis, String token, IBinder connectionListener, IBinder dataListener, IBinder callback) {
        this.versionCode = versionCode;
        this.zzaFh = (Device) zzu.zzu(device);
        this.name = zzu.zzcj(name);
        this.description = (String) zzu.zzu(description);
        this.zzaFg = deviceType;
        this.zzPr = timeoutMillis;
        this.zzaFl = token;
        zzu.zzu(connectionListener);
        this.zzaFi = zza.zzcV(connectionListener);
        zzu.zzu(dataListener);
        this.zzaFj = zzok.zza.zzcW(dataListener);
        zzu.zzu(callback);
        this.zzaFk = zzol.zza.zzcX(callback);
    }

    public int describeContents() {
        zza com_google_android_gms_nearby_bootstrap_request_zza = CREATOR;
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String getToken() {
        return this.zzaFl;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza com_google_android_gms_nearby_bootstrap_request_zza = CREATOR;
        zza.zza(this, out, flags);
    }

    public IBinder zzqU() {
        return this.zzaFk == null ? null : this.zzaFk.asBinder();
    }

    public byte zzwK() {
        return this.zzaFg;
    }

    public Device zzwM() {
        return this.zzaFh;
    }

    public long zzwN() {
        return this.zzPr;
    }

    public IBinder zzwO() {
        return this.zzaFi == null ? null : this.zzaFi.asBinder();
    }

    public IBinder zzwP() {
        return this.zzaFj == null ? null : this.zzaFj.asBinder();
    }
}
