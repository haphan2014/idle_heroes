package com.heyzap.sdk.ads;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.heyzap.common.net.APIClient;
import com.heyzap.common.vast.VASTInterstitial;
import com.heyzap.common.vast.VASTInterstitial.VASTError;
import com.heyzap.common.vast.model.TrackingEvent;
import com.heyzap.common.vast.model.VASTModel;
import com.heyzap.common.video.view.FullscreenVideoView;
import com.heyzap.house.abstr.AbstractActivity.AdActionListener;
import com.heyzap.http.AsyncHttpResponseHandler;
import com.heyzap.http.RequestParams;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.Header;

public class VASTActivity extends Activity implements AdActionListener {
    protected FrameLayout backgroundView;
    private AtomicBoolean completed = new AtomicBoolean(false);
    VASTModel model = null;
    private boolean pausedByActivityState = false;
    private Integer trackedQuartile = Integer.valueOf(0);
    private HashMap<TrackingEvent, List<String>> trackingEventMap;
    protected FullscreenVideoView videoView;

    class C15021 extends AsyncHttpResponseHandler {
        C15021() {
        }

        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        }

        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        this.model = (VASTModel) getIntent().getSerializableExtra("com.heyzap.vast.VASTModel");
        this.trackingEventMap = this.model.getTrackingUrls();
        prepare();
        setContentView(getContentView());
    }

    public void onBackPressed() {
        if (this.model.getVideoDisplayOptions().allowSkip) {
            super.onBackPressed();
            hide();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.videoView != null) {
            if (this.videoView.isPlaying()) {
                this.videoView.stop();
            }
            this.pausedByActivityState = true;
        }
    }

    public void onResume() {
        super.onResume();
        if (!(this.videoView == null || this.videoView.isPlaying() || !this.pausedByActivityState)) {
            this.videoView.resume();
        }
        this.pausedByActivityState = false;
    }

    public Boolean onPrepared() {
        this.backgroundView = new FrameLayout(this);
        this.backgroundView.setBackgroundColor(0);
        if (this.model.isFileCached().booleanValue() || this.model.getVideoDisplayOptions().allowStreamingFallback || this.model.getVideoDisplayOptions().forceStreaming) {
            this.videoView = new FullscreenVideoView(this, this.model, this);
            this.backgroundView.addView(this.videoView, new LayoutParams(-1, -1));
        }
        return Boolean.valueOf(true);
    }

    public View getContentView() {
        this.backgroundView.setLayoutParams(new LayoutParams(-1, -1));
        return this.backgroundView;
    }

    public void prepare() {
        onPrepared();
    }

    private void processEvent(TrackingEvent eventName) {
        try {
            if (eventName == TrackingEvent.start) {
                fireUrls(this.model.getImpressions());
            }
            fireUrls((List) this.model.getTrackingUrls().get(eventName));
        } catch (Exception e) {
            if (Utils.isDebug(this).booleanValue()) {
                throw new RuntimeException(e);
            }
            Logger.error("Error processing event: " + eventName, e);
        }
    }

    private void fireUrls(List<String> urls) {
        if (urls != null) {
            for (String url : urls) {
                APIClient.simpleGet(this, url, new RequestParams(), new C15021());
            }
        }
    }

    public void show() {
    }

    public void skip(Integer time) {
        dismiss(TrackingEvent.skip);
    }

    public void hide() {
        processEvent(TrackingEvent.closeLinear);
        dismiss(TrackingEvent.close);
    }

    public void completed() {
        this.completed.set(true);
        dismiss(TrackingEvent.complete);
    }

    private void dismiss(TrackingEvent event) {
        if (VASTInterstitial.listener != null) {
            if (this.completed.get()) {
                VASTInterstitial.listener.vastComplete();
            } else {
                VASTInterstitial.listener.vastIncomplete();
            }
            VASTInterstitial.listener.vastDismiss();
        }
        processEvent(event);
        finish();
    }

    public void click() {
        if (VASTInterstitial.listener != null) {
            VASTInterstitial.listener.vastClick();
        }
        String clickThroughUrl = this.model.getVideoClicks().getClickThrough();
        fireUrls(this.model.getVideoClicks().getClickTracking());
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(clickThroughUrl)));
        } catch (Throwable e) {
            Logger.trace(e);
        }
    }

    public void clickUrl(String url, String extraData) {
    }

    public void error() {
        if (VASTInterstitial.listener != null) {
            VASTInterstitial.listener.vastError(VASTError.VIDEO_PLAYBACK);
        }
        fireUrls(this.model.getErrorUrl());
        finish();
    }

    public void restart() {
        processEvent(TrackingEvent.rewind);
    }

    public void progress(int remainingTime, float percentComplete) {
        if (((int) Math.round(100.0d * ((double) percentComplete))) >= this.trackedQuartile.intValue() * 25) {
            if (this.trackedQuartile.intValue() == 0) {
                processEvent(TrackingEvent.start);
                if (VASTInterstitial.listener != null) {
                    VASTInterstitial.listener.vastStart();
                }
            } else if (this.trackedQuartile.intValue() == 1) {
                processEvent(TrackingEvent.firstQuartile);
            } else if (this.trackedQuartile.intValue() == 2) {
                processEvent(TrackingEvent.midpoint);
            } else if (this.trackedQuartile.intValue() == 3) {
                processEvent(TrackingEvent.thirdQuartile);
            }
            Integer num = this.trackedQuartile;
            this.trackedQuartile = Integer.valueOf(this.trackedQuartile.intValue() + 1);
        }
    }

    public void resume() {
        processEvent(TrackingEvent.resume);
    }
}
