package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import java.util.ArrayList;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation {
    public static final Creator<InvitationEntity> CREATOR = new InvitationEntityCreatorCompat();
    private final int zzCY;
    private final String zzapl;
    private final GameEntity zzaud;
    private final long zzaue;
    private final int zzauf;
    private final ParticipantEntity zzaug;
    private final ArrayList<ParticipantEntity> zzauh;
    private final int zzaui;
    private final int zzauj;

    static final class InvitationEntityCreatorCompat extends InvitationEntityCreator {
        InvitationEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdI(x0);
        }

        public InvitationEntity zzdI(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zznE()) || DowngradeableSafeParcel.zzca(InvitationEntity.class.getCanonicalName())) {
                return super.zzdI(parcel);
            }
            GameEntity gameEntity = (GameEntity) GameEntity.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            long readLong = parcel.readLong();
            int readInt = parcel.readInt();
            ParticipantEntity participantEntity = (ParticipantEntity) ParticipantEntity.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            for (int i = 0; i < readInt2; i++) {
                arrayList.add(ParticipantEntity.CREATOR.createFromParcel(parcel));
            }
            return new InvitationEntity(2, gameEntity, readString, readLong, readInt, participantEntity, arrayList, -1, 0);
        }
    }

    InvitationEntity(int versionCode, GameEntity game, String invitationId, long creationTimestamp, int invitationType, ParticipantEntity inviter, ArrayList<ParticipantEntity> participants, int variant, int availableAutoMatchSlots) {
        this.zzCY = versionCode;
        this.zzaud = game;
        this.zzapl = invitationId;
        this.zzaue = creationTimestamp;
        this.zzauf = invitationType;
        this.zzaug = inviter;
        this.zzauh = participants;
        this.zzaui = variant;
        this.zzauj = availableAutoMatchSlots;
    }

    InvitationEntity(Invitation invitation) {
        this.zzCY = 2;
        this.zzaud = new GameEntity(invitation.getGame());
        this.zzapl = invitation.getInvitationId();
        this.zzaue = invitation.getCreationTimestamp();
        this.zzauf = invitation.getInvitationType();
        this.zzaui = invitation.getVariant();
        this.zzauj = invitation.getAvailableAutoMatchSlots();
        String participantId = invitation.getInviter().getParticipantId();
        Object obj = null;
        ArrayList participants = invitation.getParticipants();
        int size = participants.size();
        this.zzauh = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(participantId)) {
                obj = participant;
            }
            this.zzauh.add((ParticipantEntity) participant.freeze());
        }
        zzu.zzb(obj, (Object) "Must have a valid inviter!");
        this.zzaug = (ParticipantEntity) obj.freeze();
    }

    static int zza(Invitation invitation) {
        return zzt.hashCode(invitation.getGame(), invitation.getInvitationId(), Long.valueOf(invitation.getCreationTimestamp()), Integer.valueOf(invitation.getInvitationType()), invitation.getInviter(), invitation.getParticipants(), Integer.valueOf(invitation.getVariant()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static boolean zza(Invitation invitation, Object obj) {
        if (!(obj instanceof Invitation)) {
            return false;
        }
        if (invitation == obj) {
            return true;
        }
        Invitation invitation2 = (Invitation) obj;
        return zzt.equal(invitation2.getGame(), invitation.getGame()) && zzt.equal(invitation2.getInvitationId(), invitation.getInvitationId()) && zzt.equal(Long.valueOf(invitation2.getCreationTimestamp()), Long.valueOf(invitation.getCreationTimestamp())) && zzt.equal(Integer.valueOf(invitation2.getInvitationType()), Integer.valueOf(invitation.getInvitationType())) && zzt.equal(invitation2.getInviter(), invitation.getInviter()) && zzt.equal(invitation2.getParticipants(), invitation.getParticipants()) && zzt.equal(Integer.valueOf(invitation2.getVariant()), Integer.valueOf(invitation.getVariant())) && zzt.equal(Integer.valueOf(invitation2.getAvailableAutoMatchSlots()), Integer.valueOf(invitation.getAvailableAutoMatchSlots()));
    }

    static String zzb(Invitation invitation) {
        return zzt.zzt(invitation).zzg("Game", invitation.getGame()).zzg("InvitationId", invitation.getInvitationId()).zzg("CreationTimestamp", Long.valueOf(invitation.getCreationTimestamp())).zzg("InvitationType", Integer.valueOf(invitation.getInvitationType())).zzg("Inviter", invitation.getInviter()).zzg("Participants", invitation.getParticipants()).zzg("Variant", Integer.valueOf(invitation.getVariant())).zzg("AvailableAutoMatchSlots", Integer.valueOf(invitation.getAvailableAutoMatchSlots())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Invitation freeze() {
        return this;
    }

    public int getAvailableAutoMatchSlots() {
        return this.zzauj;
    }

    public long getCreationTimestamp() {
        return this.zzaue;
    }

    public Game getGame() {
        return this.zzaud;
    }

    public String getInvitationId() {
        return this.zzapl;
    }

    public int getInvitationType() {
        return this.zzauf;
    }

    public Participant getInviter() {
        return this.zzaug;
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.zzauh);
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
            this.zzaud.writeToParcel(dest, flags);
            dest.writeString(this.zzapl);
            dest.writeLong(this.zzaue);
            dest.writeInt(this.zzauf);
            this.zzaug.writeToParcel(dest, flags);
            int size = this.zzauh.size();
            dest.writeInt(size);
            for (int i = 0; i < size; i++) {
                ((ParticipantEntity) this.zzauh.get(i)).writeToParcel(dest, flags);
            }
            return;
        }
        InvitationEntityCreator.zza(this, dest, flags);
    }
}
