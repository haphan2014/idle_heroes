package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class zzju {
    private static final zzl zzQW = new zzl("GameManagerMessage");
    protected final String zzTL;
    protected final long zzTM;
    protected final JSONObject zzTN;
    protected final int zzTR;
    protected final int zzTS;
    protected final String zzTT;
    protected final int zzTU;
    protected final int zzTV;
    protected final List<zzjy> zzTW;
    protected final JSONObject zzTX;
    protected final String zzTY;
    protected final String zzTZ;
    protected final zzjt zzTs;

    public zzju(int i, int i2, String str, JSONObject jSONObject, int i3, int i4, List<zzjy> list, JSONObject jSONObject2, String str2, String str3, long j, String str4, zzjt com_google_android_gms_internal_zzjt) {
        this.zzTR = i;
        this.zzTS = i2;
        this.zzTT = str;
        this.zzTN = jSONObject;
        this.zzTU = i3;
        this.zzTV = i4;
        this.zzTW = list;
        this.zzTX = jSONObject2;
        this.zzTY = str2;
        this.zzTL = str3;
        this.zzTM = j;
        this.zzTZ = str4;
        this.zzTs = com_google_android_gms_internal_zzjt;
    }

    private static List<zzjy> zza(JSONArray jSONArray) {
        List<zzjy> arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                Object com_google_android_gms_internal_zzjy;
                try {
                    com_google_android_gms_internal_zzjy = new zzjy(optJSONObject);
                } catch (Throwable e) {
                    zzQW.zzc(e, "Exception when attempting to parse PlayerInfoMessageComponent at index %d", Integer.valueOf(i));
                    com_google_android_gms_internal_zzjy = null;
                }
                if (com_google_android_gms_internal_zzjy != null) {
                    arrayList.add(com_google_android_gms_internal_zzjy);
                }
            }
        }
        return arrayList;
    }

    protected static zzju zzh(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("type", -1);
        switch (optInt) {
            case 1:
                zzjt com_google_android_gms_internal_zzjt = null;
                JSONObject optJSONObject = jSONObject.optJSONObject("gameManagerConfig");
                if (optJSONObject != null) {
                    zzjt com_google_android_gms_internal_zzjt2 = new zzjt(optJSONObject);
                }
                return new zzju(optInt, jSONObject.optInt("statusCode"), jSONObject.optString("errorDescription"), jSONObject.optJSONObject("extraMessageData"), jSONObject.optInt("gameplayState"), jSONObject.optInt("lobbyState"), zza(jSONObject.optJSONArray(Games.EXTRA_PLAYER_IDS)), jSONObject.optJSONObject("gameData"), jSONObject.optString("gameStatusText"), jSONObject.optString("playerId"), jSONObject.optLong("requestId"), jSONObject.optString("playerToken"), com_google_android_gms_internal_zzjt);
            case 2:
                return new zzju(optInt, jSONObject.optInt("statusCode"), jSONObject.optString("errorDescription"), jSONObject.optJSONObject("extraMessageData"), jSONObject.optInt("gameplayState"), jSONObject.optInt("lobbyState"), zza(jSONObject.optJSONArray(Games.EXTRA_PLAYER_IDS)), jSONObject.optJSONObject("gameData"), jSONObject.optString("gameStatusText"), jSONObject.optString("playerId"), -1, null, null);
            default:
                try {
                    zzQW.zzf("Unrecognized Game Message type %d", Integer.valueOf(optInt));
                    break;
                } catch (Throwable e) {
                    zzQW.zzc(e, "Exception while parsing GameManagerMessage from json", new Object[0]);
                    break;
                }
        }
        return null;
    }

    public final JSONObject getExtraMessageData() {
        return this.zzTN;
    }

    public final JSONObject getGameData() {
        return this.zzTX;
    }

    public final int getGameplayState() {
        return this.zzTU;
    }

    public final int getLobbyState() {
        return this.zzTV;
    }

    public final String getPlayerId() {
        return this.zzTL;
    }

    public final long getRequestId() {
        return this.zzTM;
    }

    public final int getStatusCode() {
        return this.zzTS;
    }

    public final int zzlC() {
        return this.zzTR;
    }

    public final String zzlD() {
        return this.zzTT;
    }

    public final List<zzjy> zzlE() {
        return this.zzTW;
    }

    public final String zzlF() {
        return this.zzTY;
    }

    public final String zzlG() {
        return this.zzTZ;
    }

    public final zzjt zzlH() {
        return this.zzTs;
    }
}
