package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public class PlaceAlias implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    public static final PlaceAlias zzaBg = new PlaceAlias(0, "Home");
    public static final PlaceAlias zzaBh = new PlaceAlias(0, "Work");
    final int zzCY;
    private final String zzaBi;

    PlaceAlias(int versionCode, String alias) {
        this.zzCY = versionCode;
        this.zzaBi = alias;
    }

    public int describeContents() {
        zzc com_google_android_gms_location_places_personalized_zzc = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceAlias)) {
            return false;
        }
        return zzt.equal(this.zzaBi, ((PlaceAlias) object).zzaBi);
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaBi);
    }

    public String toString() {
        return zzt.zzt(this).zzg("alias", this.zzaBi).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzc com_google_android_gms_location_places_personalized_zzc = CREATOR;
        zzc.zza(this, parcel, flags);
    }

    public String zzva() {
        return this.zzaBi;
    }
}
