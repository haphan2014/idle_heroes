package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private String zzDK = null;
        private short zzaxA = (short) -1;
        private double zzaxB;
        private double zzaxC;
        private float zzaxD;
        private int zzaxE = 0;
        private int zzaxF = -1;
        private int zzaxy = 0;
        private long zzaxz = Long.MIN_VALUE;

        public Geofence build() {
            if (this.zzDK == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.zzaxy == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if ((this.zzaxy & 4) != 0 && this.zzaxF < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (this.zzaxz == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.zzaxA == (short) -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if (this.zzaxE >= 0) {
                return new ParcelableGeofence(this.zzDK, this.zzaxy, (short) 1, this.zzaxB, this.zzaxC, this.zzaxD, this.zzaxz, this.zzaxE, this.zzaxF);
            } else {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
        }

        public Builder setCircularRegion(double latitude, double longitude, float radius) {
            this.zzaxA = (short) 1;
            this.zzaxB = latitude;
            this.zzaxC = longitude;
            this.zzaxD = radius;
            return this;
        }

        public Builder setExpirationDuration(long durationMillis) {
            if (durationMillis < 0) {
                this.zzaxz = -1;
            } else {
                this.zzaxz = SystemClock.elapsedRealtime() + durationMillis;
            }
            return this;
        }

        public Builder setLoiteringDelay(int loiteringDelayMs) {
            this.zzaxF = loiteringDelayMs;
            return this;
        }

        public Builder setNotificationResponsiveness(int notificationResponsivenessMs) {
            this.zzaxE = notificationResponsivenessMs;
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.zzDK = requestId;
            return this;
        }

        public Builder setTransitionTypes(int transitionTypes) {
            this.zzaxy = transitionTypes;
            return this;
        }
    }

    String getRequestId();
}
