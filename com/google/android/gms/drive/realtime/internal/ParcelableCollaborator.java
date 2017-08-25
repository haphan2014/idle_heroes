package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator implements SafeParcelable {
    public static final Creator<ParcelableCollaborator> CREATOR = new zzp();
    final int zzCY;
    final String zzEO;
    final String zzFE;
    final String zzadI;
    final boolean zzais;
    final boolean zzait;
    final String zzaiu;
    final String zzaiv;

    ParcelableCollaborator(int versionCode, boolean isMe, boolean isAnonymous, String sessionId, String userId, String displayName, String color, String photoUrl) {
        this.zzCY = versionCode;
        this.zzais = isMe;
        this.zzait = isAnonymous;
        this.zzFE = sessionId;
        this.zzEO = userId;
        this.zzadI = displayName;
        this.zzaiu = color;
        this.zzaiv = photoUrl;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParcelableCollaborator)) {
            return false;
        }
        return this.zzFE.equals(((ParcelableCollaborator) obj).zzFE);
    }

    public int hashCode() {
        return this.zzFE.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.zzais + ", isAnonymous=" + this.zzait + ", sessionId=" + this.zzFE + ", userId=" + this.zzEO + ", displayName=" + this.zzadI + ", color=" + this.zzaiu + ", photoUrl=" + this.zzaiv + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzp.zza(this, dest, flags);
    }
}
