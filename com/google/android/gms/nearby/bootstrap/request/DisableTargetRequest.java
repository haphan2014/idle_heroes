package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzol.zza;

public class DisableTargetRequest implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int versionCode;
    private final zzol zzaFk;

    DisableTargetRequest(int versionCode, IBinder callback) {
        this.versionCode = versionCode;
        zzu.zzu(callback);
        this.zzaFk = zza.zzcX(callback);
    }

    public int describeContents() {
        zzc com_google_android_gms_nearby_bootstrap_request_zzc = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzc com_google_android_gms_nearby_bootstrap_request_zzc = CREATOR;
        zzc.zza(this, out, flags);
    }

    public IBinder zzqU() {
        return this.zzaFk == null ? null : this.zzaFk.asBinder();
    }
}
