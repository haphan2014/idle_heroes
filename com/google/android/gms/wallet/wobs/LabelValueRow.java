package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzkx;
import java.util.ArrayList;

public final class LabelValueRow implements SafeParcelable {
    public static final Creator<LabelValueRow> CREATOR = new zzc();
    private final int zzCY;
    String zzaSx;
    String zzaSy;
    ArrayList<LabelValue> zzaSz;

    LabelValueRow() {
        this.zzCY = 1;
        this.zzaSz = zzkx.zzoP();
    }

    LabelValueRow(int versionCode, String hexFontColor, String hexBackgroundColor, ArrayList<LabelValue> columns) {
        this.zzCY = versionCode;
        this.zzaSx = hexFontColor;
        this.zzaSy = hexBackgroundColor;
        this.zzaSz = columns;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
