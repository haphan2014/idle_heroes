package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
    public static final ActivityRecognitionResultCreator CREATOR = new ActivityRecognitionResultCreator();
    private final int zzCY;
    List<DetectedActivity> zzaxr;
    long zzaxs;
    long zzaxt;
    int zzaxu;

    public ActivityRecognitionResult(int versionCode, List<DetectedActivity> probableActivities, long timeMillis, long elapsedRealtimeMillis, int detectorInfoId) {
        this.zzCY = versionCode;
        this.zzaxr = probableActivities;
        this.zzaxs = timeMillis;
        this.zzaxt = elapsedRealtimeMillis;
        this.zzaxu = detectorInfoId;
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis) {
        this(mostProbableActivity, time, elapsedRealtimeMillis, 0);
    }

    public ActivityRecognitionResult(DetectedActivity mostProbableActivity, long time, long elapsedRealtimeMillis, int detectorInfoId) {
        this(Collections.singletonList(mostProbableActivity), time, elapsedRealtimeMillis, detectorInfoId);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis) {
        this((List) probableActivities, time, elapsedRealtimeMillis, 0);
    }

    public ActivityRecognitionResult(List<DetectedActivity> probableActivities, long time, long elapsedRealtimeMillis, int detectorInfoId) {
        boolean z = true;
        boolean z2 = probableActivities != null && probableActivities.size() > 0;
        zzu.zzb(z2, (Object) "Must have at least 1 detected activity");
        if (time <= 0 || elapsedRealtimeMillis <= 0) {
            z = false;
        }
        zzu.zzb(z, (Object) "Must set times");
        this.zzCY = 2;
        this.zzaxr = probableActivities;
        this.zzaxs = time;
        this.zzaxt = elapsedRealtimeMillis;
        this.zzaxu = detectorInfoId;
    }

    public static ActivityRecognitionResult extractResult(Intent intent) {
        if (!hasResult(intent)) {
            return null;
        }
        Object obj = intent.getExtras().get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
        if (!(obj instanceof byte[])) {
            return obj instanceof ActivityRecognitionResult ? (ActivityRecognitionResult) obj : null;
        } else {
            Parcel obtain = Parcel.obtain();
            obtain.unmarshall((byte[]) obj, 0, ((byte[]) obj).length);
            obtain.setDataPosition(0);
            return CREATOR.createFromParcel(obtain);
        }
    }

    public static boolean hasResult(Intent intent) {
        return intent == null ? false : intent.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
    }

    public int describeContents() {
        return 0;
    }

    public int getActivityConfidence(int activityType) {
        for (DetectedActivity detectedActivity : this.zzaxr) {
            if (detectedActivity.getType() == activityType) {
                return detectedActivity.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.zzaxt;
    }

    public DetectedActivity getMostProbableActivity() {
        return (DetectedActivity) this.zzaxr.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.zzaxr;
    }

    public long getTime() {
        return this.zzaxs;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.zzaxr + ", timeMillis=" + this.zzaxs + ", elapsedRealtimeMillis=" + this.zzaxt + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        ActivityRecognitionResultCreator.zza(this, out, flags);
    }
}
