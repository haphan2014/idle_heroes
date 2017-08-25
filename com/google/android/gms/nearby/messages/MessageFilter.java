package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageFilter implements SafeParcelable {
    public static final Creator<MessageFilter> CREATOR = new zzb();
    public static final MessageFilter zzaFO = new zza().zzwX().zzwY();
    final int versionCode;
    private final List<MessageType> zzaFP;

    public static final class zza {
        private final List<MessageType> zzaFP = new ArrayList();

        private zza zzC(String str, String str2) {
            this.zzaFP.add(new MessageType(str, str2));
            return this;
        }

        public zza zzwX() {
            return zzC("", "");
        }

        public MessageFilter zzwY() {
            zzu.zza(!this.zzaFP.isEmpty(), (Object) "At least one of the include methods must be called.");
            return new MessageFilter(this.zzaFP);
        }
    }

    MessageFilter(int versionCode, List<MessageType> messageTypes) {
        this.versionCode = versionCode;
        this.zzaFP = Collections.unmodifiableList((List) zzu.zzu(messageTypes));
    }

    private MessageFilter(List<MessageType> messageTypes) {
        this(1, (List) messageTypes);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageFilter)) {
            return false;
        }
        return zzt.equal(this.zzaFP, ((MessageFilter) o).zzaFP);
    }

    public int hashCode() {
        return zzt.hashCode(this.zzaFP);
    }

    public String toString() {
        return "MessageFilter" + this.zzaFP;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    List<MessageType> zzwW() {
        return this.zzaFP;
    }
}
