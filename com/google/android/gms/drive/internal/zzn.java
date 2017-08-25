package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzn extends Metadata {
    private final MetadataBundle zzaeF;

    public zzn(MetadataBundle metadataBundle) {
        this.zzaeF = metadataBundle;
    }

    public /* synthetic */ Object freeze() {
        return zzpl();
    }

    public boolean isDataValid() {
        return this.zzaeF != null;
    }

    public String toString() {
        return "Metadata [mImpl=" + this.zzaeF + "]";
    }

    public <T> T zza(MetadataField<T> metadataField) {
        return this.zzaeF.zza((MetadataField) metadataField);
    }

    public Metadata zzpl() {
        return new zzn(MetadataBundle.zza(this.zzaeF));
    }
}
