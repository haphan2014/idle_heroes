package com.google.android.gms.games.multiplayer.turnbased;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.zzlc;
import java.util.ArrayList;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch {
    public static final Creator<TurnBasedMatchEntity> CREATOR = new TurnBasedMatchEntityCreator();
    private final int mVersion;
    private final int zzCY;
    private final String zzakM;
    private final long zzaoj;
    private final String zzapF;
    private final String zzauA;
    private final String zzauI;
    private final String zzauJ;
    private final int zzauK;
    private final byte[] zzauL;
    private final String zzauM;
    private final byte[] zzauN;
    private final int zzauO;
    private final int zzauP;
    private final boolean zzauQ;
    private final String zzauR;
    private final GameEntity zzaud;
    private final long zzaue;
    private final ArrayList<ParticipantEntity> zzauh;
    private final int zzaui;
    private final Bundle zzauy;

    TurnBasedMatchEntity(int versionCode, GameEntity game, String matchId, String creatorId, long creationTimestamp, String lastUpdaterId, long lastUpdatedTimestamp, String pendingParticipantId, int matchStatus, int variant, int version, byte[] data, ArrayList<ParticipantEntity> participants, String rematchId, byte[] previousData, int matchNumber, Bundle autoMatchCriteria, int turnStatus, boolean isLocallyModified, String description, String descriptionParticipantId) {
        this.zzCY = versionCode;
        this.zzaud = game;
        this.zzapF = matchId;
        this.zzauA = creatorId;
        this.zzaue = creationTimestamp;
        this.zzauI = lastUpdaterId;
        this.zzaoj = lastUpdatedTimestamp;
        this.zzauJ = pendingParticipantId;
        this.zzauK = matchStatus;
        this.zzauP = turnStatus;
        this.zzaui = variant;
        this.mVersion = version;
        this.zzauL = data;
        this.zzauh = participants;
        this.zzauM = rematchId;
        this.zzauN = previousData;
        this.zzauO = matchNumber;
        this.zzauy = autoMatchCriteria;
        this.zzauQ = isLocallyModified;
        this.zzakM = description;
        this.zzauR = descriptionParticipantId;
    }

    public TurnBasedMatchEntity(TurnBasedMatch match) {
        this.zzCY = 2;
        this.zzaud = new GameEntity(match.getGame());
        this.zzapF = match.getMatchId();
        this.zzauA = match.getCreatorId();
        this.zzaue = match.getCreationTimestamp();
        this.zzauI = match.getLastUpdaterId();
        this.zzaoj = match.getLastUpdatedTimestamp();
        this.zzauJ = match.getPendingParticipantId();
        this.zzauK = match.getStatus();
        this.zzauP = match.getTurnStatus();
        this.zzaui = match.getVariant();
        this.mVersion = match.getVersion();
        this.zzauM = match.getRematchId();
        this.zzauO = match.getMatchNumber();
        this.zzauy = match.getAutoMatchCriteria();
        this.zzauQ = match.isLocallyModified();
        this.zzakM = match.getDescription();
        this.zzauR = match.getDescriptionParticipantId();
        Object data = match.getData();
        if (data == null) {
            this.zzauL = null;
        } else {
            this.zzauL = new byte[data.length];
            System.arraycopy(data, 0, this.zzauL, 0, data.length);
        }
        data = match.getPreviousMatchData();
        if (data == null) {
            this.zzauN = null;
        } else {
            this.zzauN = new byte[data.length];
            System.arraycopy(data, 0, this.zzauN, 0, data.length);
        }
        ArrayList participants = match.getParticipants();
        int size = participants.size();
        this.zzauh = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            this.zzauh.add((ParticipantEntity) ((Participant) participants.get(i)).freeze());
        }
    }

    static int zza(TurnBasedMatch turnBasedMatch) {
        return zzt.hashCode(turnBasedMatch.getGame(), turnBasedMatch.getMatchId(), turnBasedMatch.getCreatorId(), Long.valueOf(turnBasedMatch.getCreationTimestamp()), turnBasedMatch.getLastUpdaterId(), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp()), turnBasedMatch.getPendingParticipantId(), Integer.valueOf(turnBasedMatch.getStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus()), turnBasedMatch.getDescription(), Integer.valueOf(turnBasedMatch.getVariant()), Integer.valueOf(turnBasedMatch.getVersion()), turnBasedMatch.getParticipants(), turnBasedMatch.getRematchId(), Integer.valueOf(turnBasedMatch.getMatchNumber()), turnBasedMatch.getAutoMatchCriteria(), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static int zza(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant.getStatus();
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static boolean zza(TurnBasedMatch turnBasedMatch, Object obj) {
        if (!(obj instanceof TurnBasedMatch)) {
            return false;
        }
        if (turnBasedMatch == obj) {
            return true;
        }
        TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch) obj;
        return zzt.equal(turnBasedMatch2.getGame(), turnBasedMatch.getGame()) && zzt.equal(turnBasedMatch2.getMatchId(), turnBasedMatch.getMatchId()) && zzt.equal(turnBasedMatch2.getCreatorId(), turnBasedMatch.getCreatorId()) && zzt.equal(Long.valueOf(turnBasedMatch2.getCreationTimestamp()), Long.valueOf(turnBasedMatch.getCreationTimestamp())) && zzt.equal(turnBasedMatch2.getLastUpdaterId(), turnBasedMatch.getLastUpdaterId()) && zzt.equal(Long.valueOf(turnBasedMatch2.getLastUpdatedTimestamp()), Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())) && zzt.equal(turnBasedMatch2.getPendingParticipantId(), turnBasedMatch.getPendingParticipantId()) && zzt.equal(Integer.valueOf(turnBasedMatch2.getStatus()), Integer.valueOf(turnBasedMatch.getStatus())) && zzt.equal(Integer.valueOf(turnBasedMatch2.getTurnStatus()), Integer.valueOf(turnBasedMatch.getTurnStatus())) && zzt.equal(turnBasedMatch2.getDescription(), turnBasedMatch.getDescription()) && zzt.equal(Integer.valueOf(turnBasedMatch2.getVariant()), Integer.valueOf(turnBasedMatch.getVariant())) && zzt.equal(Integer.valueOf(turnBasedMatch2.getVersion()), Integer.valueOf(turnBasedMatch.getVersion())) && zzt.equal(turnBasedMatch2.getParticipants(), turnBasedMatch.getParticipants()) && zzt.equal(turnBasedMatch2.getRematchId(), turnBasedMatch.getRematchId()) && zzt.equal(Integer.valueOf(turnBasedMatch2.getMatchNumber()), Integer.valueOf(turnBasedMatch.getMatchNumber())) && zzt.equal(turnBasedMatch2.getAutoMatchCriteria(), turnBasedMatch.getAutoMatchCriteria()) && zzt.equal(Integer.valueOf(turnBasedMatch2.getAvailableAutoMatchSlots()), Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())) && zzt.equal(Boolean.valueOf(turnBasedMatch2.isLocallyModified()), Boolean.valueOf(turnBasedMatch.isLocallyModified()));
    }

    static String zzb(TurnBasedMatch turnBasedMatch) {
        return zzt.zzt(turnBasedMatch).zzg("Game", turnBasedMatch.getGame()).zzg("MatchId", turnBasedMatch.getMatchId()).zzg("CreatorId", turnBasedMatch.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(turnBasedMatch.getCreationTimestamp())).zzg("LastUpdaterId", turnBasedMatch.getLastUpdaterId()).zzg("LastUpdatedTimestamp", Long.valueOf(turnBasedMatch.getLastUpdatedTimestamp())).zzg("PendingParticipantId", turnBasedMatch.getPendingParticipantId()).zzg("MatchStatus", Integer.valueOf(turnBasedMatch.getStatus())).zzg("TurnStatus", Integer.valueOf(turnBasedMatch.getTurnStatus())).zzg("Description", turnBasedMatch.getDescription()).zzg("Variant", Integer.valueOf(turnBasedMatch.getVariant())).zzg("Data", turnBasedMatch.getData()).zzg("Version", Integer.valueOf(turnBasedMatch.getVersion())).zzg("Participants", turnBasedMatch.getParticipants()).zzg("RematchId", turnBasedMatch.getRematchId()).zzg("PreviousData", turnBasedMatch.getPreviousMatchData()).zzg("MatchNumber", Integer.valueOf(turnBasedMatch.getMatchNumber())).zzg("AutoMatchCriteria", turnBasedMatch.getAutoMatchCriteria()).zzg("AvailableAutoMatchSlots", Integer.valueOf(turnBasedMatch.getAvailableAutoMatchSlots())).zzg("LocallyModified", Boolean.valueOf(turnBasedMatch.isLocallyModified())).zzg("DescriptionParticipantId", turnBasedMatch.getDescriptionParticipantId()).toString();
    }

    static String zzb(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
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

    static Participant zzc(TurnBasedMatch turnBasedMatch, String str) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        for (int i = 0; i < size; i++) {
            Participant participant = (Participant) participants.get(i);
            if (participant.getParticipantId().equals(str)) {
                return participant;
            }
        }
        throw new IllegalStateException("Participant " + str + " is not in match " + turnBasedMatch.getMatchId());
    }

    static ArrayList<String> zzc(TurnBasedMatch turnBasedMatch) {
        ArrayList participants = turnBasedMatch.getParticipants();
        int size = participants.size();
        ArrayList<String> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(((Participant) participants.get(i)).getParticipantId());
        }
        return arrayList;
    }

    public boolean canRematch() {
        return this.zzauK == 2 && this.zzauM == null;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza((TurnBasedMatch) this, obj);
    }

    public TurnBasedMatch freeze() {
        return this;
    }

    public Bundle getAutoMatchCriteria() {
        return this.zzauy;
    }

    public int getAvailableAutoMatchSlots() {
        return this.zzauy == null ? 0 : this.zzauy.getInt(Multiplayer.EXTRA_MAX_AUTOMATCH_PLAYERS);
    }

    public long getCreationTimestamp() {
        return this.zzaue;
    }

    public String getCreatorId() {
        return this.zzauA;
    }

    public byte[] getData() {
        return this.zzauL;
    }

    public String getDescription() {
        return this.zzakM;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzlc.zzb(this.zzakM, dataOut);
    }

    public Participant getDescriptionParticipant() {
        String descriptionParticipantId = getDescriptionParticipantId();
        return descriptionParticipantId == null ? null : getParticipant(descriptionParticipantId);
    }

    public String getDescriptionParticipantId() {
        return this.zzauR;
    }

    public Game getGame() {
        return this.zzaud;
    }

    public long getLastUpdatedTimestamp() {
        return this.zzaoj;
    }

    public String getLastUpdaterId() {
        return this.zzauI;
    }

    public String getMatchId() {
        return this.zzapF;
    }

    public int getMatchNumber() {
        return this.zzauO;
    }

    public Participant getParticipant(String participantId) {
        return zzc(this, participantId);
    }

    public String getParticipantId(String playerId) {
        return zzb(this, playerId);
    }

    public ArrayList<String> getParticipantIds() {
        return zzc(this);
    }

    public int getParticipantStatus(String participantId) {
        return zza((TurnBasedMatch) this, participantId);
    }

    public ArrayList<Participant> getParticipants() {
        return new ArrayList(this.zzauh);
    }

    public String getPendingParticipantId() {
        return this.zzauJ;
    }

    public byte[] getPreviousMatchData() {
        return this.zzauN;
    }

    public String getRematchId() {
        return this.zzauM;
    }

    public int getStatus() {
        return this.zzauK;
    }

    public int getTurnStatus() {
        return this.zzauP;
    }

    public int getVariant() {
        return this.zzaui;
    }

    public int getVersion() {
        return this.mVersion;
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

    public boolean isLocallyModified() {
        return this.zzauQ;
    }

    public String toString() {
        return zzb(this);
    }

    public void writeToParcel(Parcel out, int flags) {
        TurnBasedMatchEntityCreator.zza(this, out, flags);
    }
}
