package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzi;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zze extends zzi<zzi> {
    private static final zzl zzQW = new zzl("CastClientImpl");
    private static final Object zzUD = new Object();
    private static final Object zzUE = new Object();
    private final Listener zzQI;
    private double zzSh;
    private boolean zzSi;
    private final Map<Long, com.google.android.gms.common.api.zza.zzb<Status>> zzUA = new HashMap();
    private com.google.android.gms.common.api.zza.zzb<ApplicationConnectionResult> zzUB;
    private com.google.android.gms.common.api.zza.zzb<Status> zzUC;
    private ApplicationMetadata zzUl;
    private final CastDevice zzUm;
    private final Map<String, MessageReceivedCallback> zzUn = new HashMap();
    private final long zzUo;
    private zzb zzUp;
    private String zzUq;
    private boolean zzUr;
    private boolean zzUs;
    private boolean zzUt;
    private int zzUu;
    private int zzUv;
    private final AtomicLong zzUw = new AtomicLong(0);
    private String zzUx;
    private String zzUy;
    private Bundle zzUz;

    private static final class zza implements ApplicationConnectionResult {
        private final String zzFE;
        private final Status zzOt;
        private final ApplicationMetadata zzUF;
        private final String zzUG;
        private final boolean zzUH;

        public zza(Status status) {
            this(status, null, null, null, false);
        }

        public zza(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.zzOt = status;
            this.zzUF = applicationMetadata;
            this.zzUG = str;
            this.zzFE = str2;
            this.zzUH = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.zzUF;
        }

        public String getApplicationStatus() {
            return this.zzUG;
        }

        public String getSessionId() {
            return this.zzFE;
        }

        public Status getStatus() {
            return this.zzOt;
        }

        public boolean getWasLaunched() {
            return this.zzUH;
        }
    }

    private static class zzb extends com.google.android.gms.cast.internal.zzj.zza {
        private final Handler mHandler;
        private final AtomicReference<zze> zzUI;

        public zzb(zze com_google_android_gms_cast_internal_zze) {
            this.zzUI = new AtomicReference(com_google_android_gms_cast_internal_zze);
            this.mHandler = new Handler(com_google_android_gms_cast_internal_zze.getLooper());
        }

        private void zza(zze com_google_android_gms_cast_internal_zze, long j, int i) {
            synchronized (com_google_android_gms_cast_internal_zze.zzUA) {
                com.google.android.gms.common.api.zza.zzb com_google_android_gms_common_api_zza_zzb = (com.google.android.gms.common.api.zza.zzb) com_google_android_gms_cast_internal_zze.zzUA.remove(Long.valueOf(j));
            }
            if (com_google_android_gms_common_api_zza_zzb != null) {
                com_google_android_gms_common_api_zza_zzb.zzm(new Status(i));
            }
        }

        private boolean zza(zze com_google_android_gms_cast_internal_zze, int i) {
            synchronized (zze.zzUE) {
                if (com_google_android_gms_cast_internal_zze.zzUC != null) {
                    com_google_android_gms_cast_internal_zze.zzUC.zzm(new Status(i));
                    com_google_android_gms_cast_internal_zze.zzUC = null;
                    return true;
                }
                return false;
            }
        }

        public boolean isDisposed() {
            return this.zzUI.get() == null;
        }

        public void onApplicationDisconnected(final int statusCode) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.zzUI.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                com_google_android_gms_cast_internal_zze.zzUx = null;
                com_google_android_gms_cast_internal_zze.zzUy = null;
                zza(com_google_android_gms_cast_internal_zze, statusCode);
                if (com_google_android_gms_cast_internal_zze.zzQI != null) {
                    this.mHandler.post(new Runnable(this) {
                        final /* synthetic */ zzb zzUL;

                        public void run() {
                            if (com_google_android_gms_cast_internal_zze.zzQI != null) {
                                com_google_android_gms_cast_internal_zze.zzQI.onApplicationDisconnected(statusCode);
                            }
                        }
                    });
                }
            }
        }

        public void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzUI.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                com_google_android_gms_cast_internal_zze.zzUl = applicationMetadata;
                com_google_android_gms_cast_internal_zze.zzUx = applicationMetadata.getApplicationId();
                com_google_android_gms_cast_internal_zze.zzUy = str2;
                synchronized (zze.zzUD) {
                    if (com_google_android_gms_cast_internal_zze.zzUB != null) {
                        com_google_android_gms_cast_internal_zze.zzUB.zzm(new zza(new Status(0), applicationMetadata, str, str2, z));
                        com_google_android_gms_cast_internal_zze.zzUB = null;
                    }
                }
            }
        }

        public void zza(String str, double d, boolean z) {
            zze.zzQW.zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void zza(String str, long j, int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzUI.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, j, i);
            }
        }

        public void zzaM(int i) {
            zze zzlW = zzlW();
            if (zzlW != null) {
                zze.zzQW.zzb("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
                if (i != 0) {
                    zzlW.zzbs(2);
                }
            }
        }

        public void zzaN(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzUI.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                synchronized (zze.zzUD) {
                    if (com_google_android_gms_cast_internal_zze.zzUB != null) {
                        com_google_android_gms_cast_internal_zze.zzUB.zzm(new zza(new Status(i)));
                        com_google_android_gms_cast_internal_zze.zzUB = null;
                    }
                }
            }
        }

        public void zzaO(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzUI.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, i);
            }
        }

        public void zzaP(int i) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzUI.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, i);
            }
        }

        public void zzb(final ApplicationStatus applicationStatus) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.zzUI.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.zzQW.zzb("onApplicationStatusChanged", new Object[0]);
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ zzb zzUL;

                    public void run() {
                        com_google_android_gms_cast_internal_zze.zza(applicationStatus);
                    }
                });
            }
        }

        public void zzb(final DeviceStatus deviceStatus) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.zzUI.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.zzQW.zzb("onDeviceStatusChanged", new Object[0]);
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ zzb zzUL;

                    public void run() {
                        com_google_android_gms_cast_internal_zze.zza(deviceStatus);
                    }
                });
            }
        }

        public void zzb(String str, byte[] bArr) {
            if (((zze) this.zzUI.get()) != null) {
                zze.zzQW.zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
            }
        }

        public void zzd(String str, long j) {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzUI.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zza(com_google_android_gms_cast_internal_zze, j, 0);
            }
        }

        public zze zzlW() {
            zze com_google_android_gms_cast_internal_zze = (zze) this.zzUI.getAndSet(null);
            if (com_google_android_gms_cast_internal_zze == null) {
                return null;
            }
            com_google_android_gms_cast_internal_zze.zzlL();
            return com_google_android_gms_cast_internal_zze;
        }

        public void zzq(final String str, final String str2) {
            final zze com_google_android_gms_cast_internal_zze = (zze) this.zzUI.get();
            if (com_google_android_gms_cast_internal_zze != null) {
                zze.zzQW.zzb("Receive (type=text, ns=%s) %s", str, str2);
                this.mHandler.post(new Runnable(this) {
                    final /* synthetic */ zzb zzUL;

                    public void run() {
                        synchronized (com_google_android_gms_cast_internal_zze.zzUn) {
                            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) com_google_android_gms_cast_internal_zze.zzUn.get(str);
                        }
                        if (messageReceivedCallback != null) {
                            messageReceivedCallback.onMessageReceived(com_google_android_gms_cast_internal_zze.zzUm, str, str2);
                            return;
                        }
                        zze.zzQW.zzb("Discarded message for unknown namespace '%s'", str);
                    }
                });
            }
        }
    }

    public zze(Context context, Looper looper, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, connectionCallbacks, onConnectionFailedListener);
        this.zzUm = castDevice;
        this.zzQI = listener;
        this.zzUo = j;
        zzlL();
    }

    private void zza(ApplicationStatus applicationStatus) {
        boolean z;
        String zzlI = applicationStatus.zzlI();
        if (zzf.zza(zzlI, this.zzUq)) {
            z = false;
        } else {
            this.zzUq = zzlI;
            z = true;
        }
        zzQW.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzUr));
        if (this.zzQI != null && (z || this.zzUr)) {
            this.zzQI.onApplicationStatusChanged();
        }
        this.zzUr = false;
    }

    private void zza(DeviceStatus deviceStatus) {
        boolean z;
        ApplicationMetadata applicationMetadata = deviceStatus.getApplicationMetadata();
        if (!zzf.zza(applicationMetadata, this.zzUl)) {
            this.zzUl = applicationMetadata;
            this.zzQI.onApplicationMetadataChanged(this.zzUl);
        }
        double zzlO = deviceStatus.zzlO();
        if (zzlO == Double.NaN || Math.abs(zzlO - this.zzSh) <= 1.0E-7d) {
            z = false;
        } else {
            this.zzSh = zzlO;
            z = true;
        }
        boolean zzlX = deviceStatus.zzlX();
        if (zzlX != this.zzSi) {
            this.zzSi = zzlX;
            z = true;
        }
        zzQW.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzUs));
        if (this.zzQI != null && (z || this.zzUs)) {
            this.zzQI.onVolumeChanged();
        }
        int zzlP = deviceStatus.zzlP();
        if (zzlP != this.zzUu) {
            this.zzUu = zzlP;
            z = true;
        } else {
            z = false;
        }
        zzQW.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzUs));
        if (this.zzQI != null && (z || this.zzUs)) {
            this.zzQI.onActiveInputStateChanged(this.zzUu);
        }
        zzlP = deviceStatus.zzlQ();
        if (zzlP != this.zzUv) {
            this.zzUv = zzlP;
            z = true;
        } else {
            z = false;
        }
        zzQW.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzUs));
        if (this.zzQI != null && (z || this.zzUs)) {
            this.zzQI.onStandbyStateChanged(this.zzUv);
        }
        this.zzUs = false;
    }

    private void zzc(com.google.android.gms.common.api.zza.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) {
        synchronized (zzUD) {
            if (this.zzUB != null) {
                this.zzUB.zzm(new zza(new Status(2002)));
            }
            this.zzUB = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult;
        }
    }

    private void zze(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) {
        synchronized (zzUE) {
            if (this.zzUC != null) {
                com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status.zzm(new Status(2001));
                return;
            }
            this.zzUC = com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status;
        }
    }

    private void zzlL() {
        this.zzUt = false;
        this.zzUu = -1;
        this.zzUv = -1;
        this.zzUl = null;
        this.zzUq = null;
        this.zzSh = 0.0d;
        this.zzSi = false;
    }

    private void zzlR() {
        zzQW.zzb("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zzUn) {
            this.zzUn.clear();
        }
    }

    private void zzlS() throws IllegalStateException {
        if (!this.zzUt || this.zzUp == null || this.zzUp.isDisposed()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void disconnect() {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = zzQW;
        r1 = "disconnect(); ServiceListener=%s, isConnected=%b";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = r6.zzUp;
        r2[r4] = r3;
        r3 = r6.isConnected();
        r3 = java.lang.Boolean.valueOf(r3);
        r2[r5] = r3;
        r0.zzb(r1, r2);
        r0 = r6.zzUp;
        r1 = 0;
        r6.zzUp = r1;
        if (r0 == 0) goto L_0x0027;
    L_0x0021:
        r0 = r0.zzlW();
        if (r0 != 0) goto L_0x0031;
    L_0x0027:
        r0 = zzQW;
        r1 = "already disposed, so short-circuiting";
        r2 = new java.lang.Object[r4];
        r0.zzb(r1, r2);
    L_0x0030:
        return;
    L_0x0031:
        r6.zzlR();
        r0 = r6.isConnected();	 Catch:{ RemoteException -> 0x004d }
        if (r0 != 0) goto L_0x0040;
    L_0x003a:
        r0 = r6.isConnecting();	 Catch:{ RemoteException -> 0x004d }
        if (r0 == 0) goto L_0x0049;
    L_0x0040:
        r0 = r6.zznM();	 Catch:{ RemoteException -> 0x004d }
        r0 = (com.google.android.gms.cast.internal.zzi) r0;	 Catch:{ RemoteException -> 0x004d }
        r0.disconnect();	 Catch:{ RemoteException -> 0x004d }
    L_0x0049:
        super.disconnect();
        goto L_0x0030;
    L_0x004d:
        r0 = move-exception;
        r1 = zzQW;	 Catch:{ all -> 0x0063 }
        r2 = "Error while disconnecting the controller interface: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0063 }
        r4 = 0;
        r5 = r0.getMessage();	 Catch:{ all -> 0x0063 }
        r3[r4] = r5;	 Catch:{ all -> 0x0063 }
        r1.zzb(r0, r2, r3);	 Catch:{ all -> 0x0063 }
        super.disconnect();
        goto L_0x0030;
    L_0x0063:
        r0 = move-exception;
        super.disconnect();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.internal.zze.disconnect():void");
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        zzlS();
        return this.zzUl;
    }

    public String getApplicationStatus() throws IllegalStateException {
        zzlS();
        return this.zzUq;
    }

    protected String getServiceDescriptor() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    protected String getStartServiceAction() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    public boolean isMute() throws IllegalStateException {
        zzlS();
        return this.zzSi;
    }

    public void onConnectionFailed(ConnectionResult result) {
        super.onConnectionFailed(result);
        zzlR();
    }

    public void zzR(boolean z) throws IllegalStateException, RemoteException {
        ((zzi) zznM()).zza(z, this.zzSh, this.zzSi);
    }

    protected /* synthetic */ IInterface zzT(IBinder iBinder) {
        return zzaw(iBinder);
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        zzQW.zzb("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 1001) {
            this.zzUt = true;
            this.zzUr = true;
            this.zzUs = true;
        } else {
            this.zzUt = false;
        }
        if (i == 1001) {
            this.zzUz = new Bundle();
            this.zzUz.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        zzf.zzbD(str);
        zzbC(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zzUn) {
                this.zzUn.put(str, messageReceivedCallback);
            }
            ((zzi) zznM()).zzbH(str);
        }
    }

    public void zza(String str, LaunchOptions launchOptions, com.google.android.gms.common.api.zza.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zzc((com.google.android.gms.common.api.zza.zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        ((zzi) zznM()).zza(str, launchOptions);
    }

    public void zza(String str, com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) throws IllegalStateException, RemoteException {
        zze((com.google.android.gms.common.api.zza.zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        ((zzi) zznM()).zzbG(str);
    }

    public void zza(String str, String str2, com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            zzf.zzbD(str);
            zzlS();
            long incrementAndGet = this.zzUw.incrementAndGet();
            try {
                this.zzUA.put(Long.valueOf(incrementAndGet), com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
                ((zzi) zznM()).zza(str, str2, incrementAndGet);
            } catch (Throwable th) {
                this.zzUA.remove(Long.valueOf(incrementAndGet));
            }
        }
    }

    public void zza(String str, boolean z, com.google.android.gms.common.api.zza.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zzc((com.google.android.gms.common.api.zza.zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        ((zzi) zznM()).zzf(str, z);
    }

    protected zzi zzaw(IBinder iBinder) {
        return com.google.android.gms.cast.internal.zzi.zza.zzax(iBinder);
    }

    public void zzb(String str, String str2, com.google.android.gms.common.api.zza.zzb<ApplicationConnectionResult> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult) throws IllegalStateException, RemoteException {
        zzc((com.google.android.gms.common.api.zza.zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_cast_Cast_ApplicationConnectionResult);
        ((zzi) zznM()).zzr(str, str2);
    }

    public void zzbC(String str) throws IllegalArgumentException, RemoteException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zzUn) {
            MessageReceivedCallback messageReceivedCallback = (MessageReceivedCallback) this.zzUn.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((zzi) zznM()).zzbI(str);
            } catch (Throwable e) {
                zzQW.zzb(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void zzd(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((zzi) zznM()).zza(d, this.zzSh, this.zzSi);
    }

    public void zzd(com.google.android.gms.common.api.zza.zzb<Status> com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status) throws IllegalStateException, RemoteException {
        zze((com.google.android.gms.common.api.zza.zzb) com_google_android_gms_common_api_zza_zzb_com_google_android_gms_common_api_Status);
        ((zzi) zznM()).zzlY();
    }

    protected Bundle zzkR() {
        Bundle bundle = new Bundle();
        zzQW.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.zzUx, this.zzUy);
        this.zzUm.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzUo);
        this.zzUp = new zzb(this);
        bundle.putParcelable("listener", new BinderWrapper(this.zzUp.asBinder()));
        if (this.zzUx != null) {
            bundle.putString("last_application_id", this.zzUx);
            if (this.zzUy != null) {
                bundle.putString("last_session_id", this.zzUy);
            }
        }
        return bundle;
    }

    public Bundle zzlM() {
        if (this.zzUz == null) {
            return super.zzlM();
        }
        Bundle bundle = this.zzUz;
        this.zzUz = null;
        return bundle;
    }

    public void zzlN() throws IllegalStateException, RemoteException {
        ((zzi) zznM()).zzlN();
    }

    public double zzlO() throws IllegalStateException {
        zzlS();
        return this.zzSh;
    }

    public int zzlP() throws IllegalStateException {
        zzlS();
        return this.zzUu;
    }

    public int zzlQ() throws IllegalStateException {
        zzlS();
        return this.zzUv;
    }
}
