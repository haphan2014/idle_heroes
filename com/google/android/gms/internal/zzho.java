package com.google.android.gms.internal;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

@zzgd
public class zzho {
    private static zzl zzGu;
    public static final zza<Void> zzGv = new C09491();
    private static final Object zzoW = new Object();

    public interface zza<T> {
        T zzft();

        T zzh(InputStream inputStream);
    }

    static class C09491 implements zza {
        C09491() {
        }

        public /* synthetic */ Object zzft() {
            return zzgu();
        }

        public Void zzgu() {
            return null;
        }

        public /* synthetic */ Object zzh(InputStream inputStream) {
            return zzi(inputStream);
        }

        public Void zzi(InputStream inputStream) {
            return null;
        }
    }

    private static class zzb<T> extends zzk<InputStream> {
        private final zza<T> zzGz;
        private final com.google.android.gms.internal.zzm.zzb<T> zzaH;

        class C09521 implements com.google.android.gms.internal.zzm.zza {
            final /* synthetic */ com.google.android.gms.internal.zzm.zzb zzGA;
            final /* synthetic */ zza zzGB;

            C09521(com.google.android.gms.internal.zzm.zzb com_google_android_gms_internal_zzm_zzb, zza com_google_android_gms_internal_zzho_zza) {
                this.zzGA = com_google_android_gms_internal_zzm_zzb;
                this.zzGB = com_google_android_gms_internal_zzho_zza;
            }

            public void zze(zzr com_google_android_gms_internal_zzr) {
                this.zzGA.zzb(this.zzGB.zzft());
            }
        }

        public zzb(String str, zza<T> com_google_android_gms_internal_zzho_zza_T, com.google.android.gms.internal.zzm.zzb<T> com_google_android_gms_internal_zzm_zzb_T) {
            super(0, str, new C09521(com_google_android_gms_internal_zzm_zzb_T, com_google_android_gms_internal_zzho_zza_T));
            this.zzGz = com_google_android_gms_internal_zzho_zza_T;
            this.zzaH = com_google_android_gms_internal_zzm_zzb_T;
        }

        protected zzm<InputStream> zza(zzi com_google_android_gms_internal_zzi) {
            return zzm.zza(new ByteArrayInputStream(com_google_android_gms_internal_zzi.data), zzx.zzb(com_google_android_gms_internal_zzi));
        }

        protected /* synthetic */ void zza(Object obj) {
            zzj((InputStream) obj);
        }

        protected void zzj(InputStream inputStream) {
            this.zzaH.zzb(this.zzGz.zzh(inputStream));
        }
    }

    private class zzc<T> extends zzhs<T> implements com.google.android.gms.internal.zzm.zzb<T> {
        final /* synthetic */ zzho zzGx;

        private zzc(zzho com_google_android_gms_internal_zzho) {
            this.zzGx = com_google_android_gms_internal_zzho;
        }

        public void zzb(T t) {
            super.zzf(t);
        }
    }

    public zzho(Context context) {
        zzGu = zzN(context);
    }

    private static zzl zzN(Context context) {
        zzl com_google_android_gms_internal_zzl;
        synchronized (zzoW) {
            if (zzGu == null) {
                zzGu = zzac.zza(context.getApplicationContext());
            }
            com_google_android_gms_internal_zzl = zzGu;
        }
        return com_google_android_gms_internal_zzl;
    }

    public <T> zzhv<T> zza(String str, zza<T> com_google_android_gms_internal_zzho_zza_T) {
        Object com_google_android_gms_internal_zzho_zzc = new zzc();
        zzGu.zze(new zzb(str, com_google_android_gms_internal_zzho_zza_T, com_google_android_gms_internal_zzho_zzc));
        return com_google_android_gms_internal_zzho_zzc;
    }

    public zzhv<String> zzb(final String str, Map<String, String> map) {
        final Object com_google_android_gms_internal_zzho_zzc = new zzc();
        final Map<String, String> map2 = map;
        zzGu.zze(new zzab(this, str, com_google_android_gms_internal_zzho_zzc, new com.google.android.gms.internal.zzm.zza(this) {
            final /* synthetic */ zzho zzGx;

            public void zze(zzr com_google_android_gms_internal_zzr) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Failed to load URL: " + str + "\n" + com_google_android_gms_internal_zzr.toString());
                com_google_android_gms_internal_zzho_zzc.zzb(null);
            }
        }) {
            final /* synthetic */ zzho zzGx;

            public Map<String, String> getHeaders() throws zza {
                return map2 == null ? super.getHeaders() : map2;
            }
        });
        return com_google_android_gms_internal_zzho_zzc;
    }
}
