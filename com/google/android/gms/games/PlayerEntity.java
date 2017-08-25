package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfo;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;
import com.google.android.gms.internal.zzlc;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Creator<PlayerEntity> CREATOR = new PlayerEntityCreatorCompat();
    private final int zzCY;
    private final String zzTL;
    private final String zzadI;
    private final String zzadv;
    private final long zzanJ;
    private final int zzanK;
    private final long zzanL;
    private final MostRecentGameInfoEntity zzanM;
    private final PlayerLevelInfo zzanN;
    private final boolean zzanO;
    private final boolean zzanP;
    private final Uri zzanf;
    private final Uri zzang;
    private final String zzanq;
    private final String zzanr;

    static final class PlayerEntityCreatorCompat extends PlayerEntityCreator {
        PlayerEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzds(x0);
        }

        public PlayerEntity zzds(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zznE()) || DowngradeableSafeParcel.zzca(PlayerEntity.class.getCanonicalName())) {
                return super.zzds(parcel);
            }
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            return new PlayerEntity(12, readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1, null, null, null, null, null, true, false);
        }
    }

    PlayerEntity(int versionCode, String playerId, String displayName, Uri iconImageUri, Uri hiResImageUri, long retrievedTimestamp, int isInCircles, long lastPlayedWithTimestamp, String iconImageUrl, String hiResImageUrl, String title, MostRecentGameInfoEntity mostRecentGameInfo, PlayerLevelInfo playerLevelInfo, boolean isProfileVisible, boolean hasDebugAccess) {
        this.zzCY = versionCode;
        this.zzTL = playerId;
        this.zzadI = displayName;
        this.zzanf = iconImageUri;
        this.zzanq = iconImageUrl;
        this.zzang = hiResImageUri;
        this.zzanr = hiResImageUrl;
        this.zzanJ = retrievedTimestamp;
        this.zzanK = isInCircles;
        this.zzanL = lastPlayedWithTimestamp;
        this.zzadv = title;
        this.zzanO = isProfileVisible;
        this.zzanM = mostRecentGameInfo;
        this.zzanN = playerLevelInfo;
        this.zzanP = hasDebugAccess;
    }

    public PlayerEntity(Player player) {
        this(player, true);
    }

    public PlayerEntity(Player player, boolean isPlusEnabled) {
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        this.zzCY = 12;
        this.zzTL = isPlusEnabled ? player.getPlayerId() : null;
        this.zzadI = player.getDisplayName();
        this.zzanf = player.getIconImageUri();
        this.zzanq = player.getIconImageUrl();
        this.zzang = player.getHiResImageUri();
        this.zzanr = player.getHiResImageUrl();
        this.zzanJ = player.getRetrievedTimestamp();
        this.zzanK = player.zzrK();
        this.zzanL = player.getLastPlayedWithTimestamp();
        this.zzadv = player.getTitle();
        this.zzanO = player.isProfileVisible();
        MostRecentGameInfo zzrL = player.zzrL();
        if (zzrL != null) {
            mostRecentGameInfoEntity = new MostRecentGameInfoEntity(zzrL);
        }
        this.zzanM = mostRecentGameInfoEntity;
        this.zzanN = player.getLevelInfo();
        this.zzanP = player.zzrJ();
        if (isPlusEnabled) {
            zzb.zzq(this.zzTL);
        }
        zzb.zzq(this.zzadI);
        zzb.zzU(this.zzanJ > 0);
    }

    static boolean zza(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return zzt.equal(player2.getPlayerId(), player.getPlayerId()) && zzt.equal(player2.getDisplayName(), player.getDisplayName()) && zzt.equal(Boolean.valueOf(player2.zzrJ()), Boolean.valueOf(player.zzrJ())) && zzt.equal(player2.getIconImageUri(), player.getIconImageUri()) && zzt.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && zzt.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && zzt.equal(player2.getTitle(), player.getTitle()) && zzt.equal(player2.getLevelInfo(), player.getLevelInfo());
    }

    static int zzb(Player player) {
        return zzt.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzrJ()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo());
    }

    static String zzc(Player player) {
        return zzt.zzt(player).zzg("PlayerId", player.getPlayerId()).zzg("DisplayName", player.getDisplayName()).zzg("HasDebugAccess", Boolean.valueOf(player.zzrJ())).zzg("IconImageUri", player.getIconImageUri()).zzg("IconImageUrl", player.getIconImageUrl()).zzg("HiResImageUri", player.getHiResImageUri()).zzg("HiResImageUrl", player.getHiResImageUrl()).zzg("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).zzg("Title", player.getTitle()).zzg("LevelInfo", player.getLevelInfo()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public Player freeze() {
        return this;
    }

    public String getDisplayName() {
        return this.zzadI;
    }

    public void getDisplayName(CharArrayBuffer dataOut) {
        zzlc.zzb(this.zzadI, dataOut);
    }

    public Uri getHiResImageUri() {
        return this.zzang;
    }

    public String getHiResImageUrl() {
        return this.zzanr;
    }

    public Uri getIconImageUri() {
        return this.zzanf;
    }

    public String getIconImageUrl() {
        return this.zzanq;
    }

    public long getLastPlayedWithTimestamp() {
        return this.zzanL;
    }

    public PlayerLevelInfo getLevelInfo() {
        return this.zzanN;
    }

    public String getPlayerId() {
        return this.zzTL;
    }

    public long getRetrievedTimestamp() {
        return this.zzanJ;
    }

    public String getTitle() {
        return this.zzadv;
    }

    public void getTitle(CharArrayBuffer dataOut) {
        zzlc.zzb(this.zzadv, dataOut);
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    public int hashCode() {
        return zzb(this);
    }

    public boolean isDataValid() {
        return true;
    }

    public boolean isProfileVisible() {
        return this.zzanO;
    }

    public String toString() {
        return zzc((Player) this);
    }

    public void writeToParcel(Parcel dest, int flags) {
        String str = null;
        if (zznF()) {
            dest.writeString(this.zzTL);
            dest.writeString(this.zzadI);
            dest.writeString(this.zzanf == null ? null : this.zzanf.toString());
            if (this.zzang != null) {
                str = this.zzang.toString();
            }
            dest.writeString(str);
            dest.writeLong(this.zzanJ);
            return;
        }
        PlayerEntityCreator.zza(this, dest, flags);
    }

    public boolean zzrJ() {
        return this.zzanP;
    }

    public int zzrK() {
        return this.zzanK;
    }

    public MostRecentGameInfo zzrL() {
        return this.zzanM;
    }
}
