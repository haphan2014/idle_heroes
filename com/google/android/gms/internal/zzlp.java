package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzj;
import java.util.Arrays;

public class zzlp extends zzj<AppVisibleCustomProperties> {
    public zzlp(int i) {
        super("customProperties", Arrays.asList(new String[]{"customProperties", "sqlId"}), Arrays.asList(new String[]{"customPropertiesExtra"}), i);
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzl(dataHolder, i, i2);
    }

    protected AppVisibleCustomProperties zzl(DataHolder dataHolder, int i, int i2) {
        return (AppVisibleCustomProperties) dataHolder.zznb().getSparseParcelableArray("customPropertiesExtra").get(i, AppVisibleCustomProperties.zzagD);
    }
}
