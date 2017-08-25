package com.google.android.gms.maps.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Point implements SafeParcelable {
    public static final zzz CREATOR = new zzz();
    private final int versionCode;
    private final android.graphics.Point zzaCO;

    public Point(int versionCode, android.graphics.Point point) {
        this.versionCode = versionCode;
        this.zzaCO = point;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Point)) {
            return false;
        }
        return this.zzaCO.equals(((Point) o).zzaCO);
    }

    int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return this.zzaCO.hashCode();
    }

    public String toString() {
        return this.zzaCO.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzz.zza(this, out, flags);
    }

    public android.graphics.Point zzvG() {
        return this.zzaCO;
    }
}
