package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardRef extends MultiDataBufferRef implements AppContentCard {
    AppContentCardRef(ArrayList<DataHolder> dataHolderCollection, int dataRow) {
        super(dataHolderCollection, 0, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentCardEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzsd();
    }

    public List<AppContentAction> getActions() {
        return AppContentUtils.zza(this.zzWu, this.zzaoD, "card_actions", this.zzYs);
    }

    public String getDescription() {
        return getString("card_description");
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzWu, this.zzaoD, "card_data", this.zzYs);
    }

    public String getId() {
        return getString("card_id");
    }

    public String getTitle() {
        return getString("card_title");
    }

    public String getType() {
        return getString("card_type");
    }

    public int hashCode() {
        return AppContentCardEntity.zza(this);
    }

    public String toString() {
        return AppContentCardEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentCardEntity) zzsd()).writeToParcel(dest, flags);
    }

    public List<AppContentCondition> zzrO() {
        return AppContentUtils.zzc(this.zzWu, this.zzaoD, "card_conditions", this.zzYs);
    }

    public String zzrP() {
        return getString("card_content_description");
    }

    public List<AppContentAnnotation> zzrZ() {
        return AppContentUtils.zzb(this.zzWu, this.zzaoD, "card_annotations", this.zzYs);
    }

    public int zzsa() {
        return getInteger("card_current_steps");
    }

    public String zzsb() {
        return getString("card_subtitle");
    }

    public int zzsc() {
        return getInteger("card_total_steps");
    }

    public AppContentCard zzsd() {
        return new AppContentCardEntity(this);
    }
}
