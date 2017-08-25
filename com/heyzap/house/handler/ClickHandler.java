package com.heyzap.house.handler;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.google.android.gms.drive.DriveFile;
import com.heyzap.house.Manager;
import com.heyzap.house.model.AdModel;
import com.heyzap.internal.Logger;
import com.heyzap.internal.Utils;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClickHandler {
    private AtomicBoolean marketIntentLaunched = new AtomicBoolean(false);
    private AdModel model;

    public ClickHandler(AdModel ad) {
        this.model = ad;
    }

    public void doClick(Context context) {
        doClick(context, this.model.actionUrl, null);
    }

    public void doClick(final Context context, final String url, final String customPackageName) {
        Manager.handler.post(new Runnable() {
            public void run() {
                if (ClickHandler.this.model.onClick(context, customPackageName).booleanValue()) {
                    try {
                        final ProgressDialog marketSpinner = ProgressDialog.show(context, "", "Loading...", true);
                        Manager.handler.postDelayed(new Runnable() {
                            public void run() {
                                try {
                                    marketSpinner.dismiss();
                                } catch (Throwable e) {
                                    Logger.trace(e);
                                }
                            }
                        }, 3000);
                    } catch (Throwable e) {
                        Logger.trace(e);
                    }
                    if (ClickHandler.this.model.getAdRequest() != null) {
                        ClickHandler.this.model.getAdRequest().getOnStatusListener().onClick(ClickHandler.this.model.getTag());
                    }
                    ClickHandler.this.gotoMarket(context, url);
                }
            }
        });
    }

    private void launchMarketIntent(Context context, String intentUrl) {
        if (this.marketIntentLaunched.compareAndSet(false, true)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(intentUrl));
            int flags = 131072;
            if (!(context instanceof Activity)) {
                flags = 131072 | DriveFile.MODE_READ_ONLY;
            }
            intent.addFlags(flags);
            try {
                context.startActivity(intent);
            } catch (ActivityNotFoundException e) {
                try {
                    String text;
                    if (Utils.isAmazon()) {
                        text = "The Appstore cannot be found.";
                    } else {
                        text = "The Play Store cannot be found.";
                    }
                    Toast.makeText(context, "Market not found, cannot install", 1).show();
                } catch (Throwable e1) {
                    Logger.log("(LAUNCH MARKET FAILED)");
                    Logger.trace(e1);
                }
            }
        }
    }

    private boolean launchIfMarket(Context context, String adUrl) {
        if (Utils.isAmazon()) {
            if (adUrl.startsWith("amzn")) {
                launchMarketIntent(context, adUrl);
                return true;
            } else if (adUrl.contains("amazon.com/gp/mas/dl/android?")) {
                launchMarketIntent(context, "amzn://apps/" + adUrl.substring(adUrl.indexOf("android?")));
                return true;
            }
        } else if (adUrl.startsWith("market")) {
            launchMarketIntent(context, adUrl);
            return true;
        } else if (adUrl.contains("play.google")) {
            int i = adUrl.indexOf("details?");
            if (i == -1) {
                launchMarketIntent(context, adUrl);
                return true;
            }
            launchMarketIntent(context, "market://" + adUrl.substring(i));
            return true;
        }
        return false;
    }

    protected void gotoMarket(final Context context, String url) {
        final String adUrl = url;
        this.marketIntentLaunched.set(false);
        if (!launchIfMarket(context, adUrl)) {
            final WebView webView = new WebView(context);
            webView.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView wView, String url) {
                    return super.shouldOverrideUrlLoading(wView, url);
                }

                public void onLoadResource(WebView view, String url) {
                    super.onLoadResource(view, url);
                    if (ClickHandler.this.launchIfMarket(context, url)) {
                        view.stopLoading();
                    }
                }

                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    if (ClickHandler.this.launchIfMarket(context, url)) {
                        view.stopLoading();
                    }
                }

                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    super.onReceivedError(view, errorCode, description, failingUrl);
                }

                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                }
            });
            webView.setWebChromeClient(new WebChromeClient());
            webView.getSettings().setJavaScriptEnabled(true);
            Timer timer = new Timer();
            Manager.handler.postDelayed(new Runnable() {

                class C13381 implements Runnable {
                    C13381() {
                    }

                    public void run() {
                        webView.loadUrl(adUrl);
                    }
                }

                public void run() {
                    if (!ClickHandler.this.marketIntentLaunched.get()) {
                        Manager.handler.post(new C13381());
                    }
                }
            }, 0);
            Manager.handler.postDelayed(new Runnable() {

                class C13401 implements Runnable {
                    C13401() {
                    }

                    public void run() {
                        webView.loadUrl(adUrl);
                    }
                }

                public void run() {
                    if (!ClickHandler.this.marketIntentLaunched.get()) {
                        Manager.handler.post(new C13401());
                    }
                }
            }, 750);
            Manager.handler.postDelayed(new Runnable() {
                public void run() {
                    if (!ClickHandler.this.marketIntentLaunched.get()) {
                        ClickHandler.this.launchMarketIntent(context, adUrl);
                    }
                }
            }, 1250);
        }
    }
}
