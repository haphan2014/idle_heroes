package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.List;

@Deprecated
public final class PlaceLocalization implements SafeParcelable {
    public static final zzn CREATOR = new zzn();
    public final String name;
    public final int versionCode;
    public final String zzaAM;
    public final String zzaAN;
    public final String zzaAO;
    public final List<String> zzaAP;

    public PlaceLocalization(int versionCode, String name, String address, String internationalPhoneNumber, String regularOpenHours, List<String> attributions) {
        this.versionCode = versionCode;
        this.name = name;
        this.zzaAM = address;
        this.zzaAN = internationalPhoneNumber;
        this.zzaAO = regularOpenHours;
        this.zzaAP = attributions;
    }

    public static PlaceLocalization zza(String str, String str2, String str3, String str4, List<String> list) {
        return new PlaceLocalization(0, str, str2, str3, str4, list);
    }

    public int describeContents() {
        zzn com_google_android_gms_location_places_internal_zzn = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceLocalization)) {
            return false;
        }
        PlaceLocalization placeLocalization = (PlaceLocalization) object;
        return zzt.equal(this.name, placeLocalization.name) && zzt.equal(this.zzaAM, placeLocalization.zzaAM) && zzt.equal(this.zzaAN, placeLocalization.zzaAN) && zzt.equal(this.zzaAO, placeLocalization.zzaAO) && zzt.equal(this.zzaAP, placeLocalization.zzaAP);
    }

    public int hashCode() {
        return zzt.hashCode(this.name, this.zzaAM, this.zzaAN, this.zzaAO);
    }

    public String toString() {
        return zzt.zzt(this).zzg("name", this.name).zzg("address", this.zzaAM).zzg("internationalPhoneNumber", this.zzaAN).zzg("regularOpenHours", this.zzaAO).zzg("attributions", this.zzaAP).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzn com_google_android_gms_location_places_internal_zzn = CREATOR;
        zzn.zza(this, parcel, flags);
    }
}
