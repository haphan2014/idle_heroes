package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity implements SafeParcelable, AppContentAction {
    public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
    private final Bundle mExtras;
    private final int zzCY;
    private final String zzEl;
    private final String zzKI;
    private final ArrayList<AppContentConditionEntity> zzaol;
    private final String zzaom;
    private final AppContentAnnotationEntity zzaon;
    private final String zzaoo;

    AppContentActionEntity(int versionCode, ArrayList<AppContentConditionEntity> conditions, String contentDescription, Bundle extras, String type, String id, AppContentAnnotationEntity annotation, String overflowText) {
        this.zzCY = versionCode;
        this.zzaon = annotation;
        this.zzaol = conditions;
        this.zzaom = contentDescription;
        this.mExtras = extras;
        this.zzKI = id;
        this.zzaoo = overflowText;
        this.zzEl = type;
    }

    public AppContentActionEntity(AppContentAction action) {
        this.zzCY = 5;
        this.zzaon = (AppContentAnnotationEntity) action.zzrN().freeze();
        this.zzaom = action.zzrP();
        this.mExtras = action.getExtras();
        this.zzKI = action.getId();
        this.zzaoo = action.zzrQ();
        this.zzEl = action.getType();
        List zzrO = action.zzrO();
        int size = zzrO.size();
        this.zzaol = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzaol.add((AppContentConditionEntity) ((AppContentCondition) zzrO.get(i)).freeze());
        }
    }

    static int zza(AppContentAction appContentAction) {
        return zzt.hashCode(appContentAction.zzrN(), appContentAction.zzrO(), appContentAction.zzrP(), appContentAction.getExtras(), appContentAction.getId(), appContentAction.zzrQ(), appContentAction.getType());
    }

    static boolean zza(AppContentAction appContentAction, Object obj) {
        if (!(obj instanceof AppContentAction)) {
            return false;
        }
        if (appContentAction == obj) {
            return true;
        }
        AppContentAction appContentAction2 = (AppContentAction) obj;
        return zzt.equal(appContentAction2.zzrN(), appContentAction.zzrN()) && zzt.equal(appContentAction2.zzrO(), appContentAction.zzrO()) && zzt.equal(appContentAction2.zzrP(), appContentAction.zzrP()) && zzt.equal(appContentAction2.getExtras(), appContentAction.getExtras()) && zzt.equal(appContentAction2.getId(), appContentAction.getId()) && zzt.equal(appContentAction2.zzrQ(), appContentAction.zzrQ()) && zzt.equal(appContentAction2.getType(), appContentAction.getType());
    }

    static String zzb(AppContentAction appContentAction) {
        return zzt.zzt(appContentAction).zzg("Annotation", appContentAction.zzrN()).zzg("Conditions", appContentAction.zzrO()).zzg("ContentDescription", appContentAction.zzrP()).zzg("Extras", appContentAction.getExtras()).zzg("Id", appContentAction.getId()).zzg("OverflowText", appContentAction.zzrQ()).zzg("Type", appContentAction.getType()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzrR();
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public String getId() {
        return this.zzKI;
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
        AppContentActionEntityCreator.zza(this, out, flags);
    }

    public AppContentAnnotation zzrN() {
        return this.zzaon;
    }

    public List<AppContentCondition> zzrO() {
        return new ArrayList(this.zzaol);
    }

    public String zzrP() {
        return this.zzaom;
    }

    public String zzrQ() {
        return this.zzaoo;
    }

    public AppContentAction zzrR() {
        return this;
    }
}
