package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangesAvailableOptions;

public class AddEventListenerRequest implements SafeParcelable {
    public static final Creator<AddEventListenerRequest> CREATOR = new zza();
    final int zzCY;
    final DriveId zzacT;
    final int zzaca;
    final ChangesAvailableOptions zzadO;

    AddEventListenerRequest(int versionCode, DriveId driveId, int eventType, ChangesAvailableOptions changesAvailableOptions) {
        this.zzCY = versionCode;
        this.zzacT = driveId;
        this.zzaca = eventType;
        this.zzadO = changesAvailableOptions;
    }

    public AddEventListenerRequest(DriveId id, int eventType, ChangesAvailableOptions changesAvailableOptions) {
        this(1, id, eventType, changesAvailableOptions);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
