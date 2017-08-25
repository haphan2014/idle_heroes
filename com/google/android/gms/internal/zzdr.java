package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.tagmanager.DataLayer;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzgd
public class zzdr {
    private static final Set<String> zzwF = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzwG = new DecimalFormat("#,###");
    private zzid zzoA;
    private File zzwH;
    private boolean zzwI;

    public zzdr(zzid com_google_android_gms_internal_zzid) {
        this.zzoA = com_google_android_gms_internal_zzid;
        File cacheDir = com_google_android_gms_internal_zzid.getContext().getCacheDir();
        if (cacheDir == null) {
            zzb.zzaC("Context.getCacheDir() returned null");
            return;
        }
        this.zzwH = new File(cacheDir, "admobVideoStreams");
        if (!this.zzwH.isDirectory() && !this.zzwH.mkdirs()) {
            zzb.zzaC("Could not create preload cache directory at " + this.zzwH.getAbsolutePath());
            this.zzwH = null;
        } else if (!this.zzwH.setReadable(true, false) || !this.zzwH.setExecutable(true, false)) {
            zzb.zzaC("Could not set cache file permissions at " + this.zzwH.getAbsolutePath());
            this.zzwH = null;
        }
    }

    private String zzX(String str) {
        return zzk.zzcA().zzax(str);
    }

    private File zza(File file) {
        return new File(this.zzwH, file.getName() + ".done");
    }

    private void zza(final String str, final File file) {
        zza.zzGF.post(new Runnable(this) {
            final /* synthetic */ zzdr zzwN;

            public void run() {
                Map hashMap = new HashMap();
                hashMap.put(DataLayer.EVENT_KEY, "precacheCanceled");
                hashMap.put("src", str);
                if (file != null) {
                    hashMap.put("cachedSrc", file.getAbsolutePath());
                }
                this.zzwN.zzoA.zzc("onPrecacheEvent", hashMap);
            }
        });
    }

    private void zza(final String str, final File file, final int i) {
        zza.zzGF.post(new Runnable(this) {
            final /* synthetic */ zzdr zzwN;

            public void run() {
                Map hashMap = new HashMap();
                hashMap.put(DataLayer.EVENT_KEY, "precacheComplete");
                hashMap.put("src", str);
                hashMap.put("cachedSrc", file.getAbsolutePath());
                hashMap.put("totalBytes", Integer.toString(i));
                this.zzwN.zzoA.zzc("onPrecacheEvent", hashMap);
            }
        });
    }

    private void zza(String str, File file, int i, int i2) {
        final String str2 = str;
        final File file2 = file;
        final int i3 = i;
        final int i4 = i2;
        zza.zzGF.post(new Runnable(this) {
            final /* synthetic */ zzdr zzwN;

            public void run() {
                Map hashMap = new HashMap();
                hashMap.put(DataLayer.EVENT_KEY, "precacheProgress");
                hashMap.put("src", str2);
                hashMap.put("cachedSrc", file2.getAbsolutePath());
                hashMap.put("bytesLoaded", Integer.toString(i3));
                hashMap.put("totalBytes", Integer.toString(i4));
                this.zzwN.zzoA.zzc("onPrecacheEvent", hashMap);
            }
        });
    }

    private static void zzb(File file) {
        if (file.isFile()) {
            file.setLastModified(System.currentTimeMillis());
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
    }

    public void abort() {
        this.zzwI = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zzW(java.lang.String r27) {
        /*
        r26 = this;
        r0 = r26;
        r4 = r0.zzwH;
        if (r4 != 0) goto L_0x0010;
    L_0x0006:
        r4 = 0;
        r0 = r26;
        r1 = r27;
        r0.zza(r1, r4);
        r4 = 0;
    L_0x000f:
        return r4;
    L_0x0010:
        r5 = r26.zzdQ();
        r4 = com.google.android.gms.internal.zzbz.zztO;
        r4 = r4.get();
        r4 = (java.lang.Integer) r4;
        r4 = r4.intValue();
        if (r5 <= r4) goto L_0x0037;
    L_0x0022:
        r4 = r26.zzdR();
        if (r4 != 0) goto L_0x0010;
    L_0x0028:
        r4 = "Unable to expire stream cache";
        com.google.android.gms.ads.internal.util.client.zzb.zzaC(r4);
        r4 = 0;
        r0 = r26;
        r1 = r27;
        r0.zza(r1, r4);
        r4 = 0;
        goto L_0x000f;
    L_0x0037:
        r4 = r26.zzX(r27);
        r7 = new java.io.File;
        r0 = r26;
        r5 = r0.zzwH;
        r7.<init>(r5, r4);
        r0 = r26;
        r8 = r0.zza(r7);
        r4 = r7.isFile();
        if (r4 == 0) goto L_0x007c;
    L_0x0050:
        r4 = r8.isFile();
        if (r4 == 0) goto L_0x007c;
    L_0x0056:
        r4 = r7.length();
        r4 = (int) r4;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Stream cache hit at ";
        r5 = r5.append(r6);
        r0 = r27;
        r5 = r5.append(r0);
        r5 = r5.toString();
        com.google.android.gms.ads.internal.util.client.zzb.zzay(r5);
        r0 = r26;
        r1 = r27;
        r0.zza(r1, r7, r4);
        r4 = 1;
        goto L_0x000f;
    L_0x007c:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r26;
        r5 = r0.zzwH;
        r5 = r5.getAbsolutePath();
        r4 = r4.append(r5);
        r0 = r27;
        r4 = r4.append(r0);
        r9 = r4.toString();
        r5 = zzwF;
        monitor-enter(r5);
        r4 = zzwF;	 Catch:{ all -> 0x00c5 }
        r4 = r4.contains(r9);	 Catch:{ all -> 0x00c5 }
        if (r4 == 0) goto L_0x00c8;
    L_0x00a2:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c5 }
        r4.<init>();	 Catch:{ all -> 0x00c5 }
        r6 = "Stream cache already in progress at ";
        r4 = r4.append(r6);	 Catch:{ all -> 0x00c5 }
        r0 = r27;
        r4 = r4.append(r0);	 Catch:{ all -> 0x00c5 }
        r4 = r4.toString();	 Catch:{ all -> 0x00c5 }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC(r4);	 Catch:{ all -> 0x00c5 }
        r0 = r26;
        r1 = r27;
        r0.zza(r1, r7);	 Catch:{ all -> 0x00c5 }
        r4 = 0;
        monitor-exit(r5);	 Catch:{ all -> 0x00c5 }
        goto L_0x000f;
    L_0x00c5:
        r4 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x00c5 }
        throw r4;
    L_0x00c8:
        r4 = zzwF;	 Catch:{ all -> 0x00c5 }
        r4.add(r9);	 Catch:{ all -> 0x00c5 }
        monitor-exit(r5);	 Catch:{ all -> 0x00c5 }
        r6 = 0;
        r4 = new java.net.URL;	 Catch:{ IOException -> 0x0121 }
        r0 = r27;
        r4.<init>(r0);	 Catch:{ IOException -> 0x0121 }
        r5 = r4.openConnection();	 Catch:{ IOException -> 0x0121 }
        r4 = com.google.android.gms.internal.zzbz.zztS;	 Catch:{ IOException -> 0x0121 }
        r4 = r4.get();	 Catch:{ IOException -> 0x0121 }
        r4 = (java.lang.Integer) r4;	 Catch:{ IOException -> 0x0121 }
        r4 = r4.intValue();	 Catch:{ IOException -> 0x0121 }
        r5.setConnectTimeout(r4);	 Catch:{ IOException -> 0x0121 }
        r5.setReadTimeout(r4);	 Catch:{ IOException -> 0x0121 }
        r4 = r5 instanceof java.net.HttpURLConnection;	 Catch:{ IOException -> 0x0121 }
        if (r4 == 0) goto L_0x017f;
    L_0x00f0:
        r0 = r5;
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ IOException -> 0x0121 }
        r4 = r0;
        r4 = r4.getResponseCode();	 Catch:{ IOException -> 0x0121 }
        r10 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r4 < r10) goto L_0x017f;
    L_0x00fc:
        r5 = new java.io.IOException;	 Catch:{ IOException -> 0x0121 }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0121 }
        r8.<init>();	 Catch:{ IOException -> 0x0121 }
        r10 = "HTTP status code ";
        r8 = r8.append(r10);	 Catch:{ IOException -> 0x0121 }
        r4 = r8.append(r4);	 Catch:{ IOException -> 0x0121 }
        r8 = " at ";
        r4 = r4.append(r8);	 Catch:{ IOException -> 0x0121 }
        r0 = r27;
        r4 = r4.append(r0);	 Catch:{ IOException -> 0x0121 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0121 }
        r5.<init>(r4);	 Catch:{ IOException -> 0x0121 }
        throw r5;	 Catch:{ IOException -> 0x0121 }
    L_0x0121:
        r4 = move-exception;
        r5 = r6;
    L_0x0123:
        r5.close();	 Catch:{ IOException -> 0x0312, NullPointerException -> 0x0315 }
    L_0x0126:
        r0 = r26;
        r5 = r0.zzwI;
        if (r5 == 0) goto L_0x02f2;
    L_0x012c:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Preload aborted for URL \"";
        r4 = r4.append(r5);
        r0 = r27;
        r4 = r4.append(r0);
        r5 = "\"";
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.google.android.gms.ads.internal.util.client.zzb.zzaA(r4);
    L_0x014a:
        r4 = r7.exists();
        if (r4 == 0) goto L_0x0170;
    L_0x0150:
        r4 = r7.delete();
        if (r4 != 0) goto L_0x0170;
    L_0x0156:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Could not delete partial cache file at ";
        r4 = r4.append(r5);
        r5 = r7.getAbsolutePath();
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.google.android.gms.ads.internal.util.client.zzb.zzaC(r4);
    L_0x0170:
        r0 = r26;
        r1 = r27;
        r0.zza(r1, r7);
        r4 = zzwF;
        r4.remove(r9);
        r4 = 0;
        goto L_0x000f;
    L_0x017f:
        r10 = r5.getContentLength();	 Catch:{ IOException -> 0x0121 }
        if (r10 >= 0) goto L_0x01ac;
    L_0x0185:
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0121 }
        r4.<init>();	 Catch:{ IOException -> 0x0121 }
        r5 = "Stream cache aborted, missing content-length header at ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0121 }
        r0 = r27;
        r4 = r4.append(r0);	 Catch:{ IOException -> 0x0121 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0121 }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC(r4);	 Catch:{ IOException -> 0x0121 }
        r0 = r26;
        r1 = r27;
        r0.zza(r1, r7);	 Catch:{ IOException -> 0x0121 }
        r4 = zzwF;	 Catch:{ IOException -> 0x0121 }
        r4.remove(r9);	 Catch:{ IOException -> 0x0121 }
        r4 = 0;
        goto L_0x000f;
    L_0x01ac:
        r4 = zzwG;	 Catch:{ IOException -> 0x0121 }
        r12 = (long) r10;	 Catch:{ IOException -> 0x0121 }
        r11 = r4.format(r12);	 Catch:{ IOException -> 0x0121 }
        r4 = com.google.android.gms.internal.zzbz.zztP;	 Catch:{ IOException -> 0x0121 }
        r4 = r4.get();	 Catch:{ IOException -> 0x0121 }
        r4 = (java.lang.Integer) r4;	 Catch:{ IOException -> 0x0121 }
        r12 = r4.intValue();	 Catch:{ IOException -> 0x0121 }
        if (r10 <= r12) goto L_0x01f2;
    L_0x01c1:
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0121 }
        r4.<init>();	 Catch:{ IOException -> 0x0121 }
        r5 = "Content length ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0121 }
        r4 = r4.append(r11);	 Catch:{ IOException -> 0x0121 }
        r5 = " exceeds limit at ";
        r4 = r4.append(r5);	 Catch:{ IOException -> 0x0121 }
        r0 = r27;
        r4 = r4.append(r0);	 Catch:{ IOException -> 0x0121 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0121 }
        com.google.android.gms.ads.internal.util.client.zzb.zzaC(r4);	 Catch:{ IOException -> 0x0121 }
        r0 = r26;
        r1 = r27;
        r0.zza(r1, r7);	 Catch:{ IOException -> 0x0121 }
        r4 = zzwF;	 Catch:{ IOException -> 0x0121 }
        r4.remove(r9);	 Catch:{ IOException -> 0x0121 }
        r4 = 0;
        goto L_0x000f;
    L_0x01f2:
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0121 }
        r4.<init>();	 Catch:{ IOException -> 0x0121 }
        r13 = "Caching ";
        r4 = r4.append(r13);	 Catch:{ IOException -> 0x0121 }
        r4 = r4.append(r11);	 Catch:{ IOException -> 0x0121 }
        r11 = " bytes from ";
        r4 = r4.append(r11);	 Catch:{ IOException -> 0x0121 }
        r0 = r27;
        r4 = r4.append(r0);	 Catch:{ IOException -> 0x0121 }
        r4 = r4.toString();	 Catch:{ IOException -> 0x0121 }
        com.google.android.gms.ads.internal.util.client.zzb.zzay(r4);	 Catch:{ IOException -> 0x0121 }
        r4 = r5.getInputStream();	 Catch:{ IOException -> 0x0121 }
        r11 = java.nio.channels.Channels.newChannel(r4);	 Catch:{ IOException -> 0x0121 }
        r5 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0121 }
        r5.<init>(r7);	 Catch:{ IOException -> 0x0121 }
        r13 = r5.getChannel();	 Catch:{ IOException -> 0x0267 }
        r4 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;
        r14 = java.nio.ByteBuffer.allocate(r4);	 Catch:{ IOException -> 0x0267 }
        r15 = com.google.android.gms.ads.internal.zzo.zzbz();	 Catch:{ IOException -> 0x0267 }
        r6 = 0;
        r16 = r15.currentTimeMillis();	 Catch:{ IOException -> 0x0267 }
        r4 = com.google.android.gms.internal.zzbz.zztR;	 Catch:{ IOException -> 0x0267 }
        r4 = r4.get();	 Catch:{ IOException -> 0x0267 }
        r4 = (java.lang.Long) r4;	 Catch:{ IOException -> 0x0267 }
        r18 = r4.longValue();	 Catch:{ IOException -> 0x0267 }
        r20 = new com.google.android.gms.internal.zzhq;	 Catch:{ IOException -> 0x0267 }
        r0 = r20;
        r1 = r18;
        r0.<init>(r1);	 Catch:{ IOException -> 0x0267 }
        r4 = com.google.android.gms.internal.zzbz.zztQ;	 Catch:{ IOException -> 0x0267 }
        r4 = r4.get();	 Catch:{ IOException -> 0x0267 }
        r4 = (java.lang.Long) r4;	 Catch:{ IOException -> 0x0267 }
        r18 = r4.longValue();	 Catch:{ IOException -> 0x0267 }
        r4 = r6;
    L_0x0256:
        r6 = r11.read(r14);	 Catch:{ IOException -> 0x0267 }
        if (r6 < 0) goto L_0x02a8;
    L_0x025c:
        r4 = r4 + r6;
        if (r4 <= r12) goto L_0x026a;
    L_0x025f:
        r4 = new java.io.IOException;	 Catch:{ IOException -> 0x0267 }
        r6 = "stream cache file size limit exceeded";
        r4.<init>(r6);	 Catch:{ IOException -> 0x0267 }
        throw r4;	 Catch:{ IOException -> 0x0267 }
    L_0x0267:
        r4 = move-exception;
        goto L_0x0123;
    L_0x026a:
        r14.flip();	 Catch:{ IOException -> 0x0267 }
    L_0x026d:
        r6 = r13.write(r14);	 Catch:{ IOException -> 0x0267 }
        if (r6 > 0) goto L_0x026d;
    L_0x0273:
        r14.clear();	 Catch:{ IOException -> 0x0267 }
        r22 = r15.currentTimeMillis();	 Catch:{ IOException -> 0x0267 }
        r22 = r22 - r16;
        r24 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r24 = r24 * r18;
        r6 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1));
        if (r6 <= 0) goto L_0x028c;
    L_0x0284:
        r4 = new java.io.IOException;	 Catch:{ IOException -> 0x0267 }
        r6 = "stream cache time limit exceeded";
        r4.<init>(r6);	 Catch:{ IOException -> 0x0267 }
        throw r4;	 Catch:{ IOException -> 0x0267 }
    L_0x028c:
        r0 = r26;
        r6 = r0.zzwI;	 Catch:{ IOException -> 0x0267 }
        if (r6 == 0) goto L_0x029a;
    L_0x0292:
        r4 = new java.io.IOException;	 Catch:{ IOException -> 0x0267 }
        r6 = "abort requested";
        r4.<init>(r6);	 Catch:{ IOException -> 0x0267 }
        throw r4;	 Catch:{ IOException -> 0x0267 }
    L_0x029a:
        r6 = r20.tryAcquire();	 Catch:{ IOException -> 0x0267 }
        if (r6 == 0) goto L_0x0256;
    L_0x02a0:
        r0 = r26;
        r1 = r27;
        r0.zza(r1, r7, r4, r10);	 Catch:{ IOException -> 0x0267 }
        goto L_0x0256;
    L_0x02a8:
        r5.close();	 Catch:{ IOException -> 0x0267 }
        r6 = 3;
        r6 = com.google.android.gms.ads.internal.util.client.zzb.zzL(r6);	 Catch:{ IOException -> 0x0267 }
        if (r6 == 0) goto L_0x02db;
    L_0x02b2:
        r6 = zzwG;	 Catch:{ IOException -> 0x0267 }
        r10 = (long) r4;	 Catch:{ IOException -> 0x0267 }
        r6 = r6.format(r10);	 Catch:{ IOException -> 0x0267 }
        r10 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0267 }
        r10.<init>();	 Catch:{ IOException -> 0x0267 }
        r11 = "Preloaded ";
        r10 = r10.append(r11);	 Catch:{ IOException -> 0x0267 }
        r6 = r10.append(r6);	 Catch:{ IOException -> 0x0267 }
        r10 = " bytes from ";
        r6 = r6.append(r10);	 Catch:{ IOException -> 0x0267 }
        r0 = r27;
        r6 = r6.append(r0);	 Catch:{ IOException -> 0x0267 }
        r6 = r6.toString();	 Catch:{ IOException -> 0x0267 }
        com.google.android.gms.ads.internal.util.client.zzb.zzay(r6);	 Catch:{ IOException -> 0x0267 }
    L_0x02db:
        r6 = 1;
        r10 = 0;
        r7.setReadable(r6, r10);	 Catch:{ IOException -> 0x0267 }
        zzb(r8);	 Catch:{ IOException -> 0x0267 }
        r0 = r26;
        r1 = r27;
        r0.zza(r1, r7, r4);	 Catch:{ IOException -> 0x0267 }
        r4 = zzwF;	 Catch:{ IOException -> 0x0267 }
        r4.remove(r9);	 Catch:{ IOException -> 0x0267 }
        r4 = 1;
        goto L_0x000f;
    L_0x02f2:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "Preload failed for URL \"";
        r5 = r5.append(r6);
        r0 = r27;
        r5 = r5.append(r0);
        r6 = "\"";
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.google.android.gms.ads.internal.util.client.zzb.zzd(r5, r4);
        goto L_0x014a;
    L_0x0312:
        r5 = move-exception;
        goto L_0x0126;
    L_0x0315:
        r5 = move-exception;
        goto L_0x0126;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdr.zzW(java.lang.String):boolean");
    }

    public int zzdQ() {
        int i = 0;
        if (this.zzwH != null) {
            for (File name : this.zzwH.listFiles()) {
                if (!name.getName().endsWith(".done")) {
                    i++;
                }
            }
        }
        return i;
    }

    public boolean zzdR() {
        if (this.zzwH == null) {
            return false;
        }
        boolean delete;
        File file = null;
        long j = Long.MAX_VALUE;
        File[] listFiles = this.zzwH.listFiles();
        int length = listFiles.length;
        int i = 0;
        while (i < length) {
            long lastModified;
            File file2;
            File file3 = listFiles[i];
            if (!file3.getName().endsWith(".done")) {
                lastModified = file3.lastModified();
                if (lastModified < j) {
                    file2 = file3;
                    i++;
                    file = file2;
                    j = lastModified;
                }
            }
            lastModified = j;
            file2 = file;
            i++;
            file = file2;
            j = lastModified;
        }
        if (file != null) {
            delete = file.delete();
            File zza = zza(file);
            if (zza.isFile()) {
                delete &= zza.delete();
            }
        } else {
            delete = false;
        }
        return delete;
    }
}
