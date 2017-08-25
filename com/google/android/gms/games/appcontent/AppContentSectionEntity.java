package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity implements SafeParcelable, AppContentSection {
    public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int zzCY;
    private final String zzEl;
    private final String zzKI;
    private final String zzadv;
    private final ArrayList<AppContentCardEntity> zzaoE;
    private final String zzaoF;
    private final String zzaom;
    private final ArrayList<AppContentAnnotationEntity> zzaov;
    private final String zzaox;

    AppContentSectionEntity(int versionCode, ArrayList<AppContentActionEntity> actions, ArrayList<AppContentCardEntity> cards, String contentDescription, Bundle extras, String subtitle, String title, String type, String id, String cardType, ArrayList<AppContentAnnotationEntity> annotations) {
        this.zzCY = versionCode;
        this.mActions = actions;
        this.zzaov = annotations;
        this.zzaoE = cards;
        this.zzaoF = cardType;
        this.zzaom = contentDescription;
        this.mExtras = extras;
        this.zzKI = id;
        this.zzaox = subtitle;
        this.zzadv = title;
        this.zzEl = type;
    }

    public AppContentSectionEntity(AppContentSection section) {
        int i;
        int i2 = 0;
        this.zzCY = 5;
        this.zzaoF = section.zzsk();
        this.zzaom = section.zzrP();
        this.mExtras = section.getExtras();
        this.zzKI = section.getId();
        this.zzaox = section.zzsb();
        this.zzadv = section.getTitle();
        this.zzEl = section.getType();
        List actions = section.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = section.zzsj();
        size = actions.size();
        this.zzaoE = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzaoE.add((AppContentCardEntity) ((AppContentCard) actions.get(i)).freeze());
        }
        List zzrZ = section.zzrZ();
        int size2 = zzrZ.size();
        this.zzaov = new ArrayList(size2);
        while (i2 < size2) {
            this.zzaov.add((AppContentAnnotationEntity) ((AppContentAnnotation) zzrZ.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentSection appContentSection) {
        return zzt.hashCode(appContentSection.getActions(), appContentSection.zzrZ(), appContentSection.zzsj(), appContentSection.zzsk(), appContentSection.zzrP(), appContentSection.getExtras(), appContentSection.getId(), appContentSection.zzsb(), appContentSection.getTitle(), appContentSection.getType());
    }

    static boolean zza(AppContentSection appContentSection, Object obj) {
        if (!(obj instanceof AppContentSection)) {
            return false;
        }
        if (appContentSection == obj) {
            return true;
        }
        AppContentSection appContentSection2 = (AppContentSection) obj;
        return zzt.equal(appContentSection2.getActions(), appContentSection.getActions()) && zzt.equal(appContentSection2.zzrZ(), appContentSection.zzrZ()) && zzt.equal(appContentSection2.zzsj(), appContentSection.zzsj()) && zzt.equal(appContentSection2.zzsk(), appContentSection.zzsk()) && zzt.equal(appContentSection2.zzrP(), appContentSection.zzrP()) && zzt.equal(appContentSection2.getExtras(), appContentSection.getExtras()) && zzt.equal(appContentSection2.getId(), appContentSection.getId()) && zzt.equal(appContentSection2.zzsb(), appContentSection.zzsb()) && zzt.equal(appContentSection2.getTitle(), appContentSection.getTitle()) && zzt.equal(appContentSection2.getType(), appContentSection.getType());
    }

    static String zzb(AppContentSection appContentSection) {
        return zzt.zzt(appContentSection).zzg("Actions", appContentSection.getActions()).zzg("Annotations", appContentSection.zzrZ()).zzg("Cards", appContentSection.zzsj()).zzg("CardType", appContentSection.zzsk()).zzg("ContentDescription", appContentSection.zzrP()).zzg("Extras", appContentSection.getExtras()).zzg("Id", appContentSection.getId()).zzg("Subtitle", appContentSection.zzsb()).zzg("Title", appContentSection.getTitle()).zzg("Type", appContentSection.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzsl();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzKI;
    }

    public String getTitle() {
        return this.zzadv;
    }

    public String getType() {
        return this.zzEl;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        AppContentSectionEntityCreator.zza(this, out, flags);
    }

    public String zzrP() {
        return this.zzaom;
    }

    public List<AppContentAnnotation> zzrZ() {
        return new ArrayList(this.zzaov);
    }

    public String zzsb() {
        return this.zzaox;
    }

    public List<AppContentCard> zzsj() {
        return new ArrayList(this.zzaoE);
    }

    public String zzsk() {
        return this.zzaoF;
    }

    public AppContentSection zzsl() {
        return this;
    }
}
