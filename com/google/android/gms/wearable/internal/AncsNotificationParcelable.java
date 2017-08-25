package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzb;

public class AncsNotificationParcelable implements SafeParcelable, zzb {
    public static final Creator<AncsNotificationParcelable> CREATOR = new zze();
    private int mId;
    final int zzCY;
    private final String zzRx;
    private final String zzaEw;
    private final String zzaTu;
    private byte zzaTv;
    private byte zzaTw;
    private byte zzaTx;
    private byte zzaTy;
    private String zzadI;
    private final String zzadv;
    private final String zzaox;

    AncsNotificationParcelable(int versionCode, int id, String appId, String dateTime, String notificationText, String title, String subtitle, String displayName, byte eventId, byte eventFlags, byte categoryId, byte categoryCount) {
        this.mId = id;
        this.zzCY = versionCode;
        this.zzaEw = appId;
        this.zzaTu = dateTime;
        this.zzRx = notificationText;
        this.zzadv = title;
        this.zzaox = subtitle;
        this.zzadI = displayName;
        this.zzaTv = eventId;
        this.zzaTw = eventFlags;
        this.zzaTx = categoryId;
        this.zzaTy = categoryCount;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AncsNotificationParcelable ancsNotificationParcelable = (AncsNotificationParcelable) o;
        return this.zzaTy != ancsNotificationParcelable.zzaTy ? false : this.zzaTx != ancsNotificationParcelable.zzaTx ? false : this.zzaTw != ancsNotificationParcelable.zzaTw ? false : this.zzaTv != ancsNotificationParcelable.zzaTv ? false : this.mId != ancsNotificationParcelable.mId ? false : this.zzCY != ancsNotificationParcelable.zzCY ? false : !this.zzaEw.equals(ancsNotificationParcelable.zzaEw) ? false : (this.zzaTu == null ? ancsNotificationParcelable.zzaTu != null : !this.zzaTu.equals(ancsNotificationParcelable.zzaTu)) ? false : !this.zzadI.equals(ancsNotificationParcelable.zzadI) ? false : !this.zzRx.equals(ancsNotificationParcelable.zzRx) ? false : !this.zzaox.equals(ancsNotificationParcelable.zzaox) ? false : this.zzadv.equals(ancsNotificationParcelable.zzadv);
    }

    public String getDisplayName() {
        return this.zzadI == null ? this.zzaEw : this.zzadI;
    }

    public int getId() {
        return this.mId;
    }

    public String getTitle() {
        return this.zzadv;
    }

    public int hashCode() {
        return (((((((((((((((((this.zzaTu != null ? this.zzaTu.hashCode() : 0) + (((((this.zzCY * 31) + this.mId) * 31) + this.zzaEw.hashCode()) * 31)) * 31) + this.zzRx.hashCode()) * 31) + this.zzadv.hashCode()) * 31) + this.zzaox.hashCode()) * 31) + this.zzadI.hashCode()) * 31) + this.zzaTv) * 31) + this.zzaTw) * 31) + this.zzaTx) * 31) + this.zzaTy;
    }

    public String toString() {
        return "AncsNotificationParcelable{mVersionCode=" + this.zzCY + ", mId=" + this.mId + ", mAppId='" + this.zzaEw + '\'' + ", mDateTime='" + this.zzaTu + '\'' + ", mNotificationText='" + this.zzRx + '\'' + ", mTitle='" + this.zzadv + '\'' + ", mSubtitle='" + this.zzaox + '\'' + ", mDisplayName='" + this.zzadI + '\'' + ", mEventId=" + this.zzaTv + ", mEventFlags=" + this.zzaTw + ", mCategoryId=" + this.zzaTx + ", mCategoryCount=" + this.zzaTy + '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }

    public String zzAU() {
        return this.zzaTu;
    }

    public String zzAV() {
        return this.zzRx;
    }

    public byte zzAW() {
        return this.zzaTv;
    }

    public byte zzAX() {
        return this.zzaTw;
    }

    public byte zzAY() {
        return this.zzaTx;
    }

    public byte zzAZ() {
        return this.zzaTy;
    }

    public String zzsK() {
        return this.zzaEw;
    }

    public String zzsb() {
        return this.zzaox;
    }
}
