package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    int mPriority;
    private final int zzCY;
    boolean zzamB;
    long zzaxU;
    long zzaxV;
    int zzaxW;
    float zzaxX;
    long zzaxY;
    long zzaxz;

    public LocationRequest() {
        this.zzCY = 1;
        this.mPriority = 102;
        this.zzaxU = 3600000;
        this.zzaxV = 600000;
        this.zzamB = false;
        this.zzaxz = Long.MAX_VALUE;
        this.zzaxW = Integer.MAX_VALUE;
        this.zzaxX = 0.0f;
        this.zzaxY = 0;
    }

    LocationRequest(int versionCode, int priority, long interval, long fastestInterval, boolean explicitFastestInterval, long expireAt, int numUpdates, float smallestDisplacement, long maxWaitTime) {
        this.zzCY = versionCode;
        this.mPriority = priority;
        this.zzaxU = interval;
        this.zzaxV = fastestInterval;
        this.zzamB = explicitFastestInterval;
        this.zzaxz = expireAt;
        this.zzaxW = numUpdates;
        this.zzaxX = smallestDisplacement;
        this.zzaxY = maxWaitTime;
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void zzK(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    private static void zzd(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    private static void zzgu(int i) {
        switch (i) {
            case 100:
            case 102:
            case PRIORITY_LOW_POWER /*104*/:
            case PRIORITY_NO_POWER /*105*/:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static String zzgv(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case PRIORITY_LOW_POWER /*104*/:
                return "PRIORITY_LOW_POWER";
            case PRIORITY_NO_POWER /*105*/:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) object;
        return this.mPriority == locationRequest.mPriority && this.zzaxU == locationRequest.zzaxU && this.zzaxV == locationRequest.zzaxV && this.zzamB == locationRequest.zzamB && this.zzaxz == locationRequest.zzaxz && this.zzaxW == locationRequest.zzaxW && this.zzaxX == locationRequest.zzaxX;
    }

    public long getExpirationTime() {
        return this.zzaxz;
    }

    public long getFastestInterval() {
        return this.zzaxV;
    }

    public long getInterval() {
        return this.zzaxU;
    }

    public long getMaxWaitTime() {
        long j = this.zzaxY;
        return j < this.zzaxU ? this.zzaxU : j;
    }

    public int getNumUpdates() {
        return this.zzaxW;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.zzaxX;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.zzaxU), Long.valueOf(this.zzaxV), Boolean.valueOf(this.zzamB), Long.valueOf(this.zzaxz), Integer.valueOf(this.zzaxW), Float.valueOf(this.zzaxX));
    }

    public LocationRequest setExpirationDuration(long millis) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (millis > Long.MAX_VALUE - elapsedRealtime) {
            this.zzaxz = Long.MAX_VALUE;
        } else {
            this.zzaxz = elapsedRealtime + millis;
        }
        if (this.zzaxz < 0) {
            this.zzaxz = 0;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long millis) {
        this.zzaxz = millis;
        if (this.zzaxz < 0) {
            this.zzaxz = 0;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long millis) {
        zzK(millis);
        this.zzamB = true;
        this.zzaxV = millis;
        return this;
    }

    public LocationRequest setInterval(long millis) {
        zzK(millis);
        this.zzaxU = millis;
        if (!this.zzamB) {
            this.zzaxV = (long) (((double) this.zzaxU) / 6.0d);
        }
        return this;
    }

    public LocationRequest setMaxWaitTime(long millis) {
        zzK(millis);
        this.zzaxY = millis;
        return this;
    }

    public LocationRequest setNumUpdates(int numUpdates) {
        if (numUpdates <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + numUpdates);
        }
        this.zzaxW = numUpdates;
        return this;
    }

    public LocationRequest setPriority(int priority) {
        zzgu(priority);
        this.mPriority = priority;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        zzd(smallestDisplacementMeters);
        this.zzaxX = smallestDisplacementMeters;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request[").append(zzgv(this.mPriority));
        if (this.mPriority != PRIORITY_NO_POWER) {
            stringBuilder.append(" requested=");
            stringBuilder.append(this.zzaxU + "ms");
        }
        stringBuilder.append(" fastest=");
        stringBuilder.append(this.zzaxV + "ms");
        if (this.zzaxY > this.zzaxU) {
            stringBuilder.append(" maxWait=");
            stringBuilder.append(this.zzaxY + "ms");
        }
        if (this.zzaxz != Long.MAX_VALUE) {
            long elapsedRealtime = this.zzaxz - SystemClock.elapsedRealtime();
            stringBuilder.append(" expireIn=");
            stringBuilder.append(elapsedRealtime + "ms");
        }
        if (this.zzaxW != Integer.MAX_VALUE) {
            stringBuilder.append(" num=").append(this.zzaxW);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        LocationRequestCreator.zza(this, parcel, flags);
    }
}
