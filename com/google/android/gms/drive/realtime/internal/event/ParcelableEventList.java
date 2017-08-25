package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
    public static final Creator<ParcelableEventList> CREATOR = new zzd();
    final int zzCY;
    final DataHolder zzaiQ;
    final boolean zzaiR;
    final List<String> zzaiS;
    final List<ParcelableEvent> zzoB;

    ParcelableEventList(int versionCode, List<ParcelableEvent> events, DataHolder eventData, boolean undoRedoStateChanged, List<String> affectedObjectIds) {
        this.zzCY = versionCode;
        this.zzoB = events;
        this.zzaiQ = eventData;
        this.zzaiR = undoRedoStateChanged;
        this.zzaiS = affectedObjectIds;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzd.zza(this, dest, flags);
    }
}
