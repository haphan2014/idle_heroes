package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoRef;
import com.google.android.gms.games.internal.player.PlayerColumnNames;

public final class PlayerRef extends zzc implements Player {
    private final PlayerLevelInfo zzanN;
    private final PlayerColumnNames zzanX;
    private final MostRecentGameInfoRef zzanY;

    public PlayerRef(DataHolder holder, int dataRow) {
        this(holder, dataRow, null);
    }

    public PlayerRef(DataHolder holder, int dataRow, String prefix) {
        super(holder, dataRow);
        this.zzanX = new PlayerColumnNames(prefix);
        this.zzanY = new MostRecentGameInfoRef(holder, dataRow, this.zzanX);
        if (zzrM()) {
            PlayerLevel playerLevel;
            int integer = getInteger(this.zzanX.zzatf);
            int integer2 = getInteger(this.zzanX.zzati);
            PlayerLevel playerLevel2 = new PlayerLevel(integer, getLong(this.zzanX.zzatg), getLong(this.zzanX.zzath));
            if (integer != integer2) {
                playerLevel = new PlayerLevel(integer2, getLong(this.zzanX.zzath), getLong(this.zzanX.zzatj));
            } else {
                playerLevel = playerLevel2;
            }
            this.zzanN = new PlayerLevelInfo(getLong(this.zzanX.zzate), getLong(this.zzanX.zzatk), playerLevel2, playerLevel);
            return;
        }
        this.zzanN = null;
    }

    private boolean zzrM() {
        return (zzbX(this.zzanX.zzate) || getLong(this.zzanX.zzate) == -1) ? false : true;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return PlayerEntity.zza(this, obj);
    }

    public Player freeze() {
        return new PlayerEntity(this);
    }

    public String getDisplayName() {
        return getString(this.zzanX.zzasW);
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zza(this.zzanX.zzasW, dataOut);
    }

    public Uri getHiResImageUri() {
        return zzbW(this.zzanX.zzasZ);
    }

    public String getHiResImageUrl() {
        return getString(this.zzanX.zzata);
    }

    public Uri getIconImageUri() {
        return zzbW(this.zzanX.zzasX);
    }

    public String getIconImageUrl() {
        return getString(this.zzanX.zzasY);
    }

    public long getLastPlayedWithTimestamp() {
        return (!zzbV(this.zzanX.zzatd) || zzbX(this.zzanX.zzatd)) ? -1 : getLong(this.zzanX.zzatd);
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzanN;
    }

    public String getPlayerId() {
        return getString(this.zzanX.zzasV);
    }

    public long getRetrievedTimestamp() {
        return getLong(this.zzanX.zzatb);
    }

    public String getTitle() {
        return getString(this.zzanX.zzatl);
    }

    public void getTitle(CharArrayBuffer dataOut) {
        zza(this.zzanX.zzatl, dataOut);
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return PlayerEntity.zzb(this);
    }

    public boolean isProfileVisible() {
        return getBoolean(this.zzanX.zzatn);
    }

    public String toString() {
        return PlayerEntity.zzc((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        ((PlayerEntity) freeze()).writeToParcel(dest, flags);
    }

    public boolean zzrJ() {
        return getBoolean(this.zzanX.zzatu);
    }

    public int zzrK() {
        return getInteger(this.zzanX.zzatc);
    }

    public MostRecentGameInfo zzrL() {
        return zzbX(this.zzanX.zzato) ? null : this.zzanY;
    }
}
