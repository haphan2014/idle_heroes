package com.heyzap.house.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.cast.TextTrackStyle;
import com.heyzap.house.abstr.AbstractActivity.AdActionListener;
import com.heyzap.house.model.AdModel;
import com.heyzap.house.model.InterstitialModel;
import com.heyzap.house.model.VideoModel;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;

public class InterstitialWebView extends FrameLayout {
    private static final int MAX_SIZE_DP_HEIGHT = 360;
    private static final int MAX_SIZE_DP_WIDTH = 360;
    private static final float MAX_SIZE_PERCENT = 0.98f;
    public Boolean contentLoaded = Boolean.valueOf(false);
    private Boolean globalTouchEnabled = Boolean.valueOf(false);
    private AdActionListener listener;
    private AdModel model;
    private long renderStartTime;
    private WrapperView wrapperView;

    class C13604 extends WebViewClient {
        AdModel model;

        C13604() {
        }

        public WebViewClient init(long in, AdModel in2) {
            this.model = in2;
            return this;
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (InterstitialWebView.this.listener != null) {
                if (url.contains("Heyzap.close")) {
                    InterstitialWebView.this.listener.hide();
                } else if (url.contains("Heyzap.restart")) {
                    InterstitialWebView.this.listener.restart();
                } else if (!url.contains("Heyzap.installHeyzap")) {
                    if (url.contains("Heyzap.clickAd")) {
                        InterstitialWebView.this.listener.click();
                    } else if (url.contains("Heyzap.clickManualAdUrl=")) {
                        int urlStart = url.indexOf("Heyzap.clickManualAdUrl=") + 24;
                        int separator = url.indexOf(":::");
                        int packageStart = separator + 3;
                        InterstitialWebView.this.listener.clickUrl(url.substring(urlStart, separator), url.substring(packageStart));
                    }
                }
            }
            return true;
        }

        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            InterstitialWebView.this.contentLoaded = Boolean.valueOf(false);
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            InterstitialWebView.this.contentLoaded = Boolean.valueOf(true);
            InterstitialWebView.this.wrapperView.setVisibility(0);
        }
    }

    class C13615 extends WebChromeClient {
        C13615() {
        }

        public void onConsoleMessage(String message, int lineNumber, String sourceID) {
            Logger.log("Console Message", message, Integer.valueOf(lineNumber), sourceID);
        }
    }

    class C13626 implements OnTouchListener {
        C13626() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (!InterstitialWebView.this.globalTouchEnabled.booleanValue() || event.getAction() != 0) {
                return false;
            }
            if (InterstitialWebView.this.listener != null) {
                InterstitialWebView.this.listener.click();
            }
            return true;
        }
    }

    private class CustomWebView extends WebView {
        public CustomWebView(Context context) {
            super(context.getApplicationContext());
            setBackgroundColor(0);
        }

        public boolean onKeyDown(int keyCode, KeyEvent event) {
            return InterstitialWebView.this.onKeyDown(keyCode, event);
        }
    }

    private class WrapperView extends RelativeLayout {
        private static final int OVERLAY_PADDING = 10;
        public FrameLayout container;
        public CustomWebView webview;

        public WrapperView(Context context) {
            super(context);
            setLayoutParams(new LayoutParams(-2, -2));
            setGravity(17);
            this.container = new FrameLayout(context);
            int scaledPadding = Utils.getScaledSize(context, 10);
            LayoutParams containerParams = new LayoutParams(-1, -1);
            containerParams.addRule(9);
            containerParams.addRule(10);
            addView(this.container, containerParams);
            this.webview = new CustomWebView(context);
            this.webview.setVisibility(0);
            this.webview.setVerticalScrollBarEnabled(false);
            this.webview.setHorizontalScrollBarEnabled(false);
            this.webview.setScrollBarStyle(33554432);
            this.webview.setBackgroundColor(0);
            this.container.addView(this.webview, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public InterstitialWebView(Context context, AdActionListener listener) {
        super(context);
        this.listener = listener;
        this.wrapperView = new WrapperView(context);
        addView(this.wrapperView);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void render(InterstitialModel ad) {
        this.model = ad;
        render(ad.getHtmlData(), ad.getWidth(), ad.getHeight(), ad.getBackgroundOverlayColor());
    }

    public void render(VideoModel ad) {
        this.model = ad;
        render(ad.getHtmlData(), ad.getInterstitialWidth(), ad.getInterstitialWidth(), Integer.valueOf(ad.getInterstitialBackgroundOverlayColor()));
    }

    private void render(String htmlString, int width, int height, Integer backgroundOverlayColor) {
        this.renderStartTime = System.currentTimeMillis();
        setupWebview();
        setTouchListener();
        final Activity activity = (Activity) getContext();
        final int i = width;
        final int i2 = height;
        final Integer num = backgroundOverlayColor;
        final String str = htmlString;
        activity.runOnUiThread(new Runnable() {
            public void run() {
                InterstitialWebView.this.setWidths(activity, i, i2);
                InterstitialWebView.this.setBackgroundColor(num.intValue());
                InterstitialWebView.this.wrapperView.webview.loadDataWithBaseURL(null, str, "text/html", null, null);
            }
        });
    }

    public void clear() {
        this.model = null;
        this.wrapperView.webview.loadDataWithBaseURL(null, "<html></html>", "text/html", null, null);
    }

    public void hide(final Boolean animated, final Boolean doCallback) {
        ((Activity) this.wrapperView.getContext()).runOnUiThread(new Runnable() {

            class C13571 implements AnimationListener {
                C13571() {
                }

                public void onAnimationEnd(Animation arg0) {
                    if (doCallback.booleanValue()) {
                        InterstitialWebView.this.viewDidHide();
                    }
                }

                public void onAnimationRepeat(Animation arg0) {
                }

                public void onAnimationStart(Animation arg0) {
                }
            }

            public void run() {
                if (animated.booleanValue()) {
                    Animation fadeOut = new AlphaAnimation(TextTrackStyle.DEFAULT_FONT_SCALE, 0.0f);
                    fadeOut.setDuration(150);
                    fadeOut.setInterpolator(new AccelerateInterpolator());
                    fadeOut.setAnimationListener(new C13571());
                    InterstitialWebView.this.wrapperView.startAnimation(fadeOut);
                } else if (doCallback.booleanValue()) {
                    InterstitialWebView.this.viewDidHide();
                }
            }
        });
    }

    public void hide(Boolean animated) {
        hide(animated, Boolean.valueOf(true));
    }

    private void showWithAnimation(final Boolean withCallback) {
        AnimationSet set = new AnimationSet(true);
        Animation animation = new AlphaAnimation(0.0f, TextTrackStyle.DEFAULT_FONT_SCALE);
        animation.setDuration(400);
        set.addAnimation(animation);
        animation.setAnimationListener(new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (withCallback.booleanValue()) {
                    InterstitialWebView.this.viewDidShow();
                }
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        setTouchListener();
        this.wrapperView.startAnimation(set);
    }

    private void viewDidShow() {
        this.wrapperView.webview.loadUrl("javascript: try{adViewShown();}catch(e){}");
    }

    private void viewDidHide() {
        this.wrapperView.webview.loadUrl("javascript: try{adViewHidden();} catch(e) {}");
    }

    private void setupWebview() {
        this.wrapperView.webview.getSettings().setJavaScriptEnabled(true);
        this.wrapperView.webview.getSettings().setLoadsImagesAutomatically(true);
        this.wrapperView.webview.getSettings().setCacheMode(1);
        WebViewClient customWebViewClient = new C13604().init(this.renderStartTime, this.model);
        WebChromeClient customWebChromeClient = new C13615();
        this.wrapperView.webview.setWebViewClient(customWebViewClient);
        this.wrapperView.webview.setWebChromeClient(customWebChromeClient);
    }

    private void setWidths(Context context, int width, int height) {
        Activity activity = (Activity) context;
        if (width == 0 && height == 0) {
            width = Math.round(((float) activity.getWindowManager().getDefaultDisplay().getWidth()) * MAX_SIZE_PERCENT);
            height = Math.round(((float) activity.getWindowManager().getDefaultDisplay().getHeight()) * MAX_SIZE_PERCENT);
            width = Math.min(Utils.getScaledSize(context, 360), width);
            height = Math.min(Utils.getScaledSize(context, 360), height);
            width = Math.min(width, height);
            height = Math.min(width, height);
        }
        int dp = Utils.dpToPx(context, 10);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.wrapperView.getLayoutParams();
        layoutParams.gravity = 17;
        layoutParams.width = width;
        layoutParams.height = height;
        setLayoutParams(layoutParams);
    }

    private void setTouchListener() {
        this.wrapperView.webview.setOnTouchListener(new C13626());
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        showWithAnimation(Boolean.valueOf(true));
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        }
        if (this.listener != null) {
            this.listener.hide();
        }
        return true;
    }
}
