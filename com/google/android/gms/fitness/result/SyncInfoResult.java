package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.Games;

public class SyncInfoResult implements Result, SafeParcelable {
    public static final Creator<SyncInfoResult> CREATOR = new zzl();
    private final int zzCY;
    private final Status zzOt;
    private final long zzVp;

    SyncInfoResult(int versionCode, Status status, long timestamp) {
        this.zzCY = versionCode;
        this.zzOt = status;
        this.zzVp = timestamp;
    }

    private boolean zzb(SyncInfoResult syncInfoResult) {
        return this.zzOt.equals(syncInfoResult.zzOt) && zzt.equal(Long.valueOf(this.zzVp), Long.valueOf(syncInfoResult.zzVp));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SyncInfoResult) && zzb((SyncInfoResult) that));
    }

    public Status getStatus() {
        return this.zzOt;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOt, Long.valueOf(this.zzVp));
    }

    public String toString() {
        return zzt.zzt(this).zzg(Games.EXTRA_STATUS, this.zzOt).zzg("timestamp", Long.valueOf(this.zzVp)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }

    public long zzrz() {
        return this.zzVp;
    }
}
