package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;

public class zzlr extends zzj<DriveId> {
    public static final zzlr zzahD = new zzlr();

    private zzlr() {
        super("driveId", Arrays.asList(new String[]{"sqlId", "resourceId", "mimeType"}), Arrays.asList(new String[]{"dbInstanceId"}), 4100000);
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzm(dataHolder, i, i2);
    }

    protected DriveId zzm(DataHolder dataHolder, int i, int i2) {
        return new DriveId(dataHolder.zzd("resourceId", i, i2), Long.valueOf(dataHolder.zzb("sqlId", i, i2)).longValue(), dataHolder.zznb().getLong("dbInstanceId"), DriveFolder.MIME_TYPE.equals(dataHolder.zzd(zzlo.zzahg.getName(), i, i2)) ? 1 : 0);
    }
}
