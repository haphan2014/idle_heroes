package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public class SessionDataSet implements SafeParcelable {
    public static final Creator<SessionDataSet> CREATOR = new zzq();
    final int zzCY;
    private final Session zzajJ;
    private final DataSet zzakO;

    SessionDataSet(int versionCode, Session session, DataSet dataSet) {
        this.zzCY = versionCode;
        this.zzajJ = session;
        this.zzakO = dataSet;
    }

    private boolean zza(SessionDataSet sessionDataSet) {
        return zzt.equal(this.zzajJ, sessionDataSet.zzajJ) && zzt.equal(this.zzakO, sessionDataSet.zzakO);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionDataSet) && zza((SessionDataSet) o));
    }

    public Session getSession() {
        return this.zzajJ;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzajJ, this.zzakO);
    }

    public String toString() {
        return zzt.zzt(this).zzg("session", this.zzajJ).zzg("dataSet", this.zzakO).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzq.zza(this, dest, flags);
    }

    public DataSet zzqK() {
        return this.zzakO;
    }
}
