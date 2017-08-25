package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@Deprecated
public class CountrySpecification implements SafeParcelable {
    public static final Creator<CountrySpecification> CREATOR = new zzc();
    private final int zzCY;
    String zzEr;

    CountrySpecification(int versionCode, String countryCode) {
        this.zzCY = versionCode;
        this.zzEr = countryCode;
    }

    public CountrySpecification(String countryCode) {
        this.zzCY = 1;
        this.zzEr = countryCode;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.zzEr;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }
}
