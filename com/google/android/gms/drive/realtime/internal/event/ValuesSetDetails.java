package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesSetDetails implements SafeParcelable {
    public static final Creator<ValuesSetDetails> CREATOR = new zzk();
    final int mIndex;
    final int zzCY;
    final int zzaiA;
    final int zzaiB;

    ValuesSetDetails(int versionCode, int index, int valueIndex, int valueCount) {
        this.zzCY = versionCode;
        this.mIndex = index;
        this.zzaiA = valueIndex;
        this.zzaiB = valueCount;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzk.zza(this, dest, flags);
    }
}
