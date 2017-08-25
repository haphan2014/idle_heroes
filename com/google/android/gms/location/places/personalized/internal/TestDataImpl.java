package com.google.android.gms.location.places.personalized.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.location.places.personalized.zzf;

public class TestDataImpl extends zzf implements SafeParcelable {
    public static final zza CREATOR = new zza();
    final int zzCY;
    private final String zzaBm;

    TestDataImpl(int versionCode, String testName) {
        this.zzCY = versionCode;
        this.zzaBm = testName;
    }

    public int describeContents() {
        zza com_google_android_gms_location_places_personalized_internal_zza = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof TestDataImpl)) {
            return false;
        }
        return this.zzaBm.equals(((TestDataImpl) object).zzaBm);
    }

    public int hashCode() {
        return this.zzaBm.hashCode();
    }

    public String toString() {
        return zzt.zzt(this).zzg("testName", this.zzaBm).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza com_google_android_gms_location_places_personalized_internal_zza = CREATOR;
        zza.zza(this, parcel, flags);
    }

    public String zzvf() {
        return this.zzaBm;
    }
}
