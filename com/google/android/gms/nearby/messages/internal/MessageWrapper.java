package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.nearby.messages.Message;

public class MessageWrapper implements SafeParcelable {
    public static final zze CREATOR = new zze();
    final int versionCode;
    public final Message zzaFZ;

    MessageWrapper(int versionCode, Message message) {
        this.versionCode = versionCode;
        this.zzaFZ = (Message) zzu.zzu(message);
    }

    public int describeContents() {
        zze com_google_android_gms_nearby_messages_internal_zze = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze com_google_android_gms_nearby_messages_internal_zze = CREATOR;
        zze.zza(this, out, flags);
    }
}
