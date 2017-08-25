package com.heyzap.sdk.ads;

import android.view.View;
import com.heyzap.common.lifecycle.DisplayResult;
import com.heyzap.common.lifecycle.EventStream;
import com.heyzap.common.lifecycle.FetchFailure;
import com.heyzap.sdk.ads.NativeAd.Image;

public abstract class NativeAdResult {
    public EventStream<Boolean> clickEventStream = EventStream.create();
    public EventStream<DisplayResult> displayEventStream = EventStream.create();
    String network;

    public abstract Image getAdChoicesImage();

    public abstract String getAdChoicesUrl();

    public abstract String getBody();

    public abstract String getCallToAction();

    public abstract Image getCoverImage();

    public abstract FetchFailure getFetchFailure();

    public abstract Image getIcon();

    public abstract Object getNativeAdObject();

    public abstract String getSocialContext();

    public abstract String getTitle();

    public abstract void onClick(View view);

    public abstract void onImpression();

    public abstract void registerView(View view);

    public String getNetwork() {
        return this.network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }
}
