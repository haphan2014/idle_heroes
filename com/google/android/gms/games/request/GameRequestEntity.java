package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity implements SafeParcelable, GameRequest {
    public static final Creator<GameRequestEntity> CREATOR = new GameRequestEntityCreator();
    private final int zzCY;
    private final String zzDK;
    private final int zzSq;
    private final byte[] zzauL;
    private final GameEntity zzaud;
    private final long zzaue;
    private final PlayerEntity zzavf;
    private final ArrayList<PlayerEntity> zzavg;
    private final long zzavh;
    private final Bundle zzavi;
    private final int zzwS;

    GameRequestEntity(int versionCode, GameEntity game, PlayerEntity sender, byte[] data, String requestId, ArrayList<PlayerEntity> recipients, int type, long creationTimestamp, long expirationTimestamp, Bundle recipientStatuses, int status) {
        this.zzCY = versionCode;
        this.zzaud = game;
        this.zzavf = sender;
        this.zzauL = data;
        this.zzDK = requestId;
        this.zzavg = recipients;
        this.zzSq = type;
        this.zzaue = creationTimestamp;
        this.zzavh = expirationTimestamp;
        this.zzavi = recipientStatuses;
        this.zzwS = status;
    }

    public GameRequestEntity(GameRequest request) {
        this.zzCY = 2;
        this.zzaud = new GameEntity(request.getGame());
        this.zzavf = new PlayerEntity(request.getSender());
        this.zzDK = request.getRequestId();
        this.zzSq = request.getType();
        this.zzaue = request.getCreationTimestamp();
        this.zzavh = request.getExpirationTimestamp();
        this.zzwS = request.getStatus();
        Object data = request.getData();
        if (data == null) {
            this.zzauL = null;
        } else {
            this.zzauL = new byte[data.length];
            System.arraycopy(data, 0, this.zzauL, 0, data.length);
        }
        List recipients = request.getRecipients();
        int size = recipients.size();
        this.zzavg = new ArrayList(size);
        this.zzavi = new Bundle();
        for (int i = 0; i < size; i++) {
            Player player = (Player) ((Player) recipients.get(i)).freeze();
            String playerId = player.getPlayerId();
            this.zzavg.add((PlayerEntity) player);
            this.zzavi.putInt(playerId, request.getRecipientStatus(playerId));
        }
    }

    static int zza(GameRequest gameRequest) {
        return zzt.hashCode(gameRequest.getGame(), gameRequest.getRecipients(), gameRequest.getRequestId(), gameRequest.getSender(), zzb(gameRequest), Integer.valueOf(gameRequest.getType()), Long.valueOf(gameRequest.getCreationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    static boolean zza(GameRequest gameRequest, Object obj) {
        if (!(obj instanceof GameRequest)) {
            return false;
        }
        if (gameRequest == obj) {
            return true;
        }
        GameRequest gameRequest2 = (GameRequest) obj;
        return zzt.equal(gameRequest2.getGame(), gameRequest.getGame()) && zzt.equal(gameRequest2.getRecipients(), gameRequest.getRecipients()) && zzt.equal(gameRequest2.getRequestId(), gameRequest.getRequestId()) && zzt.equal(gameRequest2.getSender(), gameRequest.getSender()) && Arrays.equals(zzb(gameRequest2), zzb(gameRequest)) && zzt.equal(Integer.valueOf(gameRequest2.getType()), Integer.valueOf(gameRequest.getType())) && zzt.equal(Long.valueOf(gameRequest2.getCreationTimestamp()), Long.valueOf(gameRequest.getCreationTimestamp())) && zzt.equal(Long.valueOf(gameRequest2.getExpirationTimestamp()), Long.valueOf(gameRequest.getExpirationTimestamp()));
    }

    private static int[] zzb(GameRequest gameRequest) {
        List recipients = gameRequest.getRecipients();
        int size = recipients.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = gameRequest.getRecipientStatus(((Player) recipients.get(i)).getPlayerId());
        }
        return iArr;
    }

    static String zzc(GameRequest gameRequest) {
        return zzt.zzt(gameRequest).zzg("Game", gameRequest.getGame()).zzg("Sender", gameRequest.getSender()).zzg("Recipients", gameRequest.getRecipients()).zzg("Data", gameRequest.getData()).zzg("RequestId", gameRequest.getRequestId()).zzg("Type", Integer.valueOf(gameRequest.getType())).zzg("CreationTimestamp", Long.valueOf(gameRequest.getCreationTimestamp())).zzg("ExpirationTimestamp", Long.valueOf(gameRequest.getExpirationTimestamp())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public GameRequest freeze() {
        return this;
    }

    public long getCreationTimestamp() {
        return this.zzaue;
    }

    public byte[] getData() {
        return this.zzauL;
    }

    public long getExpirationTimestamp() {
        return this.zzavh;
    }

    public Game getGame() {
        return this.zzaud;
    }

    public int getRecipientStatus(String playerId) {
        return this.zzavi.getInt(playerId, 0);
    }

    public List<Player> getRecipients() {
        return new ArrayList(this.zzavg);
    }

    public String getRequestId() {
        return this.zzDK;
    }

    public Player getSender() {
        return this.zzavf;
    }

    public int getStatus() {
        return this.zzwS;
    }

    public int getType() {
        return this.zzSq;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zza(this);
    }

    public boolean isConsumed(String playerId) {
        return getRecipientStatus(playerId) == 1;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        return zzc(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        GameRequestEntityCreator.zza(this, dest, flags);
    }

    public Bundle zztP() {
        return this.zzavi;
    }
}
