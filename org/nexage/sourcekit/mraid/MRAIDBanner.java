package org.nexage.sourcekit.mraid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.webkit.WebView;
import android.widget.RelativeLayout.LayoutParams;

@SuppressLint({"ViewConstructor"})
public class MRAIDBanner extends MRAIDView {
    private static final String TAG = "MRAIDBanner";

    public MRAIDBanner(Context context, String baseUrl, String data, String[] supportedNativeFeatures, MRAIDViewListener viewListener, MRAIDNativeFeatureListener nativeFeatureListener) {
        super(context, baseUrl, data, supportedNativeFeatures, viewListener, nativeFeatureListener, false);
        this.webView.setBackgroundColor(0);
        addView(this.webView, new LayoutParams(-1, -2));
    }

    public boolean onBackPressed() {
        return this.state != 1 && super.onBackPressed();
    }

    protected void close() {
        if (this.state != 0 && this.state != 1 && this.state != 4) {
            super.close();
        }
    }

    protected void expand(String url) {
        if (this.state == 1 || this.state == 3) {
            super.expand(url);
        }
    }

    protected void expandHelper(WebView webView) {
        this.state = 2;
        super.expandHelper(webView);
        fireStateChangeEvent();
    }

    protected void onLayoutCompleted() {
        if (this.state == 0 && this.isPageFinished) {
            this.state = 1;
            fireStateChangeEvent();
            fireReadyEvent();
            if (this.isViewable) {
                fireViewableChangeEvent();
            }
        }
    }
}
