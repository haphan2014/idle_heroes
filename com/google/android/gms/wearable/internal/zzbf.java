package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

final class zzbf implements ChannelListener {
    private final String zzaTK;
    private final ChannelListener zzaUO;

    zzbf(String str, ChannelListener channelListener) {
        this.zzaTK = (String) zzu.zzu(str);
        this.zzaUO = (ChannelListener) zzu.zzu(channelListener);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof zzbf)) {
            return false;
        }
        zzbf com_google_android_gms_wearable_internal_zzbf = (zzbf) o;
        return this.zzaUO.equals(com_google_android_gms_wearable_internal_zzbf.zzaUO) && this.zzaTK.equals(com_google_android_gms_wearable_internal_zzbf.zzaTK);
    }

    public int hashCode() {
        return (this.zzaTK.hashCode() * 31) + this.zzaUO.hashCode();
    }

    public void onChannelClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
        this.zzaUO.onChannelClosed(channel, closeReason, appSpecificErrorCode);
    }

    public void onChannelOpened(Channel channel) {
        this.zzaUO.onChannelOpened(channel);
    }

    public void onInputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
        this.zzaUO.onInputClosed(channel, closeReason, appSpecificErrorCode);
    }

    public void onOutputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
        this.zzaUO.onOutputClosed(channel, closeReason, appSpecificErrorCode);
    }
}
