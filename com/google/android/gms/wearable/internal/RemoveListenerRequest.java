package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzas.zza;

public class RemoveListenerRequest implements SafeParcelable {
    public static final Creator<RemoveListenerRequest> CREATOR = new zzbc();
    final int zzCY;
    public final zzas zzaTq;

    RemoveListenerRequest(int versionCode, IBinder listener) {
        this.zzCY = versionCode;
        if (listener != null) {
            this.zzaTq = zza.zzdP(listener);
        } else {
            this.zzaTq = null;
        }
    }

    public RemoveListenerRequest(zzas listener) {
        this.zzCY = 1;
        this.zzaTq = listener;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzbc.zza(this, dest, flags);
    }

    IBinder zzAT() {
        return this.zzaTq == null ? null : this.zzaTq.asBinder();
    }
}
