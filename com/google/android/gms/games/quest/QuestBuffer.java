package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class QuestBuffer extends zzf<Quest> {
    public QuestBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzr(i, i2);
    }

    protected String zzni() {
        return "external_quest_id";
    }

    protected Quest zzr(int i, int i2) {
        return new QuestRef(this.zzWu, i, i2);
    }
}
