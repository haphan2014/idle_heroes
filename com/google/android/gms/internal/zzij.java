package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzo;
import com.heyzap.http.AsyncHttpResponseHandler;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzgd
public class zzij extends zzie {
    public zzij(zzid com_google_android_gms_internal_zzid, boolean z) {
        super(com_google_android_gms_internal_zzid, z);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
        Exception e;
        try {
            if (!"mraid.js".equalsIgnoreCase(new File(url).getName())) {
                return super.shouldInterceptRequest(webView, url);
            }
            if (webView instanceof zzid) {
                zzid com_google_android_gms_internal_zzid = (zzid) webView;
                com_google_android_gms_internal_zzid.zzgF().zzet();
                String str = com_google_android_gms_internal_zzid.zzaN().zzsn ? (String) zzbz.zztX.get() : com_google_android_gms_internal_zzid.zzgJ() ? (String) zzbz.zztW.get() : (String) zzbz.zztV.get();
                zzb.zzaB("shouldInterceptRequest(" + str + ")");
                return zzd(com_google_android_gms_internal_zzid.getContext(), this.zzoA.zzgI().zzGG, str);
            }
            zzb.zzaC("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return super.shouldInterceptRequest(webView, url);
        } catch (IOException e2) {
            e = e2;
            zzb.zzaC("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        } catch (ExecutionException e3) {
            e = e3;
            zzb.zzaC("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        } catch (InterruptedException e4) {
            e = e4;
            zzb.zzaC("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        } catch (TimeoutException e5) {
            e = e5;
            zzb.zzaC("Could not fetch MRAID JS. " + e.getMessage());
            return super.shouldInterceptRequest(webView, url);
        }
    }

    protected WebResourceResponse zzd(Context context, String str, String str2) throws IOException, ExecutionException, InterruptedException, TimeoutException {
        Map hashMap = new HashMap();
        hashMap.put("User-Agent", zzo.zzbv().zzf(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new zzho(context).zzb(str2, hashMap).get(60, TimeUnit.SECONDS);
        return str3 == null ? null : new WebResourceResponse("application/javascript", AsyncHttpResponseHandler.DEFAULT_CHARSET, new ByteArrayInputStream(str3.getBytes(AsyncHttpResponseHandler.DEFAULT_CHARSET)));
    }
}
