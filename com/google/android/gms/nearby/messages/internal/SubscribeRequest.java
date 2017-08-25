package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.internal.zza.zza;

public final class SubscribeRequest implements SafeParcelable {
    public static final Creator<SubscribeRequest> CREATOR = new zzj();
    final int zzCY;
    public final Strategy zzaGc;
    public final zzb zzaGd;
    public final String zzaGe;
    public final zza zzaGf;
    public final MessageFilter zzaGg;
    public final PendingIntent zzaGh;
    public final int zzaGi;
    public final String zzayp;

    SubscribeRequest(int versionCode, IBinder messageListener, Strategy strategy, IBinder callbackAsBinder, MessageFilter filter, PendingIntent pendingIntent, int messageListenerKey, String zeroPartyPackageName, String realClientPackageName) {
        this.zzCY = versionCode;
        this.zzaGf = zza.zzdd(messageListener);
        this.zzaGc = strategy;
        this.zzaGd = zzb.zza.zzde(callbackAsBinder);
        this.zzaGg = filter;
        this.zzaGh = pendingIntent;
        this.zzaGi = messageListenerKey;
        this.zzayp = zeroPartyPackageName;
        this.zzaGe = realClientPackageName;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj.zza(this, dest, flags);
    }

    IBinder zzxa() {
        return this.zzaGd == null ? null : this.zzaGd.asBinder();
    }

    IBinder zzxb() {
        return this.zzaGf == null ? null : this.zzaGf.asBinder();
    }
}
