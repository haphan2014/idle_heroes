package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzkx;
import java.util.ArrayList;

public final class AppContentUtils {

    private interface AppContentRunner {
        void zzb(ArrayList<DataHolder> arrayList, int i);
    }

    public static ArrayList<AppContentAction> zza(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        final ArrayList<AppContentAction> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 1, str2, "action_id", i, new AppContentRunner() {
            public void zzb(ArrayList<DataHolder> arrayList, int i) {
                arrayList2.add(new AppContentActionRef(arrayList, i));
            }
        }, arrayList);
        return arrayList2;
    }

    private static void zza(DataHolder dataHolder, int i, String str, String str2, int i2, AppContentRunner appContentRunner, ArrayList<DataHolder> arrayList) {
        DataHolder dataHolder2 = (DataHolder) arrayList.get(i);
        Object zzd = dataHolder.zzd(str, i2, dataHolder.zzbh(i2));
        if (!TextUtils.isEmpty(zzd)) {
            int count = dataHolder2.getCount();
            String[] split = zzd.split(",");
            for (int i3 = 0; i3 < count; i3++) {
                CharSequence zzd2 = dataHolder2.zzd(str2, i3, dataHolder2.zzbh(i3));
                if (!TextUtils.isEmpty(zzd2) && zzkx.zzb(split, zzd2)) {
                    appContentRunner.zzb(arrayList, i3);
                }
            }
        }
    }

    public static ArrayList<AppContentAnnotation> zzb(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        final ArrayList<AppContentAnnotation> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 2, str2, "annotation_id", i, new AppContentRunner() {
            public void zzb(ArrayList<DataHolder> arrayList, int i) {
                arrayList2.add(new AppContentAnnotationRef(arrayList, i));
            }
        }, arrayList);
        return arrayList2;
    }

    public static ArrayList<AppContentCondition> zzc(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        final ArrayList<AppContentCondition> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 4, str2, "condition_id", i, new AppContentRunner() {
            public void zzb(ArrayList<DataHolder> arrayList, int i) {
                arrayList2.add(new AppContentConditionRef(arrayList, i));
            }
        }, arrayList);
        return arrayList2;
    }

    public static Bundle zzd(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        final Bundle bundle = new Bundle();
        final DataHolder dataHolder2 = (DataHolder) arrayList.get(3);
        AppContentRunner c06934 = new AppContentRunner() {
            public void zzb(ArrayList<DataHolder> arrayList, int i) {
                AppContentTuple appContentTupleRef = new AppContentTupleRef(dataHolder2, i);
                bundle.putString(appContentTupleRef.getName(), appContentTupleRef.getValue());
            }
        };
        zza(dataHolder, 3, str, "tuple_id", i, c06934, arrayList);
        return bundle;
    }
}
