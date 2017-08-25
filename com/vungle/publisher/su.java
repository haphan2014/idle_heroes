package com.vungle.publisher;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.google.android.gms.tagmanager.DataLayer;
import com.vungle.publisher.gx.C1778a;
import com.vungle.publisher.jn.C1796a;
import com.vungle.publisher.jn.C1797b;
import com.vungle.publisher.tb.C1880b;
import com.vungle.publisher.ti.C1887a;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONObject;
import org.nexage.sourcekit.mraid.MRAIDNativeFeature;

/* compiled from: vungle */
public final class su extends my {
    C1797b f3205a;
    public boolean f3206b = true;
    public boolean f3207c = false;
    @Inject
    C1778a f3208d;
    @Inject
    qh f3209e;
    @Inject
    te f3210f;
    @Inject
    C1887a f3211g;
    @Inject
    ch f3212h;
    @Inject
    pj f3213i;
    private C1617z f3214j;
    private boolean f3215k = false;

    @Singleton
    /* compiled from: vungle */
    public static class C1876a {
        @Inject
        Provider<su> f3203a;
        @Inject
        C1796a f3204b;

        @Inject
        C1876a() {
        }
    }

    @Inject
    su() {
    }

    public final void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        this.f3208d.m1865a("VungleAd", "received error in WebViewClient: " + description, new RuntimeException());
        this.f3209e.m2361a(new ty("100"));
        super.onReceivedError(view, errorCode, description, failingUrl);
    }

    public final void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
        so.m2470a(6, "VungleAd", "received ssl error: " + error.getPrimaryError(), null);
        this.f3209e.m2361a(new ty("101"));
        super.onReceivedSslError(view, handler, error);
    }

    public final void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        so.m2470a(2, "VungleAd", "mraid page started loading: " + url, null);
    }

    public final void onPageFinished(WebView webView, String url) {
        so.m2470a(2, "VungleAd", "mraid page finished loading: " + url, null);
        if (this.f3206b) {
            so.m2470a(3, "VungleAd", "mraid webview finished loading", null);
            te teVar = this.f3210f;
            C1617z c1617z = this.f3214j;
            tm a = teVar.f3258d.m2503a();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(MRAIDNativeFeature.SMS, false);
                jSONObject.put(MRAIDNativeFeature.TEL, false);
                jSONObject.put(MRAIDNativeFeature.CALENDAR, false);
                jSONObject.put(MRAIDNativeFeature.STORE_PICTURE, false);
                jSONObject.put(MRAIDNativeFeature.INLINE_VIDEO, false);
            } catch (Throwable e) {
                so.m2471a("VungleProtocol", "exception setting mraid supports properties", e);
            }
            a.f3307h = jSONObject;
            a.m2507a(true);
            a.m2509c();
            a.f3312m = Boolean.valueOf(c1617z.isIncentivized());
            a.f3313n = Boolean.valueOf(c1617z.isBackButtonImmediatelyEnabled());
            a.f3309j = tr.interstitial;
            try {
                te.m2493a(webView, a.mo4355a(), true);
            } catch (Throwable e2) {
                teVar.f3256b.m1867b("VungleAd", "could not update mraid properties", e2);
            }
        } else {
            if (this.f3207c && !"about:blank".equalsIgnoreCase(url)) {
                so.m2470a(2, "VungleAd", "clear history", null);
                this.f3207c = false;
                webView.clearHistory();
            }
            this.f3209e.m2361a(new uf(C1880b.visible));
            this.f3209e.m2361a(new ud(tl.NONE, true));
        }
        super.onPageFinished(webView, url);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean shouldOverrideUrlLoading(final android.webkit.WebView r9, java.lang.String r10) {
        /*
        r8 = this;
        r5 = 2;
        r4 = 0;
        r1 = 1;
        r0 = "VungleAd";
        r2 = new java.lang.StringBuilder;
        r3 = "mraid attempted to navigate to url: ";
        r2.<init>(r3);
        r2 = r2.append(r10);
        r2 = r2.toString();
        com.vungle.publisher.so.m2470a(r5, r0, r2, r4);
        r2 = android.net.Uri.parse(r10);	 Catch:{ Exception -> 0x0062 }
        r0 = r2.getScheme();
        r3 = r2.getHost();
        r4 = "mraid";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0267;
    L_0x002b:
        r4 = new java.util.HashMap;	 Catch:{ Exception -> 0x004c }
        r4.<init>();	 Catch:{ Exception -> 0x004c }
        r0 = com.vungle.publisher.agf.m1218a(r2);	 Catch:{ Exception -> 0x004c }
        r5 = r0.iterator();	 Catch:{ Exception -> 0x004c }
    L_0x0038:
        r0 = r5.hasNext();	 Catch:{ Exception -> 0x004c }
        if (r0 == 0) goto L_0x0085;
    L_0x003e:
        r0 = r5.next();	 Catch:{ Exception -> 0x004c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x004c }
        r6 = r2.getQueryParameter(r0);	 Catch:{ Exception -> 0x004c }
        r4.put(r0, r6);	 Catch:{ Exception -> 0x004c }
        goto L_0x0038;
    L_0x004c:
        r0 = move-exception;
        r2 = r8.f3208d;
        r3 = "VungleAd";
        r4 = "exception while overriding mraid url";
        r2.m1865a(r3, r4, r0);
        r0 = r8.f3209e;
        r2 = new com.vungle.publisher.tz;
        r2.<init>();
        r0.m2361a(r2);
    L_0x0060:
        r0 = r1;
    L_0x0061:
        return r0;
    L_0x0062:
        r0 = move-exception;
        r2 = r8.f3208d;
        r3 = "VungleAd";
        r4 = new java.lang.StringBuilder;
        r5 = "Invalid URL: ";
        r4.<init>(r5);
        r4 = r4.append(r10);
        r4 = r4.toString();
        r2.m1867b(r3, r4, r0);
        r0 = r8.f3209e;
        r2 = new com.vungle.publisher.tz;
        r2.<init>();
        r0.m2361a(r2);
        r0 = r1;
        goto L_0x0061;
    L_0x0085:
        r0 = com.vungle.publisher.ti.C1887a.m2500a(r3);	 Catch:{ Exception -> 0x004c }
        r2 = "VungleAd";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004c }
        r5 = "received MRAID event from js: ";
        r3.<init>(r5);	 Catch:{ Exception -> 0x004c }
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x004c }
        r3 = r3.toString();	 Catch:{ Exception -> 0x004c }
        r5 = 3;
        r6 = 0;
        com.vungle.publisher.so.m2470a(r5, r2, r3, r6);	 Catch:{ Exception -> 0x004c }
        r2 = com.vungle.publisher.su.C18752.f3202a;	 Catch:{ Exception -> 0x004c }
        r3 = r0.ordinal();	 Catch:{ Exception -> 0x004c }
        r2 = r2[r3];	 Catch:{ Exception -> 0x004c }
        switch(r2) {
            case 1: goto L_0x00c9;
            case 2: goto L_0x00d4;
            case 3: goto L_0x0135;
            case 4: goto L_0x014d;
            case 5: goto L_0x0165;
            case 6: goto L_0x019d;
            case 7: goto L_0x01b1;
            case 8: goto L_0x01d5;
            case 9: goto L_0x01e5;
            case 10: goto L_0x01e5;
            case 11: goto L_0x01fd;
            case 12: goto L_0x0211;
            case 13: goto L_0x00c0;
            case 14: goto L_0x021d;
            default: goto L_0x00aa;
        };	 Catch:{ Exception -> 0x004c }
    L_0x00aa:
        r2 = "VungleAd";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004c }
        r4 = "Unknown MRAID Javascript command: ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x004c }
        r0 = r3.append(r0);	 Catch:{ Exception -> 0x004c }
        r0 = r0.toString();	 Catch:{ Exception -> 0x004c }
        r3 = 5;
        r4 = 0;
        com.vungle.publisher.so.m2470a(r3, r2, r0, r4);	 Catch:{ Exception -> 0x004c }
    L_0x00c0:
        r0 = "notifyCommandComplete";
        r2 = 0;
        r2 = new java.lang.String[r2];	 Catch:{ Exception -> 0x004c }
        com.vungle.publisher.sp.m2473a(r9, r0, r2);	 Catch:{ Exception -> 0x004c }
        goto L_0x0060;
    L_0x00c9:
        r0 = r8.f3209e;	 Catch:{ Exception -> 0x004c }
        r2 = new com.vungle.publisher.tv;	 Catch:{ Exception -> 0x004c }
        r2.<init>();	 Catch:{ Exception -> 0x004c }
        r0.m2361a(r2);	 Catch:{ Exception -> 0x004c }
        goto L_0x00c0;
    L_0x00d4:
        r0 = r8.f3215k;	 Catch:{ Exception -> 0x004c }
        if (r0 != 0) goto L_0x0060;
    L_0x00d8:
        r0 = r8.f3205a;	 Catch:{ JSONException -> 0x012a }
        r2 = "VungleAd";
        r3 = "inject tokens into js and notify ready";
        r4 = 3;
        r5 = 0;
        com.vungle.publisher.so.m2470a(r4, r2, r3, r5);	 Catch:{ JSONException -> 0x012a }
        r0 = r0.mo4355a();	 Catch:{ JSONException -> 0x012a }
        r2 = r0.length();	 Catch:{ JSONException -> 0x012a }
        if (r2 <= 0) goto L_0x0121;
    L_0x00ed:
        r0 = r0.toString();	 Catch:{ JSONException -> 0x012a }
        r2 = "VungleAd";
        r3 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x012a }
        r4 = "tokens: ";
        r3.<init>(r4);	 Catch:{ JSONException -> 0x012a }
        r3 = r3.append(r0);	 Catch:{ JSONException -> 0x012a }
        r3 = r3.toString();	 Catch:{ JSONException -> 0x012a }
        r4 = 2;
        r5 = 0;
        com.vungle.publisher.so.m2470a(r4, r2, r3, r5);	 Catch:{ JSONException -> 0x012a }
        r2 = "notifyReadyEvent";
        r3 = 1;
        r3 = new java.lang.String[r3];	 Catch:{ JSONException -> 0x012a }
        r4 = 0;
        r3[r4] = r0;	 Catch:{ JSONException -> 0x012a }
        com.vungle.publisher.sp.m2473a(r9, r2, r3);	 Catch:{ JSONException -> 0x012a }
    L_0x0112:
        r0 = 1;
        r8.f3215k = r0;	 Catch:{ Exception -> 0x004c }
        r0 = r8.f3209e;	 Catch:{ Exception -> 0x004c }
        r2 = new com.vungle.publisher.uc;	 Catch:{ Exception -> 0x004c }
        r2.<init>();	 Catch:{ Exception -> 0x004c }
        r0.m2361a(r2);	 Catch:{ Exception -> 0x004c }
        goto L_0x0060;
    L_0x0121:
        r0 = "notifyReadyEvent";
        r2 = 0;
        r2 = new java.lang.String[r2];	 Catch:{ JSONException -> 0x012a }
        com.vungle.publisher.sp.m2473a(r9, r0, r2);	 Catch:{ JSONException -> 0x012a }
        goto L_0x0112;
    L_0x012a:
        r0 = move-exception;
        r2 = r8.f3208d;	 Catch:{ Exception -> 0x004c }
        r3 = "VungleAd";
        r4 = "failed to inject JSON tokens";
        r2.m1867b(r3, r4, r0);	 Catch:{ Exception -> 0x004c }
        goto L_0x0112;
    L_0x0135:
        r0 = "sdkCloseButton";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x004c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x004c }
        r0 = com.vungle.publisher.tb.C1880b.valueOf(r0);	 Catch:{ Exception -> 0x004c }
        r2 = r8.f3209e;	 Catch:{ Exception -> 0x004c }
        r3 = new com.vungle.publisher.uf;	 Catch:{ Exception -> 0x004c }
        r3.<init>(r0);	 Catch:{ Exception -> 0x004c }
        r2.m2361a(r3);	 Catch:{ Exception -> 0x004c }
        goto L_0x00c0;
    L_0x014d:
        r0 = "useCustomPrivacy";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x004c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x004c }
        r0 = com.vungle.publisher.agf.m1221b(r0);	 Catch:{ Exception -> 0x004c }
        r2 = r8.f3209e;	 Catch:{ Exception -> 0x004c }
        r3 = new com.vungle.publisher.ug;	 Catch:{ Exception -> 0x004c }
        r3.<init>(r0);	 Catch:{ Exception -> 0x004c }
        r2.m2361a(r3);	 Catch:{ Exception -> 0x004c }
        goto L_0x00c0;
    L_0x0165:
        r0 = "url";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x004c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x004c }
        r0 = android.net.Uri.parse(r0);	 Catch:{ Exception -> 0x004c }
        r2 = r8.m2482a(r0);	 Catch:{ Exception -> 0x004c }
        if (r2 != 0) goto L_0x00c0;
    L_0x0177:
        r2 = "about:blank";
        r9.loadUrl(r2);	 Catch:{ Exception -> 0x004c }
        r2 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;
        r9.setBackgroundColor(r2);	 Catch:{ Exception -> 0x004c }
        r2 = 0;
        r8.f3206b = r2;	 Catch:{ Exception -> 0x004c }
        r2 = 1;
        r8.f3207c = r2;	 Catch:{ Exception -> 0x004c }
        r0 = r0.toString();	 Catch:{ Exception -> 0x004c }
        r9.loadUrl(r0);	 Catch:{ Exception -> 0x004c }
        r9.clearHistory();	 Catch:{ Exception -> 0x004c }
        r0 = r8.f3209e;	 Catch:{ Exception -> 0x004c }
        r2 = new com.vungle.publisher.ub;	 Catch:{ Exception -> 0x004c }
        r2.<init>();	 Catch:{ Exception -> 0x004c }
        r0.m2361a(r2);	 Catch:{ Exception -> 0x004c }
        goto L_0x00c0;
    L_0x019d:
        r2 = r8.f3209e;	 Catch:{ Exception -> 0x004c }
        r3 = new com.vungle.publisher.av;	 Catch:{ Exception -> 0x004c }
        r0 = "url";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x004c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x004c }
        r3.<init>(r0);	 Catch:{ Exception -> 0x004c }
        r2.m2361a(r3);	 Catch:{ Exception -> 0x004c }
        goto L_0x00c0;
    L_0x01b1:
        r0 = "allowOrientationChange";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x004c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x004c }
        r2 = com.vungle.publisher.agf.m1221b(r0);	 Catch:{ Exception -> 0x004c }
        r0 = "forceOrientation";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x004c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x004c }
        r0 = com.vungle.publisher.agf.m1223d(r0);	 Catch:{ Exception -> 0x004c }
        r3 = r8.f3209e;	 Catch:{ Exception -> 0x004c }
        r4 = new com.vungle.publisher.ud;	 Catch:{ Exception -> 0x004c }
        r4.<init>(r0, r2);	 Catch:{ Exception -> 0x004c }
        r3.m2361a(r4);	 Catch:{ Exception -> 0x004c }
        goto L_0x00c0;
    L_0x01d5:
        r0 = r8.f3209e;	 Catch:{ Exception -> 0x004c }
        r2 = new com.vungle.publisher.ts;	 Catch:{ Exception -> 0x004c }
        r3 = m2480a(r4);	 Catch:{ Exception -> 0x004c }
        r2.<init>(r3);	 Catch:{ Exception -> 0x004c }
        r0.m2361a(r2);	 Catch:{ Exception -> 0x004c }
        goto L_0x00c0;
    L_0x01e5:
        r0 = "value";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x004c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x004c }
        r2 = r8.f3209e;	 Catch:{ Exception -> 0x004c }
        r3 = new com.vungle.publisher.tu;	 Catch:{ Exception -> 0x004c }
        r4 = m2480a(r4);	 Catch:{ Exception -> 0x004c }
        r3.<init>(r4, r0);	 Catch:{ Exception -> 0x004c }
        r2.m2361a(r3);	 Catch:{ Exception -> 0x004c }
        goto L_0x00c0;
    L_0x01fd:
        r0 = "code";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x004c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x004c }
        r2 = r8.f3209e;	 Catch:{ Exception -> 0x004c }
        r3 = new com.vungle.publisher.ty;	 Catch:{ Exception -> 0x004c }
        r3.<init>(r0);	 Catch:{ Exception -> 0x004c }
        r2.m2361a(r3);	 Catch:{ Exception -> 0x004c }
        goto L_0x00c0;
    L_0x0211:
        r0 = r8.f3209e;	 Catch:{ Exception -> 0x004c }
        r2 = new com.vungle.publisher.bd;	 Catch:{ Exception -> 0x004c }
        r2.<init>();	 Catch:{ Exception -> 0x004c }
        r0.m2361a(r2);	 Catch:{ Exception -> 0x004c }
        goto L_0x00c0;
    L_0x021d:
        r0 = "selector";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x023b }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x023b }
        r2 = "UTF-8";
        r0 = java.net.URLDecoder.decode(r0, r2);	 Catch:{ Exception -> 0x023b }
        r2 = r8.f3212h;	 Catch:{ Exception -> 0x023b }
        r3 = new com.vungle.publisher.su$1;	 Catch:{ Exception -> 0x023b }
        r3.<init>(r8, r9, r0);	 Catch:{ Exception -> 0x023b }
        r0 = r2.f1490a;	 Catch:{ Exception -> 0x023b }
        r6 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r0.postDelayed(r3, r6);	 Catch:{ Exception -> 0x023b }
        goto L_0x00c0;
    L_0x023b:
        r0 = move-exception;
        r2 = r0;
        r3 = r8.f3208d;	 Catch:{ Exception -> 0x004c }
        r5 = "VungleAd";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004c }
        r0 = "invalid mraid video selector: ";
        r6.<init>(r0);	 Catch:{ Exception -> 0x004c }
        r0 = "selector";
        r0 = r4.get(r0);	 Catch:{ Exception -> 0x004c }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x004c }
        r0 = r6.append(r0);	 Catch:{ Exception -> 0x004c }
        r0 = r0.toString();	 Catch:{ Exception -> 0x004c }
        r3.m1865a(r5, r0, r2);	 Catch:{ Exception -> 0x004c }
        r0 = r8.f3209e;	 Catch:{ Exception -> 0x004c }
        r2 = new com.vungle.publisher.tz;	 Catch:{ Exception -> 0x004c }
        r2.<init>();	 Catch:{ Exception -> 0x004c }
        r0.m2361a(r2);	 Catch:{ Exception -> 0x004c }
        goto L_0x00c0;
    L_0x0267:
        r0 = r8.m2482a(r2);
        goto L_0x0061;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.su.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }

    private boolean m2482a(Uri uri) {
        if (th.f3266a.contains(uri.getScheme())) {
            return false;
        }
        so.m2470a(3, "VungleAd", "navigating to external location: " + uri.toString(), null);
        this.f3209e.m2361a(new ua(uri));
        return true;
    }

    private static hy m2480a(Map<String, String> map) {
        return new hy((String) map.get(DataLayer.EVENT_KEY));
    }
}
