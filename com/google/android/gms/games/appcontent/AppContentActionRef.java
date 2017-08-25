package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionRef extends MultiDataBufferRef implements AppContentAction {
    AppContentActionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 1, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentActionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzrR();
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzWu, this.zzaoD, "action_data", this.zzYs);
    }

    public String getId() {
        return getString("action_id");
    }

    public String getType() {
        return getString("action_type");
    }

    public int hashCode() {
        return AppContentActionEntity.zza(this);
    }

    public String toString() {
        return AppContentActionEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentActionEntity) zzrR()).writeToParcel(dest, flags);
    }

    public AppContentAnnotation zzrN() {
        List zzb = AppContentUtils.zzb(this.zzWu, this.zzaoD, "action_annotation", this.zzYs);
        return zzb.size() == 1 ? (AppContentAnnotation) zzb.get(0) : null;
    }

    public List<AppContentCondition> zzrO() {
        return AppContentUtils.zzc(this.zzWu, this.zzaoD, "action_conditions", this.zzYs);
    }

    public String zzrP() {
        return getString("action_content_description");
    }

    public String zzrQ() {
        return getString("overflow_text");
    }

    public AppContentAction zzrR() {
        return new AppContentActionEntity(this);
    }
}
