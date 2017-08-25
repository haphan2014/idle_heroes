package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import java.util.ArrayList;

public final class AppContentSectionBuffer extends zzf<AppContentSection> {
    private final ArrayList<DataHolder> zzaoD;

    public void release() {
        super.release();
        int size = this.zzaoD.size();
        for (int i = 1; i < size; i++) {
            DataHolder dataHolder = (DataHolder) this.zzaoD.get(i);
            if (dataHolder != null) {
                dataHolder.close();
            }
        }
    }

    protected /* synthetic */ Object zzj(int i, int i2) {
        return zzm(i, i2);
    }

    protected AppContentSection zzm(int i, int i2) {
        return new AppContentSectionRef(this.zzaoD, i, i2);
    }

    protected String zzni() {
        return "section_id";
    }

    protected String zznk() {
        return "card_id";
    }
}
