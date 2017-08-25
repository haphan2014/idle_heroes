package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzu;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@zzgd
public class zzdt {
    private final Context mContext;
    private final VersionInfoParcel zzoM;
    private final Object zzqt;
    private final String zzwO;
    private zzb<zzbb> zzwP;
    private zzb<zzbb> zzwQ;
    private zze zzwR;
    private int zzwS;

    public interface zzb<T> {
        void zzc(T t);
    }

    static class zza {
        static int zzxc = 60000;
        static int zzxd = 10000;
    }

    public static class zzc<T> implements zzb<T> {
        public void zzc(T t) {
        }
    }

    public static class zzd extends zzhy<zzbe> {
        private final Object zzqt = new Object();
        private final zze zzxe;
        private boolean zzxf;

        class C08841 implements com.google.android.gms.internal.zzhx.zzc<zzbe> {
            final /* synthetic */ zzd zzxg;

            C08841(zzd com_google_android_gms_internal_zzdt_zzd) {
                this.zzxg = com_google_android_gms_internal_zzdt_zzd;
            }

            public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("Ending javascript session.");
                ((zzbf) com_google_android_gms_internal_zzbe).zzcg();
            }

            public /* synthetic */ void zzc(Object obj) {
                zzb((zzbe) obj);
            }
        }

        class C08852 implements com.google.android.gms.internal.zzhx.zzc<zzbe> {
            final /* synthetic */ zzd zzxg;

            C08852(zzd com_google_android_gms_internal_zzdt_zzd) {
                this.zzxg = com_google_android_gms_internal_zzdt_zzd;
            }

            public void zzb(zzbe com_google_android_gms_internal_zzbe) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("Releasing engine reference.");
                this.zzxg.zzxe.zzdW();
            }

            public /* synthetic */ void zzc(Object obj) {
                zzb((zzbe) obj);
            }
        }

        class C08863 implements com.google.android.gms.internal.zzhx.zza {
            final /* synthetic */ zzd zzxg;

            C08863(zzd com_google_android_gms_internal_zzdt_zzd) {
                this.zzxg = com_google_android_gms_internal_zzdt_zzd;
            }

            public void run() {
                this.zzxg.zzxe.zzdW();
            }
        }

        public zzd(zze com_google_android_gms_internal_zzdt_zze) {
            this.zzxe = com_google_android_gms_internal_zzdt_zze;
        }

        public void release() {
            synchronized (this.zzqt) {
                if (this.zzxf) {
                    return;
                }
                this.zzxf = true;
                zza(new C08841(this), new com.google.android.gms.internal.zzhx.zzb());
                zza(new C08852(this), new C08863(this));
            }
        }
    }

    public static class zze extends zzhy<zzbb> {
        private final Object zzqt = new Object();
        private zzb<zzbb> zzwQ;
        private boolean zzxh;
        private int zzxi;

        class C08903 implements com.google.android.gms.internal.zzhx.zzc<zzbb> {
            final /* synthetic */ zze zzxk;

            C08903(zze com_google_android_gms_internal_zzdt_zze) {
                this.zzxk = com_google_android_gms_internal_zzdt_zze;
            }

            public void zza(final zzbb com_google_android_gms_internal_zzbb) {
                zzhl.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ C08903 zzxl;

                    public void run() {
                        this.zzxl.zzxk.zzwQ.zzc(com_google_android_gms_internal_zzbb);
                        com_google_android_gms_internal_zzbb.destroy();
                    }
                });
            }

            public /* synthetic */ void zzc(Object obj) {
                zza((zzbb) obj);
            }
        }

        public zze(zzb<zzbb> com_google_android_gms_internal_zzdt_zzb_com_google_android_gms_internal_zzbb) {
            this.zzwQ = com_google_android_gms_internal_zzdt_zzb_com_google_android_gms_internal_zzbb;
            this.zzxh = false;
            this.zzxi = 0;
        }

        public zzd zzdV() {
            final zzd com_google_android_gms_internal_zzdt_zzd = new zzd(this);
            synchronized (this.zzqt) {
                zza(new com.google.android.gms.internal.zzhx.zzc<zzbb>(this) {
                    final /* synthetic */ zze zzxk;

                    public void zza(zzbb com_google_android_gms_internal_zzbb) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaB("Getting a new session for JS Engine.");
                        com_google_android_gms_internal_zzdt_zzd.zzg(com_google_android_gms_internal_zzbb.zzce());
                    }

                    public /* synthetic */ void zzc(Object obj) {
                        zza((zzbb) obj);
                    }
                }, new com.google.android.gms.internal.zzhx.zza(this) {
                    final /* synthetic */ zze zzxk;

                    public void run() {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaB("Rejecting reference for JS Engine.");
                        com_google_android_gms_internal_zzdt_zzd.reject();
                    }
                });
                zzu.zzU(this.zzxi >= 0);
                this.zzxi++;
            }
            return com_google_android_gms_internal_zzdt_zzd;
        }

        protected void zzdW() {
            boolean z = true;
            synchronized (this.zzqt) {
                if (this.zzxi < 1) {
                    z = false;
                }
                zzu.zzU(z);
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("Releasing 1 reference for JS Engine");
                this.zzxi--;
                zzdY();
            }
        }

        public void zzdX() {
            boolean z = true;
            synchronized (this.zzqt) {
                if (this.zzxi < 0) {
                    z = false;
                }
                zzu.zzU(z);
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzxh = true;
                zzdY();
            }
        }

        protected void zzdY() {
            synchronized (this.zzqt) {
                zzu.zzU(this.zzxi >= 0);
                if (this.zzxh && this.zzxi == 0) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB("No reference is left (including root). Cleaning up engine.");
                    zza(new C08903(this), new com.google.android.gms.internal.zzhx.zzb());
                } else {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB("There are still references to the engine. Not destroying.");
                }
            }
        }
    }

    public zzdt(Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zzqt = new Object();
        this.zzwS = 1;
        this.zzwO = str;
        this.mContext = context.getApplicationContext();
        this.zzoM = versionInfoParcel;
        this.zzwP = new zzc();
        this.zzwQ = new zzc();
    }

    public zzdt(Context context, VersionInfoParcel versionInfoParcel, String str, zzb<zzbb> com_google_android_gms_internal_zzdt_zzb_com_google_android_gms_internal_zzbb, zzb<zzbb> com_google_android_gms_internal_zzdt_zzb_com_google_android_gms_internal_zzbb2) {
        this(context, versionInfoParcel, str);
        this.zzwP = com_google_android_gms_internal_zzdt_zzb_com_google_android_gms_internal_zzbb;
        this.zzwQ = com_google_android_gms_internal_zzdt_zzb_com_google_android_gms_internal_zzbb2;
    }

    private zze zzdS() {
        final zze com_google_android_gms_internal_zzdt_zze = new zze(this.zzwQ);
        zzhl.runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzdt zzwU;

            public void run() {
                final zzbb zza = this.zzwU.zza(this.zzwU.mContext, this.zzwU.zzoM);
                zza.zza(new com.google.android.gms.internal.zzbb.zza(this) {
                    final /* synthetic */ C08811 zzwW;

                    class C08751 extends TimerTask {
                        final /* synthetic */ C08761 zzwX;

                        class C08741 implements Runnable {
                            final /* synthetic */ C08751 zzwY;

                            C08741(C08751 c08751) {
                                this.zzwY = c08751;
                            }

                            public void run() {
                                zza.destroy();
                            }
                        }

                        C08751(C08761 c08761) {
                            this.zzwX = c08761;
                        }

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void run() {
                            /*
                            r3 = this;
                            r0 = r3.zzwX;
                            r0 = r0.zzwW;
                            r0 = r0.zzwU;
                            r1 = r0.zzqt;
                            monitor-enter(r1);
                            r0 = r3.zzwX;	 Catch:{ all -> 0x003f }
                            r0 = r0.zzwW;	 Catch:{ all -> 0x003f }
                            r0 = r0;	 Catch:{ all -> 0x003f }
                            r0 = r0.getStatus();	 Catch:{ all -> 0x003f }
                            r2 = -1;
                            if (r0 == r2) goto L_0x0025;
                        L_0x0018:
                            r0 = r3.zzwX;	 Catch:{ all -> 0x003f }
                            r0 = r0.zzwW;	 Catch:{ all -> 0x003f }
                            r0 = r0;	 Catch:{ all -> 0x003f }
                            r0 = r0.getStatus();	 Catch:{ all -> 0x003f }
                            r2 = 1;
                            if (r0 != r2) goto L_0x0027;
                        L_0x0025:
                            monitor-exit(r1);	 Catch:{ all -> 0x003f }
                        L_0x0026:
                            return;
                        L_0x0027:
                            r0 = r3.zzwX;	 Catch:{ all -> 0x003f }
                            r0 = r0.zzwW;	 Catch:{ all -> 0x003f }
                            r0 = r0;	 Catch:{ all -> 0x003f }
                            r0.reject();	 Catch:{ all -> 0x003f }
                            r0 = new com.google.android.gms.internal.zzdt$1$1$1$1;	 Catch:{ all -> 0x003f }
                            r0.<init>(r3);	 Catch:{ all -> 0x003f }
                            com.google.android.gms.internal.zzhl.runOnUiThread(r0);	 Catch:{ all -> 0x003f }
                            r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                            com.google.android.gms.ads.internal.util.client.zzb.zzaB(r0);	 Catch:{ all -> 0x003f }
                            monitor-exit(r1);	 Catch:{ all -> 0x003f }
                            goto L_0x0026;
                        L_0x003f:
                            r0 = move-exception;
                            monitor-exit(r1);	 Catch:{ all -> 0x003f }
                            throw r0;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdt.1.1.1.run():void");
                        }
                    }

                    public void zzcf() {
                        new Timer().schedule(new C08751(this), (long) zza.zzxd);
                    }
                });
                zza.zza("/jsLoaded", new zzdg(this) {
                    final /* synthetic */ C08811 zzwW;

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void zza(com.google.android.gms.internal.zzid r4, java.util.Map<java.lang.String, java.lang.String> r5) {
                        /*
                        r3 = this;
                        r0 = r3.zzwW;
                        r0 = r0.zzwU;
                        r1 = r0.zzqt;
                        monitor-enter(r1);
                        r0 = r3.zzwW;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0051 }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.zzwW;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0051 }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.zzwW;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzwU;	 Catch:{ all -> 0x0051 }
                        r2 = 0;
                        r0.zzwS = r2;	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzwW;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzwU;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzwP;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzc(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzwW;	 Catch:{ all -> 0x0051 }
                        r0 = r0;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzg(r2);	 Catch:{ all -> 0x0051 }
                        r0 = r3.zzwW;	 Catch:{ all -> 0x0051 }
                        r0 = r0.zzwU;	 Catch:{ all -> 0x0051 }
                        r2 = r3.zzwW;	 Catch:{ all -> 0x0051 }
                        r2 = r0;	 Catch:{ all -> 0x0051 }
                        r0.zzwR = r2;	 Catch:{ all -> 0x0051 }
                        r0 = "Successfully loaded JS Engine.";
                        com.google.android.gms.ads.internal.util.client.zzb.zzaB(r0);	 Catch:{ all -> 0x0051 }
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        goto L_0x0020;
                    L_0x0051:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x0051 }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdt.1.2.zza(com.google.android.gms.internal.zzid, java.util.Map):void");
                    }
                });
                final zzhr com_google_android_gms_internal_zzhr = new zzhr();
                zzdg c08783 = new zzdg(this) {
                    final /* synthetic */ C08811 zzwW;

                    public void zza(zzid com_google_android_gms_internal_zzid, Map<String, String> map) {
                        synchronized (this.zzwW.zzwU.zzqt) {
                            com.google.android.gms.ads.internal.util.client.zzb.zzaA("JS Engine is requesting an update");
                            if (this.zzwW.zzwU.zzwS == 0) {
                                com.google.android.gms.ads.internal.util.client.zzb.zzaA("Starting reload.");
                                this.zzwW.zzwU.zzwS = 2;
                                this.zzwW.zzwU.zzdT();
                            }
                            zza.zzb("/requestReload", (zzdg) com_google_android_gms_internal_zzhr.get());
                        }
                    }
                };
                com_google_android_gms_internal_zzhr.set(c08783);
                zza.zza("/requestReload", c08783);
                if (this.zzwU.zzwO.endsWith(".js")) {
                    zza.zzr(this.zzwU.zzwO);
                } else if (this.zzwU.zzwO.startsWith("<html>")) {
                    zza.zzt(this.zzwU.zzwO);
                } else {
                    zza.zzs(this.zzwU.zzwO);
                }
                new Timer().schedule(new TimerTask(this) {
                    final /* synthetic */ C08811 zzwW;

                    class C08791 implements Runnable {
                        final /* synthetic */ C08804 zzxa;

                        C08791(C08804 c08804) {
                            this.zzxa = c08804;
                        }

                        public void run() {
                            zza.destroy();
                        }
                    }

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                        r3 = this;
                        r0 = r3.zzwW;
                        r0 = r0.zzwU;
                        r1 = r0.zzqt;
                        monitor-enter(r1);
                        r0 = r3.zzwW;	 Catch:{ all -> 0x0037 }
                        r0 = r0;	 Catch:{ all -> 0x0037 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0037 }
                        r2 = -1;
                        if (r0 == r2) goto L_0x001f;
                    L_0x0014:
                        r0 = r3.zzwW;	 Catch:{ all -> 0x0037 }
                        r0 = r0;	 Catch:{ all -> 0x0037 }
                        r0 = r0.getStatus();	 Catch:{ all -> 0x0037 }
                        r2 = 1;
                        if (r0 != r2) goto L_0x0021;
                    L_0x001f:
                        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
                    L_0x0020:
                        return;
                    L_0x0021:
                        r0 = r3.zzwW;	 Catch:{ all -> 0x0037 }
                        r0 = r0;	 Catch:{ all -> 0x0037 }
                        r0.reject();	 Catch:{ all -> 0x0037 }
                        r0 = new com.google.android.gms.internal.zzdt$1$4$1;	 Catch:{ all -> 0x0037 }
                        r0.<init>(r3);	 Catch:{ all -> 0x0037 }
                        com.google.android.gms.internal.zzhl.runOnUiThread(r0);	 Catch:{ all -> 0x0037 }
                        r0 = "Could not receive loaded message in a timely manner. Rejecting.";
                        com.google.android.gms.ads.internal.util.client.zzb.zzaB(r0);	 Catch:{ all -> 0x0037 }
                        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
                        goto L_0x0020;
                    L_0x0037:
                        r0 = move-exception;
                        monitor-exit(r1);	 Catch:{ all -> 0x0037 }
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdt.1.4.run():void");
                    }
                }, (long) zza.zzxc);
            }
        });
        return com_google_android_gms_internal_zzdt_zze;
    }

    protected zzbb zza(Context context, VersionInfoParcel versionInfoParcel) {
        return new zzbd(context, versionInfoParcel);
    }

    protected zze zzdT() {
        final zze zzdS = zzdS();
        zzdS.zza(new com.google.android.gms.internal.zzhx.zzc<zzbb>(this) {
            final /* synthetic */ zzdt zzwU;

            public void zza(zzbb com_google_android_gms_internal_zzbb) {
                synchronized (this.zzwU.zzqt) {
                    this.zzwU.zzwS = 0;
                    if (!(this.zzwU.zzwR == null || zzdS == this.zzwU.zzwR)) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaB("New JS engine is loaded, marking previous one as destroyable.");
                        this.zzwU.zzwR.zzdX();
                    }
                    this.zzwU.zzwR = zzdS;
                }
            }

            public /* synthetic */ void zzc(Object obj) {
                zza((zzbb) obj);
            }
        }, new com.google.android.gms.internal.zzhx.zza(this) {
            final /* synthetic */ zzdt zzwU;

            public void run() {
                synchronized (this.zzwU.zzqt) {
                    this.zzwU.zzwS = 1;
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB("Failed loading new engine. Marking new engine destroyable.");
                    zzdS.zzdX();
                }
            }
        });
        return zzdS;
    }

    public zzd zzdU() {
        zzd zzdV;
        synchronized (this.zzqt) {
            if (this.zzwR == null || this.zzwR.getStatus() == -1) {
                this.zzwS = 2;
                this.zzwR = zzdT();
                zzdV = this.zzwR.zzdV();
            } else if (this.zzwS == 0) {
                zzdV = this.zzwR.zzdV();
            } else if (this.zzwS == 1) {
                this.zzwS = 2;
                zzdT();
                zzdV = this.zzwR.zzdV();
            } else if (this.zzwS == 2) {
                zzdV = this.zzwR.zzdV();
            } else {
                zzdV = this.zzwR.zzdV();
            }
        }
        return zzdV;
    }
}
