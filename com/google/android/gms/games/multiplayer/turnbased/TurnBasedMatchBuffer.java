package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class TurnBasedMatchBuffer extends zzf<TurnBasedMatch> {
    public TurnBasedMatchBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzq(i, i2);
    }

    protected String zzni() {
        return "external_match_id";
    }

    protected TurnBasedMatch zzq(int i, int i2) {
        return new TurnBasedMatchRef(this.zzWu, i, i2);
    }
}
