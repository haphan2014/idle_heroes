package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CapabilityInfoParcelable implements SafeParcelable, CapabilityInfo {
    public static final Creator<CapabilityInfoParcelable> CREATOR = new zzh();
    private final String mName;
    final int zzCY;
    private Set<Node> zzaTE;
    private final List<NodeParcelable> zzaTH;
    private final Object zzqt = new Object();

    CapabilityInfoParcelable(int versionCode, String name, List<NodeParcelable> nodeList) {
        this.zzCY = versionCode;
        this.mName = name;
        this.zzaTH = nodeList;
        this.zzaTE = null;
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
        CapabilityInfoParcelable capabilityInfoParcelable = (CapabilityInfoParcelable) o;
        if (this.zzCY != capabilityInfoParcelable.zzCY) {
            return false;
        }
        if (this.mName == null ? capabilityInfoParcelable.mName != null : !this.mName.equals(capabilityInfoParcelable.mName)) {
            return false;
        }
        if (this.zzaTH != null) {
            if (this.zzaTH.equals(capabilityInfoParcelable.zzaTH)) {
                return true;
            }
        } else if (capabilityInfoParcelable.zzaTH == null) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.mName;
    }

    public Set<Node> getNodes() {
        Set<Node> set;
        synchronized (this.zzqt) {
            if (this.zzaTE == null) {
                this.zzaTE = new HashSet(this.zzaTH);
            }
            set = this.zzaTE;
        }
        return set;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.mName != null ? this.mName.hashCode() : 0) + (this.zzCY * 31)) * 31;
        if (this.zzaTH != null) {
            i = this.zzaTH.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CapabilityInfo{" + this.mName + ", " + this.zzaTH + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public List<NodeParcelable> zzBa() {
        return this.zzaTH;
    }
}
