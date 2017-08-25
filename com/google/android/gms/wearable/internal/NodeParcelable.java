package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class NodeParcelable implements SafeParcelable, Node {
    public static final Creator<NodeParcelable> CREATOR = new zzay();
    final int zzCY;
    private final String zzKI;
    private final int zzaUL;
    private final boolean zzaUM;
    private final String zzadI;

    NodeParcelable(int versionCode, String id, String displayName, int hopCount, boolean isNearby) {
        this.zzCY = versionCode;
        this.zzKI = id;
        this.zzadI = displayName;
        this.zzaUL = hopCount;
        this.zzaUM = isNearby;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return !(o instanceof NodeParcelable) ? false : ((NodeParcelable) o).zzKI.equals(this.zzKI);
    }

    public String getDisplayName() {
        return this.zzadI;
    }

    public int getHopCount() {
        return this.zzaUL;
    }

    public String getId() {
        return this.zzKI;
    }

    public int hashCode() {
        return this.zzKI.hashCode();
    }

    public boolean isNearby() {
        return this.zzaUM;
    }

    public String toString() {
        return "Node{" + this.zzadI + ", id=" + this.zzKI + ", hops=" + this.zzaUL + ", isNearby=" + this.zzaUM + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzay.zza(this, dest, flags);
    }
}
