package com.google.android.gms.games.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class GameRequestBuffer extends zzf<GameRequest> {
    public GameRequestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzs(i, i2);
    }

    protected String zzni() {
        return "external_request_id";
    }

    protected GameRequest zzs(int i, int i2) {
        return new GameRequestRef(this.zzWu, i, i2);
    }
}
