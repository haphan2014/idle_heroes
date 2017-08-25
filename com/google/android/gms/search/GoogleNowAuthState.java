package com.google.android.gms.search;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GoogleNowAuthState implements SafeParcelable {
    public static final Creator<GoogleNowAuthState> CREATOR = new zza();
    final int zzCY;
    String zzaJE;
    String zzaJF;
    long zzaJG;

    GoogleNowAuthState(int versionCode, String authCode, String accessToken, long nextAllowedTimeMillis) {
        this.zzCY = versionCode;
        this.zzaJE = authCode;
        this.zzaJF = accessToken;
        this.zzaJG = nextAllowedTimeMillis;
    }

    public int describeContents() {
        return 0;
    }

    public String getAccessToken() {
        return this.zzaJF;
    }

    public String getAuthCode() {
        return this.zzaJE;
    }

    public long getNextAllowedTimeMillis() {
        return this.zzaJG;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
