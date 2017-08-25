package com.heyzap.sdk.ads;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.heyzap.common.video.view.FullscreenVideoView;
import com.heyzap.house.abstr.AbstractActivity;
import com.heyzap.house.abstr.AbstractActivity.AdActionListener;
import com.heyzap.house.model.VideoModel;
import com.heyzap.house.view.InterstitialWebView;
import com.heyzap.internal.Constants.AdUnit;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;

public final class HeyzapVideoActivity extends AbstractActivity {
    private static final int NO_SCREEN = 0;
    private static final int VIDEO_SCREEN = 2;
    private static final int WEBVIEW_SCREEN = 1;
    protected FrameLayout backgroundView;
    private int currentScreen = 0;
    protected Boolean startedVideo = Boolean.valueOf(false);
    private boolean videoPausedByActivity = false;
    protected FullscreenVideoView videoView;
    protected InterstitialWebView webView;

    private class VideoActionListener implements AdActionListener {
        private VideoActionListener() {
        }

        public void show() {
            Logger.log("(STARTING VIDEO)");
            HeyzapVideoActivity.this.startedVideo = Boolean.valueOf(true);
            HeyzapVideoActivity.this.onAudioStarted();
        }

        public void skip(Integer time) {
            Logger.log("(SKIP VIDEO)");
            dismiss();
        }

        public void hide() {
            Logger.log("(FINISH VIDEO)");
            dismiss();
        }

        public void dismiss() {
            HeyzapVideoActivity.this.onAudioFinished();
            HeyzapVideoActivity.this.startedVideo = Boolean.valueOf(false);
            if (((VideoModel) HeyzapVideoActivity.this.currentAd).getVideoDisplayOptions().postRollInterstitial) {
                HeyzapVideoActivity.this.switchToView(1);
            } else {
                HeyzapVideoActivity.this.onHide();
            }
        }

        public void click() {
            HeyzapVideoActivity.this.onClick();
        }

        public void clickUrl(String url, String extraData) {
            Logger.log(url);
        }

        public void completed() {
            Logger.log("(COMPLETE VIDEO)");
            HeyzapVideoActivity.this.currentAdComplete = Boolean.valueOf(true);
            dismiss();
        }

        public void error() {
            Logger.trace();
            HeyzapVideoActivity.this.onAudioFinished();
            HeyzapVideoActivity.this.startedVideo = Boolean.valueOf(false);
            if (!Utils.isApplicationOnTop(HeyzapVideoActivity.this)) {
                hide();
            } else if (((VideoModel) HeyzapVideoActivity.this.currentAd).getVideoDisplayOptions().postRollInterstitial) {
                ((VideoModel) HeyzapVideoActivity.this.currentAd).onInterstitialFallback();
                HeyzapVideoActivity.this.switchToView(1);
            } else {
                HeyzapVideoActivity.this.onHide();
            }
        }

        public void restart() {
        }

        public void progress(int remainingTime, float percentComplete) {
        }

        public void resume() {
        }
    }

    private class WebViewActionListener implements AdActionListener {
        private WebViewActionListener() {
        }

        public void show() {
        }

        public void hide() {
            HeyzapVideoActivity.this.onHide();
        }

        public void skip(Integer time) {
        }

        public void click() {
            HeyzapVideoActivity.this.onClick();
        }

        public void clickUrl(String url, String extraData) {
            HeyzapVideoActivity.this.onClick(url, extraData);
        }

        public void completed() {
        }

        public void error() {
        }

        public void restart() {
            HeyzapVideoActivity.this.switchToView(2);
            HeyzapVideoActivity.this.videoView.restart();
        }

        public void progress(int remainingTime, float percentComplete) {
        }

        public void resume() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Utils.getSdkVersion() >= 9) {
            super.setRequestedOrientation(6);
        } else {
            super.setRequestedOrientation(0);
        }
    }

    public Boolean onPrepared() {
        VideoModel videoModel = this.currentAd;
        this.backgroundView = new FrameLayout(this);
        this.backgroundView.setBackgroundColor(0);
        this.webView = new InterstitialWebView(this, new WebViewActionListener());
        this.webView.render((VideoModel) this.currentAd);
        if (videoModel.isFileCached().booleanValue() || videoModel.getVideoDisplayOptions().allowStreamingFallback || videoModel.getVideoDisplayOptions().forceStreaming) {
            this.videoView = new FullscreenVideoView(this, videoModel, new VideoActionListener());
            this.backgroundView.addView(this.videoView, new LayoutParams(-1, -1));
            this.currentScreen = 2;
        } else if (videoModel.getVideoDisplayOptions().postRollInterstitial) {
            Logger.log("(INTERSTITIAL FALLBACK)");
            videoModel.onInterstitialFallback();
            this.backgroundView.addView(this.webView, new LayoutParams(-1, -1));
            this.currentScreen = 1;
        }
        return Boolean.valueOf(true);
    }

    public View getContentView() {
        this.backgroundView.setLayoutParams(new LayoutParams(-1, -1));
        return this.backgroundView;
    }

    protected void switchToView(int screen) {
        if (screen != this.currentScreen) {
            Animation anim_fadein = AnimationUtils.loadAnimation(this, 17432576);
            Animation anim_fadeout = AnimationUtils.loadAnimation(this, 17432577);
            View currentView = null;
            View incomingView = null;
            switch (this.currentScreen) {
                case 1:
                    currentView = this.webView;
                    break;
                case 2:
                    currentView = this.videoView;
                    break;
            }
            switch (screen) {
                case 1:
                    incomingView = this.webView;
                    incomingView.invalidate();
                    break;
                case 2:
                    incomingView = this.videoView;
                    break;
            }
            if (currentView != null && incomingView != null) {
                this.backgroundView.addView(incomingView, new LayoutParams(-1, -1));
                incomingView.startAnimation(anim_fadein);
                this.backgroundView.removeView(currentView);
                this.currentScreen = screen;
            }
        }
    }

    public void onHide() {
        Boolean incentivized = Boolean.valueOf(this.currentAdUnit == AdUnit.INCENTIVIZED);
        if (this.videoView != null) {
            ((VideoModel) this.currentAd).onComplete(this, this.videoView.getPlaybackDuration(), this.videoView.getTotalVideoDuration(), this.currentAdComplete);
        }
        if (incentivized.booleanValue()) {
            if (this.currentAdComplete.booleanValue()) {
                this.currentAd.getAdRequest().getOnIncentiveListener().onComplete(this.currentAd.getTag());
            } else {
                this.currentAd.getAdRequest().getOnIncentiveListener().onIncomplete(this.currentAd.getTag());
            }
        }
        super.onHide();
        if (this.webView != null) {
            this.webView.clear();
        }
        if (this.videoView != null) {
            this.videoView.clear();
        }
    }

    public void onRestart() {
        super.onRestart();
        if (VERSION.SDK_INT < 11 && this.currentScreen == 2) {
            if (((VideoModel) this.currentAd).getVideoDisplayOptions().postRollInterstitial) {
                switchToView(1);
            } else {
                onHide();
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (this.videoPausedByActivity && !this.videoView.isPlaying() && this.currentScreen == 2) {
            this.videoView.restart();
        }
        this.videoPausedByActivity = false;
    }

    protected void onPause() {
        super.onPause();
        if (this.videoView != null && this.videoView.isPlaying()) {
            this.videoView.stop();
            this.videoPausedByActivity = true;
        }
    }

    private void onAudioStarted() {
        if (this.startedVideo.booleanValue()) {
            this.currentAd.getAdRequest().getOnStatusListener().onAudioStarted();
        }
    }

    private void onAudioFinished() {
        if (this.startedVideo.booleanValue()) {
            this.currentAd.getAdRequest().getOnStatusListener().onAudioFinished();
        }
    }

    public void prepare() {
        onPrepared();
    }
}
