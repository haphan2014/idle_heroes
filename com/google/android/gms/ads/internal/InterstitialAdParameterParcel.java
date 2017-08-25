package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgd;

@zzgd
public final class InterstitialAdParameterParcel implements SafeParcelable {
    public static final zzk CREATOR = new zzk();
    public final int versionCode;
    public final boolean zzoU;
    public final boolean zzoV;

    InterstitialAdParameterParcel(int versionCode, boolean transparentBackground, boolean hideStatusBar) {
        this.versionCode = versionCode;
        this.zzoU = transparentBackground;
        this.zzoV = hideStatusBar;
    }

    public InterstitialAdParameterParcel(boolean transparentBackground, boolean hideStatusBar) {
        this.versionCode = 1;
        this.zzoU = transparentBackground;
        this.zzoV = hideStatusBar;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzk.zza(this, out, flags);
    }
}
