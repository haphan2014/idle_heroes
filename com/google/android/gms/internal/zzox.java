package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class zzox implements PanoramaResult {
    private final Status zzOt;
    private final Intent zzaGA;

    public zzox(Status status, Intent intent) {
        this.zzOt = (Status) zzu.zzu(status);
        this.zzaGA = intent;
    }

    public Status getStatus() {
        return this.zzOt;
    }

    public Intent getViewerIntent() {
        return this.zzaGA;
    }
}
