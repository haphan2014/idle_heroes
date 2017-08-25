package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class ParcelableGeofence implements SafeParcelable, Geofence {
    public static final zzm CREATOR = new zzm();
    private final int zzCY;
    private final String zzDK;
    private final short zzaxA;
    private final double zzaxB;
    private final double zzaxC;
    private final float zzaxD;
    private final int zzaxE;
    private final int zzaxF;
    private final int zzaxy;
    private final long zzazj;

    public ParcelableGeofence(int version, String requestId, int transitionTypes, short type, double latitude, double longitude, float radius, long expireAt, int notificationResponsiveness, int loiteringDelayMillis) {
        zzdn(requestId);
        zze(radius);
        zza(latitude, longitude);
        transitionTypes = zzgG(transitionTypes);
        this.zzCY = version;
        this.zzaxA = type;
        this.zzDK = requestId;
        this.zzaxB = latitude;
        this.zzaxC = longitude;
        this.zzaxD = radius;
        this.zzazj = expireAt;
        this.zzaxy = transitionTypes;
        this.zzaxE = notificationResponsiveness;
        this.zzaxF = loiteringDelayMillis;
    }

    public ParcelableGeofence(String requestId, int transitionTypes, short type, double latitude, double longitude, float radius, long expireAt, int notificationResponsiveness, int loiteringDelayMillis) {
        this(1, requestId, transitionTypes, type, latitude, longitude, radius, expireAt, notificationResponsiveness, loiteringDelayMillis);
    }

    private static void zza(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            throw new IllegalArgumentException("invalid latitude: " + d);
        } else if (d2 > 180.0d || d2 < -180.0d) {
            throw new IllegalArgumentException("invalid longitude: " + d2);
        }
    }

    private static void zzdn(String str) {
        if (str == null || str.length() > 100) {
            throw new IllegalArgumentException("requestId is null or too long: " + str);
        }
    }

    private static void zze(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("invalid radius: " + f);
        }
    }

    private static int zzgG(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("No supported transition specified: " + i);
    }

    private static String zzgH(int i) {
        switch (i) {
            case 1:
                return "CIRCLE";
            default:
                return null;
        }
    }

    public static ParcelableGeofence zzn(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        ParcelableGeofence zzem = CREATOR.zzem(obtain);
        obtain.recycle();
        return zzem;
    }

    public int describeContents() {
        zzm com_google_android_gms_location_internal_zzm = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ParcelableGeofence)) {
            return false;
        }
        ParcelableGeofence parcelableGeofence = (ParcelableGeofence) obj;
        return this.zzaxD != parcelableGeofence.zzaxD ? false : this.zzaxB != parcelableGeofence.zzaxB ? false : this.zzaxC != parcelableGeofence.zzaxC ? false : this.zzaxA == parcelableGeofence.zzaxA;
    }

    public long getExpirationTime() {
        return this.zzazj;
    }

    public double getLatitude() {
        return this.zzaxB;
    }

    public double getLongitude() {
        return this.zzaxC;
    }

    public int getNotificationResponsiveness() {
        return this.zzaxE;
    }

    public String getRequestId() {
        return this.zzDK;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzaxB);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzaxC);
        return (((((((i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.zzaxD)) * 31) + this.zzaxA) * 31) + this.zzaxy;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[]{zzgH(this.zzaxA), this.zzDK, Integer.valueOf(this.zzaxy), Double.valueOf(this.zzaxB), Double.valueOf(this.zzaxC), Float.valueOf(this.zzaxD), Integer.valueOf(this.zzaxE / 1000), Integer.valueOf(this.zzaxF), Long.valueOf(this.zzazj)});
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzm com_google_android_gms_location_internal_zzm = CREATOR;
        zzm.zza(this, parcel, flags);
    }

    public short zzuA() {
        return this.zzaxA;
    }

    public float zzuB() {
        return this.zzaxD;
    }

    public int zzuC() {
        return this.zzaxy;
    }

    public int zzuD() {
        return this.zzaxF;
    }
}
