package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzan.zza;
import com.google.android.gms.drive.internal.zzx;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzlg;
import com.google.android.gms.internal.zzlo;
import com.heyzap.sdk.ads.HeyzapAds.NetworkCallback;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent implements SafeParcelable, ResourceEvent {
    public static final Creator<CompletionEvent> CREATOR = new zze();
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    final int zzCY;
    final String zzOx;
    final DriveId zzacT;
    final ParcelFileDescriptor zzadT;
    final ParcelFileDescriptor zzadU;
    final MetadataBundle zzadV;
    final List<String> zzadW;
    final IBinder zzadX;
    private boolean zzadY = false;
    private boolean zzadZ = false;
    private boolean zzaea = false;
    final int zzwS;

    CompletionEvent(int versionCode, DriveId driveId, String accountName, ParcelFileDescriptor baseParcelFileDescriptor, ParcelFileDescriptor modifiedParcelFileDescriptor, MetadataBundle modifiedMetadataBundle, List<String> trackingTags, int status, IBinder releaseCallback) {
        this.zzCY = versionCode;
        this.zzacT = driveId;
        this.zzOx = accountName;
        this.zzadT = baseParcelFileDescriptor;
        this.zzadU = modifiedParcelFileDescriptor;
        this.zzadV = modifiedMetadataBundle;
        this.zzadW = trackingTags;
        this.zzwS = status;
        this.zzadX = releaseCallback;
    }

    private void zzpu() {
        if (this.zzaea) {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        }
    }

    private void zzv(boolean z) {
        zzpu();
        this.zzaea = true;
        zzlg.zza(this.zzadT);
        zzlg.zza(this.zzadU);
        if (this.zzadV != null && this.zzadV.zzc(zzlo.zzaho)) {
            ((BitmapTeleporter) this.zzadV.zza(zzlo.zzaho)).release();
        }
        if (this.zzadX == null) {
            zzx.zzv("CompletionEvent", "No callback on " + (z ? "snooze" : NetworkCallback.DISMISS));
            return;
        }
        try {
            zza.zzaR(this.zzadX).zzv(z);
        } catch (RemoteException e) {
            zzx.zzv("CompletionEvent", "RemoteException on " + (z ? "snooze" : NetworkCallback.DISMISS) + ": " + e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void dismiss() {
        zzv(false);
    }

    public String getAccountName() {
        zzpu();
        return this.zzOx;
    }

    public InputStream getBaseContentsInputStream() {
        zzpu();
        if (this.zzadT == null) {
            return null;
        }
        if (this.zzadY) {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzadY = true;
        return new FileInputStream(this.zzadT.getFileDescriptor());
    }

    public DriveId getDriveId() {
        zzpu();
        return this.zzacT;
    }

    public InputStream getModifiedContentsInputStream() {
        zzpu();
        if (this.zzadU == null) {
            return null;
        }
        if (this.zzadZ) {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        }
        this.zzadZ = true;
        return new FileInputStream(this.zzadU.getFileDescriptor());
    }

    public MetadataChangeSet getModifiedMetadataChangeSet() {
        zzpu();
        return this.zzadV != null ? new MetadataChangeSet(this.zzadV) : null;
    }

    public int getStatus() {
        zzpu();
        return this.zzwS;
    }

    public List<String> getTrackingTags() {
        zzpu();
        return new ArrayList(this.zzadW);
    }

    public int getType() {
        return 2;
    }

    public void snooze() {
        zzv(true);
    }

    public String toString() {
        String str = this.zzadW == null ? "<null>" : "'" + TextUtils.join("','", this.zzadW) + "'";
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[]{this.zzacT, Integer.valueOf(this.zzwS), str});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags | 1);
    }
}
