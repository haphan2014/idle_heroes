package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzt.zza;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutocompleteFilter implements SafeParcelable {
    public static final zzc CREATOR = new zzc();
    final int zzCY;
    final boolean zzazr;
    final List<Integer> zzazs;
    private final Set<Integer> zzazt;

    AutocompleteFilter(int versionCode, boolean restrictToPlaces, Collection<Integer> placeTypes) {
        this.zzCY = versionCode;
        this.zzazr = restrictToPlaces;
        this.zzazs = placeTypes == null ? Collections.emptyList() : new ArrayList(placeTypes);
        if (this.zzazs.isEmpty()) {
            this.zzazt = Collections.emptySet();
        } else {
            this.zzazt = Collections.unmodifiableSet(new HashSet(this.zzazs));
        }
    }

    public static AutocompleteFilter create(Collection<Integer> placeTypes) {
        return zza(true, placeTypes);
    }

    public static AutocompleteFilter zza(boolean z, Collection<Integer> collection) {
        return new AutocompleteFilter(0, z, collection);
    }

    public int describeContents() {
        zzc com_google_android_gms_location_places_zzc = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AutocompleteFilter)) {
            return false;
        }
        AutocompleteFilter autocompleteFilter = (AutocompleteFilter) object;
        return this.zzazt.equals(autocompleteFilter.zzazt) && this.zzazr == autocompleteFilter.zzazr;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzazt;
    }

    public int hashCode() {
        return zzt.hashCode(Boolean.valueOf(this.zzazr), this.zzazt);
    }

    public String toString() {
        zza zzt = zzt.zzt(this);
        if (!this.zzazr) {
            zzt.zzg("restrictedToPlaces", Boolean.valueOf(this.zzazr));
        }
        zzt.zzg("placeTypes", this.zzazt);
        return zzt.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzc com_google_android_gms_location_places_zzc = CREATOR;
        zzc.zza(this, parcel, flags);
    }

    public boolean zzuE() {
        return this.zzazr;
    }
}
