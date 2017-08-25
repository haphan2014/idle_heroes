package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DriveSpace implements SafeParcelable {
    public static final Creator<DriveSpace> CREATOR = new zzg();
    public static final DriveSpace zzadi = new DriveSpace("DRIVE");
    public static final DriveSpace zzadj = new DriveSpace("APP_DATA_FOLDER");
    public static final DriveSpace zzadk = new DriveSpace(NativeProtocol.METHOD_ARGS_PHOTOS);
    public static final Set<DriveSpace> zzadl = Collections.unmodifiableSet(new HashSet(Arrays.asList(new DriveSpace[]{zzadi, zzadj, zzadk})));
    public static final String zzadm = TextUtils.join(",", zzadl.toArray());
    private final String mName;
    final int zzCY;

    DriveSpace(int versionCode, String name) {
        this.zzCY = versionCode;
        this.mName = (String) zzu.zzu(name);
    }

    private DriveSpace(String name) {
        this(1, name);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return (o == null || o.getClass() != DriveSpace.class) ? false : this.mName.equals(((DriveSpace) o).mName);
    }

    public String getName() {
        return this.mName;
    }

    public int hashCode() {
        return 1247068382 ^ this.mName.hashCode();
    }

    public String toString() {
        return this.mName;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzg.zza(this, out, flags);
    }
}
