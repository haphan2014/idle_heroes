package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzmu.zza;

public class SessionStartRequest implements SafeParcelable {
    public static final Creator<SessionStartRequest> CREATOR = new zzx();
    private final int zzCY;
    private final String zzMZ;
    private final Session zzajJ;
    private final zzmu zzalN;

    SessionStartRequest(int versionCode, Session session, IBinder callback, String packageName) {
        this.zzCY = versionCode;
        this.zzajJ = session;
        this.zzalN = callback == null ? null : zza.zzbF(callback);
        this.zzMZ = packageName;
    }

    public SessionStartRequest(Session session, zzmu callback, String packageName) {
        zzu.zzb(session.isOngoing(), (Object) "Cannot start a session which has already ended");
        this.zzCY = 2;
        this.zzajJ = session;
        this.zzalN = callback;
        this.zzMZ = packageName;
    }

    private boolean zzb(SessionStartRequest sessionStartRequest) {
        return zzt.equal(this.zzajJ, sessionStartRequest.zzajJ);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof SessionStartRequest) && zzb((SessionStartRequest) o));
    }

    public String getPackageName() {
        return this.zzMZ;
    }

    public Session getSession() {
        return this.zzajJ;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzajJ);
    }

    public String toString() {
        return zzt.zzt(this).zzg("session", this.zzajJ).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzx.zza(this, dest, flags);
    }

    public IBinder zzqU() {
        return this.zzalN == null ? null : this.zzalN.asBinder();
    }
}
