package com.heyzap.sdk.ads;

import android.view.View;
import com.heyzap.house.abstr.AbstractActivity;
import com.heyzap.house.abstr.AbstractActivity.AdActionListener;
import com.heyzap.house.model.InterstitialModel;
import com.heyzap.house.view.InterstitialWebView;

public final class HeyzapInterstitialActivity extends AbstractActivity {
    private InterstitialWebView webview;

    private class WebViewActionListener implements AdActionListener {
        private WebViewActionListener() {
        }

        public void show() {
            HeyzapInterstitialActivity.this.onShow();
        }

        public void skip(Integer time) {
        }

        public void hide() {
            HeyzapInterstitialActivity.this.webview.clear();
            HeyzapInterstitialActivity.this.onHide();
        }

        public void click() {
            HeyzapInterstitialActivity.this.onClick();
        }

        public void clickUrl(String url, String extraData) {
            HeyzapInterstitialActivity.this.onClick(url, extraData);
        }

        public void completed() {
        }

        public void error() {
        }

        public void restart() {
        }

        public void progress(int remainingTime, float percentComplete) {
        }

        public void resume() {
        }
    }

    public Boolean onPrepared() {
        this.webview = new InterstitialWebView(this, new WebViewActionListener());
        this.webview.render((InterstitialModel) this.currentAd);
        return Boolean.valueOf(true);
    }

    public View getContentView() {
        return this.webview;
    }

    public void prepare() {
        onPrepared();
    }
}
