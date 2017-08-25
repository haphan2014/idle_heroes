package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzmr;
import com.google.android.gms.internal.zzmr.zza;

public class ReadStatsRequest implements SafeParcelable {
    public static final Creator<ReadStatsRequest> CREATOR = new zzr();
    private final int zzCY;
    private final String zzMZ;
    private final zzmr zzamq;

    ReadStatsRequest(int versionCode, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.zzamq = zza.zzbC(callback);
        this.zzMZ = packageName;
    }

    public int describeContents() {
        return 0;
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public String toString() {
        return String.format("ReadStatsRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzr.zza(this, parcel, flags);
    }

    public IBinder zzqU() {
        return this.zzamq.asBinder();
    }
}
