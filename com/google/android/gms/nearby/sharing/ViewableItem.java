package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.Arrays;

public class ViewableItem implements SafeParcelable {
    public static final Creator<ViewableItem> CREATOR = new zzf();
    private final int versionCode;
    private String[] zzaGo;

    private ViewableItem() {
        this.versionCode = 1;
    }

    ViewableItem(int versionCode, String[] uris) {
        this.versionCode = versionCode;
        this.zzaGo = uris;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ViewableItem)) {
            return false;
        }
        return zzt.equal(this.zzaGo, ((ViewableItem) o).zzaGo);
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaGo);
    }

    public String toString() {
        return "ViewableItem[uris=" + Arrays.toString(this.zzaGo) + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public String[] zzxg() {
        return this.zzaGo;
    }
}
