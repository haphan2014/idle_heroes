package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.internal.zzx;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzlo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MetadataBundle implements SafeParcelable {
    public static final Creator<MetadataBundle> CREATOR = new zzh();
    final int zzCY;
    final Bundle zzagI;

    MetadataBundle(int versionCode, Bundle valueBundle) {
        this.zzCY = versionCode;
        this.zzagI = (Bundle) zzu.zzu(valueBundle);
        this.zzagI.setClassLoader(getClass().getClassLoader());
        List<String> arrayList = new ArrayList();
        for (String str : this.zzagI.keySet()) {
            if (zze.zzcw(str) == null) {
                arrayList.add(str);
                zzx.zzu("MetadataBundle", "Ignored unknown metadata field in bundle: " + str);
            }
        }
        for (String str2 : arrayList) {
            this.zzagI.remove(str2);
        }
    }

    private MetadataBundle(Bundle valueBundle) {
        this(1, valueBundle);
    }

    public static <T> MetadataBundle zza(MetadataField<T> metadataField, T t) {
        MetadataBundle zzpX = zzpX();
        zzpX.zzb(metadataField, t);
        return zzpX;
    }

    public static MetadataBundle zza(MetadataBundle metadataBundle) {
        return new MetadataBundle(new Bundle(metadataBundle.zzagI));
    }

    public static MetadataBundle zzpX() {
        return new MetadataBundle(new Bundle());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MetadataBundle)) {
            return false;
        }
        MetadataBundle metadataBundle = (MetadataBundle) obj;
        Set<String> keySet = this.zzagI.keySet();
        if (!keySet.equals(metadataBundle.zzagI.keySet())) {
            return false;
        }
        for (String str : keySet) {
            if (!zzt.equal(this.zzagI.get(str), metadataBundle.zzagI.get(str))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 1;
        for (String str : this.zzagI.keySet()) {
            i *= 31;
            i = this.zzagI.get(str).hashCode() + i;
        }
        return i;
    }

    public void setContext(Context context) {
        BitmapTeleporter bitmapTeleporter = (BitmapTeleporter) zza(zzlo.zzaho);
        if (bitmapTeleporter != null) {
            bitmapTeleporter.zzc(context.getCacheDir());
        }
    }

    public String toString() {
        return "MetadataBundle [values=" + this.zzagI + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzh.zza(this, dest, flags);
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return metadataField.zzi(this.zzagI);
    }

    public <T> void zzb(MetadataField<T> metadataField, T t) {
        if (zze.zzcw(metadataField.getName()) == null) {
            throw new IllegalArgumentException("Unregistered field: " + metadataField.getName());
        }
        metadataField.zza(t, this.zzagI);
    }

    public boolean zzc(MetadataField<?> metadataField) {
        return this.zzagI.containsKey(metadataField.getName());
    }

    public Set<MetadataField<?>> zzpY() {
        Set<MetadataField<?>> hashSet = new HashSet();
        for (String zzcw : this.zzagI.keySet()) {
            hashSet.add(zze.zzcw(zzcw));
        }
        return hashSet;
    }
}
