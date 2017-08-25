package com.vungle.publisher;

import android.webkit.WebView;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class mq extends my {
    @Inject
    qh f2580a;
    @Inject
    mt f2581b;

    public final void onReceivedError(WebView webView, int code, String desc, String str) {
        so.m2470a(6, "VungleAd", "failed to load web view: code " + code + ", " + desc, null);
        this.f2580a.m2361a(new bo());
    }

    public final void onPageFinished(WebView webView, String url) {
        so.m2470a(2, "VungleAd", "webview finished loading. appending config string", null);
        if (!url.toLowerCase(Locale.US).startsWith("javascript:")) {
            StringBuilder stringBuilder = new StringBuilder("javascript:function actionClicked(m,p){ var q = prompt('vungle:'+JSON.stringify({method:m,params:(p?p:null)}));if(q&&typeof q === 'string'){return JSON.parse(q).result;}};function noTapHighlight(){var l=document.getElementsByTagName('*');for(var i=0; i<l.length; i++){l[i].style.webkitTapHighlightColor='rgba(0,0,0,0)';}};noTapHighlight();");
            try {
                stringBuilder.append("if (typeof vungleInit == 'function') {vungleInit($webviewConfig$);};".replace("$webviewConfig$", this.f2581b.m857d()));
            } catch (Throwable e) {
                so.m2471a("VungleAd", "webview failed to load config object", e);
            }
            String stringBuilder2 = stringBuilder.toString();
            so.m2470a(2, "VungleAd", "webview client injecting javascript: " + stringBuilder2, null);
            webView.loadUrl(stringBuilder2);
            super.onPageFinished(webView, url);
        }
    }
}
