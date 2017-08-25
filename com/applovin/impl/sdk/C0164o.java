package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinLogger;
import com.heyzap.http.AsyncHttpResponseHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

class C0164o {
    private final AppLovinSdkImpl f692a;
    private final AppLovinLogger f693b;

    C0164o(AppLovinSdkImpl appLovinSdkImpl) {
        this.f692a = appLovinSdkImpl;
        this.f693b = appLovinSdkImpl.getLogger();
    }

    private int m738a(Throwable th) {
        if (th instanceof UnknownHostException) {
            return AppLovinErrorCodes.NO_NETWORK;
        }
        if (th instanceof SocketTimeoutException) {
            return AppLovinErrorCodes.FETCH_AD_TIMEOUT;
        }
        if (!(th instanceof IOException)) {
            return th instanceof JSONException ? -104 : -1;
        } else {
            String message = th.getMessage();
            return (message == null || !message.toLowerCase(Locale.ENGLISH).contains("authentication challenge")) ? -100 : 401;
        }
    }

    private HttpURLConnection m739a(String str, String str2, int i) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(i < 0 ? ((Integer) this.f692a.m253a(cd.f576o)).intValue() : i);
        if (i < 0) {
            i = ((Integer) this.f692a.m253a(cd.f578q)).intValue();
        }
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    private static void m740a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }

    private void m741a(String str, int i, String str2, C0151p c0151p) {
        this.f693b.mo635d("ConnectionManager", i + " received from from \"" + str2 + "\": " + str);
        if (i < 200 || i >= 300) {
            this.f693b.mo636e("ConnectionManager", i + " error received from \"" + str2 + "\"");
            c0151p.mo622a(i);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (!(i == AppLovinErrorCodes.NO_FILL || str == null || str.length() <= 2)) {
            jSONObject = new JSONObject(str);
        }
        c0151p.mo623a(jSONObject, i);
    }

    private void m742a(String str, String str2, int i, long j) {
        this.f693b.mo638i("ConnectionManager", "Successful " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s" + " over " + C0165q.m750a(this.f692a) + " to \"" + str2 + "\"");
    }

    private void m743a(String str, String str2, int i, long j, Throwable th) {
        this.f693b.mo637e("ConnectionManager", "Failed " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s" + " over " + C0165q.m750a(this.f692a) + " to \"" + str2 + "\"", th);
    }

    private static void m744a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
            }
        }
    }

    void m745a(String str, int i, C0151p c0151p) {
        m748a(str, "GET", i, null, true, c0151p);
    }

    void m746a(String str, int i, JSONObject jSONObject, boolean z, C0151p c0151p) {
        m748a(str, "POST", i, jSONObject, z, c0151p);
    }

    void m747a(String str, int i, boolean z, C0151p c0151p) {
        m748a(str, "GET", i, null, z, c0151p);
    }

    void m748a(String str, String str2, int i, JSONObject jSONObject, boolean z, C0151p c0151p) {
        String str3;
        Throwable th;
        int a;
        Throwable th2;
        InputStream inputStream;
        if (str == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No method specified");
        } else if (c0151p == null) {
            throw new IllegalArgumentException("No callback specified");
        } else if (str.toLowerCase().startsWith("http")) {
            if (!((Boolean) this.f692a.m253a(cd.bf)).booleanValue() || str.contains("https://")) {
                str3 = str;
            } else {
                this.f692a.getLogger().mo641w("ConnectionManager", "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
                str3 = str.replace("http://", "https://");
            }
            long currentTimeMillis = System.currentTimeMillis();
            InputStream inputStream2 = null;
            HttpURLConnection a2;
            try {
                this.f693b.mo638i("ConnectionManager", "Sending " + str2 + " request to \"" + str3 + "\"...");
                a2 = m739a(str3, str2, i);
                if (jSONObject != null) {
                    try {
                        String jSONObject2 = jSONObject.toString();
                        this.f693b.mo635d("ConnectionManager", "Request to \"" + str3 + "\" is " + jSONObject2);
                        a2.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                        a2.setDoOutput(true);
                        a2.setFixedLengthStreamingMode(jSONObject2.getBytes(Charset.forName(AsyncHttpResponseHandler.DEFAULT_CHARSET)).length);
                        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(a2.getOutputStream(), "UTF8"));
                        printWriter.print(jSONObject2);
                        printWriter.close();
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            a = m738a(th);
                            m743a(str2, str3, a, currentTimeMillis, th);
                            c0151p.mo622a(a);
                            C0164o.m740a(inputStream2);
                            C0164o.m744a(a2);
                        } catch (Throwable th4) {
                            th2 = th4;
                            C0164o.m740a(inputStream2);
                            C0164o.m744a(a2);
                            throw th2;
                        }
                    }
                }
                try {
                    a = a2.getResponseCode();
                    if (a > 0) {
                        m742a(str2, str3, a, currentTimeMillis);
                        if (z) {
                            inputStream = a2.getInputStream();
                            try {
                                m741a(C0165q.m751a(inputStream), a2.getResponseCode(), str3, c0151p);
                            } catch (MalformedURLException e) {
                                if (z) {
                                    try {
                                        c0151p.mo622a(-901);
                                        C0164o.m740a(inputStream);
                                        C0164o.m744a(a2);
                                    } catch (Throwable th5) {
                                        inputStream2 = inputStream;
                                        th2 = th5;
                                        C0164o.m740a(inputStream2);
                                        C0164o.m744a(a2);
                                        throw th2;
                                    }
                                }
                                c0151p.mo623a(new JSONObject(), -901);
                                C0164o.m740a(inputStream);
                                C0164o.m744a(a2);
                            }
                        }
                        c0151p.mo623a(new JSONObject(), a);
                        inputStream = null;
                    } else {
                        m743a(str2, str3, a, currentTimeMillis, null);
                        c0151p.mo622a(a);
                        inputStream = null;
                    }
                } catch (MalformedURLException e2) {
                    inputStream = null;
                    if (z) {
                        c0151p.mo622a(-901);
                        C0164o.m740a(inputStream);
                        C0164o.m744a(a2);
                    }
                    c0151p.mo623a(new JSONObject(), -901);
                    C0164o.m740a(inputStream);
                    C0164o.m744a(a2);
                }
                C0164o.m740a(inputStream);
                C0164o.m744a(a2);
            } catch (Throwable th52) {
                a2 = null;
                th2 = th52;
                C0164o.m740a(inputStream2);
                C0164o.m744a(a2);
                throw th2;
            }
        } else {
            this.f693b.userError("ConnectionManager", "Requested postback submission to non HTTP endpoint " + str + "; skipping...");
            c0151p.mo622a(AppLovinErrorCodes.INVALID_URL);
        }
    }

    void m749a(String str, JSONObject jSONObject, C0151p c0151p) {
        m748a(str, "POST", -1, jSONObject, true, c0151p);
    }
}
