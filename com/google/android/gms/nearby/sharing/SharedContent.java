package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.Arrays;

public class SharedContent implements SafeParcelable {
    public static final Creator<SharedContent> CREATOR = new zzc();
    private final int versionCode;
    @Deprecated
    private String zzaGl;
    private ViewableItem[] zzaGm;
    private LocalContent[] zzaGn;

    private SharedContent() {
        this.versionCode = 2;
    }

    SharedContent(int versionCode, String uri, ViewableItem[] viewableItems, LocalContent[] localContents) {
        this.versionCode = versionCode;
        this.zzaGl = uri;
        this.zzaGm = viewableItems;
        this.zzaGn = localContents;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SharedContent)) {
            return false;
        }
        SharedContent sharedContent = (SharedContent) o;
        return zzt.equal(this.zzaGm, sharedContent.zzaGm) && zzt.equal(this.zzaGn, sharedContent.zzaGn) && zzt.equal(this.zzaGl, sharedContent.zzaGl);
    }

    public String getUri() {
        return this.zzaGl;
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaGm, this.zzaGn, this.zzaGl);
    }

    public String toString() {
        return "SharedContent[viewableItems=" + Arrays.toString(this.zzaGm) + ", localContents=" + Arrays.toString(this.zzaGn) + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public ViewableItem[] zzxe() {
        return this.zzaGm;
    }

    public LocalContent[] zzxf() {
        return this.zzaGn;
    }
}
