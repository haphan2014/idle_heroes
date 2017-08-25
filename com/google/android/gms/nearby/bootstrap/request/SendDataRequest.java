package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzol.zza;
import com.google.android.gms.nearby.bootstrap.Device;

public class SendDataRequest implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    private final byte[] data;
    final int versionCode;
    private final Device zzaFh;
    private final zzol zzaFk;

    SendDataRequest(int versionCode, Device device, byte[] data, IBinder callback) {
        this.versionCode = versionCode;
        this.zzaFh = (Device) zzu.zzu(device);
        this.data = (byte[]) zzu.zzu(data);
        zzu.zzu(callback);
        this.zzaFk = zza.zzcX(callback);
    }

    public int describeContents() {
        zzf com_google_android_gms_nearby_bootstrap_request_zzf = CREATOR;
        return 0;
    }

    public byte[] getData() {
        return this.data;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzf com_google_android_gms_nearby_bootstrap_request_zzf = CREATOR;
        zzf.zza(this, out, flags);
    }

    public IBinder zzqU() {
        return this.zzaFk == null ? null : this.zzaFk.asBinder();
    }

    public Device zzwM() {
        return this.zzaFh;
    }
}
