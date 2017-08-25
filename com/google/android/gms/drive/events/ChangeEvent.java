package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

public final class ChangeEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<ChangeEvent> CREATOR = new zza();
    final int zzCY;
    final DriveId zzacT;
    final int zzadN;

    ChangeEvent(int versionCode, DriveId driveId, int changeFlags) {
        this.zzCY = versionCode;
        this.zzacT = driveId;
        this.zzadN = changeFlags;
    }

    public int describeContents() {
        return 0;
    }

    public DriveId getDriveId() {
        return this.zzacT;
    }

    public int getType() {
        return 1;
    }

    public boolean hasBeenDeleted() {
        return (this.zzadN & 4) != 0;
    }

    public boolean hasContentChanged() {
        return (this.zzadN & 2) != 0;
    }

    public boolean hasMetadataChanged() {
        return (this.zzadN & 1) != 0;
    }

    public String toString() {
        return String.format(Locale.US, "ChangeEvent [id=%s,changeFlags=%x]", new Object[]{this.zzacT, Integer.valueOf(this.zzadN)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
