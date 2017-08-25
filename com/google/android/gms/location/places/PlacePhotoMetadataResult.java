package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class PlacePhotoMetadataResult implements Result, SafeParcelable {
    public static final Creator<PlacePhotoMetadataResult> CREATOR = new zzi();
    final int zzCY;
    private final Status zzOt;
    final DataHolder zzazH;
    private final zzh zzazI;

    PlacePhotoMetadataResult(int versionCode, Status status, DataHolder dataHolder) {
        this.zzCY = versionCode;
        this.zzOt = status;
        this.zzazH = dataHolder;
        if (dataHolder == null) {
            this.zzazI = null;
        } else {
            this.zzazI = new zzh(this.zzazH);
        }
    }

    public int describeContents() {
        return 0;
    }

    public Status getStatus() {
        return this.zzOt;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzi.zza(this, parcel, flags);
    }
}
