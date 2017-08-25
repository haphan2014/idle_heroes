package com.google.android.gms.internal;

import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class zzjw implements GameManagerState {
    private final String zzTO;
    private final int zzTP;
    private final int zzTU;
    private final int zzTV;
    private final JSONObject zzTX;
    private final String zzTY;
    private final Map<String, PlayerInfo> zzUa;

    public zzjw(int i, int i2, String str, JSONObject jSONObject, Collection<PlayerInfo> collection, String str2, int i3) {
        this.zzTV = i;
        this.zzTU = i2;
        this.zzTY = str;
        this.zzTX = jSONObject;
        this.zzTO = str2;
        this.zzTP = i3;
        this.zzUa = new HashMap(collection.size());
        for (PlayerInfo playerInfo : collection) {
            this.zzUa.put(playerInfo.getPlayerId(), playerInfo);
        }
    }

    public boolean equals(Object otherObj) {
        boolean z = true;
        if (otherObj == null || !(otherObj instanceof GameManagerState)) {
            return false;
        }
        GameManagerState gameManagerState = (GameManagerState) otherObj;
        if (getPlayers().size() != gameManagerState.getPlayers().size()) {
            return false;
        }
        for (PlayerInfo playerInfo : getPlayers()) {
            boolean z2 = false;
            for (PlayerInfo playerInfo2 : gameManagerState.getPlayers()) {
                boolean z3;
                if (!zzf.zza(playerInfo.getPlayerId(), playerInfo2.getPlayerId())) {
                    z3 = z2;
                } else if (!zzf.zza(playerInfo, playerInfo2)) {
                    return false;
                } else {
                    z3 = true;
                }
                z2 = z3;
            }
            if (!z2) {
                return false;
            }
        }
        if (!(this.zzTV == gameManagerState.getLobbyState() && this.zzTU == gameManagerState.getGameplayState() && this.zzTP == gameManagerState.getMaxPlayers() && zzf.zza(this.zzTO, gameManagerState.getApplicationName()) && zzf.zza(this.zzTY, gameManagerState.getGameStatusText()) && zzlh.zzd(this.zzTX, gameManagerState.getGameData()))) {
            z = false;
        }
        return z;
    }

    public CharSequence getApplicationName() {
        return this.zzTO;
    }

    public List<PlayerInfo> getConnectedControllablePlayers() {
        List arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected() && playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public List<PlayerInfo> getConnectedPlayers() {
        List arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isConnected()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public List<PlayerInfo> getControllablePlayers() {
        List arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.isControllable()) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public JSONObject getGameData() {
        return this.zzTX;
    }

    public CharSequence getGameStatusText() {
        return this.zzTY;
    }

    public int getGameplayState() {
        return this.zzTU;
    }

    public Collection<String> getListOfChangedPlayers(GameManagerState other) {
        Collection hashSet = new HashSet();
        for (PlayerInfo playerInfo : getPlayers()) {
            PlayerInfo player = other.getPlayer(playerInfo.getPlayerId());
            if (player == null || !playerInfo.equals(player)) {
                hashSet.add(playerInfo.getPlayerId());
            }
        }
        for (PlayerInfo playerInfo2 : other.getPlayers()) {
            if (getPlayer(playerInfo2.getPlayerId()) == null) {
                hashSet.add(playerInfo2.getPlayerId());
            }
        }
        return hashSet;
    }

    public int getLobbyState() {
        return this.zzTV;
    }

    public int getMaxPlayers() {
        return this.zzTP;
    }

    public PlayerInfo getPlayer(String playerId) {
        return playerId == null ? null : (PlayerInfo) this.zzUa.get(playerId);
    }

    public Collection<PlayerInfo> getPlayers() {
        return Collections.unmodifiableCollection(this.zzUa.values());
    }

    public List<PlayerInfo> getPlayersInState(int playerState) {
        List arrayList = new ArrayList();
        for (PlayerInfo playerInfo : getPlayers()) {
            if (playerInfo.getPlayerState() == playerState) {
                arrayList.add(playerInfo);
            }
        }
        return arrayList;
    }

    public boolean hasGameDataChanged(GameManagerState other) {
        return !zzlh.zzd(this.zzTX, other.getGameData());
    }

    public boolean hasGameStatusTextChanged(GameManagerState other) {
        return !zzf.zza(this.zzTY, other.getGameStatusText());
    }

    public boolean hasGameplayStateChanged(GameManagerState other) {
        return this.zzTU != other.getGameplayState();
    }

    public boolean hasLobbyStateChanged(GameManagerState other) {
        return this.zzTV != other.getLobbyState();
    }

    public boolean hasPlayerChanged(String playerId, GameManagerState other) {
        return !zzf.zza(getPlayer(playerId), other.getPlayer(playerId));
    }

    public boolean hasPlayerDataChanged(String playerId, GameManagerState other) {
        PlayerInfo player = getPlayer(playerId);
        PlayerInfo player2 = other.getPlayer(playerId);
        return (player == null && player2 == null) ? false : player == null || player2 == null || !zzlh.zzd(player.getPlayerData(), player2.getPlayerData());
    }

    public boolean hasPlayerStateChanged(String playerId, GameManagerState other) {
        PlayerInfo player = getPlayer(playerId);
        PlayerInfo player2 = other.getPlayer(playerId);
        return (player == null && player2 == null) ? false : player == null || player2 == null || player.getPlayerState() != player2.getPlayerState();
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzTV), Integer.valueOf(this.zzTU), this.zzUa, this.zzTY, this.zzTX, this.zzTO, Integer.valueOf(this.zzTP));
    }
}
