package com.heyzap.mediation.handler;

import com.heyzap.sdk.ads.HeyzapAds.NetworkCallbackListener;

public class NetworkCallbackListenerProxy implements NetworkCallbackListener {
    private NetworkCallbackListener listener = null;

    public void setNetworkCallbackListener(NetworkCallbackListener listener) {
        this.listener = listener;
    }

    public void onNetworkCallback(String network, String callback) {
        if (this.listener != null) {
            this.listener.onNetworkCallback(network, callback);
        }
    }
}
