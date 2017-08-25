package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity implements SafeParcelable, AppContentCard {
    public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
    private final ArrayList<AppContentActionEntity> mActions;
    private final Bundle mExtras;
    private final int zzCY;
    private final String zzEl;
    private final String zzKI;
    private final String zzadv;
    private final String zzakM;
    private final ArrayList<AppContentConditionEntity> zzaol;
    private final String zzaom;
    private final ArrayList<AppContentAnnotationEntity> zzaov;
    private final int zzaow;
    private final String zzaox;
    private final int zzaoy;

    AppContentCardEntity(int versionCode, ArrayList<AppContentActionEntity> actions, ArrayList<AppContentAnnotationEntity> annotations, ArrayList<AppContentConditionEntity> conditions, String contentDescription, int currentProgress, String description, Bundle extras, String subtitle, String title, int totalProgress, String type, String id) {
        this.zzCY = versionCode;
        this.mActions = actions;
        this.zzaov = annotations;
        this.zzaol = conditions;
        this.zzaom = contentDescription;
        this.zzaow = currentProgress;
        this.zzakM = description;
        this.mExtras = extras;
        this.zzKI = id;
        this.zzaox = subtitle;
        this.zzadv = title;
        this.zzaoy = totalProgress;
        this.zzEl = type;
    }

    public AppContentCardEntity(AppContentCard card) {
        int i;
        int i2 = 0;
        this.zzCY = 4;
        this.zzaom = card.zzrP();
        this.zzaow = card.zzsa();
        this.zzakM = card.getDescription();
        this.mExtras = card.getExtras();
        this.zzKI = card.getId();
        this.zzadv = card.getTitle();
        this.zzaox = card.zzsb();
        this.zzaoy = card.zzsc();
        this.zzEl = card.getType();
        List actions = card.getActions();
        int size = actions.size();
        this.mActions = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.mActions.add((AppContentActionEntity) ((AppContentAction) actions.get(i)).freeze());
        }
        actions = card.zzrZ();
        size = actions.size();
        this.zzaov = new ArrayList(size);
        for (i = 0; i < size; i++) {
            this.zzaov.add((AppContentAnnotationEntity) ((AppContentAnnotation) actions.get(i)).freeze());
        }
        List zzrO = card.zzrO();
        int size2 = zzrO.size();
        this.zzaol = new ArrayList(size2);
        while (i2 < size2) {
            this.zzaol.add((AppContentConditionEntity) ((AppContentCondition) zzrO.get(i2)).freeze());
            i2++;
        }
    }

    static int zza(AppContentCard appContentCard) {
        return zzt.hashCode(appContentCard.getActions(), appContentCard.zzrZ(), appContentCard.zzrO(), appContentCard.zzrP(), Integer.valueOf(appContentCard.zzsa()), appContentCard.getDescription(), appContentCard.getExtras(), appContentCard.getId(), appContentCard.zzsb(), appContentCard.getTitle(), Integer.valueOf(appContentCard.zzsc()), appContentCard.getType());
    }

    static boolean zza(AppContentCard appContentCard, Object obj) {
        if (!(obj instanceof AppContentCard)) {
            return false;
        }
        if (appContentCard == obj) {
            return true;
        }
        AppContentCard appContentCard2 = (AppContentCard) obj;
        return zzt.equal(appContentCard2.getActions(), appContentCard.getActions()) && zzt.equal(appContentCard2.zzrZ(), appContentCard.zzrZ()) && zzt.equal(appContentCard2.zzrO(), appContentCard.zzrO()) && zzt.equal(appContentCard2.zzrP(), appContentCard.zzrP()) && zzt.equal(Integer.valueOf(appContentCard2.zzsa()), Integer.valueOf(appContentCard.zzsa())) && zzt.equal(appContentCard2.getDescription(), appContentCard.getDescription()) && zzt.equal(appContentCard2.getExtras(), appContentCard.getExtras()) && zzt.equal(appContentCard2.getId(), appContentCard.getId()) && zzt.equal(appContentCard2.zzsb(), appContentCard.zzsb()) && zzt.equal(appContentCard2.getTitle(), appContentCard.getTitle()) && zzt.equal(Integer.valueOf(appContentCard2.zzsc()), Integer.valueOf(appContentCard.zzsc())) && zzt.equal(appContentCard2.getType(), appContentCard.getType());
    }

    static String zzb(AppContentCard appContentCard) {
        return zzt.zzt(appContentCard).zzg("Actions", appContentCard.getActions()).zzg("Annotations", appContentCard.zzrZ()).zzg("Conditions", appContentCard.zzrO()).zzg("ContentDescription", appContentCard.zzrP()).zzg("CurrentSteps", Integer.valueOf(appContentCard.zzsa())).zzg("Description", appContentCard.getDescription()).zzg("Extras", appContentCard.getExtras()).zzg("Id", appContentCard.getId()).zzg("Subtitle", appContentCard.zzsb()).zzg("Title", appContentCard.getTitle()).zzg("TotalSteps", Integer.valueOf(appContentCard.zzsc())).zzg("Type", appContentCard.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzsd();
    }

    public List<AppContentAction> getActions() {
        return new ArrayList(this.mActions);
    }

    public String getDescription() {
        return this.zzakM;
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
        AppContentCardEntityCreator.zza(this, out, flags);
    }

    public List<AppContentCondition> zzrO() {
        return new ArrayList(this.zzaol);
    }

    public String zzrP() {
        return this.zzaom;
    }

    public List<AppContentAnnotation> zzrZ() {
        return new ArrayList(this.zzaov);
    }

    public int zzsa() {
        return this.zzaow;
    }

    public String zzsb() {
        return this.zzaox;
    }

    public int zzsc() {
        return this.zzaoy;
    }

    public AppContentCard zzsd() {
        return this;
    }
}
