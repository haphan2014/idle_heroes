package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.WriteAwareParcelable;

public class QueryResultEventParcelable extends WriteAwareParcelable implements DriveEvent {
    public static final zzk CREATOR = new zzk();
    final int zzCY;
    final DataHolder zzWu;
    final boolean zzaei;
    final int zzaej;

    QueryResultEventParcelable(int versionCode, DataHolder dataHolder, boolean isStatusChanged, int queryStatus) {
        this.zzCY = versionCode;
        this.zzWu = dataHolder;
        this.zzaei = isStatusChanged;
        this.zzaej = queryStatus;
    }

    public int describeContents() {
        return 0;
    }

    public int getType() {
        return 3;
    }

    public void zzI(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public DataHolder zzpx() {
        return this.zzWu;
    }

    public boolean zzpy() {
        return this.zzaei;
    }

    public int zzpz() {
        return this.zzaej;
    }
}
