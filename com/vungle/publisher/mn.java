package com.vungle.publisher;

import android.webkit.WebChromeClient;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class mn extends WebChromeClient {
    @Inject
    qh f2575a;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onJsPrompt(android.webkit.WebView r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, android.webkit.JsPromptResult r13) {
        /*
        r8 = this;
        r7 = 5;
        r2 = 0;
        r0 = "VungleAd";
        r1 = new java.lang.StringBuilder;
        r3 = "js prompt: ";
        r1.<init>(r3);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r3 = 2;
        com.vungle.publisher.so.m2470a(r3, r0, r1, r2);
        r0 = "vungle:";
        r3 = r11.startsWith(r0);
        if (r3 == 0) goto L_0x0049;
    L_0x001f:
        r0 = 7;
        r1 = r11.substring(r0);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x00b0, Exception -> 0x00a8 }
        r0 = new org.json.JSONObject;	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r0.<init>(r1);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r4 = "method";
        r4 = r0.getString(r4);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r5 = "params";
        r0.getString(r5);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r0 = "close";
        r0 = r0.equalsIgnoreCase(r4);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        if (r0 == 0) goto L_0x004a;
    L_0x003c:
        r0 = r8.f2575a;	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r4 = new com.vungle.publisher.at;	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r4.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r0.m2361a(r4);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
    L_0x0046:
        r13.cancel();
    L_0x0049:
        return r3;
    L_0x004a:
        r0 = "download";
        r0 = r0.equalsIgnoreCase(r4);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        if (r0 == 0) goto L_0x0068;
    L_0x0052:
        r0 = r8.f2575a;	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r4 = new com.vungle.publisher.ai;	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r5 = com.vungle.publisher.jw.C1798a.postroll_click;	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r4.<init>(r5);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r0.m2361a(r4);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        goto L_0x0046;
    L_0x005f:
        r0 = move-exception;
        r0 = "VungleAd";
        r1 = "no javascript method call";
        com.vungle.publisher.so.m2470a(r7, r0, r1, r2);
        goto L_0x0046;
    L_0x0068:
        r0 = "privacy";
        r0 = r0.equalsIgnoreCase(r4);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        if (r0 == 0) goto L_0x0091;
    L_0x0070:
        r0 = r8.f2575a;	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r4 = new com.vungle.publisher.av;	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r4.<init>();	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r0.m2361a(r4);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        goto L_0x0046;
    L_0x007b:
        r0 = move-exception;
    L_0x007c:
        r2 = "VungleAd";
        r4 = new java.lang.StringBuilder;
        r5 = "invalid json ";
        r4.<init>(r5);
        r1 = r4.append(r1);
        r1 = r1.toString();
        com.vungle.publisher.so.m2470a(r7, r2, r1, r0);
        goto L_0x0046;
    L_0x0091:
        r0 = "VungleAd";
        r5 = new java.lang.StringBuilder;	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r6 = "unknown javascript method: ";
        r5.<init>(r6);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r4 = r5.append(r4);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r4 = r4.toString();	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        r5 = 5;
        r6 = 0;
        com.vungle.publisher.so.m2470a(r5, r0, r4, r6);	 Catch:{ IndexOutOfBoundsException -> 0x005f, JSONException -> 0x007b, Exception -> 0x00a8 }
        goto L_0x0046;
    L_0x00a8:
        r0 = move-exception;
        r1 = "VungleAd";
        r4 = 6;
        com.vungle.publisher.so.m2470a(r4, r1, r2, r0);
        goto L_0x0046;
    L_0x00b0:
        r0 = move-exception;
        r1 = r2;
        goto L_0x007c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.publisher.mn.onJsPrompt(android.webkit.WebView, java.lang.String, java.lang.String, java.lang.String, android.webkit.JsPromptResult):boolean");
    }
}
