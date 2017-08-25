package com.google.android.gms.cast;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v7.media.MediaRouteSelector;
import android.support.v7.media.MediaRouter;
import android.support.v7.media.MediaRouter.Callback;
import android.support.v7.media.MediaRouter.RouteInfo;
import android.text.TextUtils;
import android.view.Display;
import com.google.android.gms.C0346R;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplayOptions;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.drive.DriveFile;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CastRemoteDisplayLocalService extends Service {
    private static final zzl zzQW = new zzl("CastRemoteDisplayLocalService");
    private static final int zzQX = C0346R.id.cast_notification_id;
    private static final Object zzQY = new Object();
    private static AtomicBoolean zzQZ = new AtomicBoolean(false);
    private static CastRemoteDisplayLocalService zzRn;
    private Handler mHandler;
    private Notification mNotification;
    private String zzQv;
    private GoogleApiClient zzRa;
    private CastRemoteDisplaySessionCallbacks zzRb;
    private Callbacks zzRc;
    private zzb zzRd;
    private NotificationSettings zzRe;
    private Boolean zzRf;
    private PendingIntent zzRg;
    private CastDevice zzRh;
    private Display zzRi;
    private Context zzRj;
    private ServiceConnection zzRk;
    private MediaRouter zzRl;
    private final Callback zzRm = new C04411(this);
    private final IBinder zzRo = new zza();

    class C04411 extends Callback {
        final /* synthetic */ CastRemoteDisplayLocalService zzRp;

        C04411(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzRp = castRemoteDisplayLocalService;
        }

        public void onRouteUnselected(MediaRouter router, RouteInfo info) {
            CastRemoteDisplayLocalService.zzQW.zzb("onRouteUnselected", new Object[0]);
            if (this.zzRp.zzRh == null) {
                CastRemoteDisplayLocalService.zzQW.zzb("onRouteUnselected, no device was selected", new Object[0]);
            } else if (CastDevice.getFromBundle(info.getExtras()).getDeviceId().equals(this.zzRp.zzRh.getDeviceId())) {
                CastRemoteDisplayLocalService.stopService();
            } else {
                CastRemoteDisplayLocalService.zzQW.zzb("onRouteUnselected, device does not match", new Object[0]);
            }
        }
    }

    class C04443 implements CastRemoteDisplaySessionCallbacks {
        final /* synthetic */ CastRemoteDisplayLocalService zzRp;

        class C04431 implements Runnable {
            final /* synthetic */ C04443 zzRu;

            C04431(C04443 c04443) {
                this.zzRu = c04443;
            }

            public void run() {
                CastRemoteDisplayLocalService.zzM(false);
            }
        }

        C04443(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzRp = castRemoteDisplayLocalService;
        }

        public void onRemoteDisplayEnded(Status status) {
            CastRemoteDisplayLocalService.zzQW.zzb(String.format("Cast screen has ended: %d", new Object[]{Integer.valueOf(status.getStatusCode())}), new Object[0]);
            if (this.zzRp.mHandler != null) {
                this.zzRp.mHandler.post(new C04431(this));
            }
        }
    }

    class C04454 implements ResultCallback<CastRemoteDisplaySessionResult> {
        final /* synthetic */ CastRemoteDisplayLocalService zzRp;

        C04454(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzRp = castRemoteDisplayLocalService;
        }

        public /* synthetic */ void onResult(Result x0) {
            zza((CastRemoteDisplaySessionResult) x0);
        }

        public void zza(CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
            if (castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                Display presentationDisplay = castRemoteDisplaySessionResult.getPresentationDisplay();
                if (presentationDisplay != null) {
                    this.zzRp.zza(presentationDisplay);
                } else {
                    CastRemoteDisplayLocalService.zzQW.zzc("Cast Remote Display session created without display", new Object[0]);
                }
                CastRemoteDisplayLocalService.zzQZ.set(false);
                if (this.zzRp.zzRj != null && this.zzRp.zzRk != null) {
                    this.zzRp.zzRj.unbindService(this.zzRp.zzRk);
                    this.zzRp.zzRk = null;
                    this.zzRp.zzRj = null;
                    return;
                }
                return;
            }
            CastRemoteDisplayLocalService.zzQW.zzc("Connection was not successful", new Object[0]);
            this.zzRp.zzlj();
        }
    }

    class C04465 implements ResultCallback<CastRemoteDisplaySessionResult> {
        final /* synthetic */ CastRemoteDisplayLocalService zzRp;

        C04465(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzRp = castRemoteDisplayLocalService;
        }

        public /* synthetic */ void onResult(Result x0) {
            zza((CastRemoteDisplaySessionResult) x0);
        }

        public void zza(CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
            if (castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                CastRemoteDisplayLocalService.zzQW.zzb("remote display stopped", new Object[0]);
            } else {
                CastRemoteDisplayLocalService.zzQW.zzb("Unable to stop the remote display, result unsuccessful", new Object[0]);
            }
            this.zzRp.zzRi = null;
        }
    }

    class C04476 implements ConnectionCallbacks {
        final /* synthetic */ CastRemoteDisplayLocalService zzRp;

        C04476(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzRp = castRemoteDisplayLocalService;
        }

        public void onConnected(Bundle bundle) {
            CastRemoteDisplayLocalService.zzQW.zzb("onConnected", new Object[0]);
            this.zzRp.zzlh();
        }

        public void onConnectionSuspended(int cause) {
            CastRemoteDisplayLocalService.zzQW.zzf(String.format("ConnectionSuspended %d", new Object[]{Integer.valueOf(cause)}), new Object[0]);
        }
    }

    class C04487 implements OnConnectionFailedListener {
        final /* synthetic */ CastRemoteDisplayLocalService zzRp;

        C04487(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzRp = castRemoteDisplayLocalService;
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            CastRemoteDisplayLocalService.zzQW.zzc("Connection failed: " + connectionResult, new Object[0]);
            this.zzRp.zzlj();
        }
    }

    public interface Callbacks {
        void onRemoteDisplaySessionError(Status status);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castRemoteDisplayLocalService);
    }

    public static final class NotificationSettings {
        private Notification mNotification;
        private PendingIntent zzRv;
        private String zzRw;
        private String zzRx;

        public static final class Builder {
            private NotificationSettings zzRy = new NotificationSettings();

            public NotificationSettings build() {
                if (this.zzRy.mNotification != null) {
                    if (!TextUtils.isEmpty(this.zzRy.zzRw)) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    } else if (!TextUtils.isEmpty(this.zzRy.zzRx)) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    } else if (this.zzRy.zzRv != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(this.zzRy.zzRw) && TextUtils.isEmpty(this.zzRy.zzRx) && this.zzRy.zzRv == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return this.zzRy;
            }

            public Builder setNotification(Notification notification) {
                this.zzRy.mNotification = notification;
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent notificationPendingIntent) {
                this.zzRy.zzRv = notificationPendingIntent;
                return this;
            }

            public Builder setNotificationText(String notificationText) {
                this.zzRy.zzRx = notificationText;
                return this;
            }

            public Builder setNotificationTitle(String notificationTitle) {
                this.zzRy.zzRw = notificationTitle;
                return this;
            }
        }

        private NotificationSettings() {
        }

        private NotificationSettings(NotificationSettings newSettings) {
            this.mNotification = newSettings.mNotification;
            this.zzRv = newSettings.zzRv;
            this.zzRw = newSettings.zzRw;
            this.zzRx = newSettings.zzRx;
        }
    }

    private class zza extends Binder {
        final /* synthetic */ CastRemoteDisplayLocalService zzRp;

        private zza(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
            this.zzRp = castRemoteDisplayLocalService;
        }

        CastRemoteDisplayLocalService zzlp() {
            return this.zzRp;
        }
    }

    private static final class zzb extends BroadcastReceiver {
        private zzb() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT")) {
                CastRemoteDisplayLocalService.zzQW.zzb("disconnecting", new Object[0]);
                CastRemoteDisplayLocalService.stopService();
            }
        }
    }

    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzQY) {
            castRemoteDisplayLocalService = zzRn;
        }
        return castRemoteDisplayLocalService;
    }

    protected static void setDebugEnabled() {
        zzQW.zzS(true);
    }

    public static void startService(Context activityContext, Class<? extends CastRemoteDisplayLocalService> serviceClass, String applicationId, CastDevice device, NotificationSettings notificationSettings, Callbacks callbacks) {
        zzQW.zzb("Starting Service", new Object[0]);
        zzb(activityContext, (Class) serviceClass);
        zzu.zzb((Object) activityContext, (Object) "activityContext is required.");
        zzu.zzb((Object) serviceClass, (Object) "serviceClass is required.");
        zzu.zzb((Object) applicationId, (Object) "applicationId is required.");
        zzu.zzb((Object) device, (Object) "device is required.");
        zzu.zzb((Object) notificationSettings, (Object) "notificationSettings is required.");
        zzu.zzb((Object) callbacks, (Object) "callbacks is required.");
        if (notificationSettings.mNotification == null && notificationSettings.zzRv == null) {
            throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
        } else if (zzQZ.getAndSet(true)) {
            zzQW.zzc("Service is already being started, startService has been called twice", new Object[0]);
        } else {
            Intent intent = new Intent(activityContext, serviceClass);
            activityContext.startService(intent);
            final String str = applicationId;
            final CastDevice castDevice = device;
            final NotificationSettings notificationSettings2 = notificationSettings;
            final Context context = activityContext;
            final Callbacks callbacks2 = callbacks;
            activityContext.bindService(intent, new ServiceConnection() {
                public void onServiceConnected(ComponentName className, IBinder binder) {
                    CastRemoteDisplayLocalService zzlp = ((zza) binder).zzlp();
                    if (zzlp != null) {
                        zzlp.zza(str, castDevice, notificationSettings2, context, this, callbacks2);
                        return;
                    }
                    CastRemoteDisplayLocalService.zzQW.zzc("Connected but unable to get the service instance", new Object[0]);
                    callbacks2.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
                    CastRemoteDisplayLocalService.zzQZ.set(false);
                    context.unbindService(this);
                }

                public void onServiceDisconnected(ComponentName arg0) {
                    CastRemoteDisplayLocalService.zzQW.zzb("onServiceDisconnected", new Object[0]);
                    callbacks2.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_DISCONNECTED, "Service Disconnected"));
                    CastRemoteDisplayLocalService.zzQZ.set(false);
                    context.unbindService(this);
                }
            }, 64);
        }
    }

    public static void stopService() {
        zzM(false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzM(boolean r6) {
        /*
        r5 = 0;
        r4 = 0;
        r0 = zzQW;
        r1 = "Stopping Service";
        r2 = new java.lang.Object[r5];
        r0.zzb(r1, r2);
        r0 = zzQZ;
        r0.set(r5);
        r1 = zzQY;
        monitor-enter(r1);
        r0 = zzRn;	 Catch:{ all -> 0x0080 }
        if (r0 != 0) goto L_0x0023;
    L_0x0017:
        r0 = zzQW;	 Catch:{ all -> 0x0080 }
        r2 = "Service is already being stopped";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0080 }
        r0.zzc(r2, r3);	 Catch:{ all -> 0x0080 }
        monitor-exit(r1);	 Catch:{ all -> 0x0080 }
    L_0x0022:
        return;
    L_0x0023:
        r0 = zzRn;	 Catch:{ all -> 0x0080 }
        r2 = 0;
        zzRn = r2;	 Catch:{ all -> 0x0080 }
        monitor-exit(r1);	 Catch:{ all -> 0x0080 }
        if (r6 != 0) goto L_0x0043;
    L_0x002b:
        r1 = r0.zzRl;
        if (r1 == 0) goto L_0x0043;
    L_0x002f:
        r1 = zzQW;
        r2 = "Setting default route";
        r3 = new java.lang.Object[r5];
        r1.zzb(r2, r3);
        r1 = r0.zzRl;
        r2 = r0.zzRl;
        r2 = r2.getDefaultRoute();
        r1.selectRoute(r2);
    L_0x0043:
        r1 = r0.zzRd;
        if (r1 == 0) goto L_0x0055;
    L_0x0047:
        r1 = zzQW;
        r2 = "Unregistering notification receiver";
        r3 = new java.lang.Object[r5];
        r1.zzb(r2, r3);
        r1 = r0.zzRd;
        r0.unregisterReceiver(r1);
    L_0x0055:
        r0.zzlk();
        r0.zzll();
        r0.zzlg();
        r1 = r0.zzRj;
        if (r1 == 0) goto L_0x0071;
    L_0x0062:
        r1 = r0.zzRk;
        if (r1 == 0) goto L_0x0071;
    L_0x0066:
        r1 = r0.zzRj;
        r2 = r0.zzRk;
        r1.unbindService(r2);
        r0.zzRk = r4;
        r0.zzRj = r4;
    L_0x0071:
        r0.zzRc = r4;
        r0.zzQv = r4;
        r0.zzRa = r4;
        r0.zzRh = r4;
        r0.zzRe = r4;
        r0.mNotification = r4;
        r0.zzRi = r4;
        goto L_0x0022;
    L_0x0080:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0080 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastRemoteDisplayLocalService.zzM(boolean):void");
    }

    private Notification zzN(boolean z) {
        int i;
        int i2;
        CharSequence string;
        int i3 = getApplicationInfo().labelRes;
        CharSequence zzb = this.zzRe.zzRw;
        CharSequence zzc = this.zzRe.zzRx;
        if (z) {
            i = C0346R.string.cast_notification_connected_message;
            i2 = C0346R.drawable.cast_ic_notification_on;
        } else {
            i = C0346R.string.cast_notification_connecting_message;
            i2 = C0346R.drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(zzb)) {
            zzb = getString(i3);
        }
        if (TextUtils.isEmpty(zzc)) {
            string = getString(i, new Object[]{this.zzRh.getFriendlyName()});
        } else {
            string = zzc;
        }
        Notification build = new Builder(this).setContentTitle(zzb).setContentText(string).setContentIntent(this.zzRe.zzRv).setSmallIcon(i2).setOngoing(true).addAction(17301560, getString(C0346R.string.cast_notification_disconnect), zzlm()).build();
        startForeground(zzQX, build);
        return build;
    }

    private GoogleApiClient zza(CastDevice castDevice) {
        return new GoogleApiClient.Builder(this, new C04476(this), new C04487(this)).addApi(CastRemoteDisplay.API, new CastRemoteDisplayOptions.Builder(castDevice, this.zzRb).build()).build();
    }

    private void zza(Display display) {
        this.zzRi = display;
        if (this.zzRf.booleanValue()) {
            this.mNotification = zzN(true);
        }
        if (this.zzRc != null) {
            this.zzRc.onRemoteDisplaySessionStarted(this);
            this.zzRc = null;
        }
        onCreatePresentation(this.zzRi);
    }

    private void zza(String str, CastDevice castDevice, NotificationSettings notificationSettings, Context context, ServiceConnection serviceConnection, Callbacks callbacks) {
        zzQW.zzb("startRemoteDisplaySession", new Object[0]);
        zzu.zzbY("Starting the Cast Remote Display must be done on the main thread");
        synchronized (zzQY) {
            if (zzRn != null) {
                zzM(true);
                zzQW.zzf("An existing service had not been stopped before starting one", new Object[0]);
            }
            zzRn = this;
        }
        this.zzRc = callbacks;
        this.zzQv = str;
        this.zzRh = castDevice;
        this.zzRj = context;
        this.zzRk = serviceConnection;
        this.zzRl = MediaRouter.getInstance(getApplicationContext());
        this.zzRl.addCallback(new MediaRouteSelector.Builder().addControlCategory(CastMediaControlIntent.categoryForCast(this.zzQv)).build(), this.zzRm, 4);
        this.mHandler = new Handler(getMainLooper());
        this.mNotification = notificationSettings.mNotification;
        this.zzRd = new zzb();
        registerReceiver(this.zzRd, new IntentFilter("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"));
        this.zzRe = new NotificationSettings(notificationSettings);
        if (this.zzRe.mNotification == null) {
            this.zzRf = Boolean.valueOf(true);
            this.mNotification = zzN(false);
        } else {
            this.zzRf = Boolean.valueOf(false);
            this.mNotification = this.zzRe.mNotification;
        }
        this.zzRa = zza(castDevice);
        this.zzRa.connect();
    }

    private static void zzb(Context context, Class cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 128);
            if (serviceInfo != null && serviceInfo.exported) {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
        }
    }

    private void zzlg() {
        if (this.zzRl != null) {
            zzu.zzbY("CastRemoteDisplayLocalService calls must be done on the main thread");
            this.zzRl.removeCallback(this.zzRm);
        }
    }

    private void zzlh() {
        zzQW.zzb("startRemoteDisplay", new Object[0]);
        if (this.zzRa == null || !this.zzRa.isConnected()) {
            zzQW.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(this.zzRa, this.zzQv).setResultCallback(new C04454(this));
        }
    }

    private void zzli() {
        zzQW.zzb("stopRemoteDisplay", new Object[0]);
        if (this.zzRa == null || !this.zzRa.isConnected()) {
            zzQW.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(this.zzRa).setResultCallback(new C04465(this));
        }
    }

    private void zzlj() {
        if (this.zzRc != null) {
            this.zzRc.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
            this.zzRc = null;
        }
        stopService();
    }

    private void zzlk() {
        zzQW.zzb("stopRemoteDisplaySession", new Object[0]);
        zzli();
        onDismissPresentation();
    }

    private void zzll() {
        zzQW.zzb("Stopping the remote display Service", new Object[0]);
        stopForeground(true);
        stopSelf();
    }

    private PendingIntent zzlm() {
        if (this.zzRg == null) {
            this.zzRg = PendingIntent.getBroadcast(this, 0, new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"), DriveFile.MODE_READ_ONLY);
        }
        return this.zzRg;
    }

    protected Display getDisplay() {
        return this.zzRi;
    }

    public IBinder onBind(Intent intent) {
        return this.zzRo;
    }

    public void onCreate() {
        super.onCreate();
        this.zzRb = new C04443(this);
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    public int onStartCommand(Intent intent, int flags, int startId) {
        zzQW.zzb("onStartCommand", new Object[0]);
        return 2;
    }

    public void updateNotificationSettings(NotificationSettings notificationSettings) {
        zzu.zzb((Object) notificationSettings, (Object) "notificationSettings is required.");
        if (!this.zzRf.booleanValue()) {
            zzu.zzb(notificationSettings.mNotification, (Object) "notification is required.");
            this.mNotification = notificationSettings.mNotification;
            this.zzRe.mNotification = this.mNotification;
        } else if (notificationSettings.mNotification != null) {
            throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
        } else {
            if (notificationSettings.zzRv != null) {
                this.zzRe.zzRv = notificationSettings.zzRv;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzRw)) {
                this.zzRe.zzRw = notificationSettings.zzRw;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzRx)) {
                this.zzRe.zzRx = notificationSettings.zzRx;
            }
            this.mNotification = zzN(true);
        }
        startForeground(zzQX, this.mNotification);
    }
}
