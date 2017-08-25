package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.internal.zza.zza;

public final class ReceiveContentRequest implements SafeParcelable {
    public static final Creator<ReceiveContentRequest> CREATOR = new zzg();
    public String packageName;
    final int versionCode;
    public IBinder zzaGp;
    public zzc zzaGt;
    public zza zzaGu;

    ReceiveContentRequest() {
        this.versionCode = 1;
    }

    ReceiveContentRequest(int versionCode, IBinder clientBinder, IBinder contentReceiverAsBinder, String packageName, IBinder callbackAsBinder) {
        this.versionCode = versionCode;
        this.zzaGp = clientBinder;
        this.zzaGu = zza.zzdh(contentReceiverAsBinder);
        this.packageName = packageName;
        this.zzaGt = zzc.zza.zzdj(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    IBinder zzxa() {
        return this.zzaGt.asBinder();
    }

    IBinder zzxj() {
        return this.zzaGu == null ? null : this.zzaGu.asBinder();
    }
}
