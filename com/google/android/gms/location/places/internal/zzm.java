package com.google.android.gms.location.places.internal;

import android.content.Context;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public class zzm extends zzt implements PlaceLikelihood {
    private final Context mContext;

    public zzm(DataHolder dataHolder, int i, Context context) {
        super(dataHolder, i);
        this.mContext = context;
    }

    public /* synthetic */ Object freeze() {
        return zzuY();
    }

    public float getLikelihood() {
        return zzb("place_likelihood", (float) GroundOverlayOptions.NO_DIMENSION);
    }

    public Place getPlace() {
        return new zzr(this.zzWu, this.zzYs, this.mContext);
    }

    public PlaceLikelihood zzuY() {
        return PlaceLikelihoodEntity.zza((PlaceImpl) getPlace().freeze(), getLikelihood());
    }
}
