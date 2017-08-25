package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.zzas.zza;

public class AddListenerRequest implements SafeParcelable {
    public static final Creator<AddListenerRequest> CREATOR = new zzb();
    final int zzCY;
    public final zzas zzaTq;
    public final IntentFilter[] zzaTr;
    public final String zzaTs;
    public final String zzaTt;

    AddListenerRequest(int versionCode, IBinder listener, IntentFilter[] filters, String channelToken, String capability) {
        this.zzCY = versionCode;
        if (listener != null) {
            this.zzaTq = zza.zzdP(listener);
        } else {
            this.zzaTq = null;
        }
        this.zzaTr = filters;
        this.zzaTs = channelToken;
        this.zzaTt = capability;
    }

    public AddListenerRequest(zzbl stub) {
        this.zzCY = 1;
        this.zzaTq = stub;
        this.zzaTr = stub.zzBh();
        this.zzaTs = stub.zzBi();
        this.zzaTt = stub.zzBj();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    IBinder zzAT() {
        return this.zzaTq == null ? null : this.zzaTq.asBinder();
    }
}
