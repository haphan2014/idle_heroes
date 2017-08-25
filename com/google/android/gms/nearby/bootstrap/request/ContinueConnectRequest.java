package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzol.zza;

public class ContinueConnectRequest implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int versionCode;
    private final zzol zzaFk;
    private final String zzaFl;

    ContinueConnectRequest(int versionCode, String token, IBinder callback) {
        this.versionCode = versionCode;
        this.zzaFl = (String) zzu.zzu(token);
        this.zzaFk = zza.zzcX(callback);
    }

    public int describeContents() {
        zzb com_google_android_gms_nearby_bootstrap_request_zzb = CREATOR;
        return 0;
    }

    public String getToken() {
        return this.zzaFl;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb com_google_android_gms_nearby_bootstrap_request_zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    public IBinder zzqU() {
        return this.zzaFk == null ? null : this.zzaFk.asBinder();
    }
}
