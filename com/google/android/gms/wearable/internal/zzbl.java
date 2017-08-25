package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.zzas.zza;
import java.util.List;

final class zzbl<T> extends zza {
    private final String zzaTD;
    private final IntentFilter[] zzaUk;
    private com.google.android.gms.wearable.zza.zza zzaVb;
    private DataListener zzaVc;
    private MessageListener zzaVd;
    private NodeListener zzaVe;
    private NodeApi.zza zzaVf;
    private ChannelListener zzaVg;
    private CapabilityListener zzaVh;
    private final String zzaVi;

    private zzbl(com.google.android.gms.wearable.zza.zza com_google_android_gms_wearable_zza_zza, DataListener dataListener, MessageListener messageListener, NodeListener nodeListener, NodeApi.zza com_google_android_gms_wearable_NodeApi_zza, ChannelListener channelListener, CapabilityListener capabilityListener, IntentFilter[] intentFilterArr, String str, String str2) {
        this.zzaVb = com_google_android_gms_wearable_zza_zza;
        this.zzaVc = dataListener;
        this.zzaVd = messageListener;
        this.zzaVe = nodeListener;
        this.zzaVf = com_google_android_gms_wearable_NodeApi_zza;
        this.zzaVg = channelListener;
        this.zzaVh = capabilityListener;
        this.zzaUk = intentFilterArr;
        this.zzaVi = str;
        this.zzaTD = str2;
    }

    public static zzbl<CapabilityListener> zza(CapabilityListener capabilityListener, String str) {
        return new zzbl(null, null, null, null, null, null, (CapabilityListener) zzu.zzu(capabilityListener), null, null, str);
    }

    public static zzbl<ChannelListener> zza(ChannelListener channelListener, String str) {
        return new zzbl(null, null, null, null, null, (ChannelListener) zzu.zzu(channelListener), null, null, (String) zzu.zzu(str), null);
    }

    public static zzbl<DataListener> zza(DataListener dataListener, IntentFilter[] intentFilterArr) {
        return new zzbl(null, (DataListener) zzu.zzu(dataListener), null, null, null, null, null, intentFilterArr, null, null);
    }

    public static zzbl<MessageListener> zza(MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return new zzbl(null, null, (MessageListener) zzu.zzu(messageListener), null, null, null, null, intentFilterArr, null, null);
    }

    public static zzbl<NodeListener> zza(NodeListener nodeListener) {
        return new zzbl(null, null, null, (NodeListener) zzu.zzu(nodeListener), null, null, null, null, null, null);
    }

    public static zzbl<ChannelListener> zzb(ChannelListener channelListener) {
        return new zzbl(null, null, null, null, null, (ChannelListener) zzu.zzu(channelListener), null, null, null, null);
    }

    public void clear() {
        this.zzaVb = null;
        this.zzaVc = null;
        this.zzaVd = null;
        this.zzaVe = null;
        this.zzaVf = null;
        this.zzaVg = null;
        this.zzaVh = null;
    }

    public void onConnectedNodes(List<NodeParcelable> connectedNodes) {
        if (this.zzaVf != null) {
            this.zzaVf.onConnectedNodes(connectedNodes);
        }
    }

    public IntentFilter[] zzBh() {
        return this.zzaUk;
    }

    public String zzBi() {
        return this.zzaVi;
    }

    public String zzBj() {
        return this.zzaTD;
    }

    public void zza(AncsNotificationParcelable ancsNotificationParcelable) {
        if (this.zzaVb != null) {
            this.zzaVb.zza(ancsNotificationParcelable);
        }
    }

    public void zza(CapabilityInfoParcelable capabilityInfoParcelable) {
        if (this.zzaVh != null) {
            this.zzaVh.onCapabilityChanged(capabilityInfoParcelable);
        }
    }

    public void zza(ChannelEventParcelable channelEventParcelable) {
        if (this.zzaVg != null) {
            channelEventParcelable.zza(this.zzaVg);
        }
    }

    public void zza(MessageEventParcelable messageEventParcelable) {
        if (this.zzaVd != null) {
            this.zzaVd.onMessageReceived(messageEventParcelable);
        }
    }

    public void zza(NodeParcelable nodeParcelable) {
        if (this.zzaVe != null) {
            this.zzaVe.onPeerConnected(nodeParcelable);
        }
    }

    public void zzac(DataHolder dataHolder) {
        if (this.zzaVc != null) {
            try {
                this.zzaVc.onDataChanged(new DataEventBuffer(dataHolder));
            } finally {
                dataHolder.close();
            }
        } else {
            dataHolder.close();
        }
    }

    public void zzb(NodeParcelable nodeParcelable) {
        if (this.zzaVe != null) {
            this.zzaVe.onPeerDisconnected(nodeParcelable);
        }
    }
}
