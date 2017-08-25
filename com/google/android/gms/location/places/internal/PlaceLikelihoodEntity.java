package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

public class PlaceLikelihoodEntity implements SafeParcelable, PlaceLikelihood {
    public static final Creator<PlaceLikelihoodEntity> CREATOR = new zzl();
    final int zzCY;
    final PlaceImpl zzaAK;
    final float zzaAL;

    PlaceLikelihoodEntity(int versionCode, PlaceImpl place, float likelihood) {
        this.zzCY = versionCode;
        this.zzaAK = place;
        this.zzaAL = likelihood;
    }

    public static PlaceLikelihoodEntity zza(PlaceImpl placeImpl, float f) {
        return new PlaceLikelihoodEntity(0, (PlaceImpl) zzu.zzu(placeImpl), f);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PlaceLikelihoodEntity)) {
            return false;
        }
        PlaceLikelihoodEntity placeLikelihoodEntity = (PlaceLikelihoodEntity) object;
        return this.zzaAK.equals(placeLikelihoodEntity.zzaAK) && this.zzaAL == placeLikelihoodEntity.zzaAL;
    }

    public /* synthetic */ Object freeze() {
        return zzuY();
    }

    public float getLikelihood() {
        return this.zzaAL;
    }

    public Place getPlace() {
        return this.zzaAK;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaAK, Float.valueOf(this.zzaAL));
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzt.zzt(this).zzg("place", this.zzaAK).zzg("likelihood", Float.valueOf(this.zzaAL)).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzl.zza(this, parcel, flags);
    }

    public PlaceLikelihood zzuY() {
        return this;
    }
}
