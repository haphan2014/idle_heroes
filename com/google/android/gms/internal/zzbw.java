package com.google.android.gms.internal;

import android.os.Binder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@zzgd
public class zzbw {
    private final Collection<zzbv<String>> zztA = new ArrayList();
    private final Collection<zzbs> zzty = new ArrayList();
    private final Collection<zzbv<String>> zztz = new ArrayList();

    public void zza(zzbs com_google_android_gms_internal_zzbs) {
        this.zzty.add(com_google_android_gms_internal_zzbs);
    }

    public void zza(zzbv<String> com_google_android_gms_internal_zzbv_java_lang_String) {
        this.zztz.add(com_google_android_gms_internal_zzbv_java_lang_String);
    }

    public void zzb(zzbv<String> com_google_android_gms_internal_zzbv_java_lang_String) {
        this.zztA.add(com_google_android_gms_internal_zzbv_java_lang_String);
    }

    public List<String> zzda() {
        List<String> arrayList = new ArrayList();
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            for (zzbv zzcZ : this.zztA) {
                String str = (String) zzcZ.zzcZ().get();
                if (str != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }

    public List<String> zzdb() {
        List<String> arrayList = new ArrayList();
        for (zzbv com_google_android_gms_internal_zzbv : this.zztz) {
            String str = (String) com_google_android_gms_internal_zzbv.get();
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
