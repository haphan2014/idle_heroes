package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties implements SafeParcelable, Iterable<CustomProperty> {
    public static final Creator<AppVisibleCustomProperties> CREATOR = new zza();
    public static final AppVisibleCustomProperties zzagD = new zza().zzpU();
    final int zzCY;
    final List<CustomProperty> zzagE;

    public static class zza {
        private final Map<CustomPropertyKey, CustomProperty> zzagF = new HashMap();

        public zza zza(CustomPropertyKey customPropertyKey, String str) {
            zzu.zzb((Object) customPropertyKey, (Object) "key");
            this.zzagF.put(customPropertyKey, new CustomProperty(customPropertyKey, str));
            return this;
        }

        public AppVisibleCustomProperties zzpU() {
            return new AppVisibleCustomProperties(this.zzagF.values());
        }
    }

    AppVisibleCustomProperties(int versionCode, Collection<CustomProperty> properties) {
        this.zzCY = versionCode;
        zzu.zzu(properties);
        this.zzagE = new ArrayList(properties);
    }

    private AppVisibleCustomProperties(Collection<CustomProperty> properties) {
        this(1, (Collection) properties);
    }

    public int describeContents() {
        return 0;
    }

    public Iterator<CustomProperty> iterator() {
        return this.zzagE.iterator();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }

    public Map<CustomPropertyKey, String> zzpT() {
        Map hashMap = new HashMap(this.zzagE.size());
        for (CustomProperty customProperty : this.zzagE) {
            hashMap.put(customProperty.zzpV(), customProperty.getValue());
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
