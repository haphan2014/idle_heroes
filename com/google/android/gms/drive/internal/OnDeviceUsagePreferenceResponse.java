package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnDeviceUsagePreferenceResponse implements SafeParcelable {
    public static final Creator<OnDeviceUsagePreferenceResponse> CREATOR = new zzav();
    final int zzCY;
    final FileUploadPreferencesImpl zzagf;

    OnDeviceUsagePreferenceResponse(int versionCode, FileUploadPreferencesImpl preferences) {
        this.zzCY = versionCode;
        this.zzagf = preferences;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzav.zza(this, dest, flags);
    }

    public FileUploadPreferencesImpl zzpL() {
        return this.zzagf;
    }
}
