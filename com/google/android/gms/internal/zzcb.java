package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Environment;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class zzcb {
    private final Context mContext;
    private final String zzqr;
    private int zzuA;
    private int zzuB;
    private int zzuC;
    private String zzuD;
    private BlockingQueue<zzce> zzuF;
    private ExecutorService zzuG;
    private LinkedHashMap<String, String> zzuH = new LinkedHashMap();
    private AtomicBoolean zzuI;
    private File zzuJ;
    private int zzuz;

    class C08581 implements Runnable {
        final /* synthetic */ zzcb zzuK;

        C08581(zzcb com_google_android_gms_internal_zzcb) {
            this.zzuK = com_google_android_gms_internal_zzcb;
        }

        public void run() {
            this.zzuK.zzdl();
        }
    }

    public zzcb(Context context, String str, String str2, int i, int i2, int i3, int i4, Map<String, String> map, int i5) {
        this.mContext = context;
        this.zzqr = str;
        this.zzuD = str2;
        this.zzuA = i;
        this.zzuB = i2;
        this.zzuC = i3;
        zzq(i4);
        this.zzuI = new AtomicBoolean(false);
        this.zzuI.set(((Boolean) zzbz.zzub.get()).booleanValue());
        if (this.zzuI.get()) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory != null) {
                this.zzuJ = new File(externalStorageDirectory, "sdk_csi_data.txt");
            }
        }
        for (Entry entry : map.entrySet()) {
            zzd((String) entry.getKey(), (String) entry.getValue());
        }
        if (i5 == 1) {
            zzdj();
        }
        if (i5 == 2) {
            zzdk();
        }
        init();
    }

    private void init() {
        this.zzuF = new ArrayBlockingQueue(this.zzuA);
        this.zzuG = Executors.newSingleThreadExecutor();
        this.zzuG.execute(new C08581(this));
    }

    private void zza(File file, String str) {
        FileOutputStream fileOutputStream;
        Throwable e;
        if (file != null) {
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.write(10);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            return;
                        } catch (Throwable e2) {
                            zzb.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e2);
                            return;
                        }
                    }
                    return;
                } catch (IOException e3) {
                    e2 = e3;
                    try {
                        zzb.zzd("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e2);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                                return;
                            } catch (Throwable e22) {
                                zzb.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e22);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e22 = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e4) {
                                zzb.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                            }
                        }
                        throw e22;
                    }
                }
            } catch (IOException e5) {
                e22 = e5;
                fileOutputStream = null;
                zzb.zzd("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e22);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    return;
                }
                return;
            } catch (Throwable th2) {
                e22 = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e22;
            }
        }
        zzb.zzaC("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
    }

    private void zzb(List<String> list) {
        if (list != null && !list.isEmpty()) {
            zzd("eid", TextUtils.join(",", list));
        }
    }

    private boolean zzc(Map<String, String> map) {
        boolean z = false;
        int i = 0;
        while (!z && i < this.zzuB) {
            try {
                Thread.sleep((long) this.zzuC);
                String zza = zza(this.zzuD, (Map) map);
                if (this.zzuI.get()) {
                    zza(this.zzuJ, zza);
                } else {
                    zzo.zzbv().zzc(this.mContext, this.zzqr, zza);
                }
                z = true;
            } catch (Throwable e) {
                zzb.zzd("CsiReporter: interrupted in sendReport()", e);
                Thread.currentThread().interrupt();
            }
            i++;
        }
        return z;
    }

    private void zzdj() {
        zzb(zzbz.zzdb());
    }

    private void zzdk() {
        zzb(zzbz.zzx(this.mContext));
    }

    private void zzdl() {
        while (true) {
            try {
                List zzp = zzp(this.zzuz);
                if (zzp != null) {
                    for (Map zzc : zzc(zzp).values()) {
                        zzc(zzc);
                    }
                }
            } catch (Throwable e) {
                zzb.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    private List<zzce> zzp(int i) throws InterruptedException {
        List<zzce> arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(this.zzuF.take());
        }
        return arrayList;
    }

    private void zzq(int i) {
        if (i < 1) {
            zzb.zzaC("CsiReporter - too small batch size :" + i + ", changed to 1");
            i = 1;
        }
        if (i > this.zzuA) {
            zzb.zzaC("CsiReporter - batch size :" + i + " bigger than buffer size, " + "change to buffer limit");
            i = this.zzuA;
        }
        this.zzuz = i;
    }

    String zza(String str, Map<String, String> map) {
        Builder buildUpon = Uri.parse(str).buildUpon();
        for (Entry entry : map.entrySet()) {
            buildUpon.appendQueryParameter((String) entry.getKey(), (String) entry.getValue());
        }
        return buildUpon.build().toString();
    }

    public boolean zza(zzce com_google_android_gms_internal_zzce) {
        return this.zzuF.offer(com_google_android_gms_internal_zzce);
    }

    Map<String, Map<String, String>> zzc(List<zzce> list) {
        Map linkedHashMap = new LinkedHashMap();
        for (zzce com_google_android_gms_internal_zzce : list) {
            String zzdr = com_google_android_gms_internal_zzce.zzdr();
            if (linkedHashMap.containsKey(zzdr)) {
                ((List) linkedHashMap.get(zzdr)).add(com_google_android_gms_internal_zzce);
            } else {
                List arrayList = new ArrayList();
                arrayList.add(com_google_android_gms_internal_zzce);
                linkedHashMap.put(zzdr, arrayList);
            }
        }
        Map<String, Map<String, String>> linkedHashMap2 = new LinkedHashMap();
        for (Entry entry : linkedHashMap.entrySet()) {
            List list2 = (List) entry.getValue();
            Map linkedHashMap3 = new LinkedHashMap(this.zzuH);
            try {
                linkedHashMap3.putAll(zzce.zza((zzce[]) list2.toArray(new zzce[list2.size()])));
                linkedHashMap2.put(entry.getKey(), linkedHashMap3);
            } catch (Throwable e) {
                zzb.zzd("CsiReporter:failed to merge tickers:" + list2, e);
            }
        }
        return linkedHashMap2;
    }

    void zzd(String str, String str2) {
        this.zzuH.put(str, str2);
    }
}
