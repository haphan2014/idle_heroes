package org.nexage.sourcekit.mraid;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.heyzap.http.AsyncHttpResponseHandler;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.nexage.sourcekit.mraid.internal.MRAIDHtmlProcessor;
import org.nexage.sourcekit.mraid.internal.MRAIDLog;
import org.nexage.sourcekit.mraid.internal.MRAIDNativeFeatureManager;
import org.nexage.sourcekit.mraid.properties.MRAIDOrientationProperties;
import org.nexage.sourcekit.mraid.properties.MRAIDResizeProperties;

@SuppressLint({"ViewConstructor"})
public class MRAIDView extends RelativeLayout {
    private static final int CLOSE_REGION_SIZE = 50;
    private static final String[] COMMANDS_WITH_MAP = new String[]{"setOrientationProperties", "setResizeProperties"};
    private static final String[] COMMANDS_WITH_NO_PARAM = new String[]{"close", "resize"};
    private static final String[] COMMANDS_WITH_STRING = new String[]{"createCalendarEvent", "expand", "open", "playVideo", MRAIDNativeFeature.STORE_PICTURE, "useCustomClose"};
    private static final String MRAID_LOG_TAG = "MRAIDView";
    public static final int STATE_DEFAULT = 1;
    public static final int STATE_EXPANDED = 2;
    public static final int STATE_HIDDEN = 4;
    public static final int STATE_LOADING = 0;
    public static final int STATE_RESIZED = 3;
    private final String baseUrl;
    private ImageButton closeRegion;
    private int contentViewTop;
    private final Context context;
    private Rect currentPosition;
    @Nullable
    private WebView currentWebView;
    private Rect defaultPosition;
    private final DisplayMetrics displayMetrics;
    private RelativeLayout expandedView;
    private final GestureDetector gestureDetector;
    protected Handler handler;
    private int injections = 0;
    private boolean isActionBarShowing;
    private boolean isClosing;
    private boolean isExpanded;
    private boolean isExpandingFromDefault;
    private boolean isExpandingPart2;
    private boolean isForceNotFullScreen;
    private boolean isForcingFullScreen;
    private boolean isFullScreen;
    private final boolean isInterstitial;
    protected boolean isLaidOut;
    protected boolean isPageFinished;
    protected boolean isViewable;
    protected MRAIDViewListener listener;
    private Size maxSize;
    private String mraidJs;
    private final MRAIDWebChromeClient mraidWebChromeClient;
    private final MRAIDWebViewClient mraidWebViewClient;
    private final MRAIDNativeFeatureListener nativeFeatureListener;
    private final MRAIDNativeFeatureManager nativeFeatureManager;
    private final MRAIDOrientationProperties orientationProperties;
    private int origTitleBarVisibility;
    private final int originalRequestedOrientation;
    private final MRAIDResizeProperties resizeProperties;
    private RelativeLayout resizedView;
    private Size screenSize;
    private Activity showActivity;
    protected int state;
    private View titleBar;
    private boolean useCustomClose;
    private boolean wasTouched = false;
    protected WebView webView;
    private WebView webViewPart2;

    class C19621 extends SimpleOnGestureListener {
        C19621() {
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return true;
        }
    }

    class C19643 implements OnTouchListener {
        C19643() {
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View v, MotionEvent event) {
            MRAIDView.this.wasTouched = true;
            switch (event.getAction()) {
                case 0:
                case 1:
                    if (!v.hasFocus()) {
                        v.requestFocus();
                        break;
                    }
                    break;
            }
            return false;
        }
    }

    class C19654 implements Runnable {
        C19654() {
        }

        public void run() {
            if (MRAIDView.this.state == 1 || MRAIDView.this.state == 2) {
                MRAIDView.this.closeFromExpanded();
            } else if (MRAIDView.this.state == 3) {
                MRAIDView.this.closeFromResized();
            }
        }
    }

    class C19686 implements Runnable {
        C19686() {
        }

        public void run() {
            MRAIDView.this.fireStateChangeEvent();
        }
    }

    class C19697 implements Runnable {
        C19697() {
        }

        public void run() {
            MRAIDView.this.restoreOriginalOrientation();
            MRAIDView.this.restoreOriginalScreenState();
        }
    }

    class C19708 implements Runnable {
        C19708() {
        }

        public void run() {
            MRAIDView.this.fireStateChangeEvent();
            if (MRAIDView.this.listener != null) {
                MRAIDView.this.listener.mraidViewClose(MRAIDView.this);
            }
        }
    }

    class C19719 implements Runnable {
        C19719() {
        }

        public void run() {
            MRAIDView.this.fireStateChangeEvent();
            if (MRAIDView.this.listener != null) {
                MRAIDView.this.listener.mraidViewClose(MRAIDView.this);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MRAIDState {
    }

    private class MRAIDWebChromeClient extends WebChromeClient {
        private MRAIDWebChromeClient() {
        }

        public boolean onConsoleMessage(ConsoleMessage cm) {
            if (cm == null || cm.message() == null) {
                return false;
            }
            MRAIDLog.m2734i("JS console", cm.message() + (cm.sourceId() == null ? "" : " at " + cm.sourceId()) + ":" + cm.lineNumber());
            return true;
        }

        public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
            MRAIDLog.m2729d("hz-m MRAIDView ChromeClient - onJsBeforeUnload");
            return true;
        }

        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            MRAIDLog.m2730d("JS alert", message);
            return handlePopups(result);
        }

        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            MRAIDLog.m2730d("JS confirm", message);
            return handlePopups(result);
        }

        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            MRAIDLog.m2730d("JS prompt", message);
            return handlePopups(result);
        }

        private boolean handlePopups(JsResult result) {
            result.cancel();
            return true;
        }

        public void onProgressChanged(WebView view, int newProgress) {
            MRAIDLog.m2729d("hz-m MRAIDView ChromeClient - onProgressChanged " + newProgress + " wv: " + MRAIDView.this.webView + " view: " + MRAIDView.this);
        }

        public void onShowCustomView(View view, CustomViewCallback callback) {
            MRAIDLog.m2729d("hz-m MRAIDView ChromeClient - showCustomView");
        }

        public void onCloseWindow(WebView window) {
            MRAIDLog.m2729d("hz-m MRAIDView ChromeClient - onCloseWindow");
        }

        public void onExceededDatabaseQuota(String url, String databaseIdentifier, long quota, long estimatedDatabaseSize, long totalQuota, QuotaUpdater quotaUpdater) {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onExceededDatabaseQuota");
            quotaUpdater.updateQuota(quota);
        }

        public void onReachedMaxAppCacheSize(long requiredStorage, long quota, QuotaUpdater quotaUpdater) {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onReachedMaxAppCacheSize");
            quotaUpdater.updateQuota(quota);
        }

        public void onPermissionRequest(PermissionRequest request) {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onPermissionRequest");
        }

        public boolean onJsTimeout() {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onJsTimeout");
            return true;
        }
    }

    private class MRAIDWebViewClient extends WebViewClient {

        class C19721 implements Runnable {
            C19721() {
            }

            public void run() {
                MRAIDView.this.injectJavaScript("mraid.setPlacementType('" + (MRAIDView.this.isInterstitial ? "interstitial" : "inline") + "');");
                MRAIDView.this.setSupportedServices();
                MRAIDView.this.setScreenSize();
                MRAIDView.this.setDefaultPosition();
                MRAIDLog.m2730d(MRAIDView.MRAID_LOG_TAG, "calling fireStateChangeEvent 2");
                MRAIDView.this.fireStateChangeEvent();
                MRAIDView.this.fireReadyEvent();
                if (MRAIDView.this.isViewable) {
                    MRAIDView.this.fireViewableChangeEvent();
                }
            }
        }

        class C19732 implements Runnable {
            C19732() {
            }

            public void run() {
                MRAIDView.injectJavaScript(MRAIDView.this.webView, "mraid.logLevel = mraid.LogLevelEnum.DEBUG;");
            }
        }

        private MRAIDWebViewClient() {
        }

        public void onPageFinished(WebView view, String url) {
            MRAIDLog.m2730d(MRAIDView.MRAID_LOG_TAG, "onPageFinished: " + url);
            super.onPageFinished(view, url);
            if (MRAIDView.this.state == 0) {
                MRAIDView.this.isPageFinished = true;
                MRAIDView.this.injectJavaScript("mraid.setPlacementType('" + (MRAIDView.this.isInterstitial ? "interstitial" : "inline") + "');");
                MRAIDView.this.setSupportedServices();
                if (MRAIDView.this.isLaidOut) {
                    MRAIDView.this.setScreenSize();
                    MRAIDView.this.setMaxSize();
                    MRAIDView.this.setCurrentPosition();
                    MRAIDView.this.setDefaultPosition();
                    if (MRAIDView.this.isInterstitial) {
                        MRAIDView.this.showAsInterstitial(MRAIDView.this.showActivity);
                    } else {
                        MRAIDView.this.state = 1;
                        MRAIDView.this.fireStateChangeEvent();
                        MRAIDView.this.fireReadyEvent();
                        if (MRAIDView.this.isViewable) {
                            MRAIDView.this.fireViewableChangeEvent();
                        }
                    }
                }
                if (MRAIDView.this.listener != null) {
                    MRAIDView.this.listener.mraidViewLoaded(MRAIDView.this);
                }
            }
            if (MRAIDView.this.isExpandingPart2) {
                MRAIDView.this.isExpandingPart2 = false;
                MRAIDView.this.handler.post(new C19721());
            }
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onPageStarted");
        }

        public void onPageCommitVisible(WebView view, String url) {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onPageCommitVisibile");
        }

        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onReceivedError");
        }

        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onReceivedHttpError");
        }

        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onReceivedSslError");
        }

        public void onTooManyRedirects(WebView view, Message cancelMsg, Message continueMsg) {
            cancelMsg.sendToTarget();
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onTooManyRedirects");
        }

        public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onReceivedClientCertRequest");
        }

        public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onReceivedHttpAuthRequest");
            handler.cancel();
        }

        public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - shouldOverrideKeyEvent");
            return false;
        }

        public void onScaleChanged(WebView view, float oldScale, float newScale) {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onScaleChanged");
        }

        public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
            MRAIDLog.m2729d("hz-m MRAIDView WebViewClient - onReceivedLoginRequest");
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            MRAIDLog.m2730d(MRAIDView.MRAID_LOG_TAG, "onReceivedError: " + description);
            super.onReceivedError(view, errorCode, description, failingUrl);
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            MRAIDLog.m2730d(MRAIDView.MRAID_LOG_TAG, "shouldOverrideUrlLoading: " + url);
            if (url.startsWith("mraid://")) {
                MRAIDView.this.parseCommandUrl(url);
            } else {
                try {
                    MRAIDView.this.open(URLEncoder.encode(url, AsyncHttpResponseHandler.DEFAULT_CHARSET));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }

        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            MRAIDLog.m2729d("hz-m shouldInterceptRequest - " + url);
            if (!url.contains("mraid.js")) {
                return null;
            }
            MRAIDLog.m2729d("hz-m shouldInterceptRequest - intercepting mraid - " + url);
            MRAIDView.this.handler.post(new C19732());
            return new WebResourceResponse("application/javascript", AsyncHttpResponseHandler.DEFAULT_CHARSET, MRAIDView.this.getMraidJsStream());
        }
    }

    private static class Size {
        public int height;
        public int width;

        private Size() {
        }
    }

    public int getState() {
        return this.state;
    }

    public MRAIDView(Context context, String baseUrl, String data, String[] supportedNativeFeatures, MRAIDViewListener listener, MRAIDNativeFeatureListener nativeFeatureListener, boolean isInterstitial) {
        super(context);
        this.context = context;
        this.showActivity = (Activity) context;
        if (baseUrl == null) {
            baseUrl = "http://example.com/";
        }
        this.baseUrl = baseUrl;
        this.isInterstitial = isInterstitial;
        this.state = 0;
        this.isViewable = false;
        this.useCustomClose = false;
        this.orientationProperties = new MRAIDOrientationProperties();
        this.resizeProperties = new MRAIDResizeProperties();
        this.nativeFeatureManager = new MRAIDNativeFeatureManager(context, new ArrayList(Arrays.asList(supportedNativeFeatures)));
        this.listener = listener;
        this.nativeFeatureListener = nativeFeatureListener;
        this.displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(this.displayMetrics);
        this.currentPosition = new Rect();
        this.defaultPosition = new Rect();
        this.maxSize = new Size();
        this.screenSize = new Size();
        if (this.context instanceof Activity) {
            this.originalRequestedOrientation = ((Activity) context).getRequestedOrientation();
        } else {
            this.originalRequestedOrientation = -1;
        }
        MRAIDLog.m2730d(MRAID_LOG_TAG, "originalRequestedOrientation " + getOrientationString(this.originalRequestedOrientation));
        this.gestureDetector = new GestureDetector(getContext(), new C19621());
        this.handler = new Handler(Looper.getMainLooper());
        this.mraidWebChromeClient = new MRAIDWebChromeClient();
        this.mraidWebViewClient = new MRAIDWebViewClient();
        this.webView = createWebView();
        this.currentWebView = this.webView;
        MRAIDLog.m2729d("hz-m loading mraid " + MRAIDHtmlProcessor.processRawHtml(data));
        this.webView.loadDataWithBaseURL(this.baseUrl, MRAIDHtmlProcessor.processRawHtml(data), "text/html", AsyncHttpResponseHandler.DEFAULT_CHARSET, null);
        String jsLogLevel = "NONE";
        switch (MRAIDLog.getLoggingLevel()) {
            case verbose:
            case debug:
                jsLogLevel = "DEBUG";
                return;
            case info:
                jsLogLevel = "INFO";
                return;
            case warning:
                jsLogLevel = "WARNING";
                return;
            case error:
                jsLogLevel = "ERROR";
                return;
            default:
                return;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private WebView createWebView() {
        WebView wv = new WebView(this.context) {
            private static final String TAG = "MRAIDView-WebView";

            protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
                super.onLayout(changed, left, top, right, bottom);
                MRAIDView.this.onLayoutWebView(this, changed, left, top, right, bottom);
            }

            public void onConfigurationChanged(Configuration newConfig) {
                super.onConfigurationChanged(newConfig);
                MRAIDLog.m2730d(TAG, "onConfigurationChanged " + (newConfig.orientation == 1 ? "portrait" : "landscape"));
                if (MRAIDView.this.isInterstitial) {
                    ((Activity) MRAIDView.this.context).getWindowManager().getDefaultDisplay().getMetrics(MRAIDView.this.displayMetrics);
                }
            }

            protected void onVisibilityChanged(View changedView, int visibility) {
                super.onVisibilityChanged(changedView, visibility);
                MRAIDLog.m2730d(TAG, "onVisibilityChanged " + MRAIDView.getVisibilityString(visibility));
                if (MRAIDView.this.isInterstitial) {
                    MRAIDView.this.setViewable(visibility);
                }
            }

            protected void onWindowVisibilityChanged(int visibility) {
                super.onWindowVisibilityChanged(visibility);
                int actualVisibility = getVisibility();
                MRAIDLog.m2730d(TAG, "onWindowVisibilityChanged " + MRAIDView.getVisibilityString(visibility) + " (actual " + MRAIDView.getVisibilityString(actualVisibility) + ')');
                if (MRAIDView.this.isInterstitial) {
                    MRAIDView.this.setViewable(actualVisibility);
                }
                if (visibility == 0) {
                }
            }
        };
        wv.setScrollContainer(false);
        wv.setVerticalScrollBarEnabled(false);
        wv.setHorizontalScrollBarEnabled(false);
        wv.setScrollBarStyle(33554432);
        wv.setFocusableInTouchMode(true);
        wv.setOnTouchListener(new C19643());
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setAllowContentAccess(true);
        wv.getSettings().setBlockNetworkImage(false);
        wv.getSettings().setBuiltInZoomControls(false);
        wv.getSettings().setUseWideViewPort(false);
        wv.getSettings().setLoadsImagesAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            wv.getSettings().setMixedContentMode(0);
        }
        wv.getSettings().setSupportZoom(false);
        wv.setWebChromeClient(this.mraidWebChromeClient);
        wv.setWebViewClient(this.mraidWebViewClient);
        if (VERSION.SDK_INT >= 17) {
            wv.getSettings().setMediaPlaybackRequiresUserGesture(false);
        }
        if (VERSION.SDK_INT >= 19 && (this.context.getApplicationInfo().flags & 2) != 0) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        return wv;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent event) {
        if (this.gestureDetector.onTouchEvent(event)) {
            event.setAction(3);
        }
        return super.onTouchEvent(event);
    }

    public void clearView() {
        if (this.webView != null) {
            this.webView.setWebChromeClient(null);
            this.webView.setWebViewClient(null);
            this.webView.loadUrl("about:blank");
        }
    }

    public boolean isExpanded() {
        return this.isExpanded;
    }

    public void destroy() {
        if (this.webView != null) {
            MRAIDLog.m2733i("Destroying Main WebView");
            destroyWebView(this.webView);
        }
        if (this.webViewPart2 != null) {
            MRAIDLog.m2733i("Destroying Secondary WebView");
            destroyWebView(this.webViewPart2);
        }
        if (this.expandedView != null) {
            ViewGroup parent = (ViewGroup) this.expandedView.getParent();
            if (parent != null) {
                parent.removeView(this.expandedView);
            }
            this.expandedView = null;
        }
        this.currentWebView = null;
    }

    private static void destroyWebView(@NonNull WebView wv) {
        wv.clearHistory();
        wv.clearCache(true);
        wv.loadUrl("about:blank");
        wv.pauseTimers();
        wv.setWebChromeClient(null);
        wv.setWebViewClient(null);
        wv.destroy();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseCommandUrl(java.lang.String r12) {
        /*
        r11 = this;
        r8 = 1;
        r6 = 0;
        r7 = "MRAIDView";
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = "parseCommandUrl ";
        r9 = r9.append(r10);
        r9 = r9.append(r12);
        r9 = r9.toString();
        org.nexage.sourcekit.mraid.internal.MRAIDLog.m2730d(r7, r9);
        r4 = new org.nexage.sourcekit.mraid.internal.MRAIDParser;
        r4.<init>();
        r1 = r4.parseCommandUrl(r12);
        r7 = "command";
        r0 = r1.get(r7);
        r0 = (java.lang.String) r0;
        r7 = COMMANDS_WITH_NO_PARAM;	 Catch:{ Exception -> 0x0060 }
        r7 = java.util.Arrays.asList(r7);	 Catch:{ Exception -> 0x0060 }
        r7 = r7.contains(r0);	 Catch:{ Exception -> 0x0060 }
        if (r7 == 0) goto L_0x0065;
    L_0x0037:
        r6 = r11.getClass();	 Catch:{ NoSuchMethodException -> 0x0049 }
        r7 = 0;
        r7 = new java.lang.Class[r7];	 Catch:{ NoSuchMethodException -> 0x0049 }
        r6 = r6.getDeclaredMethod(r0, r7);	 Catch:{ NoSuchMethodException -> 0x0049 }
        r7 = 0;
        r7 = new java.lang.Object[r7];	 Catch:{ NoSuchMethodException -> 0x0049 }
        r6.invoke(r11, r7);	 Catch:{ NoSuchMethodException -> 0x0049 }
    L_0x0048:
        return;
    L_0x0049:
        r2 = move-exception;
        r6 = r11.getClass();	 Catch:{ Exception -> 0x0060 }
        r6 = r6.getSuperclass();	 Catch:{ Exception -> 0x0060 }
        r7 = 0;
        r7 = new java.lang.Class[r7];	 Catch:{ Exception -> 0x0060 }
        r6 = r6.getDeclaredMethod(r0, r7);	 Catch:{ Exception -> 0x0060 }
        r7 = 0;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0060 }
        r6.invoke(r11, r7);	 Catch:{ Exception -> 0x0060 }
        goto L_0x0048;
    L_0x0060:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x0048;
    L_0x0065:
        r7 = COMMANDS_WITH_STRING;	 Catch:{ Exception -> 0x0060 }
        r7 = java.util.Arrays.asList(r7);	 Catch:{ Exception -> 0x0060 }
        r7 = r7.contains(r0);	 Catch:{ Exception -> 0x0060 }
        if (r7 == 0) goto L_0x00d7;
    L_0x0071:
        r7 = -1;
        r9 = r0.hashCode();	 Catch:{ Exception -> 0x0060 }
        switch(r9) {
            case -733616544: goto L_0x00be;
            case 1614272768: goto L_0x00c7;
            default: goto L_0x0079;
        };	 Catch:{ Exception -> 0x0060 }
    L_0x0079:
        r6 = r7;
    L_0x007a:
        switch(r6) {
            case 0: goto L_0x00d1;
            case 1: goto L_0x00d4;
            default: goto L_0x007d;
        };	 Catch:{ Exception -> 0x0060 }
    L_0x007d:
        r3 = "url";
    L_0x007f:
        r5 = r1.get(r3);	 Catch:{ Exception -> 0x0060 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0060 }
        r6 = r11.getClass();	 Catch:{ NoSuchMethodException -> 0x009f }
        r7 = 1;
        r7 = new java.lang.Class[r7];	 Catch:{ NoSuchMethodException -> 0x009f }
        r8 = 0;
        r9 = java.lang.String.class;
        r7[r8] = r9;	 Catch:{ NoSuchMethodException -> 0x009f }
        r6 = r6.getDeclaredMethod(r0, r7);	 Catch:{ NoSuchMethodException -> 0x009f }
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NoSuchMethodException -> 0x009f }
        r8 = 0;
        r7[r8] = r5;	 Catch:{ NoSuchMethodException -> 0x009f }
        r6.invoke(r11, r7);	 Catch:{ NoSuchMethodException -> 0x009f }
        goto L_0x0048;
    L_0x009f:
        r2 = move-exception;
        r6 = r11.getClass();	 Catch:{ Exception -> 0x0060 }
        r6 = r6.getSuperclass();	 Catch:{ Exception -> 0x0060 }
        r7 = 1;
        r7 = new java.lang.Class[r7];	 Catch:{ Exception -> 0x0060 }
        r8 = 0;
        r9 = java.lang.String.class;
        r7[r8] = r9;	 Catch:{ Exception -> 0x0060 }
        r6 = r6.getDeclaredMethod(r0, r7);	 Catch:{ Exception -> 0x0060 }
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0060 }
        r8 = 0;
        r7[r8] = r5;	 Catch:{ Exception -> 0x0060 }
        r6.invoke(r11, r7);	 Catch:{ Exception -> 0x0060 }
        goto L_0x0048;
    L_0x00be:
        r8 = "createCalendarEvent";
        r8 = r0.equals(r8);	 Catch:{ Exception -> 0x0060 }
        if (r8 == 0) goto L_0x0079;
    L_0x00c6:
        goto L_0x007a;
    L_0x00c7:
        r6 = "useCustomClose";
        r6 = r0.equals(r6);	 Catch:{ Exception -> 0x0060 }
        if (r6 == 0) goto L_0x0079;
    L_0x00cf:
        r6 = r8;
        goto L_0x007a;
    L_0x00d1:
        r3 = "eventJSON";
        goto L_0x007f;
    L_0x00d4:
        r3 = "useCustomClose";
        goto L_0x007f;
    L_0x00d7:
        r6 = COMMANDS_WITH_MAP;	 Catch:{ Exception -> 0x0060 }
        r6 = java.util.Arrays.asList(r6);	 Catch:{ Exception -> 0x0060 }
        r6 = r6.contains(r0);	 Catch:{ Exception -> 0x0060 }
        if (r6 == 0) goto L_0x0048;
    L_0x00e3:
        r6 = r11.getClass();	 Catch:{ NoSuchMethodException -> 0x00fe }
        r7 = 1;
        r7 = new java.lang.Class[r7];	 Catch:{ NoSuchMethodException -> 0x00fe }
        r8 = 0;
        r9 = java.util.Map.class;
        r7[r8] = r9;	 Catch:{ NoSuchMethodException -> 0x00fe }
        r6 = r6.getDeclaredMethod(r0, r7);	 Catch:{ NoSuchMethodException -> 0x00fe }
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ NoSuchMethodException -> 0x00fe }
        r8 = 0;
        r7[r8] = r1;	 Catch:{ NoSuchMethodException -> 0x00fe }
        r6.invoke(r11, r7);	 Catch:{ NoSuchMethodException -> 0x00fe }
        goto L_0x0048;
    L_0x00fe:
        r2 = move-exception;
        r6 = r11.getClass();	 Catch:{ Exception -> 0x0060 }
        r6 = r6.getSuperclass();	 Catch:{ Exception -> 0x0060 }
        r7 = 1;
        r7 = new java.lang.Class[r7];	 Catch:{ Exception -> 0x0060 }
        r8 = 0;
        r9 = java.util.Map.class;
        r7[r8] = r9;	 Catch:{ Exception -> 0x0060 }
        r6 = r6.getDeclaredMethod(r0, r7);	 Catch:{ Exception -> 0x0060 }
        r7 = 1;
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0060 }
        r8 = 0;
        r7[r8] = r1;	 Catch:{ Exception -> 0x0060 }
        r6.invoke(r11, r7);	 Catch:{ Exception -> 0x0060 }
        goto L_0x0048;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.nexage.sourcekit.mraid.MRAIDView.parseCommandUrl(java.lang.String):void");
    }

    public boolean onBackPressed() {
        MRAIDLog.m2729d("hz-m MRAIDView - onBackPressed");
        if (this.state == 0 || this.state == 4) {
            MRAIDLog.m2729d("hz-m MRAIDView - onBackPressed - loading or hidden");
            return false;
        }
        close();
        return true;
    }

    @JavascriptMRAIDCallback
    protected void close() {
        MRAIDLog.m2730d("MRAIDView-JS callback", "close");
        MRAIDLog.m2729d("hz-m closing wv: " + this.webView);
        this.handler.post(new C19654());
    }

    @JavascriptMRAIDCallback
    private void createCalendarEvent(String eventJSON) {
        MRAIDLog.m2730d("MRAIDView-JS callback", "createCalendarEvent " + eventJSON);
        if (this.nativeFeatureListener != null) {
            this.nativeFeatureListener.mraidNativeFeatureCreateCalendarEvent(eventJSON);
        }
    }

    @TargetApi(11)
    @JavascriptMRAIDCallback
    protected void expand(String url) {
        MRAIDLog.m2729d("hz-m MRAIDView - expand " + url);
        MRAIDLog.m2730d("MRAIDView-JS callback", "expand " + (url != null ? url : "(1-part)"));
        if (TextUtils.isEmpty(url)) {
            if (this.state == 0 || this.state == 1) {
                if (this.webView.getParent() != null) {
                    ((ViewGroup) this.webView.getParent()).removeView(this.webView);
                } else {
                    removeView(this.webView);
                }
            } else if (this.state == 3) {
                removeResizeView();
            }
            expandHelper(this.webView);
            MRAIDLog.m2729d("hz-m MRAIDView - expand - empty url");
            return;
        }
        try {
            url = URLDecoder.decode(url, AsyncHttpResponseHandler.DEFAULT_CHARSET);
            if (!(url.startsWith("http://") || url.startsWith("https://"))) {
                url = this.baseUrl + url;
            }
            final String finalUrl = url;
            new Thread(new Runnable() {
                public void run() {
                    MRAIDLog.m2729d("hz-m MRAIDView - expand - url loading thread");
                    final String content = MRAIDView.this.getStringFromUrl(finalUrl);
                    if (TextUtils.isEmpty(content)) {
                        MRAIDLog.m2731e("Could not load part 2 expanded content for URL: " + finalUrl);
                    } else {
                        ((Activity) MRAIDView.this.context).runOnUiThread(new Runnable() {
                            public void run() {
                                if (MRAIDView.this.state == 3) {
                                    MRAIDView.this.removeResizeView();
                                    MRAIDView.this.addView(MRAIDView.this.webView);
                                }
                                MRAIDView.this.webView.setWebChromeClient(null);
                                MRAIDView.this.webView.setWebViewClient(null);
                                MRAIDView.this.webViewPart2 = MRAIDView.this.createWebView();
                                MRAIDView.this.webViewPart2.loadDataWithBaseURL(MRAIDView.this.baseUrl, content, "text/html", AsyncHttpResponseHandler.DEFAULT_CHARSET, null);
                                MRAIDLog.m2729d("hz-m MRAIDView - expand - switching out currentwebview for " + MRAIDView.this.webViewPart2);
                                MRAIDView.this.currentWebView = MRAIDView.this.webViewPart2;
                                MRAIDView.this.isExpandingPart2 = true;
                                MRAIDView.this.expandHelper(MRAIDView.this.currentWebView);
                            }
                        });
                    }
                }
            }, "2-part-content").start();
        } catch (UnsupportedEncodingException e) {
            MRAIDLog.m2729d("hz-m MRAIDView - expand - UnsupportedEncodingException " + e);
        }
    }

    @JavascriptMRAIDCallback
    private void open(String url) {
        try {
            url = URLDecoder.decode(url, AsyncHttpResponseHandler.DEFAULT_CHARSET);
            MRAIDLog.m2730d("MRAIDView-JS callback", "open " + url + " touched: " + this.wasTouched);
            if (!this.wasTouched) {
                MRAIDLog.m2730d("MRAIDView- JS callback", "open called, but no touch recorded, aborting");
            } else if (this.nativeFeatureListener == null) {
            } else {
                if (url.startsWith(MRAIDNativeFeature.SMS)) {
                    this.nativeFeatureListener.mraidNativeFeatureSendSms(url);
                } else if (url.startsWith(MRAIDNativeFeature.TEL)) {
                    this.nativeFeatureListener.mraidNativeFeatureCallTel(url);
                } else {
                    this.nativeFeatureListener.mraidNativeFeatureOpenBrowser(url);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @JavascriptMRAIDCallback
    private void playVideo(String url) {
        try {
            url = URLDecoder.decode(url, AsyncHttpResponseHandler.DEFAULT_CHARSET);
            MRAIDLog.m2730d("MRAIDView-JS callback", "playVideo " + url);
            if (this.nativeFeatureListener != null) {
                this.nativeFeatureListener.mraidNativeFeaturePlayVideo(url);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @JavascriptMRAIDCallback
    private void resize() {
        MRAIDLog.m2730d("MRAIDView-JS callback", "resize");
        if (this.listener != null) {
            if (this.listener.mraidViewResize(this, this.resizeProperties.width, this.resizeProperties.height, this.resizeProperties.offsetX, this.resizeProperties.offsetY)) {
                this.state = 3;
                if (this.resizedView == null) {
                    this.resizedView = new RelativeLayout(this.context);
                    removeAllViews();
                    this.resizedView.addView(this.webView);
                    addCloseRegion(this.resizedView);
                    ((FrameLayout) getRootView().findViewById(16908290)).addView(this.resizedView);
                }
                setCloseRegionPosition(this.resizedView);
                setResizedViewSize();
                setResizedViewPosition();
                this.handler.post(new C19686());
            }
        }
    }

    @JavascriptMRAIDCallback
    protected void setOrientationProperties(Map<String, String> properties) {
        boolean allowOrientationChange = Boolean.parseBoolean((String) properties.get("allowOrientationChange"));
        String forceOrientation = (String) properties.get("forceOrientation");
        MRAIDLog.m2730d("MRAIDView-JS callback", "setOrientationProperties " + allowOrientationChange + " " + forceOrientation);
        this.orientationProperties.allowOrientationChange = allowOrientationChange;
        this.orientationProperties.forceOrientation = MRAIDOrientationProperties.forceOrientationFromString(forceOrientation);
        if ((this instanceof MRAIDInterstitial) || this.state == 2) {
            applyOrientationProperties();
        }
    }

    @JavascriptMRAIDCallback
    private void setResizeProperties(Map<String, String> properties) {
        int width = Integer.parseInt((String) properties.get("width"));
        int height = Integer.parseInt((String) properties.get("height"));
        int offsetX = Integer.parseInt((String) properties.get("offsetX"));
        int offsetY = Integer.parseInt((String) properties.get("offsetY"));
        String customClosePosition = (String) properties.get("customClosePosition");
        boolean allowOffscreen = Boolean.parseBoolean((String) properties.get("allowOffscreen"));
        MRAIDLog.m2730d("MRAIDView-JS callback", "setResizeProperties " + width + " " + height + " " + offsetX + " " + offsetY + " " + customClosePosition + " " + allowOffscreen);
        this.resizeProperties.width = width;
        this.resizeProperties.height = height;
        this.resizeProperties.offsetX = offsetX;
        this.resizeProperties.offsetY = offsetY;
        this.resizeProperties.customClosePosition = MRAIDResizeProperties.customClosePositionFromString(customClosePosition);
        this.resizeProperties.allowOffscreen = allowOffscreen;
    }

    @JavascriptMRAIDCallback
    private void storePicture(String url) {
        try {
            url = URLDecoder.decode(url, AsyncHttpResponseHandler.DEFAULT_CHARSET);
            MRAIDLog.m2730d("MRAIDView-JS callback", "storePicture " + url);
            if (this.nativeFeatureListener != null) {
                this.nativeFeatureListener.mraidNativeFeatureStorePicture(url);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @JavascriptMRAIDCallback
    private void useCustomClose(String useCustomCloseString) {
        MRAIDLog.m2730d("MRAIDView-JS callback", "useCustomClose " + useCustomCloseString);
        boolean useCustomClose = Boolean.parseBoolean(useCustomCloseString);
        if (this.useCustomClose != useCustomClose) {
            this.useCustomClose = useCustomClose;
            if (useCustomClose) {
                removeDefaultCloseButton();
            } else {
                showDefaultCloseButton();
            }
        }
    }

    private String getStringFromUrl(String url) {
        if (url.startsWith("file:///")) {
            return getStringFromFileUrl(url);
        }
        String content = null;
        InputStream is = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            int responseCode = conn.getResponseCode();
            MRAIDLog.m2730d(MRAID_LOG_TAG, "response code " + responseCode);
            if (responseCode == 200) {
                MRAIDLog.m2730d(MRAID_LOG_TAG, "getContentLength " + conn.getContentLength());
                is = conn.getInputStream();
                byte[] buf = new byte[1500];
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int count = is.read(buf);
                    if (count == -1) {
                        break;
                    }
                    sb.append(new String(buf, 0, count));
                }
                content = sb.toString();
                MRAIDLog.m2730d(MRAID_LOG_TAG, "getStringFromUrl ok, length=" + content.length());
            }
            conn.disconnect();
            if (is == null) {
                return content;
            }
            try {
                is.close();
                return content;
            } catch (IOException e) {
                return content;
            }
        } catch (IOException e2) {
            MRAIDLog.m2732e(MRAID_LOG_TAG, "getStringFromUrl failed " + e2.getLocalizedMessage());
            if (is == null) {
                return null;
            }
            try {
                is.close();
                return null;
            } catch (IOException e3) {
                return null;
            }
        } catch (Throwable th) {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e4) {
                }
            }
        }
    }

    private String getStringFromFileUrl(String fileURL) {
        StringBuffer mLine = new StringBuffer("");
        String[] urlElements = fileURL.split("/");
        if (urlElements[3].equals("android_asset")) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(this.context.getAssets().open(urlElements[4])));
                String line = reader.readLine();
                mLine.append(line);
                while (line != null) {
                    line = reader.readLine();
                    mLine.append(line);
                }
                reader.close();
            } catch (IOException e) {
                MRAIDLog.m2731e("Error fetching file: " + e.getMessage());
            }
            return mLine.toString();
        }
        MRAIDLog.m2731e("Unknown location to fetch file content");
        return "";
    }

    protected void showAsInterstitial(Activity activity) {
        MRAIDLog.m2729d("hz-m MRAIDVIEW - showAsInterstitial");
        this.showActivity = activity;
        expand(null);
    }

    protected void expandHelper(WebView webView) {
        applyOrientationProperties();
        forceFullScreen();
        this.expandedView = new RelativeLayout(this.context);
        this.expandedView.addView(webView, new LayoutParams(-1, -1));
        addCloseRegion(this.expandedView);
        setCloseRegionPosition(this.expandedView);
        MRAIDLog.m2729d("hz-m MRAIDView - expandHelper - adding contentview to activity " + this.context);
        this.showActivity.addContentView(this.expandedView, new LayoutParams(-1, -1));
        this.isExpandingFromDefault = true;
        this.isExpanded = true;
    }

    private void setResizedViewSize() {
        MRAIDLog.m2730d(MRAID_LOG_TAG, "setResizedViewSize");
        int widthInDip = this.resizeProperties.width;
        int heightInDip = this.resizeProperties.height;
        MRAIDLog.m2730d(MRAID_LOG_TAG, "setResizedViewSize " + widthInDip + "x" + heightInDip);
        this.resizedView.setLayoutParams(new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, (float) widthInDip, this.displayMetrics), (int) TypedValue.applyDimension(1, (float) heightInDip, this.displayMetrics)));
    }

    private void setResizedViewPosition() {
        MRAIDLog.m2730d(MRAID_LOG_TAG, "setResizedViewPosition");
        if (this.resizedView != null) {
            int widthInDip = this.resizeProperties.width;
            int heightInDip = this.resizeProperties.height;
            int offsetXInDip = this.resizeProperties.offsetX;
            int width = (int) TypedValue.applyDimension(1, (float) widthInDip, this.displayMetrics);
            int height = (int) TypedValue.applyDimension(1, (float) heightInDip, this.displayMetrics);
            int x = this.defaultPosition.left + ((int) TypedValue.applyDimension(1, (float) offsetXInDip, this.displayMetrics));
            int y = this.defaultPosition.top + ((int) TypedValue.applyDimension(1, (float) this.resizeProperties.offsetY, this.displayMetrics));
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) this.resizedView.getLayoutParams();
            params.leftMargin = x;
            params.topMargin = y;
            this.resizedView.setLayoutParams(params);
            if (x != this.currentPosition.left || y != this.currentPosition.top || width != this.currentPosition.width() || height != this.currentPosition.height()) {
                this.currentPosition.left = x;
                this.currentPosition.top = y;
                this.currentPosition.right = x + width;
                this.currentPosition.bottom = y + height;
                setCurrentPosition();
            }
        }
    }

    protected void closeFromExpanded() {
        if (this.state == 2 || this.state == 3) {
            this.state = 1;
        }
        this.isClosing = true;
        this.isExpanded = false;
        this.expandedView.removeAllViews();
        ((FrameLayout) ((Activity) this.context).findViewById(16908290)).removeView(this.expandedView);
        this.expandedView = null;
        this.closeRegion = null;
        this.handler.post(new C19697());
        if (this.webViewPart2 == null) {
            addView(this.webView, new LayoutParams(-1, -2));
        } else {
            destroyWebView(this.webViewPart2);
            this.webView.setWebChromeClient(this.mraidWebChromeClient);
            this.webView.setWebViewClient(this.mraidWebViewClient);
            MRAIDLog.m2729d("hz-m MRAIDView - closeFromExpanded - setting currentwebview to " + this.webView);
            this.currentWebView = this.webView;
            this.currentWebView.setLayoutParams(new LayoutParams(-1, -2));
        }
        this.handler.post(new C19708());
    }

    protected void closeFromResized() {
        this.state = 1;
        this.isClosing = true;
        removeResizeView();
        addView(this.webView);
        this.handler.post(new C19719());
    }

    private void removeResizeView() {
        this.resizedView.removeAllViews();
        ((FrameLayout) ((Activity) this.context).findViewById(16908290)).removeView(this.resizedView);
        this.resizedView = null;
        this.closeRegion = null;
    }

    @TargetApi(11)
    private void forceFullScreen() {
        boolean z;
        boolean z2 = true;
        MRAIDLog.m2730d(MRAID_LOG_TAG, "forceFullScreen");
        Activity activity = this.context;
        int flags = activity.getWindow().getAttributes().flags;
        if ((flags & 1024) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.isFullScreen = z;
        if ((flags & 2048) != 0) {
            z = true;
        } else {
            z = false;
        }
        this.isForceNotFullScreen = z;
        this.origTitleBarVisibility = -9;
        boolean hasActionBar = false;
        if (VERSION.SDK_INT >= 11) {
            ActionBar actionBar = activity.getActionBar();
            if (actionBar != null) {
                hasActionBar = true;
                this.isActionBarShowing = actionBar.isShowing();
                actionBar.hide();
            }
        }
        if (!hasActionBar) {
            this.titleBar = null;
            try {
                this.titleBar = (View) activity.findViewById(16908310).getParent();
            } catch (NullPointerException e) {
            }
            if (this.titleBar != null) {
                this.origTitleBarVisibility = this.titleBar.getVisibility();
                this.titleBar.setVisibility(8);
            }
        }
        MRAIDLog.m2730d(MRAID_LOG_TAG, "isFullScreen " + this.isFullScreen);
        MRAIDLog.m2730d(MRAID_LOG_TAG, "isForceNotFullScreen " + this.isForceNotFullScreen);
        MRAIDLog.m2730d(MRAID_LOG_TAG, "isActionBarShowing " + this.isActionBarShowing);
        MRAIDLog.m2730d(MRAID_LOG_TAG, "origTitleBarVisibility " + getVisibilityString(this.origTitleBarVisibility));
        ((Activity) this.context).getWindow().addFlags(1024);
        ((Activity) this.context).getWindow().clearFlags(2048);
        if (this.isFullScreen) {
            z2 = false;
        }
        this.isForcingFullScreen = z2;
    }

    @TargetApi(11)
    private void restoreOriginalScreenState() {
        Activity activity = this.context;
        if (!this.isFullScreen) {
            activity.getWindow().clearFlags(1024);
        }
        if (this.isForceNotFullScreen) {
            activity.getWindow().addFlags(2048);
        }
        if (VERSION.SDK_INT >= 11 && this.isActionBarShowing) {
            activity.getActionBar().show();
        } else if (this.titleBar != null) {
            this.titleBar.setVisibility(this.origTitleBarVisibility);
        }
    }

    private static String getVisibilityString(int visibility) {
        switch (visibility) {
            case 0:
                return "VISIBLE";
            case 4:
                return "INVISIBLE";
            case 8:
                return "GONE";
            default:
                return "UNKNOWN";
        }
    }

    private void addCloseRegion(View view) {
        this.closeRegion = new ImageButton(this.context);
        this.closeRegion.setBackgroundColor(0);
        this.closeRegion.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                MRAIDView.this.close();
            }
        });
        if (view == this.expandedView && !this.useCustomClose) {
            showDefaultCloseButton();
        }
        ((ViewGroup) view).addView(this.closeRegion);
    }

    private void showDefaultCloseButton() {
        if (this.closeRegion != null) {
            Drawable closeButtonNormalDrawable = Assets.getDrawableFromBase64(getResources(), Assets.new_close);
            Drawable closeButtonPressedDrawable = Assets.getDrawableFromBase64(getResources(), Assets.new_close_pressed);
            StateListDrawable states = new StateListDrawable();
            states.addState(new int[]{-16842919}, closeButtonNormalDrawable);
            states.addState(new int[]{16842919}, closeButtonPressedDrawable);
            this.closeRegion.setImageDrawable(states);
            this.closeRegion.setScaleType(ScaleType.CENTER_CROP);
        }
    }

    private void removeDefaultCloseButton() {
        if (this.closeRegion != null) {
            this.closeRegion.setImageResource(17170445);
        }
    }

    private void setCloseRegionPosition(View view) {
        int size = (int) TypedValue.applyDimension(1, 50.0f, this.displayMetrics);
        LayoutParams params = new LayoutParams(size, size);
        if (view != this.expandedView) {
            if (view == this.resizedView) {
                switch (this.resizeProperties.customClosePosition) {
                    case 0:
                    case 4:
                        params.addRule(9);
                        break;
                    case 1:
                    case 3:
                    case 5:
                        params.addRule(14);
                        break;
                    case 2:
                    case 6:
                        params.addRule(11);
                        break;
                }
                switch (this.resizeProperties.customClosePosition) {
                    case 0:
                    case 1:
                    case 2:
                        params.addRule(10);
                        break;
                    case 3:
                        params.addRule(15);
                        break;
                    case 4:
                    case 5:
                    case 6:
                        params.addRule(12);
                        break;
                    default:
                        break;
                }
            }
        }
        params.addRule(10);
        params.addRule(11);
        this.closeRegion.setLayoutParams(params);
    }

    private void injectMraidJs(WebView wv) {
        if (TextUtils.isEmpty(this.mraidJs)) {
            this.mraidJs = new String(Base64.decode(Assets.mraidJS, 0));
        }
        injectJavaScript(this.mraidJs);
    }

    private InputStream getMraidJsStream() {
        if (TextUtils.isEmpty(this.mraidJs)) {
            this.mraidJs = new String(Base64.decode(Assets.mraidJS, 0));
        }
        return new ByteArrayInputStream(this.mraidJs.getBytes(Charset.forName(AsyncHttpResponseHandler.DEFAULT_CHARSET)));
    }

    private void injectJavaScript(String js) {
        injectJavaScript(this.currentWebView, js);
    }

    private static void injectJavaScript(WebView webView, String js) {
        if (!TextUtils.isEmpty(js)) {
            if (VERSION.SDK_INT >= 19) {
                MRAIDLog.m2730d(MRAID_LOG_TAG, "evaluating js: " + js);
                webView.evaluateJavascript(js, new ValueCallback<String>() {
                    public void onReceiveValue(String value) {
                        MRAIDLog.m2729d("Evaluated JS: " + value);
                    }
                });
                return;
            }
            MRAIDLog.m2730d(MRAID_LOG_TAG, "loading url: " + js);
            webView.loadUrl("javascript:" + js);
        }
    }

    protected void fireReadyEvent() {
        MRAIDLog.m2730d(MRAID_LOG_TAG, "fireReadyEvent");
        injectJavaScript("mraid.fireReadyEvent();");
    }

    @SuppressLint({"DefaultLocale"})
    protected void fireStateChangeEvent() {
        MRAIDLog.m2730d(MRAID_LOG_TAG, "fireStateChangeEvent");
        injectJavaScript("mraid.fireStateChangeEvent('" + new String[]{"loading", "default", "expanded", "resized", "hidden"}[this.state] + "');");
    }

    protected void fireViewableChangeEvent() {
        MRAIDLog.m2730d(MRAID_LOG_TAG, "fireViewableChangeEvent");
        injectJavaScript("mraid.fireViewableChangeEvent(" + this.isViewable + ");");
    }

    private int px2dip(int pixels) {
        return (pixels * 160) / this.displayMetrics.densityDpi;
    }

    private void setCurrentPosition() {
        int x = this.currentPosition.left;
        int y = this.currentPosition.top;
        int width = this.currentPosition.width();
        int height = this.currentPosition.height();
        MRAIDLog.m2730d(MRAID_LOG_TAG, "setCurrentPosition [" + x + "," + y + "] (" + width + "x" + height + ")");
        injectJavaScript("mraid.setCurrentPosition(" + px2dip(x) + "," + px2dip(y) + "," + px2dip(width) + "," + px2dip(height) + ");");
    }

    private void setDefaultPosition() {
        int x = this.defaultPosition.left;
        int y = this.defaultPosition.top;
        int width = this.defaultPosition.width();
        int height = this.defaultPosition.height();
        MRAIDLog.m2730d(MRAID_LOG_TAG, "setDefaultPosition [" + x + "," + y + "] (" + width + "x" + height + ")");
        injectJavaScript("mraid.setDefaultPosition(" + px2dip(x) + "," + px2dip(y) + "," + px2dip(width) + "," + px2dip(height) + ");");
    }

    private void setMaxSize() {
        MRAIDLog.m2730d(MRAID_LOG_TAG, "setMaxSize");
        int width = this.maxSize.width;
        int height = this.maxSize.height;
        MRAIDLog.m2730d(MRAID_LOG_TAG, "setMaxSize " + width + "x" + height);
        injectJavaScript("mraid.setMaxSize(" + px2dip(width) + "," + px2dip(height) + ");");
    }

    private void setScreenSize() {
        MRAIDLog.m2730d(MRAID_LOG_TAG, "setScreenSize");
        int width = this.screenSize.width;
        int height = this.screenSize.height;
        MRAIDLog.m2730d(MRAID_LOG_TAG, "setScreenSize " + width + "x" + height);
        injectJavaScript("mraid.setScreenSize(" + px2dip(width) + "," + px2dip(height) + ");");
    }

    private void setSupportedServices() {
        MRAIDLog.m2730d(MRAID_LOG_TAG, "setSupportedServices");
        injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.CALENDAR, " + this.nativeFeatureManager.isCalendarSupported() + ");");
        injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.INLINEVIDEO, " + this.nativeFeatureManager.isInlineVideoSupported() + ");");
        injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.SMS, " + this.nativeFeatureManager.isSmsSupported() + ");");
        injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.STOREPICTURE, " + this.nativeFeatureManager.isStorePictureSupported() + ");");
        injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.TEL, " + this.nativeFeatureManager.isTelSupported() + ");");
    }

    @TargetApi(11)
    private void pauseWebView(WebView webView) {
        MRAIDLog.m2730d(MRAID_LOG_TAG, "pauseWebView " + webView.toString());
        if (VERSION.SDK_INT >= 11) {
            webView.onPause();
        } else {
            webView.loadUrl("about:blank");
        }
    }

    public boolean isLoaded() {
        return this.isPageFinished;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        MRAIDLog.m2730d(MRAID_LOG_TAG, "onConfigurationChanged " + (newConfig.orientation == 1 ? "portrait" : "landscape"));
        ((Activity) this.context).getWindowManager().getDefaultDisplay().getMetrics(this.displayMetrics);
    }

    protected void onAttachedToWindow() {
        MRAIDLog.m2730d(MRAID_LOG_TAG, "onAttachedToWindow");
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        MRAIDLog.m2730d(MRAID_LOG_TAG, "onDetachedFromWindow");
        super.onDetachedFromWindow();
    }

    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        MRAIDLog.m2730d(MRAID_LOG_TAG, "onVisibilityChanged " + getVisibilityString(visibility));
        setViewable(visibility);
    }

    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        int actualVisibility = getVisibility();
        MRAIDLog.m2730d(MRAID_LOG_TAG, "onWindowVisibilityChanged " + getVisibilityString(visibility) + " (actual " + getVisibilityString(actualVisibility) + ")");
        setViewable(actualVisibility);
    }

    private void setViewable(int visibility) {
        boolean isCurrentlyViewable = visibility == 0;
        if (isCurrentlyViewable != this.isViewable) {
            this.isViewable = isCurrentlyViewable;
            if (this.isPageFinished && this.isLaidOut) {
                fireViewableChangeEvent();
            }
        }
    }

    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        MRAIDLog.m2738w(MRAID_LOG_TAG, "onLayout (" + this.state + ") " + changed + " " + left + " " + top + " " + right + " " + bottom);
        if (this.isForcingFullScreen) {
            MRAIDLog.m2730d(MRAID_LOG_TAG, "onLayout ignored");
            return;
        }
        if (this.state == 2 || this.state == 3) {
            calculateScreenSize();
            calculateMaxSize();
        }
        if (this.isClosing) {
            this.isClosing = false;
            this.currentPosition = new Rect(this.defaultPosition);
            setCurrentPosition();
        } else {
            calculatePosition(false);
        }
        if (this.state == 3 && changed) {
            this.handler.post(new Runnable() {
                public void run() {
                    MRAIDView.this.setResizedViewPosition();
                }
            });
        }
        this.isLaidOut = true;
        onLayoutCompleted();
    }

    protected void onLayoutCompleted() {
    }

    private void onLayoutWebView(WebView wv, boolean changed, int left, int top, int right, int bottom) {
        boolean isCurrent;
        if (wv == this.currentWebView) {
            isCurrent = true;
        } else {
            isCurrent = false;
        }
        MRAIDLog.m2738w(MRAID_LOG_TAG, "onLayoutWebView " + (wv == this.webView ? "1 " : "2 ") + isCurrent + " (" + this.state + ") " + changed + " " + left + " " + top + " " + right + " " + bottom);
        if (isCurrent) {
            if (this.state == 0 || this.state == 1) {
                calculateScreenSize();
                calculateMaxSize();
            }
            if (!this.isClosing) {
                calculatePosition(true);
                if (this.isInterstitial && !this.defaultPosition.equals(this.currentPosition)) {
                    this.defaultPosition = new Rect(this.currentPosition);
                    setDefaultPosition();
                }
            }
            if (this.isExpandingFromDefault) {
                this.isExpandingFromDefault = false;
                if (this.isInterstitial) {
                    this.state = 1;
                    this.isLaidOut = true;
                }
                if (!this.isExpandingPart2) {
                    MRAIDLog.m2730d(MRAID_LOG_TAG, "calling fireStateChangeEvent 1");
                    fireStateChangeEvent();
                }
                if (this.isInterstitial) {
                    fireReadyEvent();
                    if (this.isViewable) {
                        fireViewableChangeEvent();
                    }
                }
                if (this.listener != null) {
                    this.listener.mraidViewExpand(this);
                    return;
                }
                return;
            }
            return;
        }
        MRAIDLog.m2730d(MRAID_LOG_TAG, "onLayoutWebView ignored, not current");
    }

    private void calculateScreenSize() {
        boolean isPortrait = true;
        if (getResources().getConfiguration().orientation != 1) {
            isPortrait = false;
        }
        MRAIDLog.m2730d(MRAID_LOG_TAG, "calculateScreenSize orientation " + (isPortrait ? "portrait" : "landscape"));
        int width = this.displayMetrics.widthPixels;
        int height = this.displayMetrics.heightPixels;
        MRAIDLog.m2730d(MRAID_LOG_TAG, "calculateScreenSize screen size " + width + "x" + height);
        if (width != this.screenSize.width || height != this.screenSize.height) {
            this.screenSize.width = width;
            this.screenSize.height = height;
            if (this.isPageFinished) {
                setScreenSize();
            }
        }
    }

    private void calculateMaxSize() {
        Rect frame = new Rect();
        Window window = ((Activity) this.context).getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(frame);
        MRAIDLog.m2730d(MRAID_LOG_TAG, "calculateMaxSize frame [" + frame.left + "," + frame.top + "][" + frame.right + "," + frame.bottom + "] (" + frame.width() + "x" + frame.height() + ")");
        this.contentViewTop = window.findViewById(16908290).getTop();
        int statusHeight = frame.top;
        int titleHeight = this.contentViewTop - statusHeight;
        MRAIDLog.m2730d(MRAID_LOG_TAG, "calculateMaxSize statusHeight " + statusHeight);
        MRAIDLog.m2730d(MRAID_LOG_TAG, "calculateMaxSize titleHeight " + titleHeight);
        MRAIDLog.m2730d(MRAID_LOG_TAG, "calculateMaxSize contentViewTop " + this.contentViewTop);
        int width = frame.width();
        int height = this.screenSize.height - this.contentViewTop;
        MRAIDLog.m2730d(MRAID_LOG_TAG, "calculateMaxSize max size " + width + "x" + height);
        if (width != this.maxSize.width || height != this.maxSize.height) {
            this.maxSize.width = width;
            this.maxSize.height = height;
            if (this.isPageFinished) {
                setMaxSize();
            }
        }
    }

    private void calculatePosition(boolean isCurrentWebView) {
        View view;
        if (isCurrentWebView) {
            view = this.currentWebView;
        } else {
            view = this;
        }
        String name = isCurrentWebView ? "current" : "default";
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        MRAIDLog.m2730d(MRAID_LOG_TAG, "calculatePosition " + name + " locationOnScreen [" + x + "," + y + "]");
        MRAIDLog.m2730d(MRAID_LOG_TAG, "calculatePosition " + name + " contentViewTop " + this.contentViewTop);
        y -= this.contentViewTop;
        int width = view.getWidth();
        int height = view.getHeight();
        MRAIDLog.m2730d(MRAID_LOG_TAG, "calculatePosition " + name + " position [" + x + "," + y + "] (" + width + "x" + height + ")");
        Rect position = isCurrentWebView ? this.currentPosition : this.defaultPosition;
        if (x != position.left || y != position.top || width != position.width() || height != position.height()) {
            if (isCurrentWebView) {
                this.currentPosition = new Rect(x, y, x + width, y + height);
            } else {
                this.defaultPosition = new Rect(x, y, x + width, y + height);
            }
            if (!this.isPageFinished) {
                return;
            }
            if (isCurrentWebView) {
                setCurrentPosition();
            } else {
                setDefaultPosition();
            }
        }
    }

    private static String getOrientationString(int orientation) {
        switch (orientation) {
            case -1:
                return "UNSPECIFIED";
            case 0:
                return "LANDSCAPE";
            case 1:
                return "PORTRAIT";
            default:
                return "UNKNOWN";
        }
    }

    protected void applyOrientationProperties() {
        boolean isCurrentPortrait;
        MRAIDLog.m2730d(MRAID_LOG_TAG, "applyOrientationProperties " + this.orientationProperties.allowOrientationChange + " " + this.orientationProperties.forceOrientationString());
        Activity activity = this.context;
        if (getResources().getConfiguration().orientation == 1) {
            isCurrentPortrait = true;
        } else {
            isCurrentPortrait = false;
        }
        MRAIDLog.m2730d(MRAID_LOG_TAG, "currentOrientation " + (isCurrentPortrait ? "portrait" : "landscape"));
        int orientation = this.originalRequestedOrientation;
        if (this.orientationProperties.forceOrientation == 0) {
            orientation = 1;
        } else if (this.orientationProperties.forceOrientation == 1) {
            orientation = 0;
        } else if (this.orientationProperties.allowOrientationChange) {
            orientation = -1;
        } else {
            orientation = isCurrentPortrait ? 1 : 0;
        }
        activity.setRequestedOrientation(orientation);
    }

    private void restoreOriginalOrientation() {
        MRAIDLog.m2730d(MRAID_LOG_TAG, "restoreOriginalOrientation");
        Activity activity = this.context;
        if (activity.getRequestedOrientation() != this.originalRequestedOrientation) {
            activity.setRequestedOrientation(this.originalRequestedOrientation);
        }
    }
}
