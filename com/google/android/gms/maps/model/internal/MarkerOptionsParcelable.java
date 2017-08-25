package com.google.android.gms.maps.model.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class MarkerOptionsParcelable implements SafeParcelable {
    public static final zzm CREATOR = new zzm();
    private final int zzCY;
    private BitmapDescriptorParcelable zzaDQ;

    public MarkerOptionsParcelable() {
        this.zzCY = 1;
    }

    MarkerOptionsParcelable(int versionCode, BitmapDescriptorParcelable parcelableIcon) {
        this.zzCY = versionCode;
        this.zzaDQ = parcelableIcon;
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzm.zza(this, out, flags);
    }

    public BitmapDescriptorParcelable zzvO() {
        return this.zzaDQ;
    }
}
