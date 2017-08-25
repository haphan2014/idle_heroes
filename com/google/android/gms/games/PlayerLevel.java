package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;

public final class PlayerLevel implements SafeParcelable {
    public static final Creator<PlayerLevel> CREATOR = new PlayerLevelCreator();
    private final int zzCY;
    private final int zzanQ;
    private final long zzanR;
    private final long zzanS;

    PlayerLevel(int versionCode, int levelNumber, long minXp, long maxXp) {
        boolean z = true;
        zzu.zza(minXp >= 0, (Object) "Min XP must be positive!");
        if (maxXp <= minXp) {
            z = false;
        }
        zzu.zza(z, (Object) "Max XP must be more than min XP!");
        this.zzCY = versionCode;
        this.zzanQ = levelNumber;
        this.zzanR = minXp;
        this.zzanS = maxXp;
    }

    public PlayerLevel(int value, long minXp, long maxXp) {
        this(1, value, minXp, maxXp);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevel)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        PlayerLevel playerLevel = (PlayerLevel) obj;
        return zzt.equal(Integer.valueOf(playerLevel.getLevelNumber()), Integer.valueOf(getLevelNumber())) && zzt.equal(Long.valueOf(playerLevel.getMinXp()), Long.valueOf(getMinXp())) && zzt.equal(Long.valueOf(playerLevel.getMaxXp()), Long.valueOf(getMaxXp()));
    }

    public int getLevelNumber() {
        return this.zzanQ;
    }

    public long getMaxXp() {
        return this.zzanS;
    }

    public long getMinXp() {
        return this.zzanR;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public int hashCode() {
        return zzt.hashCode(Integer.valueOf(this.zzanQ), Long.valueOf(this.zzanR), Long.valueOf(this.zzanS));
    }

    public String toString() {
        return zzt.zzt(this).zzg("LevelNumber", Integer.valueOf(getLevelNumber())).zzg("MinXp", Long.valueOf(getMinXp())).zzg("MaxXp", Long.valueOf(getMaxXp())).toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        PlayerLevelCreator.zza(this, out, flags);
    }
}
