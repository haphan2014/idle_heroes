package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.zzs;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.zzg;

public class OpenFileActivityBuilder {
    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String zzadv;
    private String[] zzadw;
    private Filter zzadx;
    private DriveId zzady;

    public IntentSender build(GoogleApiClient apiClient) {
        zzu.zza(apiClient.isConnected(), (Object) "Client must be connected");
        if (this.zzadw == null) {
            this.zzadw = new String[0];
        }
        if (this.zzadw.length <= 0 || this.zzadx == null) {
            try {
                return ((zzs) apiClient.zza(Drive.zzNX)).zzpB().zza(new OpenFileIntentSenderRequest(this.zzadv, this.zzadw, this.zzady, this.zzadx == null ? null : new FilterHolder(this.zzadx)));
            } catch (Throwable e) {
                throw new RuntimeException("Unable to connect Drive Play Service", e);
            }
        }
        throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId folder) {
        this.zzady = (DriveId) zzu.zzu(folder);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String title) {
        this.zzadv = (String) zzu.zzu(title);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String[] mimeTypes) {
        zzu.zzb(mimeTypes != null, (Object) "mimeTypes may not be null");
        this.zzadw = mimeTypes;
        return this;
    }

    public OpenFileActivityBuilder setSelectionFilter(Filter filter) {
        boolean z = true;
        zzu.zzb(filter != null, (Object) "filter may not be null");
        if (zzg.zza(filter)) {
            z = false;
        }
        zzu.zzb(z, (Object) "FullTextSearchFilter cannot be used as a selection filter");
        this.zzadx = filter;
        return this;
    }
}
