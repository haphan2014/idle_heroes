package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements GameBadge {
    public static final GameBadgeEntityCreator CREATOR = new GameBadgeEntityCreatorCompat();
    private final int zzCY;
    private int zzSq;
    private String zzadv;
    private String zzakM;
    private Uri zzanf;

    static final class GameBadgeEntityCreatorCompat extends GameBadgeEntityCreator {
        GameBadgeEntityCreatorCompat() {
        }

        public /* synthetic */ Object createFromParcel(Parcel x0) {
            return zzdE(x0);
        }

        public GameBadgeEntity zzdE(Parcel parcel) {
            if (GamesDowngradeableSafeParcel.zzd(DowngradeableSafeParcel.zznE()) || DowngradeableSafeParcel.zzca(GameBadgeEntity.class.getCanonicalName())) {
                return super.zzdE(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(1, readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }
    }

    GameBadgeEntity(int versionCode, int type, String title, String description, Uri iconImageUri) {
        this.zzCY = versionCode;
        this.zzSq = type;
        this.zzadv = title;
        this.zzakM = description;
        this.zzanf = iconImageUri;
    }

    public GameBadgeEntity(GameBadge gameBadge) {
        this.zzCY = 1;
        this.zzSq = gameBadge.getType();
        this.zzadv = gameBadge.getTitle();
        this.zzakM = gameBadge.getDescription();
        this.zzanf = gameBadge.getIconImageUri();
    }

    static int zza(GameBadge gameBadge) {
        return zzt.hashCode(Integer.valueOf(gameBadge.getType()), gameBadge.getTitle(), gameBadge.getDescription(), gameBadge.getIconImageUri());
    }

    static boolean zza(GameBadge gameBadge, Object obj) {
        if (!(obj instanceof GameBadge)) {
            return false;
        }
        if (gameBadge == obj) {
            return true;
        }
        GameBadge gameBadge2 = (GameBadge) obj;
        return zzt.equal(Integer.valueOf(gameBadge2.getType()), gameBadge.getTitle()) && zzt.equal(gameBadge2.getDescription(), gameBadge.getIconImageUri());
    }

    static String zzb(GameBadge gameBadge) {
        return zzt.zzt(gameBadge).zzg("Type", Integer.valueOf(gameBadge.getType())).zzg("Title", gameBadge.getTitle()).zzg("Description", gameBadge.getDescription()).zzg("IconImageUri", gameBadge.getIconImageUri()).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public /* synthetic */ Object freeze() {
        return zzti();
    }

    public String getDescription() {
        return this.zzakM;
    }

    public Uri getIconImageUri() {
        return this.zzanf;
    }

    public String getTitle() {
        return this.zzadv;
    }

    public int getType() {
        return this.zzSq;
    }

    public int getVersionCode() {
        return this.zzCY;
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
        if (zznF()) {
            dest.writeInt(this.zzSq);
            dest.writeString(this.zzadv);
            dest.writeString(this.zzakM);
            dest.writeString(this.zzanf == null ? null : this.zzanf.toString());
            return;
        }
        GameBadgeEntityCreator.zza(this, dest, flags);
    }

    public GameBadge zzti() {
        return this;
    }
}
