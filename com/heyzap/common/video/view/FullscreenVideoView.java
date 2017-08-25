package com.heyzap.common.video.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.droidhang.pay.util.IabHelper;
import com.facebook.internal.AnalyticsEvents;
import com.heyzap.common.cache.Entry;
import com.heyzap.common.video.VideoDisplayOptions;
import com.heyzap.common.video.VideoModelInterface;
import com.heyzap.common.video.view.VideoControlView.OnActionListener;
import com.heyzap.house.abstr.AbstractActivity.AdActionListener;
import com.heyzap.internal.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class FullscreenVideoView extends FrameLayout {
    public int bufferProgress = 0;
    private VideoControlView controlView;
    private AdActionListener listener;
    public ProgressDialog loadingSpinner;
    private MediaPlayer mediaPlayer;
    private VideoModelInterface model;
    private MediaPlayerListener mpListener;
    private boolean pauseOnClick = true;
    private boolean pausedOnPurpose = false;
    private int playbackDuration = 0;
    public Timer playbackTimer;
    private int totalDuration = 0;
    public SurfaceView videoSurface;
    public Integer waitMillisBeforeSkipShow = Integer.valueOf(1);

    class C12991 extends TimerTask {
        C12991() {
        }

        public void run() {
            FullscreenVideoView.this.onVideoTick();
        }
    }

    private class MediaPlayerListener implements OnCompletionListener, OnBufferingUpdateListener, OnErrorListener, OnPreparedListener, OnVideoSizeChangedListener {
        private MediaPlayerListener() {
        }

        public void onPrepared(MediaPlayer mp) {
            if (FullscreenVideoView.this.loadingSpinner != null && FullscreenVideoView.this.loadingSpinner.isShowing()) {
                FullscreenVideoView.this.loadingSpinner.dismiss();
            }
            FullscreenVideoView.this.onVideoStart();
        }

        public boolean onError(MediaPlayer mp, int what, int extra) {
            String failureType;
            String failureExplain;
            if (FullscreenVideoView.this.loadingSpinner != null) {
                FullscreenVideoView.this.loadingSpinner.dismiss();
                FullscreenVideoView.this.loadingSpinner = null;
            }
            FullscreenVideoView.this.playbackTimer.cancel();
            FullscreenVideoView.this.playbackTimer.purge();
            switch (what) {
                case 100:
                    failureType = "Server Died.";
                    break;
                default:
                    failureType = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    break;
            }
            switch (extra) {
                case IabHelper.IABHELPER_INVALID_CONSUMPTION /*-1010*/:
                    failureExplain = "Unsupported.";
                    break;
                case IabHelper.IABHELPER_MISSING_TOKEN /*-1007*/:
                    failureExplain = "Malformed.";
                    break;
                case IabHelper.IABHELPER_SEND_INTENT_FAILED /*-1004*/:
                    failureExplain = "Error IO.";
                    break;
                case -110:
                    failureExplain = "Timed Out.";
                    break;
                case 200:
                    failureExplain = "Not Valid for Progressive Playback.";
                    break;
                default:
                    failureExplain = "Unknown.";
                    break;
            }
            Logger.log("MediaPlayer Error! What: " + failureType + " Extra: " + failureExplain);
            if (FullscreenVideoView.this.listener != null) {
                FullscreenVideoView.this.listener.error();
            }
            return true;
        }

        public void onBufferingUpdate(MediaPlayer mp, int percent) {
            FullscreenVideoView.this.bufferProgress = percent;
        }

        public void onCompletion(MediaPlayer mp) {
            FullscreenVideoView.this.playbackTimer.cancel();
            FullscreenVideoView.this.playbackTimer.purge();
            if (FullscreenVideoView.this.listener != null) {
                FullscreenVideoView.this.listener.completed();
            }
        }

        public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
            FullscreenVideoView.this.onVideoSizeChanged(width, height);
        }
    }

    private class OnVideoActionListener implements OnActionListener {
        private OnVideoActionListener() {
        }

        public void onSkip() {
            if (FullscreenVideoView.this.listener != null && FullscreenVideoView.this.mediaPlayer.isPlaying()) {
                int totalTimeWatched = FullscreenVideoView.this.mediaPlayer.getCurrentPosition();
                if (totalTimeWatched > FullscreenVideoView.this.playbackDuration) {
                    FullscreenVideoView.this.playbackDuration = totalTimeWatched;
                }
                FullscreenVideoView.this.listener.skip(Integer.valueOf(FullscreenVideoView.this.playbackDuration));
                FullscreenVideoView.this.mediaPlayer.pause();
            }
        }

        public void onHide() {
            if (FullscreenVideoView.this.listener == null) {
                return;
            }
            if (FullscreenVideoView.this.mediaPlayer.isPlaying()) {
                int totalTimeWatched = FullscreenVideoView.this.mediaPlayer.getCurrentPosition();
                if (totalTimeWatched > FullscreenVideoView.this.playbackDuration) {
                    FullscreenVideoView.this.playbackDuration = totalTimeWatched;
                }
                FullscreenVideoView.this.mediaPlayer.pause();
                FullscreenVideoView.this.listener.hide();
                return;
            }
            FullscreenVideoView.this.listener.hide();
        }

        public void onClick() {
            if (FullscreenVideoView.this.mediaPlayer != null && FullscreenVideoView.this.pauseOnClick) {
                FullscreenVideoView.this.mediaPlayer.pause();
            }
            if (FullscreenVideoView.this.listener != null) {
                FullscreenVideoView.this.listener.click();
            }
        }
    }

    private class VideoSurfaceViewCallback implements Callback {
        private AtomicBoolean hasAlreadyFired;

        private VideoSurfaceViewCallback() {
            this.hasAlreadyFired = new AtomicBoolean(false);
        }

        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            if (!FullscreenVideoView.this.pausedOnPurpose) {
                try {
                    if (this.hasAlreadyFired.get()) {
                        FullscreenVideoView.this.resume();
                    }
                    this.hasAlreadyFired.set(true);
                    FullscreenVideoView.this.mediaPlayer.start();
                } catch (Throwable e) {
                    Logger.trace(e);
                }
            }
        }

        public void surfaceCreated(SurfaceHolder holder) {
            try {
                FullscreenVideoView.this.mediaPlayer.setDisplay(holder);
            } catch (Throwable e) {
                Logger.trace(e);
            }
        }

        public void surfaceDestroyed(SurfaceHolder holder) {
            try {
                if (FullscreenVideoView.this.mediaPlayer != null && FullscreenVideoView.this.mediaPlayer.isPlaying()) {
                    FullscreenVideoView.this.mediaPlayer.pause();
                }
            } catch (Throwable e) {
                Logger.trace(e);
            }
        }
    }

    public FullscreenVideoView(Context context, VideoModelInterface model, AdActionListener listener) {
        super(context);
        this.model = model;
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.listener = listener;
        this.playbackTimer = new Timer();
        this.mpListener = new MediaPlayerListener();
        setBackgroundColor(0);
        addMediaPlayer();
        addControlSurface();
        showControls();
        render();
    }

    public void setPauseOnClick(boolean pauseOnClick) {
        this.pauseOnClick = pauseOnClick;
    }

    private void addMediaPlayer() {
        this.mediaPlayer = new MediaPlayer();
        this.mediaPlayer.setOnBufferingUpdateListener(this.mpListener);
        this.mediaPlayer.setOnCompletionListener(this.mpListener);
        this.mediaPlayer.setOnErrorListener(this.mpListener);
        this.mediaPlayer.setOnPreparedListener(this.mpListener);
        this.mediaPlayer.setOnVideoSizeChangedListener(this.mpListener);
        this.mediaPlayer.setScreenOnWhilePlaying(true);
        this.videoSurface = new SurfaceView(getContext());
        if (VERSION.SDK_INT < 11) {
            this.videoSurface.getHolder().setType(3);
        }
        this.videoSurface.getHolder().addCallback(new VideoSurfaceViewCallback());
        this.videoSurface.setVisibility(8);
        LayoutParams params = new LayoutParams(-1, -1);
        params.gravity = 17;
        addView(this.videoSurface, params);
    }

    private void addControlSurface() {
        this.controlView = new VideoControlView(getContext(), this.model);
        this.controlView.setOnActionListener(new OnVideoActionListener());
        addView(this.controlView, new LayoutParams(-1, -1));
    }

    public void showControls() {
        Activity activity = (Activity) getContext();
        Animation anim_fadein = AnimationUtils.loadAnimation(getContext(), 17432576);
        anim_fadein.setDuration(150);
        this.controlView.setVisibility(0);
        this.controlView.startAnimation(anim_fadein);
    }

    @SuppressLint({"NewApi"})
    public void hideControls() {
        this.controlView.setVisibility(8);
    }

    private void onVideoTick() {
        if (this.mediaPlayer == null || this.mediaPlayer.isPlaying()) {
            try {
                int remainingTime = this.mediaPlayer.getDuration() - this.mediaPlayer.getCurrentPosition();
                float percentComplete = ((float) this.mediaPlayer.getCurrentPosition()) / ((float) this.mediaPlayer.getDuration());
                this.listener.progress(remainingTime, percentComplete);
                if (this.model.getVideoDisplayOptions().allowAdTimer) {
                    this.controlView.updateScrubber(remainingTime, percentComplete);
                }
            } catch (Throwable e) {
                Logger.trace(e);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void onVideoStart() {
        VideoDisplayOptions options = this.model.getVideoDisplayOptions();
        if (this.listener != null) {
            this.listener.show();
        }
        setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        this.totalDuration = this.mediaPlayer.getDuration();
        this.videoSurface.setVisibility(0);
        if (this.playbackTimer != null) {
            this.playbackTimer.purge();
            this.playbackTimer = null;
        }
        this.playbackTimer = new Timer();
        this.playbackTimer.scheduleAtFixedRate(new C12991(), 0, 100);
        if (options.allowSkip) {
            if (options.lockoutTime > 0) {
                this.controlView.addSkipButton(Boolean.valueOf(true), (long) options.lockoutTime, options.skipLaterText, options.skipNowText);
            } else {
                this.controlView.addSkipButton(Boolean.valueOf(false), 0, options.skipLaterText, options.skipNowText);
            }
        } else if (options.allowHide) {
            this.controlView.addHideButton();
        }
        if (options.allowInstallButton) {
            this.controlView.addCtaButton(options.installButtonText);
        }
    }

    public void onVideoSizeChanged(int width, int height) {
        int screenWidth = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getWidth();
        int screenHeight = ((Activity) getContext()).getWindowManager().getDefaultDisplay().getHeight();
        int videoHeight = this.mediaPlayer.getVideoHeight();
        int videoWidth = this.mediaPlayer.getVideoWidth();
        Float overallRatio = Float.valueOf(((float) this.mediaPlayer.getVideoWidth()) / ((float) this.mediaPlayer.getVideoHeight()));
        if (videoWidth <= videoHeight || ((double) overallRatio.floatValue()) <= 1.6d) {
            videoHeight = -1;
            videoWidth = (int) ((((float) width) / ((float) height)) * ((float) screenHeight));
        } else {
            videoHeight = (int) ((((float) height) / ((float) width)) * ((float) screenWidth));
            videoWidth = -1;
        }
        LayoutParams params = (LayoutParams) this.videoSurface.getLayoutParams();
        params.width = videoWidth;
        params.height = videoHeight;
        this.videoSurface.setLayoutParams(params);
        this.controlView.setLayoutParams(params);
    }

    private Boolean render(Entry entry) {
        try {
            return render(entry.getFilename());
        } catch (Throwable e) {
            Logger.trace(e);
            return Boolean.valueOf(false);
        }
    }

    private Boolean render(Uri uri) {
        try {
            this.loadingSpinner = ProgressDialog.show(getContext(), "", "Loading...", true);
            this.mediaPlayer.setDataSource(getContext(), uri);
            this.mediaPlayer.prepareAsync();
            return Boolean.valueOf(true);
        } catch (Throwable e) {
            Logger.trace(e);
            return Boolean.valueOf(false);
        }
    }

    private Boolean render(String path) {
        Boolean valueOf;
        Throwable e;
        Throwable th;
        FileInputStream input = null;
        try {
            File file = new File(path);
            if (file.exists()) {
                FileInputStream input2 = new FileInputStream(file);
                try {
                    this.mediaPlayer.setDataSource(input2.getFD());
                    this.mediaPlayer.prepareAsync();
                    valueOf = Boolean.valueOf(true);
                    if (input2 != null) {
                        try {
                            input2.close();
                        } catch (Throwable e2) {
                            Logger.trace(e2);
                        }
                    }
                    input = input2;
                } catch (Exception e3) {
                    e2 = e3;
                    input = input2;
                    try {
                        Logger.trace(e2);
                        if (this.listener != null) {
                            this.listener.error();
                        }
                        valueOf = Boolean.valueOf(false);
                        if (input != null) {
                            try {
                                input.close();
                            } catch (Throwable e22) {
                                Logger.trace(e22);
                            }
                        }
                        return valueOf;
                    } catch (Throwable th2) {
                        th = th2;
                        if (input != null) {
                            try {
                                input.close();
                            } catch (Throwable e222) {
                                Logger.trace(e222);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    input = input2;
                    if (input != null) {
                        input.close();
                    }
                    throw th;
                }
                return valueOf;
            }
            throw new Exception("File does not exist.");
        } catch (Exception e4) {
            e222 = e4;
            Logger.trace(e222);
            if (this.listener != null) {
                this.listener.error();
            }
            valueOf = Boolean.valueOf(false);
            if (input != null) {
                input.close();
            }
            return valueOf;
        }
    }

    private Boolean render() {
        try {
            if (this.model.getVideoDisplayOptions().forceStreaming) {
                return render(this.model.getStreamingUri());
            }
            if (this.model.isFileCached().booleanValue()) {
                return render(this.model.getCacheEntry());
            }
            throw new Exception("local");
        } catch (Throwable e) {
            if (!e.getMessage().equals("local")) {
                Logger.trace(e);
            }
            if (this.model.getVideoDisplayOptions().allowStreamingFallback) {
                Logger.log("Local file not found. Falling back to stream and cancelling download.");
                return render(this.model.getStreamingUri());
            }
            Logger.log("Local file not found. No fallback to streaming.");
            throw new Exception("Local file not found. No fallback to streaming.");
        } catch (Throwable e2) {
            Logger.trace(e2);
            if (this.listener != null) {
                this.listener.error();
            }
            return Boolean.valueOf(false);
        }
    }

    public void clear() {
        if (this.playbackTimer != null) {
            this.playbackTimer.cancel();
            this.playbackTimer.purge();
        }
        if (this.mediaPlayer != null) {
            this.mediaPlayer.reset();
            this.mediaPlayer.release();
            this.mediaPlayer = null;
        }
    }

    public boolean isPlaying() {
        if (this.mediaPlayer == null) {
            return false;
        }
        return this.mediaPlayer.isPlaying();
    }

    public void stop() {
        if (this.mediaPlayer != null) {
            this.mediaPlayer.pause();
            this.pausedOnPurpose = true;
        }
    }

    public void hide(Boolean fireCallbacks) {
        if (this.playbackTimer != null) {
            this.playbackTimer.cancel();
            this.playbackTimer.purge();
        }
        if (this.mediaPlayer != null && this.mediaPlayer.isPlaying()) {
            this.mediaPlayer.stop();
            this.mediaPlayer.reset();
        }
        clear();
        if (fireCallbacks.booleanValue() && this.listener != null) {
            this.listener.hide();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        }
        if (this.mediaPlayer == null || !this.mediaPlayer.isPlaying()) {
            hide(Boolean.valueOf(true));
        }
        if (this.model.getVideoDisplayOptions().allowSkip && this.mediaPlayer != null && this.mediaPlayer.isPlaying()) {
            if (this.model.getVideoDisplayOptions().lockoutTime != 0 && (this.model.getVideoDisplayOptions().lockoutTime <= 0 || this.mediaPlayer.getCurrentPosition() <= this.model.getVideoDisplayOptions().lockoutTime)) {
                return true;
            }
            hide(Boolean.valueOf(true));
            return true;
        } else if (!this.model.getVideoDisplayOptions().allowHide) {
            return true;
        } else {
            hide(Boolean.valueOf(true));
            return true;
        }
    }

    public void restart() {
        if (this.listener != null) {
            this.listener.show();
        }
        this.mediaPlayer.start();
    }

    public void resume() {
        if (this.listener != null) {
            this.listener.resume();
            this.pausedOnPurpose = false;
        }
    }

    public int getPlaybackDuration() {
        return this.playbackDuration;
    }

    public int getTotalVideoDuration() {
        return this.totalDuration;
    }

    public Boolean isReady() {
        return Boolean.valueOf(false);
    }
}
