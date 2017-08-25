package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.AbstractDataBuffer;

public final class ParticipantBuffer extends AbstractDataBuffer<Participant> {
    public Participant get(int position) {
        return new ParticipantRef(this.zzWu, position);
    }
}
