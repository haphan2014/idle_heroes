package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.zzlc;
import java.util.ArrayList;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room {
    public static final Creator<RoomEntity> CREATOR = new RoomEntityCreatorCompat();
    private final int zzCY;
    private final String zzakM;
    private final String zzapn;
    private final String zzauA;
    private final int zzauB;
    private final int zzauC;
    private final long zzaue;
    private final ArrayList<ParticipantEntity> zzauh;
    private final int zzaui;
    private final Bundle zzauy;

    static final class RoomEntityCreatorCompat extends RoomEntityCreator {
        RoomEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdM(x0);
        }

        public RoomEntity zzdM(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zznE()) || DowngradeableSafeParcel.zzca(RoomEntity.class.getCanonicalName())) {
                return super.zzdM(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            int readInt2 = parcel.readInt();
            Bundle readBundle = parcel.readBundle();
            int readInt3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt3);
            for (int i = 0; i < readInt3; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new RoomEntity(2, readString, readString2, readLong, readInt, readString3, readInt2, readBundle, arrayList, -1);
        }
    }

    RoomEntity(int versionCode, String roomId, String creatorId, long creationTimestamp, int roomStatus, String description, int variant, Bundle autoMatchCriteria, ArrayList<ParticipantEntity> participants, int autoMatchWaitEstimateSeconds) {
        this.zzCY = versionCode;
        this.zzapn = roomId;
        this.zzauA = creatorId;
        this.zzaue = creationTimestamp;
        this.zzauB = roomStatus;
        this.zzakM = description;
        this.zzaui = variant;
        this.zzauy = autoMatchCriteria;
        this.zzauh = participants;
        this.zzauC = autoMatchWaitEstimateSeconds;
    }

    public RoomEntity(Room room) {
        this.zzCY = 2;
        this.zzapn = room.getRoomId();
        this.zzauA = room.getCreatorId();
        this.zzaue = room.getCreationTimestamp();
        this.zzauB = room.getStatus();
        this.zzakM = room.getDescription();
        this.zzaui = room.getVariant();
        this.zzauy = room.getAutoMatchCriteria();
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        this.zzauh = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzauh.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
        this.zzauC = room.getAutoMatchWaitEstimateSeconds();
    }

    static int zza(Room room) {
        return zzt.hashCode(room.getRoomId(), room.getCreatorId(), Long.valueOf(room.getCreationTimestamp()), Integer.valueOf(room.getStatus()), room.getDescription(), Integer.valueOf(room.getVariant()), room.getAutoMatchCriteria(), room.getParticipants(), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static int zza(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in room " + room.getRoomId());
    }

    static boolean zza(Room room, Object obj) {
        if (!(obj instanceof Room)) {
            return false;
        }
        if (room == obj) {
            return true;
        }
        Room room2 = (Room) obj;
        return zzt.equal(room2.getRoomId(), room.getRoomId()) && zzt.equal(room2.getCreatorId(), room.getCreatorId()) && zzt.equal(Long.valueOf(room2.getCreationTimestamp()), Long.valueOf(room.getCreationTimestamp())) && zzt.equal(Integer.valueOf(room2.getStatus()), Integer.valueOf(room.getStatus())) && zzt.equal(room2.getDescription(), room.getDescription()) && zzt.equal(Integer.valueOf(room2.getVariant()), Integer.valueOf(room.getVariant())) && zzt.equal(room2.getAutoMatchCriteria(), room.getAutoMatchCriteria()) && zzt.equal(room2.getParticipants(), room.getParticipants()) && zzt.equal(Integer.valueOf(room2.getAutoMatchWaitEstimateSeconds()), Integer.valueOf(room.getAutoMatchWaitEstimateSeconds()));
    }

    static String zzb(Room room) {
        return zzt.zzt(room).zzg("RoomId", room.getRoomId()).zzg("CreatorId", room.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(room.getCreationTimestamp())).zzg("RoomStatus", Integer.valueOf(room.getStatus())).zzg("Description", room.getDescription()).zzg("Variant", Integer.valueOf(room.getVariant())).zzg("AutoMatchCriteria", room.getAutoMatchCriteria()).zzg("Participants", room.getParticipants()).zzg("AutoMatchWaitEstimateSeconds", Integer.valueOf(room.getAutoMatchWaitEstimateSeconds())).toString();
    }

    static String zzb(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(str)) {
                return participant.getParticipantId();
            }
        }
        return null;
    }

    static Participant zzc(Room room, String str) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + room.getRoomId());
    }

    static ArrayList<String> zzc(Room room) {
        ArrayList participants = room.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza((Room) this, obj);
    }

    public Room freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzauy;
    }

    public int getAutoMatchWaitEstimateSeconds() {
        return this.zzauC;
    }

    public long getCreationTimestamp() {
        return this.zzaue;
    }

    public String getCreatorId() {
        return this.zzauA;
    }

    public String getDescription() {
        return this.zzakM;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzlc.zzb(this.zzakM, dataOut);
    }

    public Participant getParticipant(String participantId) {
        return zzc(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return zzb(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return zzc((Room) this);
    }

    public int getParticipantStatus(String participantId) {
        return zza((Room) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.zzauh);
    }

    public String getRoomId() {
        return this.zzapn;
    }

    public int getStatus() {
        return this.zzauB;
    }

    public int getVariant() {
        return this.zzaui;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        if (zznF()) {
            dest.writeString(this.zzapn);
            dest.writeString(this.zzauA);
            dest.writeLong(this.zzaue);
            dest.writeInt(this.zzauB);
            dest.writeString(this.zzakM);
            dest.writeInt(this.zzaui);
            dest.writeBundle(this.zzauy);
            int size = this.zzauh.size();
            dest.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((ParticipantEntity) this.zzauh.get(i)).writeToParcel(dest, flags);
            }
            return;
        }
        RoomEntityCreator.zza(this, dest, flags);
    }
}
