package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.SessionDataSet;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionReadResult implements Result, SafeParcelable {
    public static final Creator<SessionReadResult> CREATOR = new zzj();
    private final int zzCY;
    private final Status zzOt;
    private final List<Session> zzalQ;
    private final List<SessionDataSet> zzamX;

    SessionReadResult(int versionCode, List<Session> sessions, List<SessionDataSet> sessionDataSets, Status status) {
        this.zzCY = versionCode;
        this.zzalQ = sessions;
        this.zzamX = Collections.unmodifiableList(sessionDataSets);
        this.zzOt = status;
    }

    public SessionReadResult(List<Session> sessions, List<SessionDataSet> sessionDataSets, Status status) {
        this.zzCY = 3;
        this.zzalQ = sessions;
        this.zzamX = Collections.unmodifiableList(sessionDataSets);
        this.zzOt = status;
    }

    public static SessionReadResult zzO(Status status) {
        return new SessionReadResult(new ArrayList(), new ArrayList(), status);
    }

    private boolean zzb(SessionReadResult sessionReadResult) {
        return this.zzOt.equals(sessionReadResult.zzOt) && zzt.equal(this.zzalQ, sessionReadResult.zzalQ) && zzt.equal(this.zzamX, sessionReadResult.zzamX);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SessionReadResult) && zzb((SessionReadResult) that));
    }

    public List<DataSet> getDataSet(Session session) {
        zzu.zzb(this.zzalQ.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (SessionDataSet sessionDataSet : this.zzamX) {
            if (zzt.equal(session, sessionDataSet.getSession())) {
                arrayList.add(sessionDataSet.zzqK());
            }
        }
        return arrayList;
    }

    public List<DataSet> getDataSet(Session session, DataType dataType) {
        zzu.zzb(this.zzalQ.contains(session), "Attempting to read data for session %s which was not returned", session);
        List<DataSet> arrayList = new ArrayList();
        for (SessionDataSet sessionDataSet : this.zzamX) {
            if (zzt.equal(session, sessionDataSet.getSession()) && dataType.equals(sessionDataSet.zzqK().getDataType())) {
                arrayList.add(sessionDataSet.zzqK());
            }
        }
        return arrayList;
    }

    public List<Session> getSessions() {
        return this.zzalQ;
    }

    public Status getStatus() {
        return this.zzOt;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzOt, this.zzalQ, this.zzamX);
    }

    public String toString() {
        return zzt.zzt(this).zzg(Games.EXTRA_STATUS, this.zzOt).zzg("sessions", this.zzalQ).zzg("sessionDataSets", this.zzamX).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    public List<SessionDataSet> zzry() {
        return this.zzamX;
    }
}
