package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int zzatQ;
    private final int zzatR;
    private final boolean zzatS;
    private final long zzatT;
    private final String zzatU;
    private final long zzatV;
    private final String zzatW;
    private final String zzatX;
    private final long zzatY;
    private final String zzatZ;
    private final String zzaua;
    private final String zzaub;

    public LeaderboardVariantEntity(LeaderboardVariant variant) {
        this.zzatQ = variant.getTimeSpan();
        this.zzatR = variant.getCollection();
        this.zzatS = variant.hasPlayerInfo();
        this.zzatT = variant.getRawPlayerScore();
        this.zzatU = variant.getDisplayPlayerScore();
        this.zzatV = variant.getPlayerRank();
        this.zzatW = variant.getDisplayPlayerRank();
        this.zzatX = variant.getPlayerScoreTag();
        this.zzatY = variant.getNumScores();
        this.zzatZ = variant.zztH();
        this.zzaua = variant.zztI();
        this.zzaub = variant.zztJ();
    }

    static int zza(LeaderboardVariant leaderboardVariant) {
        return zzt.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.zztH(), leaderboardVariant.zztJ(), leaderboardVariant.zztI());
    }

    static boolean zza(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return zzt.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && zzt.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && zzt.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && zzt.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && zzt.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && zzt.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && zzt.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && zzt.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && zzt.equal(leaderboardVariant2.zztH(), leaderboardVariant.zztH()) && zzt.equal(leaderboardVariant2.zztJ(), leaderboardVariant.zztJ()) && zzt.equal(leaderboardVariant2.zztI(), leaderboardVariant.zztI());
    }

    static String zzb(LeaderboardVariant leaderboardVariant) {
        return zzt.zzt(leaderboardVariant).zzg("TimeSpan", TimeSpan.zzfG(leaderboardVariant.getTimeSpan())).zzg("Collection", LeaderboardCollection.zzfG(leaderboardVariant.getCollection())).zzg("RawPlayerScore", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : "none").zzg("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : "none").zzg("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : "none").zzg("DisplayPlayerRank", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerRank() : "none").zzg("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).zzg("TopPageNextToken", leaderboardVariant.zztH()).zzg("WindowPageNextToken", leaderboardVariant.zztJ()).zzg("WindowPagePrevToken", leaderboardVariant.zztI()).toString();
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zztK();
    }

    public int getCollection() {
        return this.zzatR;
    }

    public String getDisplayPlayerRank() {
        return this.zzatW;
    }

    public String getDisplayPlayerScore() {
        return this.zzatU;
    }

    public long getNumScores() {
        return this.zzatY;
    }

    public long getPlayerRank() {
        return this.zzatV;
    }

    public String getPlayerScoreTag() {
        return this.zzatX;
    }

    public long getRawPlayerScore() {
        return this.zzatT;
    }

    public int getTimeSpan() {
        return this.zzatQ;
    }

    public boolean hasPlayerInfo() {
        return this.zzatS;
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

    public String zztH() {
        return this.zzatZ;
    }

    public String zztI() {
        return this.zzaua;
    }

    public String zztJ() {
        return this.zzaub;
    }

    public LeaderboardVariant zztK() {
        return this;
    }
}
