package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public final class AppIdentifier implements SafeParcelable {
    public static final Creator<AppIdentifier> CREATOR = new zza();
    private final int zzCY;
    private final String zzakL;

    AppIdentifier(int versionCode, String identifier) {
        this.zzCY = versionCode;
        this.zzakL = zzu.zzh(identifier, "Missing application identifier value");
    }

    public AppIdentifier(String identifier) {
        this(1, identifier);
    }

    public int describeContents() {
        return 0;
    }

    public String getIdentifier() {
        return this.zzakL;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
