package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GetInstrumentsRequest implements SafeParcelable {
    public static final Creator<GetInstrumentsRequest> CREATOR = new zzd();
    private final int zzCY;
    int[] zzaRL;

    GetInstrumentsRequest() {
        this(1, null);
    }

    GetInstrumentsRequest(int versionCode, int[] familyFilter) {
        this.zzCY = versionCode;
        this.zzaRL = familyFilter;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
