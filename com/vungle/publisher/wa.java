package com.vungle.publisher;

import com.vungle.publisher.gx.C1778a;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;

/* compiled from: vungle */
public final class wa {
    private static final Pattern f3492b = Pattern.compile("\\bcharset=([\\w\\-]+)\\b");
    @Inject
    protected C1778a f3493a;

    public final String m2566a(HttpURLConnection httpURLConnection) throws IOException {
        Reader inputStreamReader;
        Throwable th;
        Object obj = 1;
        Reader reader = null;
        try {
            String group;
            InputStream inputStream;
            StringBuilder stringBuilder;
            char[] cArr;
            int read;
            int responseCode = httpURLConnection.getResponseCode();
            CharSequence contentType = httpURLConnection.getContentType();
            if (contentType != null) {
                Matcher matcher = f3492b.matcher(contentType);
                if (matcher.find()) {
                    group = matcher.group(1);
                    so.m2470a(2, "VungleNetwork", "response character set: " + group, null);
                    if (responseCode / 100 > 3) {
                        obj = null;
                    }
                    inputStream = obj == null ? httpURLConnection.getInputStream() : httpURLConnection.getErrorStream();
                    if (agf.m1224e(group)) {
                        group = "ISO-8859-1";
                    }
                    inputStreamReader = new InputStreamReader(inputStream, group);
                    stringBuilder = new StringBuilder();
                    cArr = new char[8192];
                    while (true) {
                        read = inputStreamReader.read(cArr);
                        if (read > 0) {
                            break;
                        }
                        stringBuilder.append(cArr, 0, read);
                    }
                    group = stringBuilder.toString();
                    so.m2470a(3, "VungleNetwork", "response body: " + group, null);
                    try {
                        inputStreamReader.close();
                    } catch (Throwable e) {
                        this.f3493a.m1867b("VungleNetwork", "error closing input stream " + httpURLConnection.getURL(), e);
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    return group;
                }
            }
            group = null;
            so.m2470a(2, "VungleNetwork", "response character set: " + group, null);
            if (responseCode / 100 > 3) {
                obj = null;
            }
            if (obj == null) {
            }
            if (agf.m1224e(group)) {
                group = "ISO-8859-1";
            }
            inputStreamReader = new InputStreamReader(inputStream, group);
            try {
                stringBuilder = new StringBuilder();
                cArr = new char[8192];
                while (true) {
                    read = inputStreamReader.read(cArr);
                    if (read > 0) {
                        break;
                    }
                    stringBuilder.append(cArr, 0, read);
                }
                group = stringBuilder.toString();
                so.m2470a(3, "VungleNetwork", "response body: " + group, null);
                inputStreamReader.close();
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return group;
            } catch (Throwable th2) {
                th = th2;
                reader = inputStreamReader;
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (Throwable e2) {
                        this.f3493a.m1867b("VungleNetwork", "error closing input stream " + httpURLConnection.getURL(), e2);
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (reader != null) {
                reader.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }
}
