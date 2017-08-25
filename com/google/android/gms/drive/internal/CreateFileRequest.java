package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class CreateFileRequest implements SafeParcelable {
    public static final Creator<CreateFileRequest> CREATOR = new zzl();
    final int zzCY;
    final String zzadn;
    final MetadataBundle zzaeA;
    final Integer zzaeB;
    final DriveId zzaeC;
    final int zzaeD;
    final int zzaeE;
    final boolean zzaen;
    final Contents zzaes;

    CreateFileRequest(int versionCode, DriveId parentDriveId, MetadataBundle metadata, Contents contentsReference, Integer fileType, boolean sendEventOnCompletion, String trackingTag, int createStrategy, int openContentsRequestId) {
        if (!(contentsReference == null || openContentsRequestId == 0)) {
            zzu.zzb(contentsReference.getRequestId() == openContentsRequestId, (Object) "inconsistent contents reference");
        }
        if ((fileType == null || fileType.intValue() == 0) && contentsReference == null && openContentsRequestId == 0) {
            throw new IllegalArgumentException("Need a valid contents");
        }
        this.zzCY = versionCode;
        this.zzaeC = (DriveId) zzu.zzu(parentDriveId);
        this.zzaeA = (MetadataBundle) zzu.zzu(metadata);
        this.zzaes = contentsReference;
        this.zzaeB = fileType;
        this.zzadn = trackingTag;
        this.zzaeD = createStrategy;
        this.zzaen = sendEventOnCompletion;
        this.zzaeE = openContentsRequestId;
    }

    public CreateFileRequest(DriveId parentDriveId, MetadataBundle metadata, int openContentsRequestId, int fileType, ExecutionOptions executionOptions) {
        this(2, parentDriveId, metadata, null, Integer.valueOf(fileType), executionOptions.zzpj(), executionOptions.zzpi(), executionOptions.zzpk(), openContentsRequestId);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }
}
