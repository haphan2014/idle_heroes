package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.heyzap.http.AsyncHttpResponseHandler;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzgd
public class zzfd implements zzfb {
    private final Context mContext;
    final Set<WebView> zzAt = Collections.synchronizedSet(new HashSet());

    public zzfd(Context context) {
        this.mContext = context;
    }

    public void zza(String str, final String str2, final String str3) {
        zzb.zzay("Fetching assets for the given html");
        zzhl.zzGk.post(new Runnable(this) {
            final /* synthetic */ zzfd zzAw;

            public void run() {
                final WebView zzeZ = this.zzAw.zzeZ();
                zzeZ.setWebViewClient(new WebViewClient(this) {
                    final /* synthetic */ C09111 zzAx;

                    public void onPageFinished(WebView view, String url) {
                        zzb.zzay("Loading assets have finished");
                        this.zzAx.zzAw.zzAt.remove(zzeZ);
                    }

                    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                        zzb.zzaC("Loading assets have failed.");
                        this.zzAx.zzAw.zzAt.remove(zzeZ);
                    }
                });
                this.zzAw.zzAt.add(zzeZ);
                zzeZ.loadDataWithBaseURL(str2, str3, "text/html", AsyncHttpResponseHandler.DEFAULT_CHARSET, null);
                zzb.zzay("Fetching assets finished.");
            }
        });
    }

    public WebView zzeZ() {
        WebView webView = new WebView(this.mContext);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
