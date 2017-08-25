package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.nearby.sharing.internal.zzc.zza;

public final class TrustedDevicesRequest implements SafeParcelable {
    public static final Creator<TrustedDevicesRequest> CREATOR = new zzk();
    final int versionCode;
    public zzc zzaGt;
    public String zzaGv;
    public byte[] zzaGw;

    TrustedDevicesRequest(int versionCode, String deviceIdentifier, byte[] message, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzaGv = (String) zzu.zzu(deviceIdentifier);
        this.zzaGw = (byte[]) zzu.zzu(message);
        this.zzaGt = zza.zzdj(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }

    IBinder zzxa() {
        return this.zzaGt.asBinder();
    }
}
