package com.google.android.gms.location.places;

import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzr;

public class PlaceBuffer extends AbstractDataBuffer<Place> implements Result {
    private final Context mContext;
    private final Status zzOt;
    private final String zzazB;

    public PlaceBuffer(DataHolder dataHolder, Context context) {
        super(dataHolder);
        this.mContext = context;
        this.zzOt = PlacesStatusCodes.zzgU(dataHolder.getStatusCode());
        if (dataHolder == null || dataHolder.zznb() == null) {
            this.zzazB = null;
        } else {
            this.zzazB = dataHolder.zznb().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    public Place get(int position) {
        return new zzr(this.zzWu, position, this.mContext);
    }

    public CharSequence getAttributions() {
        return this.zzazB;
    }

    public Status getStatus() {
        return this.zzOt;
    }
}
