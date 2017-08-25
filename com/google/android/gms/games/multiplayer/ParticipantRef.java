package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

public final class ParticipantRef extends zzc implements Participant {
    private final PlayerRef zzaun;

    public ParticipantRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        this.zzaun = new PlayerRef(holder, dataRow);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return ParticipantEntity.zza(this, obj);
    }

    public Participant freeze() {
        return new ParticipantEntity(this);
    }

    public int getCapabilities() {
        return getInteger("capabilities");
    }

    public String getDisplayName() {
        return zzbX("external_player_id") ? getString("default_display_name") : this.zzaun.getDisplayName();
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        if (zzbX("external_player_id")) {
            zza("default_display_name", dataOut);
        } else {
            this.zzaun.getDisplayName(dataOut);
        }
    }

    public Uri getHiResImageUri() {
        return zzbX("external_player_id") ? zzbW("default_display_hi_res_image_uri") : this.zzaun.getHiResImageUri();
    }

    public String getHiResImageUrl() {
        return zzbX("external_player_id") ? getString("default_display_hi_res_image_url") : this.zzaun.getHiResImageUrl();
    }

    public Uri getIconImageUri() {
        return zzbX("external_player_id") ? zzbW("default_display_image_uri") : this.zzaun.getIconImageUri();
    }

    public String getIconImageUrl() {
        return zzbX("external_player_id") ? getString("default_display_image_url") : this.zzaun.getIconImageUrl();
    }

    public String getParticipantId() {
        return getString("external_participant_id");
    }

    public Player getPlayer() {
        return zzbX("external_player_id") ? null : this.zzaun;
    }

    public ParticipantResult getResult() {
        if (zzbX("result_type")) {
            return null;
        }
        return new ParticipantResult(getParticipantId(), getInteger("result_type"), getInteger("placing"));
    }

    public int getStatus() {
        return getInteger("player_status");
    }

    public int hashCode() {
        return ParticipantEntity.zza(this);
    }

    public boolean isConnectedToRoom() {
        return getInteger("connected") > 0;
    }

    public String toString() {
        return ParticipantEntity.zzb(this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((ParticipantEntity) freeze()).writeToParcel(dest, flags);
    }

    public String zzsr() {
        return getString("client_address");
    }
}
