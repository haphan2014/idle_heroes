package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzf;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzjy {
    private final int zzSd;
    private final String zzTL;
    private final JSONObject zzUb;

    public zzjy(String str, int i, JSONObject jSONObject) {
        this.zzTL = str;
        this.zzSd = i;
        this.zzUb = jSONObject;
    }

    public zzjy(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("playerId"), jSONObject.optInt("playerState"), jSONObject.optJSONObject("playerData"));
    }

    public boolean equals(Object otherObj) {
        if (otherObj == null || !(otherObj instanceof zzjy)) {
            return false;
        }
        zzjy com_google_android_gms_internal_zzjy = (zzjy) otherObj;
        return this.zzSd == com_google_android_gms_internal_zzjy.getPlayerState() && zzf.zza(this.zzTL, com_google_android_gms_internal_zzjy.getPlayerId()) && zzlh.zzd(this.zzUb, com_google_android_gms_internal_zzjy.getPlayerData());
    }

    public JSONObject getPlayerData() {
        return this.zzUb;
    }

    public String getPlayerId() {
        return this.zzTL;
    }

    public int getPlayerState() {
        return this.zzSd;
    }
}
