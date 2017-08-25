package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.internal.zzn;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.internal.zze;
import com.google.android.gms.internal.zzlo;

public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzadq;

    private static class zza extends Metadata {
        private final DataHolder zzWu;
        private final int zzYt;
        private final int zzadr;

        public zza(DataHolder dataHolder, int i) {
            this.zzWu = dataHolder;
            this.zzadr = i;
            this.zzYt = dataHolder.zzbh(i);
        }

        public /* synthetic */ Object freeze() {
            return zzpl();
        }

        public boolean isDataValid() {
            return !this.zzWu.isClosed();
        }

        public <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzWu, this.zzadr, this.zzYt);
        }

        public Metadata zzpl() {
            MetadataBundle zzpX = MetadataBundle.zzpX();
            for (MetadataField metadataField : zze.zzpW()) {
                if (metadataField != zzlo.zzaho) {
                    metadataField.zza(this.zzWu, zzpX, this.zzadr, this.zzYt);
                }
            }
            return new zzn(zzpX);
        }
    }

    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.zznb().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    public Metadata get(int row) {
        zza com_google_android_gms_drive_MetadataBuffer_zza = this.zzadq;
        if (com_google_android_gms_drive_MetadataBuffer_zza != null && com_google_android_gms_drive_MetadataBuffer_zza.zzadr == row) {
            return com_google_android_gms_drive_MetadataBuffer_zza;
        }
        Metadata com_google_android_gms_drive_MetadataBuffer_zza2 = new zza(this.zzWu, row);
        this.zzadq = com_google_android_gms_drive_MetadataBuffer_zza2;
        return com_google_android_gms_drive_MetadataBuffer_zza2;
    }

    @Deprecated
    public String getNextPageToken() {
        return null;
    }

    public void release() {
        if (this.zzWu != null) {
            zze.zzb(this.zzWu);
        }
        super.release();
    }
}
