package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class LeaderboardBuffer extends zzf<Leaderboard> {
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzn(i, i2);
    }

    protected Leaderboard zzn(int i, int i2) {
        return new LeaderboardRef(this.zzWu, i, i2);
    }

    protected String zzni() {
        return "external_leaderboard_id";
    }
}
