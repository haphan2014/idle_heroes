package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import java.util.List;

public abstract class WearableListenerService extends Service implements CapabilityListener, ChannelListener, DataListener, MessageListener, NodeListener, com.google.android.gms.wearable.NodeApi.zza {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private boolean zzJA;
    private String zzMZ;
    private volatile int zzZN = -1;
    private IBinder zzZQ;
    private Handler zzaTd;
    private Object zzaTe = new Object();

    private class zza extends com.google.android.gms.wearable.internal.zzas.zza {
        boolean zzaTf = false;
        final /* synthetic */ WearableListenerService zzaTg;

        zza(WearableListenerService wearableListenerService) {
            this.zzaTg = wearableListenerService;
            this.zzaTf = wearableListenerService instanceof zzh;
        }

        public void onConnectedNodes(final List<NodeParcelable> connectedNodes) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onConnectedNodes: " + this.zzaTg.zzMZ + ": " + connectedNodes);
            }
            this.zzaTg.zzAS();
            synchronized (this.zzaTg.zzaTe) {
                if (this.zzaTg.zzJA) {
                    return;
                }
                this.zzaTg.zzaTd.post(new Runnable(this) {
                    final /* synthetic */ zza zzaTi;

                    public void run() {
                        this.zzaTi.zzaTg.onConnectedNodes(connectedNodes);
                    }
                });
            }
        }

        public void zza(final AncsNotificationParcelable ancsNotificationParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onNotificationReceived: " + ancsNotificationParcelable);
            }
            if (this.zzaTf) {
                this.zzaTg.zzAS();
                final zzh com_google_android_gms_wearable_zzh = (zzh) this.zzaTg;
                synchronized (this.zzaTg.zzaTe) {
                    if (this.zzaTg.zzJA) {
                        return;
                    }
                    this.zzaTg.zzaTd.post(new Runnable(this) {
                        final /* synthetic */ zza zzaTi;

                        public void run() {
                            com_google_android_gms_wearable_zzh.zza(ancsNotificationParcelable);
                        }
                    });
                }
            }
        }

        public void zza(final CapabilityInfoParcelable capabilityInfoParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onConnectedCapabilityChanged: " + capabilityInfoParcelable);
            }
            this.zzaTg.zzAS();
            synchronized (this.zzaTg.zzaTe) {
                if (this.zzaTg.zzJA) {
                    return;
                }
                this.zzaTg.zzaTd.post(new Runnable(this) {
                    final /* synthetic */ zza zzaTi;

                    public void run() {
                        this.zzaTi.zzaTg.onCapabilityChanged(capabilityInfoParcelable);
                    }
                });
            }
        }

        public void zza(final ChannelEventParcelable channelEventParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onChannelEvent: " + channelEventParcelable);
            }
            this.zzaTg.zzAS();
            synchronized (this.zzaTg.zzaTe) {
                if (this.zzaTg.zzJA) {
                    return;
                }
                this.zzaTg.zzaTd.post(new Runnable(this) {
                    final /* synthetic */ zza zzaTi;

                    public void run() {
                        channelEventParcelable.zza(this.zzaTi.zzaTg);
                    }
                });
            }
        }

        public void zza(final MessageEventParcelable messageEventParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onMessageReceived: " + messageEventParcelable);
            }
            this.zzaTg.zzAS();
            synchronized (this.zzaTg.zzaTe) {
                if (this.zzaTg.zzJA) {
                    return;
                }
                this.zzaTg.zzaTd.post(new Runnable(this) {
                    final /* synthetic */ zza zzaTi;

                    public void run() {
                        this.zzaTi.zzaTg.onMessageReceived(messageEventParcelable);
                    }
                });
            }
        }

        public void zza(final NodeParcelable nodeParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerConnected: " + this.zzaTg.zzMZ + ": " + nodeParcelable);
            }
            this.zzaTg.zzAS();
            synchronized (this.zzaTg.zzaTe) {
                if (this.zzaTg.zzJA) {
                    return;
                }
                this.zzaTg.zzaTd.post(new Runnable(this) {
                    final /* synthetic */ zza zzaTi;

                    public void run() {
                        this.zzaTi.zzaTg.onPeerConnected(nodeParcelable);
                    }
                });
            }
        }

        public void zzac(final DataHolder dataHolder) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onDataItemChanged: " + this.zzaTg.zzMZ + ": " + dataHolder);
            }
            this.zzaTg.zzAS();
            synchronized (this.zzaTg.zzaTe) {
                if (this.zzaTg.zzJA) {
                    dataHolder.close();
                    return;
                }
                this.zzaTg.zzaTd.post(new Runnable(this) {
                    final /* synthetic */ zza zzaTi;

                    public void run() {
                        DataEventBuffer dataEventBuffer = new DataEventBuffer(dataHolder);
                        try {
                            this.zzaTi.zzaTg.onDataChanged(dataEventBuffer);
                        } finally {
                            dataEventBuffer.release();
                        }
                    }
                });
            }
        }

        public void zzb(final NodeParcelable nodeParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerDisconnected: " + this.zzaTg.zzMZ + ": " + nodeParcelable);
            }
            this.zzaTg.zzAS();
            synchronized (this.zzaTg.zzaTe) {
                if (this.zzaTg.zzJA) {
                    return;
                }
                this.zzaTg.zzaTd.post(new Runnable(this) {
                    final /* synthetic */ zza zzaTi;

                    public void run() {
                        this.zzaTi.zzaTg.onPeerDisconnected(nodeParcelable);
                    }
                });
            }
        }
    }

    private void zzAS() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.zzZN) {
            if (GooglePlayServicesUtil.zzd(this, callingUid)) {
                this.zzZN = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public final IBinder onBind(Intent intent) {
        return BIND_LISTENER_INTENT_ACTION.equals(intent.getAction()) ? this.zzZQ : null;
    }

    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
    }

    public void onChannelClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onChannelOpened(Channel channel) {
    }

    public void onConnectedNodes(List<Node> list) {
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + getPackageName());
        }
        this.zzMZ = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.zzaTd = new Handler(handlerThread.getLooper());
        this.zzZQ = new zza(this);
    }

    public void onDataChanged(DataEventBuffer dataEvents) {
    }

    public void onDestroy() {
        synchronized (this.zzaTe) {
            this.zzJA = true;
            if (this.zzaTd == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
            }
            this.zzaTd.getLooper().quit();
        }
        super.onDestroy();
    }

    public void onInputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onOutputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onPeerConnected(Node peer) {
    }

    public void onPeerDisconnected(Node peer) {
    }
}
