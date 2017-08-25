package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class CustomProperty implements SafeParcelable {
    public static final Creator<CustomProperty> CREATOR = new zzc();
    final String mValue;
    final int zzCY;
    final CustomPropertyKey zzagG;

    CustomProperty(int versionCode, CustomPropertyKey key, String value) {
        this.zzCY = versionCode;
        zzu.zzb((Object) key, (Object) "key");
        this.zzagG = key;
        this.mValue = value;
    }

    public CustomProperty(CustomPropertyKey key, String value) {
        this(1, key, value);
    }

    public int describeContents() {
        return 0;
    }

    public String getValue() {
        return this.mValue;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public CustomPropertyKey zzpV() {
        return this.zzagG;
    }
}
