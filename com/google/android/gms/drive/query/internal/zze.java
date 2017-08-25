package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Set;

class zze {
    static MetadataField<?> zzb(MetadataBundle metadataBundle) {
        Set zzpY = metadataBundle.zzpY();
        if (zzpY.size() == 1) {
            return (MetadataField) zzpY.iterator().next();
        }
        throw new IllegalArgumentException("bundle should have exactly 1 populated field");
    }
}
