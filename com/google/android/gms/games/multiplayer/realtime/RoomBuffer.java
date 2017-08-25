package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class RoomBuffer extends zzf<Room> {
    public RoomBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzp(i, i2);
    }

    protected String zzni() {
        return "external_match_id";
    }

    protected Room zzp(int i, int i2) {
        return new RoomRef(this.zzWu, i, i2);
    }
}
