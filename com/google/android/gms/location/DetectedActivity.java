package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Comparator;

public class DetectedActivity implements SafeParcelable {
    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    public static final Comparator<DetectedActivity> zzaxv = new C10731();
    private final int zzCY;
    int zzaxw;
    int zzaxx;

    static class C10731 implements Comparator<DetectedActivity> {
        C10731() {
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return zza((DetectedActivity) x0, (DetectedActivity) x1);
        }

        public int zza(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            int compareTo = Integer.valueOf(detectedActivity2.getConfidence()).compareTo(Integer.valueOf(detectedActivity.getConfidence()));
            return compareTo == 0 ? Integer.valueOf(detectedActivity.getType()).compareTo(Integer.valueOf(detectedActivity2.getType())) : compareTo;
        }
    }

    public DetectedActivity(int activityType, int confidence) {
        this.zzCY = 1;
        this.zzaxw = activityType;
        this.zzaxx = confidence;
    }

    public DetectedActivity(int versionCode, int activityType, int confidence) {
        this.zzCY = versionCode;
        this.zzaxw = activityType;
        this.zzaxx = confidence;
    }

    private int zzgp(int i) {
        return i > 15 ? 4 : i;
    }

    public static String zzgq(int i) {
        switch (i) {
            case 0:
                return "IN_VEHICLE";
            case 1:
                return "ON_BICYCLE";
            case 2:
                return "ON_FOOT";
            case 3:
                return "STILL";
            case 4:
                return "UNKNOWN";
            case 5:
                return "TILTING";
            case 7:
                return "WALKING";
            case 8:
                return "RUNNING";
            default:
                return Integer.toString(i);
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getConfidence() {
        return this.zzaxx;
    }

    public int getType() {
        return zzgp(this.zzaxw);
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return "DetectedActivity [type=" + zzgq(getType()) + ", confidence=" + this.zzaxx + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        DetectedActivityCreator.zza(this, out, flags);
    }
}
