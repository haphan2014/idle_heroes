package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class LeaderboardScoreBuffer extends AbstractDataBuffer<LeaderboardScore> {
    private final LeaderboardScoreBufferHeader zzatC;

    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zzatC = new LeaderboardScoreBufferHeader(dataHolder.zznb());
    }

    public LeaderboardScore get(int position) {
        return new LeaderboardScoreRef(this.zzWu, position);
    }

    public LeaderboardScoreBufferHeader zztF() {
        return this.zzatC;
    }
}
