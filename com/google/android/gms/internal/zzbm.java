package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public class zzbm {
    private final int zzrL;
    private final int zzrM;
    private final int zzrN;
    private final zzbl zzrO = new zzbo();

    class C08511 implements Comparator<String> {
        final /* synthetic */ zzbm zzrP;

        C08511(zzbm com_google_android_gms_internal_zzbm) {
            this.zzrP = com_google_android_gms_internal_zzbm;
        }

        public int compare(String s1, String s2) {
            return s2.length() - s1.length();
        }
    }

    class C08522 implements Comparator<com.google.android.gms.internal.zzbp.zza> {
        final /* synthetic */ zzbm zzrP;

        C08522(zzbm com_google_android_gms_internal_zzbm) {
            this.zzrP = com_google_android_gms_internal_zzbm;
        }

        public /* synthetic */ int compare(Object x0, Object x1) {
            return zza((com.google.android.gms.internal.zzbp.zza) x0, (com.google.android.gms.internal.zzbp.zza) x1);
        }

        public int zza(com.google.android.gms.internal.zzbp.zza com_google_android_gms_internal_zzbp_zza, com.google.android.gms.internal.zzbp.zza com_google_android_gms_internal_zzbp_zza2) {
            return (int) (com_google_android_gms_internal_zzbp_zza.value - com_google_android_gms_internal_zzbp_zza2.value);
        }
    }

    static class zza {
        ByteArrayOutputStream zzrQ = new ByteArrayOutputStream(4096);
        Base64OutputStream zzrR = new Base64OutputStream(this.zzrQ, 10);

        public String toString() {
            String byteArrayOutputStream;
            try {
                this.zzrR.close();
            } catch (Throwable e) {
                zzb.zzb("HashManager: Unable to convert to Base64.", e);
            }
            try {
                this.zzrQ.close();
                byteArrayOutputStream = this.zzrQ.toString();
            } catch (Throwable e2) {
                zzb.zzb("HashManager: Unable to convert to Base64.", e2);
                byteArrayOutputStream = "";
            } finally {
                this.zzrQ = null;
                this.zzrR = null;
            }
            return byteArrayOutputStream;
        }

        public void write(byte[] data) throws IOException {
            this.zzrR.write(data);
        }
    }

    public zzbm(int i) {
        this.zzrM = i;
        this.zzrL = 6;
        this.zzrN = 0;
    }

    private String zzz(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zza zzcv = zzcv();
        Arrays.sort(split, new C08511(this));
        int i = 0;
        while (i < split.length && i < this.zzrM) {
            if (split[i].trim().length() != 0) {
                try {
                    zzcv.write(this.zzrO.zzy(split[i]));
                } catch (Throwable e) {
                    zzb.zzb("Error while writing hash to byteStream", e);
                }
            }
            i++;
        }
        return zzcv.toString();
    }

    String zzA(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zza zzcv = zzcv();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzrM, new C08522(this));
        for (String zzC : split) {
            String[] zzC2 = zzbn.zzC(zzC);
            if (zzC2.length >= this.zzrL) {
                zzbp.zza(zzC2, this.zzrM, this.zzrL, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzcv.write(this.zzrO.zzy(((com.google.android.gms.internal.zzbp.zza) it.next()).zzrT));
            } catch (Throwable e) {
                zzb.zzb("Error while writing hash to byteStream", e);
            }
        }
        return zzcv.toString();
    }

    public String zza(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((String) it.next()).toLowerCase(Locale.US));
            stringBuffer.append('\n');
        }
        switch (this.zzrN) {
            case 0:
                return zzA(stringBuffer.toString());
            case 1:
                return zzz(stringBuffer.toString());
            default:
                return "";
        }
    }

    zza zzcv() {
        return new zza();
    }
}
