package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionRef extends MultiDataBufferRef implements AppContentSection {
    private final int zzaoG;

    AppContentSectionRef(ArrayList<DataHolder> dataHolderCollection, int dataRow, int numChildren) {
        super(dataHolderCollection, 0, dataRow);
        this.zzaoG = numChildren;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return AppContentSectionEntity.zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzsl();
    }

    public /* synthetic */ List getActions() {
        return zzsm();
    }

    public Bundle getExtras() {
        return AppContentUtils.zzd(this.zzWu, this.zzaoD, "section_data", this.zzYs);
    }

    public String getId() {
        return getString("section_id");
    }

    public String getTitle() {
        return getString("section_title");
    }

    public String getType() {
        return getString("section_type");
    }

    public int hashCode() {
        return AppContentSectionEntity.zza(this);
    }

    public String toString() {
        return AppContentSectionEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((AppContentSectionEntity) zzsl()).writeToParcel(dest, flags);
    }

    public String zzrP() {
        return getString("section_content_description");
    }

    public /* synthetic */ List zzrZ() {
        return zzsn();
    }

    public String zzsb() {
        return getString("section_subtitle");
    }

    public /* synthetic */ List zzsj() {
        return zzso();
    }

    public String zzsk() {
        return getString("section_card_type");
    }

    public AppContentSection zzsl() {
        return new AppContentSectionEntity(this);
    }

    public ArrayList<AppContentAction> zzsm() {
        return AppContentUtils.zza(this.zzWu, this.zzaoD, "section_actions", this.zzYs);
    }

    public ArrayList<AppContentAnnotation> zzsn() {
        return AppContentUtils.zzb(this.zzWu, this.zzaoD, "section_annotations", this.zzYs);
    }

    public ArrayList<AppContentCard> zzso() {
        ArrayList<AppContentCard> arrayList = new ArrayList(this.zzaoG);
        for (int i = 0; i < this.zzaoG; i++) {
            arrayList.add(new AppContentCardRef(this.zzaoD, this.zzYs + i));
        }
        return arrayList;
    }
}
