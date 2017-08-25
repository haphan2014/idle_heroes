package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzt.zza;
import com.google.android.gms.common.internal.zzu;

public class PlaceReport implements SafeParcelable {
    public static final Creator<PlaceReport> CREATOR = new zzk();
    private final String mTag;
    final int zzCY;
    private final String zzazK;
    private final String zzazL;

    PlaceReport(int versionCode, String placeId, String tag, String source) {
        this.zzCY = versionCode;
        this.zzazK = placeId;
        this.mTag = tag;
        this.zzazL = source;
    }

    public static PlaceReport create(String placeId, String tag) {
        return zzi(placeId, tag, "unknown");
    }

    private static boolean zzdo(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1436706272:
                if (str.equals("inferredGeofencing")) {
                    z = true;
                    break;
                }
                break;
            case -1194968642:
                if (str.equals("userReported")) {
                    z = true;
                    break;
                }
                break;
            case -284840886:
                if (str.equals("unknown")) {
                    z = false;
                    break;
                }
                break;
            case -262743844:
                if (str.equals("inferredReverseGeocoding")) {
                    z = true;
                    break;
                }
                break;
            case 1287171955:
                if (str.equals("inferredRadioSignals")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport zzi(String str, String str2, String str3) {
        zzu.zzcj(str);
        zzu.zzcj(str2);
        zzu.zzcj(str3);
        zzu.zzb(zzdo(str3), (Object) "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        if (!(that instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) that;
        return zzt.equal(this.zzazK, placeReport.zzazK) && zzt.equal(this.mTag, placeReport.mTag) && zzt.equal(this.zzazL, placeReport.zzazL);
    }

    public String getPlaceId() {
        return this.zzazK;
    }

    public String getSource() {
        return this.zzazL;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzt.hashCode(this.zzazK, this.mTag, this.zzazL);
    }

    public String toString() {
        zza zzt = zzt.zzt(this);
        zzt.zzg("placeId", this.zzazK);
        zzt.zzg("tag", this.mTag);
        if (!"unknown".equals(this.zzazL)) {
            zzt.zzg("source", this.zzazL);
        }
        return zzt.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzk.zza(this, out, flags);
    }
}
