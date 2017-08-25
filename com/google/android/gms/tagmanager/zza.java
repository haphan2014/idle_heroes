package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzld;
import java.io.IOException;

class zza {
    private static Object zzaKl = new Object();
    private static zza zzaKm;
    private volatile boolean mClosed;
    private final Context mContext;
    private final Thread zzFZ;
    private volatile Info zzJl;
    private volatile long zzaKh;
    private volatile long zzaKi;
    private volatile long zzaKj;
    private zza zzaKk;
    private final zzlb zzpw;

    public interface zza {
        Info zzyg();
    }

    class C11471 implements zza {
        final /* synthetic */ zza zzaKn;

        C11471(zza com_google_android_gms_tagmanager_zza) {
            this.zzaKn = com_google_android_gms_tagmanager_zza;
        }

        public Info zzyg() {
            Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(this.zzaKn.mContext);
            } catch (IllegalStateException e) {
                zzbg.zzaC("IllegalStateException getting Advertising Id Info");
            } catch (GooglePlayServicesRepairableException e2) {
                zzbg.zzaC("GooglePlayServicesRepairableException getting Advertising Id Info");
            } catch (IOException e3) {
                zzbg.zzaC("IOException getting Ad Id Info");
            } catch (GooglePlayServicesNotAvailableException e4) {
                zzbg.zzaC("GooglePlayServicesNotAvailableException getting Advertising Id Info");
            } catch (Exception e5) {
                zzbg.zzaC("Unknown exception. Could not get the Advertising Id Info.");
            }
            return info;
        }
    }

    class C11482 implements Runnable {
        final /* synthetic */ zza zzaKn;

        C11482(zza com_google_android_gms_tagmanager_zza) {
            this.zzaKn = com_google_android_gms_tagmanager_zza;
        }

        public void run() {
            this.zzaKn.zzye();
        }
    }

    private zza(Context context) {
        this(context, null, zzld.zzoQ());
    }

    zza(Context context, zza com_google_android_gms_tagmanager_zza_zza, zzlb com_google_android_gms_internal_zzlb) {
        this.zzaKh = 900000;
        this.zzaKi = 30000;
        this.mClosed = false;
        this.zzaKk = new C11471(this);
        this.zzpw = com_google_android_gms_internal_zzlb;
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        if (com_google_android_gms_tagmanager_zza_zza != null) {
            this.zzaKk = com_google_android_gms_tagmanager_zza_zza;
        }
        this.zzFZ = new Thread(new C11482(this));
    }

    static zza zzaE(Context context) {
        if (zzaKm == null) {
            synchronized (zzaKl) {
                if (zzaKm == null) {
                    zzaKm = new zza(context);
                    zzaKm.start();
                }
            }
        }
        return zzaKm;
    }

    private void zzye() {
        Process.setThreadPriority(10);
        while (!this.mClosed) {
            try {
                this.zzJl = this.zzaKk.zzyg();
                Thread.sleep(this.zzaKh);
            } catch (InterruptedException e) {
                zzbg.zzaA("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }

    private void zzyf() {
        if (this.zzpw.currentTimeMillis() - this.zzaKj >= this.zzaKi) {
            interrupt();
            this.zzaKj = this.zzpw.currentTimeMillis();
        }
    }

    void interrupt() {
        this.zzFZ.interrupt();
    }

    public boolean isLimitAdTrackingEnabled() {
        zzyf();
        return this.zzJl == null ? true : this.zzJl.isLimitAdTrackingEnabled();
    }

    void start() {
        this.zzFZ.start();
    }

    public String zzyd() {
        zzyf();
        return this.zzJl == null ? null : this.zzJl.getId();
    }
}
