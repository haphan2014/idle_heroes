package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig.Builder;

public final class RoomConfigImpl extends RoomConfig {
    private final String zzapl;
    private final int zzaui;
    private final RoomUpdateListener zzaut;
    private final RoomStatusUpdateListener zzauu;
    private final RealTimeMessageReceivedListener zzauv;
    private final Bundle zzauy;
    private final String[] zzauz;

    RoomConfigImpl(Builder builder) {
        this.zzaut = builder.zzaut;
        this.zzauu = builder.zzauu;
        this.zzauv = builder.zzauv;
        this.zzapl = builder.zzauw;
        this.zzaui = builder.zzaui;
        this.zzauy = builder.zzauy;
        this.zzauz = (String[]) builder.zzaux.toArray(new String[builder.zzaux.size()]);
        zzu.zzb(this.zzauv, (Object) "Must specify a message listener");
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzauy;
    }

    public String getInvitationId() {
        return this.zzapl;
    }

    public String[] getInvitedPlayerIds() {
        return this.zzauz;
    }

    public RealTimeMessageReceivedListener getMessageReceivedListener() {
        return this.zzauv;
    }

    public RoomStatusUpdateListener getRoomStatusUpdateListener() {
        return this.zzauu;
    }

    public RoomUpdateListener getRoomUpdateListener() {
        return this.zzaut;
    }

    public int getVariant() {
        return this.zzaui;
    }
}
