package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig.Builder;

public final class TurnBasedMatchConfigImpl extends TurnBasedMatchConfig {
    private final int zzauH;
    private final int zzaui;
    private final Bundle zzauy;
    private final String[] zzauz;

    TurnBasedMatchConfigImpl(Builder builder) {
        this.zzaui = builder.zzaui;
        this.zzauH = builder.zzauH;
        this.zzauy = builder.zzauy;
        this.zzauz = (String[]) builder.zzaux.toArray(new String[builder.zzaux.size()]);
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzauy;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzauz;
    }

    public int getVariant() {
        return this.zzaui;
    }

    public int zztL() {
        return this.zzauH;
    }
}
