package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BeginCompoundOperationRequest implements SafeParcelable {
    public static final Creator<BeginCompoundOperationRequest> CREATOR = new zza();
    final String mName;
    final int zzCY;
    final boolean zzaiq;
    final boolean zzair;

    BeginCompoundOperationRequest(int versionCode, boolean isCreation, String name, boolean isUndoable) {
        this.zzCY = versionCode;
        this.zzaiq = isCreation;
        this.mName = name;
        this.zzair = isUndoable;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
