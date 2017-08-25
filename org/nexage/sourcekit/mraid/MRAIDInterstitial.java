package org.nexage.sourcekit.mraid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.webkit.WebView;

@SuppressLint({"ViewConstructor"})
public class MRAIDInterstitial extends MRAIDView {
    private static final String TAG = "MRAIDInterstitial";

    class C19611 implements Runnable {
        C19611() {
        }

        public void run() {
            MRAIDInterstitial.this.fireStateChangeEvent();
            if (MRAIDInterstitial.this.listener != null) {
                MRAIDInterstitial.this.listener.mraidViewClose(MRAIDInterstitial.this);
            }
        }
    }

    public MRAIDInterstitial(Context context, String baseUrl, String data, String[] supportedNativeFeatures, MRAIDViewListener viewListener, MRAIDNativeFeatureListener nativeFeatureListener) {
        super(context, baseUrl, data, supportedNativeFeatures, viewListener, nativeFeatureListener, true);
        this.webView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        addView(this.webView);
    }

    protected void close() {
        super.close();
    }

    protected void expand(String url) {
        if (this.state == 0) {
            super.expand(url);
        }
    }

    protected void expandHelper(WebView webView) {
        super.expandHelper(webView);
        this.isLaidOut = true;
        this.state = 1;
        fireStateChangeEvent();
    }

    protected void closeFromExpanded() {
        if (this.state == 1) {
            this.state = 4;
            clearView();
            this.handler.post(new C19611());
        }
        super.closeFromExpanded();
    }

    public void show(Activity activity) {
        showAsInterstitial(activity);
    }
}
