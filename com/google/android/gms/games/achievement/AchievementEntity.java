package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzt.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzlc;

public final class AchievementEntity implements SafeParcelable, Achievement {
    public static final Creator<AchievementEntity> CREATOR = new AchievementEntityCreator();
    private final String mName;
    private final int mState;
    private final int zzCY;
    private final int zzSq;
    private final String zzakM;
    private final String zzanZ;
    private final Uri zzaoa;
    private final String zzaob;
    private final Uri zzaoc;
    private final String zzaod;
    private final int zzaoe;
    private final String zzaof;
    private final PlayerEntity zzaog;
    private final int zzaoh;
    private final String zzaoi;
    private final long zzaoj;
    private final long zzaok;

    AchievementEntity(int versionCode, String achievementId, int type, String name, String description, Uri unlockedImageUri, String unlockedImageUrl, Uri revealedImageUri, String revealedImageUrl, int totalSteps, String formattedTotalSteps, PlayerEntity player, int state, int currentSteps, String formattedCurrentSteps, long lastUpdatedTimestamp, long xpValue) {
        this.zzCY = versionCode;
        this.zzanZ = achievementId;
        this.zzSq = type;
        this.mName = name;
        this.zzakM = description;
        this.zzaoa = unlockedImageUri;
        this.zzaob = unlockedImageUrl;
        this.zzaoc = revealedImageUri;
        this.zzaod = revealedImageUrl;
        this.zzaoe = totalSteps;
        this.zzaof = formattedTotalSteps;
        this.zzaog = player;
        this.mState = state;
        this.zzaoh = currentSteps;
        this.zzaoi = formattedCurrentSteps;
        this.zzaoj = lastUpdatedTimestamp;
        this.zzaok = xpValue;
    }

    public AchievementEntity(Achievement achievement) {
        this.zzCY = 1;
        this.zzanZ = achievement.getAchievementId();
        this.zzSq = achievement.getType();
        this.mName = achievement.getName();
        this.zzakM = achievement.getDescription();
        this.zzaoa = achievement.getUnlockedImageUri();
        this.zzaob = achievement.getUnlockedImageUrl();
        this.zzaoc = achievement.getRevealedImageUri();
        this.zzaod = achievement.getRevealedImageUrl();
        this.zzaog = (PlayerEntity) achievement.getPlayer().freeze();
        this.mState = achievement.getState();
        this.zzaoj = achievement.getLastUpdatedTimestamp();
        this.zzaok = achievement.getXpValue();
        if (achievement.getType() == 1) {
            this.zzaoe = achievement.getTotalSteps();
            this.zzaof = achievement.getFormattedTotalSteps();
            this.zzaoh = achievement.getCurrentSteps();
            this.zzaoi = achievement.getFormattedCurrentSteps();
        } else {
            this.zzaoe = 0;
            this.zzaof = null;
            this.zzaoh = 0;
            this.zzaoi = null;
        }
        zzb.zzq(this.zzanZ);
        zzb.zzq(this.zzakM);
    }

    static int zza(Achievement achievement) {
        int currentSteps;
        int totalSteps;
        if (achievement.getType() == 1) {
            currentSteps = achievement.getCurrentSteps();
            totalSteps = achievement.getTotalSteps();
        } else {
            totalSteps = 0;
            currentSteps = 0;
        }
        return zzt.hashCode(achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(currentSteps), Integer.valueOf(totalSteps));
    }

    static boolean zza(Achievement achievement, Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        boolean equal;
        boolean equal2;
        Achievement achievement2 = (Achievement) obj;
        if (achievement.getType() == 1) {
            equal = zzt.equal(Integer.valueOf(achievement2.getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            equal2 = zzt.equal(Integer.valueOf(achievement2.getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else {
            equal2 = true;
            equal = true;
        }
        return zzt.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && zzt.equal(achievement2.getName(), achievement.getName()) && zzt.equal(Integer.valueOf(achievement2.getType()), Integer.valueOf(achievement.getType())) && zzt.equal(achievement2.getDescription(), achievement.getDescription()) && zzt.equal(Long.valueOf(achievement2.getXpValue()), Long.valueOf(achievement.getXpValue())) && zzt.equal(Integer.valueOf(achievement2.getState()), Integer.valueOf(achievement.getState())) && zzt.equal(Long.valueOf(achievement2.getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) && zzt.equal(achievement2.getPlayer(), achievement.getPlayer()) && equal && equal2;
    }

    static String zzb(Achievement achievement) {
        zza zzg = zzt.zzt(achievement).zzg("Id", achievement.getAchievementId()).zzg("Type", Integer.valueOf(achievement.getType())).zzg("Name", achievement.getName()).zzg("Description", achievement.getDescription()).zzg("Player", achievement.getPlayer()).zzg("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1) {
            zzg.zzg("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            zzg.zzg("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return zzg.toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Achievement freeze() {
        return this;
    }

    public String getAchievementId() {
        return this.zzanZ;
    }

    public int getCurrentSteps() {
        return this.zzaoh;
    }

    public String getDescription() {
        return this.zzakM;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzlc.zzb(this.zzakM, dataOut);
    }

    public String getFormattedCurrentSteps() {
        return this.zzaoi;
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        zzlc.zzb(this.zzaoi, dataOut);
    }

    public String getFormattedTotalSteps() {
        return this.zzaof;
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        zzlc.zzb(this.zzaof, dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return this.zzaoj;
    }

    public String getName() {
        return this.mName;
    }

    public void getName(CharArrayBuffer dataOut) {
        zzlc.zzb(this.mName, dataOut);
    }

    public Player getPlayer() {
        return this.zzaog;
    }

    public Uri getRevealedImageUri() {
        return this.zzaoc;
    }

    public String getRevealedImageUrl() {
        return this.zzaod;
    }

    public int getState() {
        return this.mState;
    }

    public int getTotalSteps() {
        return this.zzaoe;
    }

    public int getType() {
        return this.zzSq;
    }

    public Uri getUnlockedImageUri() {
        return this.zzaoa;
    }

    public String getUnlockedImageUrl() {
        return this.zzaob;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public long getXpValue() {
        return this.zzaok;
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
        AchievementEntityCreator.zza(this, dest, flags);
    }
}
