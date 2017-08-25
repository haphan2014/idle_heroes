package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;

public final class AppContentTupleEntity implements SafeParcelable, AppContentTuple {
    public static final AppContentTupleEntityCreator CREATOR = new AppContentTupleEntityCreator();
    private final String mName;
    private final String mValue;
    private final int zzCY;

    AppContentTupleEntity(int versionCode, String name, String value) {
        this.zzCY = versionCode;
        this.mName = name;
        this.mValue = value;
    }

    public AppContentTupleEntity(AppContentTuple tuple) {
        this.zzCY = 1;
        this.mName = tuple.getName();
        this.mValue = tuple.getValue();
    }

    static int zza(AppContentTuple appContentTuple) {
        return zzt.hashCode(appContentTuple.getName(), appContentTuple.getValue());
    }

    static boolean zza(AppContentTuple appContentTuple, Object obj) {
        if (!(obj instanceof AppContentTuple)) {
            return false;
        }
        if (appContentTuple == obj) {
            return true;
        }
        AppContentTuple appContentTuple2 = (AppContentTuple) obj;
        return zzt.equal(appContentTuple2.getName(), appContentTuple.getName()) && zzt.equal(appContentTuple2.getValue(), appContentTuple.getValue());
    }

    static String zzb(AppContentTuple appContentTuple) {
        return zzt.zzt(appContentTuple).zzg("Name", appContentTuple.getName()).zzg("Value", appContentTuple.getValue()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzsp();
    }

    public String getName() {
        return this.mName;
    }

    public String getValue() {
        return this.mValue;
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
        AppContentTupleEntityCreator.zza(this, out, flags);
    }

    public AppContentTuple zzsp() {
        return this;
    }
}
