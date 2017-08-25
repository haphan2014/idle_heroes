package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;

public final class PlayerLevelInfo implements SafeParcelable {
    public static final Creator<PlayerLevelInfo> CREATOR = new PlayerLevelInfoCreator();
    private final int zzCY;
    private final long zzanT;
    private final long zzanU;
    private final PlayerLevel zzanV;
    private final PlayerLevel zzanW;

    PlayerLevelInfo(int versionCode, long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        zzu.zzU(currentXpTotal != -1);
        zzu.zzu(currentLevel);
        zzu.zzu(nextLevel);
        this.zzCY = versionCode;
        this.zzanT = currentXpTotal;
        this.zzanU = lastLevelUpTimestamp;
        this.zzanV = currentLevel;
        this.zzanW = nextLevel;
    }

    public PlayerLevelInfo(long currentXpTotal, long lastLevelUpTimestamp, PlayerLevel currentLevel, PlayerLevel nextLevel) {
        this(1, currentXpTotal, lastLevelUpTimestamp, currentLevel, nextLevel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return zzt.equal(Long.valueOf(this.zzanT), Long.valueOf(playerLevelInfo.zzanT)) && zzt.equal(Long.valueOf(this.zzanU), Long.valueOf(playerLevelInfo.zzanU)) && zzt.equal(this.zzanV, playerLevelInfo.zzanV) && zzt.equal(this.zzanW, playerLevelInfo.zzanW);
    }

    public PlayerLevel getCurrentLevel() {
        return this.zzanV;
    }

    public long getCurrentXpTotal() {
        return this.zzanT;
    }

    public long getLastLevelUpTimestamp() {
        return this.zzanU;
    }

    public PlayerLevel getNextLevel() {
        return this.zzanW;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Long.valueOf(this.zzanT), Long.valueOf(this.zzanU), this.zzanV, this.zzanW);
    }

    public boolean isMaxLevel() {
        return this.zzanV.equals(this.zzanW);
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelInfoCreator.zza(this, out, flags);
    }
}
