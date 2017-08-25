package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public final class LocationAvailability implements SafeParcelable {
    public static final LocationAvailabilityCreator CREATOR = new LocationAvailabilityCreator();
    private final int zzCY;
    int zzaxQ;
    int zzaxR;
    long zzaxS;
    int zzaxT;

    LocationAvailability(int versionCode, int locationStatus, int cellStatus, int wifiStatus, long elapsedRealtimeNs) {
        this.zzCY = versionCode;
        this.zzaxT = locationStatus;
        this.zzaxQ = cellStatus;
        this.zzaxR = wifiStatus;
        this.zzaxS = elapsedRealtimeNs;
    }

    public static LocationAvailability extractLocationAvailability(Intent intent) {
        return !hasLocationAvailability(intent) ? null : (LocationAvailability) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
    }

    public static boolean hasLocationAvailability(Intent intent) {
        return intent == null ? false : intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_AVAILABILITY");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof LocationAvailability)) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) other;
        return this.zzaxT == locationAvailability.zzaxT && this.zzaxQ == locationAvailability.zzaxQ && this.zzaxR == locationAvailability.zzaxR && this.zzaxS == locationAvailability.zzaxS;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzaxT), Integer.valueOf(this.zzaxQ), Integer.valueOf(this.zzaxR), Long.valueOf(this.zzaxS));
    }

    public boolean isLocationAvailable() {
        return this.zzaxT < 1000;
    }

    public String toString() {
        return "LocationAvailability[isLocationAvailable: " + isLocationAvailable() + "]";
    }

    public void writeToParcel(Parcel parcel, int flags) {
        LocationAvailabilityCreator.zza(this, parcel, flags);
    }
}
