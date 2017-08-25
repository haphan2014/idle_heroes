package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class GameBadgeBuffer extends AbstractDataBuffer<GameBadge> {
    public /* synthetic */ Object get(int x0) {
        return zzfI(x0);
    }

    public GameBadge zzfI(int i) {
        return new GameBadgeRef(this.zzWu, i);
    }
}
