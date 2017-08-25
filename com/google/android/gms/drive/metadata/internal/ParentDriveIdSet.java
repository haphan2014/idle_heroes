package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParentDriveIdSet implements SafeParcelable {
    public static final Creator<ParentDriveIdSet> CREATOR = new zzk();
    final int zzCY;
    final List<PartialDriveId> zzagJ;

    public ParentDriveIdSet() {
        this(1, new ArrayList());
    }

    ParentDriveIdSet(int versionCode, List<PartialDriveId> partialDriveIds) {
        this.zzCY = versionCode;
        this.zzagJ = partialDriveIds;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzk.zza(this, out, flags);
    }

    public Set<DriveId> zzC(long j) {
        Set<DriveId> hashSet = new HashSet();
        for (PartialDriveId zzD : this.zzagJ) {
            hashSet.add(zzD.zzD(j));
        }
        return hashSet;
    }

    public void zza(PartialDriveId partialDriveId) {
        this.zzagJ.add(partialDriveId);
    }
}
