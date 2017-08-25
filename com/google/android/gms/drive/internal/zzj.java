package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

public class zzj {
    private String zzadv;
    private DriveId zzady;
    protected MetadataChangeSet zzaex;
    private Integer zzaey;
    private final int zzaez;

    public zzj(int i) {
        this.zzaez = i;
    }

    public IntentSender build(GoogleApiClient apiClient) {
        zzu.zzb(this.zzaex, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        zzu.zza(apiClient.isConnected(), (Object) "Client must be connected");
        zzs com_google_android_gms_drive_internal_zzs = (zzs) apiClient.zza(Drive.zzNX);
        this.zzaex.zzpm().setContext(com_google_android_gms_drive_internal_zzs.getContext());
        try {
            return com_google_android_gms_drive_internal_zzs.zzpB().zza(new CreateFileIntentSenderRequest(this.zzaex.zzpm(), this.zzaey == null ? 0 : this.zzaey.intValue(), this.zzadv, this.zzady, this.zzaez));
        } catch (Throwable e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public void zza(DriveId driveId) {
        this.zzady = (DriveId) zzu.zzu(driveId);
    }

    public void zza(MetadataChangeSet metadataChangeSet) {
        this.zzaex = (MetadataChangeSet) zzu.zzu(metadataChangeSet);
    }

    public void zzct(int i) {
        this.zzaey = Integer.valueOf(i);
    }

    public void zzcv(String str) {
        this.zzadv = (String) zzu.zzu(str);
    }
}
