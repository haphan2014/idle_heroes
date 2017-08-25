package org.nexage.sourcekit.mraid;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.internal.view.SupportMenu;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import java.util.ArrayList;

public class MRAIDBrowser extends Activity {
    public static final String MANAGER_EXTRA = "extra_manager";
    private static final String TAG = "MraidBrowser";
    public static final String URL_EXTRA = "extra_url";
    private ImageButton backButton;
    private ImageButton closeButton;
    private ImageButton forwardButton;
    private ImageButton refreshButton;
    private RelativeLayout rootLayout;
    private ArrayList<String> supportedNativeFeatures;
    private WebView webView;

    class C19551 extends WebViewClient {
        C19551() {
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            Toast.makeText((Activity) view.getContext(), "MRAID error: " + description, 0).show();
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url == null) {
                return false;
            }
            String host = Uri.parse(url).getHost();
            if (!url.startsWith("market:") && !url.startsWith("tel:") && !url.startsWith("voicemail:") && !url.startsWith("sms:") && !url.startsWith("mailto:") && !url.startsWith("geo:") && !url.startsWith("google.streetview:") && !"play.google.com".equals(host) && !"market.android.com".equals(host)) {
                return false;
            }
            try {
                if (url.startsWith("tel:")) {
                    if (MRAIDBrowser.this.supportedNativeFeatures.contains(MRAIDNativeFeature.TEL)) {
                        MRAIDBrowser.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    }
                } else if (!url.startsWith("sms:")) {
                    MRAIDBrowser.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                } else if (MRAIDBrowser.this.supportedNativeFeatures.contains(MRAIDNativeFeature.SMS)) {
                    MRAIDBrowser.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                }
            } catch (ActivityNotFoundException e) {
                Log.w("MoPub", "Unable to start activity for " + url + ". " + "Ensure that your phone can handle this intent.");
            }
            MRAIDBrowser.this.finish();
            return true;
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            MRAIDBrowser.this.forwardButton.setImageDrawable(Assets.getDrawableFromBase64(MRAIDBrowser.this.getResources(), Assets.unrightarrow));
        }

        public void onPageFinished(WebView view, String url) {
            Drawable backDrawable;
            Drawable forwardDrawable;
            super.onPageFinished(view, url);
            if (view.canGoBack()) {
                backDrawable = Assets.getDrawableFromBase64(MRAIDBrowser.this.getResources(), Assets.leftarrow);
            } else {
                backDrawable = Assets.getDrawableFromBase64(MRAIDBrowser.this.getResources(), Assets.unleftarrow);
            }
            MRAIDBrowser.this.backButton.setImageDrawable(backDrawable);
            if (view.canGoForward()) {
                forwardDrawable = Assets.getDrawableFromBase64(MRAIDBrowser.this.getResources(), Assets.rightarrow);
            } else {
                forwardDrawable = Assets.getDrawableFromBase64(MRAIDBrowser.this.getResources(), Assets.unrightarrow);
            }
            MRAIDBrowser.this.forwardButton.setImageDrawable(forwardDrawable);
        }
    }

    class C19562 extends WebChromeClient {
        C19562() {
        }

        public void onProgressChanged(WebView view, int progress) {
            Activity a = (Activity) view.getContext();
            a.setTitle("Loading...");
            a.setProgress(progress * 100);
            if (progress == 100) {
                a.setTitle(view.getUrl());
            }
        }
    }

    class C19573 implements OnClickListener {
        C19573() {
        }

        public void onClick(View v) {
            if (MRAIDBrowser.this.webView.canGoBack()) {
                MRAIDBrowser.this.webView.goBack();
            }
        }
    }

    class C19584 implements OnClickListener {
        C19584() {
        }

        public void onClick(View v) {
            if (MRAIDBrowser.this.webView.canGoForward()) {
                MRAIDBrowser.this.webView.goForward();
            }
        }
    }

    class C19595 implements OnClickListener {
        C19595() {
        }

        public void onClick(View v) {
            MRAIDBrowser.this.webView.reload();
        }
    }

    class C19606 implements OnClickListener {
        C19606() {
        }

        public void onClick(View v) {
            MRAIDBrowser.this.finish();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        if (getIntent().getExtras() != null) {
            this.supportedNativeFeatures = (ArrayList) getIntent().getExtras().getSerializable(MANAGER_EXTRA);
        }
        createUi();
        setButtonListeners();
        setContentView(this.rootLayout);
        initializeWebView(getIntent());
        enableCookies();
    }

    private void createUi() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int screenWidth = metrics.widthPixels;
        int screenHeight = metrics.heightPixels;
        float density = metrics.density;
        int densityDpi = metrics.densityDpi;
        String msg = "screen " + screenWidth + "x" + screenHeight + ", density=" + density + ", densityDpi=" + density + " (";
        switch (densityDpi) {
            case 120:
                msg = msg + "DENSITY_LOW)";
                break;
            case 160:
                msg = msg + "DENSITY_MEDIUM)";
                break;
            case 240:
                msg = msg + "DENSITY_HIGH)";
                break;
            case 320:
                msg = msg + "DENSITY_XHIGH)";
                break;
        }
        Log.d(TAG, msg);
        this.rootLayout = new RelativeLayout(this);
        this.rootLayout.setLayoutParams(new LayoutParams(-1, -1));
        this.rootLayout.setPadding(0, 0, 0, 0);
        this.rootLayout.setBackgroundColor(SupportMenu.CATEGORY_MASK);
        LinearLayout buttonLayout = new LinearLayout(this);
        LayoutParams params = new LayoutParams(-1, -2);
        params.addRule(12);
        buttonLayout.setLayoutParams(params);
        buttonLayout.setOrientation(0);
        buttonLayout.setPadding(0, 0, 0, 0);
        buttonLayout.setBackgroundDrawable(Assets.getDrawableFromBase64(getResources(), Assets.bkgrnd));
        buttonLayout.setId(View.generateViewId());
        int buttonWidth = screenWidth >>> 2;
        int buttonHeight = Math.min(buttonWidth >>> 1, screenHeight / 10);
        Log.d(TAG, "button size " + buttonWidth + "x" + buttonHeight + " min(" + (buttonWidth / 2) + "," + (screenHeight / 10) + ")");
        int padding = buttonHeight >>> 3;
        Log.d(TAG, "padding " + padding);
        this.backButton = createButton(buttonWidth, buttonHeight, padding, Assets.unleftarrow);
        this.forwardButton = createButton(buttonWidth, buttonHeight, padding, Assets.unrightarrow);
        this.refreshButton = createButton(buttonWidth, buttonHeight, padding, Assets.refresh);
        this.closeButton = createButton(buttonWidth, buttonHeight, padding, Assets.mraidClose);
        buttonLayout.addView(this.backButton);
        buttonLayout.addView(this.forwardButton);
        buttonLayout.addView(this.refreshButton);
        buttonLayout.addView(this.closeButton);
        this.rootLayout.addView(buttonLayout);
        this.webView = new WebView(this);
        params = new LayoutParams(-1, -1);
        params.addRule(2, buttonLayout.getId());
        this.webView.setLayoutParams(params);
        this.rootLayout.addView(this.webView);
    }

    ImageButton createButton(int width, int height, int padding, String pngSrc) {
        ImageButton button = new ImageButton(this);
        button.setImageDrawable(Assets.getDrawableFromBase64(getResources(), pngSrc));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        params.gravity = 16;
        button.setLayoutParams(params);
        button.setPadding(0, padding, 0, padding);
        button.setScaleType(ScaleType.FIT_CENTER);
        button.setBackgroundColor(0);
        return button;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initializeWebView(Intent intent) {
        WebSettings webSettings = this.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setUseWideViewPort(true);
        this.webView.loadUrl(intent.getStringExtra(URL_EXTRA));
        this.webView.setWebViewClient(new C19551());
        this.webView.setWebChromeClient(new C19562());
    }

    private void setButtonListeners() {
        this.backButton.setOnClickListener(new C19573());
        this.forwardButton.setOnClickListener(new C19584());
        this.refreshButton.setOnClickListener(new C19595());
        this.closeButton.setOnClickListener(new C19606());
    }

    private void enableCookies() {
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    protected void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
    }

    protected void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
    }
}
