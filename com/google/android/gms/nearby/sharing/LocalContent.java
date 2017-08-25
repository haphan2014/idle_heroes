package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public class LocalContent implements SafeParcelable {
    public static final Creator<LocalContent> CREATOR = new zzb();
    private int type;
    private final int versionCode;
    private String zzaGk;

    private LocalContent() {
        this.versionCode = 1;
    }

    LocalContent(int versionCode, int type, String contentUri) {
        this.versionCode = versionCode;
        this.type = type;
        this.zzaGk = contentUri;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LocalContent)) {
            return false;
        }
        LocalContent localContent = (LocalContent) o;
        return zzt.equal(Integer.valueOf(this.type), Integer.valueOf(localContent.type)) && zzt.equal(this.zzaGk, localContent.zzaGk);
    }

    public int getType() {
        return this.type;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.type), this.zzaGk);
    }

    public String toString() {
        return "LocalContent[contentUri=" + this.zzaGk + ", type=" + (this.type == 1 ? "PUBLIC_CONTENT" : "APP_CONTENT") + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public String zzxd() {
        return this.zzaGk;
    }
}
