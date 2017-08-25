package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class MessageEventParcelable implements SafeParcelable, MessageEvent {
    public static final Creator<MessageEventParcelable> CREATOR = new zzaw();
    final int zzCY;
    private final String zzaTQ;
    private final int zzacR;
    private final byte[] zzauL;
    private final String zzazL;

    MessageEventParcelable(int versionCode, int requestId, String path, byte[] data, String source) {
        this.zzCY = versionCode;
        this.zzacR = requestId;
        this.zzaTQ = path;
        this.zzauL = data;
        this.zzazL = source;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        return this.zzauL;
    }

    public String getPath() {
        return this.zzaTQ;
    }

    public int getRequestId() {
        return this.zzacR;
    }

    public String getSourceNodeId() {
        return this.zzazL;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.zzacR + "," + this.zzaTQ + ", size=" + (this.zzauL == null ? "null" : Integer.valueOf(this.zzauL.length)) + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzaw.zza(this, dest, flags);
    }
}
