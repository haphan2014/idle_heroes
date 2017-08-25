package com.google.android.gms.location.places;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class PlaceFilter extends zza implements SafeParcelable {
    public static final zzf CREATOR = new zzf();
    final int zzCY;
    final boolean zzazC;
    final List<Integer> zzazs;
    private final Set<Integer> zzazt;
    final List<String> zzazu;
    final List<UserDataType> zzazv;
    private final Set<String> zzazw;
    private final Set<UserDataType> zzazx;

    @Deprecated
    public static final class zza {
        private boolean zzazC;
        private Collection<Integer> zzazD;
        private Collection<UserDataType> zzazE;
        private String[] zzazF;

        private zza() {
            this.zzazD = null;
            this.zzazC = false;
            this.zzazE = null;
            this.zzazF = null;
        }

        public PlaceFilter zzuK() {
            Collection collection = null;
            Collection arrayList = this.zzazD != null ? new ArrayList(this.zzazD) : null;
            Collection arrayList2 = this.zzazE != null ? new ArrayList(this.zzazE) : null;
            if (this.zzazF != null) {
                collection = Arrays.asList(this.zzazF);
            }
            return new PlaceFilter(arrayList, this.zzazC, collection, arrayList2);
        }
    }

    public PlaceFilter() {
        this(false, null);
    }

    PlaceFilter(int versionCode, List<Integer> placeTypesList, boolean requireOpenNow, List<String> placeIdsList, List<UserDataType> requestedUserDataTypesList) {
        this.zzCY = versionCode;
        this.zzazs = placeTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(placeTypesList);
        this.zzazC = requireOpenNow;
        this.zzazv = requestedUserDataTypesList == null ? Collections.emptyList() : Collections.unmodifiableList(requestedUserDataTypesList);
        this.zzazu = placeIdsList == null ? Collections.emptyList() : Collections.unmodifiableList(placeIdsList);
        this.zzazt = zza.zzl(this.zzazs);
        this.zzazx = zza.zzl(this.zzazv);
        this.zzazw = zza.zzl(this.zzazu);
    }

    public PlaceFilter(Collection<Integer> restrictToPlaceTypes, boolean requireOpenNow, Collection<String> restrictToPlaceIds, Collection<UserDataType> requestedUserDataTypes) {
        this(0, zza.zzc(restrictToPlaceTypes), requireOpenNow, zza.zzc(restrictToPlaceIds), zza.zzc(requestedUserDataTypes));
    }

    public PlaceFilter(boolean requireOpenNow, Collection<String> restrictToPlaceIds) {
        this(null, requireOpenNow, restrictToPlaceIds, null);
    }

    @Deprecated
    public static PlaceFilter zzuJ() {
        return new zza().zzuK();
    }

    public int describeContents() {
        zzf com_google_android_gms_location_places_zzf = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceFilter)) {
            return false;
        }
        PlaceFilter placeFilter = (PlaceFilter) object;
        return this.zzazt.equals(placeFilter.zzazt) && this.zzazC == placeFilter.zzazC && this.zzazx.equals(placeFilter.zzazx) && this.zzazw.equals(placeFilter.zzazw);
    }

    public Set<String> getPlaceIds() {
        return this.zzazw;
    }

    public Set<Integer> getPlaceTypes() {
        return this.zzazt;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzazt, Boolean.valueOf(this.zzazC), this.zzazx, this.zzazw);
    }

    public boolean isRestrictedToPlacesOpenNow() {
        return this.zzazC;
    }

    public String toString() {
        com.google.android.gms.common.internal.zzt.zza zzt = zzt.zzt(this);
        if (!this.zzazt.isEmpty()) {
            zzt.zzg("types", this.zzazt);
        }
        zzt.zzg("requireOpenNow", Boolean.valueOf(this.zzazC));
        if (!this.zzazw.isEmpty()) {
            zzt.zzg("placeIds", this.zzazw);
        }
        if (!this.zzazx.isEmpty()) {
            zzt.zzg("requestedUserDataTypes", this.zzazx);
        }
        return zzt.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzf com_google_android_gms_location_places_zzf = CREATOR;
        zzf.zza(this, parcel, flags);
    }

    public Set<UserDataType> zzuI() {
        return this.zzazx;
    }
}
