package com.google.android.gms.wallet.firstparty;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GetInstrumentsResponse implements SafeParcelable {
    public static final Creator<GetInstrumentsResponse> CREATOR = new zze();
    private final int zzCY;
    String[] zzaRM;
    byte[][] zzaRN;

    GetInstrumentsResponse() {
        this(1, new String[0], new byte[0][]);
    }

    GetInstrumentsResponse(int versionCode, String[] instrumentIds, byte[][] paymentInstruments) {
        this.zzCY = versionCode;
        this.zzaRM = instrumentIds;
        this.zzaRN = paymentInstruments;
    }

    public int describeContents() {
        return 0;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }
}
