package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentConditionRef extends MultiDataBufferRef implements AppContentCondition {
    AppContentConditionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 4, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentConditionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzsi();
    }

    public int hashCode() {
        return AppContentConditionEntity.zza(this);
    }

    public String toString() {
        return AppContentConditionEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentConditionEntity) zzsi()).writeToParcel(dest, flags);
    }

    public String zzse() {
        return getString("condition_default_value");
    }

    public String zzsf() {
        return getString("condition_expected_value");
    }

    public String zzsg() {
        return getString("condition_predicate");
    }

    public Bundle zzsh() {
        return AppContentUtils.zzd(this.zzWu, this.zzaoD, "condition_predicate_parameters", this.zzYs);
    }

    public AppContentCondition zzsi() {
        return new AppContentConditionEntity(this);
    }
}
