package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class OpenFileIntentSenderRequest implements SafeParcelable {
    public static final Creator<OpenFileIntentSenderRequest> CREATOR = new zzbj();
    final int zzCY;
    final String zzadv;
    final String[] zzadw;
    final DriveId zzady;
    final FilterHolder zzagt;

    OpenFileIntentSenderRequest(int versionCode, String title, String[] mimeTypes, DriveId startFolder, FilterHolder filterHolder) {
        this.zzCY = versionCode;
        this.zzadv = title;
        this.zzadw = mimeTypes;
        this.zzady = startFolder;
        this.zzagt = filterHolder;
    }

    public OpenFileIntentSenderRequest(String title, String[] mimeTypes, DriveId startFolder, FilterHolder filterHolder) {
        this(1, title, mimeTypes, startFolder, filterHolder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbj.zza(this, dest, flags);
    }
}
