package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;

public final class SnapshotMetadataChangeEntity extends SnapshotMetadataChange implements SafeParcelable {
    public static final SnapshotMetadataChangeCreator CREATOR = new SnapshotMetadataChangeCreator();
    private final int zzCY;
    private final String zzakM;
    private final Long zzavn;
    private final Uri zzavp;
    private final Long zzavq;
    private BitmapTeleporter zzavr;

    SnapshotMetadataChangeEntity() {
        this(5, null, null, null, null, null);
    }

    SnapshotMetadataChangeEntity(int versionCode, String description, Long playedTimeMillis, BitmapTeleporter coverImage, Uri coverImageUri, Long progressValue) {
        boolean z = true;
        this.zzCY = versionCode;
        this.zzakM = description;
        this.zzavq = playedTimeMillis;
        this.zzavr = coverImage;
        this.zzavp = coverImageUri;
        this.zzavn = progressValue;
        if (this.zzavr != null) {
            if (this.zzavp != null) {
                z = false;
            }
            zzu.zza(z, (Object) "Cannot set both a URI and an image");
        } else if (this.zzavp != null) {
            if (this.zzavr != null) {
                z = false;
            }
            zzu.zza(z, (Object) "Cannot set both a URI and an image");
        }
    }

    SnapshotMetadataChangeEntity(String description, Long playedTimeMillis, BitmapTeleporter coverImage, Uri coverImageUri, Long progressValue) {
        this(5, description, playedTimeMillis, coverImage, coverImageUri, progressValue);
    }

    public int describeContents() {
        return 0;
    }

    public Bitmap getCoverImage() {
        return this.zzavr == null ? null : this.zzavr.zznc();
    }

    public Uri getCoverImageUri() {
        return this.zzavp;
    }

    public String getDescription() {
        return this.zzakM;
    }

    public Long getPlayedTimeMillis() {
        return this.zzavq;
    }

    public Long getProgressValue() {
        return this.zzavn;
    }

    public int getVersionCode() {
        return this.zzCY;
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotMetadataChangeCreator.zza(this, out, flags);
    }

    public BitmapTeleporter zztQ() {
        return this.zzavr;
    }
}
