package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public final class AppContentConditionEntity implements SafeParcelable, AppContentCondition {
    public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
    private final int zzCY;
    private final String zzaoA;
    private final String zzaoB;
    private final Bundle zzaoC;
    private final String zzaoz;

    AppContentConditionEntity(int versionCode, String defaultValue, String expectedValue, String predicate, Bundle predicateParameters) {
        this.zzCY = versionCode;
        this.zzaoz = defaultValue;
        this.zzaoA = expectedValue;
        this.zzaoB = predicate;
        this.zzaoC = predicateParameters;
    }

    public AppContentConditionEntity(AppContentCondition condition) {
        this.zzCY = 1;
        this.zzaoz = condition.zzse();
        this.zzaoA = condition.zzsf();
        this.zzaoB = condition.zzsg();
        this.zzaoC = condition.zzsh();
    }

    static int zza(AppContentCondition appContentCondition) {
        return zzt.hashCode(appContentCondition.zzse(), appContentCondition.zzsf(), appContentCondition.zzsg(), appContentCondition.zzsh());
    }

    static boolean zza(AppContentCondition appContentCondition, Object obj) {
        if (!(obj instanceof AppContentCondition)) {
            return false;
        }
        if (appContentCondition == obj) {
            return true;
        }
        AppContentCondition appContentCondition2 = (AppContentCondition) obj;
        return zzt.equal(appContentCondition2.zzse(), appContentCondition.zzse()) && zzt.equal(appContentCondition2.zzsf(), appContentCondition.zzsf()) && zzt.equal(appContentCondition2.zzsg(), appContentCondition.zzsg()) && zzt.equal(appContentCondition2.zzsh(), appContentCondition.zzsh());
    }

    static String zzb(AppContentCondition appContentCondition) {
        return zzt.zzt(appContentCondition).zzg("DefaultValue", appContentCondition.zzse()).zzg("ExpectedValue", appContentCondition.zzsf()).zzg("Predicate", appContentCondition.zzsg()).zzg("PredicateParameters", appContentCondition.zzsh()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzsi();
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
        AppContentConditionEntityCreator.zza(this, out, flags);
    }

    public String zzse() {
        return this.zzaoz;
    }

    public String zzsf() {
        return this.zzaoA;
    }

    public String zzsg() {
        return this.zzaoB;
    }

    public Bundle zzsh() {
        return this.zzaoC;
    }

    public AppContentCondition zzsi() {
        return this;
    }
}
