package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public class ApplicationStatus implements SafeParcelable {
    public static final Creator<ApplicationStatus> CREATOR = new zza();
    private final int zzCY;
    private String zzUd;

    public ApplicationStatus() {
        this(1, null);
    }

    ApplicationStatus(int versionCode, String applicationStatusText) {
        this.zzCY = versionCode;
        this.zzUd = applicationStatusText;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationStatus)) {
            return false;
        }
        return zzf.zza(this.zzUd, ((ApplicationStatus) obj).zzUd);
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzUd);
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }

    public String zzlI() {
        return this.zzUd;
    }
}
