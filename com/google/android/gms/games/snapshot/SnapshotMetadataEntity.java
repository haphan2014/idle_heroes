package com.google.android.gms.games.snapshot;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzlc;

public final class SnapshotMetadataEntity implements SafeParcelable, SnapshotMetadata {
    public static final Creator<SnapshotMetadataEntity> CREATOR = new SnapshotMetadataEntityCreator();
    private final int zzCY;
    private final String zzadv;
    private final String zzakM;
    private final String zzapg;
    private final GameEntity zzaud;
    private final Uri zzavp;
    private final PlayerEntity zzavs;
    private final String zzavt;
    private final long zzavu;
    private final long zzavv;
    private final float zzavw;
    private final String zzavx;
    private final boolean zzavy;
    private final long zzavz;

    SnapshotMetadataEntity(int versionCode, GameEntity game, PlayerEntity owner, String snapshotId, Uri coverImageUri, String coverImageUrl, String title, String description, long lastModifiedTimestamp, long playedTime, float coverImageAspectRatio, String uniqueName, boolean changePending, long progressValue) {
        this.zzCY = versionCode;
        this.zzaud = game;
        this.zzavs = owner;
        this.zzapg = snapshotId;
        this.zzavp = coverImageUri;
        this.zzavt = coverImageUrl;
        this.zzavw = coverImageAspectRatio;
        this.zzadv = title;
        this.zzakM = description;
        this.zzavu = lastModifiedTimestamp;
        this.zzavv = playedTime;
        this.zzavx = uniqueName;
        this.zzavy = changePending;
        this.zzavz = progressValue;
    }

    public SnapshotMetadataEntity(SnapshotMetadata snapshotMetadata) {
        this.zzCY = 5;
        this.zzaud = new GameEntity(snapshotMetadata.getGame());
        this.zzavs = new PlayerEntity(snapshotMetadata.getOwner());
        this.zzapg = snapshotMetadata.getSnapshotId();
        this.zzavp = snapshotMetadata.getCoverImageUri();
        this.zzavt = snapshotMetadata.getCoverImageUrl();
        this.zzavw = snapshotMetadata.getCoverImageAspectRatio();
        this.zzadv = snapshotMetadata.getTitle();
        this.zzakM = snapshotMetadata.getDescription();
        this.zzavu = snapshotMetadata.getLastModifiedTimestamp();
        this.zzavv = snapshotMetadata.getPlayedTime();
        this.zzavx = snapshotMetadata.getUniqueName();
        this.zzavy = snapshotMetadata.hasChangePending();
        this.zzavz = snapshotMetadata.getProgressValue();
    }

    static int zza(SnapshotMetadata snapshotMetadata) {
        return zzt.hashCode(snapshotMetadata.getGame(), snapshotMetadata.getOwner(), snapshotMetadata.getSnapshotId(), snapshotMetadata.getCoverImageUri(), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio()), snapshotMetadata.getTitle(), snapshotMetadata.getDescription(), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getPlayedTime()), snapshotMetadata.getUniqueName(), Boolean.valueOf(snapshotMetadata.hasChangePending()), Long.valueOf(snapshotMetadata.getProgressValue()));
    }

    static boolean zza(SnapshotMetadata snapshotMetadata, Object obj) {
        if (!(obj instanceof SnapshotMetadata)) {
            return false;
        }
        if (snapshotMetadata == obj) {
            return true;
        }
        SnapshotMetadata snapshotMetadata2 = (SnapshotMetadata) obj;
        return zzt.equal(snapshotMetadata2.getGame(), snapshotMetadata.getGame()) && zzt.equal(snapshotMetadata2.getOwner(), snapshotMetadata.getOwner()) && zzt.equal(snapshotMetadata2.getSnapshotId(), snapshotMetadata.getSnapshotId()) && zzt.equal(snapshotMetadata2.getCoverImageUri(), snapshotMetadata.getCoverImageUri()) && zzt.equal(Float.valueOf(snapshotMetadata2.getCoverImageAspectRatio()), Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())) && zzt.equal(snapshotMetadata2.getTitle(), snapshotMetadata.getTitle()) && zzt.equal(snapshotMetadata2.getDescription(), snapshotMetadata.getDescription()) && zzt.equal(Long.valueOf(snapshotMetadata2.getLastModifiedTimestamp()), Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())) && zzt.equal(Long.valueOf(snapshotMetadata2.getPlayedTime()), Long.valueOf(snapshotMetadata.getPlayedTime())) && zzt.equal(snapshotMetadata2.getUniqueName(), snapshotMetadata.getUniqueName()) && zzt.equal(Boolean.valueOf(snapshotMetadata2.hasChangePending()), Boolean.valueOf(snapshotMetadata.hasChangePending())) && zzt.equal(Long.valueOf(snapshotMetadata2.getProgressValue()), Long.valueOf(snapshotMetadata.getProgressValue()));
    }

    static String zzb(SnapshotMetadata snapshotMetadata) {
        return zzt.zzt(snapshotMetadata).zzg("Game", snapshotMetadata.getGame()).zzg("Owner", snapshotMetadata.getOwner()).zzg("SnapshotId", snapshotMetadata.getSnapshotId()).zzg("CoverImageUri", snapshotMetadata.getCoverImageUri()).zzg("CoverImageUrl", snapshotMetadata.getCoverImageUrl()).zzg("CoverImageAspectRatio", Float.valueOf(snapshotMetadata.getCoverImageAspectRatio())).zzg("Description", snapshotMetadata.getDescription()).zzg("LastModifiedTimestamp", Long.valueOf(snapshotMetadata.getLastModifiedTimestamp())).zzg("PlayedTime", Long.valueOf(snapshotMetadata.getPlayedTime())).zzg("UniqueName", snapshotMetadata.getUniqueName()).zzg("ChangePending", Boolean.valueOf(snapshotMetadata.hasChangePending())).zzg("ProgressValue", Long.valueOf(snapshotMetadata.getProgressValue())).toString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return zza(this, obj);
    }

    public SnapshotMetadata freeze() {
        return this;
    }

    public float getCoverImageAspectRatio() {
        return this.zzavw;
    }

    public Uri getCoverImageUri() {
        return this.zzavp;
    }

    public String getCoverImageUrl() {
        return this.zzavt;
    }

    public String getDescription() {
        return this.zzakM;
    }

    public void getDescription(CharArrayBuffer dataOut) {
        zzlc.zzb(this.zzakM, dataOut);
    }

    public Game getGame() {
        return this.zzaud;
    }

    public long getLastModifiedTimestamp() {
        return this.zzavu;
    }

    public Player getOwner() {
        return this.zzavs;
    }

    public long getPlayedTime() {
        return this.zzavv;
    }

    public long getProgressValue() {
        return this.zzavz;
    }

    public String getSnapshotId() {
        return this.zzapg;
    }

    public String getTitle() {
        return this.zzadv;
    }

    public String getUniqueName() {
        return this.zzavx;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public boolean hasChangePending() {
        return this.zzavy;
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

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataEntityCreator.zza(this, out, flags);
    }
}
