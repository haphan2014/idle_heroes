package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.List;

public final class AppMetadata implements SafeParcelable {
    public static final Creator<AppMetadata> CREATOR = new zzb();
    private final int zzCY;
    private final List<AppIdentifier> zzaFn;

    AppMetadata(int versionCode, List<AppIdentifier> appIdentifiers) {
        this.zzCY = versionCode;
        this.zzaFn = (List) zzu.zzb((Object) appIdentifiers, (Object) "Must specify application identifiers");
        zzu.zza(appIdentifiers.size(), (Object) "Application identifiers cannot be empty");
    }

    public AppMetadata(List<AppIdentifier> appIdentifiers) {
        this(1, appIdentifiers);
    }

    public int describeContents() {
        return 0;
    }

    public List<AppIdentifier> getAppIdentifiers() {
        return this.zzaFn;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
