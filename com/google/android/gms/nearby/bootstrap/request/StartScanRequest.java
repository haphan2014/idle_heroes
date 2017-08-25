package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzol;
import com.google.android.gms.internal.zzon;
import com.google.android.gms.internal.zzon.zza;

public class StartScanRequest implements SafeParcelable {
    public static final zzg CREATOR = new zzg();
    final int versionCode;
    private final zzol zzaFk;
    private final zzon zzaFm;

    StartScanRequest(int versionCode, IBinder scanListener, IBinder callback) {
        this.versionCode = versionCode;
        zzu.zzu(scanListener);
        this.zzaFm = zza.zzcZ(scanListener);
        zzu.zzu(callback);
        this.zzaFk = zzol.zza.zzcX(callback);
    }

    public int describeContents() {
        zzg com_google_android_gms_nearby_bootstrap_request_zzg = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg com_google_android_gms_nearby_bootstrap_request_zzg = CREATOR;
        zzg.zza(this, out, flags);
    }

    public IBinder zzqU() {
        return this.zzaFk == null ? null : this.zzaFk.asBinder();
    }

    public IBinder zzwQ() {
        return this.zzaFm == null ? null : this.zzaFm.asBinder();
    }
}
