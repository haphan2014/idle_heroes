package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public class LocationRequestInternal implements SafeParcelable {
    public static final zzk CREATOR = new zzk();
    static final List<ClientIdentity> zzaza = Collections.emptyList();
    final String mTag;
    private final int zzCY;
    LocationRequest zzamz;
    boolean zzazb;
    boolean zzazc;
    boolean zzazd;
    List<ClientIdentity> zzaze;

    LocationRequestInternal(int versionCode, LocationRequest locationRequest, boolean requestNlpDebugInfo, boolean restorePendingIntentListeners, boolean triggerUpdate, List<ClientIdentity> clients, String tag) {
        this.zzCY = versionCode;
        this.zzamz = locationRequest;
        this.zzazb = requestNlpDebugInfo;
        this.zzazc = restorePendingIntentListeners;
        this.zzazd = triggerUpdate;
        this.zzaze = clients;
        this.mTag = tag;
    }

    public static LocationRequestInternal zza(String str, LocationRequest locationRequest) {
        return new LocationRequestInternal(1, locationRequest, false, true, true, zzaza, str);
    }

    public static LocationRequestInternal zzb(LocationRequest locationRequest) {
        return zza(null, locationRequest);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof LocationRequestInternal)) {
            return false;
        }
        LocationRequestInternal locationRequestInternal = (LocationRequestInternal) other;
        return zzt.equal(this.zzamz, locationRequestInternal.zzamz) && this.zzazb == locationRequestInternal.zzazb && this.zzazc == locationRequestInternal.zzazc && this.zzazd == locationRequestInternal.zzazd && zzt.equal(this.zzaze, locationRequestInternal.zzaze);
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return this.zzamz.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.zzamz.toString());
        stringBuilder.append(" requestNlpDebugInfo=");
        stringBuilder.append(this.zzazb);
        stringBuilder.append(" restorePendingIntentListeners=");
        stringBuilder.append(this.zzazc);
        stringBuilder.append(" triggerUpdate=");
        stringBuilder.append(this.zzazd);
        stringBuilder.append(" clients=");
        stringBuilder.append(this.zzaze);
        if (this.mTag != null) {
            stringBuilder.append(" tag=");
            stringBuilder.append(this.mTag);
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzk.zza(this, parcel, flags);
    }
}
