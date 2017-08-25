package com.vungle.publisher;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.heyzap.http.AsyncHttpClient;
import com.vungle.publisher.vf.C1894b;
import com.vungle.publisher.vg.C1896a;
import com.vungle.publisher.vl.C1897a;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: vungle */
public final class vv {
    @Inject
    vy f3479a;
    @Inject
    C1897a f3480b;
    @Inject
    C1896a f3481c;

    static {
        if (VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    @Inject
    vv() {
    }

    public final vl m2561a(vf vfVar) {
        String str;
        HttpURLConnection httpURLConnection = null;
        int i = -1;
        List arrayList = new ArrayList();
        try {
            C1894b a = vfVar.mo4348a();
            String str2 = vfVar.f788b;
            int i2 = 0;
            while (i2 <= 5) {
                so.m2470a(3, "VungleNetwork", a + " " + str2, null);
                httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setUseCaches(false);
                if (a != null) {
                    httpURLConnection.setRequestMethod(a.toString());
                }
                m2558a(httpURLConnection, vfVar);
                String str3 = vfVar.f790d;
                if (!TextUtils.isEmpty(str3)) {
                    Object obj;
                    so.m2470a(3, "VungleNetwork", "request body: " + str3, null);
                    byte[] bytes = str3.getBytes();
                    String str4 = AsyncHttpClient.ENCODING_GZIP;
                    String str5 = "Content-Encoding";
                    if (vfVar.f789c == null) {
                        obj = null;
                    } else {
                        obj = vfVar.f789c.getString(str5);
                    }
                    if (str4.equals(obj)) {
                        int length = bytes.length;
                        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        gZIPOutputStream.write(bytes);
                        gZIPOutputStream.close();
                        bytes = byteArrayOutputStream.toByteArray();
                        so.m2470a(2, "VungleNetwork", "gzipped request from " + length + " bytes down to " + bytes.length + " bytes", null);
                    }
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                    httpURLConnection.getOutputStream().write(bytes);
                }
                i = httpURLConnection.getResponseCode();
                if (m2560a(i2, i)) {
                    String headerField = httpURLConnection.getHeaderField("Location");
                    Long valueOf = httpURLConnection.getHeaderFieldDate("Date", -1) == -1 ? null : Long.valueOf(httpURLConnection.getHeaderFieldDate("Date", -1));
                    vg vgVar = (vg) this.f3481c.f3441a.get();
                    vgVar.f3443b = str2;
                    vgVar.f3444c = i;
                    vgVar.f3442a = headerField;
                    vgVar.f3445d = valueOf;
                    arrayList.add(vgVar);
                    if (m2559a(i)) {
                        so.m2470a(3, "VungleNetwork", m2557a(a, i2, i, httpURLConnection.getContentType(), vfVar.f788b, str2, null), null);
                        break;
                    }
                    so.m2470a(4, "VungleNetwork", m2557a(a, i2, i, httpURLConnection.getContentType(), vfVar.f788b, str2, headerField), null);
                    i2++;
                    str2 = headerField;
                } else if (m2559a(i)) {
                    so.m2470a(3, "VungleNetwork", m2557a(a, i2, i, httpURLConnection.getContentType(), vfVar.f788b, str2, null), null);
                } else {
                    so.m2470a(4, "VungleNetwork", m2557a(a, i2, i, httpURLConnection.getContentType(), vfVar.f788b, str2, null), null);
                }
            }
        } catch (Throwable e) {
            so.m2470a(5, "VungleNetwork", agb.m1208a(e), null);
            i = 601;
        } catch (Throwable e2) {
            so.m2470a(3, "VungleNetwork", agb.m1208a(e2), null);
            i = 602;
        } catch (Throwable e22) {
            so.m2470a(3, "VungleNetwork", agb.m1208a(e22), null);
            i = 603;
        } catch (Throwable e222) {
            so.m2470a(5, "VungleNetwork", agb.m1208a(e222), null);
            i = 600;
        }
        vl vlVar = (vl) this.f3480b.f3454a.get();
        vlVar.f3455a = httpURLConnection;
        vlVar.f3458d = arrayList;
        vlVar.f3456b = i;
        if (httpURLConnection == null) {
            str = null;
        } else {
            str = String.valueOf(httpURLConnection.getURL());
        }
        vlVar.f3457c = str;
        return vlVar;
    }

    private static void m2558a(HttpURLConnection httpURLConnection, vf vfVar) {
        Bundle bundle = vfVar.f789c;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                if (bundle.get(str) instanceof String[]) {
                    for (String str2 : bundle.getStringArray(str)) {
                        so.m2470a(2, "VungleNetwork", "request header: " + str + ": " + str2, null);
                        httpURLConnection.addRequestProperty(str, str2);
                    }
                } else {
                    String valueOf = String.valueOf(bundle.get(str));
                    so.m2470a(2, "VungleNetwork", "request header: " + str + ": " + valueOf, null);
                    httpURLConnection.addRequestProperty(str, valueOf);
                }
            }
        }
    }

    private static boolean m2560a(int i, int i2) {
        if (i <= 0) {
            boolean z;
            if (i2 == 301 || i2 == 302) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    private static boolean m2559a(int i) {
        return i == 200;
    }

    private static String m2557a(C1894b c1894b, int i, int i2, String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder("HTTP");
        boolean a = m2560a(i, i2);
        if (a) {
            stringBuilder.append(" redirect count ").append(i).append(',');
        }
        stringBuilder.append(" response code ").append(i2).append(", content-type ").append(str).append(" for ").append(c1894b).append(" to");
        if (i > 0) {
            stringBuilder.append(" original URL ").append(str2).append(',');
        }
        stringBuilder.append(" requested URL ").append(str3);
        if (a) {
            stringBuilder.append(", next URL ").append(str4);
        }
        return stringBuilder.toString();
    }
}
