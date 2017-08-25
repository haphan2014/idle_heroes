package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzu;

public final class RealTimeMessage implements Parcelable {
    public static final Creator<RealTimeMessage> CREATOR = new C08131();
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;
    private final String zzauq;
    private final byte[] zzaur;
    private final int zzaus;

    static class C08131 implements Creator<RealTimeMessage> {
        C08131() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdL(x0);
        }

        public /* synthetic */ Object[] newArray(int x0) {
            return zzfU(x0);
        }

        public RealTimeMessage zzdL(Parcel parcel) {
            return new RealTimeMessage(parcel);
        }

        public RealTimeMessage[] zzfU(int i) {
            return new RealTimeMessage[i];
        }
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    public RealTimeMessage(String senderParticipantId, byte[] messageData, int isReliable) {
        this.zzauq = (String) zzu.zzu(senderParticipantId);
        this.zzaur = (byte[]) ((byte[]) zzu.zzu(messageData)).clone();
        this.zzaus = isReliable;
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getMessageData() {
        return this.zzaur;
    }

    public String getSenderParticipantId() {
        return this.zzauq;
    }

    public boolean isReliable() {
        return this.zzaus == 1;
    }

    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(this.zzauq);
        parcel.writeByteArray(this.zzaur);
        parcel.writeInt(this.zzaus);
    }
}
