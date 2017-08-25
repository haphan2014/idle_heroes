package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzt;
import java.net.URI;
import java.net.URISyntaxException;

@zzgd
public class zzil extends WebViewClient {
    private final String zzHE;
    private boolean zzHF = false;
    private final zzfq zzHG;
    private final zzid zzoA;

    public zzil(zzfq com_google_android_gms_internal_zzfq, zzid com_google_android_gms_internal_zzid, String str) {
        this.zzHE = zzaH(str);
        this.zzoA = com_google_android_gms_internal_zzid;
        this.zzHG = com_google_android_gms_internal_zzfq;
    }

    private String zzaH(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.endsWith("/")) {
                    str = str.substring(0, str.length() - 1);
                }
            } catch (IndexOutOfBoundsException e) {
                zzb.zzaz(e.getMessage());
            }
        }
        return str;
    }

    public void onLoadResource(WebView view, String url) {
        zzb.zzay("JavascriptAdWebViewClient::onLoadResource: " + url);
        if (!zzaG(url)) {
            this.zzoA.zzgF().onLoadResource(this.zzoA.getWebView(), url);
        }
    }

    public void onPageFinished(WebView view, String url) {
        zzb.zzay("JavascriptAdWebViewClient::onPageFinished: " + url);
        if (!this.zzHF) {
            this.zzHG.zzfj();
            this.zzHF = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        zzb.zzay("JavascriptAdWebViewClient::shouldOverrideUrlLoading: " + url);
        if (!zzaG(url)) {
            return this.zzoA.zzgF().shouldOverrideUrlLoading(this.zzoA.getWebView(), url);
        }
        zzb.zzay("shouldOverrideUrlLoading: received passback url");
        return true;
    }

    protected boolean zzaG(String str) {
        Object zzaH = zzaH(str);
        if (TextUtils.isEmpty(zzaH)) {
            return false;
        }
        try {
            URI uri = new URI(zzaH);
            if ("passback".equals(uri.getScheme())) {
                zzb.zzay("Passback received");
                this.zzHG.zzfk();
                return true;
            } else if (TextUtils.isEmpty(this.zzHE)) {
                return false;
            } else {
                URI uri2 = new URI(this.zzHE);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!zzt.equal(host, host2) || !zzt.equal(path, path2)) {
                    return false;
                }
                zzb.zzay("Passback received");
                this.zzHG.zzfk();
                return true;
            }
        } catch (URISyntaxException e) {
            zzb.zzaz(e.getMessage());
            return false;
        }
    }
}
