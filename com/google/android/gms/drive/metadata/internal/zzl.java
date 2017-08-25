package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class zzl extends zzi<DriveId> implements SearchableCollectionMetadataField<DriveId> {
    public zzl(int i) {
        super("parents", Collections.emptySet(), Arrays.asList(new String[]{"parentsExtra", "dbInstanceId", "parentsExtraHolder"}), i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzc(com.google.android.gms.common.data.DataHolder r15) {
        /*
        r14 = this;
        r1 = 0;
        monitor-enter(r15);
        r0 = r15.zznb();	 Catch:{ all -> 0x009b }
        r2 = "parentsExtraHolder";
        r0 = r0.getParcelable(r2);	 Catch:{ all -> 0x009b }
        r0 = (com.google.android.gms.common.data.DataHolder) r0;	 Catch:{ all -> 0x009b }
        if (r0 != 0) goto L_0x0012;
    L_0x0010:
        monitor-exit(r15);	 Catch:{ all -> 0x009b }
    L_0x0011:
        return;
    L_0x0012:
        r3 = r15.getCount();	 Catch:{ all -> 0x009e }
        r4 = new java.util.ArrayList;	 Catch:{ all -> 0x009e }
        r4.<init>(r3);	 Catch:{ all -> 0x009e }
        r5 = new java.util.HashMap;	 Catch:{ all -> 0x009e }
        r5.<init>(r3);	 Catch:{ all -> 0x009e }
        r2 = r1;
    L_0x0021:
        if (r2 >= r3) goto L_0x003f;
    L_0x0023:
        r6 = r15.zzbh(r2);	 Catch:{ all -> 0x009e }
        r7 = new com.google.android.gms.drive.metadata.internal.ParentDriveIdSet;	 Catch:{ all -> 0x009e }
        r7.<init>();	 Catch:{ all -> 0x009e }
        r4.add(r7);	 Catch:{ all -> 0x009e }
        r8 = "sqlId";
        r8 = r15.zzb(r8, r2, r6);	 Catch:{ all -> 0x009e }
        r6 = java.lang.Long.valueOf(r8);	 Catch:{ all -> 0x009e }
        r5.put(r6, r7);	 Catch:{ all -> 0x009e }
        r2 = r2 + 1;
        goto L_0x0021;
    L_0x003f:
        r2 = r0.zznb();	 Catch:{ all -> 0x009e }
        r3 = "childSqlIdColumn";
        r3 = r2.getString(r3);	 Catch:{ all -> 0x009e }
        r6 = "parentSqlIdColumn";
        r6 = r2.getString(r6);	 Catch:{ all -> 0x009e }
        r7 = "parentResIdColumn";
        r7 = r2.getString(r7);	 Catch:{ all -> 0x009e }
        r8 = r0.getCount();	 Catch:{ all -> 0x009e }
        r2 = r1;
    L_0x005a:
        if (r2 >= r8) goto L_0x0083;
    L_0x005c:
        r9 = r0.zzbh(r2);	 Catch:{ all -> 0x009e }
        r10 = r0.zzb(r3, r2, r9);	 Catch:{ all -> 0x009e }
        r1 = java.lang.Long.valueOf(r10);	 Catch:{ all -> 0x009e }
        r1 = r5.get(r1);	 Catch:{ all -> 0x009e }
        r1 = (com.google.android.gms.drive.metadata.internal.ParentDriveIdSet) r1;	 Catch:{ all -> 0x009e }
        r10 = new com.google.android.gms.drive.metadata.internal.PartialDriveId;	 Catch:{ all -> 0x009e }
        r11 = r0.zzd(r7, r2, r9);	 Catch:{ all -> 0x009e }
        r12 = r0.zzb(r6, r2, r9);	 Catch:{ all -> 0x009e }
        r9 = 1;
        r10.<init>(r11, r12, r9);	 Catch:{ all -> 0x009e }
        r1.zza(r10);	 Catch:{ all -> 0x009e }
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x005a;
    L_0x0083:
        r1 = r15.zznb();	 Catch:{ all -> 0x009e }
        r2 = "parentsExtra";
        r1.putParcelableArrayList(r2, r4);	 Catch:{ all -> 0x009e }
        r0.close();	 Catch:{ all -> 0x009b }
        r0 = r15.zznb();	 Catch:{ all -> 0x009b }
        r1 = "parentsExtraHolder";
        r0.remove(r1);	 Catch:{ all -> 0x009b }
        monitor-exit(r15);	 Catch:{ all -> 0x009b }
        goto L_0x0011;
    L_0x009b:
        r0 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x009b }
        throw r0;
    L_0x009e:
        r1 = move-exception;
        r0.close();	 Catch:{ all -> 0x009b }
        r0 = r15.zznb();	 Catch:{ all -> 0x009b }
        r2 = "parentsExtraHolder";
        r0.remove(r2);	 Catch:{ all -> 0x009b }
        throw r1;	 Catch:{ all -> 0x009b }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.metadata.internal.zzl.zzc(com.google.android.gms.common.data.DataHolder):void");
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzd(dataHolder, i, i2);
    }

    protected Collection<DriveId> zzd(DataHolder dataHolder, int i, int i2) {
        Bundle zznb = dataHolder.zznb();
        List parcelableArrayList = zznb.getParcelableArrayList("parentsExtra");
        if (parcelableArrayList == null) {
            if (zznb.getParcelable("parentsExtraHolder") != null) {
                zzc(dataHolder);
                parcelableArrayList = zznb.getParcelableArrayList("parentsExtra");
            }
            if (parcelableArrayList == null) {
                return null;
            }
        }
        return ((ParentDriveIdSet) parcelableArrayList.get(i)).zzC(zznb.getLong("dbInstanceId"));
    }

    public void zzd(DataHolder dataHolder) {
        Bundle zznb = dataHolder.zznb();
        if (zznb != null) {
            synchronized (dataHolder) {
                DataHolder dataHolder2 = (DataHolder) zznb.getParcelable("parentsExtraHolder");
                if (dataHolder2 != null) {
                    dataHolder2.close();
                    zznb.remove("parentsExtraHolder");
                }
            }
        }
    }

    protected /* synthetic */ Object zzj(Bundle bundle) {
        return zzo(bundle);
    }

    protected Collection<DriveId> zzo(Bundle bundle) {
        Collection zzo = super.zzo(bundle);
        return zzo == null ? null : new HashSet(zzo);
    }
}
