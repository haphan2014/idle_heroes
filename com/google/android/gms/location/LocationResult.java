package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class LocationResult implements SafeParcelable {
    public static final Creator<LocationResult> CREATOR = new zzf();
    static final List<Location> zzaxZ = Collections.emptyList();
    private final int zzCY;
    private final List<Location> zzaya;

    LocationResult(int versionCode, List<Location> locations) {
        this.zzCY = versionCode;
        this.zzaya = locations;
    }

    public static LocationResult create(List<Location> locations) {
        if (locations == null) {
            locations = zzaxZ;
        }
        return new LocationResult(2, locations);
    }

    public static LocationResult extractResult(Intent intent) {
        return !hasResult(intent) ? null : (LocationResult) intent.getExtras().getParcelable("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    public static boolean hasResult(Intent intent) {
        return intent == null ? false : intent.hasExtra("com.google.android.gms.location.EXTRA_LOCATION_RESULT");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (!(other instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) other;
        if (locationResult.zzaya.size() != this.zzaya.size()) {
            return false;
        }
        Iterator it = this.zzaya.iterator();
        for (Location time : locationResult.zzaya) {
            if (((Location) it.next()).getTime() != time.getTime()) {
                return false;
            }
        }
        return true;
    }

    public Location getLastLocation() {
        int size = this.zzaya.size();
        return size == 0 ? null : (Location) this.zzaya.get(size - 1);
    }

    public List<Location> getLocations() {
        return this.zzaya;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        int i = 17;
        for (Location time : this.zzaya) {
            long time2 = time.getTime();
            i = ((int) (time2 ^ (time2 >>> 32))) + (i * 31);
        }
        return i;
    }

    public String toString() {
        return "LocationResult[locations: " + this.zzaya + "]";
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzf.zza(this, parcel, flags);
    }
}
