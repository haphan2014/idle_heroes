package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.Games;
import com.google.android.gms.location.places.internal.zzb;

public class AutocompletePredictionBuffer extends AbstractDataBuffer<AutocompletePrediction> implements Result {
    public AutocompletePredictionBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    public AutocompletePrediction get(int position) {
        return new zzb(this.zzWu, position);
    }

    public Status getStatus() {
        return PlacesStatusCodes.zzgU(this.zzWu.getStatusCode());
    }

    public String toString() {
        return zzt.zzt(this).zzg(Games.EXTRA_STATUS, getStatus()).toString();
    }
}
