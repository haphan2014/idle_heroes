package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.zzc;
import com.google.android.gms.location.zzd;
import com.google.android.gms.location.zzd.zza;

public class LocationRequestUpdateData implements SafeParcelable {
    public static final zzl CREATOR = new zzl();
    PendingIntent mPendingIntent;
    private final int zzCY;
    int zzazf;
    LocationRequestInternal zzazg;
    zzd zzazh;
    zzc zzazi;

    LocationRequestUpdateData(int versionCode, int operation, LocationRequestInternal locationRequest, IBinder locationListenerBinder, PendingIntent pendingIntent, IBinder locationCallbackBinder) {
        zzc com_google_android_gms_location_zzc = null;
        this.zzCY = versionCode;
        this.zzazf = operation;
        this.zzazg = locationRequest;
        this.zzazh = locationListenerBinder == null ? null : zza.zzbT(locationListenerBinder);
        this.mPendingIntent = pendingIntent;
        if (locationCallbackBinder != null) {
            com_google_android_gms_location_zzc = zzc.zza.zzbS(locationCallbackBinder);
        }
        this.zzazi = com_google_android_gms_location_zzc;
    }

    public static LocationRequestUpdateData zza(LocationRequestInternal locationRequestInternal, zzc com_google_android_gms_location_zzc) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, null, com_google_android_gms_location_zzc.asBinder());
    }

    public static LocationRequestUpdateData zza(zzc com_google_android_gms_location_zzc) {
        return new LocationRequestUpdateData(1, 2, null, null, null, com_google_android_gms_location_zzc.asBinder());
    }

    public static LocationRequestUpdateData zzb(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, null, pendingIntent, null);
    }

    public static LocationRequestUpdateData zzb(LocationRequestInternal locationRequestInternal, zzd com_google_android_gms_location_zzd) {
        return new LocationRequestUpdateData(1, 1, locationRequestInternal, com_google_android_gms_location_zzd.asBinder(), null, null);
    }

    public static LocationRequestUpdateData zzb(zzd com_google_android_gms_location_zzd) {
        return new LocationRequestUpdateData(1, 2, null, com_google_android_gms_location_zzd.asBinder(), null, null);
    }

    public static LocationRequestUpdateData zze(PendingIntent pendingIntent) {
        return new LocationRequestUpdateData(1, 2, null, null, pendingIntent, null);
    }

    public int describeContents() {
        return 0;
    }

    int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzl.zza(this, parcel, flags);
    }

    IBinder zzuy() {
        return this.zzazh == null ? null : this.zzazh.asBinder();
    }

    IBinder zzuz() {
        return this.zzazi == null ? null : this.zzazi.asBinder();
    }
}
